package uchidb;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


public class FilesAndExceptionsTest {

  @Test
  public void testFileSizeBytes() {

  		try{
			DictionaryCoder codec = new DictionaryCoder("data.txt");
			long size = 7554990;
			assertTrue(codec.getFileSizeInBytes() == size);
		}
		catch (IOException e){
			assertTrue(false);
		}; 
  }

  
  

  @Test
  public void testTokenization() {

  		try{
			DictionaryCoder codec = new DictionaryCoder("data.txt");
			long size = 2600640;
			assertTrue(codec.getStringTokens().size() == size);
		}
		catch (IOException e){
			assertTrue(false);
		}; 
  }

  @Test
  public void testTokenization2() {

  		try{
			DictionaryCoder codec = new DictionaryCoder("data.txt");
			long size = 7279;
			assertTrue(codec.generateCodes(codec.getStringTokens()).size() == size);
		}
		catch (IOException e){
			assertTrue(false);
		}; 
  }

  @Test
  public void testInMemoryDecoding() {

  		try{
			DictionaryCoder codec = new DictionaryCoder("data.txt");
			ArrayList<String> tokens = codec.getStringTokens();
			ArrayList<String> codes = codec.generateCodes(tokens);
			ArrayList<Integer> encoded = codec.encode(tokens, codes);
			ArrayList<String> decoded = codec.decode(encoded, codes);
			assertTrue(decoded.equals(tokens));
		}
		catch (IOException e){
			assertTrue(false);
		}; 
  }

  @Test
  public void testAll() {

  		try{
			DictionaryCoder codec = new DictionaryCoder("data.txt");
			//Encoding
			ArrayList<String> tokens = codec.getStringTokens();
			ArrayList<String> codes = codec.generateCodes(tokens);
			ArrayList<Integer> encoded = codec.encode(tokens, codes);
			System.out.println("Encoded File Size: "+ String.valueOf(codec.serialize("data.cmp.test", encoded, codes)) + " Bytes");

			//Decoding
			ArrayList<String> decoded = codec.decodeFromFile("data.cmp.test");
			assertTrue(decoded.equals(tokens));
		}
		catch (IOException e){
			assertTrue(false);
		}; 
  }




}