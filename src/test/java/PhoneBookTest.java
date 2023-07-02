import development_methodologies.PhoneBook;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneBookTest {
	
	static PhoneBook phoneBook = new PhoneBook();
	
	@BeforeAll
	public static void setUp() {
		phoneBook.addContact("John", "1234567890");
		phoneBook.addContact("John", "9876543210");
		phoneBook.addContact("Alice", "5555555555");
		phoneBook.addContact("Rlo", "987654");
	}
	
	@Test
	public void testAddContact() {
		
		assertTrue(phoneBook.containsKey("John"));
		List<String> phones = phoneBook.get("John");
		assertTrue(phones.contains("1234567890"));
		
		phones = phoneBook.get("John");
		assertTrue(phones.contains("1234567890"));
		assertTrue(phones.contains("9876543210"));
		
		assertTrue(phoneBook.containsKey("Alice"));
		phones = phoneBook.get("Alice");
		assertTrue(phones.contains("5555555555"));
	}
	
	@Test
	public void testFindByNumber() {
		
		String phones = phoneBook.findByNumber("1234567890");
		assertEquals("John", phones);
		
		phones = phoneBook.findByNumber("9876543210");
		assertEquals("John", phones);
		
		phones = phoneBook.findByNumber("5555555555");
		assertEquals("Alice", phones);
		
		phones = phoneBook.findByNumber("9999999999");
		assertNull(phones);
	}
	
	@Test
	public void testFindByName() {
		
		List<String> name = phoneBook.findByName("John");
		List<String> expectedPhones = new ArrayList<>();
		expectedPhones.add("1234567890");
		expectedPhones.add("9876543210");
		assertEquals(expectedPhones, name);
		
		name = phoneBook.findByName("Alice");
		expectedPhones = new ArrayList<>();
		expectedPhones.add("5555555555");
		assertEquals(expectedPhones, name);
		
		name = phoneBook.findByName("Bob");
		expectedPhones = new ArrayList<>();
		assertEquals(expectedPhones, name);
	}
	
	@Test
	public void testPrintAllNames() {
		
		List<String> names = phoneBook.printAllNames();
		List<String> expectedNames = new ArrayList<>();
		expectedNames.add("Alice");
		expectedNames.add("John");
		expectedNames.add("Rlo");
		assertEquals(expectedNames, names);
	}
	
}


