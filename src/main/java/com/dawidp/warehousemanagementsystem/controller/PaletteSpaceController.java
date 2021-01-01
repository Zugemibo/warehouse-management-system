package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.PaletteSpace;
import com.dawidp.warehousemanagementsystem.model.Stock;
import com.dawidp.warehousemanagementsystem.service.PaletteSpaceService;
import com.dawidp.warehousemanagementsystem.service.StockService;
import com.dawidp.warehousemanagementsystem.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/paletteSpace")
public class PaletteSpaceController {

    @Autowired
    private PaletteSpaceService spaceService;
    @Autowired
    private StockService stockService;

//	@PostMapping("/single/{name}")
//	public PaletteSpace createSingleSpace(@PathVariable String name){
//		PaletteSpace paletteSpace = new PaletteSpace(0l,null, name);
//		return spaceService.saveSingle(paletteSpace);
//	}

    @PostMapping("/create")
    public List<PaletteSpace> createSpace(@RequestBody Map<String, Object> map) {
        int alley = (int) map.get("alley");
        int rack = (int) map.get("rack");
        int height = (int) map.get("height");

        String code = null;
        for (int a = 1; a < alley + 1; a++) {
            for (int r = 1; r < rack + 1; r++) {
                for (int h = 1; h < (height * 3) + 1; h++) {
                    code = (String.format("%03d", a) + "-" + String.format("%03d", r) + "-" + String.format("%03d", h));
                    PaletteSpace paletteSpace = new PaletteSpace();
                    paletteSpace.setAlley(a);
                    paletteSpace.setRack(r);
                    paletteSpace.setPlace(h);
                    paletteSpace.setSpaceBarcode(code);
                    spaceService.save(paletteSpace);
                }
            }
        }
        return spaceService.findAll();
    }

    @JsonView(Views.Stock.class)
    @GetMapping("/getPaletteSpaceByBarcode/{barcode}")
    public PaletteSpace getPaletteSpaceByBarcode(@PathVariable String barcode) {
        return spaceService.getPaletteSpaceByBarcode(barcode);
    }

    @GetMapping("/getPaletteSpaces")
    public List<PaletteSpace> getPaletteSpaces() {
        return spaceService.findAll();
    }

    @JsonView(Views.Stock.class)
    @GetMapping("/{spaceBarcode}/getStocks")
    public List<Stock> getSpaceStocks(@PathVariable String spaceBarcode) {
        return stockService.getSpaceStocks(spaceBarcode);
    }
}
