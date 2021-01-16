package Control;

import javax.swing.JOptionPane;

import View.BemVindoFrame;

public class Runner {
	public static void main(String[] args) {
		BancoDeDados.getInstance().conectar();
		
		if(BancoDeDados.getInstance().estaConectado()){
			BemVindoFrame bvf = new BemVindoFrame();
			bvf.setVisible(true);
			System.out.println("OI");
		}else JOptionPane.showMessageDialog(null, "Banco de Dados desconctao!");		
	}
}