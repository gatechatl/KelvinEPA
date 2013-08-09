import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class FilterBadReads {

	
	public static void main(String[] args) {
		
		try {
			
			LinkedList list = new LinkedList();
			String fileName2 = args[0];		
			String path = args[1];
			String problemFile = args[2];

			String outputFile = problemFile;
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fwriter);
			
		    FileInputStream fstream2 = new FileInputStream(fileName2);
			DataInputStream din2 = new DataInputStream(fstream2); 
			BufferedReader in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();
				String[] split = str.split("\t");
				String forward = split[1].toUpperCase();
				String reverse = split[2].toUpperCase();
				String fileNameF = split[3] + "R1_001.fasta";
				String fileNameR = split[3] + "R2_001.fasta";
				
				HashMap problem = new HashMap();
				String name = "";
				
				String fileName = path + "/" + fileNameF;		
			    FileInputStream fstream = new FileInputStream(fileName);
				DataInputStream din = new DataInputStream(fstream); 
				BufferedReader in = new BufferedReader(new InputStreamReader(din));
				while (in.ready()) {
					String str2 = in.readLine();
					if (str2.contains(">")) {						
						name = str2.split(" ")[0];
						
					} else {
						String tag = str2.substring(0, forward.length());
						if (!tag.equals(forward)) {
							problem.put(name, name);
						}
					}
				}
				in.close();
				
				fileName = path + "/" + fileNameR;		
			    fstream = new FileInputStream(fileName);
				din = new DataInputStream(fstream); 
				in = new BufferedReader(new InputStreamReader(din));
				while (in.ready()) {
					String str2 = in.readLine();
					if (str2.contains(">")) {						
						name = str2.split(" ")[0];						
					} else {
						String tag = str2.substring(0, reverse.length());
						if (!tag.equals(reverse)) {
							problem.put(name, name);
						}
					}
				}
				in.close();				
				
				Iterator itr = problem.keySet().iterator();
				while (itr.hasNext()) {
					String key = (String)itr.next();										
					out.write(key + "\n");
				}
			
			}
			in2.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
