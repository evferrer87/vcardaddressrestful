package service;

import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.AddressDetail;
import repository.AddressRepository;
import utils.URLParamValidator;

public class AddressFinderService {
	
	private AddressRepository repository;	
	
	public AddressFinderService(AddressRepository repository) {
		this.repository = repository;		
	}
	
	public List<Address> search(String query) {
		if (!URLParamValidator.validate(query)) return new ArrayList<Address>();
		return repository.search(query);
	}
	
	public AddressDetail addressDetail(String placeId) {
		if (!URLParamValidator.validate(placeId)) return null;
		return repository.getAddressDetail(placeId);
	}
}
