package br.com.criadouropicinini.domain.services;

import br.com.criadouropicinini.domain.exceptions.EntityInUseException;
import br.com.criadouropicinini.domain.exceptions.EspecieNotFoundException;
import br.com.criadouropicinini.domain.models.Especie;
import br.com.criadouropicinini.domain.repositories.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EspecieService {

    public static final String ESPECIE_EM_USE
            = "Espécie com o código %d não pode ser removida, pois esta em uso";
    @Autowired
    private EspecieRepository especieRepository;


    @Transactional
    public Especie save(Especie especie){
       return especieRepository.save(especie);
    }

    public Especie consultaById(long especieId){
        return especieRepository.findById(especieId)
                .orElseThrow(() -> new EspecieNotFoundException(especieId));
    }

    @Transactional
    public void remove(Long especieId) {

        try {
            especieRepository.deleteById(especieId);
            especieRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new EspecieNotFoundException(especieId);
        } catch (DataIntegrityViolationException e) {
             throw new EntityInUseException(String.format(ESPECIE_EM_USE, especieId));
        }
    }
}
