public abstract class Subclass implements Named {
    public String name;
    public final Player owner;

    public String identifier;
    protected int subLvl;
    public abstract void lvlUpTo(int level);

    public Subclass(String n, String i) {
        this.owner = PlayerCreator.newPlayer;
        name= n;
        identifier= i;
        subLvl=0;
    }

    public abstract void buildSubclass();

    public String getName() {
        return identifier+ name;
    }





}


