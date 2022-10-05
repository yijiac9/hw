package uchidb;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;


/**
 * @author skr
 */
public class DictionaryCoder {


	public DictionaryCoder(String filename) throws IOException {
	 	//TODO 1. Write code that constructs a dictionary class 

  	}

  	public long getFileSizeInBytes(){
  		//TODO 2. Write code that returns the specified file's size in bytes

  		return 0;
  	}


  	public ArrayList<String> getStringTokens() throws IOException{
  		//TODO 3. Write a method that reads the file and retuns a list of tokens
  		//Token are words in the dataset
  		//Split each line on whitespace and commas to identify the tokens
  		//Keep all of the delimiters as tokens as well
  		//Treat the new line character at the end of each line as a separate token

  		ArrayList<String> tokens = new ArrayList<String>();


      return null;

  	}


  	public ArrayList<String> generateCodes(ArrayList<String> tokens) throws IOException{
  		//TODO 4. Write a method that takes in the ArrayList of tokens generated from TODO 3
  		//and returns an ArrayList of DISTINCT tokens. The index position in the array will be
  		//the dictionary code. We call this returned array the "codebook"

      return null;
  	}


  	public ArrayList<Integer> encode(ArrayList<String> tokens, ArrayList<String> codes) throws IOException{
  		//TODO 5. Write a method that takes in both the set of tokens and the set of codes (distinct tokens)
  		//It should return a list where every token is replaced by its index in the codebook.

  		return null;
  	}


  	public ArrayList<String> decode(ArrayList<Integer> encoded, ArrayList<String> codes) throws IOException{
  		//TODO 6. Write a method that takes in an encoded ArrayList and a ArrayList of codes and
  		//returns the original token ArrayList

  		return null;
  	}


  	public long serialize(String output_file, ArrayList<Integer> encoded, ArrayList<String> codes) throws IOException{
  		//TODO 7. Write a method that serializes the two ArrayLists (encoded and code book) 
  		// to a single file.
  		//This tutorial will be helpful
  		//(https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/)
  		//This method should return the resulting file size in bytes.

  		return 0;
  	}


  	public ArrayList<String> decodeFromFile(String compressed_file) throws IOException{
  		//TODO 8. Write a method that loads data from the output file and
  		//returns an ArrayList of tokens. You will have to call the method
  		//implemented in TODO 6. 
  		// Note the object casting here is actually a little tricky.

  		return null;
  	}

}
