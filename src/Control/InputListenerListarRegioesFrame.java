package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Regiao;
import Model.RegiaoDAO;
import View.EditarRegioesFrame;
import View.ListarRegioesFrame;
import View.MenuRegiõesFrame;

public class InputListenerListarRegioesFrame implements ActionListener {
	
	private ListarRegioesFrame listarRegioes;

	public InputListenerListarRegioesFrame(ListarRegioesFrame listarRegioes) {
		this.listarRegioes = listarRegioes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			listarRegioes.dispose();
			new MenuRegiõesFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Remover")){
			if (listarRegioes.getList().getSelectedIndex() != -1) {
				String[] campos = listarRegioes.getList().getSelectedValue().split(" ");
				try {
					System.out.println("campos[2] = " + campos[0]);
					RegiaoDAO.getInstance().deleteRegiao(campos[0]);
					listarRegioes.refreshList();
					JOptionPane.showMessageDialog(null, "Deletado!");
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}else if(e.getActionCommand().equals("Editar")){
			if (listarRegioes.getList().getSelectedIndex() != -1) {
				String[] campos = listarRegioes.getList().getSelectedValue().split(" ");
				Regiao r = RegiaoDAO.getInstance().getRegiao(campos[0]);
				listarRegioes.dispose();
				new EditarRegioesFrame(r).setVisible(true);
			} else
				JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		}else if(e.getActionCommand().equals("Gerar Relatorio")){
			//gerar pdf
		}
	}

}
