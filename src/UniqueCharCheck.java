import java.util.Arrays;
/**
 * Problem statement: To check if a given input String has all unique characters.
 * Can not use any additional Data structure
 */
public class UniqueCharCheck {
	    
	// Assumed that Characters are in ASCII and all kinds of ASCII characters can make up the string 
	//including special characters and numbers
	    public boolean isUnqChar(String inputString){
	        
	    	//Used characters ASCII positions to track if the character is present in the String
	    	//more than once
	        int arrDistinct[] = new int[256];
	        
	        //Initializing the Distinct int array to 0
	        Arrays.fill(arrDistinct,0);
	        
	        //Maximum the loop will run is when there are not repeating characters in the string
	        // Therefore the time complexity of the program will be O(length of the string) 
	        
	        //for (int i=0; i<inputString.length();i++){
	         for (char ch : inputString.toCharArray()) {   
	        	
	        	//return false if duplicate character found
	        	//if (arrDistinct[(int) inputString.charAt(i)]>0){
	        	if (arrDistinct[(int) ch]>0){
	                return false;
	            }
		        //store the count in the arrDistinct, with index as the int value, of the ASCII character	            
	            //arrDistinct[(int) inputString.charAt(i)]++;
	        	arrDistinct[(int) ch]++;
	        }
	        
	        return true;
	 }
	            

	public static void main(String[] args) {
		UniqueCharCheck unqCharObj = new UniqueCharCheck();
		String inputString = "abcdes";
		System.out.println(unqCharObj.isUnqChar(inputString));
		
		String inputString2 = "abcdesa";
		System.out.println(unqCharObj.isUnqChar(inputString2));
	}

}
