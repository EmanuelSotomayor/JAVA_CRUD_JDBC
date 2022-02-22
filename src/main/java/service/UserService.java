package service;

import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

public class UserService {
	
	public void insertUser(Integer id, String name, String surname, Integer age, String phone) throws Exception{
		try{
			if(name.isEmpty() || name == null){
				throw new Exception("El nombre está vacio");
			}if(surname.isEmpty() || surname == null){
				throw new Exception("El apellido está vacio");
			}if(age < 1){
				throw new Exception("La edad no puede ser menor a 1");
			}if(phone.length() < 8){
				throw new Exception("El número está mal escrito");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Creamos el usuario
		User usr = new User();
		//Creamos el usuario DAO
		UserDAO usrDAO = new UserDAOImpl();
		usr.setId(id);
		usr.setName(name);
		usr.setSurname(surname);
		usr.setAge(age);
		usr.setPhone(phone);
		usrDAO.insertUser(usr);
	}
	
	public void deleteUser(Integer idUser) throws Exception{
		//Creamos el usuario
		User usr = new User();
		//Creamos el usuario DAO
		UserDAO usrDAO = new UserDAOImpl();
		//Le seteamos el ID
		usr.setId(idUser);
		//Ejecutamos el método del DAO
		usrDAO.deleteUser(usr);
	}
	
	public void modifyUser(Integer id, String name, String surname, String phone, Integer age) throws Exception{
		//Creamos un user
		User usr = new User();
		//Creamos un userDAO
		UserDAO usrDAO = new UserDAOImpl();
		//Modificamos los atributos
		usr.setName(name);
		usr.setSurname(surname);
		usr.setAge(age);
		usr.setPhone(phone);
		usr.setId(id);
		//Llamamos al método del usrDAO
		usrDAO.updateUser(usr);
	}
	
	public void listUsers() throws Exception{
		//Creamos una lista de usuarios vacia
		List<User> users = new ArrayList();
		//Creamos el userDAO
		UserDAO usrDAO = new UserDAOImpl();
		//Llenamos toda la lista
		users = usrDAO.showUsers();
		//Recorremos la lista
		for(User e: users){
			System.out.println("[" + e.getId() + " " + e.getName() + " " + e.getSurname() + " " + e.getAge() + " " + e.getPhone() + "]");
		}
	}
	
}