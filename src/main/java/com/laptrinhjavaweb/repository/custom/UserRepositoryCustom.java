package com.laptrinhjavaweb.repository.custom;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepositoryCustom {
	
	List<UserEntity> findAll(Map<String, Object> properties, Pageable pageable);

	List<UserEntity> findAll(Map<String, Object> properties);
	
	void assignmentStaff(Long buildingId, Long userId);
	
	void deleteAssignmentStaff(Long buildingId, Long userId);
}
