import java.util.ArrayList;

public abstract class Background implements Named{
    public ArrayList<Skills> proficiencies;
    public ArrayList<String> languages;
    public ArrayList<String> items;
    public ArrayList<Feature> features;
    public String name;
    public int[] coins;
    public Background() {
        proficiencies = new ArrayList<>();
        languages = new ArrayList<>();
        items = new ArrayList<>();
        features = new ArrayList<>();

                      // C S E G P
        coins= new int[]{0,0,0,0,0};
    }
    public String getName() {
        return name;
    }
}



class Acolyte extends Background{
    Acolyte(){
        name= "Acolyte";
        proficiencies.add(Skills.INSIGHT);
        proficiencies.add(Skills.RELIGION);

        items.add("Holy Symbol");
        items.add("Prayer Book or Prayer Wheel");
        items.add("5 sticks of incense");
        items.add("vestments");
        items.add("Common clothes");

        coins[3]= 15;
    }
}
