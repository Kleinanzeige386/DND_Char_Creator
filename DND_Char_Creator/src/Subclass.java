public abstract class Subclass implements Named {
    public String name;
    public final Player owner;

    public abstract void lvlUpTo(int level);

    public Subclass() {
        this.owner = PlayerCreator.newPlayer;
    }

    public String getName() {
        return name;
    }





}


