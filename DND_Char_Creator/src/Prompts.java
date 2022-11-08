public enum Prompts {
    PlayerName("Enter the Name of your Character: "),
    Level("Enter the Character's Level: "),
    CurrentHP("Enter the Character's current HP: "),
    TempHP("Enter the Character's temporary HP: "),
    FailedDeathSaves("Enter the Amount of failed Deathsaves: "),
    SuccesfullDeathSaves("Enter the Amount of succesfull Deathsaves: "),
    ChooseRace("Choose a Race for your Character: "),
    ChooseClass("Choose a Class for your Character: "),
    DraconicAncestry("Choose a Draconic Ancestry for your Character:"),
    ChooseSkill("N.A."),
    AbilityGeneration("Which Method do you want to use to generate your Character's Abilityscores?"),
    chooseAbilityScore("Choose the score you want to assign to "),
    ASI("Which AbiltyScore do you want to improve by 1?"),
    chooseAlignment("Choose an alignment for your Character: "),
    chooseSubclass("Choose a subclass for your Character: ");



    public final String text;
    Prompts(String text) {
        this.text=text;
    }
    @Override
    public String toString(){
        return text;
    }
}
