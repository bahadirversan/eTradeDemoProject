package eTradeProjectDemo.business.concretes;

import java.util.List;

import eTradeProjectDemo.business.abstracts.UserService;
import eTradeProjectDemo.core.EmailService;
import eTradeProjectDemo.dataAccess.abstracts.UserDao;
import eTradeProjectDemo.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private EmailService emailService;
	
	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}
	
	@Override
	public void add(User user) {
		if(userValidate(user)) {
			userDao.add(user);
			
			emailService.send(user.getEmail(), "Kayýt olundu");
		}
		
	}
	
	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);
		}
		
	}
	
	@Override
	public void delete(int userId) {
		userDao.delete(userId);
		
	}
	
	@Override
	public List<User> getAll() {
		for(User user : userDao.getAll()) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
		}
		return userDao.getAll();
		
	}
	
	@Override
	public User get(String email) {
		
		return userDao.get(email);
	}
	
	public boolean userValidate(User user) {
		if(user.getFirstName().length() > 2 && user.getLastName().length() > 2) {
			return true;
		}
		System.out.println("Ad ve soyad 2 karakterden büyük olmalýdýr");
		return false;
	}

}
