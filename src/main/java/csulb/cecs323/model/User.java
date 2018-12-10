//TO DO associationss
package csulb.cecs323.model;

import javax.persistence.*;

/**
 * User class to model basic information about users, their name, phone,
 * numOfReviews, numOfCheckIns, and numOfRatings
 */

@Entity
public class User {
	@EmbeddedId @Id @GeneratedValue private int userID;
	private String fName;
	private String lName;
    private String phone;
    private int numOfReviews;
    private int numOfCheckIns;
    private int numOfRatings;
    
    @OneToMany
    private Review review;
    
    @OneToMany
    private CheckIn checkin;
    
    @OneToMany
    private Rating rating;
    /**
     * Setting up initial users in DB
     * @param first
     * @param last
     * @param phone
     * @param review
     * @param check
     * @param ratings
     */
     public User(String first, String last, String phone, int review, int check, int ratings) {
		this.fName = first;
		this.lName = last; 
		this.phone = phone; 
		this.numOfReviews = review; 
		this.numOfCheckIns = check;
		this.numOfRatings = ratings; 
	}

     /**
      * If completely brand new to the app/database
      * @param first
      * @param last
      * @param phone
      */
	public User(String first, String last, String phone) {
		this.fName = first;
		this.lName = last; 
		this.phone = phone; 	
	}

	public User(String string, String string2, String string3, int i) {
		// TODO Auto-generated constructor stub
	}

	public User(String string, String string2, String string3, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
    	 return userID;
     }
    
     public String getfName() {
        return fName;
     }

     public void setfName(String fName) {
        this.fName = fName;
     }

     public String getlName() {
        return lName;
     }

     public void setlName(String lName) {
        this.lName = lName;
     }
     
     public String getPhone() {
         return phone;
     }

      public void setPhone(String phone) {
         this.phone = phone;
     }

     public int getNumOfReviews() {
        return numOfReviews;
     }

     public void setNumOfReviews(int numOfReviews) {
        this.numOfReviews = numOfReviews;
     }
     
     public int getNumOfCheckIns() {
         return numOfCheckIns;
     }

      public void setNumOfCheckIns(int numOfCheckIns) {
         this.numOfCheckIns = numOfCheckIns;
     }

     public int getNumOfRatings() {
         return numOfRatings;
     }

     public void setNumOfRatings(int numOfRatings) {
         this.numOfRatings = numOfRatings;
     }
}
