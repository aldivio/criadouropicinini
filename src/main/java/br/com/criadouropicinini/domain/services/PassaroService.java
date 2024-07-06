package br.com.criadouropicinini.domain.services;

import br.com.criadouropicinini.domain.exceptions.BusinessException;
import br.com.criadouropicinini.domain.exceptions.ClienteNotFoundException;
import br.com.criadouropicinini.domain.exceptions.PassaroNotFoundException;
import br.com.criadouropicinini.domain.models.*;
import br.com.criadouropicinini.domain.repositories.ClienteRepository;
import br.com.criadouropicinini.domain.repositories.PassaroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PassaroService {

    @Autowired
    private PassaroRepository passaroRepository;

    @Autowired
    private EspecieService especieService;
    @Autowired
    private ClubeService clubeService;
    @Autowired
    private CriadorService criadorService;
    @Autowired
    private FederacaoService federacaoService;
    @Autowired
    private ClienteService clienteService;



    @Transactional
    public Passaro save(Passaro passaro) {
        buscaId(passaro);
        geradorAnilha(passaro);
        Optional<Passaro> passaroExistente = passaroRepository.findByAnilha(passaro.getAnilha());
        if (passaroExistente.isPresent() && !passaroExistente.get().equals(passaro)) {
            throw new BusinessException(
                    String.format("Passaro com esta anilha de registro "
                            + passaro.getAnilha() + " já esta cadastrado em nosso sistema. "));
        }
        return passaroRepository.save(passaro);
    }


    public Passaro consultaById(long passaroId) {
        return passaroRepository.findById(passaroId)
                .orElseThrow(() -> new PassaroNotFoundException(passaroId));
    }

    @Transactional
    public void remove(Long passaroId) {

        try {
            passaroRepository.deleteById(passaroId);
            passaroRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new PassaroNotFoundException(passaroId);
        }
    }

    private void buscaId(Passaro passaro) {
        Long especieId = passaro.getEspecie().getId();
        Long clubeId =  passaro.getClube().getId();
        Long federacaoId = passaro.getFederacao().getId();
        Long criadorId = passaro.getCriador().getId();
        Long clienteId = passaro.getCliente().getId();

        Especie especie = especieService.consultaById(especieId);
        Clube clube = clubeService.consultaById(clubeId);
        Federacao federacao = federacaoService.consultaById(federacaoId);
        Criador criador = criadorService.consultaById(criadorId);
        Cliente cliente = clienteService.consultaById(clienteId);


        passaro.setEspecie(especie);
        passaro.setClube(clube);
        passaro.setFederacao(federacao);
        passaro.setCriador(criador);
        passaro.setCliente(cliente);
    }

    public void geradorAnilha(Passaro passaro){

       passaro.setAnilha(passaro.getEspecie().getNome() + " " + passaro.getAno() + " " + passaro.getNumeroAnel()
               + " " + passaro.getTamanhoAnel() + " " + passaro.getFederacao().getCodigo()
               + " " + passaro.getClube().getCodigo()
               + " " + passaro.getCriador().getCodigo()
        );
    }

}
