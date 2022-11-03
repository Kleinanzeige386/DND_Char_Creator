


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

//TODO Add second toString Method that gives a shorter version instead of the full class description
public abstract class PlayerClass {
    public Player owner;
    public int classLvl;
    public String name;
    public int hitDie;
    public ArrayList<Ability> savingThrowProf;
    public ArrayList<Skills> skillProf;
    public ArrayList<String> toolProf;
    public Skills possibleSkills[];
    public ArrayList<Feature> features;


    public PlayerClass(Player o) {
        owner = o;
        name = "N.A.";
        classLvl = 0;
        hitDie = 0;
        savingThrowProf = new ArrayList<>();
        skillProf = new ArrayList<>();
        toolProf = new ArrayList<>();
        features = new ArrayList<>();

    }



    @Override
    public String toString(){

        StringBuilder returnString = new StringBuilder();

        returnString.append(name);
        returnString.append("\n----------");
        returnString.append("\nHit Die: "+hitDie);
        returnString.append("\nSaving Throw Proficiencies:");
        returnString.append(IOManager.ArrayListToString(savingThrowProf));
        returnString.append("\nSkill Proficiencies:");
        returnString.append(IOManager.ArrayListToString(skillProf));
        returnString.append("\nTool Proficiencies:");
        returnString.append(IOManager.ArrayListToString(toolProf));
        returnString.append("\n\nFeatures:");
        returnString.append(IOManager.ArrayListToString(features));

        return returnString.toString();
    }

    public abstract void lvlUp();
    public abstract void lvlUPTo(int newLVl);

    public Skills chooseSkill() throws IOException {
        return IOManager.getArrayElement(Prompts.ChooseSkill.text,possibleSkills);
    }

    protected void abilityScoreImprovement() {
        //TODO Add abilityScoreImprovement()
    }

    public String getNameString() {
        return name;
    }
}

