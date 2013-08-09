package Merged;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class GenerateCompleteListMerge {

	public static void main(String[] args) {
		
		try {
			
			double cutoff = 0.1;
			LinkedList list = new LinkedList();
			String fileName2 = "C:\\School Notes\\Kelvin_Metagenomics\\uniq.txt";		
		    FileInputStream fstream2 = new FileInputStream(fileName2);
			DataInputStream din2 = new DataInputStream(fstream2); 
			BufferedReader in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();			
				list.add(str);
			}
			in2.close();
			
			HashMap realName = new HashMap();
			fileName2 = "C:\\School Notes\\Kelvin_Metagenomics\\list.txt";		
		    fstream2 = new FileInputStream(fileName2);
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();				
				realName.put(str, str);
			}
			in2.close();
			
			fileName2 = "C:\\School Notes\\Kelvin_Metagenomics\\PrimersUnshelter.txt";		
		    fstream2 = new FileInputStream(fileName2);
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();
				String[] split = str.split("\t");
				Iterator itr = realName.keySet().iterator();
				while (itr.hasNext()) {
					String key = (String)itr.next();
					if (key.contains(split[0] + "_")) {
						System.out.println(str + "\t" + key);
					}
				}
			}
			in2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
