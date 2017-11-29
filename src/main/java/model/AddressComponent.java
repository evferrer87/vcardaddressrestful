package model;

public class AddressComponent {

	private String longName;
	private String shortName;		
	
	AddressComponent() {
		this.longName = "";
		this.shortName = "";
	}
	
	public AddressComponent(String longName, String shortName) {
		this.longName = longName;
		this.shortName = shortName;
	}
	
	public String getLongName() {
		return longName;
	}
	public void setLong_name(String longName) {
		this.longName = longName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShort_name(String short_name) {
		this.shortName = short_name;
	}
	
}
