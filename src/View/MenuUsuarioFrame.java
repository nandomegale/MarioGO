package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.InputListenerMenuUsuarioFrame;
import Imagens.JBackground;

public class MenuUsuarioFrame extends JFrame {

	private static final long serialVersionUID = -880311488282439014L;
	private JButton btnAmigosDoMrio;
	private JButton btnInimigosDoMrio;
	private JButton btnPoderes;
	private JButton btnRegies;
	private JButton btnSair;
	private JButton btnVoltar;
	private JPanel contentPane;
	private InputListenerMenuUsuarioFrame listenerMenuUsuario;
	
	public MenuUsuarioFrame() {
		setTitle("Menu Usu\u00E1rio");
		initialize();
		listenerMenuUsuario = new InputListenerMenuUsuarioFrame(this);
		inicializarListeners();
	}
	private JButton getBtnAmigosDoMrio() {
		if (btnAmigosDoMrio == null) {
			btnAmigosDoMrio = new JButton("Amigos do M\u00E1rio");
			btnAmigosDoMrio.setBounds(140, 86, 155, 23);
		}
		return btnAmigosDoMrio;
	}
	
	private JButton getBtnInimigosDoMrio() {
		if (btnInimigosDoMrio == null) {
			btnInimigosDoMrio = new JButton("Inimigos do M\u00E1rio");
			btnInimigosDoMrio.setBounds(140, 194, 155, 23);
		}
		return btnInimigosDoMrio;
	}

	private JButton getBtnPoderes() {
		if (btnPoderes == null) {
			btnPoderes = new JButton("Poderes");
			btnPoderes.setBounds(140, 154, 155, 23);
		}
		return btnPoderes;
	}
	private JButton getBtnRegies() {
		if (btnRegies == null) {
			btnRegies = new JButton("Regi\u00F5es");
			btnRegies.setBounds(140, 120, 155, 23);
		}
		return btnRegies;
	}
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(259, 238, 89, 23);
		}
		return btnSair;
	}
	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(55, 238, 89, 23);
		}
		return btnVoltar;
	}
	private void inicializarListeners(){
		getBtnAmigosDoMrio().addActionListener(listenerMenuUsuario);
		getBtnInimigosDoMrio().addActionListener(listenerMenuUsuario);
		getBtnPoderes().addActionListener(listenerMenuUsuario);
		getBtnRegies().addActionListener(listenerMenuUsuario);
		getBtnSair().addActionListener(listenerMenuUsuario);
		getBtnVoltar().addActionListener(listenerMenuUsuario);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("menuUsuario.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getBtnAmigosDoMrio());
		contentPane.add(getBtnRegies());
		contentPane.add(getBtnPoderes());
		contentPane.add(getBtnInimigosDoMrio());
		contentPane.add(getBtnVoltar());
		contentPane.add(getBtnSair());
	}
}
