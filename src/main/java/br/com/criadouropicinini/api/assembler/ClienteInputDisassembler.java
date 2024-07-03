package br.com.criadouropicinini.api.assembler;


import br.com.criadouropicinini.api.dtos.input.ClienteInput;
import br.com.criadouropicinini.domain.models.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente toDomainObject(ClienteInput clienteInput) {
        return modelMapper.map(clienteInput, Cliente.class);
    }

    public void copyToDomainObjtect(ClienteInput clienteInput, Cliente cliente) {
        modelMapper.map(clienteInput, cliente);
    }
}

