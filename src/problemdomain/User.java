package problemdomain;

public class User {
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String accountBalance;
	
	public User(String firstName, String lastName, String address, String phoneNumber, String accountBalance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.accountBalance = accountBalance;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the accountBalance
	 */
	public String getAccountBalance() {
		return accountBalance;
	}
	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "First name: " + firstName 
				+ "Last name: " + lastName 
				+ "Address: " + address 
				+ "Phone number: " + phoneNumber
				+ "Account balance: " + accountBalance;
	}
	
}
