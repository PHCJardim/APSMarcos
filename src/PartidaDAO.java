import java.sql.*;   
import javax.swing.JOptionPane; 
public class PartidaDAO {   
	
   private final String URL = "jdbc:postgresql://localhost/aps4sem", NOME = "postgres", SENHA = "060898";   
  
   private Connection con;   
   private Statement comando;   
  
   public void insere(JogoModel[] partida, String nome){   
      conectar();   
      try {   
    	  long tempoLevado = 0;
    	  int qtdErros = 0;
    	  for (int i = 0; i <= 6; i++) {
    		  tempoLevado += partida[i].getDuracao();
    		  qtdErros += partida[i].getErros();
          }
         comando.executeUpdate("INSERT INTO ranking (nome,tempo, qtd_erros) VALUES('"  
               + nome + "', " + tempoLevado + ", '"+qtdErros+"')");   
         JOptionPane.showMessageDialog(null,"Inserida!");   
      } catch (SQLException e) {   
         imprimeErro("Erro ao inserir Partida", e.getMessage());   
      } finally {   
         fechar();   
      }   
   }   
   
   public ResultSet buscarTodos() {   
	      conectar();    
	      ResultSet rs;   
	      try {   
	         rs = comando.executeQuery("SELECT * FROM ranking order by tempo,qtd_erros limit 5");   
	         return rs;   
	      } catch (SQLException e) {   
	         imprimeErro("Erro ao buscar partidas", e.getMessage());   
	         return null;   
	      }   
	   }   

  
   private void conectar() {   
      try {   
         con = Conexao.conexao(URL, NOME, SENHA, Conexao.MYSQL);   
         comando = con.createStatement();   
         System.out.println("Conectado!");   
      } catch (ClassNotFoundException e) {   
         imprimeErro("Erro ao carregar o driver", e.getMessage());   
      } catch (SQLException e) {   
         imprimeErro("Erro ao conectar", e.getMessage());   
      }   
   }   
  
   private void fechar() {   
      try {   
         comando.close();   
         con.close();   
         System.out.println("Conexão Fechada");   
      } catch (SQLException e) {   
         imprimeErro("Erro ao fechar conexão", e.getMessage());   
      }   
   }   
  
   private void imprimeErro(String msg, String msgErro) {   
      JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);   
      System.err.println(msg);   
      System.out.println(msgErro);   
      System.exit(0);   
   }   
} 
