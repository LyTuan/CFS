package Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Store.Coffee;
import Store.Item;
import Store.List;

public class Manager implements Serializable {
	static // private static String passWord = "Coffee12345";
	Scanner input = new Scanner(System.in);

	private String name;
	int age;

	public Manager() {
		this("No name", 0);

	}

	public static void changePassWord() throws IOException {
		System.out.println("Enter the new PassWord:");
		String newPassWord = input.nextLine();
		FileOutputStream file = new FileOutputStream("Pass word.txt");
		PrintWriter output = new PrintWriter(file);
		output.println(newPassWord);
		output.close();
		file.close();
	}

	public static void setPassWord() throws IOException {
		FileOutputStream file = new FileOutputStream("Pass word.txt");
		PrintWriter output = new PrintWriter(file);
		output.println("Coffee12345");
		// file.close();
		output.close();
	}

	public static String getPassWord() throws IOException {
		FileInputStream file = new FileInputStream("Pass word.txt");
		String passWord = new String("");
		Scanner input = new Scanner(file);
		passWord = input.nextLine();

		input.close();
		return passWord;

	}

	public Manager(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public float computePay() {
		float cost = 0;
		return cost;
	}

	public static void changeCost() throws ClassNotFoundException, IOException {
		// readMenuCoffee();
		System.out.println("What kind of Coffe do you want change cost:");
		String idNumber = input.nextLine();
		System.out.println("Enter the new cost:");
		int newCost = 0;
		try {
			newCost = Integer.parseInt(input.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Your Id number not a integer number");
		}
		for (Item item : List.getListCoffee()) {
			if (item.getIdnumber().equals(idNumber)) {
				item.setCost(newCost);
			}
		}
		// writeMenuCoffeeFile();
	}

	public static void changeName() throws ClassNotFoundException, IOException {
		// readMenuCoffee();
		System.out.println("Enter the Id number of Coffe do you want change name:");
		String idNumber1 = input.nextLine();
		System.out.println("Enter the new name Coffee");
		String newNameCoffee = input.nextLine();
		for (Item item : List.getListCoffee()) {
			if (item.getIdnumber().equals(idNumber1)) {
				item.setName(newNameCoffee);
			}
		}
		// writeMenuCoffeeFile();

	}

	public static void deleteCoffee() throws ClassNotFoundException, IOException {
		// readMenuCoffee();
		System.out.println("DELETE A ELEMENT IN COFFEE ARRAY:");
		List.printListCoffe();
		System.out.println("Enter the Id number of Coffee do you want remove:");
		String idNumberRemove = input.nextLine();
		for (int pos = 0; pos < List.getListCoffee().size(); pos++) {
			if (List.getListCoffee().get(pos).getIdnumber().equals(idNumberRemove)) {
				List.getListCoffee().remove(pos);
			}
		}
		// writeMenuCoffeeFile();
	}

	public static void sortCoffee() throws ClassNotFoundException, IOException {
		// readMenuCoffee();
		Item item = new Item();
		for (int pos = 0; pos < List.getListCoffee().size(); pos++) {
			for (int pos1 = pos + 1; pos1 < List.getListCoffee().size(); pos1++) {
				if ((List.getListCoffee().get(pos).getName()).compareTo(List.getListCoffee().get(pos1).getName()) > 0) {
					item.setName(List.getListCoffee().get(pos).getName());
					item.setIdnumber(List.getListCoffee().get(pos).getIdnumber());
					item.setCost(List.getListCoffee().get(pos).getCost());
					List.getListCoffee().get(pos).setName(List.getListCoffee().get(pos1).getName());
					List.getListCoffee().get(pos).setIdnumber(List.getListCoffee().get(pos1).getIdnumber());
					List.getListCoffee().get(pos).setCost(List.getListCoffee().get(pos1).getCost());
					List.getListCoffee().get(pos1).setName(item.getName());
					List.getListCoffee().get(pos1).setIdnumber(item.getIdnumber());
					List.getListCoffee().get(pos1).setCost(item.getCost());
				}
			}
		}
		// writeMenuCoffeeFile();
	}

	public static void addCoffee() throws ClassNotFoundException, IOException {
		// readMenuCoffee();
		System.out.println("Enter the new Id number ofCoffe name:");
		String newIdNumber = input.nextLine();

		Integer.parseInt(newIdNumber);

		newIdNumber.toString();
		System.out.println("Enter the name of new Coffee:");
		String newnameCoffee = input.nextLine();
		System.out.println("Enter the  cost of new Coffee: ");
		int newCost1 = Integer.parseInt(input.nextLine());
		Coffee item1 = new Coffee();
		item1.setName(newnameCoffee);
		item1.setCost(newCost1);
		item1.setIdnumber(newIdNumber);
		if (item1 instanceof Coffee) {
			List.getListCoffee().add(item1);

		}
		// writeMenuCoffeeFile();
	}

	public static void addCondiments() throws ClassNotFoundException, IOException {
		// readMenuCondiments();
		System.out.println("Enter the new Id number of Condiments name:");
		String newIdNumber1 = input.nextLine();
		try {

		} catch (NumberFormatException e) {
			System.out.println("Your Id number not a integer number!");
		}
		System.out.println("Enter the name of new Condiments:");
		String newnameCoffee1 = input.nextLine();
		System.out.println("Enter the  cost of new Condiments: ");
		int newCost2 = Integer.parseInt(input.nextLine());
		Item item1 = new Item();
		item1.setName(newnameCoffee1);
		item1.setCost(newCost2);
		item1.setIdnumber(newIdNumber1);
		// writeMenuCondimentsFile();
	}

	public static void add(Item item) {
		if (item instanceof Coffee) {
			List.getListCoffee().add(item);
		} else {
			List.getListCondiments().add(item);
		}
	}

	public static void writeMenuCoffeeFile() throws IOException {
		File file = new File("MenuCoffee.txt");
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream output = new ObjectOutputStream(fo);
		for (Item item : List.getListCoffee()) {
			output.writeObject(item);
		}
		fo.close();
		output.close();
	}

	public static void writeMenuCondimentsFile() throws IOException {
		File file = new File("MenuCondiments.txt");
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream output = new ObjectOutputStream(fo);
		for (Item item : List.getListCondiments()) {
			output.writeObject(item);
		}
		fo.close();
		output.close();
	}

	public static void readMenuCoffee() throws IOException, ClassNotFoundException {
		File file = new File("MenuCoffee.txt");
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream input = new ObjectInputStream(fi);
		List.getListCoffee().clear();
		while (input.available() > 0) {
			Coffee item = (Coffee) input.readObject();
			List.getListCoffee().add(item);

		}
		fi.close();
		input.close();

	}

	public static void readMenuCondiments() throws IOException, ClassNotFoundException {
		File file = new File("MenuCoffee.txt");
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream input = new ObjectInputStream(fi);
		//List.getListCondiments().clear();
		ArrayList <Item> listTemp = new ArrayList<>();
		while (true) {
			
			try {
				
				Item item = (Item) input.readObject();
				//List.getListCondiments().add(item);
				listTemp.add(item);
				System.out.println(item.getName());
			} catch (java.io.EOFException ex) {
				break;
			}
			List.setList(listTemp);
		}
		fi.close();
		input.close();
	}

}
