package com.prud.zm.pi.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.prud.zm.pi.batch.model.ILDataBatchEntity;

public class ILDataBatchRowMapper implements RowMapper<ILDataBatchEntity> {

	@Override
	public ILDataBatchEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		ILDataBatchEntity ilDataEntity = new ILDataBatchEntity();
		ilDataEntity.setBankId(rs.getString("bankId"));
		ilDataEntity.setBankAccountDesc(rs.getString("bank_acnt_desc"));
		ilDataEntity.setNoBatchNumber(rs.getString("nobatchnum"));
		ilDataEntity.setNoRecbatchNumber(rs.getString("norecbatchnum"));
		ilDataEntity.setPaymentDetailsId(rs.getLong("pd_id"));
		ilDataEntity.setPrudAccountRef(rs.getString("prud_acnt_ref"));
		ilDataEntity.setRecordType(rs.getString("recordtype"));
		ilDataEntity.setSequenceFrom(rs.getLong("sequencefrom"));
		ilDataEntity.setSign(rs.getString("sign"));
		ilDataEntity.setSubMissionDate(rs.getString("submissiondate"));
		ilDataEntity.setTotalAmount(rs.getString("totalamnt"));
		ilDataEntity.setValueDate(rs.getString("valuedate"));
		ilDataEntity.setPaymentStatus(rs.getString("paymentstatus"));
		return ilDataEntity;
	}

}
