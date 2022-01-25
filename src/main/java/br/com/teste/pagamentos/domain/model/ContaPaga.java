package br.com.teste.pagamentos.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@SequenceGenerator(name = "conta_paga_seq", sequenceName = "conta_paga_id_seq", allocationSize = 1)
@Table(name = "conta_paga")
@Setter
@Getter
public class ContaPaga {

	@Id
	@GeneratedValue(generator = "conta_paga_seq", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "valor_original", nullable = false)
	private BigDecimal valorOriginal;

	@Column(name = "data_vencimento", nullable = false)
	private Date dataVencimento;

	@Column(name = "data_pagamento", nullable = false)
	private Date dataPagamento;
	
	@CreationTimestamp
	@Column(name = "data_cadastro")
	private OffsetDateTime dataCadastro;

	@UpdateTimestamp
	@Column(name = "data_ultima_alteracao")
	private OffsetDateTime dataUltimaAlteracao;
	
	@Transient
	private long diasEmAtraso;
	
	public long getDiasEmAtraso() {
		long dif = (dataPagamento.getTime() - dataVencimento.getTime());
		diasEmAtraso = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
			
		return diasEmAtraso > 0 ? diasEmAtraso : 0;
	}
	
	@Transient
	private BigDecimal valorCorrigido;
	
	public BigDecimal getValorCorrigido() {
		if (diasEmAtraso <= 0) {
			valorCorrigido = getValorOriginal();
		} else if (diasEmAtraso <= 3) {
			valorCorrigido = valorMulta(new BigDecimal(2)).add(valorJuros(new BigDecimal(0.1)));
		} else if (diasEmAtraso <= 5) {
			valorCorrigido = valorMulta(new BigDecimal(3)).add(valorJuros(new BigDecimal(0.2)));
		} else {
			valorCorrigido = valorMulta(new BigDecimal(5)).add(valorJuros(new BigDecimal(0.3)));
		}
		
		return valorCorrigido.setScale(2, RoundingMode.HALF_EVEN);
	}

	private BigDecimal valorMulta(BigDecimal multa) {
		return getValorOriginal()
				.add(getValorOriginal()
						.multiply(multa.divide(new BigDecimal(100))));
	}

	private BigDecimal valorJuros(BigDecimal juros) {
		return getValorOriginal()
				.multiply(juros.divide(new BigDecimal(100)).multiply(BigDecimal.valueOf(diasEmAtraso)));
	}
	
}
