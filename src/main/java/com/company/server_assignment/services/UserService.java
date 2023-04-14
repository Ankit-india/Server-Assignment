package com.company.server_assignment.services;
import java.util.List;

import com.company.server_assignment.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	List<UserDto> gerAllUser();

}
