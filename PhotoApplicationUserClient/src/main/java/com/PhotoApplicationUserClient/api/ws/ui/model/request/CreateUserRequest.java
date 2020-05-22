package com.PhotoApplicationUserClient.api.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class CreateUserRequest {
	
	@NotNull(message = "First Name cannot be null")
	private String firstName;
	
	@NotNull(message = "Last Name cannot be null")
	private String lastName;
	
	@NotNull(message = "Password cannot be null")
	@Size(min =4,max = 16,message = "Password didnot meet the requirements" )
	private String password;
	
	@NotNull(message = "Email cannot be null")
	@Email(message = "Enter valid Email id")
	private String email;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
