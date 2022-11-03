import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Fighter extends PlayerClass{
    public PlayerClass subclass;

    public Fighter(Player owner) {
        super(owner);

        name = "Fighter";
        classLvl = 0;
        hitDie = 10;
        savingThrowProf.add(Ability.STRENGTH);
        savingThrowProf.add(Ability.CONSTITUTION);
        possibleSkills= new Skills[]{Skills.ACROBATICS,Skills.ANIMAL_HANDLING,Skills.ATHLETICS,Skills.HISTORY,Skills.INSIGHT,Skills.INTIMIDATION,Skills.PERCEPTION,Skills.SURVIVAL};

    }

    public void makeClass() throws IOException {
        skillProf = (ArrayList<Skills>) Arrays.asList(new Skills[]{chooseSkill(),chooseSkill()});
    }





    @Override
    public void lvlUp() {
        classLvl++;

        //TODO Add Martial Versatility Option to all Ability Score Lvls
        switch (classLvl){
            case 1  -> {features.add(Database.Features.FIGHTING_STYLE.feature);  features.add(Database.Features.SECOND_WIND.feature);}
            case 2  -> {features.add(Database.Features.ACTION_SURGE.feature);}
            case 3  -> {subclass = chooseSubclass();}
            case 4, 19, 16, 14, 12, 8, 6 -> {abilityScoreImprovement();}
            case 5  -> {features.add(Database.Features.EXTRA_ATTACK.feature);}
            case 7, 15, 10, 18 -> {/*subclass.lvlUPTo(classLvl);*/} //TODO !!!! ADD child class SUbClass to Playyerclass!!! Atm : Recursive call of lvlUpTo
            case 9  -> {features.add(Database.Features.INDOMITABLE.feature);}
            case 11 -> {/* Already added at lvl 5 */}
            case 13 -> {/* Already added at lvl 9 */}
            case 17 -> {/* Already added at lvl 2 and 9 */}
            case 20 -> {/* Alreasy added at lvl 5 */}
        }

    }

    @Override
    public void lvlUPTo(int newLVl){
        for (int i=classLvl; i<newLVl; i++){
            lvlUp();
        }
    }



    private Fighter chooseSubclass() {
        return new Fighter(this.owner);
    }
}

/*


    SUBCLASSES


 */

