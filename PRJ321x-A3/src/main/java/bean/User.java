package bean;

/*Tao user*/
public class User {
	private String email;
	private String password;
	private String message;
	private int accountRole = 1;
	private String addres;
	private String phoneNumber;
	private String userName;
	public User() {}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(String email, String password, String userName ) {
		this.email = email;
		this.password = password;
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(int accountRole) {
		this.accountRole = accountRole;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*xac nhan hop le*/
	public boolean regexUser () {
        String regexEmail = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        String regexPassWord = "[a-zA-Z0-9_!@#$%^&*]+";
        if (!this.getPassword().matches(regexPassWord) ){
        	this.message = "Password not ivalid.";
            return false;
        }
        if (!this.getEmail().matches(regexEmail)) {
        	this.message = "Email not ivalid.";
            return false;
        }
        return true;
    }

}
