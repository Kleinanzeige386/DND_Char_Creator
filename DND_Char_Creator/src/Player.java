import java.util.ArrayList;

public class Player {
    public String name;
    public Race race;
    public PlayerClass playerClass;
    public int lvl;


    public AbilityScore[] abilities;
    public Skill[] skills;


    public int AC;
    public int initiative;
    public int speed;
    public int proficiencyBonus;

    public int maxHP;
    public int currentHP;
    public int tempHP;
    public int failedDeathSaves;
    public int succesfullDeathSaves;


    public int spellSaveDC;
    public int spellAtackModifier;


    public ArrayList<String> toolProf;
    public ArrayList<String> languages;


    public int[] coins ; // Copper Silver Electrum Gold Platinum
    public ArrayList<String> inventory;



    public Player() {
        name="N.A.";
        playerClass=new PlayerClass();
        abilities= PlayerCreator.initAbilities();
        skills=PlayerCreator.initSkills();

        lvl=0;
        AC=0;
        initiative=0;
        speed=0;
        maxHP=0;
        currentHP=0;
        tempHP=0;
        failedDeathSaves=0;
        succesfullDeathSaves=0;
        coins= new int[5];
        proficiencyBonus=0;
        spellSaveDC=0;
        spellAtackModifier=0;

    }



    @Override
    public String toString(){
        return "=========================================================================\nName: "+name+"\nRace: "+race+"\nClass: "+playerClass.toString()+"\nLevel: "+lvl+"\n=========================================================================\n"+abilitiesAndSkillsToString()+"\n=========================================================================\nAC: "+AC+"\nInitiative: "+initiative+"\nSpeed: "+speed+"\nProficiency Bonus: "+proficiencyBonus+"\n=========================================================================\nMaxHP: "+maxHP+"\nCurrentHP: "+currentHP+"\nTempHP: "+tempHP+"\n\nFailed Deathsaves: "+failedDeathSaves+"\nSuccesfull Deathsaves: "+succesfullDeathSaves+"\n=========================================================================\nSpellsave DC: "+spellSaveDC+"\nSpellattack Modifier: "+spellAtackModifier+"\n=========================================================================\nTool Proficiencies: "+toolProfToString()+"\n\nLanguages known: "+languagesToString()+"\n=========================================================================\nCoins: "+coinsToString()+"\nInventory: "+inventoryToString()+"\n=========================================================================";

    }

    private String languagesToString() {
        return "Player.languagesToString not implemented yet";
    }

    private String inventoryToString() {
        return "Player.inventoryToString not implemented yet";
    }

    private String toolProfToString() {
        return "Player.toolProfToString not implemented yet";
    }

    private String coinsToString() {
        return "Player.coinsToString not implemented yet";
    }

    private String abilitiesAndSkillsToString() {
        StringBuilder returnString= new StringBuilder();

        for (AbilityScore ability : abilities) {
            returnString.append(ability.toString()).append("\n----------\n");

            for (Skill skill : skills) {
                returnString.append(skill.toString()).append("\n");
            }
        }

        return returnString.toString();
    }
}
