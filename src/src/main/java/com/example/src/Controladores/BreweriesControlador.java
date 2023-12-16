package com.example.src.Controladores;


import com.example.src.Modelos.Breweries;
import com.example.src.Repo.BreweriesRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

@RequestMapping("/api")
public class BreweriesControlador {

    private final BreweriesRepo breweriesRepo;

    public BreweriesControlador(BreweriesRepo breweriesRepo) {
        this.breweriesRepo = breweriesRepo;
    }

    @GetMapping("/breweries")
    public List<Breweries> getAllBreweries() {
        return breweriesRepo.findAll();
    }

    @GetMapping("/breweries/{id}")
    public ResponseEntity<Breweries> getBreweryById(@PathVariable Long id) {
        Optional<Breweries> brewery = breweriesRepo.findById(id);

        if (brewery.isPresent()) {
            return ResponseEntity.ok(brewery.get());
        } else {
            throw new RecursoNoEncontradoException("No se encontró la brewery de id" + id);
        }
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class RecursoNoEncontradoException extends RuntimeException {
        public RecursoNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }
}

