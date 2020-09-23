package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long>{

	void deleteByBuilding(BuildingEntity building);
	
	List<RentAreaEntity> findByBuilding(BuildingEntity building);
}
