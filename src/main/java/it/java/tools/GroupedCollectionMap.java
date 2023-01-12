package it.java.tools;

import java.util.Collection;
import java.util.function.Function;

public class GroupedCollectionMap<K, V>  {
    public GroupedCollectionMap(Function<Collection<V>, K> keyMapper) {
        super(keyMapper);
    }
}
