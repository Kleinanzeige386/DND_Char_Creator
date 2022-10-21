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
        race=new Race();
        playerClass=new PlayerClass();
        lvl=0;

        abilities= PlayerCreator.initAbilities();
        skills=PlayerCreator.initSkills();

        AC=0;
        initiative=0;
        speed=0;
        proficiencyBonus=0;

        maxHP=0;
        currentHP=0;
        tempHP=0;

        failedDeathSaves=0;
        succesfullDeathSaves=0;

        spellSaveDC=0;
        spellAtackModifier=0;

        toolProf=new ArrayList<>();
        languages=new ArrayList<>();
                      // C S E G P
        coins= new int[]{0,0,0,0,0};
        inventory=new ArrayList<>();

    }



    @Override
    public String toString(){
        StringBuilder returnString= new StringBuilder();
        String border = "\n=========================================================================";

        returnString.append(border);
        returnString.append("\nName:  "+name);
        returnString.append("\nRace:  "+race);
        returnString.append("\nClass: "+playerClass.getNameString());
        returnString.append("\nLevel: "+lvl);

        returnString.append(border);
        returnString.append("\nMax HP:      "+maxHP);
        returnString.append("\nCurrent HP:  "+currentHP);
        returnString.append("\nTemp HP:     "+tempHP+"\n");
        returnString.append("\nFailed Deathsaves:      "+failedDeathSaves);
        returnString.append("\nSuccesfull Deathsaves:  "+succesfullDeathSaves);

        returnString.append(border);
        returnString.append("\n"+abilitiesAndSkillsToString());

        returnString.append(border);
        returnString.append("\nAC:                  "+AC);
        returnString.append("\nInitiative:          "+initiative);
        returnString.append("\nSpeed:               "+speed);
        returnString.append("\nProficiency Bonus:   "+proficiencyBonus);


        returnString.append(border);
        returnString.append("\nSpellsave DC:          "+spellSaveDC);
        returnString.append("\nSpellattack Modifier:  "+spellAtackModifier);

        returnString.append(border);
        returnString.append("\nTool Proficiencies:  \n"+toolProfToString()+"\n");
        returnString.append("\nLanguages known:     \n"+languagesToString());

        returnString.append(border);
        returnString.append("\nCoins:      \n"+coinsToString()+"\n");
        returnString.append("\nInventory:  \n"+inventoryToString());

        returnString.append(border);

        return returnString.toString();
    }

    private String languagesToString() {
        if (languages.size()==0){
            return "No Languages known";
        }

        StringBuilder returnString= new StringBuilder();

        for (String language : languages) {
            returnString.append("\n").append(language);
        }

        return returnString.toString();
    }

    private String inventoryToString() {
        if (inventory.size()==0){
            return "No Items in Inventory";
        }

        StringBuilder returnString= new StringBuilder();

        for (String item : inventory) {
            returnString.append("\n").append(item);
        }

        return returnString.toString();
    }

    private String toolProfToString() {
        if (toolProf.size()==0){
            return "Not proficient with any Tool";
        }

        StringBuilder returnString= new StringBuilder();

        for (String prof : toolProf) {
            returnString.append("\n").append(prof);
        }

        return returnString.toString();
    }

    private String coinsToString() {
        return "Copper:    "+coins[0]+"\nSilver:    "+coins[1]+"\nElectrum:  "+coins[2]+"\nGold:      "+coins[3]+"\nPlatinum:  "+coins[4];
    }

    private String abilitiesAndSkillsToString() {
        StringBuilder returnString= new StringBuilder();


        for (AbilityScore ability : abilities) {
            returnString.append(ability.toString()).append("\n----------");

            for (Skill skill : skills) {
                if(skill.skill.ability == ability.name) returnString.append(("\n")).append(skill.toString());
            }
            returnString.append(("\n\n\n"));
        }

        return returnString.toString();
    }
}
