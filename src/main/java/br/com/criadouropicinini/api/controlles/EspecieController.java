package br.com.criadouropicinini.api.controlles;

import br.com.criadouropicinini.api.assembler.EspecieAssembler;
import br.com.criadouropicinini.api.assembler.EspecieInputDisassembler;
import br.com.criadouropicinini.api.dtos.input.EspecieInput;
import br.com.criadouropicinini.api.dtos.model.EspecieModel;
import br.com.criadouropicinini.domain.models.Especie;
import br.com.criadouropicinini.domain.repositories.EspecieRepository;
import br.com.criadouropicinini.domain.services.EspecieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("especies")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @Autowired
    private EspecieRepository especieRepository;

    @Autowired
    private EspecieAssembler especieAssembler;

    @Autowired
    private EspecieInputDisassembler especieInputDisassembler;


    @GetMapping("/{especieId}")
    public Especie buscaById(@PathVariable Long especieId) {
        return especieService.consultaById(especieId);
    }

    @GetMapping
    public List<Especie> list() {
        List<Especie> especieTotal = especieRepository.findAll();
        return especieRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EspecieModel save(@RequestBody EspecieInput especieInput) {
        System.out.println("AKI ---> " + especieInput.toString());
            Especie especie = especieInputDisassembler.toDomainObject(especieInput);
            return especieAssembler.toModel(especieService.save(especie));

    }

    @PutMapping("/{especieId}")
    public EspecieModel update(@PathVariable Long especieId,
                               @RequestBody  EspecieInput especieInput) {
        Especie especieCurrent = especieService.consultaById(especieId);
        especieInputDisassembler.copyToDomainObjtect(especieInput, especieCurrent);
        especieCurrent = especieService.save(especieCurrent);
        return especieAssembler.toModel(especieCurrent);
    }
    @DeleteMapping("/{especieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long especieId) {
        especieService.remove(especieId);
    }

}
