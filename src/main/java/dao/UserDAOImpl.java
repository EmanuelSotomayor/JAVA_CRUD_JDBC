package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDAOImpl extends SQLConnectionDAOImpl implements UserDAO{

	@Override
	public void insertUser(User usr) throws SQLException, ClassNotFoundException{
		String insertSQL = "INSERT INTO Users(user_id, user_name, user_surname, user_age, user_phone) VALUES(?, ?, ?, ?, ?)";
		try{
			//Abrimos la conexión
			abrirConexion();
			//Creamos el prepareStatement
			state = conSQL.prepareStatement(insertSQL);
			//Seteamos los valores
			state.setInt(1, usr.getId());
			state.setString(2, usr.getName());
			state.setString(3, usr.getSurname());
			state.setInt(4, usr.getAge());
			state.setString(5, usr.getPhone());
			//Executamos la query
			state.executeUpdate();
			System.out.println("¡Agregamos un usuario!");
		}catch(SQLException s){
			s.printStackTrace();
		}catch(ClassNotFoundException c){
			c.printStackTrace();
		}finally{
			cerrarConexion();
		}
	}

	@Override
	public void deleteUser(User usr) throws SQLException, ClassNotFoundException{
		String deleteSQL = "DELETE FROM Users WHERE user_id = ?";
		try{
			//Abrimos la conexión
			abrirConexion();
			//Abrimos la sentencia
			state = conSQL.prepareStatement(deleteSQL);
			//Traemos el ID actual
			state.setInt(1, usr.getId());
			//Ejecutamos la query
			state.executeUpdate();
			System.out.println("Eliminamos el usuario de ID: " + usr.getId());
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User usr) throws SQLException, ClassNotFoundException{
		String updateSQL = "UPDATE Users SET user_name = ?, user_surname = ?, user_age = ?, user_phone = ? WHERE user_id = ? ";
		try{
			//Abrimos la conexión
			abrirConexion();
			//Abrimos la sentencia
			state = conSQL.prepareStatement(updateSQL);
			//Seteamos los cambios
			state.setString(1, usr.getName());
			state.setString(2, usr.getSurname());
			state.setInt(3, usr.getAge());
			state.setString(4, usr.getPhone());
			state.setInt(5, usr.getId());
			//Ejecutamos la consulta
			state.executeUpdate();
			System.out.println("¡Modificamos un usuario!");
		}catch(SQLException s){
			s.printStackTrace();
		}catch(ClassNotFoundException c){
			c.printStackTrace();
		}
	}

	@Override
	public List<User> showUsers() throws SQLException, ClassNotFoundException{
		String selectSQL = "SELECT * FROM Users";
		List<User> users = null;
		try{
			//Creamos la lista de usuarios
			users = new ArrayList();
			//Abrimos la conexión
			abrirConexion();
			//Preparamos la consulta
			state = conSQL.prepareStatement(selectSQL);
			//Ejecutamos la consulta lo que nos devuelve un ResultSet
			result = state.executeQuery();
			//Recorremos el ResultSet
			while(result.next()){
				User usr = new User();
				usr.setId(result.getInt("user_id"));
				usr.setName(result.getString("user_name"));
				usr.setSurname(result.getString("user_surname"));
				usr.setAge(result.getInt("user_age"));
				usr.setPhone(result.getString("user_phone"));
				users.add(usr);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException c){
			c.printStackTrace();
		}
		return users;
	}

}