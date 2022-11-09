import java.util.ArrayList;

public class Player {
    public Ability spellcastingAbility;
    public String name;
    public Race race;
    public PlayerClass playerClass;
    public int lvl;
    public Alignment alignment;
    public Background background;


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

    public ArrayList<Feature> features;



    public Player() {
        name="N.A.";
        race=null;
        playerClass=null;
        lvl=0;
        alignment = Alignment.NEUTRAL;

        abilities= PlayerCreator.initAbilities();
        skills=PlayerCreator.initSkills();

        AC=0;
        initiative=0;
        speed=0;
        proficiencyBonus=0;

        maxHP=0;
        currentHP=0;
        tempHP=0;

        spellcastingAbility = null;
        failedDeathSaves=0;
        succesfullDeathSaves=0;

        spellSaveDC=0;
        spellAtackModifier=0;

        toolProf=new ArrayList<>();
        languages=new ArrayList<>();
                      // C S E G P
        coins= new int[]{0,0,0,0,0};
        inventory=new ArrayList<>();

        features = new ArrayList<>();
    }



    @Override
    public String toString(){
        String border = "\n=========================================================================";


        return border +
                "\nName:  " + name +
                "\nRace:  " + race.name +
                "\nClass: " + playerClass.name +
                "\nLevel: " + lvl +
                border +
                "\nMax HP:      " + maxHP +
                "\nCurrent HP:  " + currentHP +
                "\nTemp HP:     " + tempHP + "\n" +
                "\nFailed Deathsaves:      " + failedDeathSaves +
                "\nSuccesfull Deathsaves:  " + succesfullDeathSaves +
                border +
                "\n" + abilitiesAndSkillsToString() +
                border +
                "\nAC:                  " + AC +
                "\nInitiative:          " + initiative +
                "\nSpeed:               " + speed +
                "\nProficiency Bonus:   " + proficiencyBonus +
                border +
                "\nSpellsave DC:          " + spellSaveDC +
                "\nSpellattack Modifier:  " + spellAtackModifier +
                border +
                "\nTool Proficiencies:  \n" + toolProfToString() + "\n" +
                "\nLanguages known:     \n" + languagesToString() +
                border +
                "\nCoins:      \n" + coinsToString() + "\n" +
                "\nInventory:  \n" + inventoryToString() +
                border;
    }

    public String languagesToString() {
        if (languages.size()==0){
            return "No Languages known";
        }

        StringBuilder returnString= new StringBuilder();

        for (String language : languages) {
            returnString.append("\n").append(language);
        }

        return returnString.toString();
    }

    public String inventoryToString() {
        if (inventory.size()==0){
            return "No Items in Inventory";
        }

        StringBuilder returnString= new StringBuilder();

        for (String item : inventory) {
            returnString.append("\n").append(item);
        }

        return returnString.toString();
    }

    public String toolProfToString() {
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
                if(skill.skill.ability == ability.name) returnString.append(("\n")).append(skill);
            }
            returnString.append(("\n\n\n"));
        }




        return returnString.toString();
    }
}
