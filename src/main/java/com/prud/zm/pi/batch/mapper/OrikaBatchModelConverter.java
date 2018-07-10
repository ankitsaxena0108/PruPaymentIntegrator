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
	/*private S s;
	private T t;*/

	public OrikaBatchModelConverter() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(ILDataEntity.class,CitiBankDomainModel.class)
		.field("payrNUM", "customerReference")
		.field("instAmt01", "amount")
		.field("byDate", "bookingDate")
		.field("bankAccKey", "creditAccount")
		.field("cntCurr", "isoCurrency")
		/*.field("agntCOY", "paymentDetails1")
		.field("agntCOY", "paymentDetails2")
		.field("agntCOY", "paymentDetails3")*/
		.field("bankAccKey", "payerAccountNumber")
		.field("userProfile", "payerAccountName")
		/*.field("agntCOY", "payerAddress1")
		.field("agntCOY", "payerAddress2")*/
		.field("agntCOY", "payerBankCode")
		//.field("agntCOY", "bankName")
		//.field("agntCOY", "paymentDetails4")
		//.field("agntCOY", "payerAddress3")
		.byDefault().register();
		mapper = mapperFactory.getMapperFacade();
	}

	@Override
	public CitiBankDomainModel map(ILDataEntity source) {
		// TODO Auto-generated method stub
		return mapper.map(source, CitiBankDomainModel.class);
	}

	/*@Override
	public T map(S source) {
		// TODO Auto-generated method stub
		return (T) mapper.map(source, ((Object)t).getClass());
	}*/

}
