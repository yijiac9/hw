package uchidb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.management.RuntimeErrorException;
import java.util.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.spec.EncodedKeySpec;
import java.nio.file.Files;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author skr
 */



public class DictionaryCoder {


	String filename;
	ArrayList<Integer> e;
	ArrayList<String> c;
	public DictionaryCoder(String filename) throws IOException {
		//TODO 1. Write code that constructs a dictionary class 
		this.filename = filename;
	 }

	public DictionaryCoder(String filename, ArrayList<Integer> e,ArrayList<String> c) throws IOException {
	 	//TODO 1. Write code that constructs a dictionary class 
		 this.filename = filename;
		 this.e = e;
		 this.c = c;

  	}

  	public long getFileSizeInBytes(){
  		//TODO 2. Write code that returns the specified file's size in bytes
		File f = new File(filename);
		// System.out.println(f.length());
		// long a = 7554990;
        return f.length();
  	}


  	public ArrayList<String> getStringTokens() throws IOException{
  		//TODO 3. Write a method that reads the file and retuns a list of tokens
  		//Token are words in the dataset
  		//Split each line on whitespace and commas to identify the tokens
  		//Keep all of the delimiters as tokens as well
  		//Treat the new line character at the end of each line as a separate token

  	    ArrayList<String> tokens = new ArrayList<String>();
		Scanner scan = new Scanner(filename);
		while (scan.hasNextLine()){
			String[] thisline = scan.nextLine().split("[\\s,]+");
			for(String token:thisline){
				tokens.add(token);
			}
		}
		System.out.println(tokens.size());
		scan.close();
		
        return tokens;

  	}


  	public ArrayList<String> generateCodes(ArrayList<String> tokens) throws IOException{
  		//TODO 4. Write a method that takes in the ArrayList of tokens generated from TODO 3
  		//and returns an ArrayList of DISTINCT tokens. The index position in the array will be
  		//the dictionary code. We call this returned array the "codebook"
		Set set = new HashSet<>(tokens);
		ArrayList<String> distinct_tokens = new ArrayList<String>(set);
        return distinct_tokens;
  	}


  	public ArrayList<Integer> encode(ArrayList<String> tokens, ArrayList<String> codes) throws IOException{
  		//TODO 5. Write a method that takes in both the set of tokens and the set of codes (distinct tokens)
  		//It should return a list where every token is replaced by its index in the codebook.
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(String token:tokens){
			int i = codes.indexOf(token);
			result.add(i);

		}

  		return result;
  	}


  	public ArrayList<String> decode(ArrayList<Integer> encoded, ArrayList<String> codes) throws IOException{
  		//TODO 6. Write a method that takes in an encoded ArrayList and a ArrayList of codes and
  		//returns the original token ArrayList
		ArrayList<String> result = new ArrayList<String>();
		for(Integer i:encoded){
			String token = codes.get(i);
			result.add(token);
		}
  		return result;
  	}


  	public long serialize(String output_file, ArrayList<Integer> encoded, ArrayList<String> codes) throws IOException{
  		//TODO 7. Write a method that serializes the two ArrayLists (encoded and code book) 
  		// to a single file.
  		//This tutorial will be helpful
  		//(https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/)
  		//This method should return the resulting file size in bytes.
		try
		{
			FileOutputStream fos = new FileOutputStream("codebook.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			DictionaryCoder d = new DictionaryCoder(filename,encoded,codes);
			oos.writeObject(d);
			oos.close();
			fos.close();
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
		long b = getFileSizeInBytes();
  		return b;
  	}


  	public ArrayList<String> decodeFromFile(String compressed_file) throws IOException{
  		//TODO 8. Write a method that loads data from the output file and
  		//returns an ArrayList of tokens. You will have to call the method
  		//implemented in TODO 6. 
  		// Note the object casting here is actually a little tricky.
		ArrayList<String> tokens = new ArrayList<>();
		DictionaryCoder d;
		try
        {
            FileInputStream fis = new FileInputStream("codebook.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d =(DictionaryCoder) ois.readObject();
			ArrayList<Integer> encoded_8 = d.e;
			ArrayList<String> codes_8 = d.c;
            ois.close();
            fis.close();
			tokens = decode(encoded_8,codes_8);
			return tokens;
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
			return tokens;
        } 
		catch (ClassNotFoundException c) 
        {
            c.printStackTrace();
			return tokens;
        }
  	}

}
