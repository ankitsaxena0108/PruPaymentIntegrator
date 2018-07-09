package com.prud.zm.pi.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.prud.zm.pi.batch.model.ILDataBatchEntity;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

public class ILDataBatchRowMapper implements RowMapper<ILDataEntity> {

	@Override
	public ILDataEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		ILDataEntity ilDataEntity = new ILDataEntity();
		ilDataEntity.setAgntCOY(rs.getString("AGNTCOY"));
		ilDataEntity.setPayrCOY(rs.getString("PAYRCOY"));
		ilDataEntity.setPayrNUM(rs.getString("PAYRNUM"));
		return ilDataEntity;
	}

}
