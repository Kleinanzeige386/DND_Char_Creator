public abstract class subBard extends Subclass{
    subBard(String n){
        super();
        name= n;
    }

    public void lvlUpTo(int n) {
        switch (n) {
            case 3 -> {
                addLVL3Features();
            }
            case 6 -> {
                addLVL6Features();
            }
            case 14 -> {
                addLVL14Features();
            }

        }
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
        owner.playerClass.features.add(Database.Features.NOTE_OF_POTENTIAL.feature);
        owner.playerClass.features.add(Database.Features.PERFORMANCE_OF_CREATION.feature);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.ANIMATING_PERFORMANCE.feature);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.CREATIVE_CRESVENDO.feature);
    }
}



class Eloquence extends subBard{

    Eloquence() {
        super("College of Eloquence");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.SILVER_TONGUE.feature);
        owner.playerClass.features.add(Database.Features.UNSETTLING_WORDS.feature);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.UNFAILING_INSPIRATION.feature);
        owner.playerClass.features.add(Database.Features.UNIVERSAL_SPEECH.feature);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.INFECTIOUS_INSPIRATION.feature);
    }
}



class Glamour extends subBard{

    Glamour() {
        super("College of Glamour");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.MANTLE_OF_INSPIRATION.feature);
        owner.playerClass.features.add(Database.Features.ENTHRALLING_PERFORMANCE.feature);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.MANTLE_OF_MAJESTY.feature);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.UNBREAKABLE_MAJESTY.feature);
    }
}



class Lore extends subBard{

    Lore() {
        super("College of Lore");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.LORE_BARD_BONUS_PROFICIENCIES.feature);
        owner.playerClass.features.add(Database.Features.CUTTING_WORDS.feature);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.ADDITIONAL_MAGICAL_SECRETS.feature);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.PEERLESS_SKILL.feature);
    }
}



class Spirits extends subBard{

    Spirits() {
        super("College of Spirits");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.GUIDING_WHISPERS.feature);
        owner.playerClass.features.add(Database.Features.SPIRITUAL_FOCUS.feature);
        owner.playerClass.features.add(Database.Features.TALES_FROM_BEYOND.feature);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.SPIRIT_SESSION.feature);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.MYSTICAL_CONNECTION.feature);
    }
}



class Swords extends subBard{

    Swords() {
        super("College of Swords");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.SWORDS_BARD_BONUS_PROFICIENCIES.feature);
        owner.playerClass.features.add(Database.Features.SWORDS_BARD_FIGHTING_STYLE.feature);
        owner.playerClass.features.add(Database.Features.BLADE_FLOURISH.feature);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.BARD_EXTRA_ATTACK.feature);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.MASTERS_FLOURISH.feature);
    }
}



class Valor extends subBard{

    Valor() {
        super("College of Valor");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.VALOR_BARD_BONUS_PROFICIENCIES.feature);
        owner.playerClass.features.add(Database.Features.COMBAT_INSPIRATION.feature);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.BARD_EXTRA_ATTACK.feature);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.BATTLE_MAGIC.feature);
    }
}



class Whispers extends subBard{

    Whispers() {
        super("College of Whispers");
    }

    @Override
    void addLVL3Features() {
        owner.playerClass.features.add(Database.Features.PSYCHIC_BLADES.feature);
        owner.playerClass.features.add(Database.Features.WORDS_OF_TERROR.feature);
    }

    @Override
    void addLVL6Features() {
        owner.playerClass.features.add(Database.Features.MANTLE_OF_WHISPERS.feature);
    }

    @Override
    void addLVL14Features() {
        owner.playerClass.features.add(Database.Features.SHADOW_LORE.feature);
    }
}
