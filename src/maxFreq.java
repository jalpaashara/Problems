import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
/** Problem Statement: Given a paragraph as a String, return the words with the maximum frequency which are 
 * not a part of dictionary given as List of String.If there are more than one words with same maximum 
 * frequency, return all the words.
 * Assumption: Words in dictionary are in lower case
 */
public class maxFreq {
	
	/**
	 * Method to get the List of words in a paragraph with maxFrequency not in the dictionary
	 * If dictionary is empty than returning the words with maxFrequency
	 * @param paragraph
	 * @param dictionary
	 * @return List<String>
	 */
	public List<String> maxFrequency (String paragraph, List<String> dictionary){
		
		if (paragraph==null) {
			System.out.println("Paragrah is empty");
			return null;
		}
		if (dictionary==null) dictionary=new ArrayList<String>();
		
		//HashMap to keep track of count of each word, with word being the key and count as the value
		HashMap<String,Integer> countWordsMap = new HashMap<>();
		
		//Splitting the words by punctuations, white space and digits
		String[] words = paragraph.toLowerCase().split("[\\p{Punct}\\s\\d]+");
		
		//Populate the Hashmap
		for (int itr=0;itr<words.length;itr++) {
			if (!dictionary.contains(words[itr])) {
				
				//Increase the count if word already present but not available in the dictionary
				if(countWordsMap.containsKey(words[itr])) {
					countWordsMap.replace(words[itr], countWordsMap.get(words[itr])+1);
				}
				
				//otherwise add the word in the HashMap with count as 1
				else {
					countWordsMap.put(words[itr], 1);
				}
			}
		}
		
		//Get the count of the first word in the map
		Entry<String, Integer> firstEntry = countWordsMap.entrySet().iterator().next();
		int frequency = firstEntry.getValue();
		
		//Find max Frequency
		for (Entry<String, Integer> getMaxFreq : countWordsMap.entrySet()) {
		    int value = getMaxFreq.getValue();
		    if (value >= frequency) {
		    	frequency = value;
		    }
		}
		
		//Add the words with maxFrequency into the result list
		List<String> result = new ArrayList<String>();
		for (Entry<String, Integer> getWordsMaxFreq : countWordsMap.entrySet()) {
			if (getWordsMaxFreq.getValue()==frequency) {
				result.add(getWordsMaxFreq.getKey());
			}
		} 
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String paragraph = new String();
		String paragraph = null;
		paragraph="Harry and Sally were out sailing's 1234 on a boat. 1234 The boat was a huge one, and had lots of color. It was a 1234 bright and sunny day with periodic cool breezes. The boat was sailing smoothly.";
		List<String> dictionary = new ArrayList<String>();
		//dictionary.add("and");
		dictionary.add("a");
		dictionary.add("boat");
		maxFreq freq=new maxFreq();
		System.out.println(freq.maxFrequency(paragraph,dictionary));
	}

}
