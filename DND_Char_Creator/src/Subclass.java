public abstract class Subclass implements Named {
    public String name;
    public final Player owner;

    public String identifier;
    public abstract void lvlUpTo(int level); //TODO use for loop i guess? maybe

    public Subclass() {
        this.owner = PlayerCreator.newPlayer;
    }

    public String getName() {
        return identifier+ name;
    }





}


