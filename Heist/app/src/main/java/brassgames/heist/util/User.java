package brassgames.heist.util;

@SuppressWarnings("WeakerAccess")
public class User {
    public final String name;
    public final boolean host;
    public final boolean thief;

    public User(String name, boolean thief) {
        this(name, thief, false);
    }

    public User(String name, boolean thief, boolean host) {
        this.name = name;
        this.thief = thief;
        this.host = host;
    }

    private String badge() {
        if(thief) {
            return "Thief";
        } else {
            return "Police";
        }
    }

    public String toString() {
        return name + "\n" + badge();
    }
}
