package com.PhotoApplicationUserClient.api.ws.users.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.PhotoApplicationUserClient.api.ws.shared.Utils;
import com.PhotoApplicationUserClient.api.ws.ui.model.dto.UserDto;
import com.PhotoApplicationUserClient.api.ws.ui.model.entity.UserEntity;
import com.PhotoApplicationUserClient.api.ws.users.data.UsersRepository;
import com.PhotoApplicationUserClient.api.ws.users.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	Utils utils;
	
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		ModelMapper modelMapper = new ModelMapper();
		
		userDto.setUserId(utils.generateUserId(25));
		userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		
		UserEntity savedDetails = userRepository.save(userEntity);
		
		UserDto returnData = modelMapper.map(savedDetails, UserDto.class);
		return returnData;
	}

}
