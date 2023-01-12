package it.java.tools;

import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public class GroupedCollectionMap<K, V> implements GroupedMapInterface<K, Collection<V>> {
    private GroupedMapInterface<K, Collection<V>> kvMap;
    private final Function<V, K> defaultKeyMapper;
    public GroupedCollectionMap(Function<V, K> keyMapper) {
        this.defaultKeyMapper = keyMapper;
    }

    @Override
    public Collection<V> add(K key, Collection<V> value) {
        return null;
    }

    @Override
    public Collection<V> add(Collection<V> value) {
        return null;
    }

    @Override
    public Collection<V> add(Collection<V> value, Function<Collection<V>, K> customMapper) {
        return null;
    }

    @Override
    public Collection<V> get(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }
}
