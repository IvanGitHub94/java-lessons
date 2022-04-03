package ru.itmo.lessons.course1;

public enum Zones {
    GUM(0), POOL(0), GROUPS(0);
    private int people;

    Zones(int people) {
        setPeople(people);
    }

    public void setPeople(int people) {
        if (people < 0 || people > 20) {
            throw new IllegalArgumentException("Значение не может быть отрицательным или больше 20.");
        }
        this.people = people;
    }

    public void addPeople () {
        if (!(this.getPeople() < 20)) {
            throw new IllegalArgumentException("В этой зоне больше нет места.");
        }
        else { setPeople(this.getPeople() + 1); }
    }

    public int getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return name() +
                " people=" + people +
                '}';
    }
}
