package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Control.BancoDeDados;

public class RegiaoDAO {
	private static RegiaoDAO regiao;

	public static RegiaoDAO getInstance() {
		if (regiao == null) {
			regiao = new RegiaoDAO();
		}
		return regiao;
	}

	private PreparedStatement ps = null;
	private ResultSet resultSet = null;

	public void cadRegiao(Regiao regiao) throws SQLException {
		String sql;
		String nome = null;

		sql = "SELECT Nome FROM estaLogado";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		resultSet = ps.executeQuery();

		while (resultSet.next()) {
			nome = resultSet.getString("nome");
		}

		System.out.println("ooooooooooooooooooooooooooo");
		sql = "INSERT INTO Regiao (nome,descricao,RegiaoHasUsuario) VALUES "
				+ "(?,?,(SELECT id FROM mario.loginUser where login = ?))";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, regiao.getNome());
		ps.setString(2, regiao.getDescricao());
		ps.setString(3, nome);
		ps.executeUpdate();
	}

	public void editarRegiao(Regiao regiao, Regiao r) throws SQLException {
		String sql = "UPDATE Regiao SET nome = ?, descricao = ? WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, regiao.getNome());
		ps.setString(2, regiao.getDescricao());
		ps.setString(3, r.getNome());
		ps.executeUpdate();
	}

	public void deleteRegiao(String nomeRegiao) throws SQLException {
		String sql = "DELETE FROM Regiao WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, nomeRegiao);
		ps.executeUpdate();
	}

	public DefaultListModel<String> getAllRegioes() { // para listar usuarios
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT Nome, Descricao FROM Regiao";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				model.addElement(resultSet.getString("nome") + " " + (resultSet.getString("descricao")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return model;
	}

	public Regiao getRegiao(String nomeRegiao) { // pegar amigos para setar
													// inicialmente na tela de
													// editar
		Regiao r = null;
		try {
			String sql = "SELECT Nome, Descricao FROM Regiao where nome = ?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, nomeRegiao);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				r = new Regiao();
				r.setNome(resultSet.getString("nome"));
				r.setDescricao(resultSet.getString("descricao"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
		return r;
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
