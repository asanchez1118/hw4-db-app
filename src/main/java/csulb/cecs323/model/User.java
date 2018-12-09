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
