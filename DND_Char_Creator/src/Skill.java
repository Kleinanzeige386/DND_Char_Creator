import java.util.stream.Stream;

public class Skill {
    public Skills skill;
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
             return "X "+ skill + value;
         }else{
             return "O "+ skill + value;
         }
     }
 }
