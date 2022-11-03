public abstract class subFighters extends Subclass {
    subFighters(Player owner) {
        super(owner);
    }

    public void lvlUpTo(int n) {
        switch (n) {
            case 3 -> addLVL3Features();
            case 7 -> addLVL7Features();
            case 10 -> addLVL10Features();
            case 15 -> addLVL15Features();
            case 18 -> addLVL18Features();
        }
    }

    protected abstract void addLVL3Features();
    protected abstract void addLVL7Features();
    protected abstract void addLVL10Features();
    protected abstract void addLVL15Features();
    protected abstract void addLVL18Features();
}



class Arcane_Archer extends subFighters{
    String name ="Arcane Archer";

    Arcane_Archer(Player owner) {
        super(owner);
    }


    @Override
    protected void addLVL3Features() {
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



class Banneret extends subFighters{

    public Banneret (Player owner) {
        super(owner);
    }

    @Override
    public void lvlUpTo(int n) {

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



class Battle_Master extends subFighters{

    public Battle_Master (Player owner) {
        super(owner);
    }

    @Override
    public void lvlUpTo(int n) {

    }
}



class  Cavalier extends subFighters{

    public Cavalier(Player owner) {
        super(owner);
    }

    @Override
    public void lvlUpTo(int n) {

    }
}



class Champion extends subFighters{

    public Champion(Player owner) {
        super(owner);
    }

    @Override
    public void lvlUpTo(int n) {

    }
}



class Echo_Knight extends subFighters{

    public Echo_Knight(Player owner) {
        super(owner);
    }

    @Override
    public void lvlUpTo(int n) {

    }
}

class Eldritch_Knight extends subFighters{

    public Eldritch_Knight(Player owner) {
        super(owner);
    }

    @Override
    public void lvlUpTo(int n) {

    }
}



class Psi_Warrior extends subFighters{

    public Psi_Warrior(Player owner) {
        super(owner);
    }

    @Override
    public void lvlUpTo(int n) {

    }
}



class Rune_Knight extends subFighters{

    public Rune_Knight(Player owner) {
        super(owner);

    }

    @Override
    public void lvlUpTo(int n) {

    }
}



class Samurai extends subFighters{

    public Samurai(Player owner) {
        super(owner);
    }

    @Override
    public void lvlUpTo(int n) {

    }
}