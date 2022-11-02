public enum Prompts {
    PlayerName("Enter the Name of your Character: "),
    Level("Enter the Character's Level: "),
    AC("Enter the Character's AC: "),
    Initiative("Enter the Character's Initiative: "),
    Speed("Enter the Character's Speed: "),
    ProfBonus("Enter the Character's Proficiency Bonus: "),
    MaxHP("Enter the Character's max HP: "),
    CurrentHP("Enter the Character's current HP: "),
    TempHP("Enter the Character's temporary HP: "),
    FailedDeathSaves("Enter the Amount of failed Deathsaves: "),
    SuccesfullDeathSaves("Enter the Amount of succesfull Deathsaves: "),
    SpellSaveDc("Enter the Character's Spellsave DC: "),
    SpellAttackModifier("Enter the Character's Spell Attack-modifier: "),
    ChooseRace("Choose a Race for your Character: "),
    ChooseClass("Choose a Class for your Character: "),
    DraconicAncestry("Choose a Draconic Ancestry for your Character:"),
    ChooseSkill("N.A."),
    AbilityGeneration("N.A.");


    public String text;
    Prompts(String text) {
        this.text=text;
    }
    @Override
    public String toString(){
        return text;
    }
}
