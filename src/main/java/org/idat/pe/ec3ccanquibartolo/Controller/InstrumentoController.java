package org.idat.pe.ec3ccanquibartolo.Controller;


import org.idat.pe.ec3ccanquibartolo.Model.Instrument;
import org.idat.pe.ec3ccanquibartolo.Service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentoController {

    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentoController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping
    public List<Instrument> getAllInstruments(){
        return instrumentService.getAllInstruments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrument> getInstrumentById(@PathVariable Long id){
        Instrument instrument = instrumentService.getIntrumentById(id);
        return ResponseEntity.ok(instrument);
    }

    @PostMapping
    public ResponseEntity<Instrument> createInstrument(@RequestBody Instrument instrument){
        Instrument newInstrument = instrumentService.createInstrument(instrument);
        return ResponseEntity.ok(newInstrument);
    }
}