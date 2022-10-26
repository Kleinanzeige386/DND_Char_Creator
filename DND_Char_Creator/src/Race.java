import java.util.ArrayList;
import java.util.stream.Collectors;

public class Race {
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
        returnString.append("\nLanguages: \n -");
        returnString.append(String.join("\n -",languages));
        returnString.append("\n\nFeatures: \n -");
        returnString.append(String.join(features.stream().map(Object::toString)
                                                         .collect(Collectors.joining("\n\n")))); //TODO Update to String method

        return returnString.toString();
    }

    private String abilityScoreIncreaseToString() {
        StringBuilder returnString = new StringBuilder();//TODO

        return returnString.toString();
    }


    public String getNameString() {
        return name;
    }
}
