package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Amigo;
import Model.AmigoDAO;
import View.EditarAmigosMarioFrame;
import View.MenuAmigosDoMarioFrame;

public class InputListenerEditarAmigosMarioFrame implements ActionListener {

	private EditarAmigosMarioFrame editarAmigos;
	private Amigo a;

	public InputListenerEditarAmigosMarioFrame(EditarAmigosMarioFrame editarAmigos, Amigo a) {
		this.editarAmigos = editarAmigos;
		this.a = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			editarAmigos.dispose();
			new MenuAmigosDoMarioFrame().setVisible(true);

		} else if (e.getActionCommand().equals("Cancelar")) {
			editarAmigos.getHabilidadetextArea().setText(null);
			editarAmigos.getHistoriaTextArea().setText(null);
			editarAmigos.getNomeTextArea().setText(null);

		} else if (e.getActionCommand().equals("Atualizar")) {
			Amigo amigo = new Amigo();

			amigo.setNome(editarAmigos.getNomeTextArea().getText());
			amigo.setHabilidade(editarAmigos.getHabilidadetextArea().getText());
			amigo.setHistoria(editarAmigos.getHistoriaTextArea().getText());
			amigo.setHabilidade(editarAmigos.getHabilidadetextArea().getText());

			try {
				AmigoDAO.getInstance().editarAmigo(amigo, a);
				JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
				editarAmigos.dispose();
				new MenuAmigosDoMarioFrame().setVisible(true);
			} catch (SQLException r) {
				JOptionPane.showMessageDialog(null, r.getMessage());
			}
		}
	}
}