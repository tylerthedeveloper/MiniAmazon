//package src.Userbase;

public class User
{
	String ID;
	String name;
	String pass;
	String email;
	String role;
	
	public enum Role 
	{
		Buyer,
		Seller,
		Admin
	};
	
	public User ()
	{
		
	}
	
	public void setID(){}
	public void setName(String name){}
	public void setRole(String role){}
	public void setEmail(String email){}
	public void setPass(String pass){}
	public void hashPass(){}
	
}