public abstract class subCleric extends Subclass    {
    subCleric(String n ) {
        super(n,"Domain");
    }

    public void lvlUpTo(int n) {

        switch (n) {
            case 1 -> addLVL1Features();
            case 2 -> addLVL2Features();
            case 6 -> addLVL6Features();
            case 8 -> addLVL8Features();
            case 17 -> addLVL17Features();
        }
        if(this instanceof Magical){  ((Magical) this).magicalLvlUpTo(n);}
    }



    protected abstract void addLVL1Features();
    protected abstract void addLVL2Features();
    protected abstract void addLVL6Features();
    protected abstract void addLVL8Features();
    protected abstract void addLVL17Features();

}

class Arcana extends subCleric{

    Arcana() {
        super("Arcana");
    }

    @Override
    protected void addLVL1Features() {
        owner.playerClass.addFeature(Database.Features.ARCANE_INITIATE);
    }

    @Override
    protected void addLVL2Features() {
        owner.playerClass.addFeature(Database.Features.CHANNEL_DIVINITY_ARCANE_ABJURATION);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.SPELL_BREAKER);
    }

    @Override
    protected void addLVL8Features() {
        owner.playerClass.addFeature(Database.Features.POTENT_SPELLCASTING);
    }

    @Override
    protected void addLVL17Features() {
        owner.playerClass.addFeature(Database.Features.ARCANE_MASTERY);
    }
}



class Death extends subCleric{

    Death() {
        super("Death");
    }

    @Override
    protected void addLVL1Features() {
        owner.playerClass.addFeature(Database.Features.DEATH_BONUS_PROFICIENCY);
        owner.playerClass.addFeature(Database.Features.REAPER);
    }

    @Override
    protected void addLVL2Features() {
        owner.playerClass.addFeature(Database.Features.CHANNEL_DIVINITY_TOUCH_OF_DEATH);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.INESCAPABLE_DESTRUCTION);
    }

    @Override
    protected void addLVL8Features() {
        owner.playerClass.addFeature(Database.Features.DEATH_DIVINE_STRIKE);
    }

    @Override
    protected void addLVL17Features() {
        owner.playerClass.addFeature(Database.Features.IMPROVED_REAPER);
    }
}



class Forge extends subCleric{

    Forge() {
        super("Forge");
    }

    @Override
    protected void addLVL1Features() {
        owner.playerClass.addFeature(Database.Features.FORGE_BONUS_PROFICIENCIES);
        owner.playerClass.addFeature(Database.Features.BLESSING_OF_THE_FORGE);
    }

    @Override
    protected void addLVL2Features() {
        owner.playerClass.addFeature(Database.Features.CHANNEL_DIVINITY_ARTISANS_BLESSING);
    }

    @Override
    protected void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.SOUL_OF_THE_FORGE);
    }

    @Override
    protected void addLVL8Features() {
        owner.playerClass.addFeature(Database.Features.FORGE_DIVINE_STRIKE);
    }

    @Override
    protected void addLVL17Features() {
        owner.playerClass.addFeature(Database.Features.SAINT_OF_FORGE_AND_FIRE);
    }
}



class Grave extends subCleric{

}



class Knowledge extends subCleric{

}



class Life extends subCleric{

}



class Light extends subCleric{

}



class Nature extends subCleric{

}



class Order extends subCleric{

}



class Peace extends subCleric{

}



class Tempest extends subCleric{

}



class Trickery extends subCleric{

}



class Twilight extends subCleric{

}



class War extends subCleric{

}
