import java.util.ArrayList;
import java.util.stream.Collectors;

public class Race {
    public String name;
    public AbilityScore abilityScoreIncrease;
    public int speed;
    public ArrayList<String> languages;
    public ArrayList<Feature> features;

    public Race(String name, AbilityScore abilityScoreIncrease, int speed, ArrayList<String> languages, ArrayList<Feature> features) {
        this.name = name;
        this.abilityScoreIncrease = abilityScoreIncrease;
        this.speed = speed;
        this.languages = languages;
        this.features = features;
    }

    public Race() {}

    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();

        returnString.append(name);
        returnString.append("\n----------");
        returnString.append("\nAbilityscore Increase : "+abilityScoreIncrease.name+": "+abilityScoreIncrease.amount);
        returnString.append("\nSpeed: "+speed+"ft.");
        returnString.append("\nLanguages: \n -");
        returnString.append(String.join("\n -",languages));
        returnString.append("\n\nFeatures: \n -");
        returnString.append(String.join(features.stream().map(Object::toString)
                                                         .collect(Collectors.joining("\n\n")))); //TODO Update to String method

        return returnString.toString();
    }


    public String getNameString() {
        return name;
    }
}
