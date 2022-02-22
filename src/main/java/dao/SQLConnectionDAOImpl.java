package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConnectionDAOImpl implements SQLConnectionDAO{
	
	protected Connection conSQL = null;
	protected PreparedStatement state = null;
	protected ResultSet result = null;
	
	@Override
	public void abrirConexion() throws SQLException, ClassNotFoundException{
		try{
			//Cargamos el Driver JDBC
			Class.forName(DRIVER_JDBC);
			//Abrimos la conexión SQL
			this.conSQL = DriverManager.getConnection(URL_JDBC, USER_JDBC, PASS_JDBC);
		}catch(SQLException s){
			System.out.println("Error en la conexión de base de datos");
			s.printStackTrace();
		}catch(ClassNotFoundException c){
			c.printStackTrace();
		}
	}

	@Override
	public void cerrarConexion() throws SQLException{
		//Cerramos la conexión de la base de datos, los statement o prepared statement y lo resultset.
		//Esto lo agregamos siempre en un bloque finally.
		try{
			//Verificamos que el Result sea diferente a null
			if(this.result != null){
				//Luego sí es diferente a null, preguntamos sí la conexión no está cerrada.
				if(!this.result.isClosed()){
					this.result.close();
				}
			}
			if(!this.state.isClosed()){
				this.state.close();
			}
			if(!this.conSQL.isClosed()){
				this.conSQL.close();
			}
		}catch(SQLException s){
			s.printStackTrace();
		}
	}
	
}