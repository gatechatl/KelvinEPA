package ChimericReads;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ExtractFastaFile {

	public static void main(String[] args) {
		try {
			
			String fileName1 = args[0];
            FileInputStream fstream = new FileInputStream(fileName1);
            DataInputStream din = new DataInputStream(fstream);
            BufferedReader in = new BufferedReader(new InputStreamReader(din));
            while (in.ready()) {
                    String name = in.readLine().split(" ")[0];
                    String sequence = in.readLine();
                    String plus = in.readLine();
                    String quality = in.readLine();
                    System.out.println(name + "\n" + sequence);
            
            }
            in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
