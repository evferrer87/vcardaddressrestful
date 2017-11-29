package exception;

public class IncorrectPlaceIdException extends RuntimeException {

	private static final long serialVersionUID = -8524518535704984469L;
	private final String placeId;
	
	public IncorrectPlaceIdException(String placeId, String message) {
		super (message);
		this.placeId = placeId;		
	}
	
	public String getPlaceId() {
		return this.placeId;
	}
}
