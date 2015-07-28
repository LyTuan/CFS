package Store;

import java.io.Serializable;

public class Coffee extends Item implements Serializable{
	//private String color;
	public Coffee(String Idnumber,String name, int cost)
	{
		super(Idnumber,name,cost);
	}
	public Coffee() {
		this("0","No name",0);
		// TODO Auto-generated constructor stub
	}
}
