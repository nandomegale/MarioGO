package View;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Control.InputListenerEditarPoderesFrame;
import Imagens.JBackground;
import Model.Poder;

public class EditarPoderesFrame extends JFrame {

	private static final long serialVersionUID = 6633455427082114616L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private InputListenerEditarPoderesFrame listenerEditarPoderes;
	private Poder p;
	private JTextArea NomeTextArea;
	private JTextArea EfeitoTextArea;
	
	public EditarPoderesFrame(Poder p) {
		this.p = p;
		setTitle("Editar Poderes");
		initialize();
		listenerEditarPoderes = new InputListenerEditarPoderesFrame(this,p);
		inicializarListeners();
	}
	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton("Atualizar");
			btnAtualizar.setBounds(29, 238, 89, 23);
		}
		return btnAtualizar;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(178, 238, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(317, 238, 89, 23);
		}
		return btnVoltar;
	}
	
	public JTextArea getNomeTextArea() {
		if (NomeTextArea == null) {
			NomeTextArea = new JTextArea(p.getNome());
			NomeTextArea.setBorder(new LineBorder(Color.BLACK));
			NomeTextArea.setLineWrap(true);
			NomeTextArea.setBounds(178, 99, 86, 23);
		}
		return NomeTextArea;
	}
	
	public JTextArea getEfeitoTextArea() {
		if (EfeitoTextArea == null) {
			EfeitoTextArea = new JTextArea(p.getEfeito());
			EfeitoTextArea.setBorder(new LineBorder(Color.BLACK));
			EfeitoTextArea.setLineWrap(true);
			EfeitoTextArea.setBounds(178, 124, 86, 23);
		}
		return EfeitoTextArea;
	}
	private void inicializarListeners() {
		getBtnAtualizar().addActionListener(listenerEditarPoderes);
		getBtnCancelar().addActionListener(listenerEditarPoderes);
		getBtnVoltar().addActionListener(listenerEditarPoderes);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane_1 = new JPanel();
		contentPane_1 = new JBackground("editarPoderes.png");
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		setLocationRelativeTo(null);
		contentPane_1.setLayout(null);
		contentPane_1.add(getBtnAtualizar());
		contentPane_1.add(getBtnCancelar());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getNomeTextArea());
		contentPane_1.add(getEfeitoTextArea());
	}
	
}
