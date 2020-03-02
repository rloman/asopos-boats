package nl.workingtalent.asopos.model;

public class Member {

    public static double contributiePrice = 125.00;

    private String name; // instance variable. Java called a field.
    private int age;
    private String address;

    public String getName() {

        int localAge = 45;


        System.out.println(address);

        System.out.println(this.address);



        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
