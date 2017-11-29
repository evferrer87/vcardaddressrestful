package model;

public class Address {
	
	private String formatter_address;
	private String place_id;
	
	public Address(String formatter_address, String place_id) {
		super();
		this.formatter_address = formatter_address;
		this.place_id = place_id;
	}

	public String getFormatter_address() {
		return formatter_address;
	}

	public void setFormatter_address(String formatter_address) {
		this.formatter_address = formatter_address;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	
}
