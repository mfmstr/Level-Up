
package com.levelup.ecommerceapp.data;

import java.util.ArrayList;

public class OrderHistory {
		
	// PurchaseHistory კლასის მსგავსად, OrderHistory წარმოადგენს ინფორმაციის შესანახ ობიექტს, რომელშიც შევინახავთ order_product-ის დროს დამუშავებულ მონაცემებს.
	private ArrayList historyOfQuantity = new ArrayList();
	
	private ArrayList historyOfPrice = new ArrayList();
	
	public void addTohistoryOfQuantity(int quantity) {
		historyOfQuantity.add(quantity);
	}
	
	public ArrayList getHistoryOfQuantity() {
		return historyOfQuantity;
	}

	public ArrayList getHistoryOfPrice() {
		return historyOfPrice;
	}

	public void addhistoryOfPrice(int price) {
		historyOfPrice.add(price);
	}
	
	@Override
	public String toString() {
		return "PurchaseHistory [historyOfQuantity=" + historyOfQuantity + ", historyOfPrice=" + historyOfPrice + "]";
	}
	
}

