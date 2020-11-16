package com.dawidp.warehousemanagementsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.dawidp.warehousemanagementsystem.util.Views;
import com.fasterxml.jackson.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class PaletteSpace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paletteSpaceId;
    @JsonView(Views.ProductDetailedView.class)
    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Stock> stocks = new HashSet<>();
    @NotNull
    @Column(name="space_barcode")
    @NaturalId
    private String spaceBarcode;

    public void addStock(Stock stock){
        this.stocks.add(stock);
        stock.setSpace(this);
    }
}
