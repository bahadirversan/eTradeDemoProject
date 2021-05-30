package eTradeProjectDemo;

import java.util.List;

import eTradeProjectDemo.business.abstracts.UserService;
import eTradeProjectDemo.business.concretes.AuthManager;
import eTradeProjectDemo.business.concretes.UserManager;
import eTradeProjectDemo.core.amazonEmail.AmazonMailManagerAdapter;
import eTradeProjectDemo.core.googleEmail.GoogleMailManagerAdapter;
import eTradeProjectDemo.dataAccess.concretes.InMemoryUserDao;
import eTradeProjectDemo.entities.concretes.LoginDto;
import eTradeProjectDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
		AuthManager authManager = new AuthManager(new UserManager(inMemoryUserDao, new AmazonMailManagerAdapter()));
		
		User user4 = new User(7, "Bünyamin", "Karayagiz", "bünyamin@gmail.com", "123456", true);
		User user1 = new User(1, "Bahadýr", "Versan", "bahadirgmail.com", "444444", true);
		
		authManager.register(user4);
		authManager.login(new LoginDto("bahadir@gmail.com", "444444"));
		
		UserManager userManager = new UserManager(new InMemoryUserDao(), new GoogleMailManagerAdapter());
		userManager.add(user1);
		userManager.update(user1);
		//userManager.delete(3);
		userManager.getAll();
		
	}

}
