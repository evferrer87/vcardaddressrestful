package model.vcard;

public class VCardPropertyValue extends VCardProperty {

	private String value;
	
	public VCardPropertyValue(PropertyTypeEnum key, String value) {
		super(key);
		this.value = value;
	}
		
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.getKey() + ":" + this.getValue(); 
	}
}
