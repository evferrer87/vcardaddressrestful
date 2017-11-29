package model.vcard.adr;

import model.vcard.StringEnum;

public enum AdrComponentEnum implements StringEnum {
	
	POBOX("pobox"),
	EXT("ext"),
	STREET("street"),
	LOCALITY("locality"),
	REGION("region"),
	CODE("code"),
	COUNTRY("country"); 
	
	private final String text;
	
	private AdrComponentEnum(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text; 
	}
	
}
