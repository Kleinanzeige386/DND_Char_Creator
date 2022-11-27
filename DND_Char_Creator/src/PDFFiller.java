import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.util.List;




public class PDFFiller {
    private static List<PDField> field;
    private static Player player;



    public static void buildPDF(Player playerData, String path) throws IOException {
        player = playerData;


        //load the document
        PDDocument pdfDocument = PDDocument.load(new File("./sources/template.pdf"));

        //get the document catalog
        PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();

        // as there might not be an AcroForm entry a null check is neccessary
        if (acroForm != null)
        {
            field = acroForm.getFields();

            writeToField();




        }

        //Save and close PDF
        pdfDocument.save(path+"/"+player.name+".pdf");
        pdfDocument.close();

    }


    private static void writeToField() throws IOException {
        writePlayerBasics();

        writeHP();

        writeSavingThrows();
        writeAbilities();
        writeSkills();

        writeFightValues();
        writeSpellcast();

        writeLanguagesAndOtherProficiencies();

        writeCoins();
        writeInventory();

        writeFeatures();
        
        if (player.playerClass instanceof Magical)writeSpellslots();

    }

    private static void writeSpellslots() throws IOException {
        int[] slots = ((Magical)player.playerClass).getSpellSlots();
        field.get(PDFFields.SlotsTotal_19.value).setValue(String.valueOf(slots[1]));
        field.get(PDFFields.SlotsTotal_20.value).setValue(String.valueOf(slots[2]));
        field.get(PDFFields.SlotsTotal_21.value).setValue(String.valueOf(slots[3]));
        field.get(PDFFields.SlotsTotal_22.value).setValue(String.valueOf(slots[4]));
        field.get(PDFFields.SlotsTotal_23.value).setValue(String.valueOf(slots[5]));
        field.get(PDFFields.SlotsTotal_24.value).setValue(String.valueOf(slots[6]));
        field.get(PDFFields.SlotsTotal_25.value).setValue(String.valueOf(slots[7]));
        field.get(PDFFields.SlotsTotal_26.value).setValue(String.valueOf(slots[8]));
        field.get(PDFFields.SlotsTotal_27.value).setValue(String.valueOf(slots[9]));

    }

    private static void writeFeatures() throws IOException {
        field.get(PDFFields.Features_and_Traits.value).setValue(IOManager.ArrayListToNames(player.features));
    }

    private static void writePlayerBasics() throws IOException {
        field.get(PDFFields.CharacterName.value).setValue(player.name);
        field.get(PDFFields.CharacterName_2.value).setValue(player.name);
        field.get(PDFFields.Race_.value).setValue(player.race.name);
        field.get(PDFFields.ClassLevel.value).setValue(player.playerClass.getNameString()+"  "+player.lvl);
        field.get(PDFFields.Alignment.value).setValue(String.valueOf(player.alignment));
    }


    private static void writeHP() throws IOException {
        field.get(PDFFields.HDTotal.value).setValue(String.valueOf(player.lvl));
        field.get(PDFFields.HD.value).setValue(String.valueOf(player.playerClass.hitDie));
        field.get(PDFFields.HPMax.value).setValue(String.valueOf(player.maxHP));
        field.get(PDFFields.HPCurrent.value).setValue(String.valueOf(player.currentHP));
        field.get(PDFFields.HPTemp.value).setValue(String.valueOf(player.tempHP));
    }


    private static void writeSavingThrows() throws IOException {
        writeSingleST(47, PDFFields.ST_Strength.value, player.abilities[0]);
        writeSingleST(48, PDFFields.ST_Dexterity.value, player.abilities[1]);
        writeSingleST(49, PDFFields.ST_Constitution.value, player.abilities[2]);
        writeSingleST(50, PDFFields.ST_Intelligence.value, player.abilities[3]);
        writeSingleST(51, PDFFields.ST_Wisdom.value, player.abilities[4]);
        writeSingleST(52, PDFFields.ST_Charisma.value, player.abilities[5]);

    }
    private static void writeSingleST(int profButton, int valueField, AbilityScore AS) throws IOException {
        if (!AS.proficient){
            field.get(profButton).setValue("Off");
            field.get(valueField).setValue(String.valueOf(AS.modifier));
        }else{
            field.get(valueField).setValue(String.valueOf(AS.modifier+ player.proficiencyBonus));
        }

    }

    private static void writeAbilities() throws IOException {
        //Player.abilities STR DEX CON INT WIS CHA
        AbilityScore[] tempArr = player.abilities;
        field.get(PDFFields.STR.value).setValue(String.valueOf(tempArr[0].modifier));
        field.get(PDFFields.STRmod.value).setValue(String.valueOf(tempArr[0].amount));

        field.get(PDFFields.DEX.value).setValue(String.valueOf(tempArr[1].modifier));
        field.get(PDFFields.DEXmod_.value).setValue(String.valueOf(tempArr[1].amount));

        field.get(PDFFields.CON.value).setValue(String.valueOf(tempArr[2].modifier));
        field.get(PDFFields.CONmod.value).setValue(String.valueOf(tempArr[2].amount));

        field.get(PDFFields.INT.value).setValue(String.valueOf(tempArr[3].modifier));
        field.get(PDFFields.INTmod.value).setValue(String.valueOf(tempArr[3].amount));

        field.get(PDFFields.WIS.value).setValue(String.valueOf(tempArr[4].modifier));
        field.get(PDFFields.WISmod.value).setValue(String.valueOf(tempArr[4].amount));

        field.get(PDFFields.CHA.value).setValue(String.valueOf(tempArr[5].modifier));
        field.get(PDFFields.CHamod.value).setValue(String.valueOf(tempArr[5].amount));

        field.get(PDFFields.Passive.value).setValue(String.valueOf(tempArr[4].modifier+10));
    }

    private static void writeSkills() throws IOException {
        int[] skillFields = getSkillPositions();

        for (int i = 0; i < 18; i++) {
            writeSingleSkill(74 + i, skillFields[i], player.skills[i]);
        }
    }
    private static int[] getSkillPositions(){
            int[] temp = new int[18];

            temp[0] = PDFFields.Acrobatics.value;
            temp[1] = PDFFields.Animal.value;
            temp[2] = PDFFields.Arcana.value;
            temp[3] = PDFFields.Athletics.value;
            temp[4] = PDFFields.Deception_.value;
            temp[5] = PDFFields.History_.value;
            temp[6] = PDFFields.Insight.value;
            temp[7] = PDFFields.Intimidation.value;
            temp[8] = PDFFields.Investigation_.value;
            temp[9] = PDFFields.Medicine.value;
            temp[10] = PDFFields.Nature.value;
            temp[11] = PDFFields.Perception_.value;
            temp[12] = PDFFields.Performance.value;
            temp[13] = PDFFields.Persuasion.value;
            temp[14] = PDFFields.Religion.value;
            temp[15] = PDFFields.SleightofHand.value;
            temp[16] = PDFFields.Stealth_.value;
            temp[17] = PDFFields.Survival.value;


            return temp;
        }
    private static void writeSingleSkill(int profButton, int valueField, Skill skill) throws IOException {
        if (!skill.prof){
            field.get(profButton).setValue("Off");
            field.get(valueField).setValue(String.valueOf(skill.value));
        }else{
            field.get(valueField).setValue(String.valueOf(skill.value+ player.proficiencyBonus));
        }

    }


    private static void writeFightValues() throws IOException {
        field.get(PDFFields.AC.value).setValue(String.valueOf(player.AC));
        field.get(PDFFields.Initiative.value).setValue(String.valueOf(player.initiative));
        field.get(PDFFields.Speed.value).setValue(String.valueOf(player.speed));
        field.get(PDFFields.ProfBonus.value).setValue(String.valueOf(player.proficiencyBonus));
    }

    private static void writeSpellcast() throws IOException {
        if(player.playerClass instanceof Magical){

            field.get(PDFFields.Spellcasting_Class_2.value).setValue(player.playerClass.getNameString());
            field.get(PDFFields.SpellcastingAbility_2.value).setValue(((Magical) player.playerClass).getcastingAbility().name());
            field.get(PDFFields.SpellSaveDC__2.value).setValue(String.valueOf(player.spellSaveDC));
            field.get(PDFFields.SpellAtkBonus_2.value).setValue(String.valueOf(player.spellAtackModifier+player.proficiencyBonus));

        }else {

            field.get(PDFFields.Spellcasting_Class_2.value).setValue("/////");
            field.get(PDFFields.SpellcastingAbility_2.value).setValue("/////");
            field.get(PDFFields.SpellSaveDC__2.value).setValue("/////");
            field.get(PDFFields.SpellAtkBonus_2.value).setValue("/////");

        }
    }


    private static void writeLanguagesAndOtherProficiencies() throws IOException {

        String writeString = player.languagesToString() +
                "\n\n" +
                player.toolProfToString();

        field.get(PDFFields.ProficienciesLang.value).setValue(writeString);

    }


    private static void writeCoins() throws IOException {
        field.get(PDFFields.CP.value).setValue(String.valueOf(player.coins[0]));
        field.get(PDFFields.SP.value).setValue(String.valueOf(player.coins[1]));
        field.get(PDFFields.EP.value).setValue(String.valueOf(player.coins[2]));
        field.get(PDFFields.GP.value).setValue(String.valueOf(player.coins[3]));
        field.get(PDFFields.PP.value).setValue(String.valueOf(player.coins[4]));

    }

    private static void writeInventory() throws IOException {
        field.get(PDFFields.Equipment.value).setValue(player.inventoryToString());
    }







}

@SuppressWarnings("unused")
enum PDFFields{
    //ST = Saving Throw
    //WPN = Weapon


    ClassLevel(0),
    Background(1),
    PlayerName(2),
    CharacterName(3),
    Race_(4),
    Alignment(5),
    XP(6),
    Inspiration(7),
    STR(8),
    ProfBonus(9),
    AC(10),
    Initiative(11),
    Speed(12),
    PersonalityTraits_(13),
    STRmod(14),
    HPMax(15),
    ST_Strength(16),
    DEX(17),
    HPCurrent(18),
    Ideals(19),
    DEXmod_(20),
    HPTemp(21),
    Bonds(22),
    CON(23),
    HDTotal(24),
    Check_Box_12(25),
    Check_Box_13(26),
    Check_Box_14(27),
    CONmod(28),
    Check_Box_15(29),
    Check_Box_16(30),
    Check_Box_17(31),
    HD(32),
    Flaws(33),
    INT(34),
    ST_Dexterity(35),
    ST_Constitution(36),
    ST_Intelligence(37),
    ST_Wisdom(38),
    ST_Charisma(39),
    Acrobatics(40),
    Animal(41),
    Athletics(42),
    Deception_(43),
    History_(44),
    Insight(45),
    Intimidation(46),
    Check_Box_11(47),
    Check_Box_18(48),
    Check_Box_19(49),
    Check_Box_20(50),
    Check_Box_21(51),
    Check_Box_22(52),
    Wpn_Name(53),
    Wpn1_AtkBonus(54),
    Wpn1_Damage(55),
    INTmod(56),
    Wpn_Name_2(57),
    Wpn2_AtkBonus_(58),
    Wpn2_Damage_(59),
    Investigation_(60),
    WIS(61),
    Wpn_Name_3(62),
    Wpn3_AtkBonus__(63),
    Arcana(64),
    Wpn3_Damage_(65),
    Perception_(66),
    WISmod(67),
    CHA(68),
    Nature(69),
    Performance(70),
    Medicine(71),
    Religion(72),
    Stealth_(73),

    //Skill Proficiencies I think
    Check_Box_23(74),
    Check_Box_24(75),
    Check_Box_25(76),
    Check_Box_26(77),
    Check_Box_27(78),
    Check_Box_28(79),
    Check_Box_29(80),
    Check_Box_30(81),
    Check_Box_31(82),
    Check_Box_32(83),
    Check_Box_33(84),
    Check_Box_34(85),
    Check_Box_35(86),
    Check_Box_36(87),
    Check_Box_37(88),
    Check_Box_38(89),
    Check_Box_39(90),
    Check_Box_40(91),

    Persuasion(92),
    SleightofHand(93),
    CHamod(94),
    Survival(95),
    AttacksSpellcasting(96),
    Passive(97),
    CP(98),
    ProficienciesLang(99),
    SP(100),
    EP(101),
    GP(102),
    PP(103),
    Equipment(104),
    Features_and_Traits(105),
    CharacterName_2(106),
    Age(107),
    Height(108),
    Weight(109),
    Eyes(110),
    Skin(111),
    Hair(112),
    Faction_Symbol_Image(113),
    Allies(114),
    FactionName(115),
    Backstory(116),
    Traits(117),
    Treasure(118),
    CHARACTER_IMAGE(119),
    Spellcasting_Class_2(120),
    SpellcastingAbility_2(121),
    SpellSaveDC__2(122),
    SpellAtkBonus_2(123),
    SlotsTotal_19(124),
    SlotsRemaining_19(125),
    Spells_1014(126),
    Spells_1015(127),
    Spells_1016(128),
    Spells_1017(129),
    Spells_1018(130),
    Spells_1019(131),
    Spells_1020(132),
    Spells_1021(133),
    Spells_1022(134),
    Check_Box_314(135),
    Check_Box_3031(136),
    Check_Box_3032(137),
    Check_Box_3033(138),
    Check_Box_3034(139),
    Check_Box_3035(140),
    Check_Box_3036(141),
    Check_Box_3037(142),
    Check_Box_3038(143),
    Check_Box_3039(144),
    Check_Box_3040(145),
    Check_Box_321(146),
    Check_Box_320(147),
    Check_Box_3060(148),
    Check_Box_3061(149),
    Check_Box_3062(150),
    Check_Box_3063(151),
    Check_Box_3064(152),
    Check_Box_3065(153),
    Check_Box_3066(154),
    Check_Box_315(155),
    Check_Box_3041(156),
    Spells_1023(157),
    Check_Box_251(158),
    Check_Box_309(159),
    Check_Box_3010(160),
    Check_Box_3011(161),
    Check_Box_3012(162),
    Check_Box_3013(163),
    Check_Box_3014(164),
    Check_Box_3015(165),
    Check_Box_3016(166),
    Check_Box_3017(167),
    Check_Box_3018(168),
    Check_Box_3019(169),
    Spells_1024(170),
    Spells_1025(171),
    Spells_1026(172),
    Spells_1027(173),
    Spells_1028(174),
    Spells_1029(175),
    Spells_1030(176),
    Spells_1031(177),
    Spells_1032(178),
    Spells_1033(179),
    SlotsTotal_20(180),
    SlotsRemaining_20(181),
    Spells_1034(182),
    Spells_1035(183),
    Spells_1036(184),
    Spells_1037(185),
    Spells_1038(186),
    Spells_1039(187),
    Spells_1040(188),
    Spells_1041(189),
    Spells_1042(190),
    Spells_1043(191),
    Spells_1044(192),
    Spells_1045(193),
    Spells_1046(194),
    SlotsTotal_21(195),
    SlotsRemaining_21(196),
    Spells_1047(197),
    Spells_1048(198),
    Spells_1049(199),
    Spells_1050(200),
    Spells_1051(201),
    Spells_1052(202),
    Spells_1053(203),
    Spells_1054(204),
    Spells_1055(205),
    Spells_1056(206),
    Spells_1057(207),
    Spells_1058(208),
    Spells_1059(209),
    SlotsTotal_22(210),
    SlotsRemaining_22(211),
    Spells_1060(212),
    Spells_1061(213),
    Spells_1062(214),
    Spells_1063(215),
    Spells_1064(216),
    Check_Box_323(217),
    Check_Box_322(218),
    Check_Box_3067(219),
    Check_Box_3068(220),
    Check_Box_3069(221),
    Check_Box_3070(222),
    Check_Box_3071(223),
    Check_Box_3072(224),
    Check_Box_3073(225),
    Spells_1065(226),
    Spells_1066(227),
    Spells_1067(228),
    Spells_1068(229),
    Spells_1069(230),
    Spells_1070(231),
    Spells_1071(232),
    Check_Box_317(233),
    Spells_1072(234),
    SlotsTotal_23(235),
    SlotsRemaining_23(236),
    Spells_1073(237),
    Spells_1074(238),
    Spells_1075(239),
    Spells_1076(240),
    Spells_1077(241),
    Spells_1078(242),
    Spells_1079(243),
    Spells_1080(244),
    Spells_1081(245),
    SlotsTotal_24(246),
    SlotsRemaining_24(247),
    Spells_1082(248),
    Spells_1083(249),
    Spells_1084(250),
    Spells_1085(251),
    Spells_1086(252),
    Spells_1087(253),
    Spells_1088(254),
    Spells_1089(255),
    Spells_1090(256),
    SlotsTotal_25(257),
    SlotsRemaining_25(258),
    Spells_1091(259),
    Spells_1092(260),
    Spells_1093(261),
    Spells_1094(262),
    Spells_1095(263),
    Spells_1096(264),
    Spells_1097(265),
    Spells_1098(266),
    Spells_1099(267),
    SlotsTotal_26(268),
    SlotsRemaining_26(269),
    Spells_10100(270),
    Spells_10101(271),
    Spells_10102(272),
    Spells_10103(273),
    Check_Box_316(274),
    Check_Box_3042(275),
    Check_Box_3043(276),
    Check_Box_3044(277),
    Check_Box_3045(278),
    Check_Box_3046(279),
    Check_Box_3047(280),
    Check_Box_3048(281),
    Check_Box_3049(282),
    Check_Box_3050(283),
    Check_Box_3051(284),
    Check_Box_3052(285),
    Spells_10104(286),
    Check_Box_325(287),
    Check_Box_324(288),
    Check_Box_3074(289),
    Check_Box_3075(290),
    Check_Box_3076(291),
    Check_Box_3077(292),
    Spells_10105(293),
    Spells_10106(294),
    Check_Box_3078(295),
    SlotsTotal_27(296),
    SlotsRemaining_27(297),
    Check_Box_313(298),
    Check_Box_310(299),
    Check_Box_3020(300),
    Check_Box_3021(301),
    Check_Box_3022(302),
    Check_Box_3023(303),
    Check_Box_3024(304),
    Check_Box_3025(305),
    Check_Box_3026(306),
    Check_Box_3027(307),
    Check_Box_3028(308),
    Check_Box_3029(309),
    Check_Box_3030(310),
    Spells_10107(311),
    Spells_10108(312),
    Spells_10109(313),
    Spells_101010(314),
    Spells_101011(315),
    Spells_101012(316),
    Check_Box_319(317),
    Check_Box_318(318),
    Check_Box_3053(319),
    Check_Box_3054(320),
    Check_Box_3055(321),
    Check_Box_3056(322),
    Check_Box_3057(323),
    Check_Box_3058(324),
    Check_Box_3059(325),
    Check_Box_327(326),
    Check_Box_326(327),
    Check_Box_3079(328),
    Check_Box_3080(329),
    Check_Box_3081(330),
    Check_Box_3082(331),
    Spells_101013(332),
    Check_Box_3083(333);


    final int value;
    PDFFields(int i) {
        value=i;
    }
}
