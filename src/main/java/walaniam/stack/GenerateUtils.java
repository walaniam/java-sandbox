package walaniam.stack;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerateUtils {

    public static Tuple<Set<String>, Set<String>> randomSets(int commonCount, int uniqueCount) {

        Set<String> left = new HashSet<>(commonCount + uniqueCount);
        Set<String> right = new HashSet<>(commonCount + uniqueCount);

        IntStream.range(0, commonCount).forEach(value -> {
            String random = UUID.randomUUID().toString();
            left.add(random);
            right.add(random);
        });

        IntStream.range(0, uniqueCount).forEach(value -> {
            String random = UUID.randomUUID().toString();
            left.add("l_" + random);
            right.add("r_" + random);
        });

        return new Tuple<>(left, right);
    }
}
