package walaniam.stack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Tuple<T, V> {
    private final T left;
    private final V right;
}
