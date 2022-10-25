public class Feature {
    public int levelRequirement;
    public String name;
    public String description;

    public Feature() {}

    public Feature(int levelRequirement, String name, String description) {
        this.levelRequirement = levelRequirement;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString(){
        return ("\n"+name+"   LVL "+levelRequirement+"\n"+description);
    }
}
