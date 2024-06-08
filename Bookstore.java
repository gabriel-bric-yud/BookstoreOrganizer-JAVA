import java.io.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class Bookstore {
	
	public static void findDuplicates(String[] array, PrintWriter outfile) {
		//sort array to put duplicate books next to one another
		Arrays.sort(array);
		boolean indexMatches = false;
		
		//create header of outfile
		outfile.println("Duplicate Books");
		outfile.println("Sams Bookstore 2024");
		outfile.println();
		outfile.println("---------------------------------");
		outfile.println();
		
	
		for (int i = 0; i < array.length; i++) { //loop through all book names in sorted array			
			if (i > 0) { 
				if (!array[i].equals(null)) {
					if (array[i].equals(array[i-1]) && !indexMatches) { //if current book is the same as previous book and not already found as a match
						indexMatches = true; //books are matching
						System.out.print("***duplicate found*** \t"); 
						System.out.println(array[i]);
						outfile.println(array[i]); //print duplicate book to outfile one time
						
					}
					else {
						indexMatches = false; //books are no longer matching, begin looking for new duplicate
					}
				
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException { // force checked exception to be thrown if fails
		
		String fileName ="SamsDuplicates.txt";  //Create file name
		PrintWriter outfile = new PrintWriter(fileName);  //create object to write file with name fileName
		
		//All the books data from the document.
		String[] BOOKS = {"And Then It's Spring","Baby Bear Sees Blue","Beach Feet","Jimmy the Greatest!",
				"Boot & Shoe" ,"Boy & Bot","Cat Tale","Creepy Carrots!","Jimmy the Greatest!","Dog in Charge",
				"Eggs 1 2 3","Extra Yarn","Ganesha's Sweet Tooth","Green",
				"Happy Like Soccer","H.O.R.S.E.: A Game of Basketball and Imagination","The Insomniacs",
				"Boy & Bot","It's a Tiger!","Jimmy the Greatest!","King Arthur's Very Great Grandson",
				"Me and Momma and Big John","The Quiet Place","Robin Hood","Step Gently Out","Up, Tall and High",
				"Z Is for Moose","The Elephant's Friend and Other Tales from Ancient India.","The Goldilocks Variations",
				"The Great Race: An Indonesian Trickster Tale","King Arthur's Very Great Grandson","Hans My Hedgehog: A Tale from the Brothers Grimm.",
				"Paul Bunyan and Babe the Blue Ox: The Great Pancake Adventure","Robin Hood","The Town Mouse and the Country Mouse: An Aesop Fable.",
				"The Wooden Sword: A Jewish Folktale from Afghanistan."
		};
		

        String totalTxt = "";
		
        try {
        	Scanner scan = new Scanner(new FileInputStream(new File("SamsBookstore.txt")));
    		String currentLine = "";
            while (scan.hasNext()) {	
            	currentLine = scan.nextLine();
            	if (currentLine.length() != 0) {
            		int length = currentLine.length() - 1;
            		totalTxt += currentLine.substring(0, length) + "/";
            	}
            }
        }
        catch (FileNotFoundException e) {
        	System.out.println("file not found. Using built in database. Please place SamsBookstore.txt in main folder."); 	
        }
        
        finally {
            String[] duplicates = totalTxt.split("/");
            
            if (duplicates.length > 1) {
        		findDuplicates(duplicates, outfile);
            }
            else {
            	findDuplicates(BOOKS, outfile);
            }
        }	

		outfile.close();
		
		
	}

}
