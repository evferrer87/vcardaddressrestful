package converter;

import model.vcard.VCard;

public class VCardJsonConverter {
	
	public String toJson(VCard vcard) {
								
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(vcard != null ? vcard.toString() : null);
		sb.append("}");
				
		System.out.println(sb.toString());
		
		return sb.toString();
		
	}
	
}