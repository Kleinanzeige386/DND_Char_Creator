import java.util.ArrayList;
import java.util.Arrays;

public class Database {
    public static enum RaceFeatures {
        DARKVISION(0,"Darkvision","You can see in dim light within 60 feet of you as if it were bright light and in darkness as if it were dim light. You discern colors in that darkness only as shades of gray."),
        FEY_ANCESTRY(0,"Fey Ancestry","You have advantage on saving throws against being charmed, and magic can't put you to sleep."),
        TRANCE(0,"Trance","Elves do not sleep. Instead they meditate deeply, remaining semi-conscious, for 4 hours a day. The Common word for this meditation is \"trance.\" While meditating, you dream after a fashion; such dreams are actually mental exercises that have become reflexive after years of practice. After resting in this way, you gain the same benefit a human would from 8 hours of sleep.")
        ;


        Feature feature;

        RaceFeatures(int lvlReq, String name, String description) {
            feature = new Feature(lvlReq,name,description);
        }
    }
    public static ArrayList<Race> races;
    public static ArrayList<PlayerClass> playerClasses;
    
    public static void initDatabase(){
        races= new ArrayList<>();
        playerClasses= new ArrayList<>();

        initClasses();
        initRaces();
    }

    private static void initRaces() {
        Race temp;

        temp=new Race("Elf",new AbilityScore(2,Ability.DEXTERITY),30,new ArrayList<>(Arrays.asList("Common","Elven")),new ArrayList<>(Arrays.asList(RaceFeatures.DARKVISION.feature, RaceFeatures.FEY_ANCESTRY.feature, RaceFeatures.TRANCE.feature)));
        races.add(temp);
    }

    private static void initClasses() {
    }

}
