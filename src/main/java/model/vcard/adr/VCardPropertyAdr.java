package model.vcard.adr;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import model.vcard.PropertyTypeEnum;
import model.vcard.StringEnum;
import model.vcard.VCardPropertyType;

public class VCardPropertyAdr extends VCardPropertyType {		
	
	protected LinkedHashMap<StringEnum,String> components = new LinkedHashMap<>();
	
	public VCardPropertyAdr() {
		super(PropertyTypeEnum.ADR);
		for (AdrComponentEnum comp : AdrComponentEnum.values()) {			
			addComponent(comp, "");
		}
	}
	
	protected String getComponent(StringEnum comp) {
		return components.get(comp);
	}	
	
	public void addComponent(StringEnum key, String value) {
		components.put(key, value);
	}		
	
	public void setPostOfficeAddress(String value) {
		addComponent(AdrComponentEnum.POBOX, value);		
	}
	
	public void setExtendedAddress(String value) {
		addComponent(AdrComponentEnum.EXT, value);
	}
	
	public void setStreet(String value) {
		addComponent(AdrComponentEnum.STREET, value);
	}
	
	public void setLocality(String value) {
		addComponent(AdrComponentEnum.LOCALITY, value);
	}
	
	public void setRegion(String value) {
		addComponent(AdrComponentEnum.REGION, value);
	}
	
	public void setPostalCode(String value) {
		addComponent(AdrComponentEnum.CODE, value);
	}
	
	public void setCountry(String value) {
		addComponent(AdrComponentEnum.COUNTRY, value);
	}
	
	public String getPostOfficeAddress() {
		return getComponent(AdrComponentEnum.POBOX);		
	}
	
	public String getExtendedAddress() {
		return getComponent(AdrComponentEnum.EXT);
	}
	
	public String getStreet() {
		return getComponent(AdrComponentEnum.STREET);
	}
	
	public String getLocality() {
		return getComponent(AdrComponentEnum.LOCALITY);
	}
	
	public String getRegion() {
		return getComponent(AdrComponentEnum.REGION);
	}
	
	public String getPostalCode() {
		return getComponent(AdrComponentEnum.CODE);
	}
	
	public String getCountry() {
		return getComponent(AdrComponentEnum.COUNTRY);
	}	
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		String stringComponents = this.components.values().stream()
			.collect(Collectors.joining(";"));
		
		stringBuilder.append(super.toString());
		stringBuilder.append(stringComponents);
		
		return stringBuilder.toString();	
	}
}
