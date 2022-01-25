package br.com.teste.pagamentos.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.pagamentos.api.v1.assembler.ContaPagaInputDisassembler;
import br.com.teste.pagamentos.api.v1.assembler.ContaPagaModelAssembler;
import br.com.teste.pagamentos.api.v1.model.ContaPagaModel;
import br.com.teste.pagamentos.api.v1.model.input.ContaPagaInput;
import br.com.teste.pagamentos.domain.filter.ContaPagaFilter;
import br.com.teste.pagamentos.domain.model.ContaPaga;
import br.com.teste.pagamentos.domain.repository.ContaPagaRepository;
import br.com.teste.pagamentos.domain.service.ContaPagaService;

@RestController
@RequestMapping(path = "/v1/contas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContaPagaController {

	@Autowired
	private ContaPagaRepository contaPagaRepository;

	@Autowired
	private ContaPagaService contaPagaService;

	@Autowired
	private ContaPagaModelAssembler contaPagaModelAssembler;

	@Autowired
	private ContaPagaInputDisassembler contaPagaInputDisassembler;

	@GetMapping("/{contaPagaId}")
	public ContaPagaModel buscar(@PathVariable Long contaPagaId) {
		ContaPaga contaPaga = contaPagaService.buscarOuFalhar(contaPagaId);

		return contaPagaModelAssembler.toModel(contaPaga);
	}

	@GetMapping
	public List<ContaPagaModel> listar() {
		List<ContaPaga> todasContas = contaPagaRepository.findAll();

		return contaPagaModelAssembler.toCollectionModel(todasContas);
	}

	@GetMapping("/pesquisa")
	public List<ContaPagaModel> pesquisar(ContaPagaFilter contaPagaFilter) {
		List<ContaPaga> contaPagas = contaPagaRepository.pesquisar(contaPagaFilter);

		return contaPagaModelAssembler.toCollectionModel(contaPagas);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContaPagaModel incluir(@RequestBody @Valid ContaPagaInput contaPagaInput) {
		ContaPaga contaPaga = contaPagaInputDisassembler.toDomainObject(contaPagaInput);

		contaPaga = contaPagaService.salvar(contaPaga);

		return contaPagaModelAssembler.toModel(contaPaga);
	}

	@PutMapping("/{contaPagaId}")
	public ContaPagaModel alterar(@PathVariable Long contaPagaId, @RequestBody @Valid ContaPagaInput contaPagaInput) {
		ContaPaga contaPagaAtual = contaPagaService.buscarOuFalhar(contaPagaId);

		contaPagaInputDisassembler.copyToDomainObject(contaPagaInput, contaPagaAtual);

		contaPagaAtual = contaPagaService.salvar(contaPagaAtual);

		return contaPagaModelAssembler.toModel(contaPagaAtual);
	}

	@DeleteMapping("/{contaPagaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long contaPagaId) {
		contaPagaService.apagar(contaPagaId);
	}

}
