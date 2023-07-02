package development_methodologies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
	
	private Map<String, List<String>> phoneBook;
	
	public PhoneBook() {
		this.phoneBook = new HashMap<>();
	}
	
	// добавляет контакты
	public void addContact(String name, String phone) {
		if (phoneBook.containsKey(name)) {
			List<String> phones = phoneBook.get(name);
			phones.add(phone);
		} else {
			List<String> phones = new ArrayList<>();
			phones.add(phone);
			phoneBook.put(name, phones);
		}
		
	}
	
	// находит имя по номеру без полного перебора
	public String findByNumber(String name) {
		return null;
	}
	
	// находит номер по имени без полного перебора.
	public List<String> findByName(String name) {
		return null;
	}
	
	// выводит все имена в алфавитном порядке без необходимости проводить сортировку.
	public List<String> printAllNames() {
	return null;
	}
	
	public boolean containsKey(String name) {
		return phoneBook.containsKey(name);
	}
	
	public List<String> get(String name) {
		return phoneBook.get(name);
	}
	
}


