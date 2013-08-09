package ChimericReads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CheckPairedEnds {

        public static void main(String[] args) {

        		HashMap map = new HashMap();
        		
                String fileName1 = args[0];
                String fileName2 = args[1];
                String outputFile1 = args[2];
                String outputFile2 = args[3];
                try {
                        
                        HashMap containBoth = new HashMap();
                        FileInputStream fstream = new FileInputStream(fileName1);
                        DataInputStream din = new DataInputStream(fstream);
                        BufferedReader in = new BufferedReader(new InputStreamReader(din));
                        while (in.ready()) {
                                String name = in.readLine().split(" ")[0];
                                String sequence = in.readLine();
                                String plus = in.readLine();
                                String quality = in.readLine();
                                map.put(name,  name);
                        
                        }
                        in.close();

                        int countSecondFile = 0;
                        FileInputStream fstream2 = new FileInputStream(fileName2);
                        DataInputStream din2 = new DataInputStream(fstream2);
                        BufferedReader in2 = new BufferedReader(new InputStreamReader(din2));
                        while (in2.ready()) {
                                String name = in2.readLine().split(" ")[0];
                                String sequence = in2.readLine();
                                String plus = in2.readLine();
                                String quality = in2.readLine();
                                if (map.containsKey(name)) {
                                	containBoth.put(name, name);
                                }
                                countSecondFile++;
                        }
                        in2.close();


                        FileWriter fwriter = new FileWriter(outputFile1);
                        BufferedWriter out = new BufferedWriter(fwriter);

                        
                        fstream = new FileInputStream(fileName1);
                        din = new DataInputStream(fstream);
                        in = new BufferedReader(new InputStreamReader(din));
                        while (in.ready()) {
                                String name = in.readLine().split(" ")[0];
                                String sequence = in.readLine();
                                String plus = in.readLine();
                                String quality = in.readLine();
                                if (containBoth.containsKey(name)) {
                                	out.write(name + "\n" + sequence + "\n" + plus + "\n" + quality + "\n");
                                }
                                
                        }
                        in.close();
                        out.close();

                        fwriter = new FileWriter(outputFile2);
                        out = new BufferedWriter(fwriter);

                        
                        fstream2 = new FileInputStream(fileName2);
                        din2 = new DataInputStream(fstream2);
                        in2 = new BufferedReader(new InputStreamReader(din2));
                        while (in2.ready()) {
                                String name = in2.readLine().split(" ")[0];
                                String sequence = in2.readLine();
                                String plus = in2.readLine();
                                String quality = in2.readLine();
                                if (containBoth.containsKey(name)) {
                                	out.write(name + "\n" + sequence + "\n" + plus + "\n" + quality + "\n");
                                }
                        
                        }
                        in2.close();

                        out.close();

                        int total = 0;
                        fstream = new FileInputStream(outputFile1);
                        din = new DataInputStream(fstream);
                        in = new BufferedReader(new InputStreamReader(din));
                        while (in.ready()) {
                        	String str = in.readLine();
                        	total++;
                        }
                        int total2 = 0;
                        fstream = new FileInputStream(outputFile2);
                        din = new DataInputStream(fstream);
                        in = new BufferedReader(new InputStreamReader(din));
                        while (in.ready()) {
                        	String str = in.readLine();
                        	total2++;
                        }
                        if (total == total2) {
                        	System.out.println("Same");
                        } else {
                        	System.out.println("Different");
                        }
                } catch (Exception e) {
                	e.printStackTrace();
                }
        }
}
 
                