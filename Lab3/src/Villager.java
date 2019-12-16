public class Villager extends Creature{
    private boolean invitation;
    private Gender gender;

    public Villager(String name, Location location, Gender gender, World world) {
        super(name, location);
        this.gender = gender;
        this.invitation = false;
        world.addVillager(this);
        System.out.println("В мире теперь есть " + getName() + " в месте " + getLocation());
    }

    public Villager(String name, Location location, Gender gender,boolean invitation, World world) {
        super(name, location);
        this.invitation = invitation;
        this.gender = gender;
        world.addVillager(this);
        System.out.println("В мире теперь есть " + getName() + " в месте " + getLocation());
    }

    public Villager(String name, Location location, Gender gender) {
        super(name,location);
        this.gender = gender;
        this.invitation = false;
        System.out.println("В мире теперь есть " + getName() + " в месте " + getLocation());
    }


    public boolean getInvitation() {
        return this.invitation;
    }

    @Override
    public void goTo(Location location) {
        setLocation(location);
    }


    public void goTo(Bal bal) {
        if (getLocation().equals(bal))
        {
            System.out.println("Житель "+getName()+ " уже на месте ");
        }
        if(getInvitation()==true) {
            setLocation(bal);
        }
    }
    public void goTo(Bal bal, LittleOnes little){
        if (getLocation().equals(bal))
        {
            System.out.println("Житель "+getName()+" уже на месте ");
        }
        else if(getInvitation()==true) {
            setLocation(bal);
        }
        else {
            sayThanks(little);
            setLocation(bal);
        }
    }
    public void setInvitation(boolean b) {
       this.invitation = b;
       if (b) {
           System.out.println("Житель "+getName()+ " теперь имеет приглашение");
        }
    }

    public void sayThanks(Creature creature){
        System.out.println("Житель "+getName() + " благодарит " + creature.getName());
    }

    public void sayThanks(LittleOnes little){
        System.out.println("Житель "+getName() + " благодарит " + little.getName()+ " за фрукты");
        System.out.println(little.getName()+" пригласили жителя "+getName());
        setInvitation(true);
    }

    public Gender getGender() {
        return this.gender;
    }

}
