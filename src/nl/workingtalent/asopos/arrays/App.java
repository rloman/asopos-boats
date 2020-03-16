package nl.workingtalent.asopos.arrays;

public class App {

    public static void main(String[] args) {

        int[] numbers = new int[3];


        for(int element: numbers) {
            System.out.println(element);
        }

        numbers[1] = 5;

        // enhanced for: betekent dat de computer enhanced is.
        // dus jij hoeft niet veel te doen.
        for(int element: numbers) {
            System.out.println(element);
        }

        // basic for: betekent dat de computer basic is.
        // dus jij moet veel doen
        for(int i = 0;i<numbers.length;i++) {
            System.out.println("Op plek "+(i+1)+" zit waarde: "+numbers[i]);
        }


        int[][] multiNumbers = new int[3][3];

        multiNumbers[1][2] = 15;

        int [][][] kube = new int[3][3][3];



        //syntactis sugar
        int[] numbersAlt = new int[]{3,8,21};

        // nog makkelijker
        int[] numbersAltTwo = {3, 9, 43};

        System.out.println(numbersAltTwo);



    }
}
