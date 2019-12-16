import java.util.*;

public enum Colors {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    PURPLE;

    private static final List<Colors> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static String getRandomColor()  {
        Colors c = VALUES.get(RANDOM.nextInt(SIZE));
        if (c==RED) {return "красным";}
        else if (c==ORANGE) {return "оранжевым";}
        else if (c==YELLOW) {return "желтым";}
        else if (c==GREEN) {return "зеленым";}
        else if (c==BLUE) {return "синим";}
        else {return "фиолетовым";}
    }

}
