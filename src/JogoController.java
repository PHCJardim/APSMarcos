import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class JogoController {
	private JogoView view = new JogoView();;
	
	JogoController(){
		try{		
			view.setJogo();
			view.iniciaListenner(new Inicia());
		}
		catch (Exception err){
			System.out.println(err.getMessage());
		}
	}
	
	
	class Inicia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			try{
				view.iniciar();
			}
			catch (Exception erro ){
				System.out.println(erro.getMessage());
			}
		}
	}
	
}
