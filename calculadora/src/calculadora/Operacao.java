package calculadora;

import java.math.BigDecimal;
import java.math.MathContext;

public class Operacao {
	/** Usa-se o BigDecimal para garantir a precisão. De outra forma, uma soma
	de 5.6 + 5.8 resultaria em 11.399999... e não em 11.4
	@exception NumberFormatException - será lançada caso algum dos valores seja vazio */
	protected static Double calcula(Expressao expressao)
		throws NumberFormatException {
		BigDecimal valorCalculado = new BigDecimal("0");
		Double v_1 = Double.valueOf(expressao.getPrimeiroTermo().replace(Label.VIRGULA, Label.PONTO));
		Double v_2 = Double.valueOf(expressao.getSegundoTermo().replace(Label.VIRGULA, Label.PONTO));
		
		BigDecimal valor1 = new BigDecimal(v_1.toString());
		BigDecimal valor2 = new BigDecimal(v_2.toString());
		
		String operacao = expressao.getOperador();

		if (Label.ADICAO.equals(operacao)) {
			valorCalculado = valor1.add(valor2, MathContext.DECIMAL128);
		} else if (Label.SUBTRACAO.equals(operacao)) {
			valorCalculado = valor1.subtract(valor2, MathContext.DECIMAL128);
		} else if (Label.MULTIPLICACAO.equals(operacao)) {
			valorCalculado = valor1.multiply(valor2, MathContext.DECIMAL128);
		} else {
			valorCalculado = valor1.divide(valor2, MathContext.DECIMAL128);
		}
		if (valorCalculado.toString().length() > Dimensao.QTDE_MAX_DIGITOS) {
			valorCalculado = new BigDecimal(valorCalculado.toString().substring(0, Dimensao.QTDE_MAX_DIGITOS));
		}
		return valorCalculado.doubleValue();
	}
}