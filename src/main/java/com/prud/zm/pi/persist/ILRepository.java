package com.prud.zm.pi.persist;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prud.zm.pi.persistence.entity.ILDataEntity;

@Repository
public interface ILRepository extends CrudRepository<ILDataEntity, Long> {
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query("update ILDataEntity p set p.payFlag = :payFlag , p.recordStatus = 'COMPLETED' where p.payrNUM = :payrNUM")
	void updateBankResponseStatus(@Param("payFlag") String payFlag, @Param("payrNUM") String payrNUM);
}
