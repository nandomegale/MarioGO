package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Poder;
import Model.PoderDAO;
import View.EditarPoderesFrame;
import View.ListarPoderesFrame;
import View.MenuPoderesFrame;

public class InputListenerListarPoderesFrame implements ActionListener {

	private ListarPoderesFrame listarPoderes;

	public InputListenerListarPoderesFrame(ListarPoderesFrame listarPoderes) {
		this.listarPoderes = listarPoderes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			listarPoderes.dispose();
			new MenuPoderesFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Remover")) {
			if (listarPoderes.getList().getSelectedIndex() != -1) {
				String[] campos = listarPoderes.getList().getSelectedValue().split(" ");
				try {
					System.out.println("campos[2] = " + campos[0]);
					PoderDAO.getInstance().deletePoder(campos[0]);
					listarPoderes.refreshList();
					JOptionPane.showMessageDialog(null, "Deletado!");
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		} else if (e.getActionCommand().equals("Editar")) {
			if (listarPoderes.getList().getSelectedIndex() != -1) {
				String[] campos = listarPoderes.getList().getSelectedValue().split(" ");
				Poder p = PoderDAO.getInstance().getPoder(campos[0]);
				listarPoderes.dispose();
				new EditarPoderesFrame(p).setVisible(true);
			} else
				JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		} else if (e.getActionCommand().equals("Gerar_Relatório")) {
			System.out.println("entrei no pdf");
		}
	}
}
