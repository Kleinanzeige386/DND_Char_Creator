public enum Skills {
    ATHLETICS(Ability.STRENGTH),

    ACROBATICS(Ability.DEXTERITY),
    SLEIGHT_OF_HAND(Ability.DEXTERITY),
    STEALTH(Ability.DEXTERITY),

    ARCANA(Ability.INTELLIGENCE),
    HISTORY(Ability.INTELLIGENCE),
    INVESTIGATION(Ability.INTELLIGENCE),
    NATURE(Ability.INTELLIGENCE),
    RELIGION(Ability.INTELLIGENCE),

    ANIMAL_HANDLING(Ability.WISDOM),
    INSIGHT(Ability.WISDOM),
    MEDICINE(Ability.WISDOM),
    PERCEPTION(Ability.WISDOM),
    SURVIVAL(Ability.WISDOM),

    DECEPTION(Ability.CHARISMA),
    INTIMIDATION(Ability.CHARISMA),
    PERFOMANCE(Ability.CHARISMA),
    PERSUASION(Ability.CHARISMA);


    final Ability ability;

    Skills(Ability abil){
        ability=abil;
    }
}
