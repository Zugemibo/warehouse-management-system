package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawidp.warehousemanagementsystem.model.Supply;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Integer>{

	Supply findSupplyBySupplyId(int supplyId);

}
