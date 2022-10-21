public enum Prompts {
    PlayerName("Enter the Name of your Character: "),
    Level("N.A."),
    AC("N.A."),
    Initiative("N.A."),
    Speed("N.A."),
    ProfBonus("N.A."),
    MaxHP("N.A."),
    CurrentHP("N.A."),
    TempHP("N.A."),
    FailedDeathSaves("N.A."),
    SuccesfullDeathSaves("N.A."),
    SpellSaveDc("N.A."),
    SpellAttackModifier("N.A.");


    public String text;
    Prompts(String text) {
        this.text=text;
    }
    @Override
    public String toString(){
        return text;
    }
}
