import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Problem Statement: Get first non repeated character from String
 * Assumption: not case-sensitive and no whitespaces
 */
public class DistinctFirstChar {
		
	/* This problem can be done in the ways mentioned below:
	 *  1. Using LinkedHashMap 
	 *  2. Using HashSet and ArrayList.
	 */
	
	/* Using LinkedHashMap to find first non-repeated character from String in Java. 
	 * This algorithm loops through twice once to put the characters in the Map and 
	 * then to get the first distinct character
	 * Algorithm : 
	 * Step 1 : loop through the string and put each character(KEY) 
	 * 			and its count(VALUE) in the LinkedHashMap
	 * Step 2 : loop through the LinkedHashMap to get the key for value 1,
	 * 			as LinkedHashMap maintains insertion order, the first key with value 1 will be 
	 * 			the first non-repeated character in the string
	 */
	public char getFirstNonRepeatedCharUsingLinkedHashMap(String str) { 
		Map<Character,Integer> counts = new LinkedHashMap<>(str.length()); 
		char result=' ';
		for (char c : str.toLowerCase().toCharArray()) { 
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1); 
		}
		for (Entry<Character,Integer> entry : counts.entrySet()) { 
			if (entry.getValue() == 1) { 
				result = entry.getKey(); 
				break;
			} 
		}
		
		if (result==' ') {
			System.out.println("No repeating character found! "+str);
			return result;
		}
		else
			return result;
	}
	
	/* Using HashSet and ArrayList to find first non-repeated character from String in Java. 
	 * This algorithm uses two storage to cut down one iteration. 
	 * We store repeated and non-repeated characters separately
	 * Algorithm : 
	 * 1. loop through the string 
	 * 2. if character is present in the list, 
	 * 		add the character to the Set where repeated characters are stored, and
	 * 		remove it from the list where non-repeated characters are stored
	 * 	3. If character is not present in both the list and the Set then add it to the list.
	 */
	public char getFirstNonRepeatedCharUsingSetList(String str) { 
		Set<Character> repeating = new HashSet<>();
		List<Character> nonReapting = new ArrayList<>();
		for (char c : str.toLowerCase().toCharArray()) {
			if (nonReapting.contains(c)) {
				nonReapting.remove((Character)c);
				repeating.add(c);
			}
			else {
				if (!repeating.contains(c))
					nonReapting.add(c);
			}
		}
		
		if (!nonReapting.isEmpty()) {
			return nonReapting.get(0);
		}
		else {
			System.out.println("No repeating character found! "+str);
			return ' ';
		}
	}
		
	
	
	/*public static void main(String args[]) {
		DistinctFirstChar distFirstChar = new DistinctFirstChar();
		
		System.out.println(distFirstChar.getFirstNonRepeatedCharUsingSetList("abcdefghija"));
		System.out.println(distFirstChar.getFirstNonRepeatedCharUsingSetList("hello"));
		System.out.println(distFirstChar.getFirstNonRepeatedCharUsingSetList("Java"));
		System.out.println(distFirstChar.getFirstNonRepeatedCharUsingSetList("worldworld"));
		System.out.println(distFirstChar.getFirstNonRepeatedCharUsingSetList("Swiss"));
		
	}*/
	

}
