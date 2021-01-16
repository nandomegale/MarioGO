package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.LoginUser;
import Model.Usuario;
import Model.UsuarioDAO;
import View.EditarUsuarioFrame;
import View.MenuAdminFrame;

public class InputListenerEditarUsuarioFrame implements ActionListener {

	private EditarUsuarioFrame editarUsuario;
	private Usuario u;

	public InputListenerEditarUsuarioFrame(EditarUsuarioFrame editarUsuario, Usuario u) {
		this.editarUsuario = editarUsuario;
		this.u = u;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			editarUsuario.dispose();
			new MenuAdminFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			editarUsuario.getNomeTextArea().setText(null);
			editarUsuario.getSenhaTextArea().setText(null);
			editarUsuario.getLoginTextArea().setText(null);
			editarUsuario.getIdadeField().setText(null);
		} else if (e.getActionCommand().equals("Atualizar")) {

			LoginUser loginUser = new LoginUser();
			loginUser.setLogin(editarUsuario.getLoginTextArea().getText());
			loginUser.setSenha(editarUsuario.getSenhaTextArea().getText());

			Usuario usuario = new Usuario();

			usuario.setNome(editarUsuario.getNomeTextArea().getText());
			usuario.setIdade(Integer.parseInt(editarUsuario.getIdadeField().getText()));
			usuario.setLoginUser(loginUser);

			try {
				UsuarioDAO.getInstance().editarUsuario(usuario, u);
				JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
				editarUsuario.dispose();
				new MenuAdminFrame().setVisible(true);
			} catch (SQLException r) {
				JOptionPane.showMessageDialog(null, r.getMessage());
			}
		}
	}

}
