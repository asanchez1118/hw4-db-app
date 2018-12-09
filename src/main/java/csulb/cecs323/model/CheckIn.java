//DONE
package csulb.cecs323.model;

import javax.persistence.*;

/**
 * Check-In class to model basic information about restaurant check-ins,
 * the check-in date, and the user who checked-in.
 */

@Entity
public class CheckIn {
	@Id private String checkInDate;
	
	@ManyToOne @JoinColumn(name="userID", referencedColumnName="User") private User user;
    
    @ManyToOne @JoinColumn(name="restaurantID", referencedColumnName="Restaurant") private Restaurant restaurant;
	
	public CheckIn (String checkInDate) {
    	super();
    	this.checkInDate = checkInDate;
    }
    
    public CheckIn() {
        super();
    }
	
    public void setCheckInDate(String checkInDate) {
    	this.checkInDate = checkInDate;
    }
    
    public String getCheckInDate() {
        return checkInDate;
    }
    
    public User getUser() {
    	return user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    public Restaurant getRestaurant() {
    	return restaurant;
    }
    
    public void setRestaurant(Restaurant restaurant) {
    	this.restaurant = restaurant;
    }

}
