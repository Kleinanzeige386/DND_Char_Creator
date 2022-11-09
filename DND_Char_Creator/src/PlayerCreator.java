import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class PlayerCreator {
    public static Player newPlayer;

    public PlayerCreator() {
        initAll();
    }

    public Player createNewPlayer() throws IOException {


       newPlayer.name = IOManager.getString(Prompts.PlayerName.toString());
       getAbilities();
       newPlayer.lvl= IOManager.getInt(Prompts.Level.toString(),20);
       calcProfBonus();

       generateClass();
       generateRace();
       generateAlignment();
       generateBackgound();




       getHP(); // Calculates MAxHp, UserInput -> TempHP, CurrentHP
       getDeathsaves();

       generateSpellcastingAbility();
       generateSpellSaveDC();
       generateSpellAttackModifier();

       calculateRest();

       return newPlayer;
    }

    private void generateBackgound() {
        //TODO Implement
    }

    private void generateAlignment(){
        newPlayer.alignment = IOManager.getArrayElement(Prompts.chooseAlignment.text,Alignment.values());
    }

    private void getAbilities() {
        int input =IOManager.getArrayIndex(Prompts.AbilityGeneration.text,new String[]{"Standard Array","Point Buy","Dice Rolling"});
        switch (input) {
            case 0 -> abilityStandardArray();
            case 1 -> abilityPointBuy();
            case 2 -> abilityRoll();
        }
        calculateModifiers();
    }
    private void abilityStandardArray() {
        Integer[] standardArray = new Integer[]{15,14,13,12,10,8};
        assignAbilityScores(standardArray);

    }
    private void abilityPointBuy() {
        //TODO IMPLEMENT
    }
    private void abilityRoll() {
        Integer[] rolledScores = new Integer[]{0,0,0,0,0,0};


        for (int i=0; i<6; i++){
            rolledScores[i] = getSingleRoll();
        }

        assignAbilityScores(rolledScores);
    }
    private int getSingleRoll() {
        Random randomNum = new Random();
        int[] singleRoll= new int[]{0,0,0};
        int temp;

        //Roll 4 d6
        for (int i=0; i<3; i++ ) singleRoll[i] = randomNum.nextInt(6)+1;
        int smallest = randomNum.nextInt(6)+1;


        //Remove smallest number;
        for (int i=0; i<3; i++ ) {
            if(smallest > singleRoll[i]){
                temp = singleRoll[i];
                singleRoll[i] = smallest;
                smallest = temp;
            }
        }

        //Return Sum of biggest 3 rolls
        return singleRoll[0]+singleRoll[1]+singleRoll[2];


    }


    private void assignAbilityScores(Integer[] scores) {
        int input;
        int size = scores.length;
        boolean validInput;


        for (int i=0;i<size;i++){
            do{
                input =IOManager.getArrayIndex(Prompts.chooseAbilityScore.text+ Ability.values()[i],Arrays.copyOfRange( scores,0,size-i)); //Get index of chosen Score

                if((PlayerCreator.newPlayer.abilities[i].amount+scores[input]) <20){
                    validInput = true;
                } else{
                    validInput = false;
                    System.out.println("ERROR: Can't increase an Abiltyscore over 20, please choose a different Abilty");
                }
            }
            while(!validInput);

            newPlayer.abilities[i].amount += scores[input]; //Add score to Ability
            IOManager.removeArrayElement(scores,input);  //Remove score from scores
            scores[size-1] = -1;

        }
    }

    public static void calculateModifiers() {
        for (int i = 0; i<6; i++){
            newPlayer.abilities[i].modifier = (newPlayer.abilities[i].amount / 2) -5;
        }
    }





    private void getDeathsaves(){
        newPlayer.failedDeathSaves = IOManager.getInt(Prompts.FailedDeathSaves.toString(),3);
        newPlayer.succesfullDeathSaves = IOManager.getInt(Prompts.SuccesfullDeathSaves.toString(),3);
    }
    private void getHP(){
        calcMaxHp();
        newPlayer.currentHP = IOManager.getInt(Prompts.CurrentHP.toString(),newPlayer.maxHP);
        newPlayer.tempHP = IOManager.getInt(Prompts.TempHP.toString());
    }

    private void calculateRest() {
        calculateModifiers();
        calculateSkills();
        newPlayer.initiative = newPlayer.abilities[1].modifier; //Dex Modifier
        newPlayer.speed = newPlayer.race.speed;
        newPlayer.AC = 10+ newPlayer.abilities[1].modifier;
        mergeFeatures();
        mergeBackground();
    }

    private void mergeBackground() {
        //TODO Implement
    }

    private void mergeFeatures() {
        newPlayer.features.addAll(newPlayer.playerClass.features);
        newPlayer.features.addAll(newPlayer.race.features);
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

    private void calcProfBonus() {
        int lvl = newPlayer.lvl;
        int tempProf = 6;

        if(lvl<5) tempProf= 2;
        else if(lvl<9) tempProf= 3;
        else if(lvl<13) tempProf= 4;
        else if(lvl<17) tempProf= 5;


        newPlayer.proficiencyBonus = tempProf;
    }



    private void generateRace() {
        newPlayer.race = (Race) IOManager.getNamedArrayElement(Prompts.ChooseRace.toString(),Database.races.toArray());
        newPlayer.race.buildRace();
    }

    private void generateClass() {
        newPlayer.playerClass= (PlayerClass) IOManager.getNamedArrayElement(Prompts.ChooseClass.toString(),Database.playerClasses.toArray());
        newPlayer.playerClass.lvlUPTo(newPlayer.lvl);
    }




    /*
     * Inits
     */
    public static void initAll(){
        newPlayer = new Player();

        Database.initDatabase();

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
