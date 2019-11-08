package ua.nure.myronova.finalproject.db;

public enum UserRole {

    CUSTOMER("customer"),

    MANAGER("manager"),

    ADMINISTRATIOR("administrator");

    private String userRoleName;

    UserRole(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getUserRoleName() {
        return userRoleName;
    }
}
