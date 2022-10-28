


import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class PlayerClass {
    public Player owner;
    public int classLvl;
    public String name;
    public int hitDie;
    public ArrayList<Ability> savingThrowProf;
    public ArrayList<Skills> skillProf;
    public ArrayList<String> toolProf;

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
        returnString.append("\nSaving Throw Proficiencies: \n -");
        returnString.append(String.join(savingThrowProf.stream().map(Object::toString)
                .collect(Collectors.joining("\n\n"))));
        returnString.append("\nSkill Proficiencies: \n -");
        returnString.append(String.join(skillProf.stream().map(Object::toString)
                .collect(Collectors.joining("\n\n"))));
        returnString.append("\nTool Proficiencies: \n -");
        returnString.append(String.join(toolProf.stream().map(Object::toString)
                .collect(Collectors.joining("\n\n"))));
        returnString.append("\n\nFeatures: \n -");
        returnString.append(String.join(features.stream().map(Object::toString)
                .collect(Collectors.joining("\n\n"))));

        return returnString.toString();
    }

    public abstract void lvlUp();
    public abstract void lvlUPTo(int newLVl);

    protected void abilityScoreImprovement() {
        //TODO Add abilityScoreImporvement()
    }

    public String getNameString() {
        return name;
    }
}

class Fighter extends PlayerClass{
    public PlayerClass subclass;

    public Fighter(Player owner) {
        super(owner);
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
