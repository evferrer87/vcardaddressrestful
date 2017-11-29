package app;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import converter.VCardAddressAssembler;
import converter.VCardJsonConverter;
import mapper.JSONMapper;
import mapper.JSONMapperImp;
import repository.AddressRepository;
import repository.GoogleAddressRepository;
import service.AddressFinderService;

public class ApplicationConfig {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}	
	
	@Bean
	public AddressRepository addressRepository(RestTemplate restTemplate) {
		return new GoogleAddressRepository(restTemplate);
	}

	@Bean
	public AddressFinderService addressFinderService(AddressRepository repository) {
		return new AddressFinderService(repository);
	}
	
	@Bean
	public VCardAddressAssembler vCardAddressDTOAssembler() {
		return new VCardAddressAssembler();
	}
	
	@Bean
	public VCardJsonConverter vCardJsonConverter() {
		return new VCardJsonConverter();
	}
		
	@Bean
	public JSONMapper objectMapper() {
		return new JSONMapperImp();			
	}
}
