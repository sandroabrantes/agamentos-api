package br.com.teste.pagamentos.infrastructure.repository;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.teste.pagamentos.domain.filter.ContaPagaFilter;
import br.com.teste.pagamentos.domain.model.ContaPaga;
import br.com.teste.pagamentos.domain.repository.ContaPagaRepositoryQueries;

@Repository
public class ContaPagaRepositoryImpl implements ContaPagaRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ContaPaga> pesquisar(ContaPagaFilter contaPagaFilter) {

		var jpql = new StringBuilder();
		jpql.append("FROM ContaPaga cp WHERE 0 = 0 ");

		var parametros = new HashMap<String, Object>();

		if (StringUtils.hasText(contaPagaFilter.getNome())) {
			jpql.append("AND cp.nome LIKE :nome ");
			parametros.put("nome", "%" + contaPagaFilter.getNome().trim().toUpperCase() + "%");
		}

		if (contaPagaFilter.getDataVencimentoDe() != null) {
			jpql.append("AND cp.dataVencimento >= :dataVencimentoDe ");
			parametros.put("dataVencimentoDe", contaPagaFilter.getDataVencimentoDe());
		}

		if (contaPagaFilter.getDataVencimentoAte() != null) {
			jpql.append("AND cp.dataVencimento <= :dataVencimentoAte ");
			parametros.put("dataVencimentoAte", contaPagaFilter.getDataVencimentoAte());
		}

		jpql.append("ORDER BY cp.nome ");

		TypedQuery<ContaPaga> query = manager.createQuery(jpql.toString(), ContaPaga.class);

		parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

		return query.getResultList();
	}

}
