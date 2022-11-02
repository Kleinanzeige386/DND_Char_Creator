


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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

class Fighter extends PlayerClass{
    public PlayerClass subclass;

    public Fighter(Player owner) {
        super(owner);

        name = "Fighter";
        classLvl = 0;
        hitDie = 10;
        savingThrowProf.add(Ability.STRENGTH);
        savingThrowProf.add(Ability.CONSTITUTION);
        possibleSkills= new Skills[]{Skills.ACROBATICS,Skills.ANIMAL_HANDLING,Skills.ATHLETICS,Skills.HISTORY,Skills.INSIGHT,Skills.INTIMIDATION,Skills.PERCEPTION,Skills.SURVIVAL};

    }

    public void makeClass() throws IOException {
        skillProf = (ArrayList<Skills>) Arrays.asList(new Skills[]{chooseSkill(),chooseSkill()});
    }





    @Override
    public void lvlUp() {
        classLvl++;

        //TODO Add Martial Versatility Option to all Ability Score Lvls
        switch (classLvl){
            case 1  -> {features.add(Database.Features.FIGHTING_STYLE.feature);  features.add(Database.Features.SECOND_WIND.feature);}
            case 2  -> {features.add(Database.Features.ACTION_SURGE.feature);}
            case 3  -> {subclass = chooseSubclass();}
            case 4  -> {abilityScoreImprovement();}
            case 5  -> {features.add(Database.Features.EXTRA_ATTACK.feature);}
            case 6  -> {abilityScoreImprovement();}
            case 7  -> {subclass.lvlUPTo(7);}
            case 8  -> {abilityScoreImprovement();}
            case 9  -> {features.add(Database.Features.INDOMITABLE.feature);}
            case 10 -> {subclass.lvlUPTo(10);}
            case 11 -> {/* Already added at lvl 5 */}
            case 12 -> {abilityScoreImprovement();}
            case 13 -> {/* Already added at lvl 9 */}
            case 14 -> {abilityScoreImprovement();}
            case 15 -> {subclass.lvlUPTo(15);}
            case 16 -> {abilityScoreImprovement();}
            case 17 -> {/* Already added at lvl 2 and 9 */}
            case 18 -> {subclass.lvlUPTo(18);}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {/* Alreasy added at lvl 5 */}
        }

    }

    @Override
    public void lvlUPTo(int newLVl){
        for (int i=classLvl; i<newLVl; i++){
            lvlUp();
        }
    }



    private Fighter chooseSubclass() {
        return new Fighter(this.owner);
    }
}
