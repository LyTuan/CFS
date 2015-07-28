package Customer;

import java.util.ArrayList;

import java.util.Scanner;

import Store.Coffee;
import Store.Item;
import Store.List;

public class Customer {
	private static ArrayList <Item> listOrder = new ArrayList <>();
	Scanner input = new Scanner(System.in);
	private String nameCustomer;
	private int numberTable;
	public Customer()
	{
		this("No name Customer", 0);
	}
	public Customer(String nameCustomer, int numberTable)
	{
		this.nameCustomer =nameCustomer;
		this.numberTable = numberTable;
	}
	public void choseCoffe(String idNumber)
	{
		for(Item item:List.getListCoffee())
		{
			if(idNumber.equals(item.getIdnumber()))
			{
				System.out.println("co");
				listOrder.add(item);
			}
		}
		for(Item item:List.getListCondiments())
		{
			if(idNumber.equals(item.getIdnumber()))
			{
				listOrder.add(item);
			}
		}
	}
	public static ArrayList <Item> getListOrder()
	{
		return listOrder;
	}
	
	public void printBill()
	{
		int sum =0;
		for(Item item:listOrder)
		{
			sum +=item.getCost();
		}
		System.out.println("----------------------");
		System.out.println("Total money:"+sum);
	}
	

	

}
