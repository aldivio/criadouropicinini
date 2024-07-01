package br.com.criadouropicinini.api.controlles;


import br.com.criadouropicinini.api.assembler.ClubeInputDisassembler;
import br.com.criadouropicinini.api.assembler.ClubeModelAssembler;
import br.com.criadouropicinini.api.dtos.input.ClubeInput;
import br.com.criadouropicinini.api.dtos.model.ClubeModel;
import br.com.criadouropicinini.domain.models.Clube;
import br.com.criadouropicinini.domain.repositories.ClubeRepository;
import br.com.criadouropicinini.domain.services.ClubeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clubes")
public class ClubeController {

    @Autowired
    private ClubeService clubeService;

    @Autowired
    private ClubeRepository clubeRepository;

    @Autowired
    private ClubeModelAssembler clubeModelAssembler;

    @Autowired
    private ClubeInputDisassembler clubeInputDisassembler;


    @GetMapping("/{clubeId}")
    public Clube buscaById(@PathVariable Long clubeId) {
        return clubeService.consultaById(clubeId);
    }

    @GetMapping
    public List<Clube> list() {
        List<Clube> clubeTotal = clubeRepository.findAll();
        return clubeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClubeModel save(@RequestBody @Valid ClubeInput clubeInput) {
        Clube clube = clubeInputDisassembler.toDomainObject(clubeInput);
        return clubeModelAssembler.toModel(clubeService.save(clube));
    }

    @PutMapping("/{clubeId}")
    public ClubeModel update(@PathVariable Long clubeId,
                             @RequestBody @Valid ClubeInput clubeInput) {
        Clube clubeCurrent = clubeService.consultaById(clubeId);
        clubeInputDisassembler.copyToDomainObjtect(clubeInput, clubeCurrent);
        clubeCurrent = clubeService.save(clubeCurrent);
        return clubeModelAssembler.toModel(clubeCurrent);
    }

    @DeleteMapping("/{clubeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long clubeId) {
        clubeService.remove(clubeId);
    }


}
