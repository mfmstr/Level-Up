package com.levelup.ecommerceapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.levelup.ecommerceapp.data.Data;
import com.levelup.ecommerceapp.data.OrderHistory;
import com.levelup.ecommerceapp.data.OrderReports;
import com.levelup.ecommerceapp.data.PurchaseHistory;
import com.levelup.ecommerceapp.model.Product;

public class ProductService {
	
	// ეს მეთოდი გამოიძახება მაშინ, როდესაც კონსოლიდან შესაბამისი ბრძანება გამოიგზავნება და პროდუქტების მთავარ სიაში ამატებს ან აახლებს პროდუქტს, მისი სიაში მანამდე არსებობიდან გამომდინარე.
	public static void saveProduct(int id, String name, int price) {
		
		if(Data.allProducts.containsKey(id)) {
			Product changing = Data.allProducts.get(id);
			
			changing.setName(name);
			changing.setPrice(price);
			
			Data.allProducts.put(id, changing);
			
			System.out.print("Product has been updated successfully.");
			
		}else {
			
			Product newProduct = new Product(id, name, price);
			
			Data.allProducts.put(id, newProduct);
			
			System.out.println("");
			
		}
		
		for (Map.Entry<Integer, Product> entry : Data.allProducts.entrySet()) {
            int key = entry.getKey();
            Product value = entry.getValue();
            System.out.println(key + " -> " + value);
        }
		
	}
	
	 /*  მეთოდი გამოიძახება მაშინ, როდესაც კონსოლიდან შესაბამისი ბრძანება გამოიგზავნება და ასრულებს purchase_product-ში მითითებულ დავალებას, ანუ
	     მისი მეშვეობით ვყიდულობთ გარკვეული რაოდენობის პროდუქტს, გარკვეული რაოდენობის ფასად. რაოდენობა ახლდება მთავარ სიაში(allProducts), ხოლო
	   	 შეძენილი პროდუქტის აღწერა ხდება purchasedHistory ობიექტში და ისიც ისტორიის სახით ინახება allPurchasedHistory ჰეშმეპში.
	 */
	public static void purchaseProduct(int id, int balance, int price) {
		
		if(Data.allProducts.containsKey(id)) {
			
			Product product = Data.allProducts.get(id);
			product.setBalance(balance + product.getBalance());
			
			if(Data.allPurchasedHistory.containsKey(id)) {
				
				PurchaseHistory purchasedHistory = Data.allPurchasedHistory.get(id);
				purchasedHistory.addhistoryOfPrice(price);
				purchasedHistory.addTohistoryOfQuantity(balance);
				
			}else {
				
				PurchaseHistory purchasedHistory = new PurchaseHistory();
				purchasedHistory.addhistoryOfPrice(price);
				purchasedHistory.addTohistoryOfQuantity(balance);
				
				Data.allPurchasedHistory.put(id, purchasedHistory);
				
			}
			
			System.out.println("You have successfully purchased product.");
			
		}else {
			System.out.println("Product with id: " + id + " is not found.");
		}
		
		for (Map.Entry<Integer, Product> entry : Data.allProducts.entrySet()) {
            int key = entry.getKey();
            Product value = entry.getValue();
            System.out.println(key + " -> " + value);
        }
		
	}
	
	
	/* მეთოდი გამოიძახება მაშინ, როდესაც კონსოლიდან შესაბამისი ბრძანება გამოიგზავნება და ასრულებს order_product-ში მითითებულ დავალებას, ანუ
       მისი მეშვეობით ვყიდით გარკვეული რაოდენობის პროდუქტს. გაყიდული რაოდენობა აკლდება ინვენტორში არსებულ რაოდენობას, ხოლო გადახდის დეტალები OrderHistory ობიექტის
	   დახმარებით შეინახება Data-კლასის OrderHistory ჰეშმეპში.
	*/
	public static void orderProduct(int id, int quantity) {
		
		if(Data.allProducts.containsKey(id)) {
			if(Data.allProducts.get(id).getBalance() >= quantity) {
				
			Data.allProducts.get(id).setBalance(Data.allProducts.get(id).getBalance() - quantity);
			System.out.println("You successfully ordered " + quantity + " " + Data.allProducts.get(id).getName() + ".");
			
			Data.allProducts.get(id).setOrderCounter(Data.allProducts.get(id).getOrderCounter() + quantity);
			
			if(Data.allOrderHistory.containsKey(id)) {
				
				Data.allOrderHistory.get(id).addhistoryOfPrice(Data.allProducts.get(id).getPrice());
				Data.allOrderHistory.get(id).addTohistoryOfQuantity(quantity);
				
			}else {
				
				OrderHistory orderHistory = new OrderHistory();
				orderHistory.addhistoryOfPrice(Data.allProducts.get(id).getPrice());
				orderHistory.addTohistoryOfQuantity(quantity);
				
				Data.allOrderHistory.put(id, orderHistory);
				
			}
			
			// ამ ნაწილიშივე ვაგროვებ რეპორტს ორდერთან დაკავშირებით და ვაგზავნი OrderReports-კლასის სტატიკურ ლისტში.
			// ID, product name, quantity, price, and selling price. ამ თანმიმდევრობით.
			String[] orderInformation = {String.valueOf(id), 
											String.valueOf(Data.allProducts.get(id).getName()), 
											String.valueOf(quantity),  
											String.valueOf(Data.allPurchasedHistory.get(id).getHistoryOfPrice().get(Data.allPurchasedHistory.get(id).getHistoryOfPrice().size()-1)),
											String.valueOf(Data.allProducts.get(id).getPrice())
											};
			
			OrderReports.putInOrderReportsList(orderInformation);
			
			System.out.println("You have successfully ordered product.");
			
			}else {
				System.out.println("Amount of product your ordered, is not available, there are only " + Data.allProducts.get(id).getBalance() + " " + Data.allProducts.get(id).getName() + " in the store");
			}
		}else {
			System.out.println("No such product found.");
		}
		
		
	}
	
	// get_quantity_of_product გადაეცემა id და აბრუნებს ამ პროდუქტის არსებულ(ხელმისაწვდომ) რაოდენობას.
	public static void getQuantityOfProduct(int id) {
		
		if(Data.allProducts.containsKey(id)) {
		
		System.out.println("Available quantity of " + Data.allProducts.get(id).getName() + " is " + Data.allProducts.get(id).getBalance() + ".");
		
		}else {
			System.out.println("Product with id: " + id + " is not found.");
		}
	}
	
	// get_average_price ითვლის საშუალო ფასს შესყიდვის(purchase) ისტორიის გათვალისწინებით.
	// ეს ფუნქცია არ არის ვოიდი, რადგან მისი მნიშვნელობის დაბრუნება ქვედა ფუნქციაში მჭირდება.
	public static Integer getAveragePrice(int id) {
		
		if(Data.allProducts.containsKey(id)) {
			
			int avr = 0;
			int allPrice = 0;
			int allQuantity = 0;
			
			for(int i = 0; i < Data.allPurchasedHistory.get(id).getHistoryOfPrice().size(); i++) {
				
				allPrice += (int) Data.allPurchasedHistory.get(id).getHistoryOfQuantity().get(i) * (int) Data.allPurchasedHistory.get(id).getHistoryOfPrice().get(i);
				allQuantity += (int) Data.allPurchasedHistory.get(id).getHistoryOfQuantity().get(i);
				
			}
			
			avr = allPrice / allQuantity;
			
			return avr;
			
			
		}else {
			return 0;
		}
		
	}
	
	// get_product_profit -> ფუნქცია გამოითვლის გარკვეული პროდუქტისგან შემოსულ მოგებას.
	public static void gerProductProfit(int id) {
		
		if(Data.allProducts.containsKey(id)) {
			
			// ვითვლი Order-ებით შემოსულ საშუალო ფასს
			int avrOrder = 0;
			int allPrice = 0;
			int allQuantity = 0;
			
			for(int i = 0; i < Data.allOrderHistory.get(id).getHistoryOfPrice().size(); i++) {
				
				allPrice += (int) Data.allOrderHistory.get(id).getHistoryOfQuantity().get(i) * (int) Data.allOrderHistory.get(id).getHistoryOfPrice().get(i);
				allQuantity += (int) Data.allOrderHistory.get(id).getHistoryOfQuantity().get(i);
				
			}
			
			avrOrder = allPrice / allQuantity;
			
			System.out.println("Avarage Price Of " + Data.allProducts.get(id).getName() + " FROM ORDER HISTORY is " + avrOrder +".");
			
			// order-ის საშუალოს - purchase-ის საშუალო = მოგებას ერთ ცალ პროდუქტზე
			int avrPurchase = getAveragePrice(id);
			int profitPerUnit = avrOrder - avrPurchase;
			int totalProfit = profitPerUnit * allQuantity;
			
			System.out.println("Averige Purchase Price: " + avrPurchase);
			System.out.println("Averige Order Price: " + avrOrder);
			System.out.println("Profit Per Unit: " + profitPerUnit);
			System.out.println("Total Profit: " + totalProfit);
			
		}else {
			System.out.println("Product with id: " + id + " is not found.");
		}
		
	}
	
		// get_fewest_product ვაბრუნებთ იმ პროდუქტს, რომელიც ყველაზე ცოტა რაოდენობითაა დარჩენილი მარაგში
		public static String getFewestProduct() {
			
			int minBalance = Integer.MAX_VALUE;
			String minBalanceProduct = "";
			
			for (Map.Entry<Integer, Product> entry : Data.allProducts.entrySet()) {
	            int key = entry.getKey();
	            Product value = entry.getValue();
	            if(value.getBalance() < minBalance && value.getBalance() != 0) {
	            	minBalance = value.getBalance();
	            	minBalanceProduct = value.getName();
	            }
	        }
			
			if(minBalanceProduct.equals("")) {
				minBalanceProduct = "not found";
			}
		
			return minBalanceProduct;
			
		}
		
		// get_most_popular_product ვაბრუნებთ იმ პროდუქტს, რომელიც ყველაზე მეტჯერ გაიყიდა.
				public static String getMostPopularProduct() {
					
					int maxProduct = 0;
					String maxProductString = "";
					
					for (Map.Entry<Integer, Product> entry : Data.allProducts.entrySet()) {
			            int key = entry.getKey();
			            Product value = entry.getValue();
			            
			            if(value.getOrderCounter() > maxProduct) {
			            	maxProduct = value.getOrderCounter();
			            	maxProductString = value.getName();
			            }
			            
			        }
					
					if(maxProductString.equals("")) {
						maxProductString = "not found";
					}
				
					return maxProductString;
					
				}
				
	  // get_orders_report იღებს ინფორმაციას ყველა პროდუქტზე(იდ, სახელი, რაოდენობა, შესყიდვის ფასი, გასაყიდი ფასი) 
				public static List<String[]> getOrdersReports(){
					
					//აბრუნებს ლისტს, რომელშიც Order ფუნქციის დროს ვავსებ ინფორმაციას.
					return OrderReports.getList();
					
				}
				
}
