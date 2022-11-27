import java.util.ArrayList;
import java.util.Arrays;
//TODO  implement Equipment choosing
//TODO implement Feature functionalities

public abstract class PlayerClass implements Named {
    public final Player owner;
    public int classLvl;
    public String name;
    public int hitDie;
    public final ArrayList<Ability> savingThrowProf;
    public ArrayList<Skills> skillProf;
    public ArrayList<String> toolProf;
    public Skills[] possibleSkills;
    public final ArrayList<Subclass> possibleSubclasses;
    public final ArrayList<Feature> features;
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
        for (;classLvl<newLVl; classLvl++){
            lvlUp();
            if(this instanceof Magical){  ((Magical) this).magicalLvlUpTo(classLvl);}
        }
    }

    public Skills chooseSkill() {
        int index = IOManager.getArrayIndex(Prompts.ChooseSkill.text,possibleSkills);
        Skills returnSkill = possibleSkills[index];
        IOManager.removeArrayElement(possibleSkills,index);
        return returnSkill;
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
        this.subclass = (Subclass) IOManager.getNamedArrayElement(Prompts.chooseSubclass.text,possibleSubclasses.toArray());
        subclass.lvlUpTo(classLvl);
    }

    public abstract void initPossibleSubclasses();

    public void buildClass(){
        skillProf = new ArrayList<>( Arrays.asList(chooseSkill(),chooseSkill()));
    }

    public void addFeature(Database.Features feat){
        features.add(feat.feature);
        //TODO implement Feature functionalities
        switch(feat){

            default -> {
                break;
            }
        }
    }

}



class Barbarian extends PlayerClass{
    public Barbarian() {
        super();
        name = "Barbarian";

        hitDie = 12;
        savingThrowProf.add(Ability.STRENGTH);
        savingThrowProf.add(Ability.CONSTITUTION);
        possibleSkills= new Skills[]{Skills.ANIMAL_HANDLING,Skills.ATHLETICS,Skills.INTIMIDATION,Skills.NATURE,Skills.PERCEPTION,Skills.SURVIVAL};
    }

    @Override
    public void lvlUp(){


        switch (classLvl) {
            case 1 -> {
                addFeature(Database.Features.RAGE);
                addFeature(Database.Features.BARBARIAN_UNARMORED_DEFENSE);
            }
            case 2 ->{
                addFeature(Database.Features.RECKLESS_ATTACK);
                addFeature(Database.Features.DANGER_SENSE);
            }
            case 3 -> chooseSubclass();
            case 4, 8, 12, 16, 19 -> abilityScoreImprovement();
            case 5 -> {
                addFeature(Database.Features.BARBARIAN_EXTRA_ATTACK);
                addFeature(Database.Features.FAST_MOVEMENT);
            }
            case 6, 10, 14 -> subclass.lvlUpTo(classLvl);
            case 7 -> addFeature(Database.Features.FERAL_INSTINCT);
            case 9 -> addFeature(Database.Features.BRUTAL_CRITICAL);
            case 11 -> addFeature(Database.Features.RELENTLESS_RAGE);
            case 13, 17 -> {/* Already added at lvl 9 */}
            case 15 -> addFeature(Database.Features.PERSISTENT_RAGE);
            case 18 -> addFeature(Database.Features.INDOMITABLE_MIGHT);
            case 20 -> addFeature(Database.Features.PRIMAL_CHAMPION);
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
            case 1 -> spellSlots = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 2 -> spellSlots = new int[]{2, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 3 -> spellSlots = new int[]{2, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 4 -> spellSlots = new int[]{3, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 5 -> spellSlots = new int[]{3, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 6 -> spellSlots = new int[]{3, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 7 -> spellSlots = new int[]{3, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            case 8 -> spellSlots = new int[]{3, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            case 9 -> spellSlots = new int[]{3, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            case 10 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 0, 0, 0, 0};
            case 11, 12 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            case 13, 14 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 0, 0};
            case 15, 16 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 17 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 1, 1};
            case 18 -> spellSlots = new int[]{4, 4, 3, 3, 3, 3, 1, 1, 1, 1};
            case 19 -> spellSlots = new int[]{4, 4, 3, 3, 3, 3, 2, 1, 1, 1};
            case 20 -> spellSlots = new int[]{4, 4, 3, 3, 3, 3, 2, 2, 1, 1};
        }

    }

    @Override
    public void lvlUp() {


        switch (classLvl) {
            case 1 -> addFeature(Database.Features.BARDIC_INSPIRATION);
            case 2 ->{
                addFeature(Database.Features.JACK_OF_ALL_TRADES);
                addFeature(Database.Features.SONG_OF_REST);
            }
            case 3 ->{
                chooseSubclass();
                subclass.lvlUpTo(classLvl);
                addFeature(Database.Features.EXPERTISE);
            }
            case 4,8,12,16,19 ->abilityScoreImprovement();
            case 5 ->addFeature(Database.Features.FONT_OF_INSPIRATION);
            case 6 ->{addFeature(Database.Features.COUNTERCHARM);subclass.lvlUpTo(classLvl);}
            case 10 ->addFeature(Database.Features.MAGICAL_SECRETS);
            case 14 -> subclass.lvlUpTo(classLvl);
            case 20 ->addFeature(Database.Features.SUPERIOR_INSPIRATION);
        }

    }

    @Override
    public void initPossibleSubclasses() {
        possibleSubclasses.add(new Creation());
        possibleSubclasses.add(new Eloquence());
        possibleSubclasses.add(new Glamour());
        possibleSubclasses.add(new Lore());
        possibleSubclasses.add(new Spirits());
        possibleSubclasses.add(new Swords());
        possibleSubclasses.add(new Valor());
        possibleSubclasses.add(new Whispers());
    }

    @Override
    public void buildClass() {

        skillProf = new ArrayList<>(Arrays.asList(chooseSkill(),chooseSkill(),chooseSkill()));
    }
}



@SuppressWarnings("DuplicateBranchesInSwitch")
class Cleric extends PlayerClass implements Magical{
    public int[] spellSlots;

    Cleric(){
        super();
        name="Cleric";
        hitDie = 8;
        this.spellSlots = new int[10];

        savingThrowProf.add(Ability.WISDOM);
        savingThrowProf.add(Ability.CHARISMA);

        possibleSkills= new Skills[]{Skills.HISTORY, Skills.INSIGHT, Skills.MEDICINE, Skills.PERSUASION, Skills.RELIGION};

    }


    @Override
    public Ability getcastingAbility() {
        return Ability.WISDOM;
    }

    @Override
    public int[] getSpellSlots() {
        return spellSlots;
    }

    @Override
    public void magicalLvlUpTo(int level) {
        switch (level) {
            case 1  -> spellSlots = new int[]{3, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 2  -> spellSlots = new int[]{3, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 3  -> spellSlots = new int[]{3, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 4  -> spellSlots = new int[]{4, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 5  -> spellSlots = new int[]{4, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 6  -> spellSlots = new int[]{4, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 7  -> spellSlots = new int[]{4, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            case 8  -> spellSlots = new int[]{4, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            case 9  -> spellSlots = new int[]{4, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            case 10 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 0, 0, 0, 0};
            case 11 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            case 12 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            case 13 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 0, 0};
            case 14 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 0, 0};
            case 15 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 16 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 17 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 1, 1};
            case 18 -> spellSlots = new int[]{5, 4, 3, 3, 3, 3, 1, 1, 1, 1};
            case 19 -> spellSlots = new int[]{5, 4, 3, 3, 3, 3, 2, 1, 1, 1};
            case 20 -> spellSlots = new int[]{5, 4, 3, 3, 3, 3, 2, 2, 1, 1};
        }
    }

    @Override
    public void lvlUp() {


        switch (classLvl) {
            case 1  -> chooseSubclass();
            case 2  -> {subclass.lvlUpTo(classLvl);
                        addFeature(Database.Features.CHANNEL_DIVINITY);
                        addFeature(Database.Features.CHANNEL_DIVINITY_TURNUNDEAD);}
            case 3  -> {}
            case 4  -> abilityScoreImprovement();
            case 5  -> addFeature(Database.Features.DESTROY_UNDEAD);
            case 6  -> subclass.lvlUpTo(classLvl);
            case 7  -> {}
            case 8  -> {abilityScoreImprovement();
                        subclass.lvlUpTo(classLvl);}
            case 9  -> {}
            case 10 -> addFeature(Database.Features.DIVINE_INTERVENTION);
            case 11 -> {}
            case 12 -> abilityScoreImprovement();
            case 13 -> {}
            case 14 -> {}
            case 15 -> {}
            case 16 -> abilityScoreImprovement();
            case 17 -> subclass.lvlUpTo(classLvl);
            case 18 -> {}
            case 19 -> abilityScoreImprovement();
            case 20 -> {}
        }
    }

    @Override
    public void initPossibleSubclasses() {
        //TODO Implement Subclasses
    }


}



@SuppressWarnings("DuplicateBranchesInSwitch")
class Druid extends PlayerClass implements Magical{

    public int[] spellSlots;

    Druid(){
        super();
        name="Druid";
        hitDie = 8;
        this.spellSlots = new int[10];

        savingThrowProf.add(Ability.WISDOM);
        savingThrowProf.add(Ability.INTELLIGENCE);

        possibleSkills= new Skills[]{Skills.ARCANA,Skills.ANIMAL_HANDLING,Skills.INSIGHT,Skills.MEDICINE,Skills.NATURE,Skills.PERCEPTION,Skills.RELIGION,Skills.SURVIVAL};

        toolProf = new ArrayList<>( Arrays.asList("Herbalism Kit", "Light Armor","Medium Armor", "Shields", "Clubs","Daggers","Darts","Javelins","Maces","Quarterstaffs","Scimitars","Sickles","Slings","Spears"));


    }
    @Override
    public Ability getcastingAbility() {
        return Ability.WISDOM;
    }

    @Override
    public int[] getSpellSlots() {
        return spellSlots;
    }

    @Override
    public void magicalLvlUpTo(int level) {
        switch (level) {
            case 1  -> spellSlots = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 2  -> spellSlots = new int[]{2, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 3  -> spellSlots = new int[]{2, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 4  -> spellSlots = new int[]{3, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 5  -> spellSlots = new int[]{3, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 6  -> spellSlots = new int[]{3, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 7  -> spellSlots = new int[]{3, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            case 8  -> spellSlots = new int[]{3, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            case 9  -> spellSlots = new int[]{3, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            case 10 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 0, 0, 0, 0};
            case 11 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            case 12 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            case 13 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 0, 0};
            case 14 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 0, 0};
            case 15 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 16 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 17 -> spellSlots = new int[]{4, 4, 3, 3, 3, 2, 1, 1, 1, 1};
            case 18 -> spellSlots = new int[]{4, 4, 3, 3, 3, 3, 1, 1, 1, 1};
            case 19 -> spellSlots = new int[]{4, 4, 3, 3, 3, 3, 2, 1, 1, 1};
            case 20 -> spellSlots = new int[]{4, 4, 3, 3, 3, 3, 2, 2, 1, 1};
        }
    }

    @Override
    public void lvlUp() {
        switch (classLvl) {
            case 1  -> addFeature(Database.Features.DRUIDIC);
            case 2  -> {addFeature(Database.Features.WILD_SHAPE);
                        chooseSubclass();}
            case 3  -> {}
            case 4  -> abilityScoreImprovement();
            case 5  -> {}
            case 6  -> subclass.lvlUpTo(classLvl);
            case 7  -> {}
            case 8  -> abilityScoreImprovement();
            case 9  -> {}
            case 10 -> subclass.lvlUpTo(classLvl);
            case 11 -> {}
            case 12 -> abilityScoreImprovement();
            case 13 -> {}
            case 14 -> subclass.lvlUpTo(classLvl);
            case 15 -> {}
            case 16 -> abilityScoreImprovement();
            case 17 -> {}
            case 18 -> {addFeature(Database.Features.DRUID_TIMELESS_BODY);
                        addFeature(Database.Features.BEAST_SPELLS);}
            case 19 -> abilityScoreImprovement();
            case 20 -> addFeature(Database.Features.ARCHDRUID);
        }
    }

    @Override
    public void initPossibleSubclasses() {
//TODO Implement Subclasses
    }


}



class Fighter extends PlayerClass{

    public Fighter() {
        super();
        name = "Fighter";
        hitDie = 10;
        savingThrowProf.add(Ability.STRENGTH);
        savingThrowProf.add(Ability.CONSTITUTION);
        possibleSkills= new Skills[]{Skills.ACROBATICS,Skills.ANIMAL_HANDLING,Skills.ATHLETICS,Skills.HISTORY,Skills.INSIGHT,Skills.INTIMIDATION,Skills.PERCEPTION,Skills.SURVIVAL};

    }




    @Override
    public void lvlUp(){


        //TODO Add Martial Versatility Option to all Ability Score Lvls
        switch (classLvl){
            case 1  -> {addFeature(Database.Features.FIGHTER_FIGHTING_STYLE);  addFeature(Database.Features.SECOND_WIND);
            }
            case 2 -> addFeature(Database.Features.ACTION_SURGE);
            case 3 -> chooseSubclass();
            case 4, 19, 16, 14, 12, 8, 6 -> abilityScoreImprovement();
            case 5 -> addFeature(Database.Features.FIGHTER_EXTRA_ATTACK);
            case 7, 15, 10, 18 -> subclass.lvlUpTo(classLvl);
            case 9 -> addFeature(Database.Features.INDOMITABLE);
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



@SuppressWarnings("DuplicateBranchesInSwitch")
class Monk extends PlayerClass{

    Monk(){
        super();
        name = "Monk";
        hitDie = 8;
        toolProf = new ArrayList<>( Arrays.asList("Simple Weapons", "Shortswords", "One Artisan's tool","One Musical Instrument"));

        savingThrowProf.add(Ability.STRENGTH);
        savingThrowProf.add(Ability.DEXTERITY);
        possibleSkills= new Skills[]{Skills.ACROBATICS,Skills.ATHLETICS,Skills.HISTORY,Skills.INSIGHT,Skills.RELIGION,Skills.STEALTH};

    }

    @Override
    public void lvlUp() {
        switch (classLvl) {
            case 1  -> {addFeature(Database.Features.MONK_UNARMORED_DEFENSE);
                        addFeature(Database.Features.MARTIAL_ARTS);}
            case 2  -> {addFeature(Database.Features.KI);
                        addFeature(Database.Features.UNARMORED_MOVEMENT);}
            case 3  -> {chooseSubclass();
                        addFeature(Database.Features.DEFLECT_MISSILES);}
            case 4  -> {abilityScoreImprovement();
                        addFeature(Database.Features.SLOW_FALL);}
            case 5  -> {addFeature(Database.Features.MONK_EXTRA_ATTACK);
                        addFeature(Database.Features.STUNNING_STRIKE);}
            case 6  -> {subclass.lvlUpTo(classLvl);
                        addFeature(Database.Features.KI_EMPOWERED_STRIKES);}
            case 7  -> {addFeature(Database.Features.MONK_EVASION);
                        addFeature(Database.Features.STILLNESS_OF_MIND);}
            case 8  -> abilityScoreImprovement();
            case 9  -> {}
            case 10 -> addFeature(Database.Features.PURITY_OF_BODY);
            case 11 -> subclass.lvlUpTo(classLvl);
            case 12 -> abilityScoreImprovement();
            case 13 -> addFeature(Database.Features.TONGUE_OF_THE_SUN_AND_MOON);
            case 14 -> addFeature(Database.Features.DIAMOND_SOUL);
            case 15 -> addFeature(Database.Features.MONK_TIMELESS_BODY);
            case 16 -> abilityScoreImprovement();
            case 17 -> subclass.lvlUpTo(classLvl);
            case 18 -> addFeature(Database.Features.EMPTY_BODY);
            case 19 -> abilityScoreImprovement();
            case 20 -> addFeature(Database.Features.PERFECT_SELF);
        }
    }

    @Override
    public void initPossibleSubclasses() {

    }


}


@SuppressWarnings({"DuplicateBranchesInSwitch"})
class Paladin extends PlayerClass implements Magical{

    private int[] spellSlots;

    Paladin(){
        super();
        name="Paladin";
        hitDie = 10;
        this.spellSlots = new int[10];

        savingThrowProf.add(Ability.WISDOM);
        savingThrowProf.add(Ability.CHARISMA);

        possibleSkills= new Skills[]{Skills.ATHLETICS,Skills.INSIGHT,Skills.INTIMIDATION,Skills.MEDICINE,Skills.PERSUASION,Skills.RELIGION};

        toolProf = new ArrayList<>( Arrays.asList("Simple Weapons","Martial Weapons"));

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
            case 1  -> spellSlots = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            case 2  -> spellSlots = new int[]{0, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 3  -> spellSlots = new int[]{0, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 4  -> spellSlots = new int[]{0, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 5  -> spellSlots = new int[]{0, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 6  -> spellSlots = new int[]{0, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 7  -> spellSlots = new int[]{0, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 8  -> spellSlots = new int[]{0, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 9  -> spellSlots = new int[]{0, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 10 -> spellSlots = new int[]{0, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 11 -> spellSlots = new int[]{0, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 12 -> spellSlots = new int[]{0, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 13 -> spellSlots = new int[]{0, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            case 14 -> spellSlots = new int[]{0, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            case 15 -> spellSlots = new int[]{0, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            case 16 -> spellSlots = new int[]{0, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            case 17 -> spellSlots = new int[]{0, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            case 18 -> spellSlots = new int[]{0, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            case 19 -> spellSlots = new int[]{0, 4, 3, 3, 3, 2, 0, 0, 0, 0};
            case 20 -> spellSlots = new int[]{0, 4, 3, 3, 3, 2, 0, 0, 0, 0};
        }
    }

    @Override
    public void lvlUp() {
        switch (classLvl) {
            case 1  -> {addFeature(Database.Features.DIVINE_SENSE);
                        addFeature(Database.Features.LAY_ON_HANDS);}
            case 2  -> {addFeature(Database.Features.PALADIN_FIGHTING_STYLE);
                        addFeature(Database.Features.DIVINE_SMITE);}
            case 3  -> {chooseSubclass();
                        addFeature(Database.Features.DIVINE_HEALTH);}
            case 4  -> abilityScoreImprovement();
            case 5  -> addFeature(Database.Features.PALADIN_EXTRA_ATTACK);
            case 6  -> addFeature(Database.Features.AURA_OF_PROTECTION);
            case 7  -> subclass.lvlUpTo(classLvl);
            case 8  -> abilityScoreImprovement();
            case 9  -> {}
            case 10 -> addFeature(Database.Features.AURA_OF_COURAGE);
            case 11 -> addFeature(Database.Features.IMPROVED_DIVINE_SMITE);
            case 12 -> abilityScoreImprovement();
            case 13 -> addFeature(Database.Features.CLEANSING_TOUCH);
            case 14 -> {}
            case 15 -> subclass.lvlUpTo(classLvl);
            case 16 -> abilityScoreImprovement();
            case 17 -> {}
            case 18 -> {}
            case 19 -> abilityScoreImprovement();
            case 20 -> subclass.lvlUpTo(classLvl);
        }
    }

    @Override
    public void initPossibleSubclasses() {

    }

}



@SuppressWarnings({"DuplicateBranchesInSwitch", "RedundantLabeledSwitchRuleCodeBlock"})
class Ranger extends PlayerClass implements Magical{

    private int[] spellSlots;

    Ranger(){
        super();
        name="Ranger";
        hitDie = 10;
        this.spellSlots = new int[10];

        savingThrowProf.add(Ability.STRENGTH);
        savingThrowProf.add(Ability.DEXTERITY);

        possibleSkills= new Skills[]{Skills.ANIMAL_HANDLING,Skills.ATHLETICS,Skills.INSIGHT,Skills.INVESTIGATION,Skills.NATURE,Skills.PERCEPTION,Skills.STEALTH,Skills.SURVIVAL};

        toolProf = new ArrayList<>( Arrays.asList("Simple Weapons","Martial Weapons","Light Armor","Medium Armor","Shields" ));

    }

    @Override
    public Ability getcastingAbility() {
        return Ability.WISDOM;
    }

    @Override
    public int[] getSpellSlots() {
        return spellSlots;
    }


    @Override
    public void magicalLvlUpTo(int level) {
        switch (level) {
            case 1  -> spellSlots = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            case 2  -> spellSlots = new int[]{0, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 3  -> spellSlots = new int[]{0, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 4  -> spellSlots = new int[]{0, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 5  -> spellSlots = new int[]{0, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 6  -> spellSlots = new int[]{0, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 7  -> spellSlots = new int[]{0, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 8  -> spellSlots = new int[]{0, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 9  -> spellSlots = new int[]{0, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 10 -> spellSlots = new int[]{0, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 11 -> spellSlots = new int[]{0, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 12 -> spellSlots = new int[]{0, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 13 -> spellSlots = new int[]{0, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            case 14 -> spellSlots = new int[]{0, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            case 15 -> spellSlots = new int[]{0, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            case 16 -> spellSlots = new int[]{0, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            case 17 -> spellSlots = new int[]{0, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            case 18 -> spellSlots = new int[]{0, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            case 19 -> spellSlots = new int[]{0, 4, 3, 3, 3, 2, 0, 0, 0, 0};
            case 20 -> spellSlots = new int[]{0, 4, 3, 3, 3, 2, 0, 0, 0, 0};
        }
    }

    @Override
    public void lvlUp() {
        switch (classLvl) {
            case 1  -> {addFeature(Database.Features.FAVORED_ENEMY);
                        addFeature(Database.Features.NATURAL_EXPLORER);}
            case 2  -> {addFeature(Database.Features.RANGER_FIGHTING_STYLE);}
            case 3  -> {addFeature(Database.Features.PRIMEVAL_AWARENESS);
                        chooseSubclass();}
            case 4  -> {abilityScoreImprovement();}
            case 5  -> {addFeature(Database.Features.RANGER_EXTRA_ATTACK);}
            case 6  -> {}
            case 7  -> {subclass.lvlUpTo(classLvl);}
            case 8  -> {abilityScoreImprovement();
                        addFeature(Database.Features.LANDS_STRIDE);}
            case 9  -> {}
            case 10 -> {addFeature(Database.Features.HIDE_IN_PLAIN_SIGHT);}
            case 11 -> {subclass.lvlUpTo(classLvl);}
            case 12 -> {abilityScoreImprovement();}
            case 13 -> {}
            case 14 -> {addFeature(Database.Features.VANISH);}
            case 15 -> {subclass.lvlUpTo(classLvl);}
            case 16 -> {abilityScoreImprovement();}
            case 17 -> {}
            case 18 -> {addFeature(Database.Features.FERAL_SENSES);}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {addFeature(Database.Features.FOE_SLAYER);}
        }
    }

    @Override
    public void initPossibleSubclasses() {

    }

    @Override
    public void buildClass() {
        skillProf = new ArrayList<>( Arrays.asList(chooseSkill(),chooseSkill(),chooseSkill()));
    }
}


@SuppressWarnings({"DuplicateBranchesInSwitch", "RedundantLabeledSwitchRuleCodeBlock"})
class Rogue extends PlayerClass{

    Rogue(){
        super();
        name="Rogue";
        hitDie = 8;

        savingThrowProf.add(Ability.INTELLIGENCE);
        savingThrowProf.add(Ability.DEXTERITY);

        possibleSkills= new Skills[]{Skills.ACROBATICS,Skills.ATHLETICS,Skills.DECEPTION,Skills.INSIGHT,Skills.INVESTIGATION,Skills.PERCEPTION,Skills.PERFOMANCE,Skills.PERSUASION,Skills.SLEIGHT_OF_HAND,Skills.STEALTH};

        toolProf = new ArrayList<>( Arrays.asList("Simple Weapons","Hand crossbows","Longswords","Rapiers","Shortswords","Light Armor","Thieves' Tools" ));

    }

    @Override
    public void lvlUp() {
        switch (classLvl) {
            case 1  -> {addFeature(Database.Features.ROGUE_EXPERTISE);
                        addFeature(Database.Features.SNEAK_ATTACK);
                        addFeature(Database.Features.THIEVES_CANT);}
            case 2  -> {addFeature(Database.Features.CUNNING_ACTIONS);}
            case 3  -> {chooseSubclass();}
            case 4  -> {abilityScoreImprovement();}
            case 5  -> {addFeature(Database.Features.UNCANNY_DODGE);}
            case 6  -> {}
            case 7  -> {addFeature(Database.Features.ROGUE_EVASION);}
            case 8  -> {abilityScoreImprovement();}
            case 9  -> {subclass.lvlUpTo(classLvl);}
            case 10 -> {abilityScoreImprovement();}
            case 11 -> {addFeature(Database.Features.RELIABLE_TALENT);}
            case 12 -> {abilityScoreImprovement();}
            case 13 -> {subclass.lvlUpTo(classLvl);}
            case 14 -> {addFeature(Database.Features.BLINDSENSE);}
            case 15 -> {addFeature(Database.Features.SLIPPERY_MIND);}
            case 16 -> {abilityScoreImprovement();}
            case 17 -> {subclass.lvlUpTo(classLvl);}
            case 18 -> {addFeature(Database.Features.ELUSIVE);}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {addFeature(Database.Features.STROKE_OF_LUCK);}
        }
    }

    @Override
    public void initPossibleSubclasses() {

    }

    @Override
    public void buildClass() {
        skillProf = new ArrayList<>( Arrays.asList(chooseSkill(),chooseSkill(),chooseSkill(),chooseSkill()));
    }
}



@SuppressWarnings({"DuplicateBranchesInSwitch", "RedundantLabeledSwitchRuleCodeBlock"})
class Sorcerer extends PlayerClass implements Magical{

    private int[] spellSlots;

    Sorcerer(){
        super();
        name="Sorcerer";
        hitDie = 6;
        this.spellSlots = new int[10];

        savingThrowProf.add(Ability.CONSTITUTION);
        savingThrowProf.add(Ability.CHARISMA);

        possibleSkills= new Skills[]{Skills.ARCANA,Skills.DECEPTION,Skills.INSIGHT,Skills.INTIMIDATION,Skills.PERSUASION,Skills.RELIGION};

        toolProf = new ArrayList<>( Arrays.asList("Daggers","Darts","Slings","Quarterstaffs","Light Crossbows" ));

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
            case 1  -> spellSlots = new int[]{4, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 2  -> spellSlots = new int[]{4, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 3  -> spellSlots = new int[]{4, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 4  -> spellSlots = new int[]{5, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 5  -> spellSlots = new int[]{5, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 6  -> spellSlots = new int[]{5, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 7  -> spellSlots = new int[]{5, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            case 8  -> spellSlots = new int[]{5, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            case 9  -> spellSlots = new int[]{5, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            case 10 -> spellSlots = new int[]{6, 4, 3, 3, 3, 2, 0, 0, 0, 0};
            case 11 -> spellSlots = new int[]{6, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            case 12 -> spellSlots = new int[]{6, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            case 13 -> spellSlots = new int[]{6, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 14 -> spellSlots = new int[]{6, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 15 -> spellSlots = new int[]{6, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 16 -> spellSlots = new int[]{6, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 17 -> spellSlots = new int[]{6, 4, 3, 3, 3, 2, 1, 1, 1, 1};
            case 18 -> spellSlots = new int[]{6, 4, 3, 3, 3, 3, 1, 1, 1, 1};
            case 19 -> spellSlots = new int[]{6, 4, 3, 3, 3, 3, 2, 1, 1, 1};
            case 20 -> spellSlots = new int[]{6, 4, 3, 3, 3, 3, 2, 2, 1, 1};
        }
    }

    @Override
    public void lvlUp() {
        switch (classLvl) {
            case 1  -> {chooseSubclass();}
            case 2  -> {addFeature(Database.Features.FONT_OF_MAGIC);}
            case 3  -> {addFeature(Database.Features.METAMAGIC);}
            case 4  -> {abilityScoreImprovement();}
            case 5  -> {}
            case 6  -> {subclass.lvlUpTo(classLvl);}
            case 7  -> {}
            case 8  -> {abilityScoreImprovement();}
            case 9  -> {}
            case 10 -> {}
            case 11 -> {}
            case 12 -> {abilityScoreImprovement();}
            case 13 -> {}
            case 14 -> {subclass.lvlUpTo(classLvl);}
            case 15 -> {}
            case 16 -> {abilityScoreImprovement();}
            case 17 -> {}
            case 18 -> {subclass.lvlUpTo(classLvl);}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {addFeature(Database.Features.SORCEROUS_RESTORATION);}
        }
    }

    @Override
    public void initPossibleSubclasses() {

    }


}



@SuppressWarnings({"DuplicateBranchesInSwitch", "RedundantLabeledSwitchRuleCodeBlock"})
class Warlock extends PlayerClass implements Magical{

    private int[] spellSlots;

    Warlock(){
        super();
        name="Warlock";
        hitDie = 8;
        this.spellSlots = new int[10];

        savingThrowProf.add(Ability.WISDOM);
        savingThrowProf.add(Ability.CHARISMA);

        possibleSkills= new Skills[]{Skills.ARCANA,Skills.DECEPTION,Skills.HISTORY,Skills.INTIMIDATION,Skills.INVESTIGATION,Skills.NATURE,Skills.RELIGION};

        toolProf = new ArrayList<>( Arrays.asList("Simple Weapons","Light Armor"));

    }

    @Override
    public Ability getcastingAbility() {
        return Ability.CHARISMA ;
    }

    @Override
    public int[] getSpellSlots() {
        return spellSlots;
    }

    @Override
    public void magicalLvlUpTo(int level) {
        switch (level) {
            case 1  -> spellSlots = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0};
            case 2  -> spellSlots = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 3  -> spellSlots = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0};
            case 4  -> spellSlots = new int[]{3, 0, 2, 0, 0, 0, 0, 0, 0, 0};
            case 5  -> spellSlots = new int[]{3, 0, 0, 2, 0, 0, 0, 0, 0, 0};
            case 6  -> spellSlots = new int[]{3, 0, 0, 2, 0, 0, 0, 0, 0, 0};
            case 7  -> spellSlots = new int[]{3, 0, 0, 0, 2, 0, 0, 0, 0, 0};
            case 8  -> spellSlots = new int[]{3, 0, 0, 0, 2, 0, 0, 0, 0, 0};
            case 9  -> spellSlots = new int[]{3, 0, 0, 0, 0, 2, 0, 0, 0, 0};
            case 10 -> spellSlots = new int[]{4, 0, 0, 0, 0, 2, 0, 0, 0, 0};
            case 11 -> spellSlots = new int[]{4, 0, 0, 0, 0, 3, 0, 0, 0, 0};
            case 12 -> spellSlots = new int[]{4, 0, 0, 0, 0, 3, 0, 0, 0, 0};
            case 13 -> spellSlots = new int[]{4, 0, 0, 0, 0, 3, 0, 0, 0, 0};
            case 14 -> spellSlots = new int[]{4, 0, 0, 0, 0, 3, 0, 0, 0, 0};
            case 15 -> spellSlots = new int[]{4, 0, 0, 0, 0, 3, 0, 0, 0, 0};
            case 16 -> spellSlots = new int[]{4, 0, 0, 0, 0, 3, 0, 0, 0, 0};
            case 17 -> spellSlots = new int[]{4, 0, 0, 0, 0, 4, 0, 0, 0, 0};
            case 18 -> spellSlots = new int[]{4, 0, 0, 0, 0, 4, 0, 0, 0, 0};
            case 19 -> spellSlots = new int[]{4, 0, 0, 0, 0, 4, 0, 0, 0, 0};
            case 20 -> spellSlots = new int[]{4, 0, 0, 0, 0, 4, 0, 0, 0, 0};
        }
    }

    @Override
    public void lvlUp() {
        switch (classLvl) {
            case 1  -> {chooseSubclass();}
            case 2  -> {addFeature(Database.Features.ELDRITCH_INVOCTATIONS);}
            case 3  -> {addFeature(Database.Features.PACT_BOON);}
            case 4  -> {abilityScoreImprovement();}
            case 5  -> {}
            case 6  -> {subclass.lvlUpTo(classLvl);}
            case 7  -> {}
            case 8  -> {abilityScoreImprovement();}
            case 9  -> {}
            case 10 -> {subclass.lvlUpTo(classLvl);}
            case 11 -> {addFeature(Database.Features.MYSTIC_ARCANUM);}
            case 12 -> {abilityScoreImprovement();}
            case 13 -> {}
            case 14 -> {subclass.lvlUpTo(classLvl);}
            case 15 -> {}
            case 16 -> {abilityScoreImprovement();}
            case 17 -> {}
            case 18 -> {}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {addFeature(Database.Features.ELDTRICH_MASTER);}
        }
    }

    @Override
    public void initPossibleSubclasses() {

    }

}



@SuppressWarnings({"DuplicateBranchesInSwitch", "RedundantLabeledSwitchRuleCodeBlock"})
class Wizard extends PlayerClass implements Magical{

    private int[] spellSlots;

    Wizard(){
        super();
        name="Wizard";
        hitDie = 6;
        this.spellSlots = new int[10];

        savingThrowProf.add(Ability.WISDOM);
        savingThrowProf.add(Ability.INTELLIGENCE);

        possibleSkills= new Skills[]{Skills.ARCANA,Skills.HISTORY,Skills.INVESTIGATION,Skills.MEDICINE,Skills.RELIGION};

        toolProf = new ArrayList<>( Arrays.asList("Daggers","Darts","Slings","Quarterstaffs","Light Crossbows"));

    }

    @Override
    public Ability getcastingAbility() {
        return Ability.INTELLIGENCE;
    }

    @Override
    public int[] getSpellSlots() {
        return spellSlots;
    }

    @Override
    public void magicalLvlUpTo(int level) {
        switch (level) {
            case 1  -> spellSlots = new int[]{3, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 2  -> spellSlots = new int[]{3, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 3  -> spellSlots = new int[]{3, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 4  -> spellSlots = new int[]{4, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 5  -> spellSlots = new int[]{4, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 6  -> spellSlots = new int[]{4, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 7  -> spellSlots = new int[]{4, 4, 3, 3, 1, 0, 0, 0, 0, 0};
            case 8  -> spellSlots = new int[]{4, 4, 3, 3, 2, 0, 0, 0, 0, 0};
            case 9  -> spellSlots = new int[]{4, 4, 3, 3, 3, 1, 0, 0, 0, 0};
            case 10 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 0, 0, 0, 0};
            case 11 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            case 12 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 0, 0, 0};
            case 13 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 0, 0};
            case 14 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 0, 0};
            case 15 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 16 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 1, 0};
            case 17 -> spellSlots = new int[]{5, 4, 3, 3, 3, 2, 1, 1, 1, 1};
            case 18 -> spellSlots = new int[]{5, 4, 3, 3, 3, 3, 1, 1, 1, 1};
            case 19 -> spellSlots = new int[]{5, 4, 3, 3, 3, 3, 2, 1, 1, 1};
            case 20 -> spellSlots = new int[]{5, 4, 3, 3, 3, 3, 2, 2, 1, 1};
        }
    }

    @Override
    public void lvlUp() {
        switch (classLvl) {
            case 1  -> {addFeature(Database.Features.ARCANE_RECOVERY);}
            case 2  -> {chooseSubclass();}
            case 3  -> {}
            case 4  -> {abilityScoreImprovement();}
            case 5  -> {}
            case 6  -> {subclass.lvlUpTo(classLvl);}
            case 7  -> {}
            case 8  -> {abilityScoreImprovement();}
            case 9  -> {}
            case 10 -> {subclass.lvlUpTo(classLvl);}
            case 11 -> {}
            case 12 -> {abilityScoreImprovement();}
            case 13 -> {}
            case 14 -> {subclass.lvlUpTo(classLvl);}
            case 15 -> {}
            case 16 -> {abilityScoreImprovement();}
            case 17 -> {}
            case 18 -> {addFeature(Database.Features.SPELL_MASTERY);}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {addFeature(Database.Features.SIGNATURE_SPELLS);}
        }
    }

    @Override
    public void initPossibleSubclasses() {

    }
    
}


//Artificer

//Blood Hunter






