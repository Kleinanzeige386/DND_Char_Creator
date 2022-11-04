import java.io.IOException;
import java.util.ArrayList;

public abstract class PlayerClass implements Named {
    public Player owner;
    public int classLvl;
    public String name;
    public int hitDie;
    public ArrayList<Ability> savingThrowProf;
    public ArrayList<Skills> skillProf;
    public ArrayList<String> toolProf;
    public Skills[] possibleSkills;
    public ArrayList<Feature> features;
    public Subclass subclass;


    public PlayerClass() {
        owner = PlayerCreator.newPlayer;
        name = "N.A.";
        classLvl = 0;
        hitDie = 0;
        savingThrowProf = new ArrayList<>();
        skillProf = new ArrayList<>();
        toolProf = new ArrayList<>();
        features = new ArrayList<>();

    }


    public String getName() {
        return name;
    }

    @Override
    public String toString(){

        return name +
                "\n----------" +
                "\nHit Die: " + hitDie +
                "\nSaving Throw Proficiencies:" +
                IOManager.ArrayListToString(savingThrowProf) +
                "\nSkill Proficiencies:" +
                IOManager.ArrayListToString(skillProf) +
                "\nTool Proficiencies:" +
                IOManager.ArrayListToString(toolProf) +
                "\n\nFeatures:" +
                IOManager.ArrayListToString(features);
    }

    public abstract void lvlUp() throws IOException;
    public abstract void lvlUPTo(int newLVl) throws IOException;

    public Skills chooseSkill() {
        return IOManager.getArrayElement(Prompts.ChooseSkill.text,possibleSkills);
    }

    protected void abilityScoreImprovement(){
        int input;
        boolean validInput;

        for(int i = 0; i < 2;i++) {
            do{
                input = IOManager.getArrayIndex("Abilty Score Improvement  LVL:"+classLvl+"\n"+Prompts.ASI.text, PlayerCreator.newPlayer.abilities);
                if(PlayerCreator.newPlayer.abilities[input].amount<20){
                    validInput = true;
                } else{
                    validInput = false;
                    System.out.println("ERROR: Can't increase an Abiltyscore over 20, please choose a different Abilty");
                }
            }
            while(!validInput);
            PlayerCreator.newPlayer.abilities[input].amount += 1;
            PlayerCreator.calculateModifiers();
        }

    }

    public String getNameString() {
        return name;
    }
}

