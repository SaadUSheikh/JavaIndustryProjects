import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A program for counting the number of "coins" in a coin file.
 * 
 * The name of the coin file to use as input should be provided as a
 * command line argument when this program is run.
 * 
 * The result of the count is saved to a file called "count.txt".
 * 
 * @author Dengke Sha
 *
 */
public class CoinCounter {

	public static void main(String[] args) {
		
		String filename = args[0];
		
		Integer coinCount = null;
		
		try {
			
			// Count the number of coins in the file given by filename.
			coinCount = countCoins(filename);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File could not be found.");
			
		} catch (IOException e) {
			
			System.out.println("An error occurred when trying to count the coins in the file.");
			
		} catch (InvalidCoinFileException e) {
			
			System.out.println(e.getMessage());
		
		}
		
		// If we did get a coin count, save the output to the file.
		if(coinCount != null) {
			
			try {
				saveCoinCountToFile(coinCount, "count.txt");
			} catch (FileNotFoundException e) {
				System.out.println("An error was encountered while trying to save the count file.");
			}
			
		}

	}
	
	// Counts the number of coins in the coin file.
	// An InvalidCoinFileException will be thrown if the file is of an invalid format.
	private static int countCoins(String filename) throws IOException, InvalidCoinFileException {
		
		// Load the coin file.
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		// Count our coins.
		int coinCount = 0;
		
		while(true) {
			
			String currentLine = reader.readLine();
			
			if(currentLine == null) {
				// Reached the end of the file, so stop reading.
				reader.close();
				break;
			}
		
			for(int i=0; i < currentLine.length(); i++) {
				
				String currentCharacter = currentLine.substring(i, i + 1);
				
				if(currentCharacter.equals("O")) {
					coinCount++;
				} else {
					// Close the reader before throwing the exception.
					reader.close();
					throw new InvalidCoinFileException();
				}
				
			}
			
		}
		
		return coinCount;
		
	}
	
	// Saves the coin count to the file.
	private static void saveCoinCountToFile(int coinCount, String outputFilename) throws FileNotFoundException {
		
		PrintWriter writer = new PrintWriter(outputFilename);
		
		writer.println("You have " + coinCount + " coins!");
		writer.close();
		
		System.out.println("Coin count file saved.");
		
	}

}

