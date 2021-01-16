package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.InputListenerMenuRegioesFrame;
import Imagens.JBackground;

public class MenuRegiõesFrame extends JFrame {

	private static final long serialVersionUID = -8203908351218357278L;
	private JButton btnCadastrar;
	private JButton btnListar;
	private JButton btnSair;
	private JButton btnVoltar;
	private JPanel contentPane;
	private InputListenerMenuRegioesFrame listenerMenuRegioes;

	public MenuRegiõesFrame() {
		setTitle("Menu Regi\u00F5es");
		initialize();
		listenerMenuRegioes = new InputListenerMenuRegioesFrame(this);
		inicializarListeners();
	}
	
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(153, 107, 123, 23);
		}
		return btnCadastrar;
	}
	
	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton("Listar");
			btnListar.setBounds(153, 164, 123, 23);
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
			btnVoltar.setBounds(64, 228, 89, 23);
		}
		return btnVoltar;
	}
	private void inicializarListeners(){
		getBtnCadastrar().addActionListener(listenerMenuRegioes);
		getBtnListar().addActionListener(listenerMenuRegioes);
		getBtnSair().addActionListener(listenerMenuRegioes);
		getBtnVoltar().addActionListener(listenerMenuRegioes);
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("menuRegioes.png");
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
