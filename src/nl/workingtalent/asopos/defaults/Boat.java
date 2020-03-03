package nl.workingtalent.asopos.defaults;

public class Boat {

    private int age;

    private Paal paal;

    private boolean available;

    public void print() {
        System.out.println(this.age);
        System.out.println(this.paal);
        System.out.println(this.available);
    }
}

class Paal {

}