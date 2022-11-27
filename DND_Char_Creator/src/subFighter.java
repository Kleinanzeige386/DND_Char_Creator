
public abstract class subFighter extends Subclass {
    subFighter(String n ) {
        super(n,"");
    }

    public void lvlUpTo(int n) {

        switch (n) {
            case 3 -> addLVL3Features();
            case 7 -> addLVL7Features();
            case 10 -> addLVL10Features();
            case 15 -> addLVL15Features();
            case 18 -> addLVL18Features();
        }
        if(this instanceof Magical){  ((Magical) this).magicalLvlUpTo(n);}
    }

    protected abstract void addLVL3Features();
    protected abstract void addLVL7Features();
    protected abstract void addLVL10Features();
    protected abstract void addLVL15Features();
    protected abstract void addLVL18Features();
}



class Arcane_Archer extends subFighter{


    Arcane_Archer() {
        super("Arcane_Archer");
    }


    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.ARCANE_ARCHER_LORE);
        owner.playerClass.addFeature(Database.Features.ARCANE_SHOT);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.MAGIC_ARROW);
        owner.playerClass.addFeature(Database.Features.CURVING_SHOT);
    }

    @Override
    protected void addLVL10Features() {}

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.EVER_READY_SHOT);
    }

    @Override
    protected void addLVL18Features() {}


}



class Banneret extends subFighter{

    public Banneret () {
        super("Banneret");
    }



    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.RALLYING_CRY);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.ROYAL_ENVOY);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.INSPIRING_SURGE);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.BULWARK);
    }

    @Override
    protected void addLVL18Features() {

    }
}



class Battle_Master extends subFighter{

    public Battle_Master () {
        super("Battle Master");
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.COMBAT_SUPERIORITY);
        owner.playerClass.addFeature(Database.Features.STUDENT_OF_WAR);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.KNOW_YOUR_ENEMY);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.IMPROVED_COMBAT_SUPERIORITY);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.RELENTLESS);
    }

    @Override
    protected void addLVL18Features() {

    }
}



class  Cavalier extends subFighter{

    public Cavalier() {
        super("Cavalier");
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.CAVALIER_BONUS_PROFICIENCY);
        owner.playerClass.addFeature(Database.Features.BORN_TO_SADLE);
        owner.playerClass.addFeature(Database.Features.UNWAVERING_MARK);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.WARDING_MANEUVER);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.HOLD_THE_LINE);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.FEROCIOUS_CHARGER);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.addFeature(Database.Features.VIGILANT_DEFENDER);
    }


}



class Champion extends subFighter{

    public Champion() {
        super("Champion");
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.IMPROVED_CRITICAL);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.REMARKABLE_ATHLETE);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.ADDITIONAL_FIGHTING_STYLE);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.SUPERIOR_CRITICAL);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.addFeature(Database.Features.SURVIVOR);
    }


}



class Echo_Knight extends subFighter{

    public Echo_Knight() {
        super("Echo_Knight");
    }


    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.MANIFEST_ECHO);
        owner.playerClass.addFeature(Database.Features.UNLEASH_INCARNATION);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.ECHO_AVATAR);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.SHADOW_MARTYR);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.RECLAIM_POTENTIAL);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.addFeature(Database.Features.LEGION_OF_ONE);
    }
}



class Eldritch_Knight extends subFighter implements Magical{
    private int[] spellSlots;

    public Eldritch_Knight() {
        super("Eldritch_Knight");
        this.spellSlots = new int[10];
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.ELDKN_SPELLCASTING);
        owner.playerClass.addFeature(Database.Features.WEAPON_BOND);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.WAR_MAGIC);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.ELDRITCH_STRIKE);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.ARCANE_CHARGE);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.addFeature(Database.Features.IMPROVED_WAR_MAGIC);
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
        switch(level) {
            case 3  -> spellSlots = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 4, 6, 5 -> spellSlots = new int[]{2, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 7, 8, 9 -> spellSlots = new int[]{2, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 10, 11, 12 -> spellSlots = new int[]{3, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 13, 14, 15 -> spellSlots = new int[]{3, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 16, 17, 18 -> spellSlots = new int[]{3, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 19, 20 -> spellSlots = new int[]{3, 4, 3, 3, 1, 0, 0, 0, 0, 0};


        }


    }
}



class Psi_Warrior extends subFighter{

    public Psi_Warrior() {
        super("Psi_Warrior");
    }



    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.PSIONIC_POWER);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.TELEKINETIC_ADEPT);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.GUARDED_MIND);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.BULWARK_OF_FORCE);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.addFeature(Database.Features.TELEKINETIC_MASTER);
    }
}



class Rune_Knight extends subFighter{
    public Rune_Knight() {
        super("Rune Knight");
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.RUNE_KNIGHT_BONUS_PROFICIENCY);
        owner.playerClass.addFeature(Database.Features.RUNE_CARVER);
        owner.playerClass.addFeature(Database.Features.GIANT_MIGHT);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.RUNIC_SHIELD);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.GREAT_STATURE);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.MASTER_OF_RUNES);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.addFeature(Database.Features.RUNIC_JUGGERNAUT);
    }


}



class Samurai extends subFighter{
    public Samurai() {
        super("Samurai");
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.SAMURAI_BONUS_PROFICIENCY);
        owner.playerClass.addFeature(Database.Features.FIGHTING_SPIRIT);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.addFeature(Database.Features.ELEGANT_COURTIER);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.TIRELESS_SPIRIT);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.addFeature(Database.Features.RAPID_STRIKE);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.addFeature(Database.Features.STRENGTH_BEFORE_DEATH);
    }


}