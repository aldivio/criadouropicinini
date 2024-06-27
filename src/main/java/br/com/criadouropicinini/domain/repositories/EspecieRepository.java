package br.com.criadouropicinini.domain.repositories;

import br.com.criadouropicinini.domain.models.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {
}

