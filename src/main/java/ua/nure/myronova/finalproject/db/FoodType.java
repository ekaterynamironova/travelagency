package ua.nure.myronova.finalproject.db;

public enum FoodType {

    OB("OB"),

    BB("BB"),

    HB("HB"),

    FB("GB"),

    AI("AI");

    private String foodTypeName;

    FoodType(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }
}
