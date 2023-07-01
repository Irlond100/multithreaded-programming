import development_methodologies.PhoneBook;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

// Проверяем, что контакт был добавлен успешно
		assertTrue(phoneBook.containsKey("John"));
		List<String> phones = phoneBook.get("John");
		assertTrue(phones.contains("1234567890"));

// Проверяем, что в контакте "John" есть оба номера телефона
		phones = phoneBook.get("John");
		assertTrue(phones.contains("1234567890"));
		assertTrue(phones.contains("9876543210"));

// Проверяем, что контакт "Alice" был добавлен успешно
		assertTrue(phoneBook.containsKey("Alice"));
		phones = phoneBook.get("Alice");
		assertTrue(phones.contains("5555555555"));
	}
	
}


