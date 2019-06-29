package com.shrek.designSystems.foodOrderingSystem;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {

	String restaurantName;
	Map<String, Integer> menu = new HashMap<String, Integer>();
	int porcessingPower = 0;
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Map<String, Integer> getMenu() {
		return menu;
	}
	public void setMenu(Map<String, Integer> menu) {
		this.menu = menu;
	}
	public int getPorcessingPower() {
		return porcessingPower;
	}
	public void setPorcessingPower(int porcessingPower) {
		this.porcessingPower = porcessingPower;
	}
	public Restaurant(String restaurantName, Map<String, Integer> menu, int porcessingPower) {
		super();
		this.restaurantName = restaurantName;
		this.menu = menu;
		this.porcessingPower = porcessingPower;
	}
	
}
