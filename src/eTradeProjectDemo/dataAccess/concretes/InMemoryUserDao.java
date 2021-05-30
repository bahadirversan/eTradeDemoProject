package eTradeProjectDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTradeProjectDemo.dataAccess.abstracts.UserDao;
import eTradeProjectDemo.entities.concretes.User;

public class InMemoryUserDao implements UserDao {
	
	private List<User> users = new ArrayList<User>();
	
	public InMemoryUserDao() {
		
		User user1 = new User(1, "Bahadýr", "Versan", "bahadir@gmail.com", "444444", true);
		User user2 = new User(2, "Fahri", "Marul", "fahri@gmail.com", "456298", true);
		User user3 = new User(3, "Eren", "Keleþ", "eren@gmail.com", "751320", true);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	}

	@Override
	public void add(User user) {
		System.out.println("Kaydedildi : " + user.getEmail());
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream()
				.filter(u -> u.getId() == user.getId())
				.findFirst()
				.orElse(null);
		
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setVerify(user.isVerify());
	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream()
				.filter(u -> u.getId() == userId)
				.findFirst()
				.orElse(null);
		
		users.remove(userToDelete);
	}

	@Override
	public List<User> getAll() {
		return users;
		
	}

	@Override
	public User get(String email) {
		User user = users.stream()
				.filter(u -> u.getEmail() == email)
				.findFirst()
				.orElse(null);
		
		return user;
	}
	
	
}
