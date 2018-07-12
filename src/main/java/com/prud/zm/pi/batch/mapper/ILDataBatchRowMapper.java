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
		ilDataEntity.setPayrNUM(rs.getString("PAYRNUM"));
		ilDataEntity.setInstAmt01(rs.getString("INSTAMT01"));
		ilDataEntity.setByDate(rs.getString("BTDATE"));
		ilDataEntity.setBankAccKey(rs.getString("BANKACCKEY"));
		ilDataEntity.setCntCurr(rs.getString("CNTCURR"));
		ilDataEntity.setUserProfile(rs.getString("USER_PROFILE"));
		ilDataEntity.setAgntCOY(rs.getString("AGNTCOY"));
		ilDataEntity.setBankKey(rs.getString("BANKKEY"));
		return ilDataEntity;
	}

}
