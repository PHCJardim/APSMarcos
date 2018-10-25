import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import sun.audio.*;

public class MenuView extends JFrame{
	
		private JButton btnJogar;
	    private JButton btnSair;
	    private JLabel background;   
	
		public MenuView() {
	       initComponents();
	   }
		
		public void some() {   
	        this.setVisible(false);
	    }                                        

	    private void sair(ActionEvent evt) {    
	        System.exit(0);
	    }
	   
		void music(){
	       try
	       {
	           String filename = "Musica/musicaJogo.wav";
	           AudioPlayer aPlayer = AudioPlayer.player;
	           AudioStream aStream;
	           ContinuousAudioDataStream loop = null;
	           InputStream test = new FileInputStream(filename);
	           aStream = new AudioStream(test);
	           AudioPlayer.player.start(aStream);
	           aPlayer.start(loop);
	       }
	       catch(Exception e){
	           System.out.print(e.getMessage());
	       }
		       
	   }
		
	   private void initComponents() {

	       btnJogar = new JButton();
	       btnSair = new JButton();
	       background = new JLabel();

	       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	       setBackground(UIManager.getDefaults().getColor("Button.disabledForeground"));

	       setMaximumSize(new Dimension(500, 500));
	       setMinimumSize(new Dimension(500, 500));
	       setResizable(false);
	       getContentPane().setLayout(null);
	       btnJogar.setText("Jogar");
	       
	       getContentPane().add(btnJogar);
	       btnJogar.setBounds(160, 170, 190, 45);
	       btnSair.setText("Sair");
	       
	       getContentPane().add(btnSair);
	       btnSair.setBounds(160, 250, 190, 47);

	       background.setIcon(new ImageIcon("C:\\Users\\pedro\\Pictures\\ronaldinho_gaucho.png")); // NOI18N
	       getContentPane().add(background);
	       background.setBounds(0, 0, 560, 500);

	       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	       setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	       setVisible(true);
	       setTitle("Role com Ronaldinho");
	       pack();
	       music();
	   }  
	   
	   void jogaListenner(ActionListener jg){
    	   btnJogar.addActionListener(jg);
       }
	   
	   void sairListenner(ActionListener ext){
		   btnSair.addActionListener(ext);
       }
}
