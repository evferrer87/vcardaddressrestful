package model.vcard;

public enum PropertyTypeEnum {
	
	VERSION("VERSION"),
	URL("URL"),
	ADR("ADR"),
	TEL("TEL"),
	GEO("GEO");
	
	private final String text;
	
	private PropertyTypeEnum(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text; 
	}
}
