package ReplaceString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StringFile {

	static void StringModify(String filePath, String oldString, String newString) {
		File fileModified = new File("E:/String.txt");

		String oldContent = "";

		BufferedReader reader = null;

		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileModified));

			//Reading all the lines of input text file 			
			String line = reader.readLine();

			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}

			//Replacing old String with new string
			
			String newContent = oldContent.replaceAll(oldString, newString);  

			writer = new FileWriter(fileModified); // Rewriting the input text file with new content
														

			writer.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // Finally Block is created to close input and output stream
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		StringModify("E:/String.txt", "C", "Java");
		StringModify("E:/String.txt", "HTML", "Phython");

		System.out.println("Replaced sucessfully");
	}
}
