package model.vcard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VCardPropertyType extends VCardProperty {

	protected String type;
	protected List<StringEnum> typeValues = new ArrayList<>();	
	
	public VCardPropertyType(PropertyTypeEnum key) {
		super(key);
		this.type = "TYPE";
	}	
	
	public VCardPropertyType(PropertyTypeEnum key, String type) {
		super(key);
		this.type = type;
	}
	
	public void addTypeVal(StringEnum type) {
		if (!typeValues.contains(type)) {
			typeValues.add(type);
		}		
	}	
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.getKey().toString());
		stringBuilder.append(";");
		stringBuilder.append(type);
		stringBuilder.append("=");
		
		String types = typeValues.stream()
			.map(o -> o.toString())
			.collect(Collectors.joining(","));
		
		stringBuilder.append(types);
		stringBuilder.append(":");
		
		return stringBuilder.toString();
	}
	
}