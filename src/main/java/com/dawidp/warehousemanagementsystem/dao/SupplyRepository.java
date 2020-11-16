package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawidp.warehousemanagementsystem.model.Supply;

import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long>{

	Supply findSupplyBySupplyId(Long supplyId);

	Supply findSupplyBySupplyNumber(String supplyNumber);

	List<Supply> findSupplyBySupplierCompanyName(String companyName);
}
