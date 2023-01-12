package it.java.tools;

import java.util.*;
import java.util.function.Function;

public class GroupedMap<K, V> {
    private final Function<V, K> defaultKeyMapper;
    private final Map<K, V> kvMap = new HashMap<>();
    public GroupedMap(Function<V, K> keyMapper) {
        this.defaultKeyMapper = keyMapper;
    }

    public V add(K key, V value) {
        this.kvMap.put(key, value);
        return this.kvMap.get(value);
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
        return this.kvMap.get(key);
    }

    public boolean containsKey(K key) {
        return this.kvMap.containsKey(key);
    }

    public Set<K> keySet() {
        return this.kvMap.keySet();
    }
}
