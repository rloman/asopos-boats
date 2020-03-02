package nl.workingtalent.asopos.accessmods;

public class RowingBoat {
    private String type;


    public String getType() {
        return type;
    }

    public void foo() {
        RowingBoat other = new RowingBoat();

        other.type = "Zeiljacht :-)";
    }
}

