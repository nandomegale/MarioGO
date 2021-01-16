package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Inimigo;
import Model.InimigoDAO;
import View.EditarInimigosMarioFrame;
import View.MenuInimigosMarioFrame;

public class InputListenerEditarInimigosMarioFrame implements ActionListener {
	
	private EditarInimigosMarioFrame editarInimigos;
	private Inimigo i;

	public InputListenerEditarInimigosMarioFrame(EditarInimigosMarioFrame editarInimigos, Inimigo i) {
		this.i = i;
		this.editarInimigos = editarInimigos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			editarInimigos.dispose();  
			new MenuInimigosMarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Cancelar")){
			editarInimigos.getHabilidadetextArea().setText(null);
			editarInimigos.getHistoriaTextArea().setText(null);
			editarInimigos.getNomeTextArea().setText(null);
		}else if(e.getActionCommand().equals("Atualizar")){
			Inimigo inimigo = new Inimigo();
			
			inimigo.setNome(editarInimigos.getNomeTextArea().getText());
			inimigo.setHabilidade(editarInimigos.getHabilidadetextArea().getText());
			inimigo.setHistoria(editarInimigos.getHistoriaTextArea().getText());
			
			try{
				InimigoDAO.getInstance().editarInimigo(inimigo,i);
				JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
				editarInimigos.dispose();
				new MenuInimigosMarioFrame().setVisible(true);
			}catch(SQLException r){
				JOptionPane.showMessageDialog(null, r.getMessage());
			}
		}
	}

}
