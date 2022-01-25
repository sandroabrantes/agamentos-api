package br.com.teste.pagamentos.api.v1.model.input;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaPagaInput {

	@NotBlank
	private String nome;

	@NotNull
	private BigDecimal valorOriginal;

	@NotNull
	private Date dataVencimento;

	@NotNull
	private Date dataPagamento;
}
