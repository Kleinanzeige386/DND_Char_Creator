import java.util.ArrayList;

public class Elf extends Race{
    public Elf() {
        super();
        name = "Elf";
        speed = 30;

        abilityScoreIncrease.add(new AbilityScore(2,Ability.DEXTERITY));

        languages.add("Common");
        languages.add("Elven");

        features.add(Database.RaceFeatures.DARKVISION.feature);
        features.add(Database.RaceFeatures.FEY_ANCESTRY.feature);
        features.add(Database.RaceFeatures.TRANCE.feature);
    }
}
