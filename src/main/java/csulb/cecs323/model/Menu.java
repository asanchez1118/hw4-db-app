package csulb.cecs323.model;

import javax.persistence.*;

@Entity
public class Menu {

    @Id
    private String itemName;
    @Enumerated(EnumType.STRING)
    private MenuType menuType;
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Id @ManyToOne
    private Restaurant restaurant;
    private double price;

    public enum MenuType {
        Breakfast,
        Lunch,
        Dinner,
        Dessert,
        Beverage
    }

    public enum ItemType {
        Eggs,
        Burger,
        Steak,
        Pasta, 
        Ice_Cream,
        Soda
    }

    public Menu(String item, String menu, String type, double p) {
		this.itemName = item; 
		this.menuType = MenuType.valueOf(menu);
		this.itemType = ItemType.valueOf(type);
		this.price = p; 
	}

	public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
