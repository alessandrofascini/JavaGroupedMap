package it.java.tools;

import java.util.Set;
import java.util.function.Function;

public interface GroupedMapInterface<K, V> {
    V add(K key, V value);

    V add(V value);

    V add(V value, Function<V, K> customMapper);

    V get(K key);

    boolean containsKey(K key);

    Set<K> keySet();
}
