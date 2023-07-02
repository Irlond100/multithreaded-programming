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
	
	public String findByNumber(String name) {
		for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
			List<String> phones = entry.getValue();
			if (phones.contains(name)) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	public List<String> findByName(String phone) {
		if(phoneBook.containsKey(phone)){
			return phoneBook.get(phone);
		}
		return new ArrayList<>();
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


