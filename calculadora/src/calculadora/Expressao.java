package calculadora;

public class Expressao {
	private String primeiroTermo;
	private String segundoTermo;
	private String operador;
	private String igualdade;
	private String resultado;
	
	public Expressao() {
		this.primeiroTermo = "";
		this.segundoTermo = "";
		this.operador = "";
		this.igualdade = "";
		this.resultado = "";
	}
	
	public String getExpressao() {
		return this.getPrimeiroTermo().replace(".", Label.VIRGULA) + 
				this.getOperador() + this.getSegundoTermo() + this.getResultado();
	}
	
	public void limpa(String resultado, String segundoTermo, String operador) {
		this.resultado = "";
		this.segundoTermo = "";
		this.operador = "";
	}
	
	public void limpa(String resultado, String segundoTermo, String primeiroTermo, String operador) {
		this.limpa(resultado, segundoTermo, operador);
		this.primeiroTermo = "";
	}
	
	public String getPrimeiroTermo() {
		return primeiroTermo;
	}
	public void setPrimeiroTermo(String primeiroTermo) {
		this.primeiroTermo = primeiroTermo;
	}
	public String getSegundoTermo() {
		return segundoTermo;
	}
	public void setSegundoTermo(String segundoTermo) {
		this.segundoTermo = segundoTermo;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getIgualdade() {
		return igualdade;
	}
	public void setIgualdade(String igualdade) {
		this.igualdade = igualdade;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}