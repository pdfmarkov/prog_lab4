import java.util.ArrayList;

public class Bal extends Location {

    private boolean statStart;
    private ArrayList<Palatka> PalatkaList = new ArrayList<Palatka>();
    private ArrayList<Tree> TreeList = new ArrayList<Tree>();
    private ArrayList<Pavilion> PavilionList = new ArrayList<Pavilion>();

    public Bal(int x, int y, World world) throws LocationIsFull {
        super("Бал", x, y, world);
        world.addBal(this);
        PalatkaList.add(new Palatka(x + 1, y, world));
        PalatkaList.add(new Palatka(x - 1, y, world));
        PalatkaList.add(new Palatka(x, y + 1, world));
        PalatkaList.add(new Palatka(x, y - 1, world));
        TreeList.add(new Tree(x + 2, y, world));
        TreeList.add(new Tree(x + 1, y + 1, world));
        TreeList.add(new Tree(x, y + 2, world));
        TreeList.add(new Tree(x - 1, y + 1, world));
        TreeList.add(new Tree(x - 2, y, world));
        TreeList.add(new Tree(x - 1, y - 1, world));
        TreeList.add(new Tree(x, y - 2, world));
        TreeList.add(new Tree(x + 1, y - 1, world));
        PavilionList.add(new Pavilion(x,y+3,world));
        statStart = false;
    }

    public Tree getTree(int x) {
        return TreeList.get(x);
    }

    public Palatka getPalatka(int x){ return PalatkaList.get(x); }

    public Pavilion getPavilion(int x){ return PavilionList.get(x);};

    public void start(){
        this.statStart = true;
        System.out.println(getName()+" начался");
    }

    class Tree extends Location implements ShineActions {

        private String color;

        public Tree(int x, int y, World world) throws LocationIsFull {
            super("Дерево",x,y,world);
            shine();
        }

        @Override
        public void shine() {
            this.color = Colors.getRandomColor();
            System.out.println("Объект "+getName()+" теперь блестит "+color+" цветом!");
        }
    }

    public class Palatka extends Location implements ShineActions{
        private String color;
        public Palatka(int x, int y, World world) throws LocationIsFull {
            super("Палатка", x, y, world);
            shine();
        }

        @Override
        public void shine() {
            this.color = Colors.getRandomColor();
            System.out.println("Объект "+getName()+" теперь блестит "+color+" цветом!");
        }
    }
    class Pavilion extends Location implements ShineActions {

        private String color;

        public Pavilion(int x, int y, World world) throws LocationIsFull {
            super("%Беседка",x,y,world);
            shine();
        }

        @Override
        public void shine() {
            this.color = Colors.getRandomColor();
            System.out.println("Объект "+getName()+" теперь блестит "+color+" цветом!");
        }
    }

}