import java.util.Objects;

public class Location {
    private int x, y;
    private String name;

    public Location(String name, int x, int y,World world) throws LocationIsFull {
        int i;
        boolean b=true;
        if (world.getArrayListLocations().size()!=1)
        for (i=0; i < world.getArrayListLocations().size(); i++) {
            if ((x==world.getArrayListLocations().get(i).getX())&&(y==world.getArrayListLocations().get(i).getY())) b=false;
        }
        if (x<0 || y<0) {
            b = false;
        }
        if(b)
        {
            this.name = name;
            this.x = x;
            this.y = y;
            System.out.println("В мире теперь есть " + getName());
            world.addLocation(this);
        }
        else throw new LocationIsFull("Место "+name+" невозможно создать!");
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x &&
                y == location.y &&
                Objects.equals(name, location.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y, name);
    }

    @Override
    public String toString() {
        return getName();
    }
}