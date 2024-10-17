package base.utils;

import org.apache.commons.text.RandomStringGenerator;

public class RandomStringUtils {


	
	public static String getRandomString(int inputCharCount) 
	{
		try {
			RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
			String randomLetters = generator.generate(inputCharCount);
			return randomLetters;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String getRandomNumbers(int inputCharCount) {
		try {
			RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('1', '9').build();
			String randomLetters = generator.generate(inputCharCount);
			return randomLetters;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
