package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;

public interface IBuildingService{
	List<BuildingDTO> findAll();
	
	List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch);
	
	List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable);
	
	BuildingDTO findById(Long buildingid);
	
	BuildingDTO save(BuildingDTO buildingDTO);
	
	void update(BuildingDTO buildingDTO);
	
	void delete(Long[] ids);
	
	Map<String, String> getDistricts();
	
	Map<String, String> getBuildingTypes();
}
