package nl.workingtalent.asopos.birdcage;

public class BirdCage {

    private Bird[] birds = new Bird[5];


    public long add(Bird bird) {

        // basic loop
        for (int i = 0; i < birds.length; i++) {
            if (birds[i] == null) {
                bird.setId(i);

                birds[i] = bird;

                return i;
            }
        }
        return -1;
    }

    public void deleteById(int id) {
        this.birds[id] = null;
    }

    public void print() {
        // enhanced for
        for (Bird bird : this.birds) {
            if (bird != null) {
                System.out.println(bird);
            }
        }
    }


    public String label() {

        String result = "";
        // enhanced for
        for (Bird bird : this.birds) {
            if (bird != null) {
                result = result + ", " + bird;
            }
        }

        return result;
    }
}
