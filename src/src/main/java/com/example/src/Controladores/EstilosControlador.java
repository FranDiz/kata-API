package com.example.src.Controladores;
import com.example.src.Modelos.Estilos;
import com.example.src.Repo.EstilosRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class EstilosControlador {

    private final EstilosRepo estilosRepo;

    public EstilosControlador(EstilosRepo estilosRepo) {
        this.estilosRepo = estilosRepo;
    }
    @GetMapping("/style/{id}")
    public Optional<Estilos> getStyleById(@PathVariable Long id) {
        return estilosRepo.findById(id);
    }
    @GetMapping("/styles")
    public List<Estilos> getAllStyles() {
        return estilosRepo.findAll();
    }


}
