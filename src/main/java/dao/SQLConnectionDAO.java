package dao;

import java.sql.SQLException;

public interface SQLConnectionDAO {
	public static final String DRIVER_JDBC = "com.mysql.cj.jdbc.Driver";
	public static final String URL_JDBC = "jdbc:mysql://localhost:3306/school?useSSL=false";
	public static final String USER_JDBC = "root";
	public static final String PASS_JDBC = "Dijkstr4@rgonaut";
	public void abrirConexion() throws SQLException, ClassNotFoundException;
	public void cerrarConexion() throws SQLException, ClassNotFoundException;
}