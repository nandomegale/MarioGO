package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.InputListenerCadastroAmigosMarioFrame;
import Imagens.JBackground;

public class CadastroAmigosMarioFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane;
	private JTextField habilidadeField;
	private JTextField historiaField;
	private InputListenerCadastroAmigosMarioFrame listenerCadastroAmigos;
	private JTextField nomeField;

	public CadastroAmigosMarioFrame() {
		setTitle("Cadastro Amigos");
		initialize();
		listenerCadastroAmigos = new InputListenerCadastroAmigosMarioFrame(this);
		inicializarListeners();
	}
	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton("Cadastrar");
			btnAtualizar.setBounds(26, 238, 103, 23);
		}
		return btnAtualizar;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(173, 238, 108, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(320, 238, 103, 23);
		}
		return btnVoltar;
	}
	public JTextField getHabilidadeField() {
		if (habilidadeField == null) {
			habilidadeField = new JTextField();
			habilidadeField.setBounds(176, 112, 86, 20);
			habilidadeField.setColumns(10);
		}
		return habilidadeField;
	}
	public JTextField getHistoriaField() {
		if (historiaField == null) {
			historiaField = new JTextField();
			historiaField.setBounds(176, 143, 86, 58);
			historiaField.setColumns(10);
		}
		return historiaField;
	}
	public JTextField getNomeField() {
		if (nomeField == null) {
			nomeField = new JTextField();
			nomeField.setBounds(176, 89, 86, 20);
			nomeField.setColumns(10);
		}
		return nomeField;
	}
	private void inicializarListeners() {
		getBtnAtualizar().addActionListener(listenerCadastroAmigos);
		getBtnCancelar().addActionListener(listenerCadastroAmigos);
		getBtnVoltar().addActionListener(listenerCadastroAmigos);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("cadastrarAmigos.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getNomeField());
		contentPane.add(getHabilidadeField());
		contentPane.add(getBtnAtualizar());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnVoltar());
		contentPane.add(getHistoriaField());
	}
}
