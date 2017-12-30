import java.util.ArrayList;
import java.util.List;

public class UserManager {

	List<User> userList;
	
	
	public UserManager() {
		userList = new ArrayList<User>();
	}
	
	void addUser(User user) {
		this.userList.add(user);
	}
	
	void removeUser(User user) {
		this.userList.remove(user);
	}
	
	User getUser(String name) {
		for(User u: this.userList) {
			if(u.getName().equals(name)) {
				return u;
			}
		}
		return null;
	}
	
	List<User> getAllUsers() {
		return this.userList;
	}
}
