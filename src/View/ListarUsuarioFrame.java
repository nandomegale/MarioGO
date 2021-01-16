package View;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Control.InputListenerListarUsuarioFrame;
import Imagens.JBackground;
import Model.UsuarioDAO;

public class ListarUsuarioFrame extends JFrame {

	private static final long serialVersionUID = -892712667754648073L;
	private JButton btnEditar;
	private JButton btnGerarRelatrio;
	private JButton btnRemover;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private JList<String> list;
	private InputListenerListarUsuarioFrame listenerListarUsuario;
	private JPanel panel;
	private JScrollPane scrollPane;

	public ListarUsuarioFrame() {
		setTitle("Listar Usu\u00E1rios");
		initialize();
		listenerListarUsuario = new InputListenerListarUsuarioFrame(this);
		inicializarListeners();
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setBounds(133, 238, 89, 23);
		}
		return btnEditar;
	}
	
	private JButton getBtnGerarRelatrio() {
		if (btnGerarRelatrio == null) {
			btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
			btnGerarRelatrio.setBounds(10, 238, 105, 23);
		}
		return btnGerarRelatrio;
	}
	private JButton getBtnRemover() {
		if (btnRemover == null) {
			btnRemover = new JButton("Remover");
			btnRemover.setBounds(235, 238, 89, 23);
		}
		return btnRemover;
	}
	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(334, 238, 89, 23);
		}
		return btnVoltar;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(51, 79, 336, 152);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JScrollPane getScrollPane(){
		if(scrollPane == null){
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	
	public JList<String> getList() {
		if (list == null) {
			list = new JList<String>(UsuarioDAO.getInstance().getAllUsuarios());
		}
		return list;
	}
	
	public void refreshList(){
		list.setModel(UsuarioDAO.getInstance().getAllUsuarios());
	}
	
	private void inicializarListeners(){
		getBtnEditar().addActionListener(listenerListarUsuario);
		getBtnGerarRelatrio().addActionListener(listenerListarUsuario);
		getBtnRemover().addActionListener(listenerListarUsuario);
		getBtnVoltar().addActionListener(listenerListarUsuario);		
	}
	
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane_1 = new JPanel();
		contentPane_1 = new JBackground("listarUsuario.png");
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		setLocationRelativeTo(null);
		contentPane_1.setLayout(null);
		contentPane_1.add(getBtnGerarRelatrio());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getBtnEditar());
		contentPane_1.add(getBtnRemover());
		contentPane_1.add(getPanel());
	}
	
}
