package br.com.criadouropicinini.domain.services;

import br.com.criadouropicinini.domain.exceptions.BusinessException;
import br.com.criadouropicinini.domain.exceptions.ClubeNotFoundException;
import br.com.criadouropicinini.domain.exceptions.EntityInUseException;
import br.com.criadouropicinini.domain.models.Clube;
import br.com.criadouropicinini.domain.repositories.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClubeService {

    public static final String CLUBE_EM_USO
            = "Clube com o código %d não pode ser removido, pois está em uso";

    @Autowired
    private ClubeRepository clubeRepository;


    @Transactional
    public Clube save(Clube clube) {

        Optional<Clube> clubeExistente = clubeRepository.findByCodigo(clube.getCodigo());
        if (clubeExistente.isPresent() && !clubeExistente.get().equals(clube)) {
            throw new BusinessException(
                    String.format("A clube " + clube.getCodigo() + " já esta cadastrado em nosso sistema."));
        }

        return clubeRepository.save(clube);
    }

    public Clube consultaById(long clubeId) {
        return clubeRepository.findById(clubeId)
                .orElseThrow(() -> new ClubeNotFoundException(clubeId));
    }

    @Transactional
    public void remove(Long clubeId) {

        try {
            clubeRepository.deleteById(clubeId);
            clubeRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new ClubeNotFoundException(clubeId);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(CLUBE_EM_USO, clubeId));
        }
    }

}
