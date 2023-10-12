package edu.snhu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	ContactService contactService;

	/*	Build a string containing char c repeated length times */
	String buildString(char c, int length) {
		char[] charArray = new char[length];
		Arrays.fill(charArray, c);	
		String string = new String(charArray);		
		return string;
	}

	@BeforeEach
	void setupContactService() {
		contactService = new ContactService();
	}

	@Nested
	class ContactServiceTestAddContactId {
		@Test
		@DisplayName("Add contact with same id as existing contact")
		void addContactSameId() {

			Contact c1 = new Contact("T1", "Tony", "Stevens", "1234567890", "123 Baker St");
			Contact c2 = new Contact("T1", "Jenny", "Owens", "1234567890", "9383 Cake Ln");

			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Attempt to add two contacts with the same id
				contactService.addContact(c1);
				contactService.addContact(c2);
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Contact with id T1 already exists", exception.getMessage());
		}

		@Test
		@DisplayName("Add two contacts with different id as existing contact")
		void addContactDifferent() {

			Contact c1 = new Contact("T1", "Tony", "Stevens", "1234567890", "123 Baker St");
			Contact c2 = new Contact("T2", "Jenny", "Owens", "1234567890", "9383 Cake Ln");

			// Attempt to add two contacts with different id
			contactService.addContact(c1);
			contactService.addContact(c2);
		}
	}

	@Nested
	class ContactServiceTestDeleteContact {

		@BeforeEach
		void addContacts() {
			Contact c1 = new Contact("T1", "Tony", "Stevens", "1234567890", "123 Baker St");
			Contact c2 = new Contact("C1", "Claire", "Jenkins", "0123456789", "99 Barry Blvd");
			Contact c3 = new Contact("W1", "William", "Rogers", "1357908642", "374 Low Ln");
			
			contactService.addContact(c1);
			contactService.addContact(c2);
			contactService.addContact(c3);
		}

		@Test
		@DisplayName("Delete contacts with existing id")
		void testDeleteExistingContacts() {
			contactService.deleteContact("T1");
			contactService.deleteContact("C1");
			contactService.deleteContact("W1");
		}

		@Test
		@DisplayName("Delete contact with nonexisting id")
		void testDeleteNonexistingContacts() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contactService.deleteContact("H1");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Contact with id H1 not found", exception.getMessage());
		}

		@Test
		@DisplayName("Delete contact with null id")
		void testDeleteContactNullId() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contactService.deleteContact(null);
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Contact with id null not found", exception.getMessage());
		}

		@Test
		@DisplayName("Delete contact with 11 character id")
		void testDeleteContactElevenCharacterId() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contactService.deleteContact("ElevenChars");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Contact with id ElevenChars not found", exception.getMessage());
		}
	}

	class ContactServiceTestDeleteThenAddContact {
		@Test
		@DisplayName("Delete contact with existing id then add contact with same id")
		void testDeleteValidContacts() {
			Contact c1 = new Contact("C1", "Tony", "Stevens", "1234567890", "123 Baker St");
			Contact c2 = new Contact("C1", "Travis", "Knoll", "0123456789", "33 Cedar Lane");
			
			contactService.addContact(c1);
			contactService.deleteContact("C1");
			contactService.addContact(c2);
		}
	}

	@Nested
	class ContactServiceTestUpdateContact {

		@BeforeEach
		void addContacts() {
			Contact c1 = new Contact("T1", "Tony", "Stevens", "1234567890", "123 Baker St");
			Contact c2 = new Contact("C1", "Claire", "Jenkins", "0123456789", "99 Barry Blvd");
			Contact c3 = new Contact("W1", "William", "Rogers", "1357908642", "374 Low Ln");
			
			contactService.addContact(c1);
			contactService.addContact(c2);
			contactService.addContact(c3);
		}

		@Nested
		class ContactServiceTestUpdateContactFirstName {
			@Test
			@DisplayName("Update contact first name with existing id with valid name")
			void testUpdateExistingContactFirstNameValid() {
				contactService.updateContactFirstName("T1", "Travis");
			}

			@Test
			@DisplayName("Update contact first name with existing id with invalid name")
			void testUpdateExistingContactFirstNameNull() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactFirstName("T1", null);
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Null first name", exception.getMessage());
			}

			@Test
			@DisplayName("Update contact first name with existing id with 11 character name")
			void testUpdateExistingContactFirstNameElevenChars() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactFirstName("T1", buildString('*', 11));
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("first name length exceeds limit", exception.getMessage());
			}
		}

		@Nested
		class ContactServiceTestUpdateContactLastName {
			@Test
			@DisplayName("Update contact last name with existing id with valid name")
			void testUpdateExistingContactLastNameValid() {
				contactService.updateContactLastName("T1", "Smith");
			}

			@Test
			@DisplayName("Update contact last name with existing id with invalid name")
			void testUpdateExistingContactLastNameNull() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactLastName("T1", null);
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Null last name", exception.getMessage());
			}

			@Test
			@DisplayName("Update contact first name with existing id with 11 character name")
			void testUpdateExistingContactLastNameElevenChars() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactLastName("T1", buildString('*', 11));
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("last name length exceeds limit", exception.getMessage());
			}
		}

		@Nested
		class ContactServiceTestUpdateContactPhone {
			@Test
			@DisplayName("Update contact phone with existing id with valid phone")
			void testUpdateExistingContactPhoneValid() {
				contactService.updateContactPhone("T1", "1234567890");
			}

			@Test
			@DisplayName("Update contact phone with existing id with null phone")
			void testUpdateExistingContactPhoneNull() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactPhone("T1", null);
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Null phone number", exception.getMessage());
			}

			@Test
			@DisplayName("Update contact phone with existing id with 11 character phone")
			void testUpdateExistingContactPhoneElevenChars() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactPhone("T1", "12345678901");
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Phone number length invalid", exception.getMessage());
			}

			@Test
			@DisplayName("Update contact phone with existing id with 10 letter characters phone")
			void testUpdateExistingContactPhoneLetters() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactPhone("T1", "abcdefghij");
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Phone number contains invalid character", exception.getMessage());
			}
		}

		@Nested
		class ContactServiceTestUpdateContactAddress {			
			@Test
			@DisplayName("Update contact address with existing id with valid address")
			void testUpdateExistingContactAddressValid() {
				contactService.updateContactAddress("T1", "1234567890");
			}

			@Test
			@DisplayName("Update contact address with existing id with null address")
			void testUpdateExistingContactAdressNull() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactAddress("T1", null);
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Null address", exception.getMessage());
			}

			@Test
			@DisplayName("Update contact address with existing id with 31 character address")
			void testUpdateExistingContactAddressThirtyOneChars() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactAddress("T1", buildString('*', 31));
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("address length exceeds limit", exception.getMessage());
			}
		}

		@Nested
		class ContactServiceTestUpdateInvalidId {
			@Test
			@DisplayName("Update contact first name with null id")
			void testUpdateExistingContactNullId() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactFirstName(null, "Kevin");
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Contact with id null not found", exception.getMessage());
			}

			@Test
			@DisplayName("Update contact first name with nonexisting id")
			void testUpdateExistingContactInvalidId() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactFirstName("x3idj", "Kevin");
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Contact with id x3idj not found", exception.getMessage());
			}
			
			@Test
			@DisplayName("Update last name with null contact id")
			void testUpdateLastNameNullId() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactLastName(null, "Baker");
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Contact with id null not found", exception.getMessage());
			}
			
			@Test
			@DisplayName("Update address with null contact id")
			void testUpdateAddressId() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactAddress(null, "312 New Street");
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Contact with id null not found", exception.getMessage());
			}
			
			@Test
			@DisplayName("Update phone with null contact id")
			void testUpdatePhoneId() {
				Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contactService.updateContactPhone(null, "1234567890");
				});

				// Verify that the exception was thrown with the proper message
				assertEquals("Contact with id null not found", exception.getMessage());
			}
		}
	}
}
