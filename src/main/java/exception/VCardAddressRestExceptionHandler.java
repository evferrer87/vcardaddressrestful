package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import exception.util.ExceptionResponseBuilder;

@ControllerAdvice
public class VCardAddressRestExceptionHandler  {

	@ExceptionHandler(VCardPropertyException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ApiError handleVCardPropertyException(VCardPropertyException ex) {	
		return new ApiError(ex.getMessage());
	}	
	
	@ExceptionHandler(IncorrectPlaceIdException.class)
	public ResponseEntity<Object> handleIncorrectPlaceIdException(IncorrectPlaceIdException ex) {		
		ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		return ExceptionResponseBuilder.buildResponseEntity(error);
	}

}