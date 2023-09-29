package calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel painel =  new JPanel();
	private JTextField display = new JTextField(Dimensao.DISPLAY_SIZE);
	private CalculadoraService service = new CalculadoraService();
    
    Calculadora() {
    	super("Calculadora");
    	createCalculadora();
    }
    
    private void createCalculadora() {
    	this.display.setFont(new Font("Arial", Font.PLAIN, Dimensao.DISPLAY_FONT_SIZE));
    	this.painel.add(this.display);
    	this.painel.setBackground(Color.GRAY);
    	this.display.setEditable(false);
    	
    	this.add(this.painel);
        Botao limpa = new Botao(Label.LIMPA);
        limpa.addActionListener(this);
        this.painel.add(limpa);
 
        for (int i = 0; i < Label.LABEL_NUMEROS.length; i++) {
        	Botao botao = new Botao(Label.LABEL_NUMEROS[i]);
        	botao.addActionListener(this);
        	this.painel.add(botao);
        }
        
        Botao virgula = new Botao(Label.VIRGULA);
        virgula.addActionListener(this);
        this.painel.add(virgula);
        
        for (int i = 0; i < Label.LABEL_OPERACOES.length; i++) {
        	Botao botao = new Botao(Label.LABEL_OPERACOES[i]);
        	botao.addActionListener(this);
        	this.painel.add(botao);
        }
        Botao igual = new Botao(Label.IGUAL);
        igual.addActionListener(this);
        this.painel.add(igual);

    	this.setSize(Dimensao.CALC_WIDTH, Dimensao.CALC_HEIGHT);
        this.setLocation(Dimensao.CALC_LEFT_POSITION, Dimensao.CALC_TOP_POSITION);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
    	String comando = e.getActionCommand();
    	
    	if (!service.isResultadoVazio() ||
    			service.getValidacao().isValorCalculado(comando)) {
    		this.display.setText("");
    	}
        
        this.display.setText(service.calcula(comando));
    }
}