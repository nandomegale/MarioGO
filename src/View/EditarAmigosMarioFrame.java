package View;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Control.InputListenerEditarAmigosMarioFrame;
import Imagens.JBackground;
import Model.Amigo;

public class EditarAmigosMarioFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1_1;
	private InputListenerEditarAmigosMarioFrame listenerEditarAmigos;
	private Amigo a;
	private JTextArea HistoriatextArea;
	private JTextArea HabilidadetextArea;
	private JTextArea NometextArea;

	public EditarAmigosMarioFrame(Amigo a) {
		this.a = a;
		setTitle("Editar Amigos");
		initialize();
		listenerEditarAmigos = new InputListenerEditarAmigosMarioFrame(this, a);
		inicializarListeners();
	}

	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton("Atualizar");
			btnAtualizar.setBounds(43, 238, 89, 23);
		}
		return btnAtualizar;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(182, 238, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(318, 238, 89, 23);
		}
		return btnVoltar;
	}

	public JTextArea getHistoriaTextArea() {
		if (HistoriatextArea == null) {
			HistoriatextArea = new JTextArea(a.getHistoria());
			HistoriatextArea.setBorder(new LineBorder(Color.BLACK));
			HistoriatextArea.setLineWrap(true);
			HistoriatextArea.setBounds(197, 135, 147, 62);
		}
		return HistoriatextArea;
	}

	public JTextArea getHabilidadetextArea() {
		if (HabilidadetextArea == null) {
			HabilidadetextArea = new JTextArea(a.getHabilidade());
			HabilidadetextArea.setBorder(new LineBorder(Color.BLACK));
			HabilidadetextArea.setLineWrap(true);
			HabilidadetextArea.setBounds(197, 109, 147, 20);
		}
		return HabilidadetextArea;
	}

	public JTextArea getNomeTextArea() {
		if (NometextArea == null) {
			NometextArea = new JTextArea(a.getNome());
			NometextArea.setBorder(new LineBorder(Color.BLACK));
			NometextArea.setLineWrap(true);
			NometextArea.setBounds(197, 90, 147, 20);
		}
		return NometextArea;
	}

	private void inicializarListeners() {
		getBtnAtualizar().addActionListener(listenerEditarAmigos);
		getBtnCancelar().addActionListener(listenerEditarAmigos);
		getBtnVoltar().addActionListener(listenerEditarAmigos);
	}

	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane_1_1 = new JPanel();
		contentPane_1_1 = new JBackground("EditarAmigos.png");
		contentPane_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1_1);
		setLocationRelativeTo(null);
		contentPane_1_1.setLayout(null);
		contentPane_1_1.add(getBtnAtualizar());
		contentPane_1_1.add(getBtnCancelar());
		contentPane_1_1.add(getBtnVoltar());
		contentPane_1_1.add(getHistoriaTextArea());
		contentPane_1_1.add(getHabilidadetextArea());
		contentPane_1_1.add(getNomeTextArea());
	}
}
