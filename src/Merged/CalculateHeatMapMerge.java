package Merged;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class CalculateHeatMapMerge {
	
	public static void main(String[] args) {
		
		
		try {
			boolean outputCount = false;
			String[] shelters = {"sheltered", "unsheltered"};
			for (String shelter: shelters) {
			//String shelter = "sheltered";
			LinkedList list = new LinkedList();
			String fileName2 = "C:\\School Notes\\Kelvin_Metagenomics\\uniq_" + shelter + ".txt";		
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
			
			HashMap good = new HashMap();
			fileName2 = "C:\\School Notes\\Kelvin_Metagenomics\\FilterReads\\Good_sequence_uchime.txt";		
		    fstream2 = new FileInputStream(fileName2);
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();		
				String[] split = str.split("\t");
				split[0] = split[0].replaceAll(">", "");
				good.put(split[0], split[0]);
			}
			in2.close();
			
			
			HashMap problems = new HashMap();
			fileName2 = "C:\\School Notes\\Kelvin_Metagenomics\\FilterReads\\ProblemReads_Fixed.txt";		
		    fstream2 = new FileInputStream(fileName2);
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();		
				String[] split = str.split("\t");
				split[0] = split[0].replaceAll(">", "");
				problems.put(split[0], split[0]);
			}
			in2.close();
			
			String outputFileDomain = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapDomain" + shelter + ".txt";
			if (outputCount) {
				outputFileDomain = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapDomain" + shelter + "_Count.txt";
			}
			FileWriter fwriterDomain = new FileWriter(outputFileDomain);
			BufferedWriter outDomain = new BufferedWriter(fwriterDomain);
			
			String outputFilePhylum = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapPhylum" + shelter + ".txt";
			if (outputCount) {
				outputFilePhylum = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapPhylum" + shelter + "_Count.txt";
			}
			FileWriter fwriterPhylum = new FileWriter(outputFilePhylum);
			BufferedWriter outPhylum = new BufferedWriter(fwriterPhylum);			
			
			String outputFileClass = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapClass" + shelter + ".txt";
			if (outputCount) {
				outputFileClass = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapClass" + shelter + "_Count.txt";
			}
			FileWriter fwriterClass = new FileWriter(outputFileClass);
			BufferedWriter outClass = new BufferedWriter(fwriterClass);			

			String outputFileOrder = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapOrder" + shelter + ".txt";
			if (outputCount) {
				outputFileOrder = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapOrder" + shelter + "_Count.txt";
			}
			FileWriter fwriterOrder = new FileWriter(outputFileOrder);
			BufferedWriter outOrder = new BufferedWriter(fwriterOrder);			

			String outputFileFamily = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapFamily" + shelter + ".txt";
			if (outputCount) {
				outputFileFamily = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapFamily" + shelter + "_Count.txt";
			}
			FileWriter fwriterFamily = new FileWriter(outputFileFamily);
			BufferedWriter outFamily = new BufferedWriter(fwriterFamily);			

			String outputFileGenus = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapGenus" + shelter + ".txt";
			if (outputCount) {
				outputFileGenus = "C:\\School Notes\\Kelvin_Metagenomics\\Result\\HeatMapGenus" + shelter + "_Count.txt";
			}
			FileWriter fwriterGenus = new FileWriter(outputFileGenus);
			BufferedWriter outGenus = new BufferedWriter(fwriterGenus);			
			
			String path = "C:\\School Notes\\Kelvin_Metagenomics\\ReadMapped\\";
			
			HashMap allDomain = new HashMap();
		    fstream2 = new FileInputStream("C:\\School Notes\\Kelvin_Metagenomics\\Result\\Domain.txt");
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();
				allDomain.put(str,  str);
			}
			in2.close();
			
			
			outDomain.write("Name");
			Iterator itr5 = allDomain.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outDomain.write("\t" + key);
			}
			outDomain.write("\n");
			
			outDomain.write("NORM_MAX");
			itr5 = allDomain.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outDomain.write("\t1.0");
			}
			outDomain.write("\n");
			
			
			
			HashMap allPhylum = new HashMap();
		    fstream2 = new FileInputStream("C:\\School Notes\\Kelvin_Metagenomics\\Result\\Phylum.txt");
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();
				allPhylum.put(str,  str);
			}
			in2.close();
			itr5 = allPhylum.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outPhylum.write("\t" + key);
			}
			outPhylum.write("\n");
			
			outPhylum.write("NORM_MAX");
			itr5 = allPhylum.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outPhylum.write("\t1.0");
			}
			outPhylum.write("\n");			
			
			HashMap allClass = new HashMap();
		    fstream2 = new FileInputStream("C:\\School Notes\\Kelvin_Metagenomics\\Result\\Class.txt");
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();
				allClass.put(str,  str);
			}
			in2.close();
			itr5 = allClass.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outClass.write("\t" + key);
			}
			outClass.write("\n");
			outClass.write("NORM_MAX");
			itr5 = allClass.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outClass.write("\t1.0");
			}
			outClass.write("\n");
			
			HashMap allOrder = new HashMap();
		    fstream2 = new FileInputStream("C:\\School Notes\\Kelvin_Metagenomics\\Result\\Order.txt");
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();
				allOrder.put(str,  str);
			}			
			in2.close();
			itr5 = allOrder.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outOrder.write("\t" + key);
			}
			outOrder.write("\n");
			outOrder.write("NORM_MAX");
			itr5 = allOrder.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outOrder.write("\t1.0");
			}
			outOrder.write("\n");
			
			HashMap allFamily = new HashMap();
		    fstream2 = new FileInputStream("C:\\School Notes\\Kelvin_Metagenomics\\Result\\Family.txt");
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();
				allFamily.put(str,  str);
			}
			in2.close();
			itr5 = allFamily.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outFamily.write("\t" + key);
			}
			outFamily.write("\n");
			outFamily.write("NORM_MAX");
			itr5 = allFamily.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outFamily.write("\t1.0");
			}
			outFamily.write("\n");
			
			HashMap allGenus = new HashMap();
		    fstream2 = new FileInputStream("C:\\School Notes\\Kelvin_Metagenomics\\Result\\Genus.txt");
			din2 = new DataInputStream(fstream2); 
			in2 = new BufferedReader(new InputStreamReader(din2));
			while (in2.ready()) {
				String str = in2.readLine();
				allGenus.put(str,  str);
			}
			in2.close();
			itr5 = allGenus.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outGenus.write("\t" + key);
			}
			outGenus.write("\n");
			outGenus.write("NORM_MAX");
			itr5 = allGenus.keySet().iterator();
			while (itr5.hasNext()) {
				String key = (String)itr5.next();
				outGenus.write("\t1.0");
			}
			outGenus.write("\n");		
			
			Iterator allitr = list.iterator();
			while (allitr.hasNext()) {
				String sample = (String)allitr.next();
				String forward = "";
				String reverse = "";
				Iterator finditr = realName.keySet().iterator();
				while (finditr.hasNext()) {
					String key = (String)finditr.next();
					if (key.contains(sample)) {
						forward = key + "merge.txt";
						
					}
				}
				
				File f = new File(path + forward);				
				System.out.println(forward);
				if (f.exists()) {
					
					double confidence = 0.7;
					HashMap mapF = new HashMap();
					HashMap mapR = new HashMap();
								
					HashMap mapDomain = new HashMap();
					HashMap mapPhylum = new HashMap();
					HashMap mapClass = new HashMap();
					HashMap mapOrder = new HashMap();
					HashMap mapFamily = new HashMap();
					HashMap mapGenus = new HashMap();
					
					fileName2 = path + forward;		
				    fstream2 = new FileInputStream(fileName2);
					din2 = new DataInputStream(fstream2); 
					in2 = new BufferedReader(new InputStreamReader(din2));
					while (in2.ready()) {
						String str = in2.readLine();
						String[] split = str.split("\t");
						//System.out.println(str);
						Data data = new Data();
						data.NAME = split[0];
						data.DOMAIN = grabString(str, "domain");
						data.DOMAINP = grabP(str, "domain");
						data.PHYLUM = grabString(str, "phylum");
						data.PHYLUMP = grabP(str, "phylum");
						data.CLASS = grabString(str, "class");
						data.CLASSP = grabP(str, "class");
						data.SUBCLASS = grabString(str, "subclass");
						data.SUBCLASSP = grabP(str, "subclass");
						data.ORDER = grabString(str, "order");;
						data.ORDERP = grabP(str, "order");
						data.SUBORDER = grabString(str, "suborder");
						data.SUBORDERP = grabP(str, "suborder");
						data.FAMILY = grabString(str, "family");
						data.FAMILYP = grabP(str, "family");
						data.GENUS = grabString(str, "genus");
						data.GENUSP = grabP(str, "genus");
						
						if (!problems.containsKey(data.NAME) && good.containsKey(data.NAME)) {
						//if (!problems.containsKey(data.NAME)) {
							mapF.put(data.NAME, data);
							mapR.put(data.NAME, data);
						}
					}
					
					
					
					Iterator itr = mapF.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						if (mapR.containsKey(key)) {
							Data dataF = (Data)mapF.get(key);
							Data dataR = (Data)mapR.get(key);
							
							if (dataF.DOMAIN.equals(dataR.DOMAIN) && dataF.DOMAINP > confidence && dataR.DOMAINP > confidence){
								if (mapDomain.containsKey(dataF.DOMAIN)) {
									int num = (Integer)mapDomain.get(dataF.DOMAIN);
									num++;
									mapDomain.put(dataF.DOMAIN, num);
								} else {
									mapDomain.put(dataF.DOMAIN, 1);
								}
							} else if (dataF.DOMAINP >= dataR.DOMAINP && dataF.DOMAINP > confidence) {
								if (mapDomain.containsKey(dataF.DOMAIN)) {
									int num = (Integer)mapDomain.get(dataF.DOMAIN);
									num++;
									mapDomain.put(dataF.DOMAIN, num);
								} else {
									mapDomain.put(dataF.DOMAIN, 1);
								}
							} else if (dataR.DOMAINP > dataF.DOMAINP && dataR.DOMAINP > confidence){
								if (mapDomain.containsKey(dataR.DOMAIN)) {
									int num = (Integer)mapDomain.get(dataR.DOMAIN);
									num++;
									mapDomain.put(dataR.DOMAIN, num);
								} else {
									mapDomain.put(dataR.DOMAIN, 1);
								}								
							}
							
							if (dataF.PHYLUM.equals(dataR.PHYLUM) && dataF.PHYLUMP > confidence && dataR.PHYLUMP > confidence){
								if (mapPhylum.containsKey(dataF.PHYLUM)) {
									int num = (Integer)mapPhylum.get(dataF.PHYLUM);
									num++;
									mapPhylum.put(dataF.PHYLUM, num);
								} else {
									mapPhylum.put(dataF.PHYLUM, 1);
								}
							} else if (dataF.PHYLUMP >= dataR.PHYLUMP && dataF.PHYLUMP > confidence) {
								if (mapPhylum.containsKey(dataF.PHYLUM)) {
									int num = (Integer)mapPhylum.get(dataF.PHYLUM);
									num++;
									mapPhylum.put(dataF.PHYLUM, num);
								} else {
									mapPhylum.put(dataF.PHYLUM, 1);
								}
							} else if (dataR.PHYLUMP > dataF.PHYLUMP && dataR.PHYLUMP > confidence) {
								if (mapPhylum.containsKey(dataR.PHYLUM)) {
									int num = (Integer)mapPhylum.get(dataR.PHYLUM);
									num++;
									mapPhylum.put(dataR.PHYLUM, num);
								} else {
									mapPhylum.put(dataR.PHYLUM, 1);
								}
							}
							
							if (dataF.CLASS.equals(dataR.CLASS) && dataF.CLASSP > confidence && dataR.CLASSP > confidence){
								if (mapClass.containsKey(dataF.CLASS)) {
									int num = (Integer)mapClass.get(dataF.CLASS);
									num++;
									mapClass.put(dataF.CLASS, num);
								} else {
									mapClass.put(dataF.CLASS, 1);
								}
							} else if (dataF.CLASSP >= dataR.CLASSP && dataF.CLASSP > confidence) {								
								if (mapClass.containsKey(dataF.CLASS)) {
									int num = (Integer)mapClass.get(dataF.CLASS);
									num++;
									mapClass.put(dataF.CLASS, num);
								} else {
									mapClass.put(dataF.CLASS, 1);
								}
							} else if (dataR.CLASSP > dataF.CLASSP && dataR.CLASSP > confidence) {
								if (mapClass.containsKey(dataR.CLASS)) {
									int num = (Integer)mapClass.get(dataR.CLASS);
									num++;
									mapClass.put(dataR.CLASS, num);
								} else {
									mapClass.put(dataR.CLASS, 1);
								}								
							}
							
							if (dataF.ORDER.equals(dataR.ORDER) && dataF.ORDERP > confidence && dataR.ORDERP > confidence){
								if (mapOrder.containsKey(dataF.ORDER)) {
									int num = (Integer)mapOrder.get(dataF.ORDER);
									num++;
									mapOrder.put(dataF.ORDER, num);
								} else {
									mapOrder.put(dataF.ORDER, 1);
								}
							} else if (dataF.ORDERP >= dataR.ORDERP && dataF.ORDERP > confidence) {
								if (mapOrder.containsKey(dataF.ORDER)) {
									int num = (Integer)mapOrder.get(dataF.ORDER);
									num++;
									mapOrder.put(dataF.ORDER, num);
								} else {
									mapOrder.put(dataF.ORDER, 1);
								}
							} else if (dataR.ORDERP > dataF.ORDERP && dataR.ORDERP > confidence) {
								if (mapOrder.containsKey(dataR.ORDER)) {
									int num = (Integer)mapOrder.get(dataR.ORDER);
									num++;
									mapOrder.put(dataR.ORDER, num);
								} else {
									mapOrder.put(dataR.ORDER, 1);
								}
							}
							
							if (dataF.FAMILY.equals(dataR.FAMILY) && dataF.FAMILYP > confidence && dataR.FAMILYP > confidence){
								if (mapFamily.containsKey(dataF.FAMILY)) {
									int num = (Integer)mapFamily.get(dataF.FAMILY);
									num++;
									mapFamily.put(dataF.FAMILY, num);
								} else {
									mapFamily.put(dataF.FAMILY, 1);
								}
							} else if (dataF.FAMILYP >= dataR.FAMILYP && dataF.FAMILYP > confidence) {
								if (mapFamily.containsKey(dataF.FAMILY)) {
									int num = (Integer)mapFamily.get(dataF.FAMILY);
									num++;
									mapFamily.put(dataF.FAMILY, num);
								} else {
									mapFamily.put(dataF.FAMILY, 1);
								}
							} else if (dataR.FAMILYP > dataF.FAMILYP && dataR.FAMILYP > confidence) {
								if (mapFamily.containsKey(dataR.FAMILY)) {
									int num = (Integer)mapFamily.get(dataR.FAMILY);
									num++;
									mapFamily.put(dataR.FAMILY, num);
								} else {
									mapFamily.put(dataR.FAMILY, 1);
								}
							}
							
							if (dataF.GENUS.equals(dataR.GENUS) && dataF.GENUSP > confidence && dataR.GENUSP > confidence){
								if (mapGenus.containsKey(dataF.GENUS)) {
									int num = (Integer)mapGenus.get(dataF.GENUS);
									num++;
									mapGenus.put(dataF.GENUS, num);
								} else {
									mapGenus.put(dataF.GENUS, 1);
								}
							} else if (dataF.GENUSP >= dataR.GENUSP && dataF.GENUSP > confidence) {
								if (mapGenus.containsKey(dataF.GENUS)) {
									int num = (Integer)mapGenus.get(dataF.GENUS);
									num++;
									mapGenus.put(dataF.GENUS, num);
								} else {
									mapGenus.put(dataF.GENUS, 1);
								}
							} else if (dataR.GENUSP > dataF.GENUSP && dataR.GENUSP > confidence) {
								if (mapGenus.containsKey(dataR.GENUS)) {
									int num = (Integer)mapGenus.get(dataR.GENUS);
									num++;
									mapGenus.put(dataR.GENUS, num);
								} else {
									mapGenus.put(dataR.GENUS, 1);
								}
							}
						}								
					}
					double domainTotal = 0;
					double phylumTotal = 0;
					double classTotal = 0;
					double orderTotal = 0;
					double familyTotal = 0;
					double genusTotal = 0;
					
					itr = mapDomain.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						domainTotal += (Integer)mapDomain.get(key);
						
					}
					itr = mapPhylum.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						phylumTotal += (Integer)mapPhylum.get(key);
					}
					
					itr = mapClass.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						classTotal += (Integer)mapClass.get(key);
					}
					
					itr = mapOrder.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						orderTotal += (Integer)mapOrder.get(key);
					}
					
					itr = mapFamily.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						familyTotal += (Integer)mapFamily.get(key);
					}
					
					itr = mapGenus.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						genusTotal += (Integer)mapGenus.get(key);
					}
					
					outDomain.write(sample);
					itr = allDomain.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						double proportion = 0;
						if (mapDomain.containsKey(key)) {
							if (outputCount) {
								proportion = new Double((Integer)mapDomain.get(key));
							} else {
								proportion = new Double((Integer)mapDomain.get(key)) / domainTotal;
							}
						}
						outDomain.write("\t" + proportion);
					}
					outDomain.write("\n");
					
					outPhylum.write(sample);
					itr = allPhylum.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						double proportion = 0;
						if (mapPhylum.containsKey(key)) {
							if (outputCount) {
								proportion = new Double((Integer)mapPhylum.get(key));
							} else {
								proportion = new Double((Integer)mapPhylum.get(key)) / phylumTotal;
							}
						}
						outPhylum.write("\t" + proportion);
					}
					outPhylum.write("\n");
					
					outClass.write(sample);
					itr = allClass.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						double proportion = 0;
						if (mapClass.containsKey(key)) {
							if (outputCount) {
								proportion = new Double((Integer)mapClass.get(key));
							} else {
								proportion = new Double((Integer)mapClass.get(key)) / classTotal;
							}
						}
						outClass.write("\t" + proportion);
					}
					outClass.write("\n");
					
					outOrder.write(sample);
					itr = allOrder.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						double proportion = 0;
						if (mapOrder.containsKey(key)) {
							if (outputCount) {
								proportion = new Double((Integer)mapOrder.get(key));
							} else {
								proportion = new Double((Integer)mapOrder.get(key)) / orderTotal;
							}
						}
						outOrder.write("\t" + proportion);
					}
					outOrder.write("\n");
					
					outFamily.write(sample);
					itr = allFamily.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						double proportion = 0;
						if (mapFamily.containsKey(key)) {
							if (outputCount) {
								proportion = new Double((Integer)mapFamily.get(key));
							} else {
								proportion = new Double((Integer)mapFamily.get(key)) / familyTotal;
							}
						}
						outFamily.write("\t" + proportion);
					}
					outFamily.write("\n");

					outGenus.write(sample);
					itr = allGenus.keySet().iterator();
					while (itr.hasNext()) {
						String key = (String)itr.next();
						double proportion = 0;
						if (mapGenus.containsKey(key)) {
							if (outputCount) {
								proportion = new Double((Integer)mapGenus.get(key));
							} else {
								proportion = new Double((Integer)mapGenus.get(key)) / genusTotal;
							}
						}
						outGenus.write("\t" + proportion);
					}
					outGenus.write("\n");
					/*System.out.println(domainTotal);
					System.out.println(phylumTotal);
					System.out.println(classTotal);
					
					System.out.println(orderTotal);
					System.out.println(familyTotal);
					System.out.println(genusTotal);*/
				}// exist file
				
			} // loop each file
			
			outDomain.close();
			outPhylum.close();
			outClass.close();
			outOrder.close();
			outFamily.close();
			outGenus.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String grabString(String line, String type) {
		String[] split = line.split("\t");
		for (int i = 0; i < split.length; i++) {
			if (split[i].equals(type)) {
				return split[i - 1];
			}
		}
		return "";
	}
	public static double grabP(String line, String type) {
		String[] split = line.split("\t");
		for (int i = 0; i < split.length; i++) {
			if (split[i].equals(type)) {
				return new Double(split[i + 1]);
			}
		}
		return -1;
	}
	public static class Data {
		
		public String NAME = "";
		public String DOMAIN = "";
		public String PHYLUM = "";
		public String CLASS = "";
		public String SUBCLASS = "";
		public String ORDER = "";
		public String SUBORDER = "";
		public String FAMILY = "";
		public String GENUS = "";
		
		public double DOMAINP = 0;		
		public double PHYLUMP = 0;
		public double CLASSP = 0;
		public double SUBCLASSP = 0;
		public double ORDERP = 0;
		public double SUBORDERP = 0;
		public double FAMILYP = 0;
		public double GENUSP = 0;
		
	}			
}

