//DONE
package csulb.cecs323.model;

import javax.persistence.*;
/**
 * Review class to model basic information about restaurant reviews,
 * the review text, review date, and the user who wrote it.
 */

@Entity
@IdClass(CompositeKey.class)
public class Review {
	@Id private String reviewText;
	@Id private String reviewDate;
    
    @ManyToOne @JoinColumn(name="userID", referencedColumnName="User") private User user;
    
    @ManyToOne @JoinColumn(name="restaurantID", referencedColumnName="Restaurant") private Restaurant restaurant;
    
    public Review (String reviewText, String reviewDate, int userID) {
    	super();
    	this.reviewText = reviewText;
    	this.reviewDate = reviewDate;
    }
    
    public Review() {
        super();
    }
    
    public void setReviewText(String reviewText) {
    	this.reviewText = reviewText;
    }
    
    public String getReviewText() {
        return reviewText;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
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
