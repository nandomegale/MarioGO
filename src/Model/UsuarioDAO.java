package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Control.BancoDeDados;

public class UsuarioDAO {

	private static UsuarioDAO user;

	public static UsuarioDAO getInstance() {
		if (user == null) {
			user = new UsuarioDAO();
		}
		return user;
	}

	private PreparedStatement ps = null;
	private ResultSet resultSet = null;

	public void estaLogado(String usuario) throws SQLException {
		if (BancoDeDados.getInstance().estaConectado()) {
			String sql;
			sql = "INSERT INTO estaLogado (nome) VALUES (?)";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, usuario);
			ps.executeUpdate();
		}
	}

	public void deslogarUsuario() throws SQLException {
		String sql;
		sql = "delete from estaLogado where 1";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.executeUpdate();
	}

	public void cadUsuario(Usuario usuario) throws SQLException {
		if (BancoDeDados.getInstance().estaConectado()) {
			String sql;
			sql = "INSERT INTO LoginUser (login,senha) VALUES (?,?)";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, usuario.getLoginUser().getLogin());
			ps.setString(2, usuario.getLoginUser().getSenha());
			ps.executeUpdate();
			sql = "INSERT INTO Usuario (Nome,Idade,UsuarioHasLoginUser) VALUES "
					+ "(?,?,(SELECT MAX(id) FROM LoginUser))";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setInt(2, usuario.getIdade());
			ps.executeUpdate();
		}
	}

	public void editarUsuario(Usuario usuario, Usuario u) throws SQLException {
		String sql = "UPDATE LoginUser SET Login = ?, Senha = ? WHERE Login = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, usuario.getLoginUser().getLogin());
		ps.setString(2, usuario.getLoginUser().getSenha());
		ps.setString(3, u.getLoginUser().getLogin());
		ps.executeUpdate();
		sql = "UPDATE Usuario SET Nome = ?, Idade = ? WHERE Nome = ? AND Idade = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, usuario.getNome());
		ps.setInt(2, usuario.getIdade());
		ps.setString(3, u.getNome());
		ps.setInt(4, u.getIdade());
		ps.executeUpdate();
	}

	public void deleteUsuario(String login) throws SQLException {
		String sql = "DELETE FROM LoginUser WHERE login = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, login);
		ps.executeUpdate();
	}

	public DefaultListModel<String> getAllUsuarios() { // para listar usuarios
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT Nome, Idade, Login FROM Usuario INNER JOIN"
					+ " LoginUser ON Usuario.UsuarioHasLoginUser = LoginUser.id";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				model.addElement(resultSet.getString("nome") + " " + Integer.toString(resultSet.getInt("idade")) + " "
						+ resultSet.getString("login"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return model;
	}

	public Usuario getUsuario(String login) {
		Usuario u = null;
		try {
			String sql = "SELECT nome, idade, login, senha FROM Usuario INNER JOIN LoginUser ON Usuario.UsuarioHasLoginUser = LoginUser.id WHERE login = ?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, login);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				u = new Usuario();
				LoginUser l = new LoginUser();
				l.setLogin(resultSet.getString("Login"));
				l.setSenha(resultSet.getString("Senha"));
				u.setNome(resultSet.getString("Nome"));
				u.setIdade(resultSet.getInt("Idade"));
				u.setLoginUser(l);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		System.out.println("dssd");
		return u;
	}

	public boolean existeLogin(String login, String senha) {

		if (BancoDeDados.getInstance().estaConectado()) {
			System.out.println("Entrou no existelogin");
			try {
				String query = "SELECT Login,Senha FROM Usuario INNER JOIN LoginUser ON"
						+ " Usuario.UsuarioHasLoginUser = LoginUser.id WHERE login = ? AND Senha = ?";
				ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
				ps.setString(1, login);
				ps.setString(2, senha);
				resultSet = ps.executeQuery();
				while (resultSet.next()) {
					return true;
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return false;
	}
}