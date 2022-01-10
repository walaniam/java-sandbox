package walaniam.stack;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class TwoExclusiveSetsTest {

    private final TwoExclusiveSets underTest = new TwoExclusiveSets();

    @Test
    void findUnique() {
        Tuple<Set<String>, Set<String>> input = GenerateUtils.randomSets(570_000, 30_000);
        Tuple<Set<String>, Set<String>> output = underTest.findUnique(input);
        assertThat(output.getLeft()).hasSize(600_000);
        assertThat(output.getRight()).hasSize(600_000);
    }
}