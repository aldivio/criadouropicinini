package br.com.criadouropicinini.domain.services;

import br.com.criadouropicinini.domain.exceptions.BusinessException;
import br.com.criadouropicinini.domain.exceptions.EntityInUseException;
import br.com.criadouropicinini.domain.exceptions.FederacaoNotFoundException;
import br.com.criadouropicinini.domain.models.Federacao;
import br.com.criadouropicinini.domain.repositories.FederacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FederacaoService {

    public static final String FEDERACAO_EM_USO
            = "Federação com o código %d não pode ser removida, pois esta em uso";

    @Autowired
    private FederacaoRepository federacaoRepository;


    @Transactional
    public Federacao save(Federacao federacao) {

        Optional<Federacao> federacaoExistente = federacaoRepository.findByCodigo(federacao.getCodigo());
        if (federacaoExistente.isPresent() && !federacaoExistente.get().equals(federacao)) {
            throw new BusinessException(
                    String.format("A federação " + federacao.getCodigo() + " já esta cadastrada em nosso sistema."));
        }

        return federacaoRepository.save(federacao);
    }

    public Federacao consultaById(long federacaoId) {
        return federacaoRepository.findById(federacaoId)
                .orElseThrow(() -> new FederacaoNotFoundException(federacaoId));
    }

    @Transactional
    public void remove(Long federacaoId) {

        try {
            federacaoRepository.deleteById(federacaoId);
            federacaoRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new FederacaoNotFoundException(federacaoId);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(FEDERACAO_EM_USO, federacaoId));
        }
    }

}
