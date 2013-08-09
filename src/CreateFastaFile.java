import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class CreateFastaFile {

	
	public static void main(String[] args) {
		
		try {
			String outputFile = args[1]; //"C:\\School Notes\\Kelvin_Metagenomics\\G3-18U-8_S50_L001_R1_001.fasta";
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fwriter);
			
			String fileName = args[0]; //"C:\\School Notes\\Kelvin_Metagenomics\\G3-18U-8_S50_L001_R1_001.fastq";		
		    FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream din = new DataInputStream(fstream); 
			BufferedReader in = new BufferedReader(new InputStreamReader(din));
			while (in.ready()) {
				String name = in.readLine();
				String seq = in.readLine();
				String rand = in.readLine();
				String qual = in.readLine();
				out.write(">" + name + "\n" + seq + "\n");
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
