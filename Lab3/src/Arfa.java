public class Arfa {
    private Size size;

    Arfa(Size size){
        this.size = size;
    }

    @Override
    public String toString() {
            if (size==Size.SMALL) {return "маленькая арфа";}
            else if (size==Size.BIG) {return "арфа достаточно большая, которая уже стояла на полу";}
            else {return "арфа огромная настолько, что на нее надо было взбираться";}
    }
}
