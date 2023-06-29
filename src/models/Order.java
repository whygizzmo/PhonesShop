package models;

import java.util.Date;

public class Order {
    int id;
    String email;
    Phone phone;
    double total_Price;
    double paid;
    double change;
    Date date;

    public Order() {
    }

    public Order(int id, String email, Phone phone, double total_Price, double paid, double change, Date date) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.total_Price = total_Price;
        this.paid = paid;
        this.change = change;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public double getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(double total_Price) {
        this.total_Price = total_Price;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
