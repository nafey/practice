import java.util.Map;
import java.util.HashMap; 
import java.util.Iterator;


public class KeyIndex {
	
	public String[] sort(String[] arr, Map<String,Integer> vals, int radix) {
		int c = vals.size();
		String[] ret = new String[c];

		int[] count = new int[radix + 1];

		
		Iterator it = vals.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			count[((int) pair.getValue())]++;
		}
		
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
		
		
		for (int i = 0; i < arr.length; i++) {
			String key = arr[i];
			
			ret[count[((int) vals.get(key)) - 1]] = ((String)key);
			
			count[((int) vals.get(key)) - 1]++;
		}
		
		Support.printList(ret);
		return null;
	}
	
	public static void main(String[] args) {
		String[] arr = {
		"Anderson",
        "Brown",
        "Davis",
        "Garcia",
        "Harris",
        "Jackson",
        "Johnson",
        "Jones",
        "Martin",
        "Martinez",
        "Miller",
        "Moore",
        "Robinson",
        "Smith",
        "Taylor",
        "Thomas",
        "Thompson",
        "White",
        "Williams",
        "Wilson"
		};
		
		//Support.printList(arr);
		
		
		
		Map<String, Integer> vals = new HashMap<>();
		
		vals.put("Anderson", 2);
		vals.put("Brown", 3);
		vals.put("Davis", 3);
		vals.put("Garcia", 4);
		vals.put("Harris", 1);
		vals.put("Jackson", 3);
		vals.put("Johnson", 4);
		vals.put("Jones", 3);
		vals.put("Martin", 1);
		vals.put("Martinez", 2);
		vals.put("Miller", 2);
		vals.put("Moore", 1);
		vals.put("Robinson",2);
		vals.put("Smith", 4);
		vals.put("Taylor", 3);
		vals.put("Thomas", 4);
		vals.put("Thompson", 4);
		vals.put("White", 2);
		vals.put("Williams", 3);
		vals.put("Wilson", 4);
		
		KeyIndex k = new KeyIndex();
		k.sort(arr, vals, 4);
		
		System.out.println(vals.size());
	}
}