package com.magnumbank.api1.controller;

import com.magnumbank.api1.service.CargaInicialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carga-inicial")
public class CargaInicialController {

    private final CargaInicialService cargaInicialService;

    public CargaInicialController(CargaInicialService cargaInicialService) {
        this.cargaInicialService = cargaInicialService;
    }

    @PostMapping
    public ResponseEntity<String> executarCargaInicial() {
        cargaInicialService.executarCargaInicial();
        return ResponseEntity.accepted().build();
    }
}
