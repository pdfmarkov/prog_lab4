public class Zabor extends Location {
    private String graffiti;

    public Zabor(int x, int y, World world) throws LocationIsFull {
        super("▒забор", x, y, world);
        this.graffiti = "";
    }

    public Zabor(int x, int y, String graffiti, World world) throws LocationIsFull {
        super("▒забор", x, y, world);
        this.graffiti = graffiti;
        world.addZabor(this);
    }

    public void setGraffiti(String graffiti) {
        this.graffiti = graffiti;
    }

    @Override
    public String toString() {
        if (graffiti == "") {
            return "На заборе нет надписей";
        }
        else {
            return graffiti;
        }
    }
}
