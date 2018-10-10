/**
 * 
 */
package hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author kxhb130
 *
 */
public class ReadFile {

	static void readFile(String fileName, int d, int r) throws Exception {
		File file = new File(fileName);
		BufferedReader buf = null;
		int f = d/r;
		try {
			if (!file.exists()) {
				throw new Exception("File Does not exists");
			}
			
			buf = new BufferedReader(new FileReader(file));
			while(buf.ready()) {
				System.out.println(buf.readLine());
			}
		} catch (Exception ex) {
			 System.out.println(ex.getMessage());
			throw new Exception("file");
		} finally {
			try {
				if (buf != null)
					buf.close();;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void fileReader(String fileName) {
		FileReader file = null;
		try {
			file  = new FileReader(fileName);
			while (file.ready()) {
				System.out.println(file.read() +" "+ (char)file.read());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// readFile("/Users/kxhb130/Desktop/Untitled.sql", 1, 1);
		fileReader("/Users/kxhb130/Desktop/Untitled.sql");
	}

}
