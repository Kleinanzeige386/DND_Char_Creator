import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class Race {
    public String name;
    public ArrayList<AbilityScore> abilityScoreIncrease;
    public int speed;
    public ArrayList<String> languages;
    public ArrayList<Feature> features;
    public ArrayList<String> damageResistances;

    public Race(String name, ArrayList<AbilityScore> abilityScoreIncrease, int speed, ArrayList<String> languages, ArrayList<Feature> features,ArrayList<String> damageResistances) {
        this.name = name;
        this.abilityScoreIncrease = abilityScoreIncrease;
        this.speed = speed;
        this.languages = languages;
        this.features = features;
        this.damageResistances = damageResistances;
    }

    public Race() {
        abilityScoreIncrease = new ArrayList<>();
        languages = new ArrayList<>();
        features = new ArrayList<>();
        damageResistances= new ArrayList<>();

        name="N.A.";
        speed=0;
    }

    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();

        returnString.append(name);
        returnString.append("\n----------");
        returnString.append("\n"+abilityScoreIncreaseToString());
        returnString.append("\nSpeed: "+speed+"ft.");
        returnString.append("\nLanguages: \n -");
        returnString.append(String.join("\n -",languages));
        returnString.append("\n\nFeatures: \n -");
        returnString.append(String.join(features.stream().map(Object::toString)
                                                         .collect(Collectors.joining("\n\n")))); //TODO Update to String method

        return returnString.toString();
    }

    private String abilityScoreIncreaseToString() {
        StringBuilder returnString = new StringBuilder();//TODO

        return returnString.toString();
    }


    public String getNameString() {
        return name;
    }

    public abstract void generateRace();
}





class Elf extends Race{
    public Elf() {
        super();
        name = "Elf";
        speed = 30;

        abilityScoreIncrease.add(new AbilityScore(2,Ability.DEXTERITY));

        languages.add("Common");
        languages.add("Elven");

        features.add(Database.Features.DARKVISION.feature);
        features.add(Database.Features.FEY_ANCESTRY.feature);
        features.add(Database.Features.TRANCE.feature);
    }

    @Override
    public void generateRace() {

    }
}






class Dragonborn extends Race{
    public enum DragonColor{
        BLACK("Acid","5' by 30' line",Ability.DEXTERITY),
        BLUE("Lightning","5' by 30' line",Ability.DEXTERITY),
        BRASS("Fire","5' by 30' line",Ability.DEXTERITY),
        BRONZE("Lightning","5' by 30' line",Ability.DEXTERITY),
        COPPER("Acid","5' by 30' line",Ability.DEXTERITY),
        GOLD("Fire","15' cone",Ability.DEXTERITY),
        GREEN("Poison","15' cone",Ability.CONSTITUTION),
        RED("Fire","15' cone",Ability.DEXTERITY),
        SILVER("Cold","15' cone",Ability.CONSTITUTION),
        WHITE("Cold","15' cone",Ability.CONSTITUTION)
        ;

        public String damageType;
        public String area;
        public Ability savingThrow;
        DragonColor(String DT, String ar, Ability a) {
            damageType = DT;
            area = ar;
            savingThrow = a;
        }
    }


    public DragonColor draconicAncestry;

    public Dragonborn() throws IOException {
        super();

        name= "Dragonborn";
        speed = 30;

        abilityScoreIncrease.add(new AbilityScore(1,Ability.CHARISMA));
        abilityScoreIncrease.add(new AbilityScore(2,Ability.STRENGTH));

        languages.add("Common");
        languages.add("Draconic");

        features.add(Database.Features.DRACONIC_ANCESTRY.feature);
        features.add(Database.Features.BREATH_WEAPON.feature);
        features.add(Database.Features.DRAGON_BORN_RESISTANCE.feature);


        draconicAncestry = InputManager.getArrayElement(Prompts.DraconicAncestry.toString(),DragonColor.values());


    }

    @Override
    public void generateRace(){

    }


}



