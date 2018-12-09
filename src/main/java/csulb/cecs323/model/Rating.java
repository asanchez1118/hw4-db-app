package csulb.cecs323.model;

import javax.persistence.*;

/**
 * Rating class to model basic information about restaurant ratings,
 * the rating date, and the user who rated.
 */

@Entity
@IdClass(CompositeKey.class)
public class Rating {
	@Id private int rating;
	@Id private String ratingDate;
	
	@ManyToOne @JoinColumn(name="userID", referencedColumnName="User") private User user;
	    
	@ManyToOne @JoinColumn(name="restaurantID", referencedColumnName="Restaurant") private Restaurant restaurant;

	public Rating (int rating, String ratingDate) {
    	super();
    	this.ratingDate = ratingDate;
    	this.rating = rating;
    }
    
    public Rating() {
        super();
    }
    
    public void setRating(int rating) {
    	this.rating = rating;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRatingDate(String ratingDate) {
    	this.ratingDate = ratingDate;
    }
    
    public String getRatingDate() {
        return ratingDate;
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
