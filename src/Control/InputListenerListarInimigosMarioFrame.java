package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Inimigo;
import Model.InimigoDAO;
import View.EditarInimigosMarioFrame;
import View.ListarInimigosMarioFrame;
import View.MenuInimigosMarioFrame;

public class InputListenerListarInimigosMarioFrame implements ActionListener {
	
	private ListarInimigosMarioFrame listarInimigos;

	public InputListenerListarInimigosMarioFrame(ListarInimigosMarioFrame listarInimigos) {
		this.listarInimigos = listarInimigos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			listarInimigos.dispose();  
			new MenuInimigosMarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Remover")){
			if(listarInimigos.getList().getSelectedIndex() != -1){
				String[] campos = listarInimigos.getList().getSelectedValue().split(" ");
				try{
					System.out.println("campos[2] = "+ campos[0]);
					InimigoDAO.getInstance().deleteInimigo(campos[0]);
					listarInimigos.refreshList();
					JOptionPane.showMessageDialog(null, "Deletado!");
				}catch(SQLException r){
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}else JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		}else if(e.getActionCommand().equals("Editar")){
			if(listarInimigos.getList().getSelectedIndex()!= -1){
				String[] campos = listarInimigos.getList().getSelectedValue().split(" ");
				Inimigo i = InimigoDAO.getInstance().getInimigo(campos[0]);
				listarInimigos.dispose();
				new EditarInimigosMarioFrame(i).setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		}else if(e.getActionCommand().equals("Gerar Relatorio")){
			//gerar pdf
		}
	}

}
