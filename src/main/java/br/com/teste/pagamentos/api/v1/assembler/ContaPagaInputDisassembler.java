package br.com.teste.pagamentos.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.teste.pagamentos.api.v1.model.input.ContaPagaInput;
import br.com.teste.pagamentos.domain.model.ContaPaga;

@Component
public class ContaPagaInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public ContaPaga toDomainObject(ContaPagaInput contaInput) {
		return modelMapper.map(contaInput, ContaPaga.class);
	}

	public void copyToDomainObject(ContaPagaInput contaPagaInput, ContaPaga contaPaga) {
		modelMapper.map(contaPagaInput, contaPaga);
	}
}
