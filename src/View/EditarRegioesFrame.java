package View;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Control.InputListenerEditarRegioesFrame;
import Imagens.JBackground;
import Model.Regiao;

public class EditarRegioesFrame extends JFrame {

	private static final long serialVersionUID = 6633455427082114616L;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private InputListenerEditarRegioesFrame listenerEditarRegioes;
	private Regiao r;
	private JTextArea nomeTextArea;
	private JTextArea descricaoTextArea;

	public EditarRegioesFrame(Regiao r) {
		this.r = r;
		setTitle("Editar Regioes");
		initialize();
		listenerEditarRegioes = new InputListenerEditarRegioesFrame(this, r);
		inicializarListeners();
	}

	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton("Atualizar");
			btnCadastrar.setBounds(27, 238, 89, 23);
		}
		return btnCadastrar;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(175, 238, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(330, 238, 89, 23);
		}
		return btnVoltar;
	}

	public JTextArea getNomeTextArea() {
		if (nomeTextArea == null) {
			nomeTextArea = new JTextArea(r.getNome());
			nomeTextArea.setBorder(new LineBorder(Color.BLACK));
			nomeTextArea.setWrapStyleWord(true);
			nomeTextArea.setLineWrap(true);
			nomeTextArea.setBounds(201, 96, 86, 23);
		}
		return nomeTextArea;
	}

	public JTextArea getDescricaoTextArea() {
		if (descricaoTextArea == null) {
			descricaoTextArea = new JTextArea(r.getDescricao());
			descricaoTextArea.setBorder(new LineBorder(Color.BLACK));
			descricaoTextArea.setWrapStyleWord(true);
			descricaoTextArea.setLineWrap(true);
			descricaoTextArea.setBounds(201, 126, 111, 74);
		}
		return descricaoTextArea;
	}

	private void inicializarListeners() {
		getBtnCadastrar().addActionListener(listenerEditarRegioes);
		getBtnCancelar().addActionListener(listenerEditarRegioes);
		getBtnVoltar().addActionListener(listenerEditarRegioes);
	}

	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane_1 = new JPanel();
		contentPane_1 = new JBackground("editarRegioes.png");
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		setLocationRelativeTo(null);
		contentPane_1.setLayout(null);
		contentPane_1.add(getBtnCadastrar());
		contentPane_1.add(getBtnCancelar());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getNomeTextArea());
		contentPane_1.add(getDescricaoTextArea());
	}

}
