package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.InputListenerCadastroPoderesFrame;
import Imagens.JBackground;

public class CadastroPoderesFrame extends JFrame {

	private static final long serialVersionUID = 6633455427082114616L;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane;
	private InputListenerCadastroPoderesFrame listenerCadastroPoderes;
	private JTextField nomeField;
	private JTextField efeitoField;

	public CadastroPoderesFrame() {
		setTitle("Cadastro Poderes");
		initialize();
		listenerCadastroPoderes = new InputListenerCadastroPoderesFrame(this);
		inicializarListeners();
	}
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(49, 238, 103, 23);
		}
		return btnCadastrar;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(183, 238, 103, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(316, 238, 103, 23);
		}
		return btnVoltar;
	}
	public JTextField getNomeField() {
		if (nomeField == null) {
			nomeField = new JTextField();
			nomeField.setBounds(195, 100, 86, 20);
			nomeField.setColumns(10);
		}
		return nomeField;
	}
	public JTextField getEfeitoField() {
		if (efeitoField == null) {
			efeitoField = new JTextField();
			efeitoField.setBounds(195, 129, 86, 20);
			efeitoField.setColumns(10);
		}
		return efeitoField;
	}
	private void inicializarListeners() {
		getBtnCadastrar().addActionListener(listenerCadastroPoderes);
		getBtnCancelar().addActionListener(listenerCadastroPoderes);
		getBtnVoltar().addActionListener(listenerCadastroPoderes);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("cadastrarPoderes.jpeg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getBtnCadastrar());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnVoltar());
		contentPane.add(getNomeField());
		contentPane.add(getEfeitoField());
	}
}
