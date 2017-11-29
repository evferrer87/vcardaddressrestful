package model.vcard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exception.VCardPropertyException;

public class VCard {
	
	
	private List<VCardProperty> properties;	
	
	public VCard() {
		properties = new ArrayList<VCardProperty>();
	}
	
	public VCard(List<VCardProperty> properties) {
		this.properties = properties;
	}	
	
	public VCardProperty getProperty(String name) {
		return properties.stream()
				.filter(x -> x.getKey().equals(name))
				.findFirst()
				.orElse(null);	
	}
	
	@Override
	public String toString() {
		
		String vCardBegin = "BEGIN:VCARD";
		String vCardEnd = "END:VCARD";		
		
		String vCardBody = properties.stream()
				.map(Object::toString)			
				.collect(Collectors.joining(System.lineSeparator()))				
				.toString();			
		
		StringBuilder sb = new StringBuilder();
		sb.append(vCardBegin);
		sb.append(System.lineSeparator());
		sb.append(vCardBody);
		sb.append(System.lineSeparator());
		sb.append(vCardEnd);				
		
		return sb.toString();
	}
		
	public void addProperty(VCardProperty property) {		
		if (properties.size() == 0 && !("version").contains(property.getKey().toString().toLowerCase())) {			
			throw new VCardPropertyException(property.getKey().toString(), "The first property should be \"VERSION\" ");
		}
			
		properties.add(property);
	}
}
