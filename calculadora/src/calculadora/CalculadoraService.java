package calculadora;

public class CalculadoraService {
	private Expressao expressao;
	private Validacao validacao;
	
	public CalculadoraService() {
		this.expressao = new Expressao();
		this.validacao = new Validacao();
	}
	
	public String calcula(String comando) {
		this.validacao.setComando(comando);
		if (this.validacao.getIsNumero() || this.validacao.getIsVirgula()) {
			// Caso seja digitado um número logo após o resultado, limpa o display
			if (this.validacao.getIsOperacaoRealizada() && !this.validacao.getIsOperadorAdicionado()) {
				limpaValores();
			}
			if (this.validacao.getIsOperadorAdicionado()) {
				this.expressao.setSegundoTermo(setTermo(this.expressao.getSegundoTermo(), comando));
			} else {
				this.expressao.setPrimeiroTermo(setTermo(this.expressao.getPrimeiroTermo(), comando));
			}
		} else if (this.validacao.getIsIgual()) {
			realizaCalculo();
		} else if (this.validacao.getIsOperacao()) {
			// impede que uma operação seja adicionada antes de um número
			if (this.expressao.getPrimeiroTermo().isEmpty()) {
				this.expressao.setOperador("");
			} else {
				this.validacao.setIsOperadorAdicionado(true);
				this.expressao.setOperador(comando);
			}
		} else if (this.validacao.getIsLimpar()) {
			limpaValores();
		}
		
		return this.expressao.getExpressao();
	}
	
	private String setTermo(String termo, String comando) {
		// Caso seja digitada uma vírgula logo após o resultado, ela é substituída por 0,
		if (termo.isEmpty() && comando.equals(Label.VIRGULA)) {
			termo = "0,";
		} else {
			termo += (this.validacao.getIsVirgula() && validacao.jaTemVirgula(termo)) ? "" : comando;
		}
		return termo;
	}
	
	private void realizaCalculo() {
		// Impede que ao clicar mais de uma vez seguida em igual (=) dê erro
		// e mantém o valor calculado no display
		if (this.expressao.getOperador().isEmpty()) {
			return;
		}
		try {
			Double calculo = Operacao.calcula(this.expressao);
			this.expressao.setPrimeiroTermo(calculo.toString());
			this.expressao.limpa("","","");
			this.validacao.setIsOperadorAdicionado(false);
			this.validacao.setIsOperacaoRealizada(false);
			this.expressao.setPrimeiroTermo(
					truncate(this.expressao.getPrimeiroTermo(), Dimensao.QTDE_MAX_DIGITOS));
		} catch (NumberFormatException nfe) {
			limpaValores();
		}
	}
	
	private void limpaValores() {
		this.expressao.limpa("", "", "", "");
		this.validacao.setIsOperadorAdicionado(false);
		this.validacao.setIsOperacaoRealizada(false);
	}
	
	protected Boolean isResultadoVazio() {
		return this.expressao.getResultado().isEmpty();
	}

	private String truncate(String valor, int qtdeCaracteres) {
		String retorno = valor;
		if (valor.length() > qtdeCaracteres) {
			retorno = valor.substring(0, qtdeCaracteres);
		}
		return retorno;
	}

	public Validacao getValidacao() {
		return this.validacao;
	}
	
}
