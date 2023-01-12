package it.java.tools;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;

public class GroupedArrayListMap<K, V> {
    private final Function<V, K> defaultKeyMapper;

    private Map<K, List<V>> map = new HashMap<>();

    public GroupedArrayListMap(Function<V, K> keyMapper) {
            this.defaultKeyMapper = keyMapper;
    }

    public boolean add(K key, V value) {
        this.map.putIfAbsent(key, new ArrayList<>());
        List<V> list = this.map.get(key);
        list.add(value);
        return true;
    }

    public boolean add(V value) {
        K key = this.defaultKeyMapper.apply(value);
        return this.add(key, value);
    }

    public boolean add(V value, Function<V, K> customMapper) {
        K key = customMapper.apply(value);
        return this.add(key, value);
    }

    public List<V> get(K key) {
        return this.map.get(key);
    }

    public boolean containsKey(K key) {
        return this.map.containsKey(key);
    }

    public Set<K> keySet() {
        return this.map.keySet();
    }
}
