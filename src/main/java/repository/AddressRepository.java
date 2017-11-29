package repository;

import java.util.List;

import model.Address;
import model.AddressDetail;

public interface AddressRepository {
	public List<Address> search(String placeName);
	public AddressDetail getAddressDetail(String placeId);
}