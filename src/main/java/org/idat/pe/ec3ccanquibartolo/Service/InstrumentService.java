package org.idat.pe.ec3ccanquibartolo.Service;

import org.idat.pe.ec3ccanquibartolo.Exception.ResourceNotFoundException;
import org.idat.pe.ec3ccanquibartolo.Model.Instrument;
import org.idat.pe.ec3ccanquibartolo.Repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public List<Instrument> getAllInstruments(){
        return instrumentRepository.findAll();
    }

    public Instrument getIntrumentById(Long id){
        return  instrumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instruments no se encuentra con elid:" +id));
    }

    public Instrument createInstrument(Instrument instrument){
        return instrumentRepository.save(instrument);
    }
}
