package calculadora;

public class Validacao {
	private Boolean isOperadorAdicionado;
	private Boolean isOperacaoRealizada;
	private Boolean isNumero;
	private Boolean isVirgula;
	private Boolean isLimpar;
	private Boolean isOperacao;
	private Boolean isIgual;
	
	public Validacao() {
		this.isOperadorAdicionado = false;
		this.isOperacaoRealizada = false;
		this.isNumero = false;
		this.isVirgula = false;
		this.isLimpar = false;
		this.isOperacao = false;
		this.isIgual = false;
	}
	
	public void setComando(String comando) {
		isNumero = isNumero(comando);
		isVirgula = isVirgula(comando);
		isLimpar = isLimpar(comando);
		isOperacao = isOperacao(comando);
		isIgual = isIgual(comando);
	}
	
	protected Boolean isValorCalculado(String comando) {
		if (isOperacaoRealizada && isNumero && !isOperacao) {
			this.setIsOperacaoRealizada(true);
			return this.getIsOperacaoRealizada();
		}
		return false;
	}
	/**
	 * Verifica se o termo já possui uma vírgula. Caso possua,
	 * a adição de uma segunda vírgula será ignorada pelo método
	 * que invocou este método.
	 * @param termo - o termo a ser verificado
	 * @return - true, se o termo já possuir uma vírgula; false, caso contrário.
	 */
	protected Boolean jaTemVirgula(String termo) {
		int counter = 0;
		for (char c : termo.toCharArray()) {
			if (c == ',') {
				counter++;
			}
		}
		return counter == 1;
	}
	
	private boolean isOperacao(String valor) {
		return Util.arrayContains(Label.LABEL_OPERACOES, valor);
	}

	private Boolean isNumero(String comando) {
		return Util.arrayContains(Label.LABEL_NUMEROS, comando);
	}
	
	private Boolean isVirgula(String comando) {
		return Label.VIRGULA.equals(comando);
	}
	
	private Boolean isIgual(String comando) {
		return Label.IGUAL.equals(comando);
	}
	
	private Boolean isLimpar(String comando) {
		return Label.LIMPA.equals(comando);
	}

	public Boolean getIsOperadorAdicionado() {
		return isOperadorAdicionado;
	}

	public void setIsOperadorAdicionado(Boolean isOperadorAdicionado) {
		this.isOperadorAdicionado = isOperadorAdicionado;
	}

	public Boolean getIsOperacaoRealizada() {
		return isOperacaoRealizada;
	}

	public void setIsOperacaoRealizada(Boolean isOperacaoRealizada) {
		this.isOperacaoRealizada = isOperacaoRealizada;
	}

	public Boolean getIsNumero() {
		return isNumero;
	}

	public void setIsNumero(Boolean isNumero) {
		this.isNumero = isNumero;
	}

	public Boolean getIsVirgula() {
		return isVirgula;
	}

	public void setIsVirgula(Boolean isVirgula) {
		this.isVirgula = isVirgula;
	}

	public Boolean getIsLimpar() {
		return isLimpar;
	}

	public void setIsLimpar(Boolean isLimpar) {
		this.isLimpar = isLimpar;
	}

	public Boolean getIsOperacao() {
		return isOperacao;
	}

	public void setIsOperacao(Boolean isOperacao) {
		this.isOperacao = isOperacao;
	}

	public Boolean getIsIgual() {
		return isIgual;
	}

	public void setIsIgual(Boolean isIgual) {
		this.isIgual = isIgual;
	}
}
