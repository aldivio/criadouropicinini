package br.com.criadouropicinini.api.controlles;


import br.com.criadouropicinini.api.assembler.ClienteInputDisassembler;
import br.com.criadouropicinini.api.assembler.ClienteModelAssembler;
import br.com.criadouropicinini.api.dtos.input.ClienteInput;
import br.com.criadouropicinini.api.dtos.model.ClienteModel;
import br.com.criadouropicinini.domain.models.Cliente;
import br.com.criadouropicinini.domain.repositories.ClienteRepository;
import br.com.criadouropicinini.domain.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteModelAssembler clienteModelAssembler;
    @Autowired
    private ClienteInputDisassembler clienteInputDisassembler;


    @GetMapping("/{clienteId}")
    public Cliente buscaById(@PathVariable Long clienteId) {
        return clienteService.consultaById(clienteId);
    }

    @GetMapping
    public List<Cliente> list() {
        List<Cliente> clienteTotal = clienteRepository.findAll();
        return clienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteModel save(@RequestBody @Valid ClienteInput clienteInput) {
        Cliente cliente = clienteInputDisassembler.toDomainObject(clienteInput);
        return clienteModelAssembler.toModel(clienteService.save(cliente));

    }

    @PutMapping("/{clienteId}")
    public ClienteModel update(@PathVariable Long clienteId,
                               @RequestBody @Valid ClienteInput clienteInput) {
        Cliente clienteCurrent = clienteService.consultaById(clienteId);
        clienteInputDisassembler.copyToDomainObjtect(clienteInput, clienteCurrent);
        clienteCurrent = clienteService.save(clienteCurrent);
        return clienteModelAssembler.toModel(clienteCurrent);
    }

    @DeleteMapping("/{clienteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long clienteId) {
        clienteService.remove(clienteId);
    }


}
