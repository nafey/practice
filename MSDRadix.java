import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;


public class MSDRadix {
	
	private int dig(String val, int pos) {
		return Character.getNumericValue(val.charAt(pos));
	}
	
	// Limited implementation. No duplicate vals. Only digits less than 6.
	public void sort(String[] vals, String[] aux, int lo, int high, int radix, int pos) {
		int[] count = new int[radix + 1];
		int[] copy = new int[radix + 1];
		
		// build cumulates
		for (int i = lo; i < high; i++) {
			String val = vals[i];
			int dig = this.dig(val, pos);
			
			count[dig]++;
		}
		
		count[0] = lo;
		
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i - 1] + count[i];
		}
		
		for (int i = 0; i < copy.length; i++) {
			copy[i] = count[i];
		}
		
		for (int i = lo; i < high; i++) {
			int dig = this.dig(vals[i], pos);
			aux[count[dig - 1]] = vals[i];
			count[dig - 1]++;
		}
		
		
		
		for (int i = lo; i < high; i++) {
			vals[i] = aux[i];
		}		
		
		for (int i = 1; i < copy.length; i++) {
			lo = copy[i - 1];
			high = copy[i];
						
			if (high - lo > 1) {
				this.sort(vals, aux, lo, high, radix, pos + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		String[] vals = {
			"412",
			"144",
			"312",
			"614",
			"655",
			"214",
			"414",
			"255",
			"652",
			"254",
			"522",
			"135"
		};
				
		String[] aux = new String[vals.length];		
		
		MSDRadix msd = new MSDRadix();
		msd.sort(vals, aux, 0, vals.length, 6, 0);
		
		Support.pL(vals);
		Support.s("-----");
		
			
		System.out.println("Hello World!");
	}
}