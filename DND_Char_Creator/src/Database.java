import java.util.ArrayList;

public class Database {
    public static enum RaceFeatures {
        DARKVISION(0,"Darkvision","You can see in dim light within 60 feet of you as if it were bright light and in darkness as if it were dim light. You discern colors in that darkness only as shades of gray."),
        FEY_ANCESTRY(0,"Fey Ancestry","You have advantage on saving throws against being charmed, and magic can't put you to sleep."),
        TRANCE(0,"Trance","Elves do not sleep. Instead they meditate deeply, remaining semi-conscious, for 4 hours a day. The Common word for this meditation is \"trance.\" While meditating, you dream after a fashion; such dreams are actually mental exercises that have become reflexive after years of practice. After resting in this way, you gain the same benefit a human would from 8 hours of sleep."),
        BREATH_WEAPON(0,"Breath Weapon" ,"You can use your action to exhale destructive energy. It deals damage in an area according to your ancestry. When you use your breath weapon, all creatures in the area must make a saving throw, the type of which is determined by your ancestry. The DC of this saving throw is 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increase to 3d6 at 6th level, 4d6 at 11th, and 5d6 at 16th level. After using your breath weapon, you cannot use it again until you complete a short or long rest." ),
        DRAGON_BORN_RESISTANCE(0,"Damage Resistance" ,"You have resistance to the damage type associated with your ancestry." ),
        DRACONIC_ANCESTRY(0,"Draconic Ancestry","You are distantly related to a particular kind of dragon. Choose a type of dragon from the below list; this determines the damage and area of your breath weapon, and the type of resistance you gain.")
        ;


        final Feature feature;

        RaceFeatures(int lvlReq, String name, String description) {
            feature = new Feature(lvlReq,name,description);
        }

        //TODO Add toString Method
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
        //PHB
        // ,new ArrayList<>((Arrays.asList( ) ))));

    }

    private static void initClasses() {
    }

}
