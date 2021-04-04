package edu.comillas.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {

	@NotNull
//	@Min(5) -> para Ints , Longs...
	@Size(min = 5, max = 12)
	private String username;
	@NotBlank
	@Size(min = 5, max = 12)
	private String password;
	private String phone;
}
