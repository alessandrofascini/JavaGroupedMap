package it.java.tools;

import java.time.LocalDate;
import java.util.Objects;

public class ItemTest {
    private LocalDate creationDate;

    private String name;

    private String origin;

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemTest)) return false;
        ItemTest itemTest = (ItemTest) o;
        return Objects.equals(getCreationDate(), itemTest.getCreationDate()) && Objects.equals(getName(), itemTest.getName()) && Objects.equals(getOrigin(), itemTest.getOrigin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreationDate(), getName(), getOrigin());
    }

    @Override
    public String toString() {
        return "ItemTest{" +
                "creationDate=" + creationDate +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
