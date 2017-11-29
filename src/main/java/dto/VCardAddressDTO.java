package dto;

public class VCardAddressDTO {
	
	private String vCardJson;

	public VCardAddressDTO(String vcard) {
		this.vCardJson = vcard;
	}
	
	public String getVcard() {
		return vCardJson;
	}

	public void setVcard(String vCardJson) {
		this.vCardJson = vCardJson;
	}
	
}
