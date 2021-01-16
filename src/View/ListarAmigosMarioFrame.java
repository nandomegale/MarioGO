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

import Control.InputListenerListarAmigosMarioFrame;
import Imagens.JBackground;
import Model.AmigoDAO;

public class ListarAmigosMarioFrame extends JFrame {

	private static final long serialVersionUID = -892712667754648073L;
	private JButton btnEditar;
	private JButton btnGerarRelatrio;
	private JButton btnRemover;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private JList<String> list;
	private InputListenerListarAmigosMarioFrame listenerAmigos;
	private JPanel listPanel;
	private JScrollPane scrollPane;

	public ListarAmigosMarioFrame() {
		setTitle("Listar Amigos");
		initialize();
		listenerAmigos = new InputListenerListarAmigosMarioFrame(this);
		inicializarListeners();
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setBounds(125, 243, 89, 23);
		}
		return btnEditar;
	}
	
	private JButton getBtnGerarRelatrio() {
		if (btnGerarRelatrio == null) {
			btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
			btnGerarRelatrio.setBounds(10, 243, 105, 23);
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
			btnRemover.setBounds(224, 243, 89, 23);
		}
		return btnRemover;
	}
	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(323, 243, 89, 23);
		}
		return btnVoltar;
	}
	public JList<String> getList() {
		if (list == null) {
			//DefaultListModel<String> model = new DefaultListModel<String>();
//			model.addElement("YOSHI");
//			model.addElement("LUIGI");
			list = new JList<String>(AmigoDAO.getInstance().getAllAmigos());
			list.setBounds(71, 82, 285, 150);
		}
		return list;
	}
	
	public void refreshList(){
		list.setModel(AmigoDAO.getInstance().getAllAmigos());
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
		getBtnEditar().addActionListener(listenerAmigos);
		getBtnGerarRelatrio().addActionListener(listenerAmigos);
		getBtnRemover().addActionListener(listenerAmigos);
		getBtnVoltar().addActionListener(listenerAmigos);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		new JPanel();
		contentPane_1 = new JBackground("listarAmigos.png");
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		setLocationRelativeTo(null);
		contentPane_1.setLayout(null);
		contentPane_1.add(getBtnGerarRelatrio());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getBtnEditar());
		contentPane_1.add(getBtnRemover());
		contentPane_1.add(getListPanel());
		
	}
}
