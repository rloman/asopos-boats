package nl.workingtalent.asopos.strings.concat;

import nl.workingtalent.asopos.Dog;

public class App {

    public static void main(String[] args) {

        String aantal = 4 + 3 + " eieren";

        System.out.println(aantal);

        String anderAantal = "Ik heb momenteel " + (4 + 3) + " aantal eieren";

        System.out.println(anderAantal);

        Dog d = new Dog();


        String s = d + 3;


        boolean b = true + false;


    }
}
