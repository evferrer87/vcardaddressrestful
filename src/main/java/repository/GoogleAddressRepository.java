package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import converter.AddressDetailConverter;
import converter.AdressConverter;
import exception.IncorrectPlaceIdException;
import mapper.JSONMapper;
import mapper.JSONObject;
import model.Address;
import model.AddressDetail;
import utils.UrlBuilder;

public class GoogleAddressRepository implements AddressRepository{
	
	@Autowired
	JSONMapper jsonMapper;
	
	private RestTemplate restTemplate;
	private String googleKey = "AIzaSyBD0gEyDorrfJcxRLOLPN6JE25msvdeilY";	
	
	public GoogleAddressRepository(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;		
	}
	
	@Override
	public List<Address> search(String query) {			
		
		UrlBuilder urlBuilder = new UrlBuilder.Builder("https://maps.googleapis.com/maps/api/place/textsearch/json")
				.AddParameter("query", query)
				.AddParameter("key", googleKey)
				.build();
		String response = restTemplate.getForObject(urlBuilder.getUrl(), String.class);					
		JSONObject objResponse = jsonMapper.fromJson(response);
		
		return  AdressConverter.fromJsonNode(objResponse);			
	}	

	@Override
	public AddressDetail getAddressDetail(String placeId) {
		
		AddressDetail addressDetail = null;
		
		UrlBuilder urlBuilder = new UrlBuilder.Builder("https://maps.googleapis.com/maps/api/place/details/json")
				.AddParameter("placeid", placeId)
				.AddParameter("key", googleKey)
				.build();
		String response = restTemplate.getForObject(urlBuilder.getUrl(), String.class);	
		JSONObject objResponse = jsonMapper.fromJson(response);	
		
		if (objResponse != null && !("OK").equals(objResponse.get("status").textValue()))
			throw new IncorrectPlaceIdException(placeId, "Wrong Google PlaceId");
		
		addressDetail = AddressDetailConverter.fromJsonNode(objResponse);		
				
		return addressDetail;
	}
	
}
