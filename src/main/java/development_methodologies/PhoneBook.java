package development_methodologies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
	
	private Map<String, List<String>> phoneBook;
	
	public PhoneBook() {
		this.phoneBook = new HashMap<>();
	}
	
	// добавляет контакты
	public int addContact(String name, String phone) {
		return 0;
	}
	
	// находит имя по номеру без полного перебора
	public List<String> getPhonesByName(String name) {
		return phoneBook.get(name);
	}
	
	// находит номер по имени без полного перебора.
	public List<String> findByName(String name) {
		return null;
	}
	
	// выводит все имена в алфавитном порядке без необходимости проводить сортировку.
	public void printAllNames() {
	
	}
	
	public boolean containsKey(String name) {
		return phoneBook.containsKey(name);
	}
	
	public List<String> get(String name) {
		return phoneBook.get(name);
	}
	
}


