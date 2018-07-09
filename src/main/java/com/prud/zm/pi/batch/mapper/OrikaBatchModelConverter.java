package com.prud.zm.pi.batch.mapper;

import org.springframework.stereotype.Component;

import com.prud.zm.pi.model.CitiBankDomainModel;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * @param <S>
 * 
 */
@Component
public class OrikaBatchModelConverter implements BatchModelConverter {

	private final MapperFacade mapper;

	public OrikaBatchModelConverter() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        
		mapperFactory.classMap(ILDataEntity.class, CitiBankDomainModel.class)
		.field("agntCOY", "recAcctNO")
		.field("payrCOY", "recAcctCode")
		.byDefault().register();
		
		mapper = mapperFactory.getMapperFacade();
	}

	@Override
	public CitiBankDomainModel map(ILDataEntity source) {
		// TODO Auto-generated method stub
		return mapper.map(source, CitiBankDomainModel.class);
	}

}
