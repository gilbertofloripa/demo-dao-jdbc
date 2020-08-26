package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB { // Classe para conectar e desconectar o BD

	private static Connection conn = null;

	// Cria conexao
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties(); // chama o metodo para carregar as propriedades de conexao
				String url = props.getProperty("dburl");// pega o caminho do DB da varialve dburl
				conn = DriverManager.getConnection(url, props);// faz a conexao com o BD
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// carrega propriedades do arquivo de propriedades de conexao
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());// passa o erro para a minha execao de erros
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());// passa o erro para a minha execao de erros
			}
		}
	}

}
