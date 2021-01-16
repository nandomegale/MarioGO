package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Usuario;
import Model.UsuarioDAO;
import View.EditarUsuarioFrame;
import View.ListarUsuarioFrame;
import View.MenuAdminFrame;

public class InputListenerListarUsuarioFrame implements ActionListener {
	
	private ListarUsuarioFrame listarUsuario;

	public InputListenerListarUsuarioFrame(ListarUsuarioFrame listarUsuario) {
		this.listarUsuario = listarUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			listarUsuario.dispose();  
			new MenuAdminFrame().setVisible(true);
		
		}else if(e.getActionCommand().equals("Remover")){
			if(listarUsuario.getList().getSelectedIndex() != -1){
				String[] campos = listarUsuario.getList().getSelectedValue().split(" ");
				try{
					UsuarioDAO.getInstance().deleteUsuario(campos[2]);
					listarUsuario.refreshList();
					JOptionPane.showMessageDialog(null, "Deletado!");
				}catch(SQLException r){
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}else JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		
		}else if(e.getActionCommand().equals("Editar")){
			if(listarUsuario.getList().getSelectedIndex()!= -1){
				String[] campos = listarUsuario.getList().getSelectedValue().split(" ");
				Usuario u = UsuarioDAO.getInstance().getUsuario(campos[2]);
				listarUsuario.dispose();
				new EditarUsuarioFrame(u).setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		}else if(e.getActionCommand().equals("Gerar Relatorio")){
			//gerar pdf
		}
	}

}
