
public class Skill implements Named{
    public final Skills skill;
    public boolean prof;
    public int value;

     public Skill(Skills s) {
         skill=s;
         prof=false;
         value=0;
     }

     @Override
     public String toString(){
         if (prof){
             return "   X       "+ value+"  "+ skill ;
         }else{
             return "   O       "+ value+"  "+ skill ;
         }
     }

    @Override
    public String getName() {
        return skill.name() ;
    }
}
