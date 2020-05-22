package com.PhotoApplicationUserClient.api.ws.ui.controller;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PhotoApplicationUserClient.api.ws.ui.model.dto.UserDto;
import com.PhotoApplicationUserClient.api.ws.ui.model.reponse.UserResponse;
import com.PhotoApplicationUserClient.api.ws.ui.model.request.CreateUserRequest;
import com.PhotoApplicationUserClient.api.ws.users.service.UserService;


@RestController
@RequestMapping("/users")
public class controller {
	
	@Autowired
	private Environment env;
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/getStatus")
	public String getStatus() {
		return "working on port "+env.getProperty("local.server.port");
	}
	
	@PostMapping(path="/createUser", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_RSS_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_RSS_XML_VALUE})
	public ResponseEntity<UserResponse> createUsers(@RequestBody CreateUserRequest createUserRequest) {
		ModelMapper modelMapper = new ModelMapper();
		
		UserDto userDto = modelMapper.map(createUserRequest,UserDto.class);
		UserDto savedDetails = userService.createUser(userDto);
		
		UserResponse userResponse = modelMapper.map(savedDetails, UserResponse.class);
		
		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.ACCEPTED);	
	}
}
