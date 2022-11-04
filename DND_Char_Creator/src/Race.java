import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class Race {
    public String name;
    public ArrayList<AbilityScore> abilityScoreIncrease;
    public int speed;
    public ArrayList<String> languages;
    public ArrayList<Feature> features;
    public ArrayList<String> damageResistances;

    public Race(String name, ArrayList<AbilityScore> abilityScoreIncrease, int speed, ArrayList<String> languages, ArrayList<Feature> features,ArrayList<String> damageResistances) {
        this.name = name;
        this.abilityScoreIncrease = abilityScoreIncrease;
        this.speed = speed;
        this.languages = languages;
        this.features = features;
        this.damageResistances = damageResistances;
    }

    public Race() {
        abilityScoreIncrease = new ArrayList<>();
        languages = new ArrayList<>();
        features = new ArrayList<>();
        damageResistances= new ArrayList<>();

        name="N.A.";
        speed=0;
    }

    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();

        returnString.append(name);
        returnString.append("\n----------");
        returnString.append("\n"+abilityScoreIncreaseToString());
        returnString.append("\nSpeed: "+speed+"ft.");
        returnString.append("\nLanguages:");
        returnString.append(IOManager.ArrayListToString(languages));
        returnString.append("\n\nFeatures:");
        returnString.append(IOManager.ArrayListToString(features));

        return returnString.toString();
    }

    private String abilityScoreIncreaseToString() {
        StringBuilder returnString = new StringBuilder();//TODO

        return returnString.toString();
    }


    public String getNameString() {
        return name;
    }

    public abstract void generateRace() throws IOException;
}














