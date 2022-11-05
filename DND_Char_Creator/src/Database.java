import java.io.IOException;
import java.util.ArrayList;

public class Database {
    public enum Features {
        //ALL featured features were stolen from wikidot lmao
        DARKVISION("Darkvision","You can see in dim light within 60 feet of you as if it were bright light and in darkness as if it were dim light. You discern colors in that darkness only as shades of gray."),
        FEY_ANCESTRY("Fey Ancestry","You have advantage on saving throws against being charmed, and magic can't put you to sleep."),
        TRANCE("Trance","Elves do not sleep. Instead they meditate deeply, remaining semi-conscious, for 4 hours a day. The Common word for this meditation is \"trance.\" While meditating, you dream after a fashion; such dreams are actually mental exercises that have become reflexive after years of practice. After resting in this way, you gain the same benefit a human would from 8 hours of sleep."),
        BREATH_WEAPON("Breath Weapon" ,"You can use your action to exhale destructive energy. It deals damage in an area according to your ancestry. When you use your breath weapon, all creatures in the area must make a saving throw, the type of which is determined by your ancestry. The DC of this saving throw is 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increase to 3d6 at 6th level, 4d6 at 11th, and 5d6 at 16th level. After using your breath weapon, you cannot use it again until you complete a short or long rest." ),
        DRAGON_BORN_RESISTANCE("Damage Resistance" ,"You have resistance to the damage type associated with your ancestry." ),
        DRACONIC_ANCESTRY("Draconic Ancestry","You are distantly related to a particular kind of dragon. Choose a type of dragon from the below list; this determines the damage and area of your breath weapon, and the type of resistance you gain."),
        FIGHTING_STYLE("Fighting Style", """
                You adopt a particular style of fighting as your specialty. Choose one of the following options. You can't take a Fighting Style option more than once, even if you later get to choose again.
                Archery. You gain a +2 bonus to attack rolls you make with ranged weapons.
                Blind Fighting. You have blindsight with a range of 10 feet. Within that range, you can effectively see anything that isn't behind total cover, even if you're blinded or in darkness. Moreover, you can see an invisible creature within that range, unless the creature successfully hides from you.
                Defense. While you are wearing armor, you gain a +1 bonus to AC.
                Dueling. When you are wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls with that weapon.
                Great Weapon Fighting. When you roll a 1 or 2 on a damage die for an attack you make with a melee weapon that you are wielding with two hands, you can reroll the die and must use the new roll, even if the new roll is a 1 or a 2. The weapon must have the two-handed or versatile property for you to gain this benefit.
                Interception. When a creature you can see hits a target, other than you, within 5 feet of you with an attack, you can use your reaction to reduce the damage the target takes by 1d10 + your proficiency bonus (to a minimum of 0 damage). You must be wielding a shield or a simple or martial weapon to use this reaction.
                Protection. When a creature you can see attacks a target other than you that is within 5 feet of you, you can use your reaction to impose disadvantage on the attack roll. You must be wielding a shield.
                Superior Technique. You learn one maneuver of your choice from among those available to the Battle Master archetype. If a maneuver you use requires your target to make a saving throw to resist the maneuver's effects, the saving throw DC equals 8 + your proficiency bonus + your Strength or Dexterity modifier (your choice.)
                You gain one superiority die, which is a d6 (this die is added to any superiority dice you have from another source). This die is used to fuel your maneuvers. A superiority die is expended when you use it. You regain your expended superiority dice when you finish a short or long rest.
                Thrown Weapon Fighting. You can draw a weapon that has the thrown property as part of the attack you make with the weapon.
                In addition, when you hit with a ranged attack using a thrown weapon, you gain a +2 bonus to the damage roll.
                Two-Weapon Fighting. When you engage in two-weapon fighting, you can add your ability modifier to the damage of the second attack.
                Unarmed Fighting. Your unarmed strikes can deal bludgeoning damage equal to 1d6 + your Strength modifier on a hit. If you aren't wielding any weapons or a shield when you make the attack roll, the d6 becomes a d8.
                At the start of each of your turns, you can deal 1d4 bludgeoning damage to one creature grappled by you."""),
        SECOND_WIND("Second Wind", """
                You have a limited well of stamina that you can draw on to protect yourself from harm. On your turn, you can use a bonus action to regain hit points equal to 1d10 + your fighter level.

                Once you use this feature, you must finish a short or long rest before you can use it again"""),
        ACTION_SURGE("Action Surge", """
                Starting at 2nd level, you can push yourself beyond your normal limits for a moment. On your turn, you can take one additional action.

                Once you use this feature, you must finish a short or long rest before you can use it again. Starting at 17th level, you can use it twice before a rest, but only once on the same turn."""),
        EXTRA_ATTACK("Extra Attack", """
                Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.

                The number of attacks increases to three when you reach 11th level in this class and to four when you reach 20th level in this class"""),
        INDOMITABLE("Indomitable", """
                Beginning at 9th level, you can reroll a saving throw that you fail. If you do so, you must use the new roll, and you can't use this feature again until you finish a long rest.

                You can use this feature twice between long rests starting at 13th level and three times between long rests starting at 17th level."""),
        ARCANE_ARCHER_LORE("Arcane Archer Lore","At 3rd level, you learn magical theory or some of the secrets of nature – typical for practitioners of of this elven martial tradition. You choose to gain proficiency in either the Arcana or the Nature skill, and you choose to learn either the Prestidigitation or Druidcraft cantrip." ),
        ARCANE_SHOT("Arcane Shot", """
                At 3rd level, you learn to unleash special magical effects with some of your shots. When you gain this feature, you learn two Arcane Shot options of your choice (see "Arcane Shot Options" below).

                Once per turn when you fire an arrow from a shortbow or longbow as part of the Attack action, you can apply one of your Arcane Shot options to that arrow. You decide to use the option when the arrow hits, unless the option doesn’t involve an attack roll. You have two uses of this ability, and you regain all expended uses of it when you finish a short or long rest.

                You gain an additional Arcane Shot option of your choice when you reach certain levels in this class: 7th, 10th, 15th, and 18th level. Each option also improves when you become an 18th-level fighter."""),
        MAGIC_ARROW("Magic Arrow","At 7th level, you gain the ability to infuse arrows with magic. Whenever you fire a nonmagical arrow from a shortbow or longbow, you can make it magical for the purpose of overcoming resistance and immunity to nonmagical attacks and damage. The magic fades from the arrow immediately after it hits or misses its target."),
        CURVING_SHOT("Curving Shot","At 7th level, you learn how to direct an errant arrow toward a new target. When you make an attack roll with a magic arrow and miss, you can use a bonus action to reroll the attack roll against a different target within 60 feet of the original target." ),
        EVER_READY_SHOT("Ever-Ready Shot","Starting at 15th level, your magical archery is available whenever battle starts. If you roll initiative and have no uses of Arcane Shot remaining, you regain one use of it." ), 
        RALLYING_CRY("Rallying Cry", """
                When you choose this archetype at 3rd level, you learn how to inspire your allies to fight on past their injuries.

                When you use your Second Wind feature, you can choose up to three creatures within 60 feet of you that are allied with you. Each one regains hit points equal to your fighter level, provided that the creature can see or hear you."""),
        ROYAL_ENVOY("Royal Envoy", """
                Knights of high standing are expected to conduct themselves with grace.

                At 7th level, you gain proficiency in the Persuasion skill. If you are already proficient in it, you gain proficiency in one of the following skills of your choice: Animal Handling, Insight, Intimidation, or Performance.

                Your proficiency bonus is doubled for any ability check you make that uses Persuasion. You receive this benefit regardless of the skill proficiency you gain from this feature."""),
        INSPIRING_SURGE("Inspiring Surge", """
                Starting at 10th level, when you use your Action Surge feature, you can choose one creature within 60 feet of you that is allied with you. That creature can make one melee or ranged weapon attack with its reaction, provided that it can see or hear you.

                Starting at 18th level, you can choose two allies within 60 feet of you, rather than one."""),
        BULWARK("Bulwark","Beginning at 15th level, you can extend the benefit of your Indomitable feature to an ally. When you decide to use Indomitable to reroll an Intelligence, a Wisdom, or a Charisma saving throw and you aren't incapacitated, you can choose one ally within 60 feet of you that also failed its saving throw against the same effect. If that creature can see or hear you, it can reroll its saving throw and must use the new roll." ),
        COMBAT_SUPERIORITY("Combat Superiority", """
                When you choose this archetype at 3rd level, you learn maneuvers that are fueled by special dice called superiority dice.

                Maneuvers. You learn three maneuvers of your choice. Many maneuvers enhance an attack in some way. You can use only one maneuver per attack. You learn two additional maneuvers of your choice at 7th, 10th, and 15th level. Each time you learn new maneuvers, you can also replace one maneuver you know with a different one.

                Superiority Dice. You have four superiority dice, which are d8s. A superiority die is expended when you use it. You regain all of your expended superiority dice when you finish a short or long rest. You gain another superiority die at 7th level and one more at 15th level.

                Saving Throws. Some of your maneuvers require your target to make a saving throw to resist the maneuver's effects. The saving throw DC is calculated as follows:

                Maneuver save DC = 8 + your proficiency bonus + your Strength or Dexterity modifier (your choice)"""),
        STUDENT_OF_WAR("Student of War","At 3rd level, you gain proficiency with one type of artisan's tools of your choice." ),
        KNOW_YOUR_ENEMY("Know your Enemy", """
                Starting at 7th level, if you spend at least 1 minute observing or interacting with another creature outside combat, you can learn certain information about its capabilities compared to your own. The DM tells you if the creature is your equal, superior, or inferior in regard to two of the following characteristics of your choice:

                Strength score
                Dexterity score
                Constitution score
                Armor Class
                Current hit points
                Total class levels, if any
                Fighter class levels, if any"""),
        IMPROVED_COMBAT_SUPERIORITY("Improved Combat Superiority","At 10th level, your superiority dice turn into d10s. At 18th level, they turn into d12s." ),
        RELENTLESS("Relentless","Starting at 15th level, when you roll initiative and have no superiority dice remaining, you regain 1 superiority die."), 
        CAVALIER_BONUS_PROFICIENCY("Bonus Proficiency","When you choose this archetype at 3rd level, you gain proficiency in one of the following skills of your choice: Animal Handling, History, Insight, Performance, or Persuasion. Alternatively, you learn one language of your choice." ),
        BORN_TO_SADLE("Born to the Saddle", """
                Starting at 3rd level, your mastery as a rider becomes apparent. You have advantage on saving throws made to avoid falling off your mount. If you fall off your mount and descend no more than 10 feet, you can land on your feet if you’re not incapacitated.

                Finally, mounting or dismounting a creature costs you only 5 feet of movement, rather than half your speed."""),
        UNWAVERING_MARK("Unwavering Mark", """
                Starting at 3rd level, you can menace your foes, foiling their attacks and punishing them for harming others. When you hit a creature with a melee weapon attack, you can mark the creature until the end of your next turn. This effect ends early if you are incapacitated or you die, or if someone else marks the creature.

                While it is within 5 feet of you, a creature marked by you has disadvantage on any attack roll that doesn't target you.

                In addition, if a creature marked by you deals damage to anyone other than you, you can make a special melee weapon attack against the marked creature as a bonus action on your next turn. You have advantage on the attack roll, and if it hits, the attack's weapon deals extra damage to the target equal to half your fighter level.

                Regardless of the number of creatures you mark, you can make this special attack a number of times equal to your Strength modifier (a minimum of once), and you regain all expended uses of it when you finish a long rest."""),
        WARDING_MANEUVER("Warding Maneuver", """
                At 7th level, you learn to fend off strikes directed at you, your mount, or other creatures nearby. If you or a creature you can see within 5 feet of you is hit by an attack, you can roll 1d8 as a reaction if you're wielding a melee weapon or a shield. Roll the die, and add the number rolled to the target's AC against that attack. If the attack still hits, the target has resistance against the attack's damage.

                You can use this feature a number of times equal to your Constitution modifier (a minimum of once), and you regain all expended uses of it when you finish a long rest."""),
        HOLD_THE_LINE("Hold the Line","At 10th level, you become a master of locking down your enemies. Creatures provoke an opportunity attack from you when they move 5 feet or more while within your reach, and if you hit a creature with an opportunity attack, the target's speed is reduced to 0 until the end of the current turn." ),
        FEROCIOUS_CHARGER("Ferocious Charger","Starting at 15th level, you can run down your foes, whether you're mounted or not. If you move at least 10 feet in a straight line right before attacking a creature and you hit it with the attack, that target must succeed on a Strength saving throw (DC 8 + your proficiency bonus + your Strength modifier) or be knocked prone. You can use this feature only once on each of your turns." ),
        VIGILANT_DEFENDER("Vigilant Defender","Starting at 18th level, you respond to danger with extraordinary vigilance. In combat, you get a special reaction that you can take once on every creature's turn, except your turn. You can use this special reaction only to make an opportunity attack, and you can't use it on the same turn that you take your normal reaction." ), 
        IMPROVED_CRITICAL("Improved Critical","Beginning when you choose this archetype at 3rd level, your weapon attacks score a critical hit on a roll of 19 or 20." ),
        REMARKABLE_ATHLETE("Remarkable Athlete", """
                Starting at 7th level, you can add half your proficiency bonus (rounded up) to any Strength, Dexterity, or Constitution check you make that doesn't already use your proficiency bonus.

                In addition, when you make a running long jump, the distance you can cover increases by a number of feet equal to your Strength modifier."""),
        ADDITIONAL_FIGHTING_STYLE("Additional Fighting Style","At 10th level, you can choose a second option from the Fighting Style class feature" ),
        SUPERIOR_CRITICAL("Superior Critical","Starting at 15th level, your weapon attacks score a critical hit on a roll of 18-20." ),
        SURVIVOR("Survivor","At 18th level, you attain the pinnacle of resilience in battle. At the start of each of your turns, you regain hit points equal to 5 + your Constitution modifier if you have no more than half of your hit points left. You don't gain this benefit if you have 0 hit points." ),
        MANIFEST_ECHO("Manifest Echo", """
                At 3rd level, you can use a bonus action to magically manifest an echo of yourself in an unoccupied space you can see within 15 feet of you. This echo is a magical, translucent, gray image of you that lasts until it is destroyed, until you dismiss it as a bonus action, until you manifest another echo, or until you're incapacitated.

                Your echo has AC 14 + your proficiency bonus, 1 hit point, and immunity to all conditions. If it has to make a saving throw, it uses your saving throw bonus for the roll. It is the same size as you, and it occupies its space. On your turn, you can mentally command the echo to move up to 30 feet in any direction (no action required). If your echo is ever more than 30 feet from you at the end of your turn, it is destroyed.

                As a bonus action, you can teleport, magically swapping places with your echo at a cost of 15 feet of your movement, regardless of the distance between the two of you.
                When you take the Attack action on your turn, any attack you make with that action can originate from your space or the echo's space. You make this choice for each attack.
                When a creature that you can see within 5 feet of your echo moves at least 5 feet away from it, you can use your reaction to make an opportunity attack against that creature as if you were in the echo's space."""),
        UNLEASH_INCARNATION("Unleash Incarnation", """
                At 3rd level, you can heighten your echo's fury. Whenever you take the Attack action, you can make one additional melee attack from the echo's position.

                You can use this feature a number of times equal to your Constitution modifier (a minimum of once). You regain all expended uses when you finish a long rest."""),
        ECHO_AVATAR("Echo Avatar","Starting at 7th level, you can temporarily transfer your consciousness to your echo. As an action, you can see through your echo's eyes and hear through its ears. During this time, you are deafened and blinded. You can sustain this effect for up to 10 minutes, and you can end it at any time (requires no action). While your echo is being used in this way, it can be up to 1,000 feet away from you without being destroyed." ),
        SHADOW_MARTYR("Shadow Martyr", """
                Starting at 10th level, you can make your echo throw itself in front of an attack directed at another creature that you can see. Before the attack roll is made, you can use your reaction to teleport the echo to an unoccupied space within 5 feet of the targeted creature. The attack roll that triggered the reaction is instead made against your echo.

                Once you use this feature, you can't use it again until you finish a short or long rest."""),
        RECLAIM_POTENTIAL("Reclaim Potential", """
                By 15th level, you've learned to absorb the fleeting magic of your echo. When an echo of yours is destroyed by taking damage, you can gain a number of temporary hit points equal to 2d6 + your Constitution modifier, provided you don't already have temporary hit points.

                You can use this feature a number of times equal to your Constitution modifier (a minimum of once). You regain all expended uses when you finish a long rest."""),
        LEGION_OF_ONE("Legion of One", """
                At 18th level, you can use a bonus action to create two echos with your Manifest Echo feature, and these echoes can co-exist. If you try to create a third echo, the previous two echoes are destroyed. Anything you can do from one echo's position can be done from the other's instead.

                In addition, when you roll initiative and have no uses of your Unleash Incarnation feature left, you regain one use of that feature."""),
        ELDKN_SPELLCASTING("Spellcasting", """
                When you reach 3rd level, you augment your martial prowess with the ability to cast spells.

                Cantrips
                You learn two cantrips of your choice from the wizard spell list. You learn an additional wizard cantrip of your choice at 10th level.

                Spell Slots
                The Eldritch Knight Spellcasting table shows how many spell slots you have to cast your wizard spells of 1st level and higher. To cast one of these spells, you must expend a slot of the spell's level or higher. You regain all expended spell slots when you finish a long rest.

                For example, if you know the 1st-level spell Shield and have a 1st-level and a 2nd-level spell slot available, you can cast Shield using either slot.

                Spells Known of 1st Level and Higher
                You know three 1st-level wizard spells of your choice, two of which you must choose from the abjuration and evocation spells on the wizard spell list.

                The Spells Known column of the Eldritch Knight Spellcasting table shows when you learn more wizard spells of 1st level or higher. Each of these spells must be an abjuration or evocation spell of your choice, and must be of a level for which you have spell slots. For instance, when you reach 7th level in this class, you can learn one new spell of 1st or 2nd level.

                The spells you learn at 8th, 14th, and 20th level can come from any school of magic.

                Whenever you gain a level in this class, you can replace one of the wizard spells you know with another spell of your choice from the wizard spell list. The new spell must be of a level for which you have spell slots, and it must be an abjuration or evocation spell, unless you're replacing the spell you gained at 3rd, 8th, 14th, or 20th level from any school of magic.

                Spellcasting Ability
                Intelligence is your spellcasting ability for your wizard spells, since you learn your spells through study and memorization. You use your Intelligence whenever a spell refers to your spellcasting ability. In addition, you use your Intelligence modifier when setting the saving throw DC for a wizard spell you cast and when making an attack roll with one.

                Spell save DC = 8 + your proficiency bonus + your Intelligence modifier

                Spell attack modifier = your proficiency bonus + your Intelligence modifier"""),
        WEAPON_BOND("Weapon Bond", """
                At 3rd level, you learn a ritual that creates a magical bond between yourself and one weapon. You perform the ritual over the course of 1 hour, which can be done during a short rest. The weapon must be within your reach throughout the ritual, at the conclusion of which you touch the weapon and forge the bond.

                Once you have bonded a weapon to yourself, you can't be disarmed of that weapon unless you are incapacitated. If it is on the same plane of existence, you can summon that weapon as a bonus action on your turn, causing it to teleport instantly to your hand.

                You can have up to two bonded weapons, but can summon only one at a time with your bonus action. If you attempt to bond with a third weapon, you must break the bond with one of the other two."""),
        WAR_MAGIC("War Magic","Beginning at 7th level, when you use your action to cast a cantrip, you can make one weapon attack as a bonus action." ),
        ELDRITCH_STRIKE("Eldritch Strike","At 10th level, you learn how to make your weapon strikes undercut a creature's resistance to your spells. When you hit a creature with a weapon attack, that creature has disadvantage on the next saving throw it makes against a spell you cast before the end of your next turn." ),
        ARCANE_CHARGE("Arcane Charge","At 15th level, you gain the ability to teleport up to 30 feet to an unoccupied space you can see when you use your Action Surge. You can teleport before or after the additional action." ),
        IMPROVED_WAR_MAGIC("Improved War Magic","Starting at 18th level, when you use your action to cast a spell, you can make one weapon attack as a bonus action." ),
        PSIONIC_POWER("Psionic Power", """
                At 3rd level, you harbor a wellspring of psionic energy within yourself. This energy is represented by your Psionic Energy dice, which are each a d6. You have a number of these dice equal to twice your proficiency bonus, and they fuel various psionic powers you have, which are detailed below.

                Some of your powers expend the Psionic Energy die they use, as specified in a power's description, and you can't use a power if it requires you to use a die when your dice are all expended. You regain all your expended Psionic Energy dice when you finish a long rest. In addition, as a bonus action, you can regain one expended Psionic Energy die, but you can't do so again until you finish a short or long rest.

                When you reach certain levels in this class, the size of your Psionic Energy dice increases: at 5th level (d8), 11th level (d10), and 17th level (d12).

                The powers below use your Psionic Energy dice.

                Protective Field. When you or another creature you can see within 30 feet of you takes damage, you can use your reaction to expend one Psionic Energy die, roll the die, and reduce the damage taken by the number rolled plus your Intelligence modifier (minimum reduction of 1), as you create a momentary shield of telekinetic force.

                Psionic Strike. You can propel your weapons with psionic force. Once on each of your turns, immediately after you hit a target within 30 feet of you with an attack and deal damage to it with a weapon, you can expend one Psionic Energy die, rolling it and dealing force damage to the target equal to the number rolled plus your Intelligence modifier.

                Telekinetic Movement. You can move an object or a creature with your mind. As an action, you target one loose object that is Large or smaller or one willing creature, other than yourself. If you can see the target and it is within 30 feet of you, you can move it up to 30 feet to an unoccupied space you can see. Alternatively, if it is a Tiny object, you can move it to or from your hand. Either way, you can move the target horizontally, vertically, or both. Once you take this action, you can't do so again until you finish a short or long rest, unless you expend a Psionic Energy die to take it again."""),
        TELEKINETIC_ADEPT("Telekinetic Adept", """
                By the 7th level, You have mastered new ways to use your telekinetic abilities, detailed below.

                Psi-Powered Leap. As a bonus action, you can propel your body with your mind. You gain a flying speed equal to twice your walking speed until the end of the current turn. Once you take this bonus action, you can't do so again until you finish a short or long rest, unless you expend a Psionic Energy die to take it again.

                Telekinetic Thrust. When you deal damage to a target with your Psionic Strike, you can force the target to make a Strength saving throw against a DC equal to 8 + your proficiency bonus + your Intelligence modifier. If the save fails, you can knock the target prone or move it up to 10 feet in any direction horizontally."""),
        GUARDED_MIND("Guarded Mind","Starting at 10th level, the psionic energy flowing through you has bolstered your mind. You have resistance to psychic damage. Moreover, if you start your turn charmed or frightened, you can expend a Psionic Energy die and end every effect on yourself subjecting you to those conditions." ),
        BULWARK_OF_FORCE("Bulwark of Force", """
                At 15th level, you can shield yourself and others with telekinetic force. As a bonus action, you can choose creatures, which can include you, that you can see within 30 feet of you, up to a number of creatures equal to your Intelligence modifier (minimum of one creature). Each of the chosen creatures is protected by half cover for 1 minute or until you're incapacitated.

                Once you take this bonus action, you can't do so again until you finish a long rest, unless you expend a Psionic Energy die to take it again."""),
        TELEKINETIC_MASTER("Telekinetic Master", """
                By 18th level, your ability to move creatures and objects with your mind is matched by few. You can cast the Telekinesis spell, requiring no components, and your spellcasting ability for the spell is Intelligence. On each of your turns while you concentrate on the spell, including the turn when you cast it, you can make one attack with a weapon as a bonus action.

                Once you cast the spell with this feature, you can't do so again until you finish a long rest, unless you expend a Psionic Energy die to cast it again."""),
        RUNE_KNIGHT_BONUS_PROFICIENCY("Bonus Proficiencies","When you choose this archetype at 3rd level, you gain proficiency with smith’s tools, and you learn to speak, read, and write Giant." ), 
        RUNE_CARVER("Rune Carver", """
                Starting at 3rd level, you can use magic runes to enhance your gear. You learn two runes of your choice, from among the runes described below, and each time you gain a level in this class, you can replace one rune you know with a different one from this feature. When you reach certain levels in this class, you learn additional runes, as shown in the Runes Known table.

                Runes Known\t
                Fighter Level\tNumber of Runes
                3rd\t2
                7th\t3
                10th\t4
                15th\t5
                Whenever you finish a long rest, you can touch a number of objects equal to the number of runes you know, and you inscribe a different rune onto each of the objects. To be eligible, an object must be a weapon, a suit of armor, a shield, a piece of jewelry, or something else you can wear or hold in a hand. Your rune remains on an object until you finish a long rest, and an object can bear only one of your runes at a time.

                The following runes are available to you when you learn a rune. If a rune has a level requirement, you must be at least that level in this class to learn the rune. If a rune requires a saving throw, your Rune Magic save DC equals 8 + your proficiency bonus + your Constitution modifier.

                Cloud Rune. This rune emulates the deceptive magic used by some cloud giants. While wearing or carrying an object inscribed with this rune, you have advantage on Dexterity (Sleight of Hand) checks and Charisma (Deception) checks.
                In addition, when you or a creature you can see within 30 feet of you is hit by an attack roll, you can use your reaction to invoke the rune and choose a different creature within 30 feet of you, other than the attacker. The chosen creature becomes the target of the attack, using the same roll. This magic can transfer the attack's effects regardless of the attack's range. Once you invoke this rune, you can't do so again until you finish a short or long rest.
                Fire Rune. This rune's magic channels the masterful craftsmanship of great smiths. While wearing or carrying an object inscribed with this rune, your proficiency bonus is doubled for any ability check you make that uses your proficiency with a tool.
                In addition, when you hit a creature with an attack using a weapon, you can invoke the rune to summon fiery shackles: the target takes an extra 2d6 fire damage, and it must succeed on a Strength saving throw or be restrained for 1 minute. While restrained by the shackles, the target takes 2d6 fire damage at the start of each of its turns. The target can repeat the saving throw at the end of each of its turns, banishing the shackles on a success. Once you invoke this rune, you can't do so again until you finish a short or long rest.
                Frost Rune. This rune's magic evokes the might of those who survive in the wintry wilderness, such as frost giants. While wearing or carrying an object inscribed with this rune, you have advantage on Wisdom (Animal Handling) checks and Charisma (Intimidation) checks.
                In addition, you can invoke the rune as a bonus action to increase your sturdiness. For 10 minutes, you gain a +2 bonus to all ability checks and saving throws that use Strength or Constitution. Once you invoke this rune, you can't do so again until you finish a short or long rest.
                Stone Rune. This rune's magic channels the judiciousness associated with stone giants. While wearing or carrying an object inscribed with this rune, you have advantage on Wisdom (Insight) checks, and you have darkvision out to a range of 120 feet.
                In addition, when a creature you can see ends its turn within 30 feet of you, you can use your reaction to invoke the rune and force the creature to make a Wisdom saving throw. Unless the save succeeds, the creature is charmed by you for 1 minute. While charmed in this way, the creature has a speed of 0 and is incapacitated, descending into a dreamy stupor. The creature repeats the saving throw at the end of each of its turns, ending the effect on a success. Once you invoke this rune, you can't do so again until you finish a short or long rest.
                Hill Rune (7th Level or Higher). This rune's magic bestows a resilience reminiscent of a hill giant. While wearing or carrying an object that bears this rune, you have advantage on saving throws against being poisoned, and you have resistance against poison damage.
                In addition, you can invoke the rune as a bonus action, gaining resistance to bludgeoning, piercing, and slashing damage for 1 minute. Once you invoke this rune, you can't do so again until you finish a short or long rest.
                Storm Rune (7th Level or Higher). Using this rune, you can glimpse the future like a storm giant seer. While wearing or carrying an object inscribed with this rune, you have advantage on Intelligence (Arcana) checks, and you can't be surprised as long as you aren't incapacitated.
                In addition, you can invoke the rune as a bonus action to enter a prophetic state for 1 minute or until you're incapacitated. Until the state ends, when you or another creature you can see within 60 feet of you makes an attack roll, a saving throw, or an ability check, you can use your reaction to cause the roll to have advantage or disadvantage. Once you invoke this rune, you can't do so again until you finish a short or long rest."""),
        GIANT_MIGHT("Giant Might", """
                At 3rd level, you have learned how to imbue yourself with the might of giants. As a bonus action, you magically gain the following benefits, which last for 1 minute:

                If you are smaller than Large, you become Large, along with anything you are wearing. If you lack the room to become Large, your size doesn't change.
                You have advantage on Strength checks and Strength saving throws.
                Once on each of your turns, one of your attacks with a weapon or an unarmed strike can deal an extra 1d6 damage to a target on a hit.
                You can use this feature a number of times equal to your proficiency bonus, and you regain all expended uses of it when you finish a long rest."""),
        RUNIC_SHIELD("Runic Shield", """
                At 7th level, you learn to invoke your rune magic to protect your allies. When another creature you can see within 60 feet of you is hit by an attack roll, you can use your reaction to force the attacker to reroll the d20 and use the new roll.

                You can use this feature a number of times equal to your proficiency bonus, and you regain all expended uses when you finish a long rest."""),
        GREAT_STATURE("Great Stature", """
                By 10th level, the magic of your runes permanently alters you. When you gain this feature, roll 3d4. You grow a number of inches in height equal to the roll.

                Moreover, the extra damage you deal with your Giant's Might feature increases to 1d8."""),
        MASTER_OF_RUNES("Master of Runes","At 15th level, you can invoke each rune you know from your Rune Carver feature twice, rather than once, and you regain all expended uses when you finish a short or long rest." ),
        RUNIC_JUGGERNAUT("Runic Juggernaut","At 18th level, you learn how to amplify your rune-powered transformation. As a result, the extra damage you deal with the Giant's Might feature increases to 1d10. Moreover, when you use that feature, your size can increase to Huge, and while you are that size, your reach increases by 5 feet." ),
        SAMURAI_BONUS_PROFICIENCY("Bonus Proficiency","When you choose this archetype at 3rd level, you gain proficiency in one of the following skills of your choice: History, Insight, Performance, or Persuasion. Alternatively, you learn one language of your choice." ),
        FIGHTING_SPIRIT("Fighting Spirit", """
                Starting at 3rd level, your intensity in battle can shield you and help you strike true. As a bonus action on your turn, you can give yourself advantage on all weapon attack rolls until the end of the current turn. When you do so, you also gain 5 temporary hit points. The number of hit points increases when you reach certain levels in this class, increasing to 10 at 10th level and 15 at 15th level.

                You can use this feature three times. You regain all expended uses of it when you finish a long rest."""),
        ELEGANT_COURTIER("Elegant Courtier", """
                Starting at 7th level, your discipline and attention to detail allow you to excel in social situations. Whenever you make a Charisma (Persuasion) check, you gain a bonus to the check equal to your Wisdom modifier.

                Your self-control also causes you to gain proficiency in Wisdom saving throws. If you already have this proficiency, you instead gain proficiency in Intelligence or Charisma saving throws (your choice)."""),
        TIRELESS_SPIRIT("Tireless Spirit", """
                Starting at 10th level, when you roll initiative and have no uses of Fighting Spirit remaining, you regain one use.

                """),
        RAPID_STRIKE("Rapid Strike","Starting at 15th level, you learn to trade accuracy for swift strikes. If you take the Attack action on your turn and have advantage on an attack roll against against one of the targets, you can forgo the advantage for that roll to make an additional weapon attack against that target, as part of the same action. You can do so no more than once per turn." ),
        STRENGTH_BEFORE_DEATH("Strength before Death", """
                Starting at 18th level, your fighting spirit can delay the grasp of death. If you take damage that reduces you to 0 hit points, you can use your reaction to delay falling unconscious, and you can immediately take an extra turn. While you have 0 hit points during that extra turn, taking damage causes death saving throw failures as normal, and three death saving throw failures can still kill you. When the extra turn ends, you fall unconscious if you still have 0 hit points.

                Once you use this feature, you can’t use it again until you finish a long rest.""");






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
    public static ArrayList<Background> backgrounds;

    public static Player owner;
    
    public static void initDatabase(){
        owner =PlayerCreator.newPlayer;

        races= new ArrayList<>();
        playerClasses= new ArrayList<>();


        initClasses();
        initSubClasses();
        initRaces();
    }



    private static void initRaces(){
        //PHB
        races.add(new Elf());
        races.add(new Dragonborn());

    }

    private static void initClasses() {
        //PHB
        playerClasses.add(new Fighter());
    }

    private static void initSubClasses() {
        //PHB

    }
}
