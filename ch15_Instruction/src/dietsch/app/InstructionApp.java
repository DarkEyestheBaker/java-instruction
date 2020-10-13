package dietsch.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InstructionApp {

	public static void main(String[] args) {

//		String dirString = "C:/Users/Scott/Desktop/Java/files";
//		Path dirPath = Paths.get(dirString);
//		System.out.println("exists returns: " + Files.exists(dirPath) + "  dat, homie!");
//
//		String fileString = ("products.txt");
//		Path filePath = Paths.get(dirString, fileString);
//		System.out.println("exists returns: " + Files.exists(filePath) + "  dat, homie!");
//
//		if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
//			System.out.println("Directory: " + dirPath.toAbsolutePath());
//			System.out.println("Files: ");
//
//			DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirPath);
//
//			for (Path p : dirStream) {
//				if (Files.isRegularFile(p)) {
//					System.out.println("    " + p.getFileName());
//				}
//			}
//		}

		Path productsPath = Paths.get("products.txt");
		File productsFile = productsPath.toFile();

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(productsFile)))) {

			out.println("Tim Curry");
			out.println("Eileen Brennan");
		} catch (IOException e) {
			System.out.println(e);
		}
		try (BufferedReader in = new BufferedReader(new FileReader(productsFile))) {
			String line = in.readLine();
			while (line != null) {
				System.out.println(line);
				line = in.readLine();
			}
			System.out.println(line);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
