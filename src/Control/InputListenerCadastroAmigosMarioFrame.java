package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Amigo;
import Model.AmigoDAO;
import View.CadastroAmigosMarioFrame;
import View.MenuAmigosDoMarioFrame;

public class InputListenerCadastroAmigosMarioFrame implements ActionListener {

	private CadastroAmigosMarioFrame cadastroAmigos;

	public InputListenerCadastroAmigosMarioFrame(CadastroAmigosMarioFrame cadastroAmigos) {
		this.cadastroAmigos = cadastroAmigos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroAmigos.dispose();
			new MenuAmigosDoMarioFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroAmigos.getNomeField().setText(null);
			cadastroAmigos.getHistoriaField().setText(null);
			cadastroAmigos.getHabilidadeField().setText(null);
		} else if (e.getActionCommand().equals("Cadastrar")) {
			Amigo amigo = new Amigo();

			amigo.setNome(cadastroAmigos.getNomeField().getText());
			amigo.setHabilidade(cadastroAmigos.getHabilidadeField().getText());
			amigo.setHistoria(cadastroAmigos.getHistoriaField().getText());

			try {
				AmigoDAO.getInstance().cadAmigo(amigo);
				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
				cadastroAmigos.dispose();
				new MenuAmigosDoMarioFrame().setVisible(true);
			} catch (SQLException r) {
				JOptionPane.showMessageDialog(null, r.getMessage());
			}
		}
	}
}