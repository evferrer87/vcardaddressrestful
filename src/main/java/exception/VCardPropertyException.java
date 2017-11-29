package exception;

public class VCardPropertyException extends RuntimeException {

	private static final long serialVersionUID = -1620316691550871148L;
	private final String propertyKey;
	
	public VCardPropertyException(String propertyKey, String message) {
		super (message);
		this.propertyKey = propertyKey;		
	}
	
	public String getPropertyKey() {
		return this.propertyKey;
	}
}