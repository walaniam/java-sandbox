package walaniam.hackerrank;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubarrayDivision {

    public static void main(String[] args) {
        int solutions = birthday(Arrays.asList(2, 2, 1, 3, 2), 4, 2);
        System.out.println(solutions);
        assertThat(solutions).isEqualTo(2);
    }

    public static int birthday(List<Integer> s, int d, int m) {

        int start = 0;
        int result = 0;
        int sum = 0;

        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
            if (i - start + 1 == m) {
                if (sum == d) {
                    result++;
                }

                sum -= s.get(start);
                start++;
            }
        }
        return result;
    }


    private static long factorialOf(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

}
