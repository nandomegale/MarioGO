package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Regiao;
import Model.RegiaoDAO;
import View.EditarRegioesFrame;
import View.MenuRegi�esFrame;

public class InputListenerEditarRegioesFrame implements ActionListener {

	private EditarRegioesFrame editarRegioes;
	private Regiao r;

	public InputListenerEditarRegioesFrame(EditarRegioesFrame editarRegioes, Regiao r) {
		this.editarRegioes = editarRegioes;
		this.r = r;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			editarRegioes.dispose();
			new MenuRegi�esFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			editarRegioes.getDescricaoTextArea().setText(null);
			editarRegioes.getNomeTextArea().setText(null);
		} else if (e.getActionCommand().equals("Atualizar")) {
			Regiao regiao = new Regiao();

			regiao.setNome(editarRegioes.getNomeTextArea().getText());
			regiao.setDescricao(editarRegioes.getDescricaoTextArea().getText());

			try {
				RegiaoDAO.getInstance().editarRegiao(regiao, r);
				JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
				editarRegioes.dispose();
				new MenuRegi�esFrame().setVisible(true);
			} catch (SQLException r) {
				JOptionPane.showMessageDialog(null, r.getMessage());
			}
		}
	}

}
