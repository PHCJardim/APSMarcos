import javax.swing.UIManager;

public class Principal {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			try {
		           for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		               if ("Nimbus".equals(info.getName())) {
		                   UIManager.setLookAndFeel(info.getClassName());
		                   break;
		               }
		           }
		           
		           MenuView menuView = new MenuView();
		           MenuModel menuModel = new MenuModel();
		           MenuController menuController = new MenuController(menuModel, menuView);
		           
		       } catch (Exception ex) {
		           System.out.println(ex.getMessage());
		}
	
	}
}