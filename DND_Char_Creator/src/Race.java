import java.util.ArrayList;

public abstract class Race implements Named{
    public String name;
    public final ArrayList<AbilityScore> abilityScoreIncrease;
    public int speed;
    public final ArrayList<String> languages;
    public final ArrayList<Feature> features;
    public final ArrayList<String> damageResistances;


    public Race() {
        abilityScoreIncrease = new ArrayList<>();
        languages = new ArrayList<>();
        features = new ArrayList<>();
        damageResistances= new ArrayList<>();

        name="N.A.";
        speed=0;
    }


    public String getName() {
        return name;
    }

    public abstract void buildRace();

    public void addFeature(Database.Features feat){
        features.add(feat.feature);
        //TODO implement Feature functionalities
        switch(feat){

            default -> {
                break;
            }
        }
    }
}


class Elf extends Race{
    public Elf() {
        super();
        name = "Elf";
        speed = 30;

        abilityScoreIncrease.add(new AbilityScore(2,Ability.DEXTERITY));

        languages.add("Common");
        languages.add("Elven");

        addFeature(Database.Features.DARKVISION);
        addFeature(Database.Features.FEY_ANCESTRY);
        addFeature(Database.Features.TRANCE);
    }

    @Override
    public void buildRace() {

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

        public final String damageType;
        public final String area;
        public final Ability savingThrow;
        DragonColor(String DT, String ar, Ability a) {
            damageType = DT;
            area = ar;
            savingThrow = a;
        }
    }


    public DragonColor draconicAncestry;

    public Dragonborn() {
        super();

        name= "Dragonborn";
        speed = 30;

        abilityScoreIncrease.add(new AbilityScore(1,Ability.CHARISMA));
        abilityScoreIncrease.add(new AbilityScore(2,Ability.STRENGTH));

        languages.add("Common");
        languages.add("Draconic");

        addFeature(Database.Features.DRACONIC_ANCESTRY);
        addFeature(Database.Features.BREATH_WEAPON);
        addFeature(Database.Features.DRAGON_BORN_RESISTANCE);




    }



    @Override
    public void buildRace() {
        draconicAncestry = IOManager.getArrayElement(Prompts.DraconicAncestry.toString(),DragonColor.values());

    }


}


/*


    SUBRACES


 */












