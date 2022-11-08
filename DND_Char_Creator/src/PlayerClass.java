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
    public ArrayList<Subclass> possibleSubclasses;
    public ArrayList<Feature> features;
    public ArrayList<String> equipment;
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
        possibleSubclasses = new ArrayList<>();
        initPossibleSubclasses();

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

    public abstract void lvlUp();
    public void lvlUPTo(int newLVl) {
        for (int i=classLvl; i<newLVl; i++){
            lvlUp();
        }
    }

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

    public void chooseSubclass(){
        this.subclass = (Subclass) IOManager.getArrayElement(Prompts.chooseSubclass.text,possibleSubclasses.toArray());
    }

    public abstract void initPossibleSubclasses();
}



class Barbarian extends PlayerClass{
    public int rages;
    public Barbarian() {
        super();
        name = "Barbarian";
        rages=0;
        hitDie = 12;
        savingThrowProf.add(Ability.STRENGTH);
        savingThrowProf.add(Ability.CONSTITUTION);
        possibleSkills= new Skills[]{Skills.ANIMAL_HANDLING,Skills.ATHLETICS,Skills.INTIMIDATION,Skills.NATURE,Skills.PERCEPTION,Skills.SURVIVAL};
        skillProf = (ArrayList<Skills>) Arrays.asList(new Skills[]{chooseSkill(),chooseSkill()});
    }

    @Override
    public void lvlUp(){
        classLvl++;

        switch (classLvl) {
            case 1 -> {
                features.add(Database.Features.RAGE.feature);
                features.add(Database.Features.BARBARIAN_UNARMORED_DEFENSE.feature);
            }
            case 2 ->{
                features.add(Database.Features.RECKLESS_ATTACK.feature);
                features.add(Database.Features.DANGER_SENSE.feature);
            }
            case 3 -> {
                chooseSubclass();
            }
            case 4, 8, 12, 16, 19 -> {
                abilityScoreImprovement();
            }
            case 5 -> {
                features.add(Database.Features.BARBARIAN_EXTRA_ATTACK.feature);
                features.add(Database.Features.FAST_MOVEMENT.feature);
            }
            case 6, 10, 14 -> {
                subclass.lvlUpTo(classLvl);
            }
            case 7 -> {
                features.add(Database.Features.FERAL_INSTINCT.feature);
            }
            case 9 -> {
                features.add(Database.Features.BRUTAL_CRITICAL.feature);
            }
            case 11 -> {
                features.add(Database.Features.RELENTLESS_RAGE.feature);
            }
            case 13, 17 -> {/* Already added at lvl 9 */}
            case 15 -> {
                features.add(Database.Features.PERSISTENT_RAGE.feature);
            }
            case 18 -> {
                features.add(Database.Features.INDOMITABLE_MIGHT.feature);
            }
            case 20 -> {
                features.add(Database.Features.PRIMAL_CHAMPION.feature);
            }
        }
    }


    @Override
    public void initPossibleSubclasses() {
        possibleSubclasses.add(new Ancestral_Guardian());
        possibleSubclasses.add(new Battlerager());
        possibleSubclasses.add(new Beast());
        possibleSubclasses.add(new Berserker());
        possibleSubclasses.add(new Storm_Herald());
        possibleSubclasses.add(new Totem_Warrior());
        possibleSubclasses.add(new Wild_Magic());
        possibleSubclasses.add(new Zealot());
    }


}



class Bard extends PlayerClass implements Magical{
    private int[] spellSlots;

    Bard() {
        super();
        name="Bard";
        hitDie = 8;
        this.spellSlots = new int[10];
        toolProf.add("Three musical instruments");
        savingThrowProf.add(Ability.DEXTERITY);
        savingThrowProf.add(Ability.CHARISMA);
        possibleSkills= Skills.values();
        skillProf = (ArrayList<Skills>) Arrays.asList(new Skills[]{chooseSkill(),chooseSkill(),chooseSkill()});

    }


    @Override
    public Ability getcastingAbility() {
        return Ability.CHARISMA;
    }

    @Override
    public int[] getSpellSlots() {
        return spellSlots;
    }

    @Override
    public void magicalLvlUpTo(int level) {
        switch (level) {
            case 1 -> {
                spellSlots = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            }
            case 2 -> {
                spellSlots = new int[]{2, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            }
            case 3 -> {
                spellSlots = new int[]{2, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            }
            case 4 -> {
                spellSlots = new int[]{3, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            }
            case 5 -> {
                spellSlots = new int[]{3, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            }
            case 6 -> {
                spellSlots = new int[]{3, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            }
            case 7 -> {
                spellSlots = new int[]{3, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            }
            case 8 -> {
                spellSlots = new int[]{3, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            }
            case 9 -> {
                spellSlots = new int[]{3, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            }
            case 10 -> {
                spellSlots = new int[]{4, 4, 3, 3, 3, 2, 0, 0, 0, 0};
            }
            case 11, 12 -> {
                spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            }
            case 13, 14 -> {
                spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 0, 0};
            }
            case 15, 16 -> {
                spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            }
            case 17 -> {
                spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 1, 1};
            }
            case 18 -> {
                spellSlots = new int[]{4, 4, 3, 3, 3, 3, 1, 1, 1, 1};
            }
            case 19 -> {
                spellSlots = new int[]{4, 4, 3, 3, 3, 3, 2, 1, 1, 1};
            }
            case 20 -> {
                spellSlots = new int[]{4, 4, 3, 3, 3, 3, 2, 2, 1, 1};
            }
        }

    }

    @Override
    public void lvlUp() {
        classLvl++;

        switch (classLvl) {
            case 1 ->{features.add(Database.Features.BARDIC_INSPIRATION.feature);
            }
            case 2 ->{
                features.add(Database.Features.JACK_OF_ALL_TRADES.feature);
                features.add(Database.Features.SONG_OF_REST.feature);
            }
            case 3 ->{
                chooseSubclass();
                subclass.lvlUpTo(classLvl);
                features.add(Database.Features.EXPERTISE.feature);
            }
            case 4,8,12,16,19 ->abilityScoreImprovement();
            case 5 ->features.add(Database.Features.FONT_OF_INSPIRATION.feature);
            case 6 ->{features.add(Database.Features.COUNTERCHARM.feature);subclass.lvlUpTo(classLvl);}
            case 10 ->features.add(Database.Features.MAGICAL_SECRETS.feature);
            case 14 ->{subclass.lvlUpTo(classLvl);
            }
            case 20 ->features.add(Database.Features.SUPERIOR_INSPIRATION.feature);
        }
        magicalLvlUpTo(classLvl);
    }

    @Override
    public void initPossibleSubclasses() {

    }
}


/*
class Cleric extends PlayerClass{

}



class Druid extends PlayerClass{

}


*/
class Fighter extends PlayerClass{

    public Fighter() {
        super();
        name = "Fighter";
        hitDie = 10;
        savingThrowProf.add(Ability.STRENGTH);
        savingThrowProf.add(Ability.CONSTITUTION);
        possibleSkills= new Skills[]{Skills.ACROBATICS,Skills.ANIMAL_HANDLING,Skills.ATHLETICS,Skills.HISTORY,Skills.INSIGHT,Skills.INTIMIDATION,Skills.PERCEPTION,Skills.SURVIVAL};
        skillProf = (ArrayList<Skills>) Arrays.asList(new Skills[]{chooseSkill(),chooseSkill()});
    }




    @Override
    public void lvlUp(){
        classLvl++;

        //TODO Add Martial Versatility Option to all Ability Score Lvls
        switch (classLvl){
            case 1  -> {features.add(Database.Features.FIGHTING_STYLE.feature);  features.add(Database.Features.SECOND_WIND.feature);
            }
            case 2 -> {
                features.add(Database.Features.ACTION_SURGE.feature);
            }
            case 3 -> {
                chooseSubclass();
            }
            case 4, 19, 16, 14, 12, 8, 6 -> {
                abilityScoreImprovement();
            }
            case 5 -> {
                features.add(Database.Features.FIGHTER_EXTRA_ATTACK.feature);
            }
            case 7, 15, 10, 18 -> {
                subclass.lvlUpTo(classLvl);
            }
            case 9 -> {
                features.add(Database.Features.INDOMITABLE.feature);
            }
            case 11, 20, 17, 13 -> {/* Already added at lvl 5 */}
            /* Already added at lvl 9 */
            /* Already added at lvl 2 and 9 */
        }

    }


    @Override
    public void initPossibleSubclasses() {
        possibleSubclasses.add(new Arcane_Archer());
        possibleSubclasses.add(new Banneret());
        possibleSubclasses.add(new Battle_Master());
        possibleSubclasses.add(new Cavalier());
        possibleSubclasses.add(new Champion());
        possibleSubclasses.add(new Echo_Knight());
        possibleSubclasses.add(new Eldritch_Knight());
        possibleSubclasses.add(new Psi_Warrior());
        possibleSubclasses.add(new Rune_Knight());
        possibleSubclasses.add(new Samurai());
    }
}


/*
class Monk extends PlayerClass{

}



class Paladin extends PlayerClass{

}



class Ranger extends PlayerClass{

}



class Rogue extends PlayerClass{

}



class Sorcerer extends PlayerClass{

}



class Warlock extends PlayerClass{

}



class Wizard extends PlayerClass{

}
*/

//Artificer

//Blood Hunter






