import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;


public class LSDRadix {
	
	public String[] sort(String[] vals, int radix) {
		KeyIndex k = new KeyIndex();
		radix--;
		while (radix >= 0) {
			
			Map<String, Integer> map = new HashMap<>();
			Set <Integer> calcRadix = new HashSet<>();
		
			for (int i = 0; i < vals.length; i++) {
				map.put(vals[i], Integer.valueOf(vals[i].charAt(radix)));
				calcRadix.add(Integer.valueOf(vals[i].charAt(radix)));
			}
			
			vals = k.sort(vals, map, calcRadix.size());
			
			radix--;
		}
		
		return vals;
	}
	
	public static void main(String[] args) {
		String[] vals = {
			"dab",
			"add",
			"cab",
			"fad",
			"fee",
			"bad",
			"dad",
			"bee",
			"fed",
			"bed",
			"ebb",
			"ace"
		};
		
		LSDRadix lsd = new LSDRadix();
		lsd.sort(vals, 3);
			
		System.out.println("Hello World!");
	}
}