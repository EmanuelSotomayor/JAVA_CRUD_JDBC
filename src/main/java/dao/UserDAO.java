package dao;

import java.sql.SQLException;
import java.util.List;

import entity.User;

public interface UserDAO {
	public void insertUser(User usr) throws SQLException, ClassNotFoundException;
	public void deleteUser(User usr) throws SQLException, ClassNotFoundException;
	public void updateUser(User usr) throws SQLException, ClassNotFoundException;
	public List<User> showUsers() throws SQLException, ClassNotFoundException;
}
