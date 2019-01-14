package ua.bondarenkojek.homework.patterns.prototype;

public class Prototype implements Copyable<Prototype> {
    private int id;
    private String name;

    public Prototype(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Prototype copy() {
        return new Prototype(id, name);
    }
}
