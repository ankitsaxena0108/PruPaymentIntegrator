package com.prud.zm.pi.mapper;

import com.prud.zm.pi.model.ILData;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

public interface Converter {
	ILDataEntity map(ILData source);
}
