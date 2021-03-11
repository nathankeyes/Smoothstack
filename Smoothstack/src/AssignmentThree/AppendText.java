package AssignmentThree;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;

import java.io.IOException;

import java.util.Scanner;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/11/21
 * @LastEdited  3/11/21
 * @Description Write a java program to append text to an existing file
 */

public class AppendText {
	
	public void AppendToFile(Path filePath, String message) throws IOException{
		try {
			Files.write(filePath, message.getBytes(), StandardOpenOption.APPEND);
			System.out.println("File Appended");
			return;
		}
		catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	// continues to break at the messageString = scan.nextLine()
	// not sure what it is, but i moved the scan into main function and happen before the path call and it started working
	// truly no idea, COME BACK TO FIX ************************************************
	/*
	public String NewMessage() throws IOException {
		String messageString;
		
		try ( Scanner scan = new Scanner(System.in) ) {
			System.out.println("Enter message to be appended: ");
			
			messageString = scan.nextLine();
			
			System.out.println("Inputted Message: " + messageString);
			
			
			return messageString;
		}
		catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
	*/
	
	public Path ReadInPath() throws IOException {
		String fileString;
		
		try ( Scanner scan = new Scanner(System.in) ) {
			System.out.print("Enter file to .txt: ");
	
			fileString = scan.nextLine();
		
			
			Path filePath = Paths.get(fileString);
			
			
			// file input type stuff, couldn't get it to work so just checking if file exists or not, will have to come back
			/*
			System.out.println("File type: " + Files.probeContentType(filePath));
			
			if ( Files.probeContentType(filePath) != "text/plain") {
				System.out.print("Incorrect file type for appending, try again");
				return null;
			}
			*/
			System.out.println("Inputted Path: " + filePath);
			
			if ( Files.exists(filePath) ) {
				return filePath;
			}
			else
			{
				System.out.println("File does not exist");
				return null;
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
		

	}
	

	public static void main(String[] args) throws IOException{
		AppendText appTextObj = new AppendText();
		Path pathToFile;
		String message;
		
		//message = appTextObj.NewMessage();
		
		// some reason my scan refused to work after the scan reading in the path, so i had to just put this here
		// tried moving funciton call before hand, but still breaks
		// ---- user input message ------
		
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter message to be appended: ");
		message = scan.nextLine();
		
		scan.close();
		
		
		pathToFile = appTextObj.ReadInPath();
		

		if ( pathToFile == null )
			return;
		else 			
			appTextObj.AppendToFile(pathToFile, message);
	
		
	}

}
