package ua.nure.myronova.finalproject.db.entity;

import ua.nure.myronova.finalproject.db.FoodType;
import ua.nure.myronova.finalproject.db.TourType;

import java.util.Date;
import java.util.Map;

public class Tour extends Entity {

    private static final long serialVersionUID = -1278540703463315367L;

    private String name;

    private String description;

    private TourType type;

    private FoodType foodType;

    private int countPeople;

    private Date departureDate;

    private Date arrivalDate;

    private boolean lastMinute;

    private double price;

    private String imgPath;

    private int countAll;

    private Map<Integer, Hotel> route;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TourType getType() {
        return type;
    }

    public void setType(TourType type) {
        this.type = type;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public boolean isLastMinute() {
        return lastMinute;
    }

    public void setLastMinute(boolean lastMinute) {
        this.lastMinute = lastMinute;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getCountAll() {
        return countAll;
    }

    public void setCountAll(int countAll) {
        this.countAll = countAll;
    }

    public Map<Integer, Hotel> getRoute() {
        return route;
    }

    public void setRoute(Map<Integer, Hotel> route) {
        this.route = route;
    }
}
