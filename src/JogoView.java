import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JogoView extends JFrame {
	
	 	private JLabel introLabel;
	    private JTabbedPane painelPrincipal;
	    private JMenu btnSair;
	    private JMenuBar barraMenu;
	    private JPanel painelIntro;
	    private JButton btnJogar;
	    private JLabel textoIntro;
	    private JogoModel[] partida;
	    private int partidaAtual;
	    private long tInicio;
	    private long tFim;
	    private JPanel painelFase;
	    private JPanel areaRonaldinho;
	    private JLabel fotoRonaldinho;
	    private PartidaDAO partidaDao;

	    public void setJogo(){
	    	try{
	    		partidaAtual = 1;
		        partida = new JogoModel[10];
		        painelPrincipal = new JTabbedPane();
		        painelIntro = new JPanel();
		        introLabel = new JLabel();
		        barraMenu = new JMenuBar();
		        btnSair = new JMenu();
		        btnJogar = new JButton();
		        textoIntro = new JLabel("<html>Encontre o Ronaldinho Gaucho <br>  pelos roles  no decorreder <br> da historia da humanidade. Quando encontrar o jogador,  <br>clique com o  mouse  <br>sobre sua cara para pontuar!");
		        

		        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        setMaximumSize(new Dimension(500, 500));
		        setMinimumSize(new Dimension(500, 500));
		        setResizable(false);

		        painelIntro.setBackground(SystemColor.activeCaptionBorder);
		        painelPrincipal.setMaximumSize(new Dimension(500, 500));
		        painelPrincipal.setMinimumSize(new Dimension(500, 500));

		        btnJogar.setText("Iniciar");
		        
		        GroupLayout painelIntroLayout = new GroupLayout(painelIntro);
		        painelIntro.setLayout(painelIntroLayout);
		        painelIntroLayout.setHorizontalGroup(
		            painelIntroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(painelIntroLayout.createSequentialGroup()
		                .addContainerGap()
		                .addComponent(textoIntro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                .addGap(117, 377, Short.MAX_VALUE))
		            .addGroup(GroupLayout.Alignment.TRAILING, painelIntroLayout.createSequentialGroup()
		                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(btnJogar)
		                .addGap(188, 188, 188))
		        );

		        painelIntroLayout.setVerticalGroup(
		            painelIntroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(painelIntroLayout.createSequentialGroup()
		                .addGap(83, 83, 83)
		                .addComponent(textoIntro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                .addGap(81, 81, 81)
		                .addComponent(btnJogar)
		                .addContainerGap(250, Short.MAX_VALUE))
		        );

		        btnSair.setText("Sair");
		        btnSair.addMouseListener(new MouseAdapter() {
		            public void mouseClicked(MouseEvent evt) {
		                System.exit(0);
		            }
		        });
		        barraMenu.add(btnSair);
		        
		        setJMenuBar(barraMenu);

		        
		        painelPrincipal.addTab("Sobre", painelIntro);
		        
		        GroupLayout layout = new GroupLayout(getContentPane());
		        getContentPane().setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addComponent(painelPrincipal, GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addComponent(painelPrincipal, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
		        );

		        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		        this.pack();
		        this.setVisible(true);
		        String t = "Role com Ronaldinho";
		        this.setTitle(t);
	    	}
	    	catch (Exception err){
	    		System.out.println(err.getMessage());
	    	}
	        
	    }   
	    
	    void iniciaListenner(ActionListener begin){
    	   btnJogar.addActionListener(begin);
       }
	   
 
	    
	    void novoNivel(){
	        if(partidaAtual == 2){
	            fotoRonaldinho.setIcon(new StretchIcon("fases/fase2.jpg", false));
	            fotoRonaldinho.setHorizontalAlignment(SwingConstants.CENTER);
	            fotoRonaldinho.setBounds(1, 6, 610, 460);
	            areaRonaldinho.setBounds(390, 160, 120, 70);
	        }else if(partidaAtual == 3){
	            fotoRonaldinho.setIcon(new StretchIcon("fases/fase3.jpg", false));
	            fotoRonaldinho.setHorizontalAlignment(SwingConstants.RIGHT);
	            fotoRonaldinho.setBounds(1, 6, 510, 460);
	            areaRonaldinho.setBounds(462, 140, 120, 70);
	        }else if(partidaAtual == 4){
	            fotoRonaldinho.setIcon( new StretchIcon("fases/fase4.jpg", false) );
	            fotoRonaldinho.setHorizontalAlignment(SwingConstants.CENTER);
	            fotoRonaldinho.setBounds(1, 15, 510, 460);
	            areaRonaldinho.setBounds(135, 320, 70, 70);
	        }else if(partidaAtual == 5){
	            fotoRonaldinho.setIcon( new StretchIcon("fases/fase5.jpg", false) );
	            fotoRonaldinho.setHorizontalAlignment(SwingConstants.CENTER);
	            fotoRonaldinho.setBounds(1, 15, 510, 460);
	            areaRonaldinho.setBounds(335, 170, 50, 70);
	        }else if(partidaAtual == 6){
	            fotoRonaldinho.setIcon( new StretchIcon("fases/fase6.jpg", false) );
	            fotoRonaldinho.setHorizontalAlignment(SwingConstants.CENTER);
	            fotoRonaldinho.setBounds(1, 15, 510, 460);
	            areaRonaldinho.setBounds(279, 40, 50, 70);
	        }else if(partidaAtual == 7){
	            fotoRonaldinho.setIcon( new StretchIcon("fases/fase7.jpg", false) );
	            fotoRonaldinho.setHorizontalAlignment(SwingConstants.CENTER);
	            fotoRonaldinho.setBounds(1, 15, 510, 460);
	            areaRonaldinho.setBounds(390, 100, 50, 70);
	        }else if(partidaAtual == 8){
	            painelPrincipal.setSelectedIndex(0);
	            textoIntro.setText("<html>Sucesso!! <br> Veja como você se saiu e <b>cadastre sua pontuação</b>, clicando aqui!!<html>");
	            btnJogar.setEnabled(false);
	            painelPrincipal.setEnabledAt(1, false);
	            textoIntro.addMouseListener(new MouseAdapter() {
	                public void mouseClicked(MouseEvent evt) {
	                    for (int i = 0; i <= 6; i++) {
	                        JOptionPane.showMessageDialog(null, "<html>Fase: "+partida[i].getFase()+" <br> Tempo levado: "+partida[i].getDuracao()+"ms <br> Erros: "+partida[i].getErros()+" ");
	                    }
	                    String nome = JOptionPane.showInputDialog("Registre seu tempo", "Qual seu nome?");
	                    partidaDao = new PartidaDAO();
	                    if(nome != null){
	                    	if(nome == "")
	                    		nome = "jogador";
	                    	
	                    	partidaDao.insere(partida, nome);
	                    }
	                    
	                    ResultSet resp = partidaDao.buscarTodos();
	                    try {
	                    	textoIntro.setText("<html><p>Nome / Tempo / Erros</p><ol>");
							while(resp.next()){
								textoIntro.setText(textoIntro.getText()+"<li> "+resp.getString("nome")+" / "+resp.getString("tempo")+"ms / "+resp.getString("qtd_erros")+"");
							}
							textoIntro.setText(textoIntro.getText()+"</ol> </html>");
						} catch (SQLException e) {
							e.printStackTrace();
						}
	                }
	            });
	            
	        }
	    }

	    
	    void iniciar() {

	        painelFase = new JPanel();
	        areaRonaldinho = new JPanel();
	        fotoRonaldinho = new JLabel();
	        tInicio = System.currentTimeMillis();
	        for (int i = 0; i < partida.length; i++) 
	        partida[i] = new JogoModel((i+1), 0, 0);

	        fotoRonaldinho.setIcon(new ImageIcon("fases/fase1.jpg"));

	        painelFase.setLayout(null);

	        painelFase.add(fotoRonaldinho);
	        fotoRonaldinho.setBounds(1, 6, 610, 460);

	        areaRonaldinho.setBackground(SystemColor.activeCaptionText);

	        GroupLayout areaRonaldinhoLayout = new GroupLayout(areaRonaldinho);
	        areaRonaldinho.setLayout(areaRonaldinhoLayout);
	        areaRonaldinhoLayout.setHorizontalGroup(
	            areaRonaldinhoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 120, Short.MAX_VALUE)
	        );
	        areaRonaldinhoLayout.setVerticalGroup(
	            areaRonaldinhoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 130, Short.MAX_VALUE)
	        );

	        painelFase.add(areaRonaldinho);
	        areaRonaldinho.setBounds(50, 90, 90, 120);

	        areaRonaldinho.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                int x=e.getX();
	                int y=e.getY();
	                System.out.println(x+","+y);//these co-ords are relative to the component
	                acertou();
	                JOptionPane.showMessageDialog(null,"Dibraaadoo!");

	            }
	        });

	        painelFase.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                int x=e.getX();
	                int y=e.getY();
	                System.out.println(x+","+y);//these co-ords are relative to the component
	                errou();
	                JOptionPane.showMessageDialog(null,"Errou");
	            }
	        });
	        
	        
	        painelPrincipal.addTab("Encontre!", painelFase);
	        painelPrincipal.setSelectedIndex(partidaAtual);
	    } 
	    
	    void acertou(){
	        tFim = System.currentTimeMillis();
	        if(partidaAtual > 1){
	            partida[partidaAtual-1].setDuracao((tFim - tInicio));
	        } 
	        else if(partidaAtual == 1){
	            partida[0].setDuracao((tFim - tInicio));
	        }
	        partidaAtual++;
	        tFim = 0;
	        novoNivel();
	    }

	    void errou(){
	        if(partidaAtual > 1){
	            int erros = partida[partidaAtual - 1].getErros();
	            partida[partidaAtual - 1].setErros(erros+1);
	        } 
	        else if(partidaAtual == 1){
	            partida[0].setErros(partida[0].getErros()+1);
	        }
	    }
}
