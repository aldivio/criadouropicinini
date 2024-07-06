package br.com.criadouropicinini.domain.services;

import br.com.criadouropicinini.domain.exceptions.BusinessException;
import br.com.criadouropicinini.domain.exceptions.CriadorNotFoundException;
import br.com.criadouropicinini.domain.exceptions.EntityInUseException;
import br.com.criadouropicinini.domain.models.Criador;
import br.com.criadouropicinini.domain.repositories.CriadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CriadorService {

    public static final String CRIADOR_EM_USO
            = "Criador com o código %d não pode ser removido, pois está em uso";

    @Autowired
    private CriadorRepository criadorRepository;


    @Transactional
    public Criador save(Criador criador) {

        Optional<Criador> criadorExistente = criadorRepository.findByCodigo(criador.getCodigo());
        if (criadorExistente.isPresent() && !criadorExistente.get().equals(criador)) {
            throw new BusinessException(
                    String.format("O criador com o código" + criador.getCodigo() + "" +
                            " já está cadastrado em nosso sistema."));
        }
        return criadorRepository.save(criador);
    }

    public Criador consultaById(long criadorId) {
        return criadorRepository.findById(criadorId)
                .orElseThrow(() -> new CriadorNotFoundException(criadorId));
    }

    @Transactional
    public void remove(Long criadorId) {

        try {
            criadorRepository.deleteById(criadorId);
            criadorRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new CriadorNotFoundException(criadorId);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(CRIADOR_EM_USO, criadorId));
        }
    }


}
