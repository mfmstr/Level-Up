package com.levelup.ecommerceapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.levelup.ecommerceapp.data.Data;
import com.levelup.ecommerceapp.data.OrderReports;
import com.levelup.ecommerceapp.service.ProductService;


public class Main {
	
	private static void writeInCsvFile() {
		
			//მთავარ კლასშივე შევქმენი OrderReports-ის csv ფაილში ჩამწერი მეთოდი.
		
		 	String fileName = "OrderReports.csv";
		 	
		 	if(OrderReports.getList().isEmpty()) {
		 		System.out.println("No Reports Found");
            }else {
		 	
	        try {
	            FileWriter fileWriter = new FileWriter(fileName);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            
	            //ვამატებ csv ფაილის გასაფორმებლად.
	            String[] titleArr = {"ID", "Name", "Quantity", "Purchase Price", "Selling Price"};
	            String titleRowString = String.join(",", titleArr);
	            bufferedWriter.write(titleRowString);
	            bufferedWriter.newLine();
	            
	            for (String[] arr : OrderReports.getList()) {
	                String rowString = String.join(",", arr);
	                bufferedWriter.write(rowString);
	                bufferedWriter.newLine();
	            }

	            bufferedWriter.close();
	            System.out.println("Successfully wrote to the file.");
	        } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
        }
		
	}
	

	
	// მთავარ მეთოდში გარკვეულ ინფუთზე, შესაბამის ფუნქციას ვიძახებ და ვამატებ try/catch ბლოკებს, რათა შეყვანის დროს კონსოლურმა აპლიკაციამ არასწორ ფორმატზე მუშაობა არ შეწყვიტოს.
	// თქვენს მიერ გამოგზავნილ დავალებაში მოცემულ ფუნქციებს რიცხვითი მნიშვნელობები შევუსაბამე. იგივე დავტოვე "exit", მხოლოდ მისი საშუალებით შეძლებთ პროგრამის გათიშვას.
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int id;
		int balance;
		int price;
		
		while(true) {
		
		System.out.println("Welcome, Please Select Service: ");
		System.out.println("For Saving or Updating Product Enter -> 1: ");
		System.out.println("For Purchasing Product Enter -> 2: ");
		System.out.println("For Ordering Product Enter -> 3: ");
		System.out.println("For Getting Product Quantity Enter -> 4: ");
		System.out.println("For Getting Product's Avarage Price(based on purchase history) Enter -> 5: ");
		System.out.println("For Getting Product's Profit Details Enter -> 6: ");
		System.out.println("For Getting Product With The Lowest Remaining Quantity. Enter -> 7: ");
		System.out.println("For Getting The Most Popular Product Enter -> 8: ");
		System.out.println("For Getting Order Reports Enter -> 9: ");
		System.out.println("To Write Order Repors In OrderReports.csv File Enter -> 10: ");
		System.out.println("To Exit The Program Write 'exit' : ");
		
		
		
		String choice;
		
		while(true) {
			choice = sc.nextLine();
			
			if(choice.equals("exit")) {
				System.exit(0);
			}
			
		try {
			int choiceCheck = Integer.parseInt(choice);
			break;
		}catch (NumberFormatException e) {
            System.out.println("Invalid input. Please choose the number from the screen, right to the function you want to use.");
        }
		}
		
		if(Integer.valueOf(choice) == 1){
			
			System.out.println("You Chose Saving or Updating Product.");
			
			
			while (true) {
				System.out.print("Enter Product ID / Shemoitanet produqtis ID: ");
	            String input = sc.nextLine();
	            try {
	                id = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }
			
			
			System.out.print("Enter Product Name / Shemoitanet produqtis saxeli: ");
			String name = sc.nextLine();

			while (true) {
				System.out.print("Enter Product Price / shemoitanet produqtis fasi: ");
	            String input = sc.nextLine();
	            try {
	            	price = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }
			
			ProductService.saveProduct(id, name, price);
			
		}else if(Integer.valueOf(choice) == 2) {
			
			System.out.println("You Chose Purchasing Product.");
			
			while (true) {
				System.out.print("Enter Product ID / Shemoitanet produqtis ID: ");
	            String input = sc.nextLine();
	            try {
	                id = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }

			
			
			while (true) {
				System.out.print("Enter Product Balance / Shemoitanet produqtis raodenoba: ");
	            String input = sc.nextLine();
	            try {
	                balance = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }

			
			
			while (true) {
				System.out.print("Enter Product Price / shemoitanet produqtis fasi: ");
	            String input = sc.nextLine();
	            try {
	                price = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }
			
			
			ProductService.purchaseProduct(id, balance, price);
			
		}else if(Integer.valueOf(choice) == 3){
			
			
			System.out.println("You Chose Ordering Product.");
			
			while (true) {
				System.out.print("Enter Product ID / Shemoitanet produqtis ID: ");
	            String input = sc.nextLine();
	            try {
	                id = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }

			while (true) {
				System.out.print("Enter Product Quantity / Shemoitanet produqtis raodenoba: ");
	            String input = sc.nextLine();
	            try {
	                balance = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }
			
			ProductService.orderProduct(id, balance);
			
		}else if(Integer.valueOf(choice) == 4){
			
			System.out.println("You Chose Get Product Quantity.");
			
			while (true) {
				System.out.print("Enter Product ID / Shemoitanet produqtis ID: ");
	            String input = sc.nextLine();
	            try {
	                id = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }

			ProductService.getQuantityOfProduct(id);
			
		}else if(Integer.valueOf(choice) == 5){
			
			System.out.println("You Chose Get Product Avarage Price.");
			
			while (true) {
				System.out.print("Enter Product ID / Shemoitanet produqtis ID: ");
	            String input = sc.nextLine();
	            try {
	                id = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }

			if(ProductService.getAveragePrice(id) == 0) {
				System.out.println("Product with id: " + id + " is not found.");
			}else {
				System.out.println("Avarage Price Of " + Data.allProducts.get(id).getName() + " is " + ProductService.getAveragePrice(id) +".");
			}
			
		}else if(Integer.valueOf(choice) == 6){
			
			System.out.println("You Chose Get Profit Price.");
			
			while (true) {
				System.out.print("Enter Product ID / Shemoitanet produqtis ID: ");
	            String input = sc.nextLine();
	            try {
	                id = Integer.parseInt(input);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	            }
	        }

			ProductService.gerProductProfit(id);
			
		}else if(Integer.valueOf(choice) == 7) {
		
			System.out.println("Product with the lowest remaining quantity is " + ProductService.getFewestProduct());
			
		}else if(Integer.valueOf(choice) == 8) {
		
			System.out.println("The Most Popular Product Is: " + ProductService.getMostPopularProduct());
			
		}else if(Integer.valueOf(choice) == 9) {
		
			if(ProductService.getOrdersReports().isEmpty()) {
				System.out.println("Report are not recieved...");
			}else {
				for(int i = 0; i < ProductService.getOrdersReports().size(); i++) {
					System.out.print("Report: ");
					System.out.println(i+1);
					for(int j = 0; j < ProductService.getOrdersReports().get(i).length; j++) {
						
						System.out.println(ProductService.getOrdersReports().get(i)[j]);
					}
				}
			}
			
		}else if(Integer.valueOf(choice) == 10) {
		
				Main.writeInCsvFile();
			
		}else {
			
			System.out.println("Numbers must be from range shown on screen.");
			
		}

		}
		
	}
	
}

