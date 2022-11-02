import java.io.IOException;

public class PlayerCreator {
    private static Player newPlayer;

    public Player createNewPlayer() throws IOException {
       initAll();

       newPlayer.name = IOManager.getString(Prompts.PlayerName.toString());
       newPlayer.lvl= IOManager.getInt(Prompts.Level.toString(),20);
       generateProfBonus();

       generateRace();
       generateClass();

       getAbilities();

       getHP(); // Calculates MAxHp, UserInput -> TempHP, CurrentHP
       getDeathsaves();

       generateSpellcastingAbility();
       generateSpellSaveDC();
       generateSpellAttackModifier();

       generateToolProf();
       generateLanguages();

       generateCoins();
       generateInventory();

       calculateRest();

       return newPlayer;
    }

    private void getAbilities() {
        switch (IOManager.getInt(Prompts.AbilityGeneration.text,2)){
            case 0: abilityStandardArray();
            case 1: abilityPointBuy();
            case 2: abilityRoll();

        }
    }
    private void abilityStandardArray() {
    }
    private void abilityPointBuy() {
    }
    private void abilityRoll() {
    }





    private void getDeathsaves(){
        newPlayer.failedDeathSaves = IOManager.getInt(Prompts.FailedDeathSaves.toString(),3);
        newPlayer.succesfullDeathSaves = IOManager.getInt(Prompts.SuccesfullDeathSaves.toString(),3);
    }
    private void getHP(){
        calcMaxHp(); //sths wrong
        newPlayer.currentHP = IOManager.getInt(Prompts.CurrentHP.toString(),newPlayer.maxHP);
        newPlayer.tempHP = IOManager.getInt(Prompts.TempHP.toString());
    }

    private void calculateRest() {
        newPlayer.initiative = newPlayer.abilities[1].modifier; //Dex Modifier
        newPlayer.speed = newPlayer.race.speed;
        newPlayer.AC = IOManager.getInt(Prompts.AC.toString());

    }

    private void generateSpellcastingAbility() {
        Ability tempAbility = null;
        if(newPlayer.playerClass instanceof Magical){
            tempAbility = ((Magical) newPlayer.playerClass).getcastingAbility();
        }
        newPlayer.spellcastingAbility = tempAbility;
    }

    private void generateSpellAttackModifier() {
        newPlayer.spellAtackModifier = -1;
        if (newPlayer.spellcastingAbility != null){
            newPlayer.spellAtackModifier = newPlayer.proficiencyBonus+ getCastingAbilityModifier();
        }

    }

    private void generateSpellSaveDC() {
        if (newPlayer.playerClass instanceof Magical) {
            newPlayer.spellAtackModifier += 8;
        }
    }

    private int getCastingAbilityModifier() {
        int returnModifier= 0;
        switch (newPlayer.spellcastingAbility){
            case STRENGTH -> returnModifier = newPlayer.abilities[0].modifier;
            case DEXTERITY -> returnModifier = newPlayer.abilities[1].modifier;
            case CONSTITUTION -> returnModifier = newPlayer.abilities[2].modifier;
            case INTELLIGENCE -> returnModifier = newPlayer.abilities[3].modifier;
            case WISDOM -> returnModifier = newPlayer.abilities[4].modifier;
            case CHARISMA -> returnModifier = newPlayer.abilities[5].modifier;
        }

        return returnModifier;
    }

    private void calcMaxHp() {
        int temp= newPlayer.playerClass.hitDie;

        newPlayer.maxHP = temp+((temp/2)+(temp%2))* newPlayer.lvl;
    }

    private void generateProfBonus() {
        int lvl = newPlayer.lvl;
        int tempProf = 6;

        if(lvl<5) tempProf= 2;
        if(lvl<9) tempProf= 3;
        if(lvl<13) tempProf= 4;
        if(lvl<17) tempProf= 5;


        newPlayer.proficiencyBonus = tempProf;
    }

    private void generateInventory() {//TODO Implement

    }

    private void generateCoins() { //TODO Implement

    }

    private void generateLanguages() { //TODO Implement

    }

    private void generateToolProf() { //TODO Implement

    }

    private void generateRace() throws IOException {
        newPlayer.race = (Race) IOManager.getArrayElement(Prompts.ChooseRace.toString(),Database.races.toArray());
    }

    private void generateClass() throws IOException {
        newPlayer.playerClass= (PlayerClass) IOManager.getArrayElement(Prompts.ChooseClass.toString(),Database.playerClasses.toArray());
        newPlayer.playerClass.lvlUPTo(newPlayer.lvl);
    }




    /*
     * Inits
     */
    public static void initAll() throws IOException {
        newPlayer = new Player();
        Database.initDatabase(newPlayer);

        initSkills();
        initAbilities();
    }

    public static Skill[] initSkills() {
        Skill[] returnArr = new Skill[18];
        Skills[] skillArr= Skills.values();

        for (int i=0; i<skillArr.length;i++){
            returnArr[i]= new Skill(skillArr[i]);
        }

        return returnArr;
    }

    public static AbilityScore[] initAbilities() {
        AbilityScore[] returnArr = new AbilityScore[6];

        returnArr[0]= new AbilityScore(0,Ability.STRENGTH);
        returnArr[1]= new AbilityScore(0,Ability.DEXTERITY);
        returnArr[2]= new AbilityScore(0,Ability.CONSTITUTION);
        returnArr[3]= new AbilityScore(0,Ability.INTELLIGENCE);
        returnArr[4]= new AbilityScore(0,Ability.WISDOM);
        returnArr[5]= new AbilityScore(0,Ability.CHARISMA);


        return returnArr;
    }

}
