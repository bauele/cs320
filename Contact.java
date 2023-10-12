package edu.snhu;

public class Contact {
	
	//	Class member variables
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	/**	
	* Validates a given field
	*
	* @param fieldName 		Name of the field to be validated
	* @param fieldValue 	Value of the field to be checked
	* @param limit	 		Maximum length of the field
	* @return An IllegalArgumentException if fieldValue is null or too long, otherwise true
	*/
	private boolean validateInput(String fieldName, String fieldValue, int limit) {
		if (fieldValue == null) {
			throw new IllegalArgumentException("Null " + fieldName);
		}
		else if (fieldValue.length() > limit) {
			throw new IllegalArgumentException(fieldName + " length exceeds limit");
		}
		
		return true;
	}
		
	/**	
	* Validates a given phone number
	*
	* @param phone 	Phone number to be validated
	* @return An IllegalArgumentException if phone is invalid, otherwise null
	*/
	static Exception phoneException(String phone) {
		if (phone == null) {
			return new IllegalArgumentException("Null phone number");
		}
		else if (phone.length() != 10) {
			return new IllegalArgumentException("Phone number length invalid");
		}
		else {
			//	Ensure all characters are digits
			if (!phone.matches("\\d{10}")) {
				return new IllegalArgumentException("Phone number contains invalid character");		
			}
		}
		
		return null;
	}
		
	/**	
	* Create a new Contact object
	*
	* @param contactId 	Id of the contact 				| Must not be null or longer than 10 characters
	* @param firstName	First name of the contact 		| Must not be null or longer than 10 characters
	* @param lastName	Last name of the contact		| Must not be null or longer than 10 characters
	* @param phone		Phone number of the contact		| Must not be null and must be exactly 10 digits
	* @param address	Address of the contact			| Must not be null or longer than 30 characters
	*/
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		
		//	Validate all of the input values supplied in constructor. If any values
		//	are invalid, the function will throw an error and return to the caller 
		//	without creating the object
		validateInput("id", contactId, 10);
		validateInput("first name", firstName, 10);
		validateInput("last name", lastName, 10);
		validateInput("address", address, 30);	

		//	Phone exception checking. This cannot make use of the validInput()
		//	function because a phone number does not have a max length limit,
		//	but instead must always be exactly 10 characters
		Throwable phoneException = Contact.phoneException(phone);
		if (phoneException != null) {
			throw new IllegalArgumentException(phoneException.getMessage());
		}
	
		//	Set all member variables to supplied values
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	/**	
	* Get the id of the contact
	* 
	* @return Id of the contact
	*/
	public String getContactId() {
		return this.contactId;
	}
	
	/**	
	* Set the first name of the contact
	* 
	* @param firstName	First name of the contact | Must not be null or longer than 10 characters
	*/
	public void setFirstName(String firstName) {
		if (validateInput("first name", firstName, 10)) {
			this.firstName = firstName;
		}
	}
	
	/**	
	* Get the first name of the contact
	* 
	* @return First name of the contact
	*/
	public String getFirstName() {
		return this.firstName;
	}
	
	/**	
	* Set the last name of the contact
	* 
	* @param lastName	Last name of the contact | Must not be null or longer than 10 characters
	*/
	public void setLastName(String lastName) {
		if (validateInput("last name", lastName, 10)) {
			this.lastName = lastName;
		}
	}
	
	/**	
	* Get the last name of the contact
	* 
	* @return Last name of the contact
	*/
	public String getLastName() {
		return this.lastName;
	}
	
	/**	
	* Set the phone number of the contact
	* 
	* @param phone	Phone number of the contact	| Must not be null and must be exactly 10 digits
	*/
	public void setPhone(String phone) {
		//	Phone exception checking
		Throwable phoneException = Contact.phoneException(phone);
		if (phoneException != null) {
			throw new IllegalArgumentException(phoneException.getMessage());
		}
		else {
			this.phone = phone;
		}
	}
	
	/**	
	* Get the phone number of the contact
	* 
	* @return Phone number of the contact
	*/
	public String getPhone() {
		return this.phone;
	}
	
	/**	
	* Set the address of the contact
	* 
	* @param address	Address of the contact	| Must not be null or longer than 30 characters
	*/
	public void setAddress(String address) {
		if (validateInput("address", address, 30)) {
			this.address = address;
		}
	}
	
	/**	
	* Get the address of the contact
	* 
	* @return Address of the contact
	*/
	public String getAddress() {
		return this.address;
	}
}
