//package src.Userbase;

abstract class User
{
	String _userID;
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
		this.setUserID(createNewGUID());
		this.setName(name);
		this.setPass(pass);
		this.setEmail(email);
		this.setRole(role);
	}
	
	public String createNewGUID() {
		return "new GUID";
	}
	
	public void setUserID(String userID){
		_userID = userID;
	}
	
	public String getUserID(){
		return _userID;
	}
	
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
	
	public String toString() {
		return "UserID: " + getUserID() + "\n" +
				"Name: " + getName() + "\n" +
				"Email: " + getEmail() + "\n" +
				"Role: " + getRole() + "\n";
	}

}