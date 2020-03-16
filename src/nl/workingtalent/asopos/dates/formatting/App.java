package nl.workingtalent.asopos.dates.formatting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();


        System.out.println(now);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;

        System.out.println(now.format(formatter));

        formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");

        System.out.println(now.format(formatter));

        formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm:ss a");

        System.out.println(now.format(formatter));

        formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");

        System.out.println(now.format(formatter));

        formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY E HH:mm:ss");

        System.out.println(now.format(formatter));









    }
}
