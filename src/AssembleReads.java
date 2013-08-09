import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import jaligner.*;
import jaligner.formats.Pair;
import jaligner.matrix.Matrix;
import jaligner.matrix.MatrixLoader;
import jaligner.matrix.MatrixLoaderException;

public class AssembleReads {

	public static void main(String[] args) {
		
		try {
			
			int p = 0;
			
			
			int min = 30;
			int max = 85;
			
			String outputFile = "C:\\School Notes\\Kelvin_Metagenomics\\G3-18U-8_S50_L001.fasta";
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fwriter);

			String fileName2 = "C:\\School Notes\\Kelvin_Metagenomics\\G3-18U-8_S50_L001_R2_001.fastq";		
		    FileInputStream fstream2 = new FileInputStream(fileName2);
			DataInputStream din2 = new DataInputStream(fstream2); 
			BufferedReader in2 = new BufferedReader(new InputStreamReader(din2));
			
			int count = 0;			
			
			String fileName = "C:\\School Notes\\Kelvin_Metagenomics\\G3-18U-8_S50_L001_R1_001.fastq";		
		    FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream din = new DataInputStream(fstream); 
			BufferedReader in = new BufferedReader(new InputStreamReader(din));
			while (in.ready()) {
				String name1 = in.readLine();
				String seq1 = in.readLine().toUpperCase();
				String rand1 = in.readLine();
				String qual1 = in.readLine();
												
				String name2 = in2.readLine();
				String seq2 = in2.readLine().toUpperCase();
				String rand2 = in2.readLine();
				String qual2 = in2.readLine();
																
				System.out.println(">Forward\n" + seq1);
				System.out.println(">Reverse\n" + reverseComplement(seq2));
				//System.exit(0);
				//alignReads(seq1, seq2);
				//if (count == 1) {
				String finalseq = alignReads(seq1, reverseComplement(seq2), min, max);
				if (finalseq.equals("")) {
					System.out.println(name1);
					System.out.println(name2);
					System.exit(0);
				}
				out.write(">" + name1 + "\n" + finalseq + "\n");
				//}
				//if (count > 1000) {
				//	System.exit(0);
				//}
				//String finalseq = alignReads(seq1, seq2);
				//out.write(">" + name1 + "\n" + finalseq + "\n");
				//System.out.println(count++);
				count++;
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String alignReads(String forward, String reverse, int min, int max) {

		if (forward.length() < max) {
			max = forward.length();
		}
		if (reverse.length() < max) {
			max = reverse.length();
		}
		int scores = 0;
		
		String combined = "";
		if (max > min) {
			for (int i = min; i < max; i++) {
				String subforward = forward.substring(forward.length() - i, forward.length());
				String subreverse = reverse.substring(0, i);							
				Sequence f = new Sequence(subforward);
				Sequence r = new Sequence(subreverse);
				float[] score = getAlignmentScore(f, r);
				
				//System.out.println(score[0] + "\t" + score[1] + "\t" + score[2] + "\t" + score[3]);
				if (score[1] > 0.8 && score[2] > 50) {
					if (scores < score[0]) {
						System.out.println(i);
						System.out.println(subforward);
						System.out.println(subreverse);
						System.out.println(score[0] + "\t" + score[1] + "\t" + score[2] + "\t" + score[3]);
						combined = forward.substring(0, forward.length()) + reverse.substring(i, reverse.length()); 
						System.out.println(combined);
						System.out.println(forward);
						System.out.println(reverse);
						
						
						scores = (int)score[0];
					}
					
					
				}
			}						
		}
		if (scores > 0) {
			return combined;
			
		}
		return "";
	}
	public static float[] getAlignmentScore(Sequence forward, Sequence reverse) {
		Alignment align;
		float[] f = new float[5];
		try {
			
			
			align = SmithWatermanGotoh.align(forward, reverse, MatrixLoader.load("BLOSUM62"), 10f, 10f);
		
			System.out.println(align.getSummary());
			
			
			System.out.println(align.calculateScore());
			//System.out.println(align.getScore());
			System.out.println(new Pair().format(align));
			f[0] = align.getScore();
			f[1] = (float)align.getIdentity();
			f[2] = (float)align.getSimilarity();
			f[3] = (float)align.getMarkupLine().length;
			f[4] = (float)align.getStart2();
			f[1] = f[1] / f[3];
			return f;

		} catch (MatrixLoaderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
/*	public static String alignReads(String forward, String reverse) {
		int maxmatch = 0;
		String finalAlign = "";
		String compl = reverseComplement(reverse);
		for (int j = forward.length() - 1; j >= 0; j--) {
			
			int overlap = forward.length() - j;
			if (reverse.length() > overlap) {
				String seq1 = forward.substring(j, forward.length());
				String seq2 = reverse.substring(0, overlap);
				int hit = countHit(seq1, seq2);
				if (maxmatch < hit) {
					maxmatch = hit;
					finalAlign = forward.substring(0, forward.length()) + reverse.substring(overlap, reverse.length());					
				}
			}
		}
		return finalAlign;
	}*/
	public static int countHit(String seq1, String seq2) {
		int hit = 0;
		for (int i = 0; i < seq1.length(); i++) {
			String char1 = seq1.substring(i, i + 1);
			String char2 = seq2.substring(i, i + 1);
			if (char1.equals(char2)) {
				hit++;
			}
		}
		return hit;
	}
	public static String reverseComplement(String seq) {
		String compl = "";
		for (int i = seq.length() - 1; i >= 0; i--) {
			compl += complement(seq.substring(i, i + 1));
		}
		return compl;
	}
	public static String complement(String input) {
		if (input.equals("T")) {
			return "A";
		}
		if (input.equals("G")) {
			return "C";
		}
		if (input.equals("C")) {
			return "G";
		}
		if (input.equals("A")) {
			return "T";
		}
		return "N";
	}
}
