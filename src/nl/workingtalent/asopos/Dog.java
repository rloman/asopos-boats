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
}
