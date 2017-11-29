package model;

public class AddressDetail {	
	private String formattedAddress;
	private String placeId;
	private AddressComponent country;
	private AddressComponent locality;
	private AddressComponent street;	
	private AddressComponent streetNumber;
	private AddressComponent floor;
	private AddressComponent postalCode;
	private String formattedPhoneNumber;
	private Location location;
	private String websiteUrl;
	
	private AddressDetail(Builder builder) 
	{
		this.formattedAddress = builder.formattedAddress;
		this.placeId = builder.placeId;
		this.country = builder.country != null ? builder.country : new AddressComponent();
		this.locality = builder.locality != null ? builder.locality : new AddressComponent();
		this.street = builder.street != null ? builder.street : new AddressComponent();
		this.streetNumber = builder.streetNumber != null ? builder.streetNumber : new AddressComponent();
		this.floor = builder.floor != null ? builder.floor : new AddressComponent();
		this.postalCode = builder.postalCode != null ? builder.postalCode : new AddressComponent();
		this.formattedPhoneNumber = builder.formattedPhoneNumber != null ? builder.formattedPhoneNumber : "";
		this.location = builder.location != null ? builder.location : new Location();
		this.websiteUrl = builder.websiteUrl != null ? builder.websiteUrl : "";
	}
	
	public String getFormattedAddress() {
		return formattedAddress;
	}
	
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	
	public String getPlaceId() {
		return placeId;
	}
	
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	
	public AddressComponent getCountry() {
		return country;
	}
	
	public void setCountry(AddressComponent country) {
		this.country = country;
	}
	
	public AddressComponent getLocality() {
		return locality;
	}
	
	public void setLocality(AddressComponent locality) {
		this.locality = locality;
	}
	
	public AddressComponent getStreet() {
		return street;
	}
	public void setStreet(AddressComponent street) {
		this.street = street;
	}
	
	public AddressComponent getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreet_number(AddressComponent street_number) {
		this.streetNumber = street_number;
	}
	
	public AddressComponent getFloor() {
		return floor;
	}
	
	public void setFloor(AddressComponent floor) {
		this.floor = floor;
	}
	
	public void setPostalCode(AddressComponent postalCode) {
		this.postalCode = postalCode;
	}
	
	public AddressComponent getPostalCode() {
		return this.postalCode;
	}
	
	public void setFormattedPhoneNumber(String formattedPhoneNumber) {
		this.formattedAddress = formattedPhoneNumber;
	}	
	
	public String getFormattedPhoneNumber() {
		return this.formattedPhoneNumber;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setWebsiteUrl(String websitreUrl) {
		this.websiteUrl = websitreUrl;
	}
	
	public String getWebsiteUrl() {
		return this.websiteUrl;
	}	
	
	public static class Builder {
		private String formattedAddress;
		private String placeId;
		private AddressComponent country;
		private AddressComponent locality;
		private AddressComponent street;	
		private AddressComponent streetNumber;
		private AddressComponent floor;
		private AddressComponent postalCode;  
		private String formattedPhoneNumber;
		private Location location;
		private String websiteUrl;
        
		public Builder(String placeId)
		{			
			this.placeId = placeId;
		}
		
        public Builder formmattedAddress(String formattedAddress) {        	
        	this.formattedAddress = formattedAddress;
        	return this;
        } 
        
        public Builder placeId(String placeId) {
        	this.placeId = placeId;
        	return this;
        }   
        
        public Builder country(AddressComponent country) {
        	this.country = country;
        	return this;
        }
        
        public Builder locality(AddressComponent locality) {
        	this.locality = locality;
        	return this;
        }
        
        public Builder street(AddressComponent street) {
        	this.street = street;
        	return this;
        }
        
        public Builder streetNumber(AddressComponent streesNumber) {
        	this.streetNumber = streesNumber;
        	return this;
        }
        
        public Builder floor(AddressComponent floor) {
        	this.floor = floor;
        	return this;
        }
        
        public Builder postalCode(AddressComponent postalCode) {
        	this.postalCode = postalCode;
        	return this;
        }        
        
        public Builder formattedPhoneNumber(String formattedPhoneNumber) {
        	this.formattedPhoneNumber = formattedPhoneNumber;
        	return this;
        }
        
        public Builder location(Location location) {
        	this.location = location;        	
        	return this;
        }
        
        public Builder websiteUrl(String websiteUrl) {
        	this.websiteUrl = websiteUrl;
        	return this;
        }
        
        public AddressDetail build(){
			return new AddressDetail(this);
		}
	}
}