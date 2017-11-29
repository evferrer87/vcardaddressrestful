package converter;

import java.util.Iterator;

import mapper.JSONObject;
import model.AddressComponent;
import model.AddressDetail;
import model.Location;

public final class AddressDetailConverter {
	
	public static AddressDetail fromJsonNode (JSONObject jsonObj) {			
		
		if (jsonObj == null) return null;
		
		AddressDetail addressDetail = null;
		
		JSONObject result = (JSONObject) jsonObj.get("result");
		
		JSONObject addressComponents = result.get("address_components");
		JSONObject geometry = result.get("geometry");
		JSONObject location = geometry.get("location");				
		
		String placeId = result.get("place_id").textValue();
		String formattedAddress = result.get("address_components").textValue();
		String formattedPhonenumber = result.get("formatted_phone_number").textValue();
		String latitude = location.get("lat").textValue();
		String longitude = location.get("lng").textValue();
		String website = result.get("website").textValue();
		
		addressDetail = new AddressDetail.Builder(placeId)
			.formmattedAddress(formattedAddress)
			.formattedPhoneNumber(formattedPhonenumber)
			.location(new Location(latitude, longitude))				
			.websiteUrl(website)				
			.build();
		
		addressComponentMapper(addressComponents, addressDetail);					
		
		return addressDetail;
	}
		
	private static void addressComponentMapper(JSONObject addressComponents, AddressDetail addressDetail) {		
		
		String longName = "";
		String shortName = "";
		JSONObject types;							
		
		for (JSONObject node: addressComponents.getNodes()) {	
			
			longName = node.get("long_name").textValue();
			shortName = node.get("short_name").textValue();
			types = node.get("types");			
			
			if (containValue(types, "country")) {
				addressDetail.setCountry(new AddressComponent(longName,shortName));
				continue;
			}			
			if (containValue(types, "locality")) {
				addressDetail.setLocality(new AddressComponent(longName,shortName));
				continue;
			}
			if (containValue(types, "route")) {
				addressDetail.setStreet(new AddressComponent(longName,shortName));
				continue;
			}
			if (containValue(types, "street_number")) {
				addressDetail.setStreet_number(new AddressComponent(longName,shortName));
				continue;
			}
			if (containValue(types, "floor")) {
				addressDetail.setFloor(new AddressComponent(longName,shortName));
				continue;
			}
			if (containValue(types, "postal_code")) {
				addressDetail.setPostalCode(new AddressComponent(longName,shortName));
				continue;
			}
		}		
	}
	
	private static boolean containValue(JSONObject jsonObj, String value) {
				
		Iterator<JSONObject> iterator = jsonObj.getNodes().iterator();
		while (iterator.hasNext()) {
			String type = iterator.next().textValue();
			if ((value).equals(type)) {
				return true;
			}
		}
		
		return false;
	}

}
