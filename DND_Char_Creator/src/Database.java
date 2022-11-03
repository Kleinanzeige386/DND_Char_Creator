import java.io.IOException;
import java.util.ArrayList;

public class Database {
    public static enum Features {
        DARKVISION("Darkvision","You can see in dim light within 60 feet of you as if it were bright light and in darkness as if it were dim light. You discern colors in that darkness only as shades of gray."),
        FEY_ANCESTRY("Fey Ancestry","You have advantage on saving throws against being charmed, and magic can't put you to sleep."),
        TRANCE("Trance","Elves do not sleep. Instead they meditate deeply, remaining semi-conscious, for 4 hours a day. The Common word for this meditation is \"trance.\" While meditating, you dream after a fashion; such dreams are actually mental exercises that have become reflexive after years of practice. After resting in this way, you gain the same benefit a human would from 8 hours of sleep."),
        BREATH_WEAPON("Breath Weapon" ,"You can use your action to exhale destructive energy. It deals damage in an area according to your ancestry. When you use your breath weapon, all creatures in the area must make a saving throw, the type of which is determined by your ancestry. The DC of this saving throw is 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increase to 3d6 at 6th level, 4d6 at 11th, and 5d6 at 16th level. After using your breath weapon, you cannot use it again until you complete a short or long rest." ),
        DRAGON_BORN_RESISTANCE("Damage Resistance" ,"You have resistance to the damage type associated with your ancestry." ),
        DRACONIC_ANCESTRY("Draconic Ancestry","You are distantly related to a particular kind of dragon. Choose a type of dragon from the below list; this determines the damage and area of your breath weapon, and the type of resistance you gain."),
        FIGHTING_STYLE("Fighting Style","You adopt a particular style of fighting as your specialty. Choose one of the following options. You can't take a Fighting Style option more than once, even if you later get to choose again." + "\nArchery. You gain a +2 bonus to attack rolls you make with ranged weapons." + "\nBlind Fighting. You have blindsight with a range of 10 feet. Within that range, you can effectively see anything that isn't behind total cover, even if you're blinded or in darkness. Moreover, you can see an invisible creature within that range, unless the creature successfully hides from you." + "\nDefense. While you are wearing armor, you gain a +1 bonus to AC." + "\nDueling. When you are wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls with that weapon." + "\nGreat Weapon Fighting. When you roll a 1 or 2 on a damage die for an attack you make with a melee weapon that you are wielding with two hands, you can reroll the die and must use the new roll, even if the new roll is a 1 or a 2. The weapon must have the two-handed or versatile property for you to gain this benefit." + "\nInterception. When a creature you can see hits a target, other than you, within 5 feet of you with an attack, you can use your reaction to reduce the damage the target takes by 1d10 + your proficiency bonus (to a minimum of 0 damage). You must be wielding a shield or a simple or martial weapon to use this reaction." + "\nProtection. When a creature you can see attacks a target other than you that is within 5 feet of you, you can use your reaction to impose disadvantage on the attack roll. You must be wielding a shield." + "\nSuperior Technique. You learn one maneuver of your choice from among those available to the Battle Master archetype. If a maneuver you use requires your target to make a saving throw to resist the maneuver's effects, the saving throw DC equals 8 + your proficiency bonus + your Strength or Dexterity modifier (your choice.)" + "\nYou gain one superiority die, which is a d6 (this die is added to any superiority dice you have from another source). This die is used to fuel your maneuvers. A superiority die is expended when you use it. You regain your expended superiority dice when you finish a short or long rest." + "\nThrown Weapon Fighting. You can draw a weapon that has the thrown property as part of the attack you make with the weapon." + "\nIn addition, when you hit with a ranged attack using a thrown weapon, you gain a +2 bonus to the damage roll." + "\nTwo-Weapon Fighting. When you engage in two-weapon fighting, you can add your ability modifier to the damage of the second attack." + "\nUnarmed Fighting. Your unarmed strikes can deal bludgeoning damage equal to 1d6 + your Strength modifier on a hit. If you aren't wielding any weapons or a shield when you make the attack roll, the d6 becomes a d8." + "\nAt the start of each of your turns, you can deal 1d4 bludgeoning damage to one creature grappled by you." ),
        SECOND_WIND("Second Wind", "You have a limited well of stamina that you can draw on to protect yourself from harm. On your turn, you can use a bonus action to regain hit points equal to 1d10 + your fighter level.\n" + "\n" + "Once you use this feature, you must finish a short or long rest before you can use it again"),
        ACTION_SURGE("Action Surge","Starting at 2nd level, you can push yourself beyond your normal limits for a moment. On your turn, you can take one additional action.\n" + "\n" + "Once you use this feature, you must finish a short or long rest before you can use it again. Starting at 17th level, you can use it twice before a rest, but only once on the same turn." ),
        EXTRA_ATTACK("Extra Attack","Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.\n" + "\n" + "The number of attacks increases to three when you reach 11th level in this class and to four when you reach 20th level in this class"),
        INDOMITABLE("Indomitable","Beginning at 9th level, you can reroll a saving throw that you fail. If you do so, you must use the new roll, and you can't use this feature again until you finish a long rest.\n" + "\n" + "You can use this feature twice between long rests starting at 13th level and three times between long rests starting at 17th level."),
        ARCANE_ARCHER_LORE("Arcane Archer Lore","At 3rd level, you learn magical theory or some of the secrets of nature – typical for practitioners of of this elven martial tradition. You choose to gain proficiency in either the Arcana or the Nature skill, and you choose to learn either the Prestidigitation or Druidcraft cantrip." ),
        ARCANE_SHOT("Arcane Shot","At 3rd level, you learn to unleash special magical effects with some of your shots. When you gain this feature, you learn two Arcane Shot options of your choice (see \"Arcane Shot Options\" below).\n" + "\n" + "Once per turn when you fire an arrow from a shortbow or longbow as part of the Attack action, you can apply one of your Arcane Shot options to that arrow. You decide to use the option when the arrow hits, unless the option doesn’t involve an attack roll. You have two uses of this ability, and you regain all expended uses of it when you finish a short or long rest.\n" + "\n" + "You gain an additional Arcane Shot option of your choice when you reach certain levels in this class: 7th, 10th, 15th, and 18th level. Each option also improves when you become an 18th-level fighter."),
        MAGIC_ARROW("Magic Arrow","At 7th level, you gain the ability to infuse arrows with magic. Whenever you fire a nonmagical arrow from a shortbow or longbow, you can make it magical for the purpose of overcoming resistance and immunity to nonmagical attacks and damage. The magic fades from the arrow immediately after it hits or misses its target."),
        CURVING_SHOT("Curving Shot","At 7th level, you learn how to direct an errant arrow toward a new target. When you make an attack roll with a magic arrow and miss, you can use a bonus action to reroll the attack roll against a different target within 60 feet of the original target." ),
        EVER_READY_SHOT("Ever-Ready Shot","Starting at 15th level, your magical archery is available whenever battle starts. If you roll initiative and have no uses of Arcane Shot remaining, you regain one use of it." );




        final Feature feature;

        Features(String name, String description) {
            feature = new Feature(name,description);
        }

        @Override
        public String toString(){

            return feature.toString();
        }
    }
    public static ArrayList<Race> races;
    public static ArrayList<PlayerClass> playerClasses;
    public static ArrayList<PlayerClass> subClasses;
    public static Player owner;
    
    public static void initDatabase(Player o) throws IOException {
        owner =o;

        races= new ArrayList<>();
        playerClasses= new ArrayList<>();
        subClasses = new ArrayList<>();

        initClasses();
        initSubClasses();
        initRaces();
    }



    private static void initRaces() throws IOException {
        //PHB
        races.add(new Elf());
        races.add(new Dragonborn());

    }

    private static void initClasses() {
        //PHB
        playerClasses.add(new Fighter(owner));
    }

    private static void initSubClasses() {
        //PHB

    }
}
