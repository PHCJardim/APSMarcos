import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
	
	private MenuModel model;
	private MenuView view;
	
	MenuController(MenuModel modelo, MenuView visao){
		model = modelo;
		view = visao;
		view.jogaListenner(new Joga());
		view.sairListenner(new Sair());
	}
	
	class Joga implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			try{
				view.some();
				JogoController jogoController = new JogoController();
			}
			catch (Exception erro ){
				System.out.println(erro.getMessage());
			}
		}
	}
	
	class Sair implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			try{
				System.exit(0);
				
			}
			catch (Exception erro ){
				System.out.println(erro.getMessage());
			}
		}
	}
	
}

