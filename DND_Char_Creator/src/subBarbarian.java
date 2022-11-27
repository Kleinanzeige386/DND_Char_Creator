public abstract class subBarbarian extends Subclass{


    public subBarbarian(String n) {
        super(n, "Path of ");
    }

    public void lvlUpTo(int n){

        switch(n){
            case 3 -> addLVL3Features();
            case 6 -> addLVL6Features();
            case 10 -> addLVL10Features();
            case 14 -> addLVL14Features();
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
        super("Ancestral_Guardian");
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.ANCESTRAL_PROTECTORS);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.SPIRIT_SHIELD);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.CONSULT_THE_SPIRITS);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.VENGEFUL_ANCESTORS);
    }
}



class Battlerager extends subBarbarian{

    Battlerager(){
        super("Battlerager");
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.BATTLERAGER_ARMOR);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.RECKLESS_ABANDON);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.BATTLERAGER_CHARGE);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.SPIKED_RETRIBUTION);
    }
}



class Beast extends subBarbarian{

    Beast(){
        super("Beast");
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.FORM_OF_THE_BEAST);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.BESTIAL_SOUL);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.INFECTIOUS_FURY);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.CALL_THE_HUNT);
    }
}



class Berserker extends subBarbarian{

    Berserker(){
        super("Berserker");
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.FRENZY);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.MINDLESS_RAGE);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.INTIMIDATING_PRESENCE);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.RETALIATION);
    }
}



class Storm_Herald extends subBarbarian{

    Storm_Herald(){
        super("Storm_Herald");
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.STORM_AURA);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.STORM_SOUL);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.SHIELDING_STORM);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.RAGING_STORM);
    }
}



class Totem_Warrior extends subBarbarian{
    Totem_Warrior(){
        super("Totem Warrior");
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.SPIRIT_SEEKER);
        owner.playerClass.addFeature(Database.Features.TOTEM_SPIRIT);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.ASPECT_OF_THE_BEAST);
    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.SPIRIT_WALKER);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.TOTEMIC_ATTUNEMENT);
    }
}



class Wild_Magic extends subBarbarian{

    Wild_Magic(){
        super("Wild Magic");
    }

    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.MAGIC_AWARENESS);
        owner.playerClass.addFeature(Database.Features.WILD_SURGE);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.BOLSTERING_MAGIC);

    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.UNSTABLE_BACKLASH);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.CONTROLLED_SURGE);
    }
}



class Zealot extends subBarbarian{

    Zealot(){
        super("Zealot");
    }
    @Override
    protected void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.DIVINE_FURY);
        owner.playerClass.addFeature(Database.Features.WARRIOR_OF_GOD);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.FANATICAL_FOCUS);

    }

    @Override
    protected void addLVL10Features() {
        owner.playerClass.addFeature(Database.Features.ZEALOUS_PRESENCE);
    }

    @Override
    protected void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.RAGE_BEYOND_DEATH);
    }
}