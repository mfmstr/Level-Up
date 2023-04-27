package com.levelup.ecommerceapp.data;

import java.util.HashMap;

import com.levelup.ecommerceapp.model.Product;

public class Data {

	// allProducts ჰეშმეპში ვინახავ ან გადავაკეთებ save_product-ით გადმოცემულ პროდუქტს.
	public static HashMap<Integer, Product> allProducts = new HashMap<>();
	
	/** allPurchasedHistory ჰეშმეპში ვინახავ purchase_product-ის შესრულებისას მოცემულ ინფორმაციას(ისტორიას) 
	 	Integer-ში ვინახავ პროდუქტის ID-ს, ხოლო PurchaseHistory-კლასში შევქმენი ორი ერეილისტი, რომლებიც ნუმერაციის შესაბამისად ინახავენ 
	 	ჩემს მიერ შესყიდული პროდუქტის რაოდენობასა და ფასს. historyOfQuantity-ის პირველი წევრი აღნიშნავს პირველი შესყიდვისას რაოდენობას, ხოლო 
	 	historyOfPrice-ის შესაბამისი, ანუ პირველი წევრი, რა ფასად შევიძინე(ორივე ერელისტის მეორე წევრიც შესაბამისად მეორე შეძენისას რაოდენობას და ფასს და ა.შ).	
		@see PurchaseHistory
	*/
	public static HashMap<Integer, PurchaseHistory> allPurchasedHistory = new HashMap<>();
	
	// მსგავსაც allPurchasedHistory-ისა, allOrderHistory ინახავს გაყიდვის მონაცემებს.
	public static HashMap<Integer, OrderHistory> allOrderHistory = new HashMap<>();
	
	
	
}

