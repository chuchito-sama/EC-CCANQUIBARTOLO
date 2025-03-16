package org.idat.pe.ec3ccanquibartolo.Service;

import org.idat.pe.ec3ccanquibartolo.Exception.ResourceNotFoundException;
import org.idat.pe.ec3ccanquibartolo.Model.Marca;
import org.idat.pe.ec3ccanquibartolo.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {


    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> getAllBrands() {
        return marcaRepository.findAll();  //
    }

    public Marca getBrandById(Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand no se encuentra conel id: " + id));
    }


    public Marca createBrand(Marca marca) {
        return marcaRepository.save(marca);  // Usamos la instancia de marcaRepository inyectada
    }

}
