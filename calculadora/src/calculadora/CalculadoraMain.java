package calculadora;

import javax.swing.UIManager;

public class CalculadoraMain {

	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
 
        new Calculadora();
	}

}
