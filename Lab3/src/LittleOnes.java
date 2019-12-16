import java.util.ArrayList;
public class LittleOnes extends Creature{

    private boolean ready;
    private ArrayList<Arfa> Arfas = new ArrayList<Arfa>();

    public LittleOnes(String name, Location location, World world) {
        super(name, location);
        this.ready = false;
        world.addLittleOnes(this);
        System.out.println("В мире теперь есть " + getName() + " в месте " + getLocation());
    }

    public LittleOnes(String name, Location location, World world, int x) {
        super(name, location);
        this.ready = false;
    }
    public void laugh(Creature c){
        System.out.println(getName()+" рассмеялись над "+c.getName());
    }
    public void laugh(Neznaika n){
        System.out.println(getName()+" рассмеялись над "+n.getName());
        n.setSad(true);
    }
    public void lookAt(Creature c){
        System.out.println(getName()+" увидели "+c.getName());
    }
    public boolean isReady() {
        return this.ready;
    }

    public void playMusic() {
    LittleOnesMusicActions objLittleOnesMusicActions = new LittleOnesMusicActions() {
        public void playArfas() {
            int i;
            System.out.print(getName() + " имели множество разных арф: ");
            for (i = 0; i < Arfas.size(); i++) {
                System.out.print(Arfas.get(i) + ", ");
            }
            System.out.println("");
        }
        @Override
        public void createArfas() {
            Arfas.add(new Arfa(Size.BIG));
            Arfas.add(new Arfa(Size.ENORMOUS));
            Arfas.add(new Arfa(Size.SMALL));
            Arfas.add(new Arfa(Size.SMALL));
            Arfas.add(new Arfa(Size.BIG));
            Arfas.add(new Arfa(Size.ENORMOUS));
        }
    };
    objLittleOnesMusicActions.createArfas();
    objLittleOnesMusicActions.playArfas();
}
    public void setReady(boolean ready) {
        this.ready = ready;
        if (ready){
            System.out.println(getName()+" начали собираться ");
        }
        else {
            System.out.println(getName()+" еще не начали собираться ");
        }

    }

}
