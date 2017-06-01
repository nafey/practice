import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuilder;


public class Suffix {
		
	public String common(String a, String b) {
		int size = 0;
		
		while (size < a.length() && size < b.length() && a.charAt(size) == b.charAt(size)) {
			size++;
		}
		
		return a.substring(0, size);
	}

	public static void main(String[] args) {
		String everything = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("PI.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			everything = sb.toString();
		} catch (Exception ex) {
			Support.s("Error");
		}
		
		String[] str = new String[everything.length()];
		
		for (int i = 0; i < str.length; i++) {
			str[i] = everything.substring(i, everything.length());
		}
		
		MSDRadix msd = new MSDRadix();
		msd.sort(str);
		
		Suffix s = new Suffix();
		
		String max = "";
		String curr = "";
		
		for (int i = 1; i < str.length; i++) {
			curr = s.common(str[i - 1], str[i]);
			
			if (curr.length() > max.length()) {
				max = curr;
			}
		}
		
		Support.s("Max common: " + max);
	}
}