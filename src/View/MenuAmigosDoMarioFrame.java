package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.InputListenerMenuAmigosMarioFrame;
import Imagens.JBackground;

public class MenuAmigosDoMarioFrame extends JFrame {

	private static final long serialVersionUID = -8203908351218357278L;
	private JButton btnCadastrar;
	private JButton btnListar;
	private JButton btnSair;
	private JButton btnVoltar;
	private JPanel contentPane;
	private InputListenerMenuAmigosMarioFrame listenerMenuAmigos;

	public MenuAmigosDoMarioFrame() {
		setTitle("Menu Amigos");
		initialize();
		listenerMenuAmigos = new InputListenerMenuAmigosMarioFrame(this);
		inicializarListeners();
	}
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(141, 94, 134, 23);
		}
		return btnCadastrar;
	}
	
	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton("Listar");
			btnListar.setBounds(141, 142, 134, 23);
		}
		return btnListar;
	}

	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(242, 228, 89, 23);
		}
		return btnSair;
	}
	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(66, 228, 89, 23);
		}
		return btnVoltar;
	}
	private void inicializarListeners(){
		getBtnCadastrar().addActionListener(listenerMenuAmigos);
		getBtnListar().addActionListener(listenerMenuAmigos);
		getBtnSair().addActionListener(listenerMenuAmigos);
		getBtnVoltar().addActionListener(listenerMenuAmigos);
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("menuAmigos.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getBtnCadastrar());
		contentPane.add(getBtnListar());
		contentPane.add(getBtnVoltar());
		contentPane.add(getBtnSair());
	}
}
