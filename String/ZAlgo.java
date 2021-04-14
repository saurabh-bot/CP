/*
z - algo for pattern searching
Time complexity -> O(m + n)
Space complexiy -> O(m + n)
*/
import java.io.*;
import java.util.*;
public class ZAlgo{

	// Z - function used to get the z-array
	static int[] calculateZ(String str){
		int l = 0, r = 0, n = str.length();
		char ch[] = str.toCharArray();
		int z[] = new int[n];

		for(int k=1; k<n; k++){
			if(k>r){
				l = r = k;
				while(r<n && ch[r]==ch[r-l]){
					r++;
				}
				z[k] = r - l;
				r--;
			}else{
				int k1 = k - l;
				// If value does not stretches till right bound then just copy it
				if(z[k1]+k-1<r){
					z[k] = z[k1];
				}else{                      // Otherwise try to see if there are other matches
					l = k;
					while(r<n && ch[r]==ch[r-l]){
						r++;
					}
					z[k] = r - l;
					r--;
				}
			}
		}
		return z;
	}


	// Return list of all indices where pattern is found in text
	static List<Integer> matchPattern(String txt, String pat){

		List<Integer> list = new ArrayList<>();
		String s = pat + "$" + txt;
		int z[] = calculateZ(s);
		for(int i=pat.length()+1; i<s.length(); i++){
			if(z[i] == pat.length())
				System.out.println(i - pat.length() - 1);
				list.add(i - pat.length()-1);
		}
		return list;

	}
	public static void main(String[] args) {
		String text = "name"; 
        String pattern = "am";
        matchPattern(text, pattern);

	}
}