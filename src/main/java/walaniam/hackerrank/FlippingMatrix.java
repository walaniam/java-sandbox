package walaniam.hackerrank;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FlippingMatrix {

    public static int flippingMatrix(List<List<Integer>> matrix) {

        List<Integer> sums = new ArrayList<>();

        // rows
        for (int i = 0; i < matrix.size(); i++) {

            // columns
            for (int j = 0; j < matrix.size(); j++) {
                System.out.println("row=" + i + ", column=" + j);
                collectSum(matrix, sums);
                // reverse column
                reverseColumn(matrix, j);
                collectSum(matrix, sums);
            }

            // reverse row
            Collections.reverse(matrix.get(i));

            for (int j = 0; j < matrix.size(); j++) {
                System.out.println("row=" + i + ", column=" + j);
                collectSum(matrix, sums);
                // reverse column
                reverseColumn(matrix, j);
                collectSum(matrix, sums);
            }
        }

        System.out.println("Sums size: " + sums.size());

        return sums.stream().max(Integer::compareTo).orElseThrow();
    }



    private static void reverseColumn(List<List<Integer>> matrix, int j) {
        int x = 0;
        int y = matrix.size() - 1;
        while (x < y) {
            int tmp1 = matrix.get(x).get(j);
            int tmp2 = matrix.get(y).get(j);
            matrix.get(x).set(j, tmp2);
            matrix.get(y).set(j, tmp1);
            x++;
            y--;
        }
    }

    private static void collectSum(List<List<Integer>> matrix, Collection<Integer> sums) {
        printMatrix(matrix);
        int sum = topLeftSumOf(matrix);
        System.out.println(sum);
        sums.add(sum);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        matrix.stream().forEach(it -> System.out.println(it));
    }

    private static int topLeftSumOf(List<List<Integer>> matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.size() / 2; i++) {
            for (int j = 0; j < matrix.size() / 2; j++) {
                sum += matrix.get(i).get(j);
            }
        }
        return sum;
    }

    private static List<Integer> zeroArrayOfSize(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(0);
        }
        return result;
    }

    private static List<List<Integer>> columnsToRows(List<List<Integer>> matrix) {
        List<List<Integer>> reversed = new ArrayList<>();
        matrix.forEach(it -> reversed.add(zeroArrayOfSize(matrix.size())));

        System.out.println(reversed);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                reversed.get(i).set(j, matrix.get(j).get(i));
            }
        }

        return reversed;
    }

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(112, 42, 83, 119)));
        matrix.add(new ArrayList<>(Arrays.asList(56, 125, 56, 49)));
        matrix.add(new ArrayList<>(Arrays.asList(15, 78, 101, 43)));
        matrix.add(new ArrayList<>(Arrays.asList(62, 98, 114, 108)));

        int sum = flippingMatrix(matrix);

        assertThat(sum).isEqualTo(414);
    }
}
