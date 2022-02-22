package main;

import service.UserService;

public class AppMain {

	public static void main(String[] args) {
		UserService userSrv = null;
		try {
			userSrv = new UserService();
			//userSrv.insertUser(2, "ProbandoNombre", "ProbandoApellido", 20, "1164812380");
			userSrv.listUsers();
			userSrv.modifyUser(2, "Roberto", "Carlos", "1165820193", 30);
			userSrv.listUsers();
			//userSrv.deleteUser(2);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
