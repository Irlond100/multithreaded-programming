package multithreaded_program_variables;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	private static final AtomicInteger counter3 = new AtomicInteger(0);
	private static final AtomicInteger counter4 = new AtomicInteger(0);
	private static final AtomicInteger counter5 = new AtomicInteger(0);
	
	static int palindromeThreadCount;
	static int sameLetterThreadCount;
	static int increasingLettersThreadCount;
	
	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		String[] texts = new String[100_000];
		for (int i = 0; i < texts.length; i++) {
			texts[i] = generateText("abc", 3 + random.nextInt(3));
		}
		
		// палиндром
		Thread palindromeThread = new Thread(() -> {
			for (String text : texts) {
				if (isPalindrome(text)) {
					int length = text.length();
					if (length == 3) {
						counter3.incrementAndGet();
					} else if (length == 4) {
						counter4.incrementAndGet();
					} else if (length == 5) {
						counter5.incrementAndGet();
					}
					
				}
				palindromeThreadCount++;
			}
			
		});
		// одной и той же буквы
		Thread sameLetterThread = new Thread(() -> {
			for (String text : texts) {
				if (isSameLetter(text)) {
					int length = text.length();
					if (length == 3) {
						counter3.incrementAndGet();
					} else if (length == 4) {
						counter4.incrementAndGet();
					} else if (length == 5) {
						counter5.incrementAndGet();
					}
					sameLetterThreadCount++;
				}
			}
		});
		// слова идут по возрастанию
		Thread increasingLettersThread = new Thread(() -> {
			for (String text : texts) {
				if (isIncreasingLetters(text)) {
					int length = text.length();
					if (length == 3) {
						counter3.incrementAndGet();
					} else if (length == 4) {
						counter4.incrementAndGet();
					} else if (length == 5) {
						counter5.incrementAndGet();
					}
					increasingLettersThreadCount++;
				}
			}
		});
		
		palindromeThread.start();
		sameLetterThread.start();
		increasingLettersThread.start();
		
		palindromeThread.join();
		sameLetterThread.join();
		increasingLettersThread.join();
		
		System.out.println("Красивых слов с длиной 3: " + counter3.get() + " шт");
		System.out.println("Красивых слов с длиной 4: " + counter4.get() + " шт");
		System.out.println("Красивых слов с длиной 5: " + counter5.get() + " шт");
		
		System.out.println("Красивых слов с палиндромом: " + palindromeThreadCount + " шт");
		System.out.println("Красивых слов с одной и той же буквой: " + sameLetterThreadCount + " шт");
		System.out.println("Красивых слов идущее по возрастанию: " + increasingLettersThreadCount + " шт");
		
	}
	
	public static String generateText(String letters, int length) {
		Random random = new Random();
		StringBuilder text = new StringBuilder();
		for (int i = 0; i < length; i++) {
			text.append(letters.charAt(random.nextInt(letters.length())));
		}
		return text.toString();
	}
	
	public static boolean isPalindrome(String text) {
		int length = text.length();
		for (int i = 0; i < length; i++) {
			if (text.charAt(i) != text.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isSameLetter(String text) {
		int length = text.length();
		for (int i = 0; i < length; i++) {
			char fistChar = text.charAt(0);
			if (text.charAt(i) != fistChar) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isIncreasingLetters(String text) {
		int length = text.length();
		char currentChar = 'a' - 1;
		for (int i = 0; i < length; i++) {
			char nextChar = text.charAt(i);
			if (nextChar <= currentChar) {
				return false;
			}
			currentChar = nextChar;
		}
		return true;
	}
	
}

