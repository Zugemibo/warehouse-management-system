package com.dawidp.warehousemanagementsystem.model;

import com.dawidp.warehousemanagementsystem.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class PaletteSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paletteSpaceId;
    @JsonView(Views.Normal.class)
    @OneToMany(mappedBy = "space")
    private Set<StorageLocationProductMapper> storages;
    @NotNull
    @Column(name = "barcode")
    @NaturalId
    private String barcode;

}
