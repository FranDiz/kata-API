package com.example.src.Repo;
import com.example.src.Modelos.Cerveza;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CervezaRepo extends JpaRepository<Cerveza, Long> {
    List<Cerveza> findAllById(Long id);
}
