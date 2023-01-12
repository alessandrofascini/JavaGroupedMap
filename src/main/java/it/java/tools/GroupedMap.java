package it.java.tools;

import java.util.*;
import java.util.function.Function;

public class GroupedMap<K, V> {
    private final Function<V, K> defaultKeyMapper;
    private final Map<K, V> data = new HashMap<>();
    public GroupedMap(Function<V, K> keyMapper) {
        this.defaultKeyMapper = keyMapper;
    }

    public V add(K key, V value) {
        this.data.putIfAbsent(key, new ArrayList<>());
        Collection<V> values = this.data.get(key);
        values.add(value);
        return values;
    }

    public V add(V value) {
        K key = this.defaultKeyMapper.apply(value);
        return this.add(key, value);
    }

    public V add(V value, Function<V, K> customMapper) {
        if(Objects.isNull(customMapper)) {
            return this.add(value);
        }
        K key = customMapper.apply(value);
        return this.add(key, value);
    }

    public V get(K key) {
        return this.data.get(key);
    }

    public boolean containsKey(K key) {
        return this.data.containsKey(key);
    }

    public Set<K> keySet() {
        return this.data.keySet();
    }
}
