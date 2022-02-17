package walaniam.g;

/*
In Android, the executable files storing apps on devices are called "APKs". And each APK contains something called a "Manifest" which stores
which devices it is compatible
with. In this question, we are only going to think about the Android version requirements in the Manifest.

There are two values minSDKVersion and maxSDKVersion. Each of these is optional, and inclusive. By this I mean APKs don't have to specify
minSDKVersion or maxSDKVersion, but if they specify minSDKVersion = 3, then Android versions 3,4,5,etc all match, but 1 and 2 don't.

An app developer can upload multiple APKs for their app to the Google Play Store, each with a different manifest. For example, they might have
three APKs:

APK           Min SDK Version     Max SDK Version

APK A        4                               -

APK B        -                               16

APK C       7                               10


Now, on Google Play Store you can have more than one APK per App, and we need to decide which one to deliver. As part of this process we need to
split up the space of all phones to which APKs they match.

We want to divide the integer list of SDK versions into intervals that match the same APKs of a given App. So for this set we want to
produce:
(<=3), (4-6), (7-10), (11-16), (>=17)

This is because <=3 matches only, APK B, then (4-6) matches APK A & B, but not C, etc.

Question: Implement a method that generates the intervals that match the same APKs of a given App. Use whatever sensible data structure you want
to represent the input and the output.
*/

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Intervals {

    public static void main(String[] args) {

        List<Apk> apks = new ArrayList<>();
        apks.add(new Apk("A", new Interval(4, Integer.MAX_VALUE)));
        apks.add(new Apk("B", new Interval(Integer.MIN_VALUE, 16)));
        apks.add(new Apk("C", new Interval(7, 10)));

        App app = new App(apks);

        intervalsOf(app).forEach(System.out::println);
    }

    public static List<Interval> intervalsOf(App app) {

        Set<Integer> constraints = new TreeSet<>();
        for (Apk apk : app.apks) {
            Interval interval = apk.sdkInterval;
            constraints.add(interval.min);
            constraints.add(safeLowerConstraintOf(interval.min));
            constraints.add(interval.max);
            constraints.add(safeUpperConstraintOf(interval.max));
        }

        List<Interval> result = new ArrayList<>();
        Interval bucket = null;
        for (Integer c : constraints) {
            if (bucket == null) {
                bucket = new Interval();
                bucket.min = c;
            } else {
                bucket.max = c;
                result.add(bucket);
                bucket = null;
            }
        }

        return result;
    }

    private static int safeLowerConstraintOf(int i) {
        return i == Integer.MIN_VALUE ? i : i - 1;
    }

    private static int safeUpperConstraintOf(int i) {
        return i == Integer.MAX_VALUE ? i : i + 1;
    }

    @AllArgsConstructor
    private static class App {
        List<Apk> apks;
    }

    @AllArgsConstructor
    private static class Apk {
        String name;
        Interval sdkInterval;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    private static class Interval {
        Integer min;
        Integer max;
    }
}