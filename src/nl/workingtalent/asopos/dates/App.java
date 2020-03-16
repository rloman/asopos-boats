package nl.workingtalent.asopos.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        // old school do not use it anymore
        Date old = new Date();

        // nice
        LocalDate today = LocalDate.now();


        System.out.println(today);

        // now
        LocalDateTime now = LocalDateTime.now();

        // prints the date in ISO8601 format.
        System.out.println(now);

        LocalDate birthDateMichiel = LocalDate.of(1992, 3, 24);

        System.out.println(birthDateMichiel);

        LocalDate verjaardag = LocalDate.parse("2020-02-18"); //is08601

        System.out.println(verjaardag);

        System.out.println(verjaardag.getDayOfWeek());

        System.out.println(verjaardag.minusYears(1).minusDays(1));
        System.out.println(verjaardag);

        LocalDateTime toen = verjaardag.atTime(15,0,0);

        Period periodeVanMichiel = Period.between(birthDateMichiel, LocalDate.now());

        System.out.println(periodeVanMichiel);

        System.out.println("Michiel is nu "+periodeVanMichiel.getYears()+" jaar plus "+periodeVanMichiel.getMonths()
        + " maanden en "+periodeVanMichiel.getDays()+" dagen");

        long daysMichiel = ChronoUnit.DAYS.between(birthDateMichiel, LocalDate.now());

        System.out.println(daysMichiel);

        long seconds = ChronoUnit.SECONDS.between(birthDateMichiel.atTime(23,0,0), LocalDateTime.now());
        System.out.println(seconds);




    }
}
