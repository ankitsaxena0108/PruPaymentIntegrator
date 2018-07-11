package com.prud.zm.pi.persist;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prud.zm.pi.persistence.entity.ILDataEntity;

@Repository
public interface ILRepository extends CrudRepository<ILDataEntity, Long> {
	@Modifying
	@Query("update ILDataEntity p set p.payFlag = :payFlag where p.payrNUM = :payrNum")
	void updateBankResponseStatus(@Param("payFlag") String payFlag, @Param("payrNum") String payrNum);
}
