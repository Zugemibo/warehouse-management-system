package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawidp.warehousemanagementsystem.domain.NewSupply;

@Repository
public interface SupplyRepository extends JpaRepository<NewSupply, Integer>{

	NewSupply findNewSupplyBySupplyId(int supplyId);

}
