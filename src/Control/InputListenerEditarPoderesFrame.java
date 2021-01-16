package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Poder;
import Model.PoderDAO;
import View.EditarPoderesFrame;
import View.MenuPoderesFrame;

public class InputListenerEditarPoderesFrame implements ActionListener {
	
	private EditarPoderesFrame editarPoderes;
	private Poder p;

	public InputListenerEditarPoderesFrame(EditarPoderesFrame editarPoderes,Poder p) {
		this.p = p;
		this.editarPoderes = editarPoderes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			editarPoderes.dispose();
			new MenuPoderesFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Cancelar")){
			editarPoderes.getEfeitoTextArea().setText(null);
			editarPoderes.getNomeTextArea().setText(null);
		}else if(e.getActionCommand().equals("Atualizar")){
			Poder poder = new Poder();
			
			poder.setNome(editarPoderes.getNomeTextArea().getText());
			poder.setEfeito(editarPoderes.getEfeitoTextArea().getText());
			
			try{
				PoderDAO.getInstance().editarPoder(poder,p);
				JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
				editarPoderes.dispose();
				new MenuPoderesFrame().setVisible(true);
			}catch(SQLException r){
				JOptionPane.showMessageDialog(null, r.getMessage());
			}
		}
	}

}
