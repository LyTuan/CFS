package Store;

import java.util.ArrayList;

public class List {
	private static ArrayList<Item> listCoffee = new ArrayList<>();
	private static ArrayList<Item> listCondiments = new ArrayList<>();

	public static ArrayList<Item> getListCoffee() {
		return listCoffee;
	}

	public static void printListCoffe() {
		for (Item item : listCoffee) {
			System.out.println(item.getIdnumber() + "-" + item.getName() + "-" + item.getCost() + "$");
		}
	}

	public static void printListCondiments() {
		for (Item item : listCondiments) {
			System.out.println(item.getIdnumber() + "-" + item.getName() + "-" + item.getCost() + "$");
		}
	}

	public static void setList(ArrayList<Item> listTemp) {
		for(Item item: listTemp)
		{
			listCoffee.add(item);
			//System.out.println(item.getName());
		}
	}

	public static ArrayList<Item> getListCondiments() {
		return listCondiments;
	}

}
