import java.util.ArrayList;

public class World {
    private int sizeX,sizeY;
    private int [][] points;
    private ArrayList<Location> locations = new ArrayList<Location>();
    private ArrayList<Villager> villagers = new ArrayList<Villager>();
    private ArrayList<LittleOnes> littleones = new ArrayList<LittleOnes>();
    private Neznaika neznaika;
    private Bal bal;
    private Zabor zabor;

    World(int x, int y){
        sizeX=x;
        sizeY=y;
        System.out.println("Привет, мир");
    }

    public void addVillager(Villager villager){
        this.villagers.add(villager);
    }
    public void addLittleOnes(LittleOnes littleones){
        this.littleones.add(littleones);
    }
    public void addLocation(Location location){
        this.locations.add(location);
    }
    public void addNeznaika(Neznaika neznaika) {this.neznaika=neznaika; }
    public void addBal(Bal bal) {this.bal=bal; }
    public void addZabor(Zabor zabor) {this.zabor=zabor;}
    public ArrayList<Location> getArrayListLocations() {
        return locations;
    }
    public ArrayList<LittleOnes> getArrayListLittleOnes() {
        return littleones;
    }
    public ArrayList<Villager> getArrayListVillagers() {
        return villagers;
    }
    public Neznaika getNeznaika() { return neznaika; }
    public Bal getBal() {return bal;}
    public Zabor getZabor() {return zabor;}
    public int getSizeX() { return sizeX; }
    public int getSizeY() { return sizeY; }

    public void start(){
        int i;
        try {
            getArrayListLittleOnes().get(getArrayListLittleOnes().indexOf(new LittleOnes("Малыши на балу",bal,this,0))).playMusic();
            for (i = 0; i < getArrayListVillagers().size(); i++)
                getArrayListVillagers().get(i).goTo(bal, getArrayListLittleOnes().get(getArrayListLittleOnes().
                        indexOf(new LittleOnes("Малыши на балу",bal,this,0))));
            getNeznaika().toStory(getArrayListLittleOnes().get(getArrayListLittleOnes().indexOf(new LittleOnes("Идущие на бал малыши",bal.getTree(4),this,0))),
                    getZabor());
            getBal().start();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new BalLittleOnesDontExist("Малышей на балу нет!");
        }
    }


    public void showWorld(){
        boolean isExist;
            for (int i = getSizeY(); i >= 0; i--) {
                for (int j = 0; j <= getSizeX(); j++) {
                    isExist=false;

                    for(int f=0;f < getArrayListLocations().size();f++)
                    {
                        if (j == getArrayListLocations().get(f).getX() && i == getArrayListLocations().get(f).getY())
                        {
                            System.out.print(getArrayListLocations().get(f).getName().substring(0,1));
                            isExist=true;

                        }
                    }
                     if(!isExist) System.out.print(".");
                }
                System.out.println("");
        }

    }

}
