package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom{
	UserEntity findOneByUserNameAndStatus(String name, int status);
	
	@Query(value = 
			"SELECT DISTINCT * FROM user INNER JOIN user_role on user.id = user_role.userid INNER JOIN role"
			+ " on user_role.roleid = role.id WHERE role.code = 'STAFF'", 
			nativeQuery = true)
	List<UserEntity> findByStaff();
	
	// check staff (via staffid) is manager building (via buildingid)
	@Query(value = "SELECT COUNT(*) FROM assignmentstaff WHERE staffid =:staffId AND buildingid =:buildingId", nativeQuery = true)
	Long checkStaffByBuilding(@Param("staffId") Long staffId, @Param("buildingId") Long buildingId);
	
	List<UserEntity> findByBuildings(BuildingEntity building);
}
