package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Amigo;
import Model.AmigoDAO;
import View.EditarAmigosMarioFrame;
import View.ListarAmigosMarioFrame;
import View.MenuAmigosDoMarioFrame;

public class InputListenerListarAmigosMarioFrame implements ActionListener {
	
	private ListarAmigosMarioFrame listarAmigos;

	public InputListenerListarAmigosMarioFrame(ListarAmigosMarioFrame listarAmigos) {
		this.listarAmigos = listarAmigos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			listarAmigos.dispose();  
			new MenuAmigosDoMarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Remover")){
			
			if(listarAmigos.getList().getSelectedIndex() != -1){
				String[] campos = listarAmigos.getList().getSelectedValue().split(" ");
				try{
					System.out.println("campos[2] = "+ campos[0]);
					AmigoDAO.getInstance().deleteAmigos(campos[0]);
					listarAmigos.refreshList();
					JOptionPane.showMessageDialog(null, "Deletado!");
				}catch(SQLException r){
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}else JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");

			
		}else if(e.getActionCommand().equals("Editar")){
			
			if(listarAmigos.getList().getSelectedIndex()!= -1){
				String[] campos = listarAmigos.getList().getSelectedValue().split(" ");
				Amigo a = AmigoDAO.getInstance().getAmigo(campos[0]);
				listarAmigos.dispose();
				new EditarAmigosMarioFrame(a).setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");

		}else if(e.getActionCommand().equals("Gerar Relatorio")){
			//gerar pdf
		}
	}

}
