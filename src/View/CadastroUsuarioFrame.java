package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.InputListenerCadastroUsuarioFrame;
import Imagens.JBackground;
import javax.swing.JTextPane;

public class CadastroUsuarioFrame extends JFrame {

	private static final long serialVersionUID = 6633455427082114616L;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private JTextField idadeField;
	private InputListenerCadastroUsuarioFrame listenerCadastroUsuario;
	private JTextField loginField;
	private JTextField nomeField;
	private JTextField senhaField_1;
	private JTextPane txtpnIdade;
	private JTextPane txtpnLogin;

	public CadastroUsuarioFrame() {
		setTitle("Cadastro Usu\u00E1rio");
		initialize();
		listenerCadastroUsuario = new InputListenerCadastroUsuarioFrame(this);
		inicializarListeners();
	}
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(44, 238, 102, 23);
		}
		return btnCadastrar;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(168, 238, 102, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(290, 238, 102, 23);
		}
		return btnVoltar;
	}
	public JTextField getIdadeField() {
		if (idadeField == null) {
			idadeField = new JTextField();
			idadeField.setBounds(148, 158, 86, 20);
			idadeField.setColumns(10);
		}
		return idadeField;
	}
	public JTextField getLoginField() {
		if (loginField == null) {
			loginField = new JTextField();
			loginField.setBounds(148, 189, 86, 20);
			loginField.setColumns(10);
		}
		return loginField;
	}
	public JTextField getNomeField() {
		if (nomeField == null) {
			nomeField = new JTextField();
			nomeField.setBounds(148, 100, 86, 20);
			nomeField.setColumns(10);
		}
		return nomeField;
	}
	public JTextField getSenhaField_1() {
		if (senhaField_1 == null) {
			senhaField_1 = new JTextField();
			senhaField_1.setBounds(148, 127, 86, 20);
			senhaField_1.setColumns(10);
		}
		return senhaField_1;
	}
	private void inicializarListeners() {
		getBtnCadastrar().addActionListener(listenerCadastroUsuario);
		getBtnCancelar().addActionListener(listenerCadastroUsuario);
		getBtnVoltar().addActionListener(listenerCadastroUsuario);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		new JPanel();
		contentPane_1 = new JBackground("cadastrarUsuario.png");
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		setLocationRelativeTo(null);
		contentPane_1.setLayout(null);
		contentPane_1.add(getBtnCadastrar());
		contentPane_1.add(getBtnCancelar());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getNomeField());
		contentPane_1.add(getSenhaField_1());
		contentPane_1.add(getIdadeField());
		contentPane_1.add(getLoginField());
		contentPane_1.add(getTxtpnIdade());
		contentPane_1.add(getTxtpnLogin());
		
	}
	private JTextPane getTxtpnIdade() {
		if (txtpnIdade == null) {
			txtpnIdade = new JTextPane();
			txtpnIdade.setEnabled(false);
			txtpnIdade.setEditable(false);
			txtpnIdade.setText("Idade");
			txtpnIdade.setBounds(84, 158, 39, 20);
		}
		return txtpnIdade;
	}
	private JTextPane getTxtpnLogin() {
		if (txtpnLogin == null) {
			txtpnLogin = new JTextPane();
			txtpnLogin.setEditable(false);
			txtpnLogin.setEnabled(false);
			txtpnLogin.setText("Login");
			txtpnLogin.setBounds(84, 189, 39, 20);
		}
		return txtpnLogin;
	}
}
