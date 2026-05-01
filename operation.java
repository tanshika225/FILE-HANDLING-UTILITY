package task1filehandlingutility;
import java.io.*;
import java.util.Scanner;
public class FileHandlingutility {
	 public static void writeFile(String filename, String content) {
	        try {
	            FileWriter writer = new FileWriter(filename);
	            writer.write(content);
	            writer.close();
	            System.out.println("Data written successfully.");
	        } catch (IOException e) {
	            System.out.println("Error writing file: " + e.getMessage());
	        }
	    }

	    // Method to read data from a file
	    public static void readFile(String filename) {
	        try {
	            File file = new File(filename);
	            Scanner sc = new Scanner(file);

	            System.out.println("\nFile Content:");
	            while (sc.hasNextLine()) {
	                System.out.println(sc.nextLine());
	            }
	            sc.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found.");
	        }
	    }

	    // Method to modify file content (replace word)
	    public static void modifyFile(String filename, String oldWord, String newWord) {
	        try {
	            File file = new File(filename);
	            Scanner sc = new Scanner(file);

	            StringBuilder content = new StringBuilder();

	            while (sc.hasNextLine()) {
	                String line = sc.nextLine();
	                line = line.replaceAll(oldWord, newWord);
	                content.append(line).append("\n");
	            }
	            sc.close();

	            FileWriter writer = new FileWriter(filename);
	            writer.write(content.toString());
	            writer.close();

	            System.out.println("File modified successfully.");

	        } catch (IOException e) {
	            System.out.println("Error modifying file: " + e.getMessage());
	        }
	    }

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        String filename = "sample.txt";

	        while (true) {
	            System.out.println("\n--- FILE HANDLING MENU ---");
	            System.out.println("1. Write to File");
	            System.out.println("2. Read File");
	            System.out.println("3. Modify File");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = input.nextInt();
	            input.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter content to write: ");
	                    String content = input.nextLine();
	                    writeFile(filename, content);
	                    break;

	                case 2:
	                    readFile(filename);
	                    break;

	                case 3:
	                    System.out.print("Enter word to replace: ");
	                    String oldWord = input.nextLine();
	                    System.out.print("Enter new word: ");
	                    String newWord = input.nextLine();
	                    modifyFile(filename, oldWord, newWord);
	                    break;

	                case 4:
	                    System.out.println("Exiting program...");
	                    input.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice!");
	            }
	        }
}
}
