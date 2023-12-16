package com.example.src.Controladores;
import com.example.src.Modelos.Categorias;

import com.example.src.Repo.CategoriasRepo;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class CategoriasControlador {

    private final CategoriasRepo categoriasRepo;

    public CategoriasControlador(CategoriasRepo categoriasRepo) {
        this.categoriasRepo = categoriasRepo;
    }

    @GetMapping("/categories")
    public List<Categorias> getAllCategories() {
        return categoriasRepo.findAll();
    }

    @GetMapping("/categorie/{id}")
    public Optional<Categorias> getCategoryById(@PathVariable Long id) {
        return categoriasRepo.findById(id);
    }
}
