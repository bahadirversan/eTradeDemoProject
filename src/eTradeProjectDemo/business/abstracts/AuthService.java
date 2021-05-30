package eTradeProjectDemo.business.abstracts;

import eTradeProjectDemo.entities.concretes.LoginDto;
import eTradeProjectDemo.entities.concretes.User;

public interface AuthService {
	void register(User user);
	void verify(User user, String token);
	boolean userExists(String email);
	void login(LoginDto loginDto);
}
