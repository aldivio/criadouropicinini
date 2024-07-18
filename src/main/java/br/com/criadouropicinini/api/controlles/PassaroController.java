package br.com.criadouropicinini.api.controlles;


import br.com.criadouropicinini.api.assembler.PassaroInputDisassembler;
import br.com.criadouropicinini.api.assembler.PassaroModelAssembler;
import br.com.criadouropicinini.api.assembler.PassaroResumidoInputDisassembler;
import br.com.criadouropicinini.api.assembler.PassaroResumoModelAssembler;
import br.com.criadouropicinini.api.dtos.input.PassaroInput;
import br.com.criadouropicinini.api.dtos.input.PassaroResumidoInput;
import br.com.criadouropicinini.api.dtos.model.PassaroModel;
import br.com.criadouropicinini.api.dtos.model.PassaroResumoModel;
import br.com.criadouropicinini.domain.models.Passaro;
import br.com.criadouropicinini.domain.repositories.PassaroRepository;
import br.com.criadouropicinini.domain.services.PassaroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("passaros")
public class PassaroController {


    @Autowired
    private PassaroService passaroService;

    @Autowired
    private PassaroRepository passaroRepository;


    @Autowired
    private PassaroInputDisassembler passaroInputDisassembler;

    @Autowired
    private PassaroModelAssembler passaroModelAssembler;

    @Autowired
    private PassaroResumidoInputDisassembler passaroResumidoInputDisassembler;

    @Autowired
    private PassaroResumoModelAssembler passaroResumoModelAssembler;


    @GetMapping("/{passaroId}")
    public Passaro buscaById(@PathVariable Long passaroId) {
        return passaroService.consultaById(passaroId);
    }

    @GetMapping
    public List<PassaroResumoModel> list() {
        List<Passaro> passaroTotal = passaroRepository.findAll();
        return passaroResumoModelAssembler.toCollectionModel(passaroRepository.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassaroModel save(@RequestBody @Valid PassaroInput passaroInput) {
        Passaro passaro = passaroInputDisassembler.toDomainObject(passaroInput);
        return passaroModelAssembler.toModel(passaroService.save(passaro));
    }

    @PutMapping("/{passaroId}")
    public PassaroModel update(@PathVariable Long passaroId,
                               @RequestBody @Valid PassaroResumidoInput passaroInput) {
        Passaro passaroCurrent = passaroService.consultaById(passaroId);
        passaroResumidoInputDisassembler.copyToDomainObjtect(passaroInput,passaroCurrent);
        passaroCurrent = passaroService.update(passaroCurrent);
        return passaroModelAssembler.toModel(passaroCurrent);
   }

    @DeleteMapping("/{passaroId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long passaroId) {
        passaroService.remove(passaroId);
    }


}
