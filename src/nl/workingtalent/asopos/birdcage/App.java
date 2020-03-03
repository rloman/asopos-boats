package nl.workingtalent.asopos.birdcage;

public class App {

    public static void main(String[] args) {
        BirdCage cage = new BirdCage();

        Bird merel = new Bird();
        Bird wielewaal = new Bird();
        Bird vink = new Bird();

        merel.setName("Merel");
        wielewaal.setName("Wielewaal");
        vink.setName("Vink");

        cage.add(merel);
        cage.add(wielewaal);
        cage.add(vink);

        cage.print();

        String label = cage.label();

        System.out.println("Now the label =>");

        System.out.println(label);
    }


}
