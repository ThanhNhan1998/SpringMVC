package com.laptrinhjavaweb.repository.custom.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> properties, Pageable pageable, BuildingSearchBuilder fieldSearch) {
		
		StringBuilder sql = new StringBuilder("SELECT DISTINCT * FROM building A");

		if (StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			sql.append(" INNER JOIN assignmentstaff on A.id = assignmentstaff.buildingid");
		}

		sql.append(" WHERE 1");

		sql = this.createSQLSearch(sql, properties);

		sql.append(createSQLSepecial(fieldSearch));
		
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		
		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> properties, BuildingSearchBuilder fieldSearch) {
		StringBuilder sql = new StringBuilder("SELECT DISTINCT * FROM building A");

		if (StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			sql.append(" INNER JOIN assignmentstaff on A.id = assignmentstaff.buildingid");
		}

		sql.append(" WHERE 1");

		sql = this.createSQLSearch(sql, properties);

		sql.append(createSQLSepecial(fieldSearch));
		
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		
		return query.getResultList();
	}
	
	private String createSQLSepecial(BuildingSearchBuilder fieldSearch) {
		StringBuilder sql = new StringBuilder();

		// cost rent
		if (StringUtils.isNotBlank(fieldSearch.getCostRentFrom())) {
			sql.append(" AND A.costrent >= " + fieldSearch.getCostRentFrom() + "");
		}
		if (StringUtils.isNotBlank(fieldSearch.getCostRentTo())) {
			sql.append(" AND A.costrent <= " + fieldSearch.getCostRentTo() + "");
		}

		// buildingTypes

		if (fieldSearch.getBuildingTypes() != null && fieldSearch.getBuildingTypes().length > 0) {
			sql.append(" AND(");

			String sqlBuildingTypes = Arrays.stream(fieldSearch.getBuildingTypes())
					.map(item -> "A.type LIKE '%" + item + "%'").collect(Collectors.joining(" OR "));

			sql.append(sqlBuildingTypes);
			sql.append(")");
		}

		// rent area

		if (StringUtils.isNotBlank(fieldSearch.getAreaRentFrom())
				|| StringUtils.isNotBlank(fieldSearch.getAreaRentTo())) {
			sql.append(" AND EXISTS (SELECT * FROM rentarea ra WHERE(ra.buildingid = A.id");

			if (StringUtils.isNotBlank(fieldSearch.getAreaRentFrom())) {
				sql.append(" AND ra.value >= " + fieldSearch.getAreaRentFrom() + "");
			}

			if (StringUtils.isNotBlank(fieldSearch.getAreaRentTo())) {
				sql.append(" AND ra.value <= " + fieldSearch.getAreaRentTo() + "");
			}

			sql.append("))");
		}
		
		// staff
		if (StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			sql.append(" AND assignmentstaff.staffid = "+fieldSearch.getStaffId()+"");
		}
		
		return sql.toString();
	}
	
	private StringBuilder createSQLSearch(StringBuilder sql, Map<String, Object> properties) {

		if (properties != null && properties.size() > 0) {
			properties.forEach((key, value) -> {
				if (value instanceof String && StringUtils.isNotBlank((String) value)) {
					sql.append(" AND LOWER(A." + key + ") LIKE '%" + value.toString() + "%'");
				} else if (value instanceof Integer && value != null) {
					sql.append(" AND LOWER(A." + key + ") = " + value + "");
				} else if (value instanceof Long && value != null) {
					sql.append(" AND LOWER(A." + key + ") = " + value + "");
				}
			});
		}

		return sql;
	}

	@Override
	@Transactional
	public void deleteProperties(Long id) {
		
		String sqlDelete_RentArea = "DELETE FROM rentarea WHERE buildingid = "+id+"";
		
		String sqlDelete_assignmentStaff = "DELETE FROM assignmentstaff WHERE buildingid = "+id+"";
		
		Query query = entityManager.createNativeQuery(sqlDelete_RentArea);
		
		query.executeUpdate();
		
		query = entityManager.createNativeQuery(sqlDelete_assignmentStaff);
		
		query.executeUpdate();
	}
}
