package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Control.InputListenerListarInimigosMarioFrame;
import Imagens.JBackground;
import Model.InimigoDAO;

public class ListarInimigosMarioFrame extends JFrame {

	private static final long serialVersionUID = -892712667754648073L;
	private JButton btnEditar;
	private JButton btnGerarRelatrio;
	private JButton btnRemover;
	private JButton btnVoltar;
	private JPanel contentPane;
	private InputListenerListarInimigosMarioFrame listenerListarInimigos;
	private JList<String> list;
	private JPanel listPanel;
	private JScrollPane scrollPane;

	public ListarInimigosMarioFrame() {
		setTitle("Listar Inimigos");
		initialize();
		listenerListarInimigos = new InputListenerListarInimigosMarioFrame(this);
		inicializarListeners();
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setBounds(125, 238, 89, 23);
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
			btnRemover.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnRemover.setBounds(228, 238, 89, 23);
		}
		return btnRemover;
	}
	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(325, 238, 89, 23);
		}
		return btnVoltar;
	}
	
	public JList<String> getList() {
		if (list == null) {
			list = new JList<String>(InimigoDAO.getInstance().getAllInimigos());
			list.setBounds(71, 82, 285, 150);
		}
		return list;
	}
	
	public void refreshList(){
		list.setModel(InimigoDAO.getInstance().getAllInimigos());
	}
	
	private JPanel getListPanel() {
		if (listPanel == null) {
			listPanel = new JPanel();			
			listPanel.setBounds(67, 83, 317, 150);
			listPanel.setLayout(new BorderLayout(0, 0));
			listPanel.add(getScrollPane());
		}
		return listPanel;
	}
	 
	private JScrollPane getScrollPane(){
		if(scrollPane == null){
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	
	private void inicializarListeners(){
		getBtnEditar().addActionListener(listenerListarInimigos);
		getBtnGerarRelatrio().addActionListener(listenerListarInimigos);
		getBtnRemover().addActionListener(listenerListarInimigos);
		getBtnVoltar().addActionListener(listenerListarInimigos);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = new JBackground("listarInimigos.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getBtnGerarRelatrio());
		contentPane.add(getBtnVoltar());
		contentPane.add(getBtnEditar());
		contentPane.add(getBtnRemover());
		contentPane.add(getListPanel());
	}
}
