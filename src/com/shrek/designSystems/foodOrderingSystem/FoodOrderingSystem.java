package com.shrek.designSystems.foodOrderingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FoodOrderingSystem {

	static List<Restaurant> onboardedRestaurants = new ArrayList<Restaurant>();
	static int orderNumber = 0;
	static Map<Integer, String> ordersTable = new HashMap<Integer, String>();
	
	final static String lowestPriceStrategy = "LOWEST_PRICE_STRATEGY";
	final static String restaurantNameStrategy = "RESTAURANT_NAME";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> res1Menu = new HashMap<String, Integer>();
		res1Menu.put("Idly", 40);
		res1Menu.put("Vada", 30);
		res1Menu.put("Dosa", 50);
		Map<String, Integer> res2Menu = new HashMap<String, Integer>();
		res2Menu.put("Idly", 40);
		res2Menu.put("Poori", 25);
		res2Menu.put("Dosa", 60);
		Map<String, Integer> res3Menu = new HashMap<String, Integer>();
		res3Menu.put("Idly", 30);
		res3Menu.put("Vada", 40);
		res3Menu.put("Poori", 100);
		/* Onboarding Restaurants */
		addRestaurant("A2B", res1Menu, 4);
		addRestaurant("Rasganga", res2Menu, 6);
		addRestaurant("Eat Fit", res3Menu, 2);
		printRestaurantMenu("Rasganga");
		printRestaurantMenu("Eat Fit");
		printRestaurantMenu("A2B");

		/* Menu Update */
		Map<String, Integer> res4Menu = new HashMap<String, Integer>();
		res4Menu.put("Idly", 30);
		updateMenu("A2B", res4Menu);
		//printRestaurantMenu("A2B");
		/* System Stats */
		printSystemStats();

		/* Place an Order */
		Set<String> orderItemsSet1  = new HashSet<String>();
		orderItemsSet1.add("Idly");
		orderItemsSet1.add("Vada");
		System.out.println(placeOrder(orderItemsSet1,"LOWEST_PRICE_STRATEGY"));
		
		/* Place an Order */
		Set<String> orderItemsSet2  = new HashSet<String>();
		orderItemsSet2.add("Idly");
		orderItemsSet2.add("Poori");
		System.out.println(placeOrder(orderItemsSet2,"LOWEST_PRICE_STRATEGY"));
		
		/* Complete an Order */
		completeOrder(1);
		/* Print Live Orders */
		printLiveOrders("A2B");
		printSystemStats();
	}
	
	static String placeOrder(Set<String> items, String strategy) {
		String opString = "SHOOT";
		String selectedRestaurant;
		if(strategy.equals(lowestPriceStrategy)) {
			orderNumber++;
			selectedRestaurant = calculateOpForLOwestPriceStartegy(items);
			updateRestaurantProcessing(selectedRestaurant, false);
			opString = "Ordered from "+selectedRestaurant+"(ORDER"+orderNumber+")";
			ordersTable.put(orderNumber, selectedRestaurant);
		} else {
			opString =  "We'll get back with more stategies, pinky promise !!";
		}
		return opString;
	}
	
	static void completeOrder(int orderId) {
		String resName = ordersTable.get(orderId);
		updateRestaurantProcessing(resName, true);
	}
	
	static void printLiveOrders(String resName) {
		Set<Integer> ordersSet = ordersTable.keySet();
		Iterator<Integer> itr = ordersSet.iterator();
		while(itr.hasNext()) {
			Integer orderId = itr.next();
			if(ordersTable.get(orderId).equals(resName)) {
				System.out.println("ORDER "+orderId);
			}
		}
	}
	
	
	static String calculateOpForLOwestPriceStartegy(Set<String> orderedItems){
		Iterator<Restaurant> itr = onboardedRestaurants.iterator();
		int minSum= Integer.MAX_VALUE;
		String orderRes = null;
		while(itr.hasNext()) {
			Restaurant res = itr.next();
			Map<String, Integer> resMenu = res.getMenu();
			Set<String> resMenuItems = resMenu.keySet();
			if(resMenuItems.containsAll(orderedItems) && res.getPorcessingPower()!=0) {
				int sum = 0;
				Iterator<String> itr1 = orderedItems.iterator();
				while(itr1.hasNext()) {
					String menuItem = itr1.next();
					sum+=resMenu.get(menuItem);
				}
				if(sum<minSum) {
					minSum = sum;
					orderRes = res.getRestaurantName();
				}
			}
		}
		return orderRes;
	}
	
	static boolean addRestaurant(String resName, Map<String, Integer> menu,int processingPower){
		Restaurant res = new Restaurant(resName, menu, processingPower);
		boolean op = onboardedRestaurants.add(res);
		return op;
	}
	
	static void updateMenu(String resName, Map<String, Integer> freshMenu) {
		Iterator<Restaurant> itr = onboardedRestaurants.iterator();
		while(itr.hasNext()) {
			Restaurant res = itr.next();
			if(res.getRestaurantName().equals(resName)) {
				Map<String, Integer> existingMenu = res.getMenu();
				existingMenu.putAll(freshMenu);
				break;
			}
		}
	}
	
	static void updateRestaurantProcessing(String resName, Boolean increment) {
		Iterator<Restaurant> itr = onboardedRestaurants.iterator();
		while(itr.hasNext()) {
			Restaurant res = itr.next();
			if(res.getRestaurantName().equals(resName)) {
				if(increment) {
					res.setPorcessingPower(res.getPorcessingPower()+1);
				} else {
					res.setPorcessingPower(res.getPorcessingPower()-1);
				}
				break;
			}
		}
	}

	static void printRestaurantMenu(String resName) {
		Iterator<Restaurant> itr = onboardedRestaurants.iterator();
		while(itr.hasNext()) {
			Restaurant res = itr.next();
			if(res.getRestaurantName().equals(resName)) {
				System.out.println(res.getMenu());
				break;
			}
		}
	}
	
	static void printSystemStats() {
		Iterator<Restaurant> itr = onboardedRestaurants.iterator();
		while(itr.hasNext()) {
			Restaurant res = itr.next();
			System.out.println(res.getRestaurantName() + " : "+  res.getPorcessingPower());
		}
	}
	
}
