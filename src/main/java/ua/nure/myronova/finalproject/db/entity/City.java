package ua.nure.myronova.finalproject.db.entity;

public class City extends Entity {

    private static final long serialVersionUID = -2625876057683458294L;

    private String name;

    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
