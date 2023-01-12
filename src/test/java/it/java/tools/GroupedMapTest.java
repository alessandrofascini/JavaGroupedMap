package it.java.tools;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GroupedMapTest {
    @Test
    public void instantiation() {
        GroupedMap<LocalDate, ItemTest> map = new GroupedMap<>(it -> it.getCreationDate());
    }

    @Test
    public void addingElements() {
        GroupedMap<LocalDate, ItemTest> map = new GroupedMap<>(it -> it.getCreationDate());

        ItemTest item = new ItemTest();
        item.setCreationDate(LocalDate.of(2022, 1, 1));
        item.setOrigin("my pc");
        item.setName("item#1");
        System.out.println(item);

        map.add(item);
        LocalDate key = map.getKeyByMapper(item);

        assertTrue(map.get(key).equals(item));
    }

    @Test
    public void replaceElement() {
        GroupedMap<LocalDate, ItemTest> map = new GroupedMap<>(it -> it.getCreationDate());

        ItemTest item = new ItemTest();
        item.setCreationDate(LocalDate.of(2022, 1, 1));

        item.setOrigin("my pc");
        item.setName("item#1");
        System.out.println(item);

        LocalDate key = LocalDate.now();

        map.add(key, item);

        assertTrue(map.get(key).equals(item));
    }
}
