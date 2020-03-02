package nl.workingtalent.asopos;

import nl.workingtalent.asopos.model.Member;

public class Application {

    public static void main(String[] args) {

        Member member = new Member();

        member.setName("Ray");


        double doubleTje = 3.5f;

        System.out.println(3_000_000_000L);


        System.out.println(100);

        char c = 'C';

        boolean isMale = true;

        boolean isFemale = false;

        String firstname;

        Dog d = new Dog();

        System.out.println(d.toString());

        System.out.println(d.getName());

        Member m = new Member();

        System.out.println(m.getName());

        m.setName("Piet");

        System.out.println(m.getName());
        System.out.println(m.getAge());

        System.out.println(Member.contributiePrice);

        Member.contributiePrice++;

        System.out.println(Member.contributiePrice);

        System.out.println(Member.contributiePrice);



    }

}
