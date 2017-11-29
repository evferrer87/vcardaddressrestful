package model.vcard.tel;

import model.vcard.PropertyTypeEnum;
import model.vcard.VCardPropertyType;

public class VCardPropertyTel extends VCardPropertyType {

	private String value;
	
	public VCardPropertyTel(PropertyTypeEnum key) {
		super(key);		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(super.toString());
		stringBuilder.append(this.value);
		
		return stringBuilder.toString();
	}
	
}
