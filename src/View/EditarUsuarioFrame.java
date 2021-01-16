package View;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Control.InputListenerEditarUsuarioFrame;
import Imagens.JBackground;
import Model.Usuario;

public class EditarUsuarioFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane;
	private InputListenerEditarUsuarioFrame listenerEditarUsuario;
	private JTextField idadeField;
	private Usuario u;
	private JTextArea nomeTextArea;
	private JTextArea loginTextArea;
	private JTextArea senhaTextArea;
	private JTextArea txtrNovaIdade;
	private JTextArea txtrNovoLogin;

	public EditarUsuarioFrame(Usuario u) {
		setTitle("Editar Usu\u00E1rio");
		System.out.println(u);
		this.u = u;
		initialize();
		listenerEditarUsuario = new InputListenerEditarUsuarioFrame(this, u);
		inicializarListeners();
	}

	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton("Atualizar");
			btnAtualizar.setBounds(32, 238, 89, 23);
		}
		return btnAtualizar;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(176, 238, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(322, 238, 89, 23);
		}
		return btnVoltar;
	}

	public JTextField getIdadeField() {
		if (idadeField == null) {
			idadeField = new JTextField(Integer.toString(u.getIdade()));
			idadeField.setBorder(new LineBorder(Color.BLACK));
			idadeField.setBounds(179, 161, 86, 20);
			idadeField.setColumns(10);
		}
		return idadeField;
	}

	public JTextArea getNomeTextArea() {
		if (nomeTextArea == null) {
			nomeTextArea = new JTextArea(u.getNome());
			nomeTextArea.setBorder(new LineBorder(Color.BLACK));
			nomeTextArea.setLineWrap(true);
			nomeTextArea.setBounds(179, 97, 86, 22);
		}
		return nomeTextArea;
	}

	public JTextArea getLoginTextArea() {
		if (loginTextArea == null) {
			loginTextArea = new JTextArea(u.getLoginUser().getLogin());
			loginTextArea.setBorder(new LineBorder(Color.BLACK));
			loginTextArea.setLineWrap(true);
			loginTextArea.setBounds(176, 190, 89, 22);
		}
		return loginTextArea;
	}

	public JTextArea getSenhaTextArea() {
		if (senhaTextArea == null) {
			senhaTextArea = new JTextArea(u.getLoginUser().getSenha());
			senhaTextArea.setBorder(new LineBorder(Color.BLACK));
			senhaTextArea.setLineWrap(true);
			senhaTextArea.setBounds(179, 130, 89, 23);
		}
		return senhaTextArea;
	}

	private void inicializarListeners() {
		getBtnAtualizar().addActionListener(listenerEditarUsuario);
		getBtnCancelar().addActionListener(listenerEditarUsuario);
		getBtnVoltar().addActionListener(listenerEditarUsuario);

	}

	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("editarUsuario.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getBtnAtualizar());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnVoltar());
		contentPane.add(getIdadeField());
		contentPane.add(getNomeTextArea());
		contentPane.add(getLoginTextArea());
		contentPane.add(getSenhaTextArea());
		contentPane.add(getTxtrNovaIdade());
		contentPane.add(getTxtrNovoLogin());
	}
	private JTextArea getTxtrNovaIdade() {
		if (txtrNovaIdade == null) {
			txtrNovaIdade = new JTextArea();
			txtrNovaIdade.setEnabled(false);
			txtrNovaIdade.setEditable(false);
			txtrNovaIdade.setText("Nova Idade");
			txtrNovaIdade.setBounds(77, 159, 94, 23);
		}
		return txtrNovaIdade;
	}
	private JTextArea getTxtrNovoLogin() {
		if (txtrNovoLogin == null) {
			txtrNovoLogin = new JTextArea();
			txtrNovoLogin.setEditable(false);
			txtrNovoLogin.setEnabled(false);
			txtrNovoLogin.setText("Novo Login");
			txtrNovoLogin.setBounds(77, 190, 94, 23);
		}
		return txtrNovoLogin;
	}
}
