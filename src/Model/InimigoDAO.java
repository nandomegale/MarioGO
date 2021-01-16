package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Control.BancoDeDados;

public class InimigoDAO {
	private static InimigoDAO inimigo;

	public static InimigoDAO getInstance() {
		if (inimigo == null) {
			inimigo = new InimigoDAO();
		}
		return inimigo;
	}

	private PreparedStatement ps = null;
	private ResultSet resultSet = null;

	public void cadInimigo(Inimigo inimigo) throws SQLException {
		String sql;
		String nome = null;

		sql = "SELECT Nome FROM estaLogado";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		resultSet = ps.executeQuery();

		while (resultSet.next()) {
			nome = resultSet.getString("nome");
		}

		sql = "INSERT INTO Inimigo (nome,habilidade,historia,InimigoHasUsuario) VALUES "
				+ "(?,?,?,(SELECT id FROM mario.loginUser where login = ?))";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, inimigo.getNome());
		ps.setString(2, inimigo.getHabilidade());
		ps.setString(3, inimigo.getHistoria());
		ps.setString(4, nome);
		ps.executeUpdate();
	}

	public void editarInimigo(Inimigo inimigo, Inimigo i) throws SQLException {
		String sql = "UPDATE Inimigo SET nome = ?, habilidade = ?, historia = ? WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, inimigo.getNome());
		ps.setString(2, inimigo.getHabilidade());
		ps.setString(3, inimigo.getHistoria());
		ps.setString(4, i.getNome());
		ps.executeUpdate();
	}

	public void deleteInimigo(String nomeInimigo) throws SQLException {
		String sql = "DELETE FROM Inimigo WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, nomeInimigo);
		System.out.println(nomeInimigo);
		ps.executeUpdate();
	}

	public DefaultListModel<String> getAllInimigos() { // para listar usuarios
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT Nome, Historia, Habilidade FROM Inimigo";
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

	public Inimigo getInimigo(String nomeInimigo) { // pegar amigos para setar
													// inicialmente na tela de
													// editar
		Inimigo i = null;
		try {
			String sql = "SELECT Nome, Historia, Habilidade FROM Inimigo where nome = ?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, nomeInimigo);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				i = new Inimigo();
				i.setNome(resultSet.getString("nome"));
				i.setHistoria(resultSet.getString("historia"));
				i.setHabilidade(resultSet.getString("habilidade"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return i;
	}
}
