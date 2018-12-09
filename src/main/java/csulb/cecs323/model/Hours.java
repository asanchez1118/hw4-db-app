package csulb.cecs323.model;

import javax.persistence.*;

@Entity
@IdClass(CompositeKey.class)
public class Hours {

    @Id private String daysOpen;
    @Id private String hoursOpen;

    @Id @OneToOne
    private Restaurant restaurant;

    public Hours(int restaurantID, String daysOpen, String hoursOpen) {
        super();
        this.daysOpen = daysOpen;
        this.hoursOpen = hoursOpen;
    }

    public Hours() {
        super();
    }

    public String getDaysOpen() {
        return daysOpen;
    }

    public void setDaysOpen(String daysOpen) {
        this.daysOpen = daysOpen;
    }

    public String getHoursOpen() {
        return hoursOpen;
    }

    public void setHoursOpen(String hoursOpen) {
        this.hoursOpen = hoursOpen;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
