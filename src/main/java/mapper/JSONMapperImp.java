package mapper;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import converter.AdressConverter;

public class JSONMapperImp implements JSONMapper {
	
	private static final Logger log = LoggerFactory.getLogger(AdressConverter.class);
	
	@Override
	public JSONObject fromJson (String json) {
		
		JsonNode objNode = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			objNode = mapper.readTree(json);		    
		} catch (JsonProcessingException e) {
			log.info(e.getMessage());
		} catch (IOException e) {
			log.info(e.getMessage());
		}
		
		return new JSONObject(objNode);		
	}
	
}