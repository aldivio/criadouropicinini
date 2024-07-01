package br.com.criadouropicinini.domain.repositories;

import br.com.criadouropicinini.domain.models.Federacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FederacaoRepository extends JpaRepository<Federacao, Long> {

    Optional<Federacao> findByCodigo(String codigo);

}
