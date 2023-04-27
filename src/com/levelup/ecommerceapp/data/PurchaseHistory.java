package com.levelup.ecommerceapp.data;

import java.util.ArrayList;

public class PurchaseHistory {

	/** PurchaseHistory კლასს ვიყენებ purchase_product-ის შესრულებისას, შეძენილი რაოდენობის და ფასის დასაგროვებლად, ერეილისტებში ელემენტების ადგილმდებარობის კავშირის გამოყენებით, რათა შემდგომ
		@see Data
		კლასში allPurchasedHistory-ში შევინახო.
	*/
	
	private ArrayList<Integer> historyOfQuantity = new ArrayList<>();
	
	private ArrayList<Integer> historyOfPrice = new ArrayList<>();
	
	public void addTohistoryOfQuantity(int quantity) {
		historyOfQuantity.add(quantity);
	}
	
	public void addhistoryOfPrice(int price) {
		historyOfPrice.add(price);
	}
	
	public ArrayList getHistoryOfQuantity() {
		return historyOfQuantity;
	}

	public ArrayList getHistoryOfPrice() {
		return historyOfPrice;
	}

	@Override
	public String toString() {
		return "PurchaseHistory [historyOfQuantity=" + historyOfQuantity + ", historyOfPrice=" + historyOfPrice + "]";
	}
	
	
}

