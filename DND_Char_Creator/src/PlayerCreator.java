import java.io.IOException;
import java.util.Random;

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

    private void getAbilities() throws IOException {
        switch (IOManager.getInt(Prompts.AbilityGeneration.text,2)){
            case 0: abilityStandardArray();
            case 1: abilityPointBuy();
            case 2: abilityRoll();

        }
        calculateModifiers();
    }
    private void abilityStandardArray() throws IOException {
        Integer[] standardArray = new Integer[]{15,14,13,12,10,8};
        int input;

        for (int i=0;i<6;i++){
            input =IOManager.getArrayIndex(Prompts.chooseStandardArray.text+Ability.values()[i],standardArray);
            newPlayer.abilities[i].amount += standardArray[input];
            IOManager.removeArrayElement(standardArray,input);
            standardArray[5] = -1;

        }
    }
    private void abilityPointBuy() {
    }
    private void abilityRoll() {
        Random randomNum = new Random();
        int[] rolledScores = new int[]{0,0,0,0,0,0};
        int[] singleRoll= new int[]{0,0,0};

        for (int i=0; i<6; i++){

        }
    }
    private void calculateModifiers() {
        for (int i = 0; i<6; i++){
            newPlayer.abilities[i].modifier = (newPlayer.abilities[i].amount / 2) -5;
        }
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
        calculateModifiers();
        calculateSkills();
        newPlayer.initiative = newPlayer.abilities[1].modifier; //Dex Modifier
        newPlayer.speed = newPlayer.race.speed;
        newPlayer.AC = 10+ newPlayer.abilities[1].modifier;



    }

    private void calculateSkills() {
        int tempIndex;

        for (int i=0; i<newPlayer.skills.length;i++){
            tempIndex = IOManager.getArrayIndex(Ability.values(),newPlayer.skills[i].skill.ability);
            newPlayer.skills[i].value += newPlayer.abilities[tempIndex].modifier;

            if (newPlayer.skills[i].prof){
                newPlayer.skills[i].value += newPlayer.proficiencyBonus;
            }
        }

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
        else if(lvl<9) tempProf= 3;
        else if(lvl<13) tempProf= 4;
        else if(lvl<17) tempProf= 5;


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
