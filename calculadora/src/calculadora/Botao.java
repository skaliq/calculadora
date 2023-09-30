package calculadora;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class Botao extends JButton {
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor protegido da classe Botao.
	 * Define a label do botão, bem como sua fonte e dimensões.
	 * @param label - a label do novo botão.
	 */
	protected Botao(String label) {
		super(label);
		this.setFont(new Font("Arial", Font.PLAIN, Dimensao.DISPLAY_FONT_SIZE));
		if (Label.IGUAL.equals(label)) {
			this.setPreferredSize(new Dimension(Dimensao.BTN_IGUAL_WIDTH, Dimensao.BTN_HEIGHT));
		} else {
			this.setPreferredSize(new Dimension(Dimensao.BTN_WIDTH, Dimensao.BTN_HEIGHT));
		}
	}
}
