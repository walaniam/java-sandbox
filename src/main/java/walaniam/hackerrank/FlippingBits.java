package walaniam.hackerrank;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class FlippingBits {

    public static long flippingBits(long n) {

        char[] bits = new BigInteger(String.valueOf(n), 10).toString(2).toCharArray();
        System.out.println(Arrays.toString(bits));

        byte[] n32Reversed = new byte[32];
        int reversedIndex = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            n32Reversed[reversedIndex++] = Byte.parseByte(String.valueOf(bits[i]));
        }

        StringBuilder flipped = new StringBuilder();
        for (int i = n32Reversed.length - 1; i >= 0; i--) {
            System.out.print(n32Reversed[i]);
            if (n32Reversed[i] == 0) {
                flipped.append("1");
            } else {
                flipped.append("0");
            }
        }
        System.out.println();
        System.out.println(flipped);
        return Long.parseLong(new BigInteger(flipped.toString(), 2).toString(10));
    }

    public static void main(String[] args) {
        System.out.println(flippingBits(4));
    }
}
