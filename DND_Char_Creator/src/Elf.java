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

/*


    SUBRACES


 */