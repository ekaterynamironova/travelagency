package ua.nure.myronova.finalproject.db.type;

public enum FoodType {

    OB("OB"),

    BB("BB"),

    HB("HB"),

    FB("FB"),

    AI("AI");

    private String foodTypeName;

    FoodType(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }
}
