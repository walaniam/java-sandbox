package walaniam.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SockMerchant {

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, List<Integer>> grouped = ar.stream()
                .collect(Collectors.groupingBy(Function.identity()));

        return grouped.values().stream()
                .map(list -> list.size() / 2)
                .reduce((a, b) -> a + b)
                .orElse(0);
    }

    public static void main(String[] args) {

        List<Integer> colors = Arrays.asList(1, 2, 1, 2, 1, 3, 2);

        System.out.println(sockMerchant(7, colors));

    }
}
