import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;


public class GenerateFastqJoin {

	public static void main(String[] args) {
		
		try {
			
			HashMap realName = new HashMap();
			String fileName2 = "C:\\School Notes\\Kelvin_Metagenomics\\list.txt";		
			FileInputStream fstream2 = new FileInputStream(fileName2);
			DataInputStream din2 = new DataInputStream(fstream2); 
			BufferedReader in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();				
				realName.put(str, str);
			}
			in2.close();
			Iterator itr = realName.keySet().iterator();
			while (itr.hasNext()) {
				String key = (String)itr.next();
				//System.out.println("/usr/local/src/ea-utils.1.1.2-537/fastq-join " + "Kelvin_Reads/" + key + "R1_001.fastq " + "Kelvin_Reads/" + key + "R2_001.fastq -o " + "Kelvin_MergeFasta/" + key + "merge.");
				
				//System.out.println("java CreateFastaFile Kelvin_MergeFasta/" + key + "merge.join Kelvin_MergeFasta/" + key + "merge.fasta");
				
				System.out.println("java -jar /usr/local/src/RDP/rdp_multiclassifier_1.1/MultiClassifier.jar --assign_outfile=Kelvin_Merge_Assign/" + key + "merge.txt --hier_outfile=Kelvin_Merge_Hiarch/" + key + "merge.hiarch --bootstrap_out=Kelvin_Merge_Bootstrap/" + key + "merge.bootstrap Kelvin_MergeFasta/" + key + "merge.fasta");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
