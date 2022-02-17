package walaniam.hackerrank;

public class PageCount {

    public static int pageCount(int n, int p) {

        if (n == p || p == 1) {
            return 0;
        }

        if (n - 1 == p && p % 2 == 1) {
            return 1;
        }

        if (n - 1 == p && p % 2 == 0) {
            return 0;
        }

        int fromFront = (p - 1) / 2;
        if (p % 2 == 0) {
            fromFront++;
        }
        int fromBack = (n - p) / 2;
        return Math.min(fromFront, fromBack);
    }

    public static void main(String[] args) {
        System.out.println(pageCount(21235, 17));
        System.out.println(pageCount(6, 5));
        System.out.println(pageCount(5, 4));
        System.out.println(pageCount(5, 3));
        System.out.println(pageCount(4, 4));
        System.out.println(pageCount(95073, 17440));
    }
}
