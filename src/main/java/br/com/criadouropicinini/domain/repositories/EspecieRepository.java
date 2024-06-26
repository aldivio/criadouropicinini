package br.com.criadouropicinini.domain.repositories;

import br.com.criadouropicinini.domain.models.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {

    Optional<Especie> findByNome(String nome);
}

