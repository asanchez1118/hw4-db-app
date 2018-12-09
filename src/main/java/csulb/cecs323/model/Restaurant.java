package csulb.cecs323.model;

import javax.persistence.*;

@Entity
public class Restaurant {

    @Id @GeneratedValue private int RestaurantID;
    private String name;
    private String street;
    private String City;
    @Enumerated(EnumType.STRING) private States state;
    private String zipcode;
    private String phone;

    @Enumerated(EnumType.STRING) private Takeout takeout;
    @Enumerated(EnumType.STRING) private Delivery delivery;
    @Enumerated(EnumType.STRING) private PriceRange priceRange;

    private String website;
    private double avgRating;
    @Enumerated(EnumType.STRING)
    private CuisineCategory cuisineCategory;
    public enum States {
        AL,AK,AZ,AR,CA,CO,CT,DE,FL,GA,HI,ID,IL,IN,IA,KS,
        KY,LA,ME,MD,MA,MI,MN,MS,MO,MT,NE,NV,NH,NJ,NM,NY,NC,
        ND,OH,OK,OR,PA,RI,SC,SD,TN,TX,UT,VT,VA,WA,WV,WI,WY

    }

    public enum Takeout {
        YES,
        NO
    }
    public enum Delivery {
        YES,
        NO
    }
    public enum PriceRange {
        $,
        $$,
        $$$
    }

    public enum CuisineCategory {
        Fast_Food,
        Cafe,
        Buffet,
        Fine_Dining,
        Barbeque,
        Casual,
        Greek,
        French,
        Thai,
        Mexican

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Takeout getTakeout() {
        return takeout;
    }

    public void setTakeout(Takeout takeout) {
        this.takeout = takeout;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public CuisineCategory getCuisineCategory() {
        return cuisineCategory;
    }

    public void setCuisineCategory(CuisineCategory cuisineCategory) {
        this.cuisineCategory = cuisineCategory;
    }
}
