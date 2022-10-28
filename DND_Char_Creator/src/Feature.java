public class Feature {

    public String name;
    public String description;

    public Feature() {}

    public Feature(String name, String description) {

        this.name = name;
        this.description = description;
    }

    @Override
    public String toString(){
        return ("\n"+name+"\n"+description);
    }
}
