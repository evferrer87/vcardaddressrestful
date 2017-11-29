package mapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class JSONObject {

	private JsonNode node;
	
	public JSONObject(JsonNode node) {
		this.node = node;
	}
	
	public JSONObject get(String key) {
		return new JSONObject(this.node != null ? this.node.get(key) : null);
	}
	
	public String textValue() {
		if (this.node != null)
			return this.node.asText();
		return "";
	}
		
	public List<JSONObject> getNodes() {
		List<JSONObject> nodes = new ArrayList<JSONObject>();
		if (this.node == null) return nodes;
		for (com.fasterxml.jackson.databind.JsonNode node : this.node) {
			nodes.add(new JSONObject(node));			
		}
		return nodes;
	}
	
	public Boolean isNull() {
		return this.node == null;
	}
}
