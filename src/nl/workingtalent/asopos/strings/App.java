package nl.workingtalent.asopos.strings;

import nl.workingtalent.asopos.Assert;

public class App {

    public static void main(String[] args) {
        String firstName = "Lisa";
        String name = "Lisa";

        // behalve als ik new String(...) doe

        String otherReference = new String("Lisa");


        Assert.require(name == firstName); // == eigenlijk niet gebruiken om Objecten te vergelijken.

        Assert.require(name != otherReference);


        // bad practice
        {
            String label = "My name";

            for(int i = 0;i<10;i++) {
                label += i;
            }
        }


        // good practice
        {

            StringBuilder stringBuilder = new StringBuilder("My name");

            for(int i = 0;i<10;i++) {
                stringBuilder.append(i);
            }
            String label = stringBuilder.toString();
            System.out.println(label);


            // what happens if we print the StringBuilder?
            System.out.println(stringBuilder);

            StringBuffer buffer= new StringBuffer("MyName");
            buffer.append(3);
        }


        String myName = "Raymond";

        System.out.println(myName.indexOf("mond"));

        Assert.require(myName.indexOf("mond") == 3 );

        String ay = myName.substring(3);
        Assert.require(ay.equals("mond"));

        String ond = myName.substring(4, 7);
        System.out.println(ond);

//        System.out.println(myName.substring(4,3)); // vout

        myName = "         Deze fiets fietst lekker !!!!   ";

        myName.trim();

        System.out.println(myName);


        myName = myName.trim();

        System.out.println(myName);

        myName = myName.replace("fiets", "auto");

        System.out.println(myName);

        String result = "Sunday ".replace('u', 'Z').trim().concat("M n");
        System.out.println(result);

        String[] split = result.split(" ");

        String uppered = convert("raymond loman");

        System.out.println(uppered);

        String fox = "The quick brown 3 fox jumps over 4 the lazy dog";


        for(String word: fox.split("\\d")){
            System.out.println(word);
        }

    }

    public static String convert(String fullName) {

        String result = fullName;

        result = result.trim();

        result = result.replaceFirst("r", "R");

        result = result.replaceAll("l", "L");

        StringBuilder b = new StringBuilder(result);
        b.replace(0,1, result.substring(0,1).toUpperCase());

        int indexOfSpace = result.indexOf(" ");


        b.replace(indexOfSpace, indexOfSpace+1, b.substring(indexOfSpace, indexOfSpace+1));



        System.out.println(b);

        return b.toString();
    }
}
