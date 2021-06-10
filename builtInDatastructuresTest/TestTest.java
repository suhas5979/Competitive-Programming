package builtInDatastructuresTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class TestTest {

	public static void main(String[] args) {

		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(1,2);
		map.putIfAbsent(1, 4);
		
		String str = "suhas";
		
		
		System.out.println(map.getOrDefault(2, 0));

	}

}
