import java.io.IOException;
import java.util.ArrayList;

public abstract class Race implements Named{
    public String name;
    public ArrayList<AbilityScore> abilityScoreIncrease;
    public int speed;
    public ArrayList<String> languages;
    public ArrayList<Feature> features;
    public ArrayList<String> damageResistances;


    public Race() {
        abilityScoreIncrease = new ArrayList<>();
        languages = new ArrayList<>();
        features = new ArrayList<>();
        damageResistances= new ArrayList<>();

        name="N.A.";
        speed=0;
    }


    public String getName() {
        return name;
    }

    public abstract void generateRace() throws IOException;
}














