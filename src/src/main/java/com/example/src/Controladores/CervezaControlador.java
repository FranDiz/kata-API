package com.example.src.Controladores;

import com.example.src.Modelos.Cerveza;
import com.example.src.Repo.CervezaRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class CervezaControlador {

    private final CervezaRepo cervezaRepo;

    public CervezaControlador(CervezaRepo cervezaRepo) {
        this.cervezaRepo = cervezaRepo;
    }

    @GetMapping("/beers")
    public List<Cerveza> obtenerCervezas() {
        return cervezaRepo.findAll();
    }
    @GetMapping("/beer/{id}")
    public ResponseEntity<Cerveza> obtenercCervezaPorId(@PathVariable Long id) {
        Optional<Cerveza> Cerveza = cervezaRepo.findById(id);

        if (Cerveza.isPresent()) {
            return ResponseEntity.ok(Cerveza.get());
        } else {
            throw new RecursoNoEncontradoException("Beer no encontrada con el id:" + id);
        }
    }
    @PostMapping("/beer")
    public Cerveza anadirCerveza(@RequestBody Cerveza cerveza) {
        return cervezaRepo.save(cerveza);
    }
    @PutMapping("/beer/{id}")
    public Cerveza actualizarCerveza(@PathVariable Long id, @RequestBody Cerveza cervezaActualizada) {
        cervezaActualizada.setId(id);
        return cervezaRepo.save(cervezaActualizada);
    }

    public static class RecursoNoEncontradoException extends RuntimeException {
        public RecursoNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

    @DeleteMapping("/beer/{id}")
    public void eliminarCerveza(@PathVariable Long id) {
        cervezaRepo.deleteById(id);
    }



    @PatchMapping("/beer/{id}")
    public Cerveza partialUpdateBeer(@PathVariable Long id, @RequestBody Cerveza partialBeer) {
        Optional<Cerveza> optionalBeer = cervezaRepo.findById(id);
        if (optionalBeer.isPresent()) {
            Cerveza existingBeer = optionalBeer.get();
            if (partialBeer.getName() != null) {
                existingBeer.setName(partialBeer.getName());
            }
            if (partialBeer.getDescript() != null) {
                existingBeer.setDescript(partialBeer.getDescript());
            }
            return cervezaRepo.save(existingBeer);
        }

        return null;
    }
}