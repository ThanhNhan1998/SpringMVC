package com.laptrinhjavaweb.repository.custom.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UserEntity> findAll(Map<String, Object> properties, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findAll(Map<String, Object> properties) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	@Transactional
	public void assignmentStaff(Long buildingId, Long userId) {

		String assignment = "INSERT INTO assignmentstaff VALUES(" + buildingId + ", " + userId + ")";

		Query query = entityManager.createNativeQuery(assignment);

		query.executeUpdate();
	}

	@Override
	@Transactional
	public void deleteAssignmentStaff(Long buildingId, Long userId) {
		String Sqldelete = "DELETE FROM assignmentstaff WHERE staffid = " + userId + " AND buildingid = " + buildingId
				+ "";

		Query query = entityManager.createNativeQuery(Sqldelete);

		query.executeUpdate();
	}
}
