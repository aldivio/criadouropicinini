package br.com.criadouropicinini.api.controlles;


import br.com.criadouropicinini.api.assembler.FederacaoInputDisassembler;
import br.com.criadouropicinini.api.assembler.FederacaoModelAssembler;
import br.com.criadouropicinini.api.dtos.input.FederacaoInput;
import br.com.criadouropicinini.api.dtos.model.FederacaoModel;
import br.com.criadouropicinini.domain.models.Federacao;
import br.com.criadouropicinini.domain.repositories.FederacaoRepository;
import br.com.criadouropicinini.domain.services.FederacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("federacoes")
public class FederacaoController {

    @Autowired
    private FederacaoService federacaoService;

    @Autowired
    private FederacaoRepository federacaoRepository;

    @Autowired
    private FederacaoModelAssembler federacaoModelAssembler;

    @Autowired
    private FederacaoInputDisassembler federacaoInputDisassembler;


    @GetMapping("/{federacaoId}")
    public Federacao buscaById(@PathVariable Long federacaoId) {
        return federacaoService.consultaById(federacaoId);
    }

    @GetMapping
    public List<Federacao> list() {
        List<Federacao> federacaoTotal = federacaoRepository.findAll();
        return federacaoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FederacaoModel save(@RequestBody @Valid FederacaoInput federacaoInput) {
        Federacao federacao = federacaoInputDisassembler.toDomainObject(federacaoInput);
        return federacaoModelAssembler.toModel(federacaoService.save(federacao));

    }

    @PutMapping("/{federacaoId}")
    public FederacaoModel update(@PathVariable Long federacaoId,
                                 @RequestBody @Valid FederacaoInput federacaoInput) {
        Federacao federacaoCurrent = federacaoService.consultaById(federacaoId);
        federacaoInputDisassembler.copyToDomainObjtect(federacaoInput, federacaoCurrent);
        federacaoCurrent = federacaoService.save(federacaoCurrent);
        return federacaoModelAssembler.toModel(federacaoCurrent);
    }

    @DeleteMapping("/{federacaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long federacaoId) {
        federacaoService.remove(federacaoId);
    }


}
