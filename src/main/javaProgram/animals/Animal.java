package animals;

import java.util.ArrayList;

public class Animal {
    private final String type;
    private final String name;
    private final ArrayList<String> commands;

    public Animal(String type, String name, ArrayList<String> commands) {
        this.type = type;
        this.name = name;
        this.commands = commands;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

}
