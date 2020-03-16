package nl.workingtalent.asopos;

public class Assert {

    public static void require(boolean assertion) {
        if(!assertion) {
            throw new AssertionError();
        }
    }
}
