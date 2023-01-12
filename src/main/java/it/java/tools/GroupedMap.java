package it.java.tools;

import java.util.*;
import java.util.function.Function;

public class GroupedMap<K, V> implements GroupedMapInterface<K, V> {
    private final Function<V, K> defaultKeyMapper;
    private final Map<K, V> kvMap = new HashMap<>();
    public GroupedMap(Function<V, K> keyMapper) {
        this.defaultKeyMapper = keyMapper;
    }

    @Override
    public boolean add(K key, V value) {
        this.kvMap.put(key, value);
        return true;
    }

    @Override
    public boolean add(V value) {
        K key = this.getKeyByMapper(value);
        return this.add(key, value);
    }

    @Override
    public boolean add(V value, Function<V, K> customMapper) {
        if(Objects.isNull(customMapper)) {
            return this.add(value);
        }
        K key = customMapper.apply(value);
        return this.add(key, value);
    }

    @Override
    public V get(K key) {
        return this.kvMap.get(key);
    }

    @Override
    public boolean containsKey(K key) {
        return this.kvMap.containsKey(key);
    }

    @Override
    public Set<K> keySet() {
        return this.kvMap.keySet();
    }

    @Override
    public K getKeyByMapper(V value) {
        return this.defaultKeyMapper.apply(value);
    }
}
