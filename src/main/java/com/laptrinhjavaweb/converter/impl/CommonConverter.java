package com.laptrinhjavaweb.converter.impl;

import java.lang.reflect.ParameterizedType;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.converter.IConverter;

public class CommonConverter<D, E> implements IConverter<D, E>{
	
	private Class<D> dClass;
	private Class<E> eClass;
	
	@SuppressWarnings("unchecked")
	public CommonConverter() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		dClass = (Class<D>) parameterizedType.getActualTypeArguments()[0];
		eClass = (Class<E>) parameterizedType.getActualTypeArguments()[1];
	}
	
	@Override
	public D convertToDTO(E entity) {
		ModelMapper mapper = new ModelMapper();
		
		return (D) mapper.map(entity, this.dClass);
	}

	@Override
	public E convertToEntity(D dto) {
		ModelMapper mapper = new ModelMapper();
		
		return (E) mapper.map(dto, this.eClass);
	}

}
