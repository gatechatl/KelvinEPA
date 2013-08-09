package FinalFiltering;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FilterIllegalCharacters {

	public static void main(String[] args) {
		
		try {
			
			String outputFile = args[1];
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fwriter);
			
			String fileName1 = args[0];	
		    FileInputStream fstream1 = new FileInputStream(fileName1);
			DataInputStream din1 = new DataInputStream(fstream1); 
			BufferedReader in1 = new BufferedReader(new InputStreamReader(din1));
			while (in1.ready()) {
				String name = in1.readLine();
				String seq = in1.readLine();
				for (int i = 0; i < seq.length(); i++) {
					String a = seq.substring(i, i + 1);
					if (a.equals("A") || a.equals("G") || a.equals("C") || a.equals("U") || a.equals("T")) {
						out.write(name + "\n" + seq + "\n");
					}
				}
			}
			in1.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
