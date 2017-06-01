import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;


public class MSDRadix {
	
	private int dig(String val, int pos) {
		if (pos >= val.length()) return 0;
		return Character.getNumericValue(val.charAt(pos));
	}
	
	// Limited implementation. No duplicate vals. Only digits less than 6.
	private void sort(String[] vals, String[] aux, int lo, int high, int radix, int pos) {
		int[] count = new int[radix + 2];
		
		// build cumulates
		for (int i = lo; i < high; i++) {
			String val = vals[i];
			int dig = this.dig(val, pos);
			
			count[dig + 2]++;
		}
		
		count[0] = lo;
		
		// aggregate cumulates
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i - 1] + count[i];
		}
		
		// sorting to aux
		for (int i = lo; i < high; i++) {
			int dig = this.dig(vals[i], pos);
			aux[count[dig + 1]] = vals[i];
			count[dig + 1]++;
		}
			
		// copying back to vals
		for (int i = lo; i < high; i++) {
			vals[i] = aux[i];
		}		
		
		// call sub sorts
		lo = count[0];
		for (int i = 0; i < count.length - 1; i++) {
			high = count[i];
			
			if (high - lo > 1) {
				this.sort(vals, aux, lo, high, radix, pos + 1);
			}
			
			lo = count[i];
		}
	}
	
	public void sort(String[] vals) {
		String[] aux = new String[vals.length];
		
		this.sort(vals, aux, 0, vals.length, 10, 0);
	}
	
	public static void main(String[] args) {
		String[] vals = {
			"402",
			"123",
			"14200",
			"6331",
			"3314",
			"5231",
			"01273",
			"1449",
			"371",
			"614",
			"655",
			"214",
			"414",
			"2505",
			"8652",
			"7254",
			"5205",
			"13",
			"702"
		};
				
		MSDRadix msd = new MSDRadix();
		msd.sort(vals);
		
		Support.pL(vals);
	}
}