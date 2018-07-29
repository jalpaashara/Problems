import static org.junit.Assert.*;
import org.junit.Test; 

public class DistinctFirstCharTest { 
	
	@Test 
	public void testFirstNonRepeatedCharacterUsingMap() { 
		DistinctFirstChar distFirstChar = new DistinctFirstChar();
	
		assertEquals('b', distFirstChar.getFirstNonRepeatedCharUsingLinkedHashMap("abcdefghija")); 
		assertEquals('h', distFirstChar.getFirstNonRepeatedCharUsingLinkedHashMap("hello")); 
		assertEquals('j', distFirstChar.getFirstNonRepeatedCharUsingLinkedHashMap("Java")); 
		assertEquals(' ', distFirstChar.getFirstNonRepeatedCharUsingLinkedHashMap("worldworld")); 
		assertEquals('w', distFirstChar.getFirstNonRepeatedCharUsingLinkedHashMap("Swiss"));
	} 
	
	@Test 
	public void testFirstNonRepeatedCharacterUsingSetList() { 
		DistinctFirstChar distFirstChar = new DistinctFirstChar();
	
		assertEquals('b', distFirstChar.getFirstNonRepeatedCharUsingSetList("abcdefghija")); 
		assertEquals('h', distFirstChar.getFirstNonRepeatedCharUsingSetList("hello")); 
		assertEquals('j', distFirstChar.getFirstNonRepeatedCharUsingSetList("Java")); 
		assertEquals(' ', distFirstChar.getFirstNonRepeatedCharUsingSetList("worldworld")); 
		assertEquals('w', distFirstChar.getFirstNonRepeatedCharUsingSetList("Swiss"));
	} 

}

