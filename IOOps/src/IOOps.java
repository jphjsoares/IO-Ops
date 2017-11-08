import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Date;
import java.io.File;

public class IOOps{
	//OBJECTS INITIALIZATION
	static Date date = new Date();
	Scanner userInput = new Scanner(System.in);
	static IOOps obj = new IOOps();
	
	//Specific program vars
	static String path = "C:\\";
	static final String DONE = date.toString() + " Done :)";
	static final String ERROR_MESSAGE = date.toString() + " Something went wrong!\n";
	
	private void readFile() {
		//Create the object to read the file
		userInput.nextLine(); //Eat the cached key!
		FileReader fr;
		BufferedReader br;
				
		try {
			System.out.println("Name of the file: ");
			String nameOfFile = userInput.next();
			String sCurrentLine;

			fr = new FileReader(path + nameOfFile);
			br = new BufferedReader(fr);

			while((sCurrentLine = br.readLine()) != null){
					System.out.println(sCurrentLine);
				}

				System.out.println(DONE);
			} 
				
		catch(FileNotFoundException e) {
			System.out.println(date.toString() + " - File was not found!\n");
			}
				
		catch (Exception e) {
			System.out.println(date.toString() + " - An error was encountered: " + e + "\n");
			}
						
	}

	private void writeFile() {
		userInput.nextLine(); //Eat the cached key
		System.out.println("Filename: ");
		String file = userInput.nextLine();
		System.out.print("Enter text: ");
		String text = userInput.nextLine();
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
			fWriter = new FileWriter(path + file);
			writer = new BufferedWriter(fWriter);
			writer.write(text);
			writer.newLine();
			writer.close();
			System.out.println(DONE);
		}catch(Exception e) {
			System.out.println(ERROR_MESSAGE);
		}
	}
	
	private void createAFile() {
		userInput.nextLine(); //Eat the cached key
		
		try {
			System.out.print("Name of the file(provide extension): ");
			String nameOfFile = userInput.nextLine();
			
			File file = new File(path + nameOfFile);
			
			//Check if it was created
			if(file.createNewFile()) {
				System.out.println("File was created!");
				System.out.println(DONE);
			}
			
			else {
				System.out.println("File already exists!");
				obj.manageInput();
			}
			
		}
		catch(Exception e ) {
			System.out.println(ERROR_MESSAGE + e);
		}
		
	}
	
	private void changePath() {
		System.out.print("Target full path: ");
		path = userInput.next();
		obj.manageInput();
	}
	
	private void manageInput() {

		int number;
		
		System.out.println("Welcome to this program where you can do a lot of things with files!");
		System.out.println("What would you like to do?");
		System.out.println("1) Create a file");
		System.out.println("2) Read a file");
		System.out.println("3) Write in a file");
		System.out.println("4) Change default path");
		System.out.println("0) Quit");
		System.out.println("PATH: " + path);
		
		while(!userInput.hasNextInt()) {
			userInput.next();
			System.out.println("That's not a number!");
			obj.manageInput();
		}
		
		number = userInput.nextInt();
		
		if(number > 4 || number < 0) {
			System.out.println("Choice out of range, try again!");
			obj.manageInput();
		}
		
		switch(number) {
		case 1:
			obj.createAFile();
			break;
		case 2:
			obj.readFile();
			break;
		case 3:
			obj.writeFile();
			break;
		case 4:
			obj.changePath();
			break;
		case 0:
			System.out.println(date.toString() + " Quiting...\nDone\nGoodbye :)");	
		}//End of switch
		
	}
	
	public static void main(String[] args) {
			obj.manageInput();
		}
	}