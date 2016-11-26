public interface IStartupHelper 
{
	
	void loginButtonClicked();

	void registerButtonClicked();

	UIPage getUserPage(User.Role role);
}