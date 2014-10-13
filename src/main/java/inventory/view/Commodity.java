package inventory.view;

public class Commodity {

	private String index;
	private String name;
	private String type;
	private double price;
	
	public Commodity(String i, String n, String t, double p){
		index = i;
		name = n;
		type = t;
		price = p;
	}
	
	public String getIndex(){
		return index;
	}
	
	public String getName(){
		return name;
	}
	
	public String getType(){
		return type;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public void setType(String t){
		type = t;
	}
	
	public void setPrice(double p){
		price = p;
	}
}
