package edu.snhu;

import java.util.HashMap;

public class ContactService {
	//	List of contacts to be stored
	private final HashMap<String, Contact> contactList = new HashMap<String, Contact>();
	
	/**	
	* Add a new contact
	*
	* @param contact 	Contact to be added				| Must not be null or longer than 10 characters
	*/
	public void addContact(Contact contact) {
		String contactId = contact.getContactId();
		
		//	If a contact with a matching id was not found, add the contact
		if (contactList.get(contactId) == null) {
			contactList.put(contactId, contact);
		}
		//	Otherwise, throw an error that contact already exists
		else {
			throw new IllegalArgumentException("Contact with id " + contactId + " already exists");
		}
	}
	
	/**	
	* Delete a contact
	*
	* @param contactId 	Id of the contact	| Must not be null or longer than 10 characters
	*/
	public void deleteContact(String contactId) {		
		//	Attempt to remove the contact, throwing an error if it was not found
		if (contactList.remove(contactId) == null) {
			throw new IllegalArgumentException("Contact with id " + contactId + " not found");	
		}
	}
		
	//	The following methods will update the fields of a contact
	public void updateContactFirstName(String contactId, String updatedFirstName) {
		Contact contact = contactList.get(contactId);
		if (contact == null) {			
			throw new IllegalArgumentException("Contact with id " + contactId + " not found");		
		}
		else {
			contact.setFirstName(updatedFirstName);
		}
	}
	
	public void updateContactLastName(String contactId, String updatedLastName) {
		Contact contact = contactList.get(contactId);
		if (contact == null) {			
			throw new IllegalArgumentException("Contact with id " + contactId + " not found");		
		}
		else {
			contact.setLastName(updatedLastName);
		}
	}
	
	public void updateContactPhone(String contactId, String updatedPhone) {
		Contact contact = contactList.get(contactId);
		if (contact == null) {			
			throw new IllegalArgumentException("Contact with id " + contactId + " not found");		
		}
		else {
			contact.setPhone(updatedPhone);
		}
	}
	
	public void updateContactAddress(String contactId, String updatedAddress) {
		Contact contact = contactList.get(contactId);
		if (contact == null) {			
			throw new IllegalArgumentException("Contact with id " + contactId + " not found");		
		}
		else {
			contact.setAddress(updatedAddress);
		}
	}
}