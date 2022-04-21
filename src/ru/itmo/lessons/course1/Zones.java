package ru.itmo.lessons.course1;

public enum Zones {
    GUM, POOL, GROUPS;

    @Override
    public String toString() {
        return name();
    }
}
