package main;
/**
 * NameAuthor: Ly Tuan 
 * gmail: lytuanduong96@gmail.com
 * Exercise: Application for Caffe Shop.
 * Version 1.0.
 * Date 21-07-2015
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Customer.Customer;
import Manager.Manager;
import Store.Coffee;
import Store.Condiments;
import Store.Item;
import Store.List;

public class MainCoffee {
//	private final String ESPRESSO = "Espresso":
	public static void main(String avgrs[]) throws IOException, ClassNotFoundException
	{
		System.out.println("*********************_THAO CAFFE SHOP_*****************");
		Manager.add(new Coffee("1","ESPRESSO",20));
		Manager.add(new Coffee("2","Capuchino",25));
		Manager.add(new Coffee("3","DarkRoad",30));
		Manager.add(new Coffee("4","BlackEye",35));
		Manager.add(new Coffee("5","Americano",40));
		Manager.add(new Condiments("6","Milk",2));
		Manager.add(new Condiments("7","Chocolate",3));
		Manager.add(new Condiments("8","Sugar",4));
		Manager.add(new Condiments("9","Ice",5));
		Manager.writeMenuCoffeeFile();
		Manager.writeMenuCondimentsFile();
		Manager.readMenuCoffee();
		List.printListCoffe();
	    //Manager.readMenuCondiments();
		Scanner input = new Scanner (System.in);
		String testContinue ="";
	
		do{
			
			boolean exit = true;
			String word;
			String passWord;
			System.out.println("                 -------------------------");
			System.out.println("Main menu:");
			System.out.println("1.Manager menu.");
			System.out.println("2.Customer menu.");
			System.out.println("3.Exit");
			System.out.println("Enter the choose:");
			int choose = Integer.parseInt(input.nextLine());
			int chooseManagerMenu =0 ;
			int chooseCustomermenu=0;
			switch (choose)
			{
			case 1:
				//outerloop:
					do{
						String temp;
						System.out.println("Enter the Password:");
						passWord = input.nextLine();
						if(passWord.equals(Manager.getPassWord()))
						{
							exit = false;
							System.out.println("Change successfull.");
						}
						else{
							System.out.println("Do you want continue to Enter the pass word!(y|n)");
							{
								word = input.nextLine();
								if(word.equals("n"))
								{
									break;
								}				
							}
						}
					}while(exit == true);
				if(exit ==false)
				{
					System.out.println("-----------------------");
					System.out.println("Manager menu:");
					System.out.println("1.Change password");
					System.out.println("2.Change Cost Coffee.");
					System.out.println("3.Change Name Coffee");
					System.out.println("4.Add Coffe.");
					System.out.println("5.Add Condiments.");
					System.out.println("6.Remove a Coffee");
					System.out.println("7.Sort List Coffee");
					System.out.println("8.Exit.");
					System.out.println("Enter your choose:");
					 chooseManagerMenu = Integer.parseInt(input.nextLine());
					try {
						switch(chooseManagerMenu)
						{
						//Change pass word
						case 1:
							Manager.changePassWord();
							break;
						// Change cost of Coffee
						case 2:
							List.printListCoffe();
							Manager.changeCost();
							break;
						
						// Change name of Coffee
						case 3:
							List.printListCoffe();
							Manager.changeName();
							break;
						
						// Add Coffee
						case 4: 
							Manager.addCoffee();
							List.printListCoffe();
							List.printListCondiments();
							break;

							//Add Condiments.
						case 5:
							Manager.addCondiments();
							break;
						// Remove a element in ArrayList
						case 6:
							Manager.deleteCoffee();
							break;
						//Sort array List Coffee 
						case 7:
							System.out.println("SORT THE MENU COFFEE:");
							Manager.sortCoffee();
							System.out.println("The menu coffee after sort is:");
							List.printListCoffe();
							break;
							//Exit application.	
						case 8:
							break;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
					break;
			case 2:
				System.out.println("-------------------------");
				System.out.println("Customer menu:");
				System.out.println("1.Choose Coffee.");
				System.out.println("2.Exit");
				System.out.println("Enter your choose:");
				chooseCustomermenu = Integer.parseInt(input.nextLine());
				switch(chooseCustomermenu)
				{
				//Customer choose the coffee and codiments.
				case 1:
					chooseCoffee();
					break;
				// Exit application.
				case 2:
					break;
				}	
			}
			if(choose ==3)
			{
				System.out.println("Do you want continue:");
				testContinue = input.nextLine();
			}
		}while(testContinue.equals("y")==false);
		Manager.writeMenuCoffeeFile();
		Manager.writeMenuCondimentsFile();
	}
	
		public static void chooseCoffee()
		{
			Scanner input = new Scanner (System.in);
			System.out.println("^-^-^-^-^-^-^-MENU-^-^-^-^-^-^-^");
			List.printListCoffe();
			List.printListCondiments();
			Customer customer = new Customer("customer",1);
			int count = 0;
			System.out.println("------------------------");
			System.out.println("Menu Coffee:");
			List.printListCoffe();
			System.out.println("Enter the number of cup Coffee do you want drink:");
			int numberCup = Integer.parseInt(input.nextLine());
			if(numberCup>0){
				do{
				System.out.println("Choose Id number of Coffee:");
				String chooseIdNumber;
				chooseIdNumber = input.nextLine();
				customer.choseCoffe(chooseIdNumber);
				List.printListCondiments();
				//Choose Condiments for Coffe Cup
				System.out.println("Enter the number of condiment do you want add:");
				int numberCondiments = Integer.parseInt(input.nextLine());
				int countCondiments =0;
				System.out.println("-------------------------");
				System.out.println("Menu Condiments:");
				List.printListCondiments();
				if(numberCondiments>0){
					do{
					System.out.println("Choose Id number of Condiments:");
					String chooseIdNumberCondiments;
					chooseIdNumberCondiments = input.nextLine();
					customer.choseCoffe(chooseIdNumberCondiments);
					countCondiments++;
					}while(countCondiments!=numberCondiments);
				}
				count++;

				}while(count != numberCup);
				customer.printBill();
				
			}
			
		}
}
