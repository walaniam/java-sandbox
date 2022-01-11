package walaniam.stack;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoExclusiveSetsTest {

    private final TwoExclusiveSets underTest = new TwoExclusiveSets();

    private static final int UNIQUE_COUNT = 30_000;

    @Test
    void findUnique() {

        Tuple<Set<String>, Set<String>> input = GenerateUtils.randomSets(570_000, UNIQUE_COUNT);

        List<Duration> durations = IntStream.range(0, 100)
                .mapToObj(index -> findAndAssert(input))
                .collect(Collectors.toList());

        OptionalDouble average = durations.stream().mapToLong(Duration::toMillis).average();
        System.out.println(average);
    }

    private Duration findAndAssert(Tuple<Set<String>, Set<String>> input) {

        Stopwatch findElapsedTime = Stopwatch.createStarted();
        Tuple<Set<String>, Set<String>> output = underTest.findUnique(input);
        Duration elapsed = findElapsedTime.stop().elapsed();

        System.out.println(elapsed.toMillis() + "ms");

        assertThat(output.getLeft()).hasSize(UNIQUE_COUNT);
        assertThat(output.getLeft().stream().filter(it -> it.startsWith("l_")).count()).isEqualTo(UNIQUE_COUNT);

        assertThat(output.getRight()).hasSize(UNIQUE_COUNT);
        assertThat(output.getRight().stream().filter(it -> it.startsWith("r_")).count()).isEqualTo(UNIQUE_COUNT);

        return elapsed;
    }
}