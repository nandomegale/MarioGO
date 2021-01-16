package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Control.BancoDeDados;

public class AmigoDAO {

	private static AmigoDAO amigo;

	public static AmigoDAO getInstance() {
		if (amigo == null) {
			amigo = new AmigoDAO();
		}
		return amigo;
	}

	private PreparedStatement ps = null;
	private ResultSet resultSet = null;

	public void cadAmigo(Amigo amigo) throws SQLException {
		String sql;
		String nome = null;

		sql = "SELECT Nome FROM estaLogado";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		resultSet = ps.executeQuery();

		while (resultSet.next()) {
			nome = resultSet.getString("nome");
		}

		sql = "INSERT INTO Amigo (nome,habilidade,historia,AmigoHasUsuario) VALUES "
				+ "(?,?,?,(SELECT id FROM mario.loginUser where login = ?))";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, amigo.getNome());
		ps.setString(2, amigo.getHabilidade());
		ps.setString(3, amigo.getHistoria());
		ps.setString(4, nome);
		ps.executeUpdate();
	}

	public void editarAmigo(Amigo amigo, Amigo a) throws SQLException {
		String sql = "UPDATE Amigo SET nome = ?, habilidade = ?, historia = ? WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, amigo.getNome());
		ps.setString(2, amigo.getHabilidade());
		ps.setString(3, amigo.getHistoria());
		ps.setString(4, a.getNome());
		ps.executeUpdate();
	}

	public void deleteAmigos(String nomeAmigo) throws SQLException {
		String sql = "DELETE FROM Amigo WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, nomeAmigo);
		ps.executeUpdate();
	}

	public DefaultListModel<String> getAllAmigos() { // para listar usuarios
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT Nome, Historia, Habilidade FROM Amigo";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				model.addElement(resultSet.getString("nome") + " " + (resultSet.getString("historia")) + " "
						+ resultSet.getString("habilidade"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return model;
	}

	public Amigo getAmigo(String nome) { // pegar amigos para setar inicialmente
											// na tela de editar
		Amigo a = null;
		try {
			String sql = "SELECT Nome, Historia, Habilidade FROM Amigo where nome = ?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				a = new Amigo();
				a.setNome(resultSet.getString("nome"));
				a.setHistoria(resultSet.getString("historia"));
				a.setHabilidade(resultSet.getString("habilidade"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return a;
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
