package converter;

import org.springframework.beans.factory.annotation.Autowired;

import dto.VCardAddressDTO;
import model.AddressDetail;
import model.vcard.PropertyTypeEnum;
import model.vcard.VCard;
import model.vcard.VCardPropertyValue;
import model.vcard.adr.AdrTypeValueEnum;
import model.vcard.adr.VCardPropertyAdr;
import model.vcard.tel.TelTypeEnum;
import model.vcard.tel.VCardPropertyTel;

public class VCardAddressAssembler{
	
	@Autowired
	public VCardJsonConverter vCardJsonConverter;
	
	public VCardAddressDTO CreateDTO(AddressDetail addressDetail) {		
				
		VCard vcard = null;		
		
		if (addressDetail != null) {	
			
			vcard = new VCard();			
			vcard.addProperty(new VCardPropertyValue(PropertyTypeEnum.VERSION, "v3.0"));
			vcard.addProperty(new VCardPropertyValue(PropertyTypeEnum.URL, addressDetail.getWebsiteUrl()));
			
			VCardPropertyAdr adr = new VCardPropertyAdr();
			adr.addTypeVal(AdrTypeValueEnum.WORK);			
			adr.setStreet(addressDetail.getStreetNumber().getLongName());
			adr.setCountry(addressDetail.getCountry().getLongName());	
			adr.setExtendedAddress(addressDetail.getFormattedAddress());
			adr.setPostalCode(addressDetail.getPostalCode().getLongName());			
			adr.setLocality(addressDetail.getLocality().getLongName());
			
			vcard.addProperty(adr);
			
			VCardPropertyTel tel = new VCardPropertyTel(PropertyTypeEnum.TEL);
			tel.addTypeVal(TelTypeEnum.VOICE);
			tel.setValue(addressDetail.getFormattedPhoneNumber());
			
			vcard.addProperty(tel);
						
			vcard.addProperty(new VCardPropertyValue(PropertyTypeEnum.GEO, addressDetail.getLocation().toString()));			
			
		}
		return new VCardAddressDTO(vCardJsonConverter.toJson(vcard));
	}	
	
}