package utils;

public final class URLParamValidator {
	
	public static boolean validate(String input) {
		return input != null && !input.isEmpty() ? true : false; 
	}
	
}