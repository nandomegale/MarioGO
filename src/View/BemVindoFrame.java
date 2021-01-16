package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.InputListenerBemVindoFrame;
import Imagens.JBackground;

public class BemVindoFrame extends JFrame {

	private static final long serialVersionUID = -2101837181261778892L;
	private JButton btnEntrar;
	private JButton btnSair;
	private JPanel contentPane_1;
	private InputListenerBemVindoFrame listenerBemVindo;
	private JPasswordField passwordField;
	private JTextField userTextField;
	
	public BemVindoFrame() {
		setResizable(false);
		setTitle("Mario GO!");
		initialize();
		listenerBemVindo = new InputListenerBemVindoFrame(this);
		inicializarListeners();		
	}
	private JButton getBtnEntrar() {
		if (btnEntrar == null) {
			btnEntrar = new JButton("Entrar");
			btnEntrar.setBounds(101, 216, 89, 23);
		}
		return btnEntrar;
	}
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(221, 216, 89, 23);
		}
		return btnSair;
	}
	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(221, 159, 89, 20);
		}
		return passwordField;
	}
	public JTextField getUserTextField() {
		if (userTextField == null) {
			userTextField = new JTextField();
			userTextField.setBounds(224, 114, 86, 20);
			userTextField.setColumns(10);
		}
		return userTextField;
	}
	private void inicializarListeners() {
		getBtnEntrar().addActionListener(listenerBemVindo);
		getBtnSair().addActionListener(listenerBemVindo);
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		new JPanel();
		contentPane_1 = new JBackground("Boas_Vindas.png");
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		setLocationRelativeTo(null);
		contentPane_1.setLayout(null);
		contentPane_1.add(getBtnEntrar());
		contentPane_1.add(getBtnSair());
		contentPane_1.add(getUserTextField());
		contentPane_1.add(getPasswordField());
	}
}
