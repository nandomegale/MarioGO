package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.InputListenerCadastroRegioesFrame;
import Imagens.JBackground;

public class CadastroRegioesFrame extends JFrame {

	private static final long serialVersionUID = 6633455427082114616L;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane;
	private JTextField descricaoField;
	private InputListenerCadastroRegioesFrame listenerCadastroRegioes;
	private JTextField nomeField;

	public CadastroRegioesFrame() {
		setTitle("Cadastro Regi\u00F5es");
		initialize();
		listenerCadastroRegioes = new InputListenerCadastroRegioesFrame(this);
		inicializarListeners();
	}
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(35, 238, 104, 23);
		}
		return btnCadastrar;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(160, 238, 106, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(283, 238, 104, 23);
		}
		return btnVoltar;
	}
	public JTextField getDescricaoField() {
		if (descricaoField == null) {
			descricaoField = new JTextField();
			descricaoField.setBounds(166, 132, 86, 60);
			descricaoField.setColumns(10);
		}
		return descricaoField;
	}
	public JTextField getNomeField() {
		if (nomeField == null) {
			nomeField = new JTextField();
			nomeField.setBounds(166, 101, 86, 20);
			nomeField.setColumns(10);
		}
		return nomeField;
	}
	private void inicializarListeners() {
		getBtnCadastrar().addActionListener(listenerCadastroRegioes);
		getBtnCancelar().addActionListener(listenerCadastroRegioes);
		getBtnVoltar().addActionListener(listenerCadastroRegioes);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("cadastrarRegioes.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getBtnCadastrar());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnVoltar());
		contentPane.add(getNomeField());
		contentPane.add(getDescricaoField());
	}
}
