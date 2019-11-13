package ua.nure.myronova.finalproject.db.type;

public enum OrderStatus {

    REGISTERED("registered"),

    PAID("paid"),

    CANCELED("canceled");

    private String statusName;

    OrderStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
