package com.prud.zm.pi.persist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prud.zm.pi.persistence.entity.ILDataEntity;

@Repository
public interface ILRepository extends CrudRepository<ILDataEntity, Long>{

}
