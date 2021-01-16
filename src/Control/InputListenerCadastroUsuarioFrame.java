package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.LoginUser;
import Model.Usuario;
import Model.UsuarioDAO;
import View.CadastroUsuarioFrame;
import View.MenuAdminFrame;

public class InputListenerCadastroUsuarioFrame implements ActionListener {

	private CadastroUsuarioFrame cadastroUsuario;

	public InputListenerCadastroUsuarioFrame(CadastroUsuarioFrame cadastroUsuario) {
		this.cadastroUsuario = cadastroUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroUsuario.dispose();
			new MenuAdminFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroUsuario.getNomeField().setText(null);
			cadastroUsuario.getIdadeField().setText(null);
		} else if (e.getActionCommand().equals("Cadastrar")) {
			if (cadastroUsuario.getNomeField().getText().equals("")
					|| cadastroUsuario.getSenhaField_1().getText().equals("")
					|| cadastroUsuario.getIdadeField().getText().equals("")
					|| cadastroUsuario.getLoginField().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (UsuarioDAO.getInstance().existeLogin(cadastroUsuario.getLoginField().getText(),
					cadastroUsuario.getSenhaField_1().getText())) {
				JOptionPane.showMessageDialog(null, "Usuario e Senha ja Cadastrados!!");
				cadastroUsuario.getNomeField().setText(null);
				cadastroUsuario.getSenhaField_1().setText(null);
				cadastroUsuario.getLoginField().setText(null);
				cadastroUsuario.getIdadeField().setText(null);
				return;
			} else {
				LoginUser loginUser = new LoginUser();
				loginUser.setLogin(cadastroUsuario.getLoginField().getText());
				loginUser.setSenha(cadastroUsuario.getSenhaField_1().getText());

				Usuario usuario = new Usuario();

				try {
					usuario.setNome(cadastroUsuario.getNomeField().getText());
					usuario.setIdade(Integer.parseInt(cadastroUsuario.getIdadeField().getText()));
					usuario.setLoginUser(loginUser);

					UsuarioDAO.getInstance().cadUsuario(usuario);
					System.out.println("Where am I?");
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					cadastroUsuario.dispose();
					new MenuAdminFrame().setVisible(true);

				} catch (NumberFormatException y) {
					JOptionPane.showMessageDialog(null, "Insira um inteiro no campo Idade!", "Erro!",
							JOptionPane.ERROR_MESSAGE);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}

	}
}