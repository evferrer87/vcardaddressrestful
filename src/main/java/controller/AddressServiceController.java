package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import converter.VCardAddressAssembler;
import dto.VCardAddressDTO;
import model.Address;
import service.AddressFinderService;

@RestController
public class AddressServiceController {
	
	private AddressFinderService addressFinderService;
	
	@Autowired
	private VCardAddressAssembler vCardDTOAssembler;
	
	public AddressServiceController(AddressFinderService service) {
		this.addressFinderService = service;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public List<Address> search(@RequestParam(value="query", defaultValue = "") String query) {
		return addressFinderService.search(query);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/addressDetail")
	public VCardAddressDTO addressDetail(@RequestParam(value="placeId", defaultValue = "") String placeId) {
		return vCardDTOAssembler.CreateDTO(addressFinderService.addressDetail(placeId));
	}
}