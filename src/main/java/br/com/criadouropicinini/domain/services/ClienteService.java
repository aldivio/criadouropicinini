package br.com.criadouropicinini.domain.services;

import br.com.criadouropicinini.domain.exceptions.BusinessException;
import br.com.criadouropicinini.domain.exceptions.ClienteNotFoundException;
import br.com.criadouropicinini.domain.models.Cliente;
import br.com.criadouropicinini.domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente) {

        Optional<Cliente> clienteExistente = clienteRepository.findByCpfCnpj(cliente.getCpfCnpj());
        if (clienteExistente.isPresent() && !clienteExistente.get().equals(cliente)) {
            throw new BusinessException(
                    String.format("Cliente com esse " + cliente.getCpfCnpj() + " já esta cadastrado em nosso sistema. "));
        }

        return clienteRepository.save(cliente);
    }

    public Cliente consultaById(long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClienteNotFoundException(clienteId));
    }

    @Transactional
    public void remove(Long clienteId) {

        try {
            clienteRepository.deleteById(clienteId);
            clienteRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new ClienteNotFoundException(clienteId);
        }
    }
}
