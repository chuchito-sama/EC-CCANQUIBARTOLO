package org.idat.pe.ec3ccanquibartolo.Controller;

import org.idat.pe.ec3ccanquibartolo.Model.Marca;
import org.idat.pe.ec3ccanquibartolo.Service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<Marca> getAllBrands(){
        return marcaService.getAllBrands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getBrandById(@PathVariable Long id) {
        Marca marca = marcaService.getBrandById(id);
        return ResponseEntity.ok(marca);
    }
    @PostMapping
    public ResponseEntity<Marca> createBrand(@RequestBody Marca marca) {
        Marca newMarca = marcaService.createBrand(marca);
        return ResponseEntity.ok(newMarca);
    }
}
