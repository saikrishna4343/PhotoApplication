package com.PhotoApplicationUserClient.api.ws.users.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.PhotoApplicationUserClient.api.ws.ui.model.entity.UserEntity;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {
	
}
