public abstract class subBard extends Subclass{
    subBard(String n){
        super(n,"College of ");

    }

    public void lvlUpTo(int n) {
        switch (n) {
            case 3 -> addLVL3Features();
            case 6 -> addLVL6Features();
            case 14 -> addLVL14Features();

        }
        if(this instanceof Magical){  ((Magical) this).magicalLvlUpTo(n);}
    }

    abstract void addLVL3Features();
    abstract void addLVL6Features();
    abstract void addLVL14Features();

}

class Creation extends subBard{

    Creation() {
        super("College of Creation");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.NOTE_OF_POTENTIAL);
        owner.playerClass.addFeature(Database.Features.PERFORMANCE_OF_CREATION);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.ANIMATING_PERFORMANCE);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.CREATIVE_CRESVENDO);
    }
}



class Eloquence extends subBard{

    Eloquence() {
        super("College of Eloquence");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.SILVER_TONGUE);
        owner.playerClass.addFeature(Database.Features.UNSETTLING_WORDS);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.UNFAILING_INSPIRATION);
        owner.playerClass.addFeature(Database.Features.UNIVERSAL_SPEECH);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.INFECTIOUS_INSPIRATION);
    }
}



class Glamour extends subBard{

    Glamour() {
        super("College of Glamour");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.MANTLE_OF_INSPIRATION);
        owner.playerClass.addFeature(Database.Features.ENTHRALLING_PERFORMANCE);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.MANTLE_OF_MAJESTY);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.UNBREAKABLE_MAJESTY);
    }
}



class Lore extends subBard{

    Lore() {
        super("College of Lore");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.LORE_BARD_BONUS_PROFICIENCIES);
        owner.playerClass.addFeature(Database.Features.CUTTING_WORDS);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.ADDITIONAL_MAGICAL_SECRETS);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.PEERLESS_SKILL);
    }
}



class Spirits extends subBard{

    Spirits() {
        super("College of Spirits");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.GUIDING_WHISPERS);
        owner.playerClass.addFeature(Database.Features.SPIRITUAL_FOCUS);
        owner.playerClass.addFeature(Database.Features.TALES_FROM_BEYOND);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.SPIRIT_SESSION);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.MYSTICAL_CONNECTION);
    }
}



class Swords extends subBard{

    Swords() {
        super("College of Swords");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.SWORDS_BARD_BONUS_PROFICIENCIES);
        owner.playerClass.addFeature(Database.Features.SWORDS_BARD_FIGHTING_STYLE);
        owner.playerClass.addFeature(Database.Features.BLADE_FLOURISH);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.BARD_EXTRA_ATTACK);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.MASTERS_FLOURISH);
    }
}



class Valor extends subBard{

    Valor() {
        super("College of Valor");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.VALOR_BARD_BONUS_PROFICIENCIES);
        owner.playerClass.addFeature(Database.Features.COMBAT_INSPIRATION);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.BARD_EXTRA_ATTACK);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.BATTLE_MAGIC);
    }
}


//Why git no getting this?
class Whispers extends subBard{

    Whispers() {
        super("College of Whispers");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.addFeature(Database.Features.PSYCHIC_BLADES);
        owner.playerClass.addFeature(Database.Features.WORDS_OF_TERROR);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.addFeature(Database.Features.MANTLE_OF_WHISPERS);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.addFeature(Database.Features.SHADOW_LORE);
    }
}
