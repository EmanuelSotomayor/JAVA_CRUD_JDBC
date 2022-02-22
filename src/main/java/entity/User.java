package entity;

public class User {
	
	private Integer id;
	private String name;
	private String surname;
	private Integer age;
	private String phone;
	//Constructor sin parametrizar
	public User(){}
	//Constructor parametrizado
	public User(String name, String surname, Integer age, String phone){
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.phone = phone;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}