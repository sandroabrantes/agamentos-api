package br.com.teste.pagamentos.domain.repository;

import java.util.List;

import br.com.teste.pagamentos.domain.filter.ContaPagaFilter;
import br.com.teste.pagamentos.domain.model.ContaPaga;

public interface ContaPagaRepositoryQueries {

	List<ContaPaga> pesquisar(ContaPagaFilter contaPagaFilter);
}
