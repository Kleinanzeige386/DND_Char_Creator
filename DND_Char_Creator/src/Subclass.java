public abstract class Subclass implements Named {
    public String name;
    public final Player owner;

    public String identifier;
    public abstract void lvlUpTo(int level);

    public Subclass(String n, String i) {
        this.owner = PlayerCreator.newPlayer;
        name= n;
        identifier= i;
    }

    public String getName() {
        return identifier+ name;
    }





}


