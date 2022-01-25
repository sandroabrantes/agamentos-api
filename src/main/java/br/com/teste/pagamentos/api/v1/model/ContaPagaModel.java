package br.com.teste.pagamentos.api.v1.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaPagaModel {

	private String nome;

	private BigDecimal valorOriginal;

	private BigDecimal valorCorrigido;

	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataVencimento;

	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataPagamento;
	
	private long diasEmAtraso;
}
