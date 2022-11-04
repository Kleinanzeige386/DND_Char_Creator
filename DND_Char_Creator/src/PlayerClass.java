import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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



class Fighter extends PlayerClass{

    public Fighter() {


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
    public void lvlUp() throws IOException {
        classLvl++;

        //TODO Add Martial Versatility Option to all Ability Score Lvls
        switch (classLvl){
            case 1  -> {features.add(Database.Features.FIGHTING_STYLE.feature);  features.add(Database.Features.SECOND_WIND.feature);}
            case 2  -> features.add(Database.Features.ACTION_SURGE.feature);
            case 3  -> subclass = chooseSubclass();
            case 4, 19, 16, 14, 12, 8, 6 -> abilityScoreImprovement();
            case 5  -> features.add(Database.Features.EXTRA_ATTACK.feature);
            case 7, 15, 10, 18 -> subclass.lvlUpTo(classLvl);
            case 9  -> features.add(Database.Features.INDOMITABLE.feature);
            case 11 -> {/* Already added at lvl 5 */}
            case 13 -> {/* Already added at lvl 9 */}
            case 17 -> {/* Already added at lvl 2 and 9 */}
            case 20 -> {/* Alreasy added at lvl 5 */}
        }

    }

    @Override
    public void lvlUPTo(int newLVl) throws IOException {
        for (int i=classLvl; i<newLVl; i++){
            lvlUp();
        }
    }



    private subFighter chooseSubclass() {
        return new Arcane_Archer();
    }
}




