package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.impl.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public List<UserDTO> findAll(UserDTO userSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findAll(UserDTO userSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void assignmentBuilding(Long[] ids, Long buildingId) {
		
		List<Long> newUserIds = Arrays.asList(ids);
		
		List<UserDTO> userDTOs = findStaff(buildingId);
		
		List<Long> oldUserIds = new ArrayList<Long>();
		
		for(UserDTO user: userDTOs) {
			
			if (user.getChecked().equals("checked")) {
				oldUserIds.add(user.getId());
			}
		}
		
		for(Long newUserId: newUserIds) {
			
			if (!oldUserIds.contains(newUserId)) {
				userRepository.assignmentStaff(buildingId, newUserId);
			}
		}
		
		for(Long oldUserId: oldUserIds) {
			
			if (!newUserIds.contains(oldUserId)) {
				userRepository.deleteAssignmentStaff(buildingId, oldUserId);
			}
		}
	}

	@Override
	public List<UserDTO> findStaff(Long buildingid) {
		List<UserEntity> userEntities = userRepository.findByStaff();
		
		List<UserDTO> userDTOs = userEntities.stream().map(item -> userConverter.convertToDTO(item)).collect(Collectors.toList());
		
		for (UserDTO userDTO : userDTOs) {
			if (userRepository.checkStaffByBuilding(userDTO.getId(), buildingid) != 0) {
				userDTO.setChecked("checked");
			}else {
				userDTO.setChecked("");
			}
		}
		
		return userDTOs;
	}

	@Override
	public List<UserDTO> findStaff() {
		List<UserEntity> userEntities = userRepository.findByStaff();

		return userEntities.stream().map(item -> userConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
