package exception.util;

import org.springframework.http.ResponseEntity;

import exception.ApiError;

public final class ExceptionResponseBuilder {

	public static  ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
}
