/*
 * Licensed under the Academic Free License (AFL 3.0).
 *     http://opensource.org/licenses/AFL-3.0
 *
 *  This code is distributed to CSULB students in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, other than educational.
 *
 *  2018 Alvaro Monge <alvaro.monge@csulb.edu>
 *
 */

package csulb.cecs323.app;

import csulb.cecs323.model.*; //get all classes from model package
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @Author Antonio Sanchez
 * 
 */
public class Homework4Application {
   private static int choice = 0;
   private static EntityManager entityManager;
   private static Scanner in = new Scanner(System.in);
   private static final Logger LOGGER = Logger.getLogger(Homework4Application.class.getName());

   public Homework4Application(EntityManager manager) {
      Homework4Application.entityManager = manager;
   }

   public static void main(String[] args) {
      LOGGER.fine("Creating EntityManagerFactory and EntityManager");
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("homework4_PU");
      EntityManager manager = factory.createEntityManager();
      Homework4Application hw4application = new Homework4Application(manager);

      // Any changes to the database need to be done within a transaction.
      // See: https://en.wikibooks.org/wiki/Java_Persistence/Transactions
      
      do {
			System.out.println("\nChoose from the following options:");
			System.out.println();
			System.out.println("1. Restaurant Options");
			System.out.println("2. Menu Options");
			System.out.println("3. Write a Review");
			System.out.println("4. Check-In");
			System.out.println("5. Report an Issue");
			System.out.println("6. Exit");
		
			choice = in.nextInt();
			
			switch(choice) {
			case 1:	
				restaurantSearchMenu();
				break;
			case 2:
				menuSearchMenu();
				break;
			case 3:
				writeReview();
				break;
			case 4:
				//updateCheckIn();
				break;
			case 5:
				reportMenu();
				break; 
				
			case 6:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Choice must be a value between 1 and 6.");
			}
	}while(choice != 6);

      LOGGER.fine("Begin of Transaction");
      EntityTransaction tx = manager.getTransaction();

      tx.begin();

     // hw4application.createStudentEntity();

      tx.commit();
      LOGGER.fine("End of Transaction");
      
      hw4application.listRestaurants();

      System.out.println("\nDone!");

   }
   private static void reportMenu() {
	   int subMenuChoice = 0; 
	   do {
		   System.out.println("Please select from the following");
		   System.out.println("1. View the highest priced items");
		   System.out.println("2. Display reviews");
		   System.out.println("3. Late Night Deals");
		   System.out.println("4. Return to main menu");
		   switch(subMenuChoice) {
			case 1:	
				viewByPrice();
				break;
			case 2:
				menuSearchMenu();
				break;
			case 3:
				lowestPriceLateNight();
				break;
			case 4:
				break;
			default:
				System.out.println("Choice must be a value between 1 and 4.");
			}
	   }while(subMenuChoice !=4);
	   return;
	
	
}

private static void writeReview() {
	// TODO Auto-generated method stub
	
}

private static void menuSearchMenu() {
	   int subMenuChoice = 0; 
	   do {
		   System.out.println("Please select from the following");
		   System.out.println("1. View the highest priced items");
		   System.out.println("2. Display reviews");
		   System.out.println("3. Late Night Deals");
		   System.out.println("4. Return to main menu");
		   switch(subMenuChoice) {
			case 1:	
				viewByPrice();
				break;
			case 2:
				menuSearchMenu();
				break;
			case 3:
				lowestPriceLateNight();
				break;
			case 4:
				break;
			default:
				System.out.println("Choice must be a value between 1 and 4.");
			}
	   }while(subMenuChoice !=4);
	   return;
	
   }
   
   
   private static void viewByPrice() {
	Query q = entityManager.createQuery("SELECT r.rating AS Rating, r.name AS Restaurant, COUNT(*) AS #_of_Check-Ins"+
			 							" FROM Restaurant r INNER JOIN Rating" +
			 							" CheckIn c ON r.RestaurantID = c.RestaurantID" +
										"WHERE r.rating = 4.0;"); 
	List results = q.getResultList();
	
}

private static void lowestPriceLateNight() {
	// TODO Auto-generated method stubSELECT m.itemName, ,r.name , h.hoursOpen AS Hours_Open
	  Query q = entityManager.createQuery("FROM Menu m" +
	   " LEFT OUTER JOIN Restaurant r ON r.RestaurantID = m.RestaurantID" +
	   " LEFT OUTER JOIN Hours h on h.RestaurantID = r.RestaurantID" +
	   		" GROUP BY m.price " + 
			  "HAVING m.price < 10.00;");
	  List results = q.getResultList(); 
	  for(Object:results)
		  
}

private void loadInitialData() {

	      // Create a TypedQuery<> object to executed a named JPQL query
	      TypedQuery<Restaurant> checkRestaurant = entityManager.createNamedQuery(Restaurant.FIND_BY_NAME, Restaurant.class);

	      // Bind the parameters of the JPQL query to values
	      checkRestaurant.setParameter("name", INITIAL_RESTAURANTS[0].getName());
	      
	      // Execute the query and get the size of the result
	      int numberOfRestaurants = checkRestaurant.getResultList().size();

	      if (numberOfRestaurants == 0) { // assume other objects also don't exist

	         System.out.println("Assume Database is empty, load it with initial data");

	    /*     IntStream.range(0, INITIAL_RESTAURANTS .length).forEach(i -> {
	            Restaurant restaurant = INITIAL_RESTAURANTS[i];
	        );
*/
	         for (Restaurant restaurant : INITIAL_RESTAURANTS) {
	            entityManager.persist(restaurant);
	         }


	      }
	   }
   /**
    * Listing restaurant objects already in our database
    */
   private void listRestaurants() {
	      List<Restaurant> allRestaurants = entityManager.createNamedQuery(Restaurant.FIND_ALL, Restaurant.class).getResultList();

	      for (Restaurant restaurant : allRestaurants) {
	         System.out.println(restaurant);
	      }
	   }
   
   /**
    * list of initial entries in the database
    * */
   private static final Restaurant[] INITIAL_RESTAURANTS = new Restaurant[]{
	         new Restaurant("McDonald's","123 Elm Street","555-123-1234"),
	         new Restaurant("Maria's Italian Kitchen", "1076 W Pico Blvd", "310-441-4589"),
	         new Restaurant("Ben and Jerry's", "678 Fake Street", "555-567-3426"),
	         new Restaurant("Black Angus", "6345 Western Avenue" , "323-495-2387")
	   };
   private static final User[] INITIAL_USERS = new User[]{
	         new User("Antonio", "Sanchez", "555-872-1234"),
	         new User("Meng", "Cha", "310-653-7743"),
	         new User("Pamela", "Regudo", "555-567-3426"),
	         new User("John", "Doe", "323-495-2387"),
	         new User("Arthur", "Morgan", "323-499-1899", 5,2,1),
	         new User("John", "Doe", "323-495-2387",2,5),
	         new User("John", "Doe", "323-495-2387",1),
	         new User("John", "Doe", "323-495-2387", 5,2,1),
	         new User("John", "Doe", "323-495-2387",0,2,0),
	         new User("John", "Doe", "323-495-2387",0,0,3),
	         new User("John", "Doe", "323-495-2387")
	         
	   };
   
   private static final Menu[] INITIAL_MENUS = new Menu[] {
		   new Menu("Eggs Benedict", "Breakfast","Eggs", 5.00),
		   new Menu("Cheeseburger", "Lunch","Burger", 9.00),
		   new Menu("T-Bone", "Dinner","Steak", 25.00),
		   new Menu("Sundae", "Dessert ","Ice_Cream", 5.00),
		   new Menu("Spaghetti and Meatballs", "Dinner","Pasta", 5.00)
   };
   
   private static final Hours[] INITIAL_HOURS = new Hours[] {
		   new Hours("M-F","11:00 - 10:00"),
		   new Hours("Su-Su", "12:00 - 12:00"),
		   new Hours("T-Th", "5:00 - 2:00")
   };
private static final String FIND_BY_RATING = null;

 private static void restaurantSearchMenu()
   {
	   int subMenuChoice = 0; 
	   do {
		   System.out.println("Please select from the following");
		   System.out.println("1. View by rating");
		   System.out.println("2. Display reviews");
		   System.out.println("3. List Various Locations");
		   System.out.println("4. Return to main menu");
	   }while(subMenuChoice !=4);
	   
	   switch(subMenuChoice) {
		case 1:	
			viewByRating();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			break;
		default:
			System.out.println("Choice must be a value between 1 and 4.");
		
	   }while(choice != 4);
	   return;
   }

private static void viewByRating() {
	Query q = manager.createQuery(): 
	
}

 
  
      /**
    * Create and persist a Student object to the database.
    
   public void createStudentEntity() {
      LOGGER.fine("Creating Student object");

      Student graceHopper = new Student();
      graceHopper.setFirstName("Grace");
      graceHopper.setLastName("Hopper");
      graceHopper.setGpa(4.0);

      LOGGER.fine("Persisting Student object to DB");
      this.entityManager.persist(graceHopper);
      

   }
   */
   
   
}
