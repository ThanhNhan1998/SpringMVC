package com.laptrinhjavaweb.converter;

public interface IConverter<D, E> {
	D convertToDTO(E entity);
	E convertToEntity(D dto);
}
