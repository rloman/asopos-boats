package nl.workingtalent.asopos.equality;

import nl.workingtalent.asopos.Assert;
import nl.workingtalent.asopos.Dog;

public class App {

    public static void main(String[] args) {

        int age = 51;
        int michielAge = 27;

        if(age == michielAge) {
            System.out.println("Ze zijn even oud");
        }
        else {
            System.out.println("Ze zijn NIET even oud");
        }

        Dog d1 = new Dog("Wodan");

        Dog d2 = new Dog("Wodan");

        Assert.require(d1 != d2); // want ze zijn gevuld met een ander adres / leash dus natuurlijk niet dezelfde


        Assert.require(d1.equals(d2));




    }
}
