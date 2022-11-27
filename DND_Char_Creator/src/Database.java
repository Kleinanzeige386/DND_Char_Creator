import java.util.ArrayList;



public class Database {
    public enum Features {
        DARKVISION("Darkvision","You can see in dim light within 60 feet of you as if it were bright light and in darkness as if it were dim light. You discern colors in that darkness only as shades of gray."),
        FEY_ANCESTRY("Fey Ancestry","You have advantage on saving throws against being charmed, and magic can't put you to sleep."),
        TRANCE("Trance","Elves do not sleep. Instead they meditate deeply, remaining semi-conscious, for 4 hours a day. The Common word for this meditation is \"trance.\" While meditating, you dream after a fashion; such dreams are actually mental exercises that have become reflexive after years of practice. After resting in this way, you gain the same benefit a human would from 8 hours of sleep."),
        BREATH_WEAPON("Breath Weapon" ,"You can use your action to exhale destructive energy. It deals damage in an area according to your ancestry. When you use your breath weapon, all creatures in the area must make a saving throw, the type of which is determined by your ancestry. The DC of this saving throw is 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increase to 3d6 at 6th level, 4d6 at 11th, and 5d6 at 16th level. After using your breath weapon, you cannot use it again until you complete a short or long rest." ),
        DRAGON_BORN_RESISTANCE("Damage Resistance" ,"You have resistance to the damage type associated with your ancestry." ),
        DRACONIC_ANCESTRY("Draconic Ancestry","You are distantly related to a particular kind of dragon. Choose a type of dragon from the below list; this determines the damage and area of your breath weapon, and the type of resistance you gain."),
        FIGHTER_FIGHTING_STYLE("Fighting Style", """
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
        FIGHTER_EXTRA_ATTACK("Extra Attack", """
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

                Once you use this feature, you can’t use it again until you finish a long rest."""),
        RAGE("Rage","""
                In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action.
                
                While raging, you gain the following benefits if you aren't wearing heavy armor:
                
                You have advantage on Strength checks and Strength saving throws.
                When you make a melee weapon attack using Strength, you gain a bonus to the damage roll that increases as you gain levels as a barbarian, as shown in the Rage Damage column of the Barbarian table.
                You have resistance to bludgeoning, piercing, and slashing damage.
                If you are able to cast spells, you can't cast them or concentrate on them while raging.
                
                Your rage lasts for 1 minute. It ends early if you are knocked unconscious or if your turn ends and you haven't attacked a hostile creature since your last turn or taken damage since then. You can also end your rage on your turn as a bonus action.
                
                Once you have raged the number of times shown for your barbarian level in the Rages column of the Barbarian table, you must finish a long rest before you can rage again."""),
        BARBARIAN_UNARMORED_DEFENSE("Unarmored Defense", """
                While you are not wearing any armor, your armor class equals 10 + your Dexterity modifier + your Constitution modifier. You can use a shield and still gain this benefit.""" ),
        RECKLESS_ATTACK("Reckless Attack", """
                Starting at 2nd level, you can throw aside all concern for defense to attack with fierce desperation. When you make your first attack on your turn, you can decide to attack recklessly. Doing so gives you advantage on melee weapon attack rolls using Strength during this turn, but attack rolls against you have advantage until your next turn.""" ),
        DANGER_SENSE("Danger Sense", """
                At 2nd level, you gain an uncanny sense of when things nearby aren't as they should be, giving you an edge when you dodge away from danger. You have advantage on Dexterity saving throws against effects that you can see, such as traps and spells. To gain this benefit, you can't be blinded, deafened, or incapacitated.""" ),
        BARBARIAN_EXTRA_ATTACK("Extra Attack", """
                Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.""" ),
        FAST_MOVEMENT("Fast Movement", """
                Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor.""" ), 
        FERAL_INSTINCT("Feral Instinct", """
                By 7th level, your instincts are so honed that you have advantage on initiative rolls.
                                
                Additionally, if you are surprised at the beginning of combat and aren't incapacitated, you can act normally on your first turn, but only if you enter your rage before doing anything else on that turn.""" ),
        BRUTAL_CRITICAL("Brutal Critical", """
                Beginning at 9th level, you can roll one additional weapon damage die when determining the extra damage for a critical hit with a melee attack.
                                
                This increases to two additional dice at 13th level and three additional dice at 17th level.""" ),
        RELENTLESS_RAGE("Relentless Rage", """
                Starting at 11th level, your rage can keep you fighting despite grievous wounds. If you drop to 0 hit points while you're raging and don't die outright, you can make a DC 10 Constitution saving throw. If you succeed, you drop to 1 hit point instead.
                                
                Each time you use this feature after the first, the DC increases by 5. When you finish a short or long rest, the DC resets to 10.""" ),
        PERSISTENT_RAGE("Persistent Rage", """
                Beginning at 15th level, your rage is so fierce that it ends early only if you fall unconscious or if you choose to end it.""" ),
        INDOMITABLE_MIGHT("Indomitable Might", """
                Beginning at 18th level, if your total for a Strength check is less than your Strength score, you can use that score in place of the total.""" ),
        PRIMAL_CHAMPION("Primal Champion", """
                At 20th level, you embody the power of the wilds. Your Strength and Constitution scores increase by 4. Your maximum for those scores is now 24.""" ),
        ANCESTRAL_PROTECTORS("Ancestral Protectors", """
                Starting when you choose this path at 3rd level, spectral warriors appear when you enter your rage. While you're raging, the first creature you hit with an attack on your turn becomes the target of the warriors, which hinder its attacks. Until the start of your next turn, that target has disadvantage on any attack roll that isn't against you, and when the target hits a creature other than you with an attack, that creature has resistance to the damage dealt by the attack. The effect on the target ends early if your rage ends.""" ),
        SPIRIT_SHIELD("Spirit Shield", """
                Beginning at 6th level, the guardian spirits that aid you can provide supernatural protection to those you defend. If you are raging and another creature you can see within 30 feet of you takes damage, you can use your reaction to reduce that damage by 2d6.
                                
                When you reach certain levels in this class, you can reduce the damage by more: by 3d6 at 10th level and by 4d6 at 14th level.""" ),
        CONSULT_THE_SPIRITS("Consult the Spirits", """
                At 10th level, you gain the ability to consult with your ancestral spirits. When you do so, you cast the Augury or Clairvoyance spell, without using a spell slot or material components. Rather than creating a spherical sensor, this use of clairvoyance invisibly summons one of your ancestral spirits to the chosen location. Wisdom is your spellcasting ability for these spells.
                                
                After you cast either spell in this way, you can't use this feature again until you finish a short or long rest.""" ),
        VENGEFUL_ANCESTORS("Vengeful Ancestors", """
                At 14th level, your ancestral spirits grow powerful enough to retaliate. When you use your Spirit Shield to reduce the damage of an attack, the attacker takes an amount of force damage that your Spirit Shield prevents.""" ),
        
        //SubBarbarian: Battle Rager
        BATTLERAGER_ARMOR("Battlerager Armor", """
                When you choose this path at 3rd level, you gain the ability to use spiked armor as a weapon.
                                
                While you are wearing spiked armor and are raging, you can use a bonus action to make one melee weapon attack with your armor spikes against a target within 5 feet of you. If the attack hits, the spikes deal 1d4 piercing damage. You use your Strength modifier for the attack and damage rolls.
                                
                Additionally, when you use the Attack action to grapple a creature, the target takes 3 piercing damage if your grapple check succeeds.""" ),
        RECKLESS_ABANDON("Reckless Abandon", """
                Beginning at 6th level, when you use Reckless Attack while raging, you also gain temporary hit points equal to your Constitution modifier (minimum of 1). They vanish if any of them are left when your rage ends.""" ), 
        BATTLERAGER_CHARGE("Battlerager Charge", """
                Beginning at 10th level, you can take the Dash action as a bonus action while you are raging.""" ),
        SPIKED_RETRIBUTION("Spiked Retribution", """
                Starting at 14th level, when a creature within 5 feet of you hits you with a melee attack, the attacker takes 3 piercing damage if you are raging, aren't incapacitated, and are wearing spiked armor.""" ), 
        
        //SubBarbarian: Beast
        FORM_OF_THE_BEAST("Form of the Beast", """
                Starting when you choose this path at 3rd level, when you enter your rage, you can transform, revealing the bestial power within you. Until the rage ends, you manifest a natural weapon. It counts as a simple melee weapon for you, and you add your Strength modifier to the attack and damage rolls when you attack with it, as normal.
                                
                You choose the weapon’s form each time you rage:
                                
                Bite. Your mouth transforms into a bestial muzzle or great mandibles (your choice). It deals 1d8 piercing damage on a hit. Once on each of your turns when you damage a creature with this bite, you regain a number of hit points equal to your proficiency bonus, provided you have less than half your hit points when you hit.
                                
                Claws. Each of your hands transforms into a claw, which you can use as a weapon if it’s empty. It deals 1d6 slashing damage on a hit. Once on each of your turns when you attack with a claw using the Attack action, you can make one additional claw attack as part of the same action.
                                
                Tail. You grow a lashing, spiny tail, which deals 1d8 piercing damage on a hit and has the reach property. If a creature you can see within 10 feet of you hits you with an attack roll, you can use your reaction to swipe your tail and roll a d8, applying a bonus to your AC equal to the number rolled, potentially causing the attack to miss you.""" ),
        BESTIAL_SOUL("Bestial Soul", """
                Beginning at 6th level, the feral power within you increases, causing the natural weapons of your Form of the Beast to count as magical for the purpose of overcoming resistance and immunity to nonmagical attacks and damage.
                                
                You can also alter your form to help you adapt to your surroundings. When you finish a short or long rest, choose one of the following benefits, which lasts until you finish a short or long rest:
                                
                You gain a swimming speed equal to your walking speed, and you can breathe underwater.
                You gain a climbing speed equal to your walking speed, and you can climb difficult surfaces, including upside down on ceilings, without needing to make an ability check.
                When you jump, you can make a Strength (Athletics) check and extend your jump by a number of feet equal to the check’s total. You can make this special check only once per turn.""" ),
        INFECTIOUS_FURY("Infectious Fury", """
                At 10th level, when you hit a creature with your natural weapons while you are raging, the beast within you can curse your target with rabid fury. The target must succeed on a Wisdom saving throw (DC equal to 8 + your Constitution modifier + your proficiency bonus) or suffer one of the following effects (your choice):
                                
                The target must use its reaction to make a melee attack against another creature of your choice that you can see.
                Target takes 2d12 psychic damage.
                You can use this feature a number of times equal to your proficiency bonus, and you regain all expended uses when you finish a long rest.""" ),
        CALL_THE_HUNT("Call the Hunt", """
                At 14th level, the beast within you grows so powerful that you can spread its ferocity to others and gain resilience from them joining your hunt. When you enter your rage, you can choose a number of other willing creatures you can see within 30 feet of you equal to your Constitution modifier (minimum of one creature). You gain 5 temporary hit points for each creature that accepts this feature. Until the rage ends, the chosen creatures can use the following benefit once on each of their turns: when the creature hits a target with an attack roll and deals damage to it, the creature can roll a d6 and gain a bonus to the damage equal to the number rolled.
                                
                You can use this feature a number of times equal to your proficiency bonus, and you regain all expended uses when you finish a long rest.""" ),

        //SubBarbarian: Berserker
        FRENZY("Frenzy", """
                Starting when you choose this path at 3rd level, you can go into a frenzy when you rage. If you do so, for the duration of your rage you can make a single melee weapon attack as a bonus action on each of your turns after this one. When your rage ends, you suffer one level of exhaustion.""" ),
        MINDLESS_RAGE("Mindless Rage", """
                Beginning at 6th level, you can't be charmed or frightened while raging. If you are charmed or frightened when you enter your rage, the effect is suspended for the duration of the rage.""" ),
        INTIMIDATING_PRESENCE("Intimidating Presence", """
                Beginning at 10th level, you can use your action to frighten someone with your menacing presence. When you do so, choose one creature that you can see within 30 feet of you. If the creature can see or hear you, it must succeed on a Wisdom saving throw (DC equal to 8 + your proficiency bonus + your Charisma modifier) or be frightened of you until the end of your next turn. On subsequent turns, you can use your action to extend the duration of this effect on the frightened creature until the end of your next turn. This effect ends if the creature ends its turn out of line of sight or more than 60 feet away from you.
                                
                If the creature succeeds on its saving throw, you can't use this feature on that creature again for 24 hours.""" ),
        RETALIATION("Retaliation", """
                Starting at 14th level, when you take damage from a creature that is within 5 feet of you, you can use your reaction to make a melee weapon attack against that creature.""" ),
        
        //SubBarbarian: Storm_Herald
        STORM_AURA("Storm Aura", """
                When you select this path at 3rd level, you emanate a stormy, magical aura while you rage. The aura extends 10 feet from you in every direction, but not through total cover.
                                
                Your aura has an effect that activates when you enter your rage, and you can activate the effect again on each of your turns as a bonus action. Choose desert, sea, or tundra. Your aura's effect depends on that chosen environment, as detailed below. You can change your environment choice whenever you gain a level in this class.
                                
                If your aura's effects require a saving throw, the DC equals 8 + your proficiency bonus + your Constitution modifier.
                                
                Desert. When this effect is activated, all other creatures in your aura take 2 fire damage each. The damage increases when you reach certain levels in this class, increasing to 3 at 5th level, 4 at 10th level, 5 at 15th level, and 6 at 20th level.
                                
                Sea. When this effect is activated, you can choose one other creature you can see in your aura. The target must make a Dexterity saving throw. The target takes 1d6 lightning damage on a failed save, or half as much damage on a successful one. The damage increases when you reach certain levels in this class, increasing to 2d6 at 10th level, 3d6 at 15th level, and 4d6 at 20th level.
                                
                Tundra. When this effect is activated, each creature of your choice in your aura gains 2 temporary hit points, as icy spirits inure it to suffering. The temporary hit points increase when you reach certain levels in this class, increasing to 3 at 5th level, 4 at 10th level, 5 at 15th level, and 6 at 20th level.""" ),
        STORM_SOUL("Storm Soul", """
                At 6th level, the storm grants you benefits even when your aura isn't active. The benefits are based on the environment you chose for your Storm Aura.
                                
                Desert. You gain resistance to fire damage, and you don’t suffer the effects of extreme heat, as described in the Dungeon Master's Guide. Moreover, as an action, you can touch a flammable object that isn't being worn or carried by anyone else and set it on fire.
                                
                Sea. You gain resistance to lightning damage, and you can breathe underwater. You also gain a swimming speed of 30 feet.
                                
                Tundra. You gain resistance to cold damage, and you don’t suffer the effects of extreme cold, as described in the Dungeon Master's Guide. Moreover, as an action, you can touch water and turn a 5-foot cube of it into ice, which melts after 1 minute. This action fails if a creature is in the cube.""" ),
        SHIELDING_STORM("Shielding Storm", """
                At 10th level, you learn to use your mastery of the storm to protect others. Each creature of your choice has the damage resistance you gained from the Storm Soul feature while the creature is in your Storm Aura.""" ),
        RAGING_STORM("Raging Storm", """
                At 14th level, the power of the storm you channel grows mightier, lashing out at your foes. The effect is based on the environment you chose for your Storm Aura.
                                
                Desert. Immediately after a creature in your aura hits you with an attack, you can use your reaction to force that creature to make a Dexterity saving throw. On a failed save, the creature takes fire damage equal to your Barbarian level.
                                
                Sea. When you hit a creature in your aura with an attack, you can use your reaction to force that creature to make a Strength saving throw. On a failed save, the creature is knocked prone, as if struck by a wave.
                                
                Tundra. Whenever the effect of your Storm Aura is activated, you can choose one creature you can see in the aura. That creature must succeed on a Strength saving throw, or its speed is reduced to 0 until the start of your next turn, as magical frost covers it.""" ),

        //SubBarbarian: Totem_Warrior
        SPIRIT_SEEKER("Spirit Seeker", """
                Yours is a path that seeks attunement with the natural world, giving you a kinship with beasts. At 3rd level when you adopt this path, you gain the ability to cast the Beast Sense and Speak with Animals spells, but only as rituals.""" ),
        TOTEM_SPIRIT("Totem Spirit", """
                At 3rd level, when you adopt this path, you choose a totem spirit and gain its feature. You must make or acquire a physical totem object – an amulet or similar adornment – that incorporates fur or feathers, claws, teeth, or bones of the totem animal. At your option, you also gain minor physical attributes that are reminiscent of your totem spirit. For example, if you have a bear totem spirit, you might be unusually hairy and thick-skinned, or if your totem is the eagle, your eyes turn bright yellow.
                                
                Your totem animal might be an animal related to those listed here but more appropriate to your homeland. For example, you could choose a hawk or vulture in place of an eagle.
                                
                Bear. While raging, you have resistance to all damage except psychic damage. The spirit of the bear makes you tough enough to stand up to any punishment.
                                
                Eagle. While you're raging and aren't wearing heavy armor, other creatures have disadvantage on opportunity attack rolls against you, and you can use the Dash action as a bonus action on your turn. The spirit of the eagle makes you into a predator who can weave through the fray with ease.
                                
                Elk. While you're raging and aren't wearing heavy armor, your walking speed increases by 15 feet. The spirit of the elk makes you extraordinarily swift.
                                
                Tiger. While raging, you can add 10 feet to your long jump distance and 3 feet to your high jump distance. The spirit of the tiger empowers your leaps.
                                
                Wolf. While you're raging, your friends have advantage on melee attack rolls against any creature within 5 feet of you that is hostile to you. The spirit of the wolf makes you a leader of hunters.""" ),
        ASPECT_OF_THE_BEAST("Aspect of the Beast", """
                At 6th level, you gain a magical benefit based on the totem animal of your choice. You can choose the same animal you selected at 3rd level or a different one.
                                
                Bear. You gain the might of a bear. Your carrying capacity (including maximum load and maximum lift) is doubled, and you have advantage on Strength checks made to push, pull, lift, or break objects.
                                
                Eagle. You gain the eyesight of an eagle. You can see up to 1 mile away with no difficulty, able to discern even fine details as though looking at something no more than 100 feet away from you. Additionally, dim light doesn't impose disadvantage on your Wisdom (Perception) checks.
                                
                Elk. Whether mounted or on foot, your travel pace is doubled, as is the travel pace of up to ten companions while they're within 60 feet of you and you're not incapacitated. The elk spirit helps you roam far and fast.
                                
                Tiger. You gain proficiency in two skills from the following list: Athletics, Acrobatics, Stealth, and Survival. The cat spirit hones your survival instincts.
                                
                Wolf. You gain the hunting sensibilities of a wolf. You can track other creatures while traveling at a fast pace, and you can move stealthily while traveling at a normal pace.""" ),
        SPIRIT_WALKER("Spirit Walker", """
                At 10th level, you can cast the Commune with Nature spell, but only as a ritual. When you do so, a spiritual version of one of the animals you chose for Totem Spirit or Aspect of the Beast appears to you to convey the information you seek.""" ),
        TOTEMIC_ATTUNEMENT("Totemic Attunement", """
                At 14th level, you gain a magical benefit based on a totem animal of your choice. You can choose the same animal you selected previously or a different one.
                                
                Bear. While you're raging, any creature within 5 feet of you that's hostile to you has disadvantage on attack rolls against targets other than you or another character with this feature. An enemy is immune to this effect if it can't see or hear you or if it can't be frightened.
                                
                Eagle. While raging, you have a flying speed equal to your current walking speed. This benefit works only in short bursts; you fall if you end your turn in the air and nothing else is holding you aloft.
                                
                Elk. While raging, you can use a bonus action during your move to pass through the space of a Large or smaller creature. That creature must succeed on a Strength saving throw (DC 8 + your Strength bonus + your proficiency bonus) or be knocked prone and take bludgeoning damage equal to 1d12 + your Strength modifier.
                                
                Tiger. While you're raging, if you move at least 20 feet in a straight line toward a Large or smaller target right before making a melee weapon attack against it, you can use a bonus action to make an additional melee weapon attack against it.
                                
                Wolf. While you're raging, you can use a bonus action on your turn to knock a Large or smaller creature prone when you hit it with melee weapon attack.""" ),

        //SubBarbarian: Wild_Magic
        MAGIC_AWARENESS("Magic Awareness", """
                When you choose this path at 3rd level, as an action, you can open your awareness to the presence of concentrated magic. Until the end of your next turn, you know the location of any spell or magic item within 60 feet of you that isn’t behind total cover. When you sense a spell, you learn which school of magic it belongs to.
                                
                You can use this feature a number of times equal to your proficiency bonus, and you regain all expended uses when you finish a long rest.""" ),
        WILD_SURGE("Wild Surge", """
                Also at 3rd level, the magical energy roiling inside you sometimes erupts from you. When you enter your rage, roll on the Wild Magic table to determine the magical effect produced.
                                
                If the effect requires a saving throw, the DC equals 8 + your proficiency bonus + your Constitution modifier.
                                
                Wild Surge
                d8	Effect
                1	Each creature of your choice that you can see within 30 feet of you must succeed on a Constitution saving throw or take 1d12 necrotic damage. You also gain temporary hit points equal to 1d12 plus your barbarian level.
                2	You teleport up to 30 feet to an unoccupied space you can see. Until your rage ends, you can use this effect again on each of your turns as a bonus action.
                3	An intangible spirit, which looks like a flumph or a pixie (your choice), appears within 5 feet of one creature of your choice that you can see within 30 feet of you. At the end of the current turn, the spirit explodes, and each creature within 5 feet of it must succeed on a Dexterity saving throw or take 1d6 force damage. Until your rage ends, you can use this effect again, summoning another spirit, on each of your turns as a bonus action.
                4	Magic infuses one weapon of your choice that you are holding. Until your rage ends, the weapon's damage type changes to force, and it gains the light and thrown properties, with a normal range of 20 feet and a long range of 60 feet. If the weapon leaves your hand, the weapon reappears in your hand at the end of the current turn.
                5	Whenever a creature hits you with an attack roll before your rage ends, that creature takes 1d6 force damage, as magic lashes out in retribution.
                6	Until your rage ends, you are surrounded by multicolored, protective lights; you gain a +1 bonus to AC, and while within 10 feet of you, your allies gain the same bonus.
                7	Flowers and vines temporarily grow around you; until your rage ends, the ground within 15 feet of you is difficult terrain for your enemies.
                8	A bolt of light shoots from your chest. Another creature of your choice that you can see within 30 feet of you must succeed on a Constitution saving throw or take 1d6 radiant damage and be blinded until the start of your next turn. Until your rage ends, you can use this effect again on each of your turns as a bonus action.""" ),
        BOLSTERING_MAGIC("Bolstering Magic", """
                Beginning at 6th level, you can harness your wild magic to bolster yourself or a companion. As an action, you can touch one creature (which can be yourself) and confer one of the following benefits of your choice to that creature:
                                
                For 10 minutes, the creature can roll a d3 whenever making an attack roll or an ability check and add the number rolled to the d20 roll.
                Roll a d3. The creature regains one expended spell slot, the level of which equals the number rolled or lower (the creature’s choice). Once a creature receives this benefit, that creature can’t receive it again until after a long rest.
                You can take this action a number of times equal to your proficiency bonus, and you regain all expended uses when you finish a long rest.""" ),
        UNSTABLE_BACKLASH("Unstable Backlash", """
                At 10th level, when you are imperiled during your rage, the magic within you can lash out; immediately after you take damage or fail a saving throw while raging, you can use your reaction to roll on the Wild Magic table and immediately produce the effect rolled. This effect replaces your current Wild Magic effect.""" ),
        CONTROLLED_SURGE("Controlled Surge", """
                At 14th level, whenever you roll on the Wild Magic table, you can roll the die twice and choose which of the two effects to unleash. If you roll the same number on both dice, you can ignore the number and choose any effect on the table.""" ),

        //SubBarbarian: Zealot
        DIVINE_FURY("Divine Fury", """
                Starting when you choose this path at 3rd level, you can channel divine fury into your weapon strikes. While you're raging, the first creature you hit on each of your turns with a weapon attack takes extra damage equal to 1d6 + half your Barbarian level. The extra damage is necrotic or radiant; you choose the type of damage when you gain this feature.""" ), 
        WARRIOR_OF_GOD("Warrior of God", """
                At 3rd level, your soul is marked for endless battle. If a spell, such as Raise Dead, has the sole effect of restoring you to life (but not undeath), the caster doesn't need material components to cast the spell on you.""" ), 
        FANATICAL_FOCUS("Fanatical Focus", """
                Starting at 6th level, the divine power that fuels your rage can protect you. If you fail a saving throw while raging, you can reroll it, and you must use the new roll. You can use this ability only once per rage.""" ), 
        ZEALOUS_PRESENCE("Zealous Presence", """
                At 10th level, you learn to channel divine power to inspire zealotry in others. As a bonus action, you unleash a battle cry infused with divine energy. Up to ten other creatures of your choice within 60 feet of you that can hear you gain advantage on attack rolls and saving throws until the start of your next turn.
                                
                Once you use this feature, you can’t use it again until you finish a long rest.""" ),
        RAGE_BEYOND_DEATH("Rage Beyond Death", """
                Beginning at 14th level, the divine power that fuels your rage allows you to shrug off fatal blows.
                                
                While you're raging, having 0 hit points doesn’t knock you unconscious. You still must make death saving throws, and you suffer the normal effects of taking damage while at 0 hit points. However, if you would die due to failing death saving throws, you don’t die until your rage ends, and you die then only if you still have 0 hit points.""" ), 
      
      
      //Bard
        BARDIC_INSPIRATION("Bardic Inspiration", """
                You can inspire others through stirring words or music. To do so, you use a bonus action on your turn to choose one creature other than yourself within 60 feet of you who can hear you. That creature gains one Bardic Inspiration die, a d6.
                                
                Once within the next 10 minutes, the creature can roll the die and add the number rolled to one ability check, attack roll, or saving throw it makes. The creature can wait until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the DM says whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost. A creature can have only one Bardic Inspiration die at a time.
                                
                You can use this feature a number of times equal to your Charisma modifier (a minimum of once). You regain any expended uses when you finish a long rest.
                                
                Your Bardic Inspiration die changes when you reach certain levels in this class. The die becomes a d8 at 5th level, a d10 at 10th level, and a d12 at 15th level."""), 
        JACK_OF_ALL_TRADES("Jack of all Trades", """
                Starting at 2nd level, you can add half your proficiency bonus, rounded down, to any ability check you make that doesn't already include your proficiency bonus.""" ),
        SONG_OF_REST("Song of Resr", """
                Beginning at 2nd level, you can use soothing music or oration to help revitalize your wounded allies during a short rest. If you or any friendly creatures who can hear your performance regain hit points at the end of the short rest by spending one or more Hit Dice, each of those creatures regains an extra 1d6 hit points.
                                
                The extra Hit Points increase when you reach certain levels in this class: to 1d8 at 9th level, to 1d10 at 13th level, and to 1d12 at 17th level.""" ), 
        EXPERTISE("Expertise", """
                At 3rd level, choose two of your skill proficiencies. Your proficiency bonus is doubled for any ability check you make that uses either of the chosen proficiencies.
                                
                At 10th level, you can choose another two skill proficiencies to gain this benefit.""" ), 
        FONT_OF_INSPIRATION("Font of Inspiration", """
                Beginning when you reach 5th level, you regain all of your expended uses of Bardic Inspiration when you finish a short or long rest.""" ),
        COUNTERCHARM("Countercharm", """
                At 6th level, you gain the ability to use musical notes or words of power to disrupt mind-influencing effects. As an action, you can start a performance that lasts until the end of your next turn. During that time, you and any friendly creatures within 30 feet of you have advantage on saving throws against being frightened or charmed. A creature must be able to hear you to gain this benefit. The performance ends early if you are incapacitated or silenced or if you voluntarily end it (no action required).""" ), 
        MAGICAL_SECRETS("Magical Secrets", """
                By 10th level, you have plundered magical knowledge from a wide spectrum of disciplines. Choose two spells from any classes, including this one. A spell you choose must be of a level you can cast, as shown on the Bard table, or a cantrip.
                                
                The chosen spells count as bard spells for you and are included in the number in the Spells Known column of the Bard table.
                                
                You learn two additional spells from any classes at 14th level and again at 18th level.""" ),
        SUPERIOR_INSPIRATION("Superior Inpiration", """
                At 20th level, when you roll initiative and have no uses of Bardic Inspiration left, you regain one use.""" ),
        
        //SubBard: Creation
        NOTE_OF_POTENTIAL("Note of Potential", """
                When you join the College of Creation at 3rd level, whenever you give a creature a Bardic Inspiration die, you can utter a note from the Song of Creation to create a Tiny mote of potential, which orbits within 5 feet of that creature. The mote is intangible and invulnerable, and it lasts until the Bardic Inspiration die is lost. The mote looks like a musical note, a star, a flower, or another symbol of art or life that you choose.
                                
                When the creature uses the Bardic Inspiration die, the mote provides an additional effect based on whether the die benefits an ability check, an attack roll, or a saving throw, as detailed below:
                                
                Ability Check. When the creature rolls the Bardic Inspiration die to add it to an ability check, the creature can roll the Bardic Inspiration die again and choose which roll to use, as the mote pops and emits colorful, harmless sparks for a moment.
                                
                Attack Roll. Immediately after the creature rolls the Bardic Inspiration die to add it to an attack roll against a target, the mote thunderously shatters. The target and each creature of your choice that you can see within 5 feet of it must succeed on a Constitution saving throw against your spell save DC or take thunder damage equal to the number rolled on the Bardic Inspiration die.
                                
                Saving Throw. Immediately after the creature rolls the Bardic Inspiration die and adds it to a saving throw, the mote vanishes with the sound of soft music, causing the creature to gain temporary hit points equal to the number rolled on the Bardic Inspiration die plus your Charisma modifier (minimum of 1 temporary hit point).""" ),
        PERFORMANCE_OF_CREATION("Performance of Creation", """
                Also at 3rd level, as an action, you can channel the magic of the Song of Creation to create one nonmagical item of your choice in an unoccupied space within 10 feet of you. The item must appear on a surface or in a liquid that can support it. The gp value of the item can't be more than 20 times your bard level, and the item must be Medium or smaller. The item glimmers softly, and a creature can faintly hear music when touching it. The created item disappears after a number of hours equal to your proficiency bonus. For examples of items you can create, see the equipment chapter of the Player's Handbook.
                                
                Once you create an item with this feature, you can't do so again until you finish a long rest, unless you expend a spell slot of 2nd level or higher to use this feature again. You can have only one item created by this feature at a time; if you use this action and already have an item from this feature, the first one immediately vanishes.
                                
                The size of the item you can create with this feature increases by one size category when you reach 6th level (Large) and 14th level (Huge).""" ),
        ANIMATING_PERFORMANCE("Animating Performance", """
                By 6th level, as an action, you can target a Large or smaller nonmagical item you can see within 30 feet of you and animate it. The animate item uses the Dancing Item stat block, which uses your proficiency bonus (PB), The item is friendly to you and your companions and obeys your commands. It lives for 1 hour, until it is reduced to 0 hit points, or until you die.
                                
                In combat, the item shares your initiative count, but it takes its turn immediately after yours. It can move and use its reaction on its own, but the only action it takes on its turn is the Dodge action, unless you take a bonus action on your turn to command it to take another action. That action can be one in its stat block or some other action. If you are incapacitated, the item can take any action of its choice, not just Dodge.
                                
                When you use your Bardic Inspiration feature, you can command the item as part of the same bonus action you use for Bardic Inspiration.
                                
                Once you animate an item with this feature, you can't do so again until you finish a long rest, unless you expend a spell slot of 3rd level or higher to use this feature again. You can have only one item animated by this feature at a time; if you use this action and already have a dancing item from this feature, the first one immediately becomes inanimate.
                                
                Dancing Item
                Large or smaller construct
                Armor Class: 16 (natural armor)
                Hit Points: 10 + 5 times your bard level
                Speed: 30 ft., fly 30 ft. (hover)
                STR	DEX	CON	INT	WIS	CHA
                18 (+4)	14 (+2)	16 (+3)	4 (−3)	10 (+0)	6 (−2)
                Damage Immunities: poison, psychic
                Condition Immunities: charmed, exhaustion, poisoned, frightened
                Senses: darkvision 60 ft., passive Perception 10
                Languages: understands the languages you speak
                Challenge: —
                Proficiency Bonus (PB): equals your bonus
                Immutable Form. The item is immune to any spell or effect that would alter its form.
                Irrepressible Dance. When any creature starts its turn within 10 feet of the item, the item can increase or decrease (your choice) the walking speed of that creature by 10 feet until the end of the turn, provided the item isn't incapacitated.
                Actions
                Force-Empowered Slam. Melee Weapon Attack: your spell attack modifier to hit, reach 5 ft., one target you can see. Hit: 1d10 + PB force damage.""" ),
        CREATIVE_CRESVENDO("Creative Crescendo", """
                At 14th level, when you use your Performance of Creation feature, you can create more than one item at once. The number of items equals your Charisma modifier (minimum of two items). If you create an item that would exceed that number, you choose which of the previously created items disappears. Only one of these items can be of the maximum size you can create; the rest must be Small or Tiny.
                                
                You are no longer limited by gp value when creating items with Performance of Creation.""" ),

        //SubBard: Eloquence
        SILVER_TONGUE("Silver Tongue", """
                Starting at 3rd level, you are a master at saying the right thing at the right time. When you make a Charisma (Persuasion) or Charisma (Deception) check, you can treat a d20 roll of 9 or lower as a 10.""" ),
        UNSETTLING_WORDS("Unsettling Words", """
                Also at 3rd level, you can spin words laced with magic that unsettle a creature and cause it to doubt itself. As a bonus action, you can expend one use of your Bardic Inspiration and choose one creature you can see within 60 feet of you. Roll the Bardic Inspiration die. The creature must subtract the number rolled from the next saving throw it makes before the start of your next turn.""" ),
        UNFAILING_INSPIRATION("Unfailing Inspiration", """
                At 6th level, your inspiring words are so persuasive that others feel driven to succeed. When a creature adds one of your Bardic Inspiration dice to its ability check, attack roll, or saving throw and the roll fails, the creature can keep the Bardic Inspiration die."""),
        UNIVERSAL_SPEECH("Universal Speech", """
                Also at 6th level, you have gained the ability to make your speech intelligible to any creature. As an action, choose one or more creatures within 60 feet of you, up to a number equal to your Charisma modifier (minimum of one creature). The chosen creatures can magically understand you, regardless of the language you speak, for 1 hour.
                                
                Once you use this feature, you can't use it again until you finish a long rest, unless you expend a spell slot to use it again.""" ),
        INFECTIOUS_INSPIRATION("Infectious Inpiration", """
                At 14th level, when you successfully inspire someone, the power of your eloquence can now spread to someone else. When a creature within 60 feet of you adds one of your Bardic Inspiration dice to its ability check, attack roll, or saving throw and the roll succeeds, you can use your reaction to encourage a different creature (other than yourself) that can hear you within 60 feet of you, giving it a Bardic Inspiration die without expending any of your Bardic Inspiration uses.
                                
                You can use this reaction a number of times equal to your Charisma modifier (minimum of once), and you regain all expended uses when you finish a long rest.""" ),

        //SubBard: Glamour
        MANTLE_OF_INSPIRATION("Mantle of Inspiration", """
                When you join the College of Glamour at 3rd level, you gain the ability to weave a song of fey magic that imbues your allies with vigor and speed.
                                
                As a bonus action, you can expend one use of your Bardic Inspiration to grant yourself a wondrous appearance. When you do so, choose a number of creatures you can see and who can see you within 60 feet of you, up to a number equal to your Charisma modifier (minimum of one). Each of them gains 5 temporary hit points. When a creature gains these temporary hit points, it can immediately use its reaction to move up to its speed, without provoking opportunity attacks.
                                
                The number of temporary hit points increases when you reach certain levels in this class, increasing to 8 at 5th level, 11 at 10th level, and 14 at 15th level.""" ),
        ENTHRALLING_PERFORMANCE("Enthralling Performance", """
                Starting at 3rd level, you can charge your performance with seductive, fey magic.
                                
                If you perform for at least 1 minute, you can attempt to inspire wonder in your audience by singing, reciting a poem, or dancing. At the end of the performance, choose a number of humanoids within 60 feet of you who watched and listened to all of it, up to a number equal to your Charisma modifier (minimum of one). Each target must succeed on a Wisdom saving throw against your spell save DC or be charmed by you. While charmed in this way, the target idolizes you, it speaks glowingly of you to anyone who speaks to it, and it hinders anyone who opposes you, avoiding violence unless it was already inclined to fight on your behalf. This effect ends on a target after 1 hour, if it takes any damage, if you attack it, or if it witnesses you attacking or damaging any of its allies.
                                
                If a target succeeds on its saving throw, the target has no hint that you tried to charm it.
                                
                Once you use this feature, you can’t use it again until you finish a short or long rest.""" ),
        MANTLE_OF_MAJESTY("Mantle of Majesty", """
                At 6th level, you gain the ability to cloak yourself in a fey magic that makes others want to serve you. As a bonus action, you cast Command, without expending a spell slot, and you take on an appearance of unearthly beauty for 1 minute or until your concentration ends (as if you were concentrating on a spell). During this time, you can cast Command as a bonus action on each of your turns, without expending a spell slot.
                                
                Any creature charmed by you automatically fails its saving throw against the Command you cast with this feature.
                                
                Once you use this feature, you can’t use it again until you finish a long rest.""" ),
        UNBREAKABLE_MAJESTY("Unbreakable Majesty", """
                At 14th level, your appearance permanently gains an otherworldly aspect that makes you look more lovely and fierce.
                                
                In addition, as a bonus action, you can assume a magically majestic presence for 1 minute or until you are incapacitated. For the duration, whenever any creature tries to attack you for the first time on a turn, the attacker must make a Charisma saving throw against your spell save DC. On a failed save, it can't attack you on this turn, and it must choose a new target for its attack or the attack is wasted. On a successful save, it can attack you on this turn, but it has disadvantage on any saving throw it makes against your spells on your next turn.
                                
                Once you assume this majestic presence, you can't do so again until you finish a short or long rest.""" ), 
        
        //SubBard: Lore
        LORE_BARD_BONUS_PROFICIENCIES("Bonus Proficiencies", """
                When you join the College of Lore at 3rd level, you gain proficiency with three skills of your choice.""" ), 
        CUTTING_WORDS("Cutting Words", """
                Also at 3rd level, you learn how to use your wit to distract, confuse, and otherwise sap the confidence and competence of others. When a creature that you can see within 60 feet of you makes an attack roll, an ability check, or a damage roll, you can use your reaction to expend one of your uses of Bardic Inspiration, rolling a Bardic Inspiration die and subtracting the number rolled from the creature's roll. You can choose to use this feature after the creature makes its roll, but before the DM determines whether the attack roll or ability check succeeds or fails, or before the creature deals its damage. The creature is immune if it can't hear you or if it's immune to being charmed.""" ),
        ADDITIONAL_MAGICAL_SECRETS("Additional Magical Secrets", """
                At 6th level, you learn two spells of your choice from any class. A spell you choose must be of a level you can cast, as shown on the Bard table, or a cantrip. The chosen spells count as bard spells for you but don't count against the number of bard spells you know.""" ),
        PEERLESS_SKILL("Peerless Skill", """
                Starting at 14th level, when you make an ability check, you can expend one use of Bardic Inspiration. Roll a Bardic Inspiration die and add the number rolled to your ability check. You can choose to do so after you roll the die for the ability check, but before the DM tells you whether you succeed or fail.""" ),

        //SubBard: Spirits
        GUIDING_WHISPERS("Guiding Whispers", """
                At 3rd level, you can reach out to spirits to guide you and others. You learn the Guidance cantrip, which doesn’t count against the number of bard cantrips you know. For you, it has a range of 60 feet when you cast it.""" ),
        SPIRITUAL_FOCUS("Spiritual Focus", """
                At 3rd level, you employ tools that aid you in channeling spirits, be they historical figures or fictional archetypes. You can use the following objects as a spellcasting focus for your bard spells: a candle, crystal ball, skull, spirit board, or tarokka deck.
                                
                Starting at 6th level, when you cast a bard spell that deals damage or restores hit points through the Spiritual Focus, roll a d6, and you gain a bonus to one damage or healing roll of the spell equal to the number rolled.""" ),
        TALES_FROM_BEYOND("Tales from Beyond", """
                At 3rd level, you reach out to spirits who tell their tales through you. While you are holding your Spiritual Focus, you can use a bonus action to expend one use of your Bardic Inspiration and roll on the Spirit Tales table using your Bardic Inspiration die to determine the tale the spirits direct you to tell. You retain the tale in mind until you bestow the tale’s effect or you finish a short or long rest.
                                
                You can use an action to choose one creature you can see within 30 feet of you (this can be you) to be the target of the tale’s effect. Once you do so, you can’t bestow the tale’s effect again until you roll it again.
                                
                You can retain only one of these tales in mind at a time, and rolling on the Spirit Tales table immediately ends the effect of the previous tale.
                                
                If the tale requires a saving throw, the DC equals your spell save DC.
                                
                Spirit Tales
                Bardic Insp. Die	Tale Told Through You
                1	Tale of the Clever Animal. For the next 10 minutes, whenever the target makes an Intelligence, a Wisdom, or a Charisma check, the target can roll an extra die immediately after rolling the d20 and add the extra die's number to the check. The extra die is the same type as your Bardic Inspiration die.
                2	Tale of the Renowned Duelist. You make a melee spell attack against the target. On a hit, the target takes force damage equal to two rolls of your Bardic Inspiration die + your Charisma modifier.
                3	Tale of the Beloved Friends. The target and another creature of its choice it can see within 5 feet of it gains temporary hit points equal to a roll of your Bardic Inspiration die + your Charisma modifier
                4	Tale of the Runaway. The target can immediately use its reaction to teleport up to 30 feet to an unoccupied space it can see. When the target teleports, it can choose a number of creatures it can see within 30 feet of it up to your Charisma modifier (minimum of 0) to immediately use the same reaction.
                5	Tale of the Avenger. For 1 minute, any creature that hits the target with a melee attack takes force damage equal to a roll of your Bardic Inspiration die.
                6	Tale of the Traveler. The target gains temporary hit points equal to a roll of your Bardic Inspiration die + your bard level. While it has these temporary hit points, the target’s walking speed increases by 10 feet and it gains a +1 bonus to its AC.
                7	Tale of the Beguiler. The target must succeed on a Wisdom saving throw or take psychic damage equal to two rolls of your Bardic Inspiration die, and the target is incapacitated until the end of its next turn.
                8	Tale of the Phantom. The target becomes invisible until the end of its next turn or until it hits a creature with an attack. If it hits a creature with an attack during this invisibility, the creature it hits takes necrotic damage equal to a roll of your Bardic Inspiration die and is frightened of the target until the end of the frightened creature's next turn.
                9	Tale of the Brute. Each creature of the target’s choice it can see within 30 feet of it must make a Strength saving throw. On a failed save, a creature takes thunder damage equal to three rolls of your Bardic Inspiration die and is knocked prone. A creature that succeeds on its saving throw takes half as much damage and isn’t knocked prone.
                10	Tale of the Dragon. The target spews fire from the mouth in a 30-foot cone. Each creature in that area must make a Dexterity saving throw, taking fire damage equal to four rolls of your Bardic Inspiration die on a failed save, or half as much damage on a successful one.
                11	Tale of the Angel. The target regains hit points equal to two rolls of your Bardic Inspiration die + your Charisma modifier, and you end one condition from the following list affecting the target: blinded, deafened, paralyzed, petrified, or poisoned.
                12	Tale of the Mind-Bender You envoke an incomprehensible fable from an otherworldly being. The target must succeed on an Intelligence saving throw or take psychic damage equal to three rolls of your Bardic Inspiration die and be stunned until the end of its next turn.""" ), 
        SPIRIT_SESSION("Spirit Session", """
                At 6th level, spirits provide you with supernatural insights. You can conduct an hour-long ritual channeling spirits (which can be done during a short or long rest) using your Spiritual Focus. You can conduct the ritual with a number of willing creatures equal to your proficiency bonus (including yourself). At the end of the ritual, you temporarily learn one spell of your choice from any class.
                                
                The spell you choose must be of a level equal to the number of creatures that conducted the ritual or less, the spell must of a level you can cast, and it must be in the school of Divination or Necromancy. The chosen spell counts as a bard spell for you but doesn’t count against the number of bard spells you know.
                                
                Once you perform the ritual, you can’t do so again until you start a long rest, and you know the chosen spell until you start a long rest.""" ),
        MYSTICAL_CONNECTION("Mystical Connection", """
                At 14th level, you now have the ability to nudge the spirits of Tales from Beyond toward certain tales. Whenever you roll on the Spirit Tales table, you can roll the die twice and choose which of the two effects to bestow. If you roll the same number on both dice, you can ignore the number and choose any effect on the table.""" ),

        //SubBard: Swords
        SWORDS_BARD_BONUS_PROFICIENCIES("Bonus Proficiencies", """
                When you join the College of Swords at 3rd level, you gain proficiency with medium armor and the scimitar.
                                
                If you’re proficient with a simple or martial melee weapon, you can use it as a spellcasting focus for your bard spells.""" ),
        SWORDS_BARD_FIGHTING_STYLE("Fighting Style", """
                At 3rd level, you adopt a particular style of fighting as your specialty. Choose one of the following options. You can't take a Fighting Style option more than once, even if you later get to choose again.
                                
                Dueling. When you are wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls with that weapon.
                Two-Weapon Fighting. When you engage in two-weapon fighting, you can add your ability modifier to the damage of the second attack.""" ),
        BLADE_FLOURISH("Blade Flourish", """
                At 3rd level, you learn to conduct impressive displays of martial prowess and speed.
                                
                Whenever you take the Attack action on your turn, your walking speed increases by 10 feet until the end of the turn, and if a weapon attack that you make as part of this action hits a creature, you can use one of the following Blade Flourish options of your choice. You can use only one Blade Flourish option per turn.
                                
                Defensive Flourish. You can expend one use of your Bardic Inspiration to cause the weapon to deal extra damage to the target you hit. The damage equals the number you roll on the Bardic Inspiration die. You also add the number rolled to your AC until the start of your next turn.
                                
                Slashing Flourish. You can expend one use of your Bardic Inspiration to cause the weapon to deal extra damage to the target you hit and to any other creature of your choice that you can see within 5 feet of you. The damage equals the number you roll on the Bardic Inspiration die.
                                
                Mobile Flourish. You can expend one use of your Bardic Inspiration to cause the weapon to deal extra damage to the target you hit. The damage equals the number you roll on the Bardic Inspiration die. You can also push the target up to 5 feet away from you, plus a number of feet equal to the number you roll on that die. You can then immediately use your reaction to move up to your walking speed to an unoccupied space within 5 feet of the target.""" ),
        BARD_EXTRA_ATTACK("Extra Attack", """
                Starting at 6th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.""" ),
        MASTERS_FLOURISH("Master's Flourish", """
                Starting at 14th level, whenever you use a Blade Flourish option, you can roll a d6 and use it instead of expending a Bardic Inspiration die.""" ),

        //SubBard: Valor
        VALOR_BARD_BONUS_PROFICIENCIES("Bonus Proficiencies", """
                When you join the College of Valor at 3rd level, you gain proficiency with medium armor, shields, and martial weapons.""" ), 
        COMBAT_INSPIRATION("Combat Inspiration", """
                Also at 3rd level, you learn to inspire others in battle. A creature that has a Bardic Inspiration die from you can roll that die and add the number rolled to a weapon damage roll it just made. Alternatively, when an attack roll is made against the creature, it can use its reaction to roll the Bardic Inspiration die and add the number rolled to its AC against that attack, after seeing the roll but before knowing whether it hits or misses.""" ),
        BATTLE_MAGIC("Battle Magic", """
                At 14th level, you have mastered the art of weaving spellcasting and weapon use into a single harmonious act. When you use your action to cast a bard spell, you can make one weapon attack as a bonus action.""" ), 
        PSYCHIC_BLADES("Psychic Blades", """
                When you join the College of Whispers at 3rd level, you gain the ability to make your weapon attacks magically toxic to a creature's mind.
                                
                When you hit a creature with a weapon attack, you can expend one use of your Bardic Inspiration to deal an additional 2d6 psychic damage to that target. You can do so only once per round on your turn.
                                
                The psychic damage increases when you reach certain levels in this class, increasing to 3d6 at 5th level, 5d6 at 10th level, and 8d6 at 15th level.""" ), 
        WORDS_OF_TERROR("Words of Terror", """
                At 3rd level, you learn to infuse innocent-seeming words with an insidious magic that can inspire terror.
                                
                If you speak to a humanoid alone for at least 1 minute, you can attempt to seed paranoia and fear into its mind. At the end of the conversation, the target must succeed on a Wisdom saving throw against your spell save DC or be frightened of you or another creature of your choice. The target is frightened in this way for 1 hour, until it is attacked or damaged, or until it witnesses its allies being attacked or damaged.
                                
                If the target succeeds on its saving throw, the target has no hint that you tried to frighten it.
                                
                Once you use this feature, you can’t use it again until you finish a short rest or long rest.""" ), 
        MANTLE_OF_WHISPERS("Mantle of Whispers", """
                At 6th level, you gain the ability to adopt a humanoid's persona. When a humanoid dies within 30 feet of you, you can magically capture its shadow using your reaction. You retain this shadow until you use it or you finish a long rest.
                                
                You can use the shadow as an action. When you do so, it vanishes, magically transforming into a disguise that appears on you. You now look like the dead person, but healthy and alive. This disguise lasts for 1 hour or until you end it as a bonus action.
                                
                While you're in the disguise, you gain access to all information that the humanoid would freely share with a casual acquaintance. Such information includes general details on its background and personal life, but doesn't include secrets. The information is enough that you can pass yourself off as the person by drawing on its memories.
                                
                Another creature can see through this disguise by succeeding on a Wisdom (Insight) check contested by your Charisma (Deception) check. You gain a +5 bonus to your check.
                                
                Once you capture a shadow with this feature, you can't capture another one with it until you finish a short or long rest.""" ),
        SHADOW_LORE("Shadow Lore", """
                At 14th level, you gain the ability to weave dark magic into your words and tap into a creature’s deepest fears.
                                
                As an action, you magically whisper a phrase that only one creature of your choice within 30 feet of you can hear. The target must make a Wisdom saving throw against your spell save DC. It automatically succeeds if it doesn’t share a language with you or if it can’t hear you. On a successful saving throw, your whisper sounds like unintelligible mumbling and has no effect.
                                
                If the target fails its saving throw, it is charmed by you for the next 8 hours or until you or your allies attack or damage it. It interprets the whispers as a description of its most mortifying secret.
                                
                While you gain no knowledge of this secret, the target is convinced you know it. While charmed in this way, the creature obeys your commands for fear that you will reveal its secret. It won’t risk its life for you or fight for you, unless it was already inclined to do so. It grants you favors and gifts it would offer to a close friend.
                                
                When the effect ends, the creature has no understanding of why it held you in such fear.
                                
                Once you use this feature, you can’t use it again until you finish a long rest.""" ),



        //Base Cleric
        CHANNEL_DIVINITY("Channel Divinity", """
                At 2nd level, you gain the ability to channel divine energy directly from your deity, using that energy to fuel magical effects. You start with two such effects: Turn Undead and an effect determined by your domain. Some domains grant you additional effects as you advance in levels, as noted in the domain description.
                                
                When you use your Channel Divinity, you choose which effect to create. You must then finish a short or long rest to use your Channel Divinity again.
                                
                Some Channel Divinity effects require saving throws. When you use such an effect from this class, the DC equals your cleric spell save DC.
                                
                Beginning at 6th level, you can use your Channel Divinity twice between rests, and beginning at 18th level, you can use it three times between rests. When you finish a short or long rest, you regain your expended uses.""" ),
        CHANNEL_DIVINITY_TURNUNDEAD("Channel Divinity: Turn Undeas", """
                As an action, you present your holy symbol and speak a prayer censuring the undead. Each undead that can see or hear you within 30 feet of you must make a Wisdom saving throw. If the creature fails its saving throw, it is turned for 1 minute or until it takes any damage.
                                
                A turned creature must spend its turns trying to move as far away from you as it can, and it can't willingly move to a space within 30 feet of you. It also can't take reactions. For its action, it can use only the Dash action or try to escape from an effect that prevents it from moving. If there's nowhere to move, the creature can use the Dodge action."""),
        DESTROY_UNDEAD("Destroy Undead", """
                Starting at 5th level, when an undead fails its saving throw against your Turn Undead feature, the creature is instantly destroyed if its challenge rating is at or below a certain threshold, as shown in the Cleric table above.""" ),
        DIVINE_INTERVENTION("Divine Intervention", """
                Beginning at 10th level, you can call on your deity to intervene on your behalf when your need is great.
                                
                Imploring your deity's aid requires you to use your action. Describe the assistance you seek, and roll percentile dice. If you roll a number equal to or lower than your cleric level, your deity intervenes. The DM chooses the nature of the intervention; the effect of any cleric spell or cleric domain spell would be appropriate. If your deity intervenes, you can't use this feature again for 7 days. Otherwise, you can use it again after you finish a long rest.
                                
                At 20th level, your call for intervention succeeds automatically, no roll required.""" ),


        //Base Druid
        DRUIDIC("Druidic", """
                You know Druidic, the secret language of druids. You can speak the language and use it to leave hidden messages. You and others who know this language automatically spot such a message. Others spot the message's presence with a successful DC 15 Wisdom (Perception) check but can't decipher it without magic.""" ), 
        WILD_SHAPE("Wild Shape", """
                Starting at 2nd level, you can use your action to magically assume the shape of a beast that you have seen before. You can use this feature twice. You regain expended uses when you finish a short or long rest.
                                
                Your druid level determines the beasts you can transform into, as shown in the Beast Shapes table. At 2nd level, for example, you can transform into any beast that has a challenge rating of 1/4 or lower that doesn't have a flying or swimming speed.
                                
                Beast Shapes
                Level	Max. CR	Limitations	Example
                2nd	1/4	No flying or swimming speed	Wolf
                4th	1/2	No flying speed	Crocodile
                8th	1		Giant eagle
                You can stay in a beast shape for a number of hours equal to half your druid level (rounded down). You then revert to your normal form unless you expend another use of this feature. You can revert to your normal form earlier by using a bonus action on your turn. You automatically revert if you fall unconscious, drop to 0 hit points, or die.
                                
                While you are transformed, the following rules apply:
                                
                Your game statistics are replaced by the statistics of the beast, but you retain your alignment, personality, and Intelligence, Wisdom, and Charisma scores. You also retain all of your skill and saving throw proficiencies, in addition to gaining those of the creature. If the creature has the same proficiency as you and the bonus in its stat block is higher than yours, use the creature's bonus instead of yours. If the creature has any legendary or lair actions, you can't use them.
                When you transform, you assume the beast's hit points and Hit Dice. When you revert to your normal form, you return to the number of hit points you had before you transformed. However, if you revert as a result of dropping to 0 hit points, any excess damage carries over to your normal form, For example, if you take 10 damage in animal form and have only 1 hit point left, you revert and take 9 damage. As long as the excess damage doesn't reduce your normal form to 0 hit points, you aren't knocked unconscious.
                You can't cast spells, and your ability to speak or take any action that requires hands is limited to the capabilities of your beast form. Transforming doesn't break your concentration on a spell you've already cast, however, or prevent you from taking actions that are part of a spell, such as Call Lightning, that you've already cast.
                You retain the benefit of any features from your class, race, or other source and can use them if the new form is physically capable of doing so. However, you can't use any of your special senses, such as darkvision, unless your new form also has that sense.
                You choose whether your equipment falls to the ground in your space, merges into your new form, or is worn by it. Worn equipment functions as normal, but the DM decides whether it is practical for the new form to wear a piece of equipment, based on the creature's shape and size. Your equipment doesn't change size or shape to match the new form, and any equipment that the new form can't wear must either fall to the ground or merge with it. Equipment that merges with the form has no effect until you leave the form.""" ), 
        DRUID_TIMELESS_BODY("Timeless Body", """
                Starting at 18th level, the primal magic that you wield causes you to age more slowly. For every 10 years that pass, your body ages only 1 year.""" ),
        BEAST_SPELLS("Beast Spells", """
                Beginning at 18th level, you can cast many of your druid spells in any shape you assume using Wild Shape. You can perform the somatic and verbal components of a druid spell while in a beast shape, but you aren't able to provide material components.""" ),
        ARCHDRUID("Archdruid", """
                At 20th level, you can use your Wild Shape an unlimited number of times.
                                
                Additionally, you can ignore the verbal and somatic components of your druid spells, as well as any material components that lack a cost and aren't consumed by a spell. You gain this benefit in both your normal shape and your beast shape from Wild Shape.""" ),


        //Base Monk
        MONK_UNARMORED_DEFENSE("Unarmored Defense", """
                Beginning at 1st level, while you are wearing no armor and not wielding a shield, your AC equals 10 + your Dexterity modifier + your Wisdom modifier.""" ),
        MARTIAL_ARTS("Martial Arts", """
                At 1st level, your practice of martial arts gives you mastery of combat styles that use unarmed strikes and monk weapons, which are shortswords and any simple melee weapons that don't have the two-handed or heavy property.
                                
                You gain the following benefits while you are unarmed or wielding only monk weapons and you aren't wearing armor or wielding a shield:
                                
                You can use Dexterity instead of Strength for the attack and damage rolls of your unarmed strikes and monk weapons.
                You can roll a d4 in place of the normal damage of your unarmed strike or monk weapon. This die changes as you gain monk levels, as shown in the Martial Arts column of the Monk table.
                When you use the Attack action with an unarmed strike or a monk weapon on your turn, you can make one unarmed strike as a bonus action. For example, if you take the Attack action and attack with a quarterstaff, you can also make an unarmed strike as a bonus action, assuming you haven't already taken a bonus action this turn.
                Certain monasteries use specialized forms of the monk weapons. For example, you might use a club that is two lengths of wood connected by a short chain (called a nunchaku) or a sickle with a shorter, straighter blade (called a kama). Whatever name you use for a monk weapon, you can use the game statistics provided for the weapon on the Weapons page.""" ),
        KI("KI", """
                Starting at 2nd level, your training allows you to harness the mystic energy of ki. Your access to this energy is represented by a number of ki points. Your monk level determines the number of points you have, as shown in the Ki Points column of the Monk table.
                                
                You can spend these points to fuel various ki features. You start knowing three such features: Flurry of Blows, Patient Defense, and Step of the Wind. You learn more ki features as you gain levels in this class.
                                
                When you spend a ki point, it is unavailable until you finish a short or long rest, at the end of which you draw all of your expended ki back into yourself. You must spend at least 30 minutes of the rest meditating to regain your ki points.
                                
                Some of your ki features require your target to make a saving throw to resist the feature's effects. The saving throw DC is calculated as follows:
                                
                Ki save DC = 8 + your proficiency bonus + your Wisdom modifier
                                
                Flurry of Blows. Immediately after you take the Attack action on your turn, you can spend 1 ki point to make two unarmed strikes as a bonus action.
                Patient Defense. You can spend 1 ki point to take the Dodge action as a bonus action on your turn.
                Step of the Wind. You can spend 1 ki point to take the Disengage or Dash action as a bonus action on your turn, and your jump distance is doubled for the turn.""" ),
        UNARMORED_MOVEMENT("Unarmored Movement", """
                Starting at 2nd level, your speed increases by 10 feet while you are not wearing armor or wielding a shield. This bonus increases when you reach certain monk levels, as shown in the Monk table.
                                
                At 9th level, you gain the ability to move along vertical surfaces and across liquids on your turn without falling during the move.""" ),
        DEFLECT_MISSILES("Deflect Missiles", """
                Starting at 3rd level, you can use your reaction to deflect or catch the missile when you are hit by a ranged weapon attack. When you do so, the damage you take from the attack is reduced by 1d10 + your Dexterity modifier + your monk level.
                                
                If you reduce the damage to 0, you can catch the missile if it is small enough for you to hold in one hand and you have at least one hand free. If you catch a missile in this way, you can spend 1 ki point to make a ranged attack with a range of 20/60 using the weapon or piece of ammunition you just caught, as part of the same reaction. You make this attack with proficiency, regardless of your weapon proficiencies, and the missile counts as a monk weapon for the attack.""" ),
        SLOW_FALL("Slow Fall", """
                Beginning at 4th level, you can use your reaction when you fall to reduce any falling damage you take by an amount equal to five times your monk level.""" ),
        MONK_EXTRA_ATTACK("Extra Attack", """
                Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.""" ),
        STUNNING_STRIKE("Stunning Strike", """
                Starting at 5th level, you can interfere with the flow of ki in an opponent's body. When you hit another creature with a melee weapon attack, you can spend 1 ki point to attempt a stunning strike. The target must succeed on a Constitution saving throw or be stunned until the end of your next turn.""" ),
        KI_EMPOWERED_STRIKES("Ki-Empowered Strikes", """
                Starting at 6th level, your unarmed strikes count as magical for the purpose of overcoming resistance and immunity to nonmagical attacks and damage.""" ),
        MONK_EVASION("Evasion", """
                At 7th level, your instinctive agility lets you dodge out of the way of certain area effects, such as a blue dragon's lightning breath or a fireball spell. When you are subjected to an effect that allows you to make a Dexterity saving throw to take only half damage, you instead take no damage if you succeed on the saving throw, and only half damage if you fail.""" ),
        STILLNESS_OF_MIND("Stilness of Mind", """
                Starting at 7th level, you can use your action to end one effect on yourself that is causing you to be charmed or frightened""" ),
        PURITY_OF_BODY("Purity of Body", """
                At 10th level, your mastery of the ki flowing through you makes you immune to disease and poison.""" ),
        TONGUE_OF_THE_SUN_AND_MOON("Tongue of the Sun and Moon", """
                Starting at 13th level, you learn to touch the ki of other minds so that you understand all spoken languages. Moreover, any creature that can understand a language can understand what you say.""" ),
        DIAMOND_SOUL("Diamond Soul", """
                Beginning at 14th level, your mastery of ki grants you proficiency in all saving throws.
                                
                Additionally, whenever you make a saving throw and fail, you can spend 1 ki point to reroll it and take the second result.""" ), 
        MONK_TIMELESS_BODY("Timeless Body", """
                At 15th level, your ki sustains you so that you suffer none of the frailty of old age, and you can't be aged magically. You can still die of old age, however. In addition, you no longer need food or water.""" ),
        EMPTY_BODY("Empty Body", """
                Beginning at 18th level, you can use your action to spend 4 ki points to become invisible for 1 minute. During that time, you also have resistance to all damage but force damage.
                                
                Additionally, you can spend 8 ki points to cast the astral projection spell, without needing material components. When you do so, you can't take any other creatures with you.""" ),
        PERFECT_SELF("Perfect Self", """
                At 20th level, when you roll for initiative and have no ki points remaining, you regain 4 ki points.""" ),
        DIVINE_SENSE("Divine Sense", """
                The presence of strong evil registers on your senses like a noxious odor, and powerful good rings like heavenly music in your ears. As an action, you can open your awareness to detect such forces. Until the end of your next turn, you know the location of any celestial, fiend, or undead within 60 feet of you that is not behind total cover. You know the type (celestial, fiend, or undead) of any being whose presence you sense, but not its identity (the vampire Count Strahd von Zarovich, for instance). Within the same radius, you also detect the presence of any place or object that has been consecrated or desecrated, as with the Hallow spell.
                                
                You can use this feature a number of times equal to 1 + your Charisma modifier. When you finish a long rest, you regain all expended uses.""" ),
        LAY_ON_HANDS("Lay on Hands", """
                Your blessed touch can heal wounds. You have a pool of healing power that replenishes when you take a long rest. With that pool, you can restore a total number of hit points equal to your paladin level x 5.
                                
                As an action, you can touch a creature and draw power from the pool to restore a number of hit points to that creature, up to the maximum amount remaining in your pool.
                                
                Alternatively, you can expend 5 hit points from your pool of healing to cure the target of one disease or neutralize one poison affecting it. You can cure multiple diseases and neutralize multiple poisons with a single use of Lay on Hands, expending hit points separately for each one.
                                
                This feature has no effect on undead and constructs.""" ),
        PALADIN_FIGHTING_STYLE("Fighting Style", """
                Starting at 2nd level, you adopt a particular style of fighting as your specialty. Choose one of the following options. You can't take a Fighting Style option more than once, even if you later get to choose again.
                                
                Blessed Warrior. You learn two cantrips of your choice from the cleric spell list. They count as paladin spells for you, and Charisma is your spellcasting ability for them. Whenever you gain a level in this class, you can replace one of these cantrips with another cantrip from the cleric spell list.
                Blind Fighting. You have blindsight with a range of 10 feet. Within that range, you can effectively see anything that isn't behind total cover, even if you're blinded or in darkness. Moreover, you can see an invisible creature within that range, unless the creature successfully hides from you.
                Defense. While you are wearing armor, you gain a +1 bonus to AC.
                Dueling. When you are wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls with that weapon.
                Great Weapon Fighting. When you roll a 1 or 2 on a damage die for an attack you make with a melee weapon that you are wielding with two hands, you can reroll the die and must use the new roll, even if the new roll is a 1 or a 2. The weapon must have the two-handed or versatile property for you to gain this benefit.
                Interception. When a creature you can see hits a target, other than you, within 5 feet of you with an attack, you can use your reaction to reduce the damage the target takes by 1d10 + your proficiency bonus (to a minimum of 0 damage). You must be wielding a shield or a simple or martial weapon to use this reaction.
                Protection. When a creature you can see attacks a target other than you that is within 5 feet of you, you can use your reaction to impose disadvantage on the attack roll. You must be wielding a shield."""),
        DIVINE_SMITE("Divine Smite", """
                Starting at 2nd level, when you hit a creature with a melee weapon attack, you can expend one spell slot to deal radiant damage to the target, in addition to the weapon's damage. The extra damage is 2d8 for a 1st-level spell slot, plus 1d8 for each spell level higher than 1st, to a maximum of 5d8. The damage increases by 1d8 if the target is an undead or a fiend, to a maximum of 6d8."""),
        DIVINE_HEALTH("Divine Health", """
                By 3rd level, the divine magic flowing through you makes you immune to disease.""" ),
        PALADIN_EXTRA_ATTACK("Extra Attack", """
                Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.""" ),
        AURA_OF_PROTECTION("Aura of Protection", """
                Starting at 6th level, whenever you or a friendly creature within 10 feet of you must make a saving throw, the creature gains a bonus to the saving throw equal to your Charisma modifier (with a minimum bonus of +1). You must be conscious to grant this bonus.
                                
                At 18th level, the range of this aura increases to 30 feet.""" ),
        AURA_OF_COURAGE("Aura of Courage", """
                Starting at 10th level, you and friendly creatures within 10 feet of you can't be frightened while you are conscious.
                                
                At 18th level, the range of this aura increases to 30 feet.""" ), 
        IMPROVED_DIVINE_SMITE("Improved Divine Smite", """
                By 11th level, you are so suffused with righteous might that all your melee weapon strikes carry divine power with them. Whenever you hit a creature with a melee weapon, the creature takes an extra 1d8 radiant damage.""" ),
        CLEANSING_TOUCH("Cleansing Touch", """
                Beginning at 14th level, you can use your action to end one spell on yourself or on one willing creature that you touch.
                                
                You can use this feature a number of times equal to your Charisma modifier (a minimum of once). You regain expended uses when you finish a long rest.""" ),


        //Base Ranger
        FAVORED_ENEMY("Favored Enemy", """
                Beginning at 1st level, you have significant experience studying, tracking, hunting, and even talking to a certain type of enemy.
                                
                Choose a type of favored enemy: aberrations, beasts, celestials, constructs, dragons, elementals, fey, fiends, giants, monstrosities, oozes, plants, or undead. Alternatively, you can select two races of humanoid (such as gnolls and orcs) as favored enemies.
                                
                You have advantage on Wisdom (Survival) checks to track your favored enemies, as well as on Intelligence checks to recall information about them.
                                
                When you gain this feature, you also learn one language of your choice that is spoken by your favored enemies, if they speak one at all.
                                
                You choose one additional favored enemy, as well as an associated language, at 6th and 14th level. As you gain levels, your choices should reflect the types of monsters you have encountered on your adventures.""" ),
        NATURAL_EXPLORER("Natural Explorer", """
                Also at 1st level, you are particularly familiar with one type of natural environment and are adept at traveling and surviving in such regions. Choose one type of favored terrain: arctic, coast, desert, forest, grassland, mountain, swamp, or the Underdark. When you make an Intelligence or Wisdom check related to your favored terrain, your proficiency bonus is doubled if you are using a skill that you’re proficient in.
                                
                While traveling for an hour or more in your favored terrain, you gain the following benefits:
                                
                Difficult terrain doesn’t slow your group’s travel.
                Your group can’t become lost except by magical means.
                Even when you are engaged in another activity while traveling (such as foraging, navigating, or tracking), you remain alert to danger.
                If you are traveling alone, you can move stealthily at a normal pace.
                When you forage, you find twice as much food as you normally would.
                While tracking other creatures, you also learn their exact number, their sizes, and how long ago they passed through the area.
                You choose additional favored terrain types at 6th and 10th level.""" ), 
        RANGER_FIGHTING_STYLE("Fighting Style", """
                At 2nd level, you adopt a particular style of fighting as your specialty. Choose one of the following options. You can't take a Fighting Style option more than once, even if you later get to choose again.
                                
                Archery. You gain a +2 bonus to attack rolls you make with ranged weapons.
                Blind Fighting. You have blind sight with a range of 10 feet. Within that range, you can effectively see anything that isn't behind total cover, even if you're blinded or in darkness. Moreover, you can see an invisible creature within that range, unless the creature successfully hides from you.
                Defense. While you are wearing armor, you gain a +1 bonus to AC.
                Druidic Warrior. You learn two cantrips of your choice from the Druid spell list. They count as ranger spells for you, and Wisdom is your spellcasting ability for them. Whenever you gain a level in this class, you can replace one of these cantrips with another cantrip from the Druid spell list.
                Dueling. When you are wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls with that weapon.
                Thrown Weapon Fighting. You can draw a weapon that has the thrown property as part of the attack you make with the weapon.
                In addition, when you hit with a ranged attack using a thrown weapon, you gain a +2 bonus to the damage roll.
                Two-Weapon Fighting. When you engage in two-weapon fighting, you can add your ability modifier to the damage of the second attack.""" ),
        PRIMEVAL_AWARENESS("Primeval Awareness", """
                Beginning at 3rd level, you can use your action and expend one ranger spell slot to focus your awareness on the region around you. For 1 minute per level of the spell slot you expend, you can sense whether the following types of creatures are present within 1 mile of you (or within up to 6 miles if you are in your favored terrain): aberrations, celestials, dragons, elementals, fey, fiends, and undead. This feature doesn’t reveal the creatures’ location or number.""" ),
        RANGER_EXTRA_ATTACK("Extra Attack", """
                Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.""" ), 
        LANDS_STRIDE("Land's Stride", """
                Starting at 8th level, moving through nonmagical difficult terrain costs you no extra movement. You can also pass through nonmagical plants without being slowed by them and without taking damage from them if they have thorns, spines, or a similar hazard.
                                
                In addition, you have advantage on saving throws against plants that are magically created or manipulated to impede movement, such as those created by the Entangle spell.""" ),
        HIDE_IN_PLAIN_SIGHT("Hide in Plain Sight", """
                Starting at 10th level, you can spend 1 minute creating camouflage for yourself. You must have access to fresh mud, dirt, plants, soot, and other naturally occurring materials with which to create your camouflage.
                                
                Once you are camouflaged in this way, you can try to hide by pressing yourself up against a solid surface, such as a tree or wall, that is at least as tall and wide as you are. You gain a +10 bonus to Dexterity (Stealth) checks as long as you remain there without moving or taking actions. Once you move or take an action or a reaction, you must camouflage yourself again to gain this benefit.""" ),
        VANISH("Vanish", """
                Starting at 14th level, you can use the Hide action as a bonus action on your turn. Also, you can't be tracked by nonmagical means, unless you choose to leave a trail.""" ),
        FERAL_SENSES("Feral Senses", """
                At 18th level, you gain preternatural senses that help you fight creatures you can't see. When you attack a creature you can't see, your inability to see it doesn't impose disadvantage on your attack rolls against it.
                                
                You are also aware of the location of any invisible creature within 30 feet of you, provided that the creature isn't hidden from you and you aren't blinded or deafened.""" ),
        FOE_SLAYER("Foe Slayer", """
                At 20th level, you become an unparalleled hunter of your enemies. Once on each of your turns, you can add your Wisdom modifier to the attack roll or the damage roll of an attack you make against one of your favored enemies. You can choose to use this feature before or after the roll, but before any effects of the roll are applied.""" ),
        ROGUE_EXPERTISE("Expertise", """
                At 1st level, choose two of your skill proficiencies, or one of your skill proficiencies and your proficiency with thieves' tools. Your proficiency bonus is doubled for any ability check you make that uses either of the chosen proficiencies.
                                
                At 6th level, you can choose two more of your proficiencies (in skills or with thieves' tools) to gain this benefit.""" ),
        SNEAK_ATTACK("Sneak Attack", """
                Beginning at 1st level, you know how to strike subtly and exploit a foe's distraction. Once per turn, you can deal an extra 1d6 damage to one creature you hit with an attack if you have advantage on the attack roll. The attack must use a finesse or a ranged weapon.
                                
                You don't need advantage on the attack roll if another enemy of the target is within 5 feet of it, that enemy isn't incapacitated, and you don't have disadvantage on the attack roll.
                                
                The amount of the extra damage increases as you gain levels in this class, as shown in the Sneak Attack column of the Rogue table.""" ),
        THIEVES_CANT("Thieves' Cant", """
                During your rogue training you learned thieves' cant, a secret mix of dialect, jargon, and code that allows you to hide messages in seemingly normal conversation. Only another creature that knows thieves' cant understands such messages. It takes four times longer to convey such a message than it does to speak the same idea plainly.
                                
                In addition, you understand a set of secret signs and symbols used to convey short, simple messages, such as whether an area is dangerous or the territory of a thieves' guild, whether loot is nearby, or whether the people in an area are easy marks or will provide a safe house for thieves on the run.""" ),
        CUNNING_ACTIONS("Cunning Action", """
                Starting at 2nd level, your quick thinking and agility allow you to move and act quickly. You can take a bonus action on each of your turns in combat. This action can be used only to take the Dash, Disengage, or Hide action.""" ),
        UNCANNY_DODGE("Uncanny Dodge", """
                Starting at 5th level, when an attacker that you can see hits you with an attack, you can use your reaction to halve the attack's damage against you.""" ), 
        ROGUE_EVASION("Evasion", """
                Beginning at 7th level, you can nimbly dodge out of the way of certain area effects, such as a red dragon's fiery breath or an Ice Storm spell. When you are subjected to an effect that allows you to make a Dexterity saving throw to take only half damage, you instead take no damage if you succeed on the saving throw, and only half damage if you fail.""" ),
        RELIABLE_TALENT("Reliable Talent", """
                By 11th level, you have refined your chosen skills until they approach perfection. Whenever you make an ability check that lets you add your proficiency bonus, you can treat a d20 roll of 9 or lower as a 10.""" ),
        BLINDSENSE("Blindsense", """
                Starting at 14th level, if you are able to hear, you are aware of the location of any hidden or invisible creature within 10 feet of you.""" ),
        SLIPPERY_MIND("Slippery Mind", """
                By 15th level, you have acquired greater mental strength. You gain proficiency in Wisdom saving throws.""" ),
        ELUSIVE("Elusive", """
                Beginning at 18th level, you are so evasive that attackers rarely gain the upper hand against you. No attack roll has advantage against you while you aren't incapacitated.""" ),
        STROKE_OF_LUCK("Stroke of Luck", """
                At 20th level, you have an uncanny knack for succeeding when you need to. If your attack misses a target within range, you can turn the miss into a hit. Alternatively, if you fail an ability check, you can treat the d20 roll as a 20.
                                
                Once you use this feature, you can't use it again until you finish a short or long rest.""" ),

        //Base Sorcerer
        FONT_OF_MAGIC("Font of Magic", """
                Font of Magic
                At 2nd level, you tap into a deep wellspring of magic within yourself. This wellspring is represented by sorcery points, which allow you to create a variety of magical effects.
                                
                Sorcery Points. You have 2 sorcery points, and you gain more as you reach higher levels, as shown in the Sorcery Points column of the Sorcerer table. You can never have more sorcery points than shown on the table for your level. You regain all spent sorcery points when you finish a long rest.
                Flexible Casting. You can use your sorcery points to gain additional spell slots, or sacrifice spell slots to gain additional sorcery points. You learn other ways to use your sorcery points as you reach higher levels.
                Creating Spell Slots. You can transform unexpended sorcery points into one spell slot as a bonus action on your turn. The Creating Spell Slots table shows the cost of creating a spell slot of a given level. You can create spell slots no higher in level than 5th. Any spell slot you create with this feature vanishes when you finish a long rest.
                Converting a Spell Slot to Sorcery Points. As a bonus action on your turn, you can expend one spell slot and gain a number of sorcery points equal to the slot's level.
                Creating Spell Slots
                Spell Slot Level	Sorcery Point Cost
                1st	2
                2nd	3
                3rd	5
                4th	6
                5th	7""" ),
        METAMAGIC("Metamagic", """
                At 3rd level, you gain the ability to twist your spells to suit your needs. You gain two of the following Metamagic options of your choice. You gain another one at 10th and 17th level.
                                
                You can use only one Metamagic option on a spell when you cast it, unless otherwise noted.
                                
                Careful Spell. When you cast a spell that forces other creatures to make a saving throw, you can protect some of those creatures from the spell's full force. To do so, you spend 1 sorcery point and choose a number of those creatures up to your Charisma modifier (minimum of one creature). A chosen creature automatically succeeds on its saving throw against the spell.
                Distant Spell. When you cast a spell that has a range of 5 feet or greater, you can spend 1 sorcery point to double the range of the spell.
                When you cast a spell that has a range of touch, you can spend 1 sorcery point to make the range of the spell 30 feet.
                Empowered Spell. When you roll damage for a spell, you can spend 1 sorcery point to reroll a number of the damage dice up to your Charisma modifier (minimum of one). You must use the new rolls.
                You can use Empowered Spell even if you have already used a different Metamagic option during the casting of the spell.
                Extended Spell. When you cast a spell that has a duration of 1 minute or longer, you can spend 1 sorcery point to double its duration, to a maximum duration of 24 hours.
                Heightened Spell. When you cast a spell that forces a creature to make a saving throw to resist its effects, you can spend 3 sorcery points to give one target of the spell disadvantage on its first saving throw made against the spell.
                Quickened Spell. When you cast a spell that has a casting time of 1 action, you can spend 2 sorcery points to change the casting time to 1 bonus action for this casting.
                Seeking Spell. If you make an attack roll for a spell and miss, you can spend 2 sorcerer points to reroll the d20, and you must use the new roll.
                You can use Seeking Spell even if you have already used a different Metamagic option during the casting of the spell.
                Subtle Spell. When you cast a spell, you can spend 1 sorcery point to cast it without any somatic or verbal components.
                Transmuted Spell. When you cast a spell that deals a type of damage from the following list, you can spend 1 sorcery point to change that damage type to one of the other listed types: acid, cold, fire, lightning, poison, thunder.
                Twinned Spell. When you cast a spell that targets only one creature and doesn't have a range of self, you can spend a number of sorcery points equal to the spell's level to target a second creature in range with the same spell (1 sorcery point if the spell is a cantrip). To be eligible, a spell must be incapable of targeting more than one creature at the spell's current level. For example, magic missile and scorching ray aren't eligible, but ray of frost and chromatic orb are.""" ),
        SORCEROUS_RESTORATION("Sorcerous Restoration", """
                At 20th level, you regain 4 expended sorcery points whenever you finish a short rest.""" ),


        //Base Warlock
        ELDRITCH_INVOCTATIONS("Eldritch Invoctations", """
                In your study of occult lore, you have unearthed Eldritch Invocations, fragments of forbidden knowledge that imbue you with an abiding magical ability.
                                
                At 2nd level, you gain two eldritch invocations of your choice. When you gain certain warlock levels, you gain additional invocations of your choice, as shown in the Invocations Known column of the Warlock table. A level prerequisite refers to your level in this class.
                                
                Additionally, when you gain a level in this class, you can choose one of the invocations you know and replace it with another invocation that you could learn at that level.""" ),
        PACT_BOON("Pact Boon", """
                At 3rd level, your otherworldly patron bestows a gift upon you for your loyal service. You gain one of the following features of your choice.
                                
                Pact of the Blade
                You can use your action to create a pact weapon in your empty hand. You can choose the form that this melee weapon takes each time you create it. You are proficient with it while you wield it. This weapon counts as magical for the purpose of overcoming resistance and immunity to nonmagical attacks and damage.
                Your pact weapon disappears if it is more than 5 feet away from you for 1 minute or more. It also disappears if you use this feature again, if you dismiss the weapon (no action required), or if you die.
                You can transform one magic weapon into your pact weapon by performing a special ritual while you hold the weapon. You perform the ritual over the course of 1 hour, which can be done during a short rest.
                You can then dismiss the weapon, shunting it into an extradimensional space, and it appears whenever you create your pact weapon thereafter. You can't affect an artifact or a sentient weapon in this way. The weapon ceases being your pact weapon if you die, if you perform the 1-hour ritual on a different weapon, or if you use a 1-hour ritual to break your bond to it. The weapon appears at your feet if it is in the extradimensional space when the bond breaks.
                Pact of the Chain
                You learn the find familiar spell and can cast it as a ritual. The spell doesn't count against your number of spells known.
                When you cast the spell, you can choose one of the normal forms for your familiar or one of the following special forms: imp, pseudodragon, quasit, or sprite.
                Additionally, when you take the Attack action, you can forgo one of your own attacks to allow your familiar to use its reaction to make one attack with its reaction.
                Pact of the Tome
                Your patron gives you a grimoire called a Book of Shadows. When you gain this feature, choose three cantrips from any class's spell list (the three needn't be from the same list). While the book is on your person, you can cast those cantrips at will. They don't count against your number of cantrips known. If they don't appear on the warlock spell list, they are nonetheless warlock spells for you.
                If you lose your Book of Shadows, you can perform a 1-hour ceremony to receive a replacement from your patron. This ceremony can be performed during a short or long rest, and it destroys the previous book. The book turns to ash when you die.
                Pact of the Talisman
                Your patron gives you an amulet, a talisman that can aid the wearer when the need is great. When the wearer fails an ability check, they can add a d4 to the roll, potentially turning the roll into a success. This benefit can be used a number of times equal to your proficiency bonus, and all expended uses are restored when you finish a long rest.
                If you lose the talisman, you can perform a 1-hour ceremony to receive a replacement from your patron. This ceremony can be performed during a short or long rest, and it destroys the previous amulet. The talisman turns to ash when you die.""" ),
        MYSTIC_ARCANUM("Mystic Arcanum", """
                At 11th level, your patron bestows upon you a magical secret called an arcanum. Choose one 6th-level spell from the warlock spell list as this arcanum.
                                
                You can cast your arcanum spell once without expending a spell slot. You must finish a long rest before you can do so again.
                                
                At higher levels, you gain more warlock spells of your choice that can be cast in this way: one 7th-level spell at 13th level, one 8th-level spell at 15th level, and one 9th-level spell at 17th level. You regain all uses of your Mystic Arcanum when you finish a long rest.""" ),
        ELDTRICH_MASTER("Eldtrich Master", """
                At 20th level, you can draw on your inner reserve of mystical power while entreating your patron to regain expended spell slots. You can spend 1 minute entreating your patron for aid to regain all your expended spell slots from your Pact Magic feature. Once you regain spell slots with this feature, you must finish a long rest before you can do so again.""" ), 
        
        
        //Base Wizart
        ARCANE_RECOVERY("Arcane Recovery", """
                You have learned to regain some of your magical energy by studying your spellbook. Once per day when you finish a short rest, you can choose expended spell slots to recover. The spell slots can have a combined level that is equal to or less than half your wizard level (rounded up), and none of the slots can be 6th level or higher.
                                
                For example, if you're a 4th-level wizard, you can recover up to two levels worth of spell slots. You can recover either a 2nd-level spell slot or two 1st-level spell slots.""" ),
        SPELL_MASTERY("Spell Mastery", """
                At 18th level, you have achieved such mastery over certain spells that you can cast them at will. Choose a 1st-level wizard spell and a 2nd-level wizard spell that are in your spellbook. You can cast those spells at their lowest level without expending a spell slot when you have them prepared. If you want to cast either spell at a higher level, you must expend a spell slot as normal.
                                
                By spending 8 hours in study, you can exchange one or both of the spells you chose for different spells of the same levels.""" ),
        SIGNATURE_SPELLS("Signature Spells", """
                When you reach 20th level, you gain mastery over two powerful spells and can cast them with little effort. Choose two 3rd-level wizard spells in your spellbook as your signature spells. You always have these spells prepared, they don't count against the number of spells you have prepared, and you can cast each of them once at 3rd level without expending a spell slot. When you do so, you can't do so again until you finish a short or long rest.
                                
                If you want to cast either spell at a higher level, you must expend a spell slot as normal.""" ),

        //SubClerics
        ARCANE_INITIATE("Arcane Initiate", """
                When you choose this domain at 1st level, you gain proficiency in the Arcana skill, and you gain two cantrips of your choice from the wizard spell list. For you, these cantrips count as cleric cantrips.""" ),
        CHANNEL_DIVINITY_ARCANE_ABJURATION("Channel Divinity: Arcane Abjuration", """
                Starting at 2nd level, you can use your Channel Divinity to abjure otherworldly creatures.
                                
                As an action, you present your holy symbol, and one celestial, elemental, fey, or fiend of your choice that is within 30 feet of you must make a Wisdom saving throw, provided that the creature can see or hear you. If the creature fails its saving throw, it is turned for 1 minute or until it takes any damage.
                                
                A turned creature must spend its turns trying to move as far away from you as it can, and it can't willingly end its move in a space within 30 feet of you. It also can't take reactions. For its action, it can only use the Dash action or try to escape from an effect that prevents it from moving. If there's nowhere to move, the creature can use the Dodge action.
                                
                After you reach 5th level, when a creature fails its saving throw against your Arcane Abjuration feature, the creature is banished for 1 minute (as in the Banishment spell, no concentration required) if it isn't on its plane of origin and its challenge rating is at or below a certain threshold, as shown on the Arcane Banishment table.
                                
                Arcane Banishment
                Cleric Level	Banishes Creatures of CR…
                5th	1/2 or lower
                8th	1 or lower
                11th	2 or lower
                14th	3 or lower
                17th	4 or lower""" ),
        SPELL_BREAKER("Spell Breaker", """
                Starting at 6th level, when you restore hit points to an ally with a spell of 1st level or higher, you can also end one spell of your choice on that creature. The level of the spell you end must be equal to or lower than the level of the spell slot you use to cast the healing spell.""" ),
        POTENT_SPELLCASTING("Potent Spellcasting", """
                Starting at 8th level, you add your Wisdom modifier to the damage you deal with any cleric cantrip.""" ),
        ARCANE_MASTERY("Arcane Mastery", """
                At 17th level, you choose four spells from the wizard spell list, one from each of the following levels: 6th, 7th, 8th, and 9th. You add them to your list of domain spells. Like your other domain spells, they are always prepared and count as cleric spells for you.""" ),
        DEATH_BONUS_PROFICIENCY("Bonus Proficiency", """
                When you choose this domain at 1st level, you gain proficiency with martial weapons.""" ),
        REAPER("Reaper", """
                At 1st level, you learn one necromancy cantrip of your choice from any spell list. When you cast a necromancy cantrip that normally targets only one creature, the spell can instead target two creatures within range and within 5 feet of each other.""" ),
        CHANNEL_DIVINITY_TOUCH_OF_DEATH("Channel Divinity: Touch of Death", """
                Starting at 2nd level, you can use Channel Divinity to destroy another creature's life force by touch. When you hit a creature with a melee attack, you can use Channel Divinity to deal extra necrotic damage to the target. The damage equals 5 + twice your cleric level.""" ),
        INESCAPABLE_DESTRUCTION("Inescapable Destruction", """
                Starting at 6th level, your ability to channel negative energy becomes more potent. Necrotic damage dealt by your cleric spells and Channel Divinity options ignores resistance to necrotic damage.""" ),
        DIVINE_STRIKE("Divine Strike", """
                At 8th level, you gain the ability to infuse your weapon strikes with necrotic energy. Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an a 1d8 necrotic damage to the target. When you reach 14th level, the extra damage increases to 2d8.""" ),
        IMPROVED_REAPER("Improved Reaper", """
                Starting at 17th level, when you cast a necromancy spell of 1st through 5th level that targets only one creature, the spell can instead target two creatures within range and within 5 feet of each other. If the spell consumes its material components, you must provide them for each target.""" );



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

    public static void initDatabase(){


        initClasses();
        initRaces();
        initBackgrounds();
    }

    private static void initBackgrounds() {
        backgrounds = new ArrayList<>();

        backgrounds.add(new Acolyte());

    }


    private static void initRaces(){
        races= new ArrayList<>();
        //PHB
        races.add(new Elf());
        races.add(new Dragonborn());

    }

    private static void initClasses() {
        playerClasses= new ArrayList<>();
        //PHB
        playerClasses.add(new Barbarian());
        playerClasses.add(new Bard());
        playerClasses.add(new Cleric());
        playerClasses.add(new Druid());
        playerClasses.add(new Fighter());
        playerClasses.add(new Monk());
        playerClasses.add(new Paladin());
        playerClasses.add(new Ranger());
        playerClasses.add(new Rogue());

    }


}
