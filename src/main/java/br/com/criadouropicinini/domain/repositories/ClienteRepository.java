package br.com.criadouropicinini.domain.repositories;

import br.com.criadouropicinini.domain.models.Cliente;
import br.com.criadouropicinini.domain.models.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    Optional<Cliente> findByCpfCnpj(String cpfCnpj);

}
