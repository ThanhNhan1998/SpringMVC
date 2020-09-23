package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.impl.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private BuildingConverter buildingConverter;

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private RentAreaRepository rentAreaRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();

		buildingEntities.stream().forEach(item -> item.setRentAreas(rentAreaRepository.findByBuilding(item)));
		
		List<BuildingDTO> buildingDTOs = buildingEntities.stream().map((item) -> buildingConverter.convertToDTO(item))
				.collect(Collectors.toList());
		
		
		return buildingDTOs;
	}
	
	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable) {
		Map<String, Object> properties = convertToMapProperties(fieldSearch);

		List<BuildingEntity> buildingEntities = buildingRepository.findAll(properties, pageable, fieldSearch);
		
		buildingEntities.stream().forEach(item -> item.setRentAreas(rentAreaRepository.findByBuilding(item)));
		
		List<BuildingDTO> buildingDTOs = buildingEntities.stream().map((item) -> buildingConverter.convertToDTO(item))
				.collect(Collectors.toList());

		return buildingDTOs;
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch) {
		Map<String, Object> properties = convertToMapProperties(fieldSearch);

		List<BuildingEntity> buildingEntities = buildingRepository.findAll(properties, fieldSearch);

		buildingEntities.stream().forEach(item -> item.setRentAreas(rentAreaRepository.findByBuilding(item)));
		
		List<BuildingDTO> buildingDTOs = buildingEntities.stream().map((item) -> buildingConverter.convertToDTO(item))
				.collect(Collectors.toList());

		return buildingDTOs;
	}

	@Override
	public BuildingDTO findById(Long buildingid) {
		
		BuildingEntity buildingEntity = buildingRepository.findOne(buildingid);
		
		buildingEntity.setRentAreas(rentAreaRepository.findByBuilding(buildingEntity));
		
		return buildingConverter.convertToDTO(buildingRepository.findOne(buildingid));
	}

	@Override
	@Transactional
	public BuildingDTO save(BuildingDTO buildingDTO) {

		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);

		buildingEntity.setType(String.join(",", buildingDTO.getBuildingTypes()));

		buildingEntity = buildingRepository.save(buildingEntity);

		for (String rentArea : buildingDTO.getAreaRent().split(",")) {
			RentAreaEntity rentAreaEntity = new RentAreaEntity();

			rentAreaEntity.setValue(Integer.parseInt(rentArea));

			rentAreaEntity.setBuilding(buildingEntity);

			rentAreaRepository.save(rentAreaEntity);
		}

		return buildingConverter.convertToDTO(buildingEntity);
	}

	@Override
	@Transactional
	public void update(BuildingDTO buildingDTO) {

		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);

		buildingEntity.setType(String.join(",", buildingDTO.getBuildingTypes()));
		
		rentAreaRepository
			.findByBuilding(buildingEntity)
			.stream()
			.forEach(item -> rentAreaRepository.delete(item));
		
		for (String rentArea : buildingDTO.getAreaRent().split(",")) {
			RentAreaEntity rentAreaEntity = new RentAreaEntity();

			rentAreaEntity.setValue(Integer.parseInt(rentArea));

			rentAreaEntity.setBuilding(buildingEntity);

			rentAreaRepository.save(rentAreaEntity);
		}
		
		buildingRepository.save(buildingEntity);
	}

	@Override
	@Transactional
	public void delete(Long[] ids) {

		for (Long id : ids) {

			buildingRepository.deleteProperties(id);
			buildingRepository.delete(id);
		}
	}

	@Override
	public Map<String, String> getDistricts() {
		Map<String, String> districts = new HashMap<>();

		for (DistrictsEnum item : DistrictsEnum.values()) {
			districts.put(item.toString(), item.getValue());
		}

		return districts;
	}

	@Override
	public Map<String, String> getBuildingTypes() {
		Map<String, String> buildingTypes = new HashMap<>();

		for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
			buildingTypes.put(item.toString(), item.getValue());
		}

		return buildingTypes;
	}

	private Map<String, Object> convertToMapProperties(BuildingSearchBuilder fieldSearch) {

		Map<String, Object> properties = new HashMap<String, Object>();

		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();

			for (Field field : fields) {
				field.setAccessible(true);

				Object fieldValue = field.get(fieldSearch);
				String fieldName = field.getName();

				if (fieldValue instanceof String) {
					if (!fieldName.startsWith("costRent") && !fieldName.startsWith("areaRent")
							&& !fieldName.equals("staffId")) {

						if (fieldName.equals("numberOfBasement") || fieldName.equals("buildingArea")) {
							if (fieldValue != null && StringUtils.isNotEmpty((String) fieldValue))
								properties.put(fieldName.toLowerCase(), Integer.parseInt((String) fieldValue));
						} else {
							properties.put(fieldName.toLowerCase(), fieldValue);
						}
					}
				}
			}

		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties;
	}
}
