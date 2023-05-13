package collections_for_parallel_work;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
	
	public static BlockingQueue<String> queueA = new ArrayBlockingQueue<>(100);
	public static BlockingQueue<String> queueB = new ArrayBlockingQueue<>(100);
	public static BlockingQueue<String> queueC = new ArrayBlockingQueue<>(100);
	public static Thread testGeneretor;
	
	public static void main(String[] args) throws InterruptedException {
		testGeneretor = new Thread(() ->
		{
			for (int i = 0; i < 10000; i++) {
				String test = generateText("abc", 100000);
				try {
					queueA.put(test);
					queueB.put(test);
					queueC.put(test);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});
		
		testGeneretor.start();
		
		Thread a = getThread(queueA, 'a');
		Thread b = getThread(queueB, 'b');
		Thread c = getThread(queueC, 'c');
		
		a.start();
		b.start();
		c.start();
		
		a.join();
		c.join();
		b.join();
		
	}
	
	public static String generateText(String letters, int length) {
		Random random = new Random();
		StringBuilder text = new StringBuilder();
		for (int i = 0; i < length; i++) {
			text.append(letters.charAt(random.nextInt(letters.length())));
		}
		return text.toString();
	}
	
	public static Thread getThread(BlockingQueue<String> queue, char letter) {
		return new Thread(() ->
		{
			int max = MaxChar(queue,letter);
			System.out.println("Максимально "+ letter + " в тексте " + max);
		});
	}
	
	public static int MaxChar(BlockingQueue<String> queue, char letter) {
		int count = 0;
		int max = 0;
		String test;
		try {
			while (testGeneretor.isAlive()) {
				test = queue.take();
				for (char c : test.toCharArray()) {
					if (c == letter) count++;
				}
				if (count > max) max = count;
				count = 0;
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + "Была прервана");
			return -1;
		}
		return max;
	}
	
}