package ChimericReads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CheckChimericReads {

	public static void main(String[] args) {
		try {
			
			String fileName2 = "C:\\School Notes\\Kelvin_Metagenomics\\FilterReads\\ProblemReads_Fixed.txt";		
			/*String outputFile = args[1];
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fwriter);
			*/
			HashMap problems = new HashMap();
		    FileInputStream fstream2 = new FileInputStream(fileName2);
			DataInputStream din2 = new DataInputStream(fstream2); 
			BufferedReader in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {				
				String str = in2.readLine();		
				String[] split = str.split("\t");
				split[0] = split[0].replaceAll(">", "");
				if (split[1].equals("G2-9U-0_S22_L001_")) {
					problems.put(split[0], split[0]);
				}
			}
			in2.close();
			
			int count = 0;
			String fileName = "C:\\School Notes\\Kelvin_Metagenomics\\FilterReads\\G2-9U-0_S22_L001_merge_trimmed.fasta";
			fstream2 = new FileInputStream(fileName);
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {				
				String str = in2.readLine();	
				str = str.replaceAll(" ", "");
				if (str.contains(">")) {
					if (problems.containsKey(str.replaceAll(">", ""))) {
						count++;
					}
				}
			}
			in2.close();
			System.out.println(problems.size());
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
