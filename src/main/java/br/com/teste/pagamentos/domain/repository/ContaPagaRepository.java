package br.com.teste.pagamentos.domain.repository;

import org.springframework.stereotype.Repository;

import br.com.teste.pagamentos.domain.model.ContaPaga;

@Repository
public interface ContaPagaRepository extends CustomJpaRepository<ContaPaga, Long>, ContaPagaRepositoryQueries {

}
