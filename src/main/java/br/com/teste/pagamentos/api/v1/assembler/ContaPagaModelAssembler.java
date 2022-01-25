package br.com.teste.pagamentos.api.v1.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.teste.pagamentos.api.v1.model.ContaPagaModel;
import br.com.teste.pagamentos.domain.model.ContaPaga;

@Component
public class ContaPagaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ContaPagaModel toModel(ContaPaga contaPaga) {
		return modelMapper.map(contaPaga, ContaPagaModel.class);
	}

	public List<ContaPagaModel> toCollectionModel(Collection<ContaPaga> contas) {
		return contas
				.stream()
				.map(contaPaga -> toModel(contaPaga))
				.collect(Collectors.toList());
	}

}
