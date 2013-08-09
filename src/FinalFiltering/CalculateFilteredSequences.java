package FinalFiltering;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class CalculateFilteredSequences {

	public static void main(String[] args) {
		
		try {
			
			
			double total = 0;
			double good = 0;
			// grab all names

			// original file
			
			HashMap list = new HashMap();
			String fileName1 = "list.txt";		
		    FileInputStream fstream1 = new FileInputStream(fileName1);
			DataInputStream din1 = new DataInputStream(fstream1); 
			BufferedReader in1 = new BufferedReader(new InputStreamReader(din1));
			while (in1.ready()) {
				String str = in1.readLine();			
				list.put(str, str);
			}
			in1.close();

			String outputFile = "Good_sequence_uchime.txt";
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fwriter);
			
			Iterator itr2 = list.keySet().iterator();
			while (itr2.hasNext()) {
				
				HashMap map = new HashMap();
				HashMap index = new HashMap();
				
				String str2 = (String)itr2.next();
				String fileName2 = "Derep_report/" + str2 + "merge_derep.uc";//args[0];
				
				FileInputStream fstream2 = new FileInputStream(fileName2);
				DataInputStream din2 = new DataInputStream(fstream2); 
				BufferedReader in2 = new BufferedReader(new InputStreamReader(din2));
				while (in2.ready()) {
					String str = in2.readLine();				
					String[] split = str.split("\t");
					if (split[0].equals("S")) {
						map.put(split[8], split[8]);
						
						index.put(split[8], split[8]);
					} else if (split[0].equals("H")) {
						String keyName = split[9];
						if (index.containsKey(keyName)) {
							String stuff = (String)index.get(keyName);
							stuff += "\t" + split[8];
							index.put(keyName, stuff);
							//System.out.println("Adding");
						}
						map.put(split[8], keyName);
						
					} else if (split[0].equals("C")) {
						map.put(split[8], split[8]);
						index.put(split[8], split[8]);
					} else {
						System.out.println(str);
					}
				}
				in2.close();
				
				HashMap afterUchime = new HashMap();
				fileName2 = "uchime_fasta/" + str2 + "merge_uchime.fasta";//args[1];		
				fstream2 = new FileInputStream(fileName2);
				din2 = new DataInputStream(fstream2); 
				in2 = new BufferedReader(new InputStreamReader(din2));
				while (in2.ready()) {			
					String str = in2.readLine();
					if (str.contains(">")) {
						String name = str.replaceAll(">", "").split(";")[0];
						if (map.containsKey(name)) {
							if (index.containsKey(name)) {
								afterUchime.put(name, name);
								String stuff = (String)index.get(name);
								String[] split = stuff.split("\t");
								for (String s: split) {
									afterUchime.put(s,  s);
								}
							} else {
								//System.out.println("Something wrong");
							}												
						}
											
					}
				}
				in2.close();
				
				total += map.size();
				good += afterUchime.size();
				
				Iterator itr = afterUchime.keySet().iterator();
				while (itr.hasNext()) {
					String key = (String)itr.next();
					out.write(">" + key + "\t" + str2 + "\n");
				}
				
			}
			out.close();
			System.out.println(total);
			System.out.println(good);
			System.out.println(good / total);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
