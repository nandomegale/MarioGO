package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Inimigo;
import Model.InimigoDAO;
import View.CadastroInimigosMarioFrame;
import View.MenuInimigosMarioFrame;

public class InputListenerCadastroInimigosMarioFrame implements ActionListener {

	private CadastroInimigosMarioFrame cadastroInimigos;

	public InputListenerCadastroInimigosMarioFrame(CadastroInimigosMarioFrame cadastroInimigos) {
		this.cadastroInimigos = cadastroInimigos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroInimigos.dispose();
			new MenuInimigosMarioFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroInimigos.getNomeField().setText(null);
			cadastroInimigos.getHistoriaField().setText(null);
			cadastroInimigos.getNomeField().setText(null);
		} else if (e.getActionCommand().equals("Cadastrar")) {
			Inimigo inimigo = new Inimigo();

			inimigo.setNome(cadastroInimigos.getNomeField().getText());
			inimigo.setHabilidade(cadastroInimigos.getHabilidadeField().getText());
			inimigo.setHistoria(cadastroInimigos.getHistoriaField().getText());

			try {
				InimigoDAO.getInstance().cadInimigo(inimigo);
				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
				cadastroInimigos.dispose();
				new MenuInimigosMarioFrame().setVisible(true);
			} catch (SQLException r) {
				JOptionPane.showMessageDialog(null, r.getMessage());
			}
		}
	}
}