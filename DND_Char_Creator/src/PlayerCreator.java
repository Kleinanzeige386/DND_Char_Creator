import java.io.IOException;
import java.util.ArrayList;

public class PlayerCreator {
    private static Player newPlayer;

    public Player createNewPlayer() throws IOException {


       newPlayer.name = InputManager.getString(Prompts.PlayerName.toString());
       newPlayer.race = generateRace();
       newPlayer.playerClass= generateClass();
       newPlayer.lvl= InputManager.getInt(Prompts.Level.toString());

       newPlayer.proficiencyBonus= generateProfBonus(newPlayer.lvl);
       newPlayer.AC = InputManager.getInt(Prompts.AC.toString());

       newPlayer.maxHP = calcMaxHp(newPlayer);
       newPlayer.currentHP = InputManager.getInt(Prompts.CurrentHP.toString());
       newPlayer.tempHP = InputManager.getInt(Prompts.TempHP.toString());

       newPlayer.failedDeathSaves = InputManager.getInt(Prompts.FailedDeathSaves.toString());
       newPlayer.succesfullDeathSaves = InputManager.getInt(Prompts.SuccesfullDeathSaves.toString());

       newPlayer.spellcastingAbility = generateSpellcastingAbility(newPlayer);
       newPlayer.spellSaveDC = generateSpellSaveDC(newPlayer);
       newPlayer.spellAtackModifier = generateSpellAttackModifier(newPlayer);

       newPlayer.toolProf = generateToolProf();
       newPlayer.languages = generateLanguages();

       newPlayer.coins = generateCoins();
       newPlayer.inventory = generateInventory();

       newPlayer.initiative = newPlayer.abilities[1].modifier; //Dex Modifier
       newPlayer.speed = newPlayer.race.speed;




       return newPlayer;
    }

    private Ability generateSpellcastingAbility(Player newPlayer) {
        if(newPlayer.playerClass instanceof Magical){
            return ((Magical) newPlayer.playerClass).getcastingAbility();
        }
        return null;
    }

    private int generateSpellAttackModifier() {
        if (newPlayer.spellcastingAbility != null){
            return newPlayer.proficiencyBonus+ getCastingAbilityModifier(newPlayer);
        }
        return -1;
    }

    private int generateSpellSaveDC() {
        if (newPlayer.playerClass instanceof Magical){
            return newPlayer.spellAtackModifier + 8;
        }
        return -1;
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

    private int calcMaxHp() {
        int temp= newPlayer.playerClass.hitDie;

        return temp+((temp/2)+(temp%2))* newPlayer.lvl;
    }

    private int generateProfBonus() {
        int lvl = newPlayer.lvl;

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
        Race returnRace = (Race) InputManager.getArrayElement(Prompts.ChooseRace.toString(),Database.races.toArray());
        return returnRace;
    }

    private PlayerClass generateClass() throws IOException {
        PlayerClass returnClass= (PlayerClass) InputManager.getArrayElement(Prompts.ChooseClass.toString(),Database.playerClasses.toArray());
        return returnClass;
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
