import java.util.ArrayList;

public abstract class Race implements Named{
    public String name;
    public ArrayList<AbilityScore> abilityScoreIncrease;
    public int speed;
    public ArrayList<String> languages;
    public ArrayList<Feature> features;
    public ArrayList<String> damageResistances;


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

        features.add(Database.Features.DRACONIC_ANCESTRY.feature);
        features.add(Database.Features.BREATH_WEAPON.feature);
        features.add(Database.Features.DRAGON_BORN_RESISTANCE.feature);




    }

    @Override
    public void buildRace() {
        draconicAncestry = IOManager.getArrayElement(Prompts.DraconicAncestry.toString(),DragonColor.values());

    }


}


/*


    SUBRACES


 */












