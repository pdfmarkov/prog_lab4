public class Neznaika extends Villager implements NeznaikaActions {

    private boolean statSitting;
    private boolean statLying;
    private boolean statSleeping;
    private boolean Sad;

    Neznaika(Location location, World world) {
        super("Незнайка", location, Gender.MALE);
        this.statSitting = true;
        this.statLying = false;
        this.statSleeping = false;
        world.addNeznaika(this);
    }

    @Override
    public boolean getSitting() {
        return this.statSitting;
    }
    @Override
    public boolean getLying() {
        return this.statLying;
    }
    @Override
    public boolean getSleeping() {
        return this.statSleeping;
    }

    @Override
    public boolean getSad() {
        System.out.println(getName()+" расстроился");
        return this.Sad;
    }

    @Override
    public void setSitting(boolean b) {
        this.statSitting = b;
    }
    @Override
    public void setLying(boolean b) {
        this.statLying = b;
    }
    @Override
    public void setSleeping(boolean b) {
        this.statSleeping = b;
    }

    @Override
    public void setSad(boolean b) {
        System.out.println(getName()+" расстроился");
        this.Sad = b;
    }

    public void goTo(LittleOnes little) {
        this.goOut();
        System.out.println(getName()+" пошел туда же, в место " + little.getLocation());
        setLocation(little.getLocation());
    }

    public void goTo(Zabor zabor)
    {
        System.out.println(getName()+" убежал и наткнулся на " + zabor.getName());
        System.out.println(getName()+" ударился об "+zabor.getName()+" и увидел: "+zabor);
    }

    public void sayTruth() {
        System.out.print("Но на самом деле ");
        if (this.getSitting()) {
            this.setLying(true);
            System.out.println(this.getName() + " сидит, поэтому он лежит...");
            if (this.getLying()) {
                this.setSleeping(true);
                System.out.println(this.getName() + " лежит, поэтому он спит.");
            }
        }
    }

    public void toStory(LittleOnes little,Zabor zabor) throws BalLittleOnesDontExist {
            System.out.println("А прямо сейчас " + this.getName() + " находится где-то в месте " + this.getLocation());
            sayTruth();
            little.setReady(true);
            lookAt(little);
            little.lookAt(this);
            little.laugh(this);
            goTo(zabor);
    }

    public void lookAt(LittleOnes little) {
        if (little.isReady()){
            System.out.println(getName()+" увидел целую толпу, а точнее это были " + little.getName());
            goTo(little);
        }
        else {
            System.out.println(getName()+" не нашел ничего интересного");
        }
    }

    public void goOut() {
        this.setSleeping(false);
        this.setLying(false);
        this.setSitting(false);
        System.out.println(getName()+" пришел в себя");
    }
}
