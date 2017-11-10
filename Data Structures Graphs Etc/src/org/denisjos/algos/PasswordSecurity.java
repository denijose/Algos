package org.denisjos.algos;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class PasswordSecurity {

	/**
	 * @param args
	 */
	
	// usage -  instantiate PasswordSecurity and call the checkPasswords(inputFileName) where inputFileName is the full file name of the input passwords file
	// We could have used static methods too but then the set would have to initialized not in the constructor
	
	// a set to store vowels
	private HashSet<Character> vowels = new HashSet<Character>();
	
	public static void main(String[] args) {
		PasswordSecurity obj = new PasswordSecurity(); // We can use a singleton pattern
		try {
			obj.checkPasswords("C:\\D Drive\\say.in.txt"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public PasswordSecurity(){
		vowels = new HashSet<Character>(); 
		vowels.add('a'); vowels.add('e');vowels.add('i'); vowels.add('o'); vowels.add('u'); // better than using new HashSet<String>(Arrays.asList('a','e','i','o'));
	}
	
	public void checkPasswords(String fileName) throws IOException{		
		readFile(fileName);
	}

	private void readFile(String inputFileName) throws IOException{
		File inputFile = new File(inputFileName);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		
		// to create an out file with a similar name in the same directory as the input file
		int endIndex = inputFile.getName().indexOf(".in");
		String outputFileName = inputFile.getName().substring(0, endIndex);
		outputFileName = outputFileName + ".out";
		File outPutFile = new File(inputFile.getParent() + "\\" + outputFileName);			
    	if( outPutFile.exists()){
    		outPutFile.delete();
    		outPutFile.createNewFile();
    	}
    	System.out.println("Output File created - " + outPutFile.getAbsolutePath() );
		BufferedWriter bw = new BufferedWriter(new FileWriter(outPutFile));		
		
		
		String password = new String();
		String output = new String();
		while( !(password=br.readLine()).equalsIgnoreCase("end")){
			if(check(password))
				output = "<" + password + ">" + " is acceptable.\n";
			else
				output = "<" + password + ">" + " is not acceptable.\n";
			bw.write(output);
		}
			
		br.close();
		bw.close();
	}
	
	// a method to check each password for its validity
	private boolean check(String password){
		int vowelsCount = 0; 		// to keep track of the consecutive vowels
		int consonantsCount = 0; 	// to keep track of the consecutive consonants
		boolean atLeastOnce = false;
	    
		int i = 0;
		for(i=0;i<password.length()-1;i++){
			if(password.charAt(i) ==  password.charAt(i+1) && password.charAt(i)!='e' &&  password.charAt(i)!='o')
				return false;
			
			if(vowels.contains(password.charAt(i))){
				atLeastOnce = true;
				consonantsCount = 0;   //toggle the counts appropriately
				vowelsCount++;
				if(vowelsCount==3)
					return false;
			}
			else{
				consonantsCount++;
				vowelsCount = 0;
				if(consonantsCount==3)
					return false;
			}			
		}
		
		//check for the last character!
		if(vowels.contains(password.charAt(i))){
			atLeastOnce = true;
			consonantsCount = 0;
			vowelsCount++;
			if(vowelsCount==3)
				return false;
		}
		else{
			consonantsCount++;
			vowelsCount = 0;
			if(consonantsCount==3)
				return false;
		}
		
		// check if there is atleast one vowel
		if(atLeastOnce==true)
		   return true;
		
		return false;
		
	}
}
