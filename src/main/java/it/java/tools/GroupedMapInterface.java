package it.java.tools;

import java.util.Set;
import java.util.function.Function;

public interface GroupedMapInterface<K, V> {
    boolean add(K key, V value);

    boolean add(V value);

    boolean add(V value, Function<V, K> customMapper);

    V get(K key);

    boolean containsKey(K key);

    Set<K> keySet();
}
