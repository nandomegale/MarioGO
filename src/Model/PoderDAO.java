package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Control.BancoDeDados;

public class PoderDAO {

	private static PoderDAO poder;

	public static PoderDAO getInstance() {
		if (poder == null) {
			poder = new PoderDAO();
		}
		return poder;
	}

	private PreparedStatement ps = null;
	private ResultSet resultSet = null;

	public void cadPoder(Poder poder) throws SQLException {
		String sql;
		String nome = null;

		sql = "SELECT Nome FROM estaLogado";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		resultSet = ps.executeQuery();

		while (resultSet.next()) {
			nome = resultSet.getString("nome");
		}

		System.out.println("ooooooooooooooooooooooooooo");
		sql = "INSERT INTO Poder (nome,efeito,PoderHasUsuario) VALUES "
				+ "(?,?,(SELECT id FROM mario.loginUser where login = ?))";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, poder.getNome());
		ps.setString(2, poder.getEfeito());
		ps.setString(3, nome);
		ps.executeUpdate();
	}

	public void editarPoder(Poder poder, Poder p) throws SQLException {
		String sql = "UPDATE Poder SET nome = ?, efeito = ? WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, poder.getNome());
		ps.setString(2, poder.getEfeito());
		ps.setString(3, p.getNome());
		ps.executeUpdate();
	}

	public void deletePoder(String nomePoder) throws SQLException {
		String sql = "DELETE FROM Poder WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, nomePoder);
		ps.executeUpdate();
	}

	public DefaultListModel<String> getAllPoderes() { // para listar usuarios
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT Nome, Efeito FROM Poder";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				model.addElement(resultSet.getString("nome") + " " + (resultSet.getString("efeito")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return model;
	}

	public Poder getPoder(String nomePoder) { // pegar amigos para setar
												// inicialmente na tela de
												// editar
		Poder p = null;
		try {
			String sql = "SELECT Nome, Efeito FROM Poder where nome = ?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, nomePoder);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				p = new Poder();
				p.setNome(resultSet.getString("nome"));
				p.setEfeito(resultSet.getString("efeito"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return p;
	}

	// implementacao futura -- nao cadastrar dois amigos iguais
	// public boolean existeLogin(String login, String senha){
	//
	// if(BancoDeDados.getInstance().estaConectado()){
	// System.out.println("Entrou no existelogin");
	// try{
	// String query = "SELECT Login,Senha FROM Usuario INNER JOIN LoginUser ON"
	// +" Usuario.UsuarioHasLoginUser = LoginUser.id WHERE login = ? AND Senha =
	// ?";
	// ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
	// ps.setString(1,login);
	// ps.setString(2, senha);
	// resultSet = ps.executeQuery();
	// while(resultSet.next()){
	// return true;
	// }
	// }catch(SQLException e){
	// JOptionPane.showMessageDialog(null,
	// e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	// }
	// }return false;
	// }

}
