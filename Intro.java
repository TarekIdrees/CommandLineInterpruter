import java.util.*;
import java.io.*;

public class Intro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	File f1 = new File("C:\\Users\\Tarek\\Desktop\\Test1MyFile.txt");
	
			
				try {
					f1.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		
		/*try {
            FileReader reader = new FileReader("MyFile.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

          
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
 
        } catch (IOException e) {
           System.out.println("Couldn't read from file");
        }
        
        try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write("Hello World");
            bufferedWriter.newLine();
            bufferedWriter.write("See You Again!");
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	}*/

}
}
