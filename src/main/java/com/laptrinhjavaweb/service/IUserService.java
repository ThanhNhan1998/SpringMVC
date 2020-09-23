package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {
	
	List<UserDTO> findAll();

	List<UserDTO> findAll(UserDTO userSearch, Pageable pageable);
	
	List<UserDTO> findAll(UserDTO userSearch);
	
	void assignmentBuilding(Long[] ids, Long buildingId);
	
	List<UserDTO> findStaff(Long buildingid);
	
	List<UserDTO> findStaff();
}
