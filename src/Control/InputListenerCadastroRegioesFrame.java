package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Regiao;
import Model.RegiaoDAO;
import View.CadastroRegioesFrame;
import View.MenuRegiõesFrame;

public class InputListenerCadastroRegioesFrame implements ActionListener {

	private CadastroRegioesFrame cadastroRegioes;

	public InputListenerCadastroRegioesFrame(CadastroRegioesFrame cadastroRegioes) {
		this.cadastroRegioes = cadastroRegioes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroRegioes.dispose();
			new MenuRegiõesFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroRegioes.getDescricaoField().setText(null);
			cadastroRegioes.getNomeField().setText(null);
		} else if (e.getActionCommand().equals("Cadastrar")) {
			Regiao regiao = new Regiao();

			regiao.setNome(cadastroRegioes.getNomeField().getText());
			regiao.setDescricao(cadastroRegioes.getDescricaoField().getText());

			try {
				RegiaoDAO.getInstance().cadRegiao(regiao);
				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
				cadastroRegioes.dispose();
				new MenuRegiõesFrame().setVisible(true);
			} catch (SQLException r) {
				JOptionPane.showMessageDialog(null, r.getMessage());
			}
		}
	}
}