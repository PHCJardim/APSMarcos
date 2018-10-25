
import java.sql.*; 

public class Conexao { 
	public static final int MYSQL = 0; 
	private static final String MySQLDriver = "org.postgresql.Driver"; 
	public static Connection conexao(String url, String nome, String senha, 
		int banco) throws ClassNotFoundException, SQLException { 
		switch (banco) { 
			case MYSQL: Class.forName(MySQLDriver); 
			break; 
		} 
		return DriverManager.getConnection(url, nome, senha); 
	} 
}