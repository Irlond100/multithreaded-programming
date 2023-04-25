package working_synchronization.delivery_robot;

import java.util.Random;

public class RouteGenerator implements Runnable {
	
	public static final String LETTERA = "RLRFR";
	public static final int LENGTH = 100;
	
	public static String generateRoute(String letters, int length) {
		Random random = new Random();
		StringBuilder route = new StringBuilder();
		for (int i = 0; i < length; i++) {
			route.append(letters.charAt(random.nextInt(letters.length())));
		}
		return route.toString();
	}
	@Override
	public void run() {
		String route = generateRoute(LETTERA, LENGTH);
		int countR = countR(route);
		synchronized (Main.sizeToFreq) {
			if (Main.sizeToFreq.containsKey(countR)) {
				Main.sizeToFreq.put(countR, Main.sizeToFreq.get(countR) + 1);
			} else {
				Main.sizeToFreq.put(countR, 1);
			}
		}
		System.out.println(route + "-" + countR);
	}
	
	private int countR(String route) {
		int count = 0;
		for (int i = 0; i < route.length(); i++) {
			if (route.charAt(i) == 'R') {
				count++;
			}
		}
		return count;
	}
	
}
