package com.prud.zm.pi.batch.mapper;

import com.prud.zm.pi.model.CitiBankDomainModel;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

public interface BatchModelConverter {
	CitiBankDomainModel map(ILDataEntity source);
	//T map(S source);
}
