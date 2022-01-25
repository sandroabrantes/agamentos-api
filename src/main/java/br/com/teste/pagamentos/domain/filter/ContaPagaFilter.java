package br.com.teste.pagamentos.domain.filter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaPagaFilter {

	private String nome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataVencimentoDe;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataVencimentoAte;
}
