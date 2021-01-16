package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.InputListenerMenuAdminFrame;
import Imagens.JBackground;

public class MenuAdminFrame extends JFrame {

	private static final long serialVersionUID = -4253126942024484618L;
	private JButton btnCadastrar;
	private JButton btnListar;
	private JButton btnSair;
	private JButton btnVoltar;
	private JPanel contentPane;
	private InputListenerMenuAdminFrame listenerMenuAdmin;

	public MenuAdminFrame() {
		setResizable(false);
		setAutoRequestFocus(false);
		setTitle("Menu Administrador");
		initialize();
		listenerMenuAdmin = new InputListenerMenuAdminFrame(this);
		inicializarListeners();
	}
	
	private void inicializarListeners(){
		getBtnCadastrar().addActionListener(listenerMenuAdmin);
		getBtnListar().addActionListener(listenerMenuAdmin);
		getBtnSair().addActionListener(listenerMenuAdmin);
		getBtnVoltar().addActionListener(listenerMenuAdmin);	
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("MenuAdmin.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getBtnCadastrar());
		contentPane.add(getBtnListar());
		contentPane.add(getBtnVoltar());
		contentPane.add(getBtnSair());
	}
	
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton("Cadastrar Usu\u00E1rios");
			btnCadastrar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCadastrar.setBounds(148, 124, 131, 23);
		}
		return btnCadastrar;
	}

	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton("Listar Usu\u00E1rios");
			btnListar.setBounds(148, 158, 131, 23);
		}
		return btnListar;
	}
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(231, 228, 89, 23);
		}
		return btnSair;
	}
	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBackground(new Color(255, 255, 255));
			btnVoltar.setBounds(99, 228, 89, 23);
		}
		return btnVoltar;
	}
}
