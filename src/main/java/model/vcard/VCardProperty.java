package model.vcard;

public abstract class VCardProperty {
	
	private PropertyTypeEnum key;
	
	public VCardProperty(PropertyTypeEnum key) {
		this.key = key;
	}
	
	public PropertyTypeEnum getKey() {
		return key;
	}
	
	protected void setKey(PropertyTypeEnum key) {
		this.key = key;
	}	
	
}