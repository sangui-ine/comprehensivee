package comprehensivee.com.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 @ExceptionHandler(UserNotFoundException.class)
 public Map<String,String>handleBusinessException(UserNotFoundException ex){
	 Map<String,String>errorMap=new HashMap<>();
	 errorMap.put("errorMessage",ex.getMessage());
	 return errorMap;
 }
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 @ExceptionHandler(EmployeeAlreadyExit.class)
 public Map<String,String>handleException(EmployeeAlreadyExit ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
 }
 
 
}




