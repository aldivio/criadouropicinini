package br.com.criadouropicinini.api.controlles;


import br.com.criadouropicinini.api.assembler.CriadorInputDisassembler;
import br.com.criadouropicinini.api.assembler.CriadorModelAssembler;
import br.com.criadouropicinini.api.dtos.input.CriadorInput;
import br.com.criadouropicinini.api.dtos.model.CriadorModel;
import br.com.criadouropicinini.domain.models.Criador;
import br.com.criadouropicinini.domain.repositories.CriadorRepository;
import br.com.criadouropicinini.domain.services.CriadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criadores")
public class CriadorController {

    @Autowired
    private CriadorService criadorService;

    @Autowired
    private CriadorRepository criadorRepository;

    @Autowired
    private CriadorModelAssembler criadorModelAssembler;
    @Autowired
    private CriadorInputDisassembler criadorInputDisassembler;


    @GetMapping("/{criadorId}")
    public Criador buscaById(@PathVariable Long criadorId) {
        return criadorService.consultaById(criadorId);
    }

    @GetMapping
    public List<Criador> list() {
        List<Criador> criadorTotal = criadorRepository.findAll();
        return criadorRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CriadorModel save(@RequestBody @Valid CriadorInput criadorInput) {

        Criador criador = criadorInputDisassembler.toDomainObject(criadorInput);

        return criadorModelAssembler.toModel(criadorService.save(criador));

    }

    @PutMapping("/{criadorId}")
    public CriadorModel update(@PathVariable Long criadorId,
                               @RequestBody @Valid CriadorInput criadorInput) {
        Criador criadorCurrent = criadorService.consultaById(criadorId);
        criadorInputDisassembler.copyToDomainObjtect(criadorInput, criadorCurrent);
        criadorCurrent = criadorService.save(criadorCurrent);
        return criadorModelAssembler.toModel(criadorCurrent);
    }

    @DeleteMapping("/{criadorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long criadorId) {
        criadorService.remove(criadorId);
    }
}
