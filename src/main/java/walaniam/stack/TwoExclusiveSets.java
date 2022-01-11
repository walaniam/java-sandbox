package walaniam.stack;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Inspired by https://stackoverflow.com/questions/70580012/fast-way-to-get-different-lines-from-2-big-files-in-java
 */
public class TwoExclusiveSets {

    public Tuple<Set<String>, Set<String>> findUnique(Tuple<Set<String>, Set<String>> sets) {

        Set<String> inputLeft = sets.getLeft();
        Set<String> inputRight = sets.getRight();

        if (inputLeft.getClass() != inputRight.getClass()) {
            throw new IllegalArgumentException("Both sets should be the same class " + inputLeft + ", " + inputRight);
        }

        CompletableFuture<HashSet<String>> copyLeft = CompletableFuture.supplyAsync(() -> Sets.newHashSet(inputLeft));
        CompletableFuture<HashSet<String>> copyRight = CompletableFuture.supplyAsync(() -> Sets.newHashSet(inputRight));
        CompletableFuture.allOf(copyLeft, copyRight).join();

        Set<String> outputLeft = copyLeft.join();
        Set<String> outputRight = copyRight.join();

        Sets.SetView<String> intersection = inputLeft.size() < inputRight.size()
                ? Sets.intersection(inputLeft, inputRight)
                : Sets.intersection(inputRight, inputLeft);

        CompletableFuture<Void> removeLeft = CompletableFuture.runAsync(() -> outputLeft.removeAll(intersection));
        CompletableFuture<Void> removeRight = CompletableFuture.runAsync(() -> outputRight.removeAll(intersection));
        CompletableFuture.allOf(removeLeft, removeRight).join();

        return Tuple.of(outputLeft, outputRight);
    }
}
