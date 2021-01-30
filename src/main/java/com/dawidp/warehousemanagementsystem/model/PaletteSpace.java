package com.dawidp.warehousemanagementsystem.model;

import com.dawidp.warehousemanagementsystem.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
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
    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Stock> stocks = new HashSet<>();
    private int alley;
    private int rack;
    private int place;
    @Column(name = "space_barcode")
    @NaturalId
    @JsonView(Views.Stock.class)
    private String spaceBarcode;

    public void addStock(Stock stock) {
        this.stocks.add(stock);
        stock.setSpace(this);
    }
}
