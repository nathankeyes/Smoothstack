package AssignmentThree;

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

import java.util.stream.Collectors;

/**
 * @author Nathan Keyes
 * @DateCreated 3/11/21
 * @LastEdited 3/11/21
 * @Description Write a Java program to get a list of all file/directory names
 *              under a given directory - scanner to get path from user
 */

public class FileList {

	public void PrintPath(Path filePath) throws IOException {
		// Path file = Paths.get(filePath);
		// File file = new File("/Smoothstack/src/AssignmentThree");
		// File fileObj = new File(filePath);

		List<Path> listOfPaths;

		try (Stream<Path> walk = Files.walk(filePath)) {
			// this line does a couple things
			// 1. its walks the path
			// 2. walks to path looking for regular files
			// 3. collects changes the output from stream to specified(toList) so that I can
			// save it and read through it later
			listOfPaths = walk.filter(Files::isRegularFile).collect(Collectors.toList());

			for (Path x : listOfPaths)
				System.out.println(x);

		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return;
	}

	public Path ReadInPath() throws IOException {
		String fileString;

		try (Scanner scan = new Scanner(System.in)) {

			System.out.print("Enter file path for directory: ");

			fileString = scan.nextLine();

			Path filePath = Paths.get(fileString);

			return filePath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		FileList obj = new FileList();
		Path path;

		path = obj.ReadInPath();

		System.out.println("Your path: " + path);

		obj.PrintPath(path);
	}

}
