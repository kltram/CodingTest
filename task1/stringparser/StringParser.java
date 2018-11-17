/**
 * 
 */
 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ramesh
 * 
 *         Description String parsing:: Read the whitelist from the file. Each
 *         line in a whitelist is an individual parser. A program should ask a
 *         user to send a test, find the exact parser that match the user
 *         response and returns the token value from the user response.
 * 
 */
public class StringParser {

	private static final String CONFIG_FILE = "whitelist.txt";
	static List<String> items = new ArrayList<String>();

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			File file = readFromWhiteFile();
			// create a Buffered Reader object instance with a FileReader

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please Enter your input: ");
			String strInput = scanner.nextLine();;
			
			if (strInput.equals("") || strInput == null ) {
				System.out.print("\nPlease Re-Run the program and pass the user input ");
				return;
			} 

			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			// Read the data from Whitelist.txt
			while ((st = br.readLine()) != null)
				items.add(st);
			// close file stream 
			br.close();
			if (items.size() != 0 && items != null) {
				toPrintTheMatchedOutput(items, strInput);
			} else {
				System.out.println("White file is empty");
			}
		}
		// handle exceptions
		catch (FileNotFoundException exp) {
			System.out.println("file not found" + exp.getLocalizedMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	private static void toPrintTheMatchedOutput(List<String> items,
			String strInput) {
		//pattern
		Pattern pattern = Pattern.compile("\\s*(\\{.+?})\\s*");
		List<String> finalValue = new ArrayList<String>();
		for (String item : items) {
			Matcher matcher = pattern.matcher(item);
			if (matcher.find()) {
				String str = matcher.group(1);
				
				String str1 = item.replace("'", "");
				str1 = item.replaceAll("\\s+", " ");
				String strRemoved = str1.replace(str.trim(), "");
				strRemoved = strRemoved.trim().replaceAll("\\s{4,}", "");
				strRemoved = strRemoved.replaceAll("\\s+", " ");
				String arr = missingWords(strInput, strRemoved);
				finalValue.add(arr);
			}
		}
		
		 String strTockenValue = finalValue.get(0);

		    for (String element : finalValue) {
		        if (element.length() < strTockenValue.length()) {
		        	strTockenValue = element;
		        }
		    }

		System.out
				.println("\nThe expected returns token value from the user response\n");
		System.out
				.println("-------------------------------------------------------\n");
		System.out.println("\t\t" + strTockenValue);
		System.out
				.println("\n---------------Written by Ramesh----------------------");
	}

	static String missingWords(String strFileReadItem, String strRemoved) {
		
		List<String> words = new ArrayList<>();
		String[] tTokens = strRemoved.split(" ");
		String[] sTokens = strFileReadItem.split(" ");

		for (int i = 0, j = 0; i < sTokens.length; i++) {
			if (!sTokens[i].trim().equals(tTokens[j].trim())) {
				words.add(sTokens[i]);
			} else {
				if (j >= tTokens.length - 1) {
					continue;
				} else {
					j++;
				}
			}
		}
		String str4 = Arrays.toString(words.toArray());
		str4 = str4.replaceAll(",", "").replace("[", "").replace("]", "");
		return str4;
	}

	public static File readFromWhiteFile() {
		URL fileUrl = StringParser.class.getResource(CONFIG_FILE);
		return new File(fileUrl.getFile());
	}
}
