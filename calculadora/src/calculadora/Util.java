package calculadora;

public class Util {

	/**
	 * Verifica se o array informado possui o valor informado.
	 * @param array - o array a ser analisado.
	 * @param valor - o valor a ser procurado no array informado.
	 * @return - true, caso o array possua o valor procurado; false, caso contrário.
	 */
	protected static boolean arrayContains(String[] array, String valor) {
		for (String v : array) {
			if (valor.equals(v)) return true;
		}
		return false;
	}
}
