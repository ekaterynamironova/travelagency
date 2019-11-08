package ua.nure.myronova.finalproject.db.entity;

import java.util.List;

public class Hotel extends Entity {

    private static final long serialVersionUID = -5330817633399891239L;

    private String name;

    private int countStars;

    private City city;

    private List<Service> services;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountStars() {
        return countStars;
    }

    public void setCountStars(int countStars) {
        this.countStars = countStars;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
