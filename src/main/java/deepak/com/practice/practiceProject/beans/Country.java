package deepak.com.practice.practiceProject.beans;

public class Country {
	private String name;
	private String currency;
	
	public Country() {
	}
	
	public Country(String name, String currency) {
		super();
		this.name = name;
		this.currency = currency;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
