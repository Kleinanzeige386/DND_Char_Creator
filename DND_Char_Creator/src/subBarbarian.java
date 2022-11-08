public abstract class subBarbarian extends Subclass{
    public void lvlUpTo(int n){
        switch(n){
            case 3 -> {
                addLVL3Features();
            }
            case 6 -> {
                addLVL6Features();
            }
            case 10 -> {
                addLVL10Features();
            }
            case 14 -> {
                addLVL14Features();
            }
        }

        if(this instanceof Magical){  ((Magical) this).magicalLvlUpTo(n);}
    }

    protected abstract void addLVL3Features();
    protected abstract void addLVL6Features();
    protected abstract void addLVL10Features();
    protected abstract void addLVL14Features();

}



class Ancestral_Guardian extends subBarbarian{
    Ancestral_Guardian(){
        name="Ancestral_Guardian";
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.ANCESTRAL_PROTECTORS.feature);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.SPIRIT_SHIELD.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.CONSULT_THE_SPIRITS.feature);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.VENGEFUL_ANCESTORS.feature);
    }
}



class Battlerager extends subBarbarian{

    Battlerager(){
        name = "Battlerager";
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.BATTLERAGER_ARMOR.feature);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.RECKLESS_ABANDON.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.BATTLERAGER_CHARGE.feature);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.SPIKED_RETRIBUTION.feature);
    }
}



class Beast extends subBarbarian{

    Beast(){
        name = "Beast";
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.FORM_OF_THE_BEAST.feature);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.BESTIAL_SOUL.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.INFECTIOUS_FURY.feature);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.CALL_THE_HUNT.feature);
    }
}



class Berserker extends subBarbarian{

    Berserker(){
        name = "Berserker";
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.FRENZY.feature);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.MINDLESS_RAGE.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.INTIMIDATING_PRESENCE.feature);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.RETALIATION.feature);
    }
}



class Storm_Herald extends subBarbarian{

    Storm_Herald(){
        name = "Storm_Herald";
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.STORM_AURA.feature);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.STORM_SOUL.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.SHIELDING_STORM.feature);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.RAGING_STORM.feature);
    }
}



class Totem_Warrior extends subBarbarian{
    Totem_Warrior(){
        name = "Totem Warrior";
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.SPIRIT_SEEKER.feature);
        owner.playerClass.features.add(Database.Features.TOTEM_SPIRIT.feature);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.ASPECT_OF_THE_BEAST.feature);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.SPIRIT_WALKER.feature);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.TOTEMIC_ATTUNEMENT.feature);
    }
}



class Wild_Magic extends subBarbarian{

    Wild_Magic(){
        name= "Wild Magic";
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.MAGIC_AWARENESS.feature);
        owner.playerClass.features.add(Database.Features.WILD_SURGE.feature);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.BOLSTERING_MAGIC.feature);

    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.UNSTABLE_BACKLASH.feature);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.CONTROLLED_SURGE.feature);
    }
}



class Zealot extends subBarbarian{

    Zealot(){
        name= "Zealot";
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.DIVINE_FURY.feature);
        owner.playerClass.features.add(Database.Features.WARRIOR_OF_GOD.feature);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.FANATICAL_FOCUS.feature);

    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.features.add(Database.Features.ZEALOUS_PRESENCE.feature);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.RAGE_BEYOND_DEATH.feature);
    }
}