//package src.Userbase;

abstract class User
{
	String ID;
	String _name;
	String _pass;
	String _email;
	Role _role;
	
	
	public static enum Role 
	{
		Buyer,
		Seller,
		Admin
	};
	
	
	public User () {}
	
	public User (String name, String pass, String email, Role role) 
	{
		setName(name);
		setPass(pass);
		setEmail(email);
		setRole(role);
	}
	
	public void setID(){}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

	public void setPass(String pass){
		_pass = pass;
	}
	
	public void setEmail(String email){
		_email = email;
	}

	public String getEmail() {
		return _email;
	}
	
	public void setRole(Role role) {
		_role = role;
	}
	
	public Role getRole() {
		return _role;
	}
	
	public void hashPass(){}
	
}