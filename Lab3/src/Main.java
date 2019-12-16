public class Main {
    public static void main(String args[]) throws LocationIsFull {

        //Create World
        World world = new World(18,18);
        // Create locations
        Bal bal =  new Bal(8,6, world);
        Location dandelions = new Location("Одуванчики",1,1, world);
        Location zmeevka = new Location("Змеевка",3,3, world);
        Zabor zabor = new Zabor(3,4,"Незнайка дурак", world);
        // Create creatures
        Villager gvozdik = new Villager("Гвоздик",zmeevka,Gender.MALE, world);
        Villager shpuntik = new Villager("Шпунтик",zmeevka,Gender.MALE, world);
        Villager bublik = new Villager("Бублик",zmeevka,Gender.MALE, world);
        Neznaika neznaika = new Neznaika(dandelions, world);
        LittleOnes BalLittleOnes = new LittleOnes("Малыши на балу",bal, world);
        LittleOnes OrchestreLittleOnes = new LittleOnes("Малыши из оркестра",bal.getPavilion(0), world);
        LittleOnes GoingLittleOnes = new LittleOnes("Идущие на бал малыши",bal.getTree(4), world);

        // Story start...
       world.start();
       world.showWorld();
    }
}
