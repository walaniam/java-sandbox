package walaniam.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.IntStream;

public class TowerBreakers {

    public static int towerBreakers(int n, int m) {
        if (m == 1) {
            return 2;
        }
        return n % 2 == 0 ? 2 : 1;
    }

    public static void main(String[] args) throws IOException {
//        assertThat(towerBreakers(2, 6)).isEqualTo(2);
//        assertThat(towerBreakers(601251, 142899)).isEqualTo(1);
//        assertThat(towerBreakers(926797, 842282)).isEqualTo(1);

        String testcases = """
90
100000 1
100001 1
56389 75377
864918 691871
813085 534467
999943 750080
996862 913372
555557 585282
769161 726285
944979 757252
849839 377936
247404 241140
450646 205092
129189 251500
954266 274794
606312 207275
228695 878419
671852 757170
618268 46908
358244 268734
113584 22190
671725 498278
520425 476318
772493 831559
520281 307847
852374 816570
552032 968192
561065 88429
876852 791997
403574 590089
134046 480155
28790 420631
755308 784846
620450 639506
704239 805227
213013 903355
136403 617403
14548 980684
350667 608225
590051 636788
392333 554941
437574 91023
904363 726561
348334 547570
514106 451013
783830 910677
396633 298027
622227 523721
862558 697800
949735 796652
147107 459451
926797 842282
492228 769091
258303 66251
459240 45872
980254 620946
492730 347492
328826 209178
633544 579781
240200 341641
75881 537385
128909 460223
128075 584898
151937 400391
138859 697825
641020 180108
181922 696659
345746 411754
896991 874515
474069 515353
667709 973330
172359 602071
192333 223900
40878 821976
168974 345161
278654 347698
177051 31812
88723 548839
120664 534544
460883 356072
206381 894419
364352 128778
503531 330174
690551 321656
39321 92312
799591 481254
628042 687940
81778 511773
873776 157014
921080 377371                
                """;

        BufferedReader bufferedReader = new BufferedReader(new StringReader(testcases));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = towerBreakers(n, m);

//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();

    }
}
