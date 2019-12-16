import java.util.Objects;

abstract public class Creature {
    private String name;
    private Location location;

    public Creature(String name, Location location){
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void goTo(Location location) {
        setLocation(location);
        System.out.println(getName()+" отправился в "+location.getName());
    }

    public String getName() {
        return name;
    }

    public void setLocation(Location location) {
        this.location = location;
        System.out.println(getName()+" теперь в месте "+ getLocation());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return Objects.equals(name, creature.name) &&
                Objects.equals(location, creature.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return getName();
    }
}
