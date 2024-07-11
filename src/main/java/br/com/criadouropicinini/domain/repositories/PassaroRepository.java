package br.com.criadouropicinini.domain.repositories;

import br.com.criadouropicinini.domain.models.Cliente;
import br.com.criadouropicinini.domain.models.Passaro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassaroRepository extends JpaRepository<Passaro, Long> {


    Optional<Passaro> findByAnilha(String anilha);
}
