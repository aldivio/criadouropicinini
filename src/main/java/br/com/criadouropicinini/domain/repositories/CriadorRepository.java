package br.com.criadouropicinini.domain.repositories;

import br.com.criadouropicinini.domain.models.Clube;
import br.com.criadouropicinini.domain.models.Criador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CriadorRepository extends JpaRepository<Criador, Long> {

    Optional<Criador> findByCodigo(String codigo);

}
