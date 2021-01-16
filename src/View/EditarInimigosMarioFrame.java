package View;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Control.InputListenerEditarInimigosMarioFrame;
import Imagens.JBackground;
import Model.Inimigo;

public class EditarInimigosMarioFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane;
	private JTextArea HistoriatextArea;
	private JTextArea HabilidadetextArea;
	private JTextArea NometextArea;
	private InputListenerEditarInimigosMarioFrame listenerEditarInimigos;
	private Inimigo i;

	public EditarInimigosMarioFrame(Inimigo i) {
		this.i =i ;
		setTitle("Editar Inimigos");
		initialize();
		listenerEditarInimigos = new InputListenerEditarInimigosMarioFrame(this,i);
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
			btnCancelar.setBounds(183, 238, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(320, 238, 89, 23);
		}
		return btnVoltar;
	}
	
	public JTextArea getHistoriaTextArea() {
		if (HistoriatextArea == null) {
			HistoriatextArea = new JTextArea(i.getHistoria());
			HistoriatextArea.setBorder(new LineBorder(Color.BLACK));
			HistoriatextArea.setLineWrap(true);
			HistoriatextArea.setBounds(197, 135, 147, 62);
		}
		return HistoriatextArea;
	}

	public JTextArea getHabilidadetextArea() {
		if (HabilidadetextArea == null) {
			HabilidadetextArea = new JTextArea(i.getHabilidade());
			HabilidadetextArea.setBorder(new LineBorder(Color.BLACK));
			HabilidadetextArea.setLineWrap(true);
			HabilidadetextArea.setBounds(197, 109, 147, 20);
		}
		return HabilidadetextArea;
	}

	public JTextArea getNomeTextArea() {
		if (NometextArea == null) {
			NometextArea = new JTextArea(i.getNome());
			NometextArea.setBorder(new LineBorder(Color.BLACK));
			NometextArea.setLineWrap(true);
			NometextArea.setBounds(197, 90, 147, 20);
		}
		return NometextArea;
	}
	
	
	
	private void inicializarListeners() {
		getBtnAtualizar().addActionListener(listenerEditarInimigos);
		getBtnCancelar().addActionListener(listenerEditarInimigos);
		getBtnVoltar().addActionListener(listenerEditarInimigos);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("editarInimigos.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getBtnAtualizar());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnVoltar());
		contentPane.add(getHistoriaTextArea());
		contentPane.add(getHabilidadetextArea());
		contentPane.add(getNomeTextArea());
		
	}
}
