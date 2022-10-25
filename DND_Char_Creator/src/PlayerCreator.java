import java.io.IOException;
import java.util.ArrayList;

public class PlayerCreator {

    public Player createNewPlayer() throws IOException {
       Player newPlayer = new Player();
       Database.initDatabase();

       newPlayer.name = InputManager.getString(Prompts.PlayerName.toString());
       newPlayer.race = generateRace();
       newPlayer.playerClass= generateClass();
       newPlayer.lvl= InputManager.getInt(Prompts.Level.toString());

       newPlayer.proficiencyBonus= generateProfBonus(newPlayer.lvl);
       newPlayer.AC = InputManager.getInt(Prompts.AC.toString());

       newPlayer.maxHP = InputManager.getInt(Prompts.MaxHP.toString()); //TODO Change from User Input to Calculation using Hit Die
       newPlayer.currentHP = InputManager.getInt(Prompts.CurrentHP.toString());
       newPlayer.tempHP = InputManager.getInt(Prompts.TempHP.toString());

       newPlayer.failedDeathSaves = InputManager.getInt(Prompts.FailedDeathSaves.toString());
       newPlayer.succesfullDeathSaves = InputManager.getInt(Prompts.SuccesfullDeathSaves.toString());

       newPlayer.spellSaveDC = InputManager.getInt(Prompts.SpellSaveDc.toString()); //TODO Change to Calculation in PlayerClass
       newPlayer.spellAtackModifier = InputManager.getInt(Prompts.SpellAttackModifier.toString());//TODO Change to Calculation in PlayerClass

       newPlayer.toolProf = generateToolProf();
       newPlayer.languages = generateLanguages();

       newPlayer.coins = generateCoins();
       newPlayer.inventory = generateInventory();

       newPlayer.initiative = newPlayer.abilities[1].modifier; //Dex Modifier
       newPlayer.speed = newPlayer.race.speed;




       return newPlayer;
    }

    private int generateProfBonus(int lvl) {
        if(lvl<5) return 2;
        if(lvl<9) return 3;
        if(lvl<13) return 4;
        if(lvl<17) return 5;
        return 6;
    }

    private ArrayList<String> generateInventory() {
        return new ArrayList<>();
    }

    private int[] generateCoins() {
        return new int[5];
    }

    private ArrayList<String> generateLanguages() {
        return new ArrayList<>();
    }

    private ArrayList<String> generateToolProf() {
        return new ArrayList<>();
    }

    private Race generateRace() throws IOException {
        Race tempRace= new Race();

        InputManager.getArrayElement(Prompts.chooseRace.toString(),Database.races.toArray());


        return tempRace;
    }

    private PlayerClass generateClass() {
        PlayerClass returnClass= new PlayerClass();

        //TODO Make user choose a class

        return returnClass;
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
