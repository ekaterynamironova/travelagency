package ua.nure.myronova.finalproject.util;

public enum Action {
    FORWARD("forward"),

    REDIRECT("redirect");

    private String actionName;

    Action(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }
}
