
public abstract class subFighter extends Subclass {
    subFighter() {

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
        name = "Arcane_Archer";
    }


    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.ARCANE_ARCHER_LORE.feature);
        owner.playerClass.features.add(Database.Features.ARCANE_SHOT.feature);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.MAGIC_ARROW.feature);
        owner.playerClass.features.add(Database.Features.CURVING_SHOT.feature);
    }

    @Override
    protected void addLVL10Features() {}

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.EVER_READY_SHOT.feature);
    }

    @Override
    protected void addLVL18Features() {}


}



class Banneret extends subFighter{

    public Banneret () {
        name= "Banneret";
    }



    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.RALLYING_CRY.feature);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.ROYAL_ENVOY.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.INSPIRING_SURGE.feature);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.BULWARK.feature);
    }

    @Override
    protected void addLVL18Features() {

    }
}



class Battle_Master extends subFighter{

    public Battle_Master () {
        name = "Battle Master";
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.COMBAT_SUPERIORITY.feature);
        owner.playerClass.features.add(Database.Features.STUDENT_OF_WAR.feature);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.KNOW_YOUR_ENEMY.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.IMPROVED_COMBAT_SUPERIORITY.feature);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.RELENTLESS.feature);
    }

    @Override
    protected void addLVL18Features() {

    }
}



class  Cavalier extends subFighter{

    public Cavalier() {
        name = "Cavalier";
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.CAVALIER_BONUS_PROFICIENCY.feature);
        owner.playerClass.features.add(Database.Features.BORN_TO_SADLE.feature);
        owner.playerClass.features.add(Database.Features.UNWAVERING_MARK.feature
        );
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.WARDING_MANEUVER.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.HOLD_THE_LINE.feature);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.FEROCIOUS_CHARGER.feature);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.features.add(Database.Features.VIGILANT_DEFENDER.feature);
    }


}



class Champion extends subFighter{

    public Champion() {
        name= "Champion";
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.IMPROVED_CRITICAL.feature);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.REMARKABLE_ATHLETE.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.ADDITIONAL_FIGHTING_STYLE.feature);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.SUPERIOR_CRITICAL.feature);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.features.add(Database.Features.SURVIVOR.feature);
    }


}



class Echo_Knight extends subFighter{

    public Echo_Knight() {
        name = "Echo_Knight";
    }


    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.MANIFEST_ECHO.feature);
        owner.playerClass.features.add(Database.Features.UNLEASH_INCARNATION.feature);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.ECHO_AVATAR.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.SHADOW_MARTYR.feature);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.RECLAIM_POTENTIAL.feature);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.features.add(Database.Features.LEGION_OF_ONE.feature);
    }
}



class Eldritch_Knight extends subFighter implements Magical{
    private int[] spellSlots;

    public Eldritch_Knight() {
        this.spellSlots = new int[10];
        name = " Eldritch_Knight";
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.ELDKN_SPELLCASTING.feature);
        owner.playerClass.features.add(Database.Features.WEAPON_BOND.feature);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.WAR_MAGIC.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.ELDRITCH_STRIKE.feature);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.ARCANE_CHARGE.feature);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.features.add(Database.Features.IMPROVED_WAR_MAGIC.feature);
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
            case 3  ->spellSlots = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0};
            case 4, 6, 5 ->spellSlots = new int[]{2, 3, 0, 0, 0, 0, 0, 0, 0, 0};
            case 7, 8, 9 ->spellSlots = new int[]{2, 4, 2, 0, 0, 0, 0, 0, 0, 0};
            case 10, 11, 12 ->spellSlots = new int[]{3, 4, 3, 0, 0, 0, 0, 0, 0, 0};
            case 13, 14, 15 ->spellSlots = new int[]{3, 4, 3, 2, 0, 0, 0, 0, 0, 0};
            case 16, 17, 18 ->spellSlots = new int[]{3, 4, 3, 3, 0, 0, 0, 0, 0, 0};
            case 19, 20 ->spellSlots = new int[]{3, 4, 3, 3, 1, 0, 0, 0, 0, 0};


        }


    }
}



class Psi_Warrior extends subFighter{

    public Psi_Warrior() {
        name = "Psi_Warrior";
    }



    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.PSIONIC_POWER.feature);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.TELEKINETIC_ADEPT.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.GUARDED_MIND.feature);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.BULWARK_OF_FORCE.feature);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.features.add(Database.Features.TELEKINETIC_MASTER.feature);
    }
}



class Rune_Knight extends subFighter{
    public Rune_Knight() {
        name= "Rune Knight";
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.RUNE_KNIGHT_BONUS_PROFICIENCY.feature);
        owner.playerClass.features.add(Database.Features.RUNE_CARVER.feature);
        owner.playerClass.features.add(Database.Features.GIANT_MIGHT.feature);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.RUNIC_SHIELD.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.GREAT_STATURE.feature);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.MASTER_OF_RUNES.feature);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.features.add(Database.Features.RUNIC_JUGGERNAUT.feature);
    }


}



class Samurai extends subFighter{
    public Samurai() {
        name = "Samurai";
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.SAMURAI_BONUS_PROFICIENCY.feature);
        owner.playerClass.features.add(Database.Features.FIGHTING_SPIRIT.feature);
    }

    @Override
    protected void addLVL7Features() {
        owner.playerClass.features.add(Database.Features.ELEGANT_COURTIER.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.TIRELESS_SPIRIT.feature);
    }

    @Override
    protected void addLVL15Features() {
        owner.playerClass.features.add(Database.Features.RAPID_STRIKE.feature);
    }

    @Override
    protected void addLVL18Features() {
        owner.playerClass.features.add(Database.Features.STRENGTH_BEFORE_DEATH.feature);
    }


}