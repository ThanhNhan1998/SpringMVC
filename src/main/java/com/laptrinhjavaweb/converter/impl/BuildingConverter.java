package com.laptrinhjavaweb.converter.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;

@Component
public class BuildingConverter extends CommonConverter<BuildingDTO, BuildingEntity>{
	private SimpleDateFormat dateFormatter;
	
	public BuildingConverter() {
		// or dd/MM/yyyy H:i:s
		dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	@Override
	public BuildingDTO convertToDTO(BuildingEntity entity) {
		
		BuildingDTO building = super.convertToDTO(entity);
		
		if (entity.getCreatedDate() != null) {
			building.setCreatedDate(dateFormatter.format(entity.getCreatedDate()));
		}
		
		if (entity.getModifiedDate() != null) {
			building.setModifiedDate(dateFormatter.format(entity.getModifiedDate()));
		}
		
		if (entity.getRentAreas().size() > 0) {
			
			String rentArea = entity.getRentAreas()
					.stream()
					.map(item -> String.valueOf(item.getValue()))
					.collect(Collectors.joining(","));
			
			building.setRentArea(rentArea);
		}
		
		building.setAddress(createAddress(building));
		
		building.setType(convertBuildingTypes(building.getType()));
		
		return building;
	}
	
	@Override
	public BuildingEntity convertToEntity(BuildingDTO dto) {
		return super.convertToEntity(dto);
	}
	
	private String convertBuildingTypes(String type) {
		
		if (StringUtils.isNotBlank(type)) {
			return Arrays.stream(BuildingTypesEnum.values())
				.filter(item -> type.contains(item.toString()))
				.map(item -> item.getValue())
				.collect(Collectors.joining(", "));
		}
		
		return "";
	}
	
	private String convertDistrict(String district) {
		
		if (StringUtils.isNotBlank(district)) {
			return Arrays.stream(DistrictsEnum.values())
					.filter(item -> item.toString().equals(district))
					.map(item -> item.getValue())
					.collect(Collectors.joining());
		}
		
		return "";
	}
	
	private String createAddress(BuildingDTO building) {
		
		building.setDistrict(convertDistrict(building.getDistrict()));
		
		List<String> address = new ArrayList<String>();
		
		if (StringUtils.isNotBlank(building.getStreet())) {
			address.add(building.getStreet());
		}
		
		if (StringUtils.isNotBlank(building.getWard())) {
			address.add(building.getWard());
		}
		
		if (StringUtils.isNotBlank(building.getDistrict())) {
			address.add(building.getDistrict());
		}
		
		return address.stream().collect(Collectors.joining(", "));
	}
}
