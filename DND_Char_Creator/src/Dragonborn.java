import java.io.IOException;

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




    }

    @Override
    public void generateRace() throws IOException {
        draconicAncestry = IOManager.getArrayElement(Prompts.DraconicAncestry.toString(),DragonColor.values());

    }


}


/*


    SUBRACES


 */