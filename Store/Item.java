package Store;

import java.io.Serializable;

public class Item implements Serializable{
	private String name;
	private String Idnumber;
	private int cost;
	public Item()
	{
		this("1","No name", 0);
	}
	public String getName()
	{
		return name;
	}
	
	public String getIdnumber() {
		return Idnumber;
	}
	public void setIdnumber(String idnumber) {
		Idnumber = idnumber;
	}
	public Item( String idnumber,String name, int cost) {
		this.name = name;
		Idnumber = idnumber;
		this.cost = cost;
	}
	public int getCost()
	{
		return cost;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	

}
