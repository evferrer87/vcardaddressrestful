package model.vcard.tel;

import model.vcard.StringEnum;

public enum TelTypeEnum implements StringEnum{
	
	PREF("PREF"),
	WORK("WORK"),
	HOME("HOME"),
	VOICE("VOICE"),
	FAX("FAX"),
	MSG("MSG"),
	CELL("CELL"),
	PAGER("PAGER"),
	BBS("BBS"),
	MODEM("MODEM"),
	CAR("CAR"),
	ISDN("ISDN"),
	VIDEO("VIDEO");
	
	
	private final String text;
	
	private TelTypeEnum(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text; 
	}
	
}
