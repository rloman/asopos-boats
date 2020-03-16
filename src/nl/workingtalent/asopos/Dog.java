package nl.workingtalent.asopos;

public class Dog {

    private final String name;

    private int age;

    public Dog() {
        super();
        this.name = "onbekend";
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        return name.equals(dog.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
