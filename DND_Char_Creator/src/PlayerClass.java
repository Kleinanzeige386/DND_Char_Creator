import java.util.ArrayList;
import java.util.Arrays;
//TODO  implement Equipment choosing


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

    public abstract void buildClass();
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
    }

    @Override
    public void lvlUp(){


        switch (classLvl) {
            case 1 -> {
                features.add(Database.Features.RAGE.feature);
                features.add(Database.Features.BARBARIAN_UNARMORED_DEFENSE.feature);
            }
            case 2 ->{
                features.add(Database.Features.RECKLESS_ATTACK.feature);
                features.add(Database.Features.DANGER_SENSE.feature);
            }
            case 3 -> chooseSubclass();
            case 4, 8, 12, 16, 19 -> abilityScoreImprovement();
            case 5 -> {
                features.add(Database.Features.BARBARIAN_EXTRA_ATTACK.feature);
                features.add(Database.Features.FAST_MOVEMENT.feature);
            }
            case 6, 10, 14 -> subclass.lvlUpTo(classLvl);
            case 7 -> features.add(Database.Features.FERAL_INSTINCT.feature);
            case 9 -> features.add(Database.Features.BRUTAL_CRITICAL.feature);
            case 11 -> features.add(Database.Features.RELENTLESS_RAGE.feature);
            case 13, 17 -> {/* Already added at lvl 9 */}
            case 15 -> features.add(Database.Features.PERSISTENT_RAGE.feature);
            case 18 -> features.add(Database.Features.INDOMITABLE_MIGHT.feature);
            case 20 -> features.add(Database.Features.PRIMAL_CHAMPION.feature);
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

    @Override
    public void buildClass() {

        skillProf = new ArrayList<>( Arrays.asList(chooseSkill(),chooseSkill()));
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
            case 1 -> features.add(Database.Features.BARDIC_INSPIRATION.feature);
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
            case 14 -> subclass.lvlUpTo(classLvl);
            case 20 ->features.add(Database.Features.SUPERIOR_INSPIRATION.feature);
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
        return new int[0];
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
            case 1  -> {chooseSubclass();}
            case 2  -> {features.add(Database.Features.CHANNEL_DIVINITY.feature);
                        features.add(Database.Features.CHANNEL_DIVINITY_TURNUNDEAD.feature);}
            case 3  -> {}
            case 4  -> {abilityScoreImprovement();}
            case 5  -> {features.add(Database.Features.DESTROY_UNDEAD.feature);}
            case 6  -> {subclass.lvlUpTo(classLvl);}
            case 7  -> {}
            case 8  -> {abilityScoreImprovement();
                        subclass.lvlUpTo(classLvl);}
            case 9  -> {}
            case 10 -> {features.add(Database.Features.DIVINE_INTERVENTION.feature);}
            case 11 -> {}
            case 12 -> {abilityScoreImprovement();}
            case 13 -> {}
            case 14 -> {}
            case 15 -> {}
            case 16 -> {abilityScoreImprovement();}
            case 17 -> {subclass.lvlUpTo(classLvl);}
            case 18 -> {}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {}
        }
    }

    @Override
    public void initPossibleSubclasses() {
        //TODO Implement Subclasses
    }

    @Override
    public void buildClass() {

        skillProf = new ArrayList<>(Arrays.asList(chooseSkill(),chooseSkill()));
    }
}



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

        toolProf = (ArrayList<String>) Arrays.asList(new String[]{"Herbalism Kit", "Light Armor","Medium Armor", "Shields", "Clubs","Daggers","Darts","Javelins","Maces","Quarterstaffs","Scimitars","Sickles","Slings","Spears"});


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
            case 1  -> {features.add(Database.Features.DRUIDIC.feature);}
            case 2  -> {features.add(Database.Features.WILD_SHAPE.feature);
                        chooseSubclass();}
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
            case 18 -> {features.add(Database.Features.DRUID_TIMELESS_BODY.feature);
                        features.add(Database.Features.BEAST_SPELLS.feature);}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {features.add(Database.Features.ARCHDRUID.feature);}
        }
    }

    @Override
    public void initPossibleSubclasses() {
//TODO Implement Subclasses
    }

    @Override
    public void buildClass() {
        skillProf = new ArrayList<>(Arrays.asList(chooseSkill(),chooseSkill()));
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
            case 1  -> {features.add(Database.Features.FIGHTER_FIGHTING_STYLE.feature);  features.add(Database.Features.SECOND_WIND.feature);
            }
            case 2 -> features.add(Database.Features.ACTION_SURGE.feature);
            case 3 -> chooseSubclass();
            case 4, 19, 16, 14, 12, 8, 6 -> abilityScoreImprovement();
            case 5 -> features.add(Database.Features.FIGHTER_EXTRA_ATTACK.feature);
            case 7, 15, 10, 18 -> subclass.lvlUpTo(classLvl);
            case 9 -> features.add(Database.Features.INDOMITABLE.feature);
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

    @Override
    public void buildClass() {
        skillProf = new ArrayList<>(Arrays.asList(chooseSkill(),chooseSkill()));
    }
}



class Monk extends PlayerClass{

    Monk(){
        super();
        name = "Monk";
        hitDie = 8;
        toolProf = (ArrayList<String>) Arrays.asList(new String[]{"Simple Weapons", "Shortswords", "One Artisan's tool","One Musical Instrument"});

        savingThrowProf.add(Ability.STRENGTH);
        savingThrowProf.add(Ability.DEXTERITY);
        possibleSkills= new Skills[]{Skills.ACROBATICS,Skills.ATHLETICS,Skills.HISTORY,Skills.INSIGHT,Skills.RELIGION,Skills.STEALTH};

    }

    @Override
    public void lvlUp() {
        switch (classLvl) {
            case 1  -> {features.add(Database.Features.MONK_UNARMORED_DEFENSE.feature);
                        features.add(Database.Features.MARTIAL_ARTS.feature);}
            case 2  -> {features.add(Database.Features.KI.feature);
                        features.add(Database.Features.UNARMORED_MOVEMENT.feature);}
            case 3  -> {chooseSubclass();
                        features.add(Database.Features.DEFLECT_MISSILES.feature);}
            case 4  -> {abilityScoreImprovement();
                        features.add(Database.Features.SLOW_FALL.feature);}
            case 5  -> {features.add(Database.Features.MONK_EXTRA_ATTACK.feature);
                        features.add(Database.Features.STUNNING_STRIKE.feature);}
            case 6  -> {subclass.lvlUpTo(classLvl);
                        features.add(Database.Features.KI_EMPOWERED_STRIKES.feature);}
            case 7  -> {features.add(Database.Features.EVASION.feature);
                        features.add(Database.Features.STILLNESS_OF_MIND.feature);}
            case 8  -> {abilityScoreImprovement();}
            case 9  -> {}
            case 10 -> {features.add(Database.Features.PURITY_OF_BODY.feature);}
            case 11 -> {subclass.lvlUpTo(classLvl);}
            case 12 -> {abilityScoreImprovement();}
            case 13 -> {features.add(Database.Features.TONGUE_OF_THE_SUN_AND_MOON.feature);}
            case 14 -> {features.add(Database.Features.DIAMOND_SOUL.feature);}
            case 15 -> {features.add(Database.Features.MONK_TIMELESS_BODY.feature);}
            case 16 -> {abilityScoreImprovement();}
            case 17 -> {subclass.lvlUpTo(classLvl);}
            case 18 -> {features.add(Database.Features.EMPTY_BODY.feature);}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {features.add(Database.Features.PERFECT_SELF.feature);}
        }
    }

    @Override
    public void initPossibleSubclasses() {

    }

    @Override
    public void buildClass() {
        skillProf = new ArrayList<>( Arrays.asList(chooseSkill(),chooseSkill()));
    }
}



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

        toolProf = (ArrayList<String>) Arrays.asList(new String[]{"Simple Weapons","Martial Weapons"});

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
            case 1  -> {features.add(Database.Features.DIVINE_SENSE.feature);
                        features.add(Database.Features.LAY_ON_HANDS.feature);}
            case 2  -> {features.add(Database.Features.PALADIN_FIGHTING_STYLE.feature);
                        features.add(Database.Features.DIVINE_SMITE.feature);}
            case 3  -> {chooseSubclass();
                        features.add(Database.Features.DIVINE_HEALTH.feature);}
            case 4  -> {abilityScoreImprovement();}
            case 5  -> {features.add(Database.Features.PALADIN_EXTRA_ATTACK.feature);}
            case 6  -> {features.add(Database.Features.AURA_OF_PROTECTION.feature);}
            case 7  -> {subclass.lvlUpTo(classLvl);}
            case 8  -> {abilityScoreImprovement();}
            case 9  -> {}
            case 10 -> {features.add(Database.Features.AURA_OF_COURAGE.feature);}
            case 11 -> {features.add(Database.Features.IMPROVED_DIVINE_SMITE.feature);}
            case 12 -> {abilityScoreImprovement();}
            case 13 -> {features.add(Database.Features.CLEANSING_TOUCH.feature);}
            case 14 -> {}
            case 15 -> {subclass.lvlUpTo(classLvl);}
            case 16 -> {abilityScoreImprovement();}
            case 17 -> {}
            case 18 -> {}
            case 19 -> {abilityScoreImprovement();}
            case 20 -> {subclass.lvlUpTo(classLvl);}
        }
    }

    @Override
    public void initPossibleSubclasses() {

    }

    @Override
    public void buildClass() {
        skillProf = new ArrayList<>( Arrays.asList(chooseSkill(),chooseSkill()));
    }
}


/*
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






