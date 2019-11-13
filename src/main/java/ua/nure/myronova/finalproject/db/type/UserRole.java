package ua.nure.myronova.finalproject.db.type;

import ua.nure.myronova.finalproject.db.entity.User;

public enum UserRole {

    CUSTOMER("customer"),

    MANAGER("manager"),

    ADMINISTRATOR("administrator");

    private String userRoleName;

    UserRole(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getUserRoleName() {
        return userRoleName;
    }
}
