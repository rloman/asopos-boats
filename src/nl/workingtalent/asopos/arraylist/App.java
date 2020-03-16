package nl.workingtalent.asopos.arraylist;

import nl.workingtalent.asopos.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String[] args) {
        {
            ArrayList names = new ArrayList();

            // 2004
            names.add("Piet");
            names.add(new Dog("Wodan"));
            names.add(3);

            String name = (String) names.get(0);
        }


        // dat kan niet langer zo.
        // generics to the rescue vanaf 2005
        {

            ArrayList<String> names = new ArrayList<>(); /// vanaf Java 7 de "diamond operator"
            names.add("Piet");
//            names.add(new Dog("Poedel")); // vout
            names.add("Raymie");
            names.add("Willem");

            String name = names.get(0);

            // 2004
            Iterator<String> iterator = names.iterator();
            while(iterator.hasNext()) {
                String nameLocal = iterator.next();
            }

            //Java 5+
            for(String nameLocal: names) {
                System.out.println(nameLocal);
            }

            ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0,1,1,2,3,5,8,13));


            // twintig meter verderop


            Integer[] elementenWeer = numbers.toArray(new Integer[numbers.size()]);

            ArrayList<Double> dubbels = new ArrayList<>();
            ArrayList<Character> lettertjes = new ArrayList<>();


            char c = 'a';
            char b = 'b';

            if(c == b) {

            }


        }
    }
}
