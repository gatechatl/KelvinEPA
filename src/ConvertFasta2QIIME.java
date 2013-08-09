import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class ConvertFasta2QIIME {

	public static void main(String[] args) {
		
		try {
			int index = 1;
			String outputFile = args[1];
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fwriter);
			
			String fileName1 = args[0];	
		    FileInputStream fstream1 = new FileInputStream(fileName1);
			DataInputStream din1 = new DataInputStream(fstream1); 
			BufferedReader in1 = new BufferedReader(new InputStreamReader(din1));
			while (in1.ready()) {
				String str = in1.readLine();			
				if (str.contains(">")) {
					String name = str.replaceAll(">", "");
					name = index + " Sample " + name;
					out.write(">" + name + "\n");
					index++;
				} else {
					out.write(str + "\n");
				}
			}
			in1.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
