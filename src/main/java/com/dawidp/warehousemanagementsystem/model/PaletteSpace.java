package com.dawidp.warehousemanagementsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.dawidp.warehousemanagementsystem.util.Views;
import com.fasterxml.jackson.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class PaletteSpace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paletteSpaceId;
    @JsonView(Views.Normal.class)
    @OneToMany(mappedBy = "paletteSpace")
    private List<StorageLocationProductMapper> storages;
    @NotNull
    @Column(name="barcode")
    @NaturalId
    private String barcode;

    public void addStorage(StorageLocationProductMapper storage){
        storages.add(storage);
        storage.setPaletteSpace(this);
    }

    public void removeStorage(StorageLocationProductMapper storage){
        storages.remove(storage);
        storage.setPaletteSpace(null);
    }

}
