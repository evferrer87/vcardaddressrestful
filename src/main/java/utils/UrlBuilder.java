package utils;

public class UrlBuilder {	

	private String url = "";	
	
	public UrlBuilder(Builder builder) {
		this.url = builder.bUrl;
	}
	
	public String getUrl() {
		return url;
	}
	
	public static class Builder {
		String bUrl;
		boolean firstParameter = true;
		
		public Builder(String url) {
			this.bUrl = url;
		}
		
		public Builder AddParameter(String name, String value) {
			if (name == null || name.isEmpty()) return this;			
			String joinChar = firstParameter ? "?" : "&";
			this.bUrl += joinChar + name + "=" + value;
			
			if (firstParameter) firstParameter = false;
			return this;
		}
		
		public Builder AddPart(String urlPart) {
			this.bUrl += "/" + this.bUrl + urlPart;
			return this;
		}
		
		public UrlBuilder build() {
			return new UrlBuilder(this);
		}
	}
}
