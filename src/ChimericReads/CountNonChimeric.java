package ChimericReads;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CountNonChimeric {

	
	public static void main(String[] args) {
		
		try {
			
			int biggest = 0;
			int size = 0;
			String fileName1 = "C:\\School Notes\\Kelvin_Metagenomics\\NonChimeric\\example.fasta";
            FileInputStream fstream = new FileInputStream(fileName1);
            DataInputStream din = new DataInputStream(fstream);
            BufferedReader in = new BufferedReader(new InputStreamReader(din));
            while (in.ready()) {
                    String name = in.readLine();
                    if (name.contains(">")) {
                    	String[] split = name.split(";");
                    	String val = split[split.length - 1];
                    	String num = val.split("=")[1];
                    	size += new Integer(num);
                    	if (biggest < new Integer(num)) {
                    		biggest = new Integer(num);
                    		System.out.println(biggest);
                    	}
                    	//System.out.println(size);
                    }
                    
                    
            
            }
            in.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
