package calculadora;

public class Label {
	protected static final String ZERO = "0";
	protected static final String UM = "1";
	protected static final String DOIS = "2";
	protected static final String TRES = "3";
	protected static final String QUATRO = "4";
	protected static final String CINCO = "5";
	protected static final String SEIS = "6";
	protected static final String SETE = "7";
	protected static final String OITO = "8";
	protected static final String NOVE = "9";
	protected static final String DIVISAO = "/";
	protected static final String MULTIPLICACAO = "*";
	protected static final String ADICAO = "+";
	protected static final String SUBTRACAO = "-";
	protected static final String IGUAL = "=";
	protected static final String LIMPA = "C";
	protected static final String VIRGULA = ",";
	protected static final String PONTO = ".";
	protected static final String[] LABEL_NUMEROS;
	protected static final String[] LABEL_OPERACOES;
	
	static {
		LABEL_NUMEROS = new String[] {ZERO,UM,DOIS,TRES,QUATRO,CINCO,SEIS,SETE,OITO,NOVE};
        LABEL_OPERACOES = new String[] {ADICAO,SUBTRACAO,DIVISAO,MULTIPLICACAO};
	}
}
