package br.com.teste.pagamentos.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.teste.pagamentos.domain.exception.NegocioException;
import br.com.teste.pagamentos.domain.model.ContaPaga;
import br.com.teste.pagamentos.domain.repository.ContaPagaRepository;

@Service
public class ContaPagaService {

	@Autowired
	private ContaPagaRepository contaPagaRepository;
	
	public ContaPaga buscarOuFalhar(Long contaPagaId) {
		return contaPagaRepository.findById(contaPagaId).orElseThrow(() -> new NegocioException(String.format("Não existe uma conta com código %d", contaPagaId)));
	}

	@Transactional
	public ContaPaga salvar(ContaPaga contaPaga) {
		return contaPagaRepository.save(contaPaga);
	}
	
	@Transactional
	public void apagar(Long contaPagaId) {
		buscarOuFalhar(contaPagaId);
		contaPagaRepository.deleteById(contaPagaId);
	}

}
