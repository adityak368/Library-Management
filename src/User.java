
public class User {

	public User(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private String name;
	private String address;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User : " + this.getName();
	}
}
