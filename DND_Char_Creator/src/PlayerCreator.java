import java.util.ArrayList;

public class PlayerCreator {

    public Player createNewPlayer(){
       Player newPlayer = new Player();
/*
       newPlayer.name = InputManager.getString(Prompts.PlayerName.toString());
       newPlayer.race = generateRace();
       newPlayer.playerClass= generateClass();
       newPlayer.lvl= InputManager.getInt(Prompts.Level.toString());

       //newPlayer.abilities= generateAbilities();
       //newPlayer.skills= generateSkills();

       newPlayer.AC = InputManager.getInt(Prompts.AC.toString());
       newPlayer.initiative = InputManager.getInt(Prompts.Initiative.toString());
       newPlayer.speed = InputManager.getInt(Prompts.Speed.toString());
       newPlayer.proficiencyBonus = InputManager.getInt(Prompts.ProfBonus.toString());

       newPlayer.maxHP = InputManager.getInt(Prompts.MaxHP.toString());
       newPlayer.currentHP = InputManager.getInt(Prompts.CurrentHP.toString());
       newPlayer.tempHP = InputManager.getInt(Prompts.TempHP.toString());

       newPlayer.failedDeathSaves = InputManager.getInt(Prompts.FailedDeathSaves.toString());
       newPlayer.succesfullDeathSaves = InputManager.getInt(Prompts.SuccesfullDeathSaves.toString());

       newPlayer.spellSaveDC = InputManager.getInt(Prompts.SpellSaveDc.toString());
       newPlayer.spellAtackModifier = InputManager.getInt(Prompts.SpellAttackModifier.toString());

       newPlayer.toolProf = generateToolProf();
       newPlayer.languages = generateLanguages();

       newPlayer.coins = generateCoins();
       newPlayer.inventory = generateInventory();
*/

       return newPlayer;
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

    private Skill[] generateSkills() {
        return new Skill[8];
    }

    private AbilityScore[] generateAbilities() {
        return new AbilityScore[6];
    }

    private Race generateRace() {
        return new Race();
    }

    private PlayerClass generateClass() {
        return new PlayerClass();
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
        Ability[] abiltyArr = Ability.values();

        for (int i=0; i<returnArr.length; i++){
            returnArr[i]= new AbilityScore(0,abiltyArr[i]);
        }

        return returnArr;
    }


}
