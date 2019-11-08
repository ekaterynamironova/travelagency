package ua.nure.myronova.finalproject.db.entity;

import ua.nure.myronova.finalproject.db.OrderStatus;

import java.util.Date;

public class Order extends Entity {

    private static final long serialVersionUID = -620973706540704129L;

    private User user;

    private Tour tour;

    private OrderStatus status;

    private Date registerDate;

    private int quantity;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
