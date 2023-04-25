package working_synchronization.delivery_robot;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();
	
	public static void main(String[] args) throws InterruptedException {
		int numThreads = 1000;
		Thread thread = null;
		for (int i = 0; i < numThreads; i++) {
			thread = new Thread(new RouteGenerator());
			thread.start();
		}
		for (int i = 0; i < numThreads; i++) {
			thread.join();
		}
		
		int maxFreq = 0;
		int maxFreqSize = 0;
		for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
			int size = entry.getKey();
			int freq = entry.getValue();
			if (freq > maxFreq) {
				maxFreq = freq;
				maxFreqSize = size;
			}
		}
		
		System.out.println("Самое частое количество повторений " + maxFreqSize + " (встретилось " + maxFreq + " раз)");
		System.out.println("Другие размеры:");
		for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
			int size = entry.getKey();
			int freq = entry.getValue();
			if (size != maxFreqSize) {
				System.out.println("- " + size + " (" + freq + " раз)");
			}
		}
	}
	
}
