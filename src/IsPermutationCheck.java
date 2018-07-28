/**
 * Problem Statement: Given two Strings str1 and str2, decide if one is permutation of the other
 * Assumption: not case-sensitive
 */
public class IsPermutationCheck {
	
	public boolean isPermutation(String str1, String str2) {
		
		if (str1==null || str2==null) {
			System.out.println("\nInvalid Input");
			return false;
		}
		if (str1.isEmpty() || str2.isEmpty()) {
			System.out.println("\nInvalid Input");
			return false;
		}
		if (str1.length()!=str2.length()) return false;
		
		//Sort str1 and str2; this will have complexity of O(n log(n))
		char [] tempArrayToSort = str1.toLowerCase().toCharArray();
		java.util.Arrays.sort(tempArrayToSort);
		String sortedStr1 = new String(tempArrayToSort);
		
		tempArrayToSort = str2.toLowerCase().toCharArray();
		java.util.Arrays.sort(tempArrayToSort);
		String sortedStr2 = new String(tempArrayToSort);
		
		//if sorted strings are equal then return true else return false
		if (sortedStr1.equals(sortedStr2)) {
			return true;
		}
		else
			return false;
	}

	public static void main(String[] args) {
		
		IsPermutationCheck permChk = new IsPermutationCheck();
		
		System.out.println(permChk.isPermutation("ABCDE", "ABCD"));
		System.out.println(permChk.isPermutation("ABCDE", "DEABC"));
		System.out.println(permChk.isPermutation(null, "ABCDF"));
		System.out.println(permChk.isPermutation(new String(), new String()));
		
	}

}
