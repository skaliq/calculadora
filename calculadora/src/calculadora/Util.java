package calculadora;

public class Util {

	protected static boolean arrayContains(String[] array, String valor) {
		for (String v : array) {
			if (valor.equals(v)) return true;
		}
		return false;
	}
}
