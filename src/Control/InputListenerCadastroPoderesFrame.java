package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Poder;
import Model.PoderDAO;
import View.CadastroPoderesFrame;
import View.MenuPoderesFrame;

public class InputListenerCadastroPoderesFrame implements ActionListener {

	private CadastroPoderesFrame cadastroPoderes;

	public InputListenerCadastroPoderesFrame(CadastroPoderesFrame cadastroPoderes) {
		this.cadastroPoderes = cadastroPoderes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroPoderes.dispose();
			new MenuPoderesFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroPoderes.getNomeField().setText(null);
			cadastroPoderes.getEfeitoField().setText(null);
		} else if (e.getActionCommand().equals("Cadastrar")) {
			Poder poder = new Poder();

			poder.setNome(cadastroPoderes.getNomeField().getText());
			poder.setEfeito(cadastroPoderes.getEfeitoField().getText());

			try {
				PoderDAO.getInstance().cadPoder(poder);
				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
				cadastroPoderes.dispose();
				new MenuPoderesFrame().setVisible(true);
			} catch (SQLException r) {
				JOptionPane.showMessageDialog(null, r.getMessage());
			}
		}
	}
}