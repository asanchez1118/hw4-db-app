package csulb.cecs323.model;

import java.io.Serializable;

public class CompositeKey implements Serializable {
	private int rating;
	private String ratingDate;
	private int userID;
	private int restaurantID;
	private String checkInDate;
	private String reviewText;
	private String reviewDate;
	private String daysOpen;
	private String hoursOpen;
	private String itemName;
}
