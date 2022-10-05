package uchidb;

import java.util.ArrayList;
import java.io.IOException;

/**
 * @author skr
 */
public class DictionaryCoderRunner {

	public static void main(String[] args){

		try{
			//Initial stats
			DictionaryCoder codec = new DictionaryCoder("data.txt");
			System.out.println("Input File Size: " + String.valueOf(codec.getFileSizeInBytes()) + " Bytes");
			System.out.println("Number of Total Tokens: "+ String.valueOf(codec.getStringTokens().size()));
			System.out.println("Number of Distinct Tokens: "+ String.valueOf(codec.generateCodes(codec.getStringTokens()).size()));

			System.out.println("---");

			//Encoding
			ArrayList<String> tokens = codec.getStringTokens();
			ArrayList<String> codes = codec.generateCodes(tokens);
			ArrayList<Integer> encoded = codec.encode(tokens, codes);
			System.out.println("Encoded File Size: "+ String.valueOf(codec.serialize("data.cmp", encoded, codes)) + " Bytes");

			//Decoding
			ArrayList<String> decoded = codec.decodeFromFile("data.cmp");
			System.out.println("Decoded File Matches Tokens: "+ decoded.equals(tokens));


		}
		catch (IOException e){};
		
		
	}
}
