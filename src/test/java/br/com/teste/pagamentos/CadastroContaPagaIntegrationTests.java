package br.com.teste.pagamentos;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.teste.pagamentos.domain.model.ContaPaga;
import br.com.teste.pagamentos.domain.service.ContaPagaService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CadastroContaPagaIntegrationTests {

	@Autowired
	private ContaPagaService contaPagaService;

	@Test
	public void testarCadastroContaPagaComSucesso() {
		// cenário
		ContaPaga novaContaPaga = new ContaPaga();
		novaContaPaga.setNome("AULA DE NATAÇÃO");
		novaContaPaga.setDataVencimento(new Date());
		novaContaPaga.setDataPagamento(new Date());
		novaContaPaga.setValorOriginal(new BigDecimal(145.00));
		
		// ação
		novaContaPaga = contaPagaService.salvar(novaContaPaga);

		// validação
		assertThat(novaContaPaga).isNotNull();
		assertThat(novaContaPaga.getId()).isNotNull();
	}

	@Test
	public void testarCadastroContaPagaSemNome() {
		ContaPaga novaContaPaga = new ContaPaga();
		novaContaPaga.setNome(null);
		novaContaPaga.setDataVencimento(new Date());
		novaContaPaga.setDataPagamento(new Date());
		novaContaPaga.setValorOriginal(new BigDecimal(145.00));

		ConstraintViolationException erroEsperado = Assertions.assertThrows(ConstraintViolationException.class, () -> {
			contaPagaService.salvar(novaContaPaga);
		});

		assertThat(erroEsperado).isNotNull();
	}

}
