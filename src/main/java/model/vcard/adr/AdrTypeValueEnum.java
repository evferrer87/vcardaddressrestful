package model.vcard.adr;

import model.vcard.StringEnum;

public enum AdrTypeValueEnum implements StringEnum {
	
	DOM("domestic"),
	INTL("international"), 
	POSTAl("postal"),
	PARCEL("parcel"),
	HOME("home"),
	WORK("work");
	
	private final String text;
	
	private AdrTypeValueEnum(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text; 
	}
}
