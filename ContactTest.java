package edu.snhu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ContactTest {	
	
	/*	Build a string containing char c repeated length times */
	String buildString(char c, int length) {
		char[] charArray = new char[length];
		Arrays.fill(charArray, c);	
		String string = new String(charArray);		
		return string;
	}

	@Nested
	class ContactTestCreationId {
		@Test
		@DisplayName("Contact creation with null id")
		void testNullId() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with a null id
				new Contact(null, "Tony", "Stevens", "1234567890", "123 Baker St");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Null id", exception.getMessage());
		}

		@Test
		@DisplayName("Contact creation with 0 character id")
		void testIdZeroChars() {
			new Contact("", "Tony", "Stevens", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 9 character id")
		void testIdNineChars() {
			new Contact("NineChars", "Tony", "Stevens", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 10 character id")
		void testIdTenChars() {
			new Contact("1234567890", "Tony", "Stevens", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 11 character id")
		void testIdElevenChars() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with too long of an id
				new Contact("ElevenChars", "Tony", "Stevens", "1234567890", "123 Baker St");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("id length exceeds limit", exception.getMessage());
		}
	}

	@Nested
	class ContactTestCreationFirstName {
		@Test
		@DisplayName("Contact creation with null first name")
		void testNullFirstName() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with a null first name
				new Contact("T1", null, "Stevens", "1234567890", "123 Baker St");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Null first name", exception.getMessage());
		}

		@Test
		@DisplayName("Contact creation with 0 character first name")
		void testFirstNameZeroChars() {
			new Contact("T1", "", "Stevens", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 9 character first name")
		void testFirstNameNineChars() {
			new Contact("T1", "nineChars", "Stevens", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 10 character first name")
		void testFirstNameTenChars() {
			new Contact("T1", "1234567890", "Stevens", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 11 character first name")
		void testFirstNameElevenChars() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with too long of a first name
				new Contact("T1", "ElevenChars", "Stevens", "1234567890", "123 Baker St");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("first name length exceeds limit", exception.getMessage());
		}
	}

	@Nested
	class ContactTestCreationLastName {
		@Test
		@DisplayName("Contact creation with null last name")
		void testNullLastName() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with a null last name
				new Contact("T1", "Tony", null, "1234567890", "123 Baker St");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Null last name", exception.getMessage());
		}

		@Test
		@DisplayName("Contact creation with 0 character last name")
		void testLastNameZeroChars() {
			new Contact("T1", "Tony", "", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 9 character last name")
		void testLastNameNineChars() {
			new Contact("T1", "Tony", "nineChars", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 10 character last name")
		void testLastNameTenChars() {
			new Contact("T1", "Tony", "1234567890", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 11 character last name")
		void testLastNameElevenChars() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with too long of a first name
				new Contact("T1", "Tony", "ElevenChars", "1234567890", "123 Baker St");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("last name length exceeds limit", exception.getMessage());
		}
	}

	@Nested
	class ContactTestCreationPhoneNumber {
		@Test
		@DisplayName("Contact creation with null phone number")
		void testNullPhoneNumber() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with a null phone number
				new Contact("T1", "Tony", "Stevens", null, "123 Baker St");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Null phone number", exception.getMessage());
		}

		@Test
		@DisplayName("Contact creation with 0 character phone number")
		void testPhoneNumberZeroChars() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with blank phone number
				new Contact("T1", "Tony", "Stevens", "", "123 Baker St");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Phone number length invalid", exception.getMessage());
		}

		@Test
		@DisplayName("Contact creation with 9 character phone number")
		void testPhoneNumberNineChars() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with blank phone number
				new Contact("T1", "Tony", "Stevens", "nineChars", "123 Baker St");
			});
			// Verify that the exception was thrown with the proper message
			assertEquals("Phone number length invalid", exception.getMessage());
		}

		@Test
		@DisplayName("Contact creation with 10 digit phone number")
		void testPhoneNumberTenDigitChars() {
			new Contact("T1", "Tony", "Stevens", "1234567890", "123 Baker St");
		}

		@Test
		@DisplayName("Contact creation with 10 letter phone number")
		void testPhoneNumberTenLetterChars() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with too long of a phone number
				new Contact("T1", "Tony", "Stevens", "abcdefghij", "123 Baker St");
			});
			
			assertEquals("Phone number contains invalid character", exception.getMessage());
		}

		@Test
		@DisplayName("Contact creation with 11 character phone number")
		void testPhoneNumberElevenChars() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with too long of a phone number
				new Contact("T1", "Tony", "Stevens", "ElevenChars", "123 Baker St");
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Phone number length invalid", exception.getMessage());
		}
	}

	@Nested
	class ContactTestCreationAddress {
		@Test
		@DisplayName("Contact creation with null address")
		void testNullAddress() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with a null address
				new Contact("T1", "Tony", "Stevens", "1234567890", null);
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("Null address", exception.getMessage());
		}

		@Test
		@DisplayName("Contact creation with 0 character address")
		void testAddressZeroChars() {
			new Contact("T1", "Tony", "Stevens", "1234567890", "");
		}

		@Test
		@DisplayName("Contact creation with 29 character address")
		void testPhoneNumberNineChars() {
			// Create a contact with a 29 address
			new Contact("T1", "Tony", "Stevens", "1234567890", buildString('*', 29));
		}

		@Test
		@DisplayName("Contact creation with 30 character address")
		void testAddressThirtyChars() {
			new Contact("T1", "Tony", "Stevens", "1234567890", buildString('*', 30));
		}

		@Test
		@DisplayName("Contact creation with 31 character address number")
		void testAddressThirtyOneChars() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Create a contact with too long of an address
				new Contact("T1", "Tony", "Stevens", "1234567890", buildString('*', 31));
			});

			// Verify that the exception was thrown with the proper message
			assertEquals("address length exceeds limit", exception.getMessage());
		}
	}

	@Nested
	class ContactTestRetrieval {
		// Create all contact objects at the top of the class
		Contact contactOne = new Contact("C1", "Mark", "Zimmer", "1234567890", "Some Address");
		Contact contactTwo = new Contact("", "", "", "0123456789", "");
		Contact contactThree = new Contact("c*j3h@h!a", "!! vve3s", "\"", "1357908642", "null");

		@Test
		@DisplayName("Retrieve values of contact one")
		void testContactOneRetrieval() {
			assertEquals(contactOne.getContactId(), "C1");
			assertEquals(contactOne.getFirstName(), "Mark");
			assertEquals(contactOne.getLastName(), "Zimmer");
			assertEquals(contactOne.getPhone(), "1234567890");
			assertEquals(contactOne.getAddress(), "Some Address");
		}

		@Test
		@DisplayName("Retrieve all values of contact two")
		void testContactTwoRetrieval() {
			assertEquals(contactTwo.getContactId(), "");
			assertEquals(contactTwo.getFirstName(), "");
			assertEquals(contactTwo.getLastName(), "");
			assertEquals(contactTwo.getPhone(), "0123456789");
			assertEquals(contactTwo.getAddress(), "");
		}

		@Test
		@DisplayName("Retrieve all values of contact three")
		void testContactThreeRetrieval() {
			assertEquals(contactThree.getContactId(), "c*j3h@h!a");
			assertEquals(contactThree.getFirstName(), "!! vve3s");
			assertEquals(contactThree.getLastName(), "\"");
			assertEquals(contactThree.getPhone(), "1357908642");
			assertEquals(contactThree.getAddress(), "null");
		}

	}
}
