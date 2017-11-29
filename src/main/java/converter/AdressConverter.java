package converter;

import java.util.ArrayList;

import mapper.JSONObject;
import model.Address;

public final class AdressConverter {

	public static ArrayList<Address> fromJsonNode(JSONObject jsonObj) {
		
		ArrayList<Address> list = new ArrayList<>();
		
		for (JSONObject node : jsonObj.get("results").getNodes()) {
			list.add(new Address(node.get("formatted_address").textValue(), node.get("place_id").textValue()));
		}
		
		return list;
		
	}

}
