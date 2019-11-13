package ua.nure.myronova.finalproject.web.command;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {

    private static Map<String, Command> commands = new TreeMap<>();

    static {
        commands.put("start", new StartCommand());
        commands.put("search", new SearchCommand());
        commands.put("noCommand", new NoCommand());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
