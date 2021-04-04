package edu.comillas.demo.controller.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.comillas.demo.model.ValidationErrors;
import edu.comillas.demo.model.ValidationErrors.ErrorCustom;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> genericError(Exception e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> validationError(MethodArgumentNotValidException e) {
		final List<FieldError> errors = e.getBindingResult().getFieldErrors();

		final ValidationErrors validationErrors = new ValidationErrors();
//		String errorFinal = "";
		for (final FieldError error : errors) {
//			errorFinal += "Error in field: " + error.getField() + " with validation error " + error.getDefaultMessage();
			final ErrorCustom custom = new ErrorCustom();
			custom.setField(error.getField());
			custom.setMessage(error.getDefaultMessage());
			validationErrors.getErrors().add(custom);

//			ErrorCustom customWithBuilder = ErrorCustom.builder().field(error.getField())
//					.message(error.getDefaultMessage()).build();
//
//			validationErrors.getErrors().add(customWithBuilder);

		}

		return new ResponseEntity<>(validationErrors, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
