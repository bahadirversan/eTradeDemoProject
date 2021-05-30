package eTradeProjectDemo.business.concretes;

import eTradeProjectDemo.business.abstracts.AuthService;
import eTradeProjectDemo.business.abstracts.UserService;
import eTradeProjectDemo.core.utils.Utils;
import eTradeProjectDemo.entities.concretes.LoginDto;
import eTradeProjectDemo.entities.concretes.User;

public class AuthManager implements AuthService{
	
	private UserService userService;
	
	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if (userValidate(user) 
				&& passwordValidate(user.getPassword()) 
				&& userExists(user.getEmail()) == true //normalde false ???
				&& Utils.emailValidate(user.getEmail())) {

			userService.add(user);
		}else {
		System.out.println("Kay�t olma i�lemi ba�ar�s�z!");
		}
	}

	@Override
	public void verify(User user, String token) {
		if(user != null && token.length() > 20) {
			User existsUser = userService.get(user.getEmail());
			existsUser.setVerify(true);
			
			userService.update(existsUser);
			System.out.println("Do�rulama i�lemi ba�ar�l�");
		}
		System.out.println("Do�rulanma i�lemi ba�ar�s�z!");
		
	}

	@Override
	public boolean userExists(String email) {
		
		User user = userService.get(email);
		
		if (user == null) {
			return true;

		}else {
			System.out.println("Email mevcut " + email);
			return false;
		}
	}

	@Override
	public void login(LoginDto dto) {
		User user = userService.get(dto.getEmail());
		
		if(user != null && user.getPassword().equals(dto.getPassword())) {
			System.out.println("Giri� ba�ar�l�");
			
		}else {
			System.out.println("Kullan�c� ad� veya �ifre yanl��");
			
		}

	}

	public boolean userValidate(User user) {

		if (user != null && !user.getFirstName().isEmpty() && !user.getLastName().isEmpty()
				&& !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {

			return true;
		}
		return false;

	}

	public boolean passwordValidate(String password) {
		if (password.length() >= 6) {
			return true;
			
		} else {
			System.out.println("�ifreniz en az 6 karakter olmal�d�r!");
			return false;
		}
	}

}
