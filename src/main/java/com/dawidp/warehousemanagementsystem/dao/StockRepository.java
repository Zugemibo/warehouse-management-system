package com.dawidp.warehousemanagementsystem.dao;

import com.dawidp.warehousemanagementsystem.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT s from Stock s where s.space.spaceBarcode like :space and s.product.productBarcode like :product")
    Stock getStockBySpaceBarcodeAndProductBarcode(@Param("space") String space, @Param("product") String product);

    @Modifying
    @Query("delete from Stock s where s.stockId=:id")
    void deleteStockById(@Param("id") Long id);

    @Query("Select s from Stock s where s.product.productBarcode like :product")
    List<Stock> getProductStocks(@Param("product") String productBarcode);

    @Query("Select s from Stock s where s.space.spaceBarcode like :space")
    List<Stock> getSpaceStocks(@Param("space") String spaceBarcode);
}
