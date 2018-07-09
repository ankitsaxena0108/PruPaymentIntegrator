package com.prud.zm.pi.mapper;

import org.springframework.stereotype.Component;

import com.prud.zm.pi.model.ILData;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * @param <S>
 * 
 */
@Component
public class OrikaConverter implements Converter {

	private final MapperFacade mapper;

	public OrikaConverter() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		mapperFactory.classMap(ILData.class, ILDataEntity.class)
		.byDefault().register();
		mapper = mapperFactory.getMapperFacade();
	}

	@Override
	public ILDataEntity map(ILData source) {
		// TODO Auto-generated method stub
		return mapper.map(source, ILDataEntity.class);
	}

}
