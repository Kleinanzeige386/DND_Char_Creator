public class Feature implements Named {

    public final String name;
    public final String description;


    public Feature(String name, String description) {

        this.name = name;
        this.description = description;
    }

    @Override
    public String toString(){
        return ("\n"+name+"\n"+description);
    }

    @Override
    public String getName() {
        return name;
    }
}
