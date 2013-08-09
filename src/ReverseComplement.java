
public class ReverseComplement {

	public static void main(String[] args) {
		
		String complement = "GCGAAGTCCGTCAATTCCTTTGAGTTTTAATCTTGCGACCGTACTCCCCAGGCGGTCAACTTCACGCGTTAGCTGCGCTACTGAAGCCTAACGGCCCCAACAGCTAGTTGACATCGTTTAGGGCGTGGACTACCAGGGTATCTAATCCTGTTTGCTCCCCACGCTTTCGTGTCTGAGCGTCAGTATTATCCCAGGGGGCTGCCTTCGCCATCGGTATTCCTCCACATCTCTACGCATTTCACTGCTACAC";
		System.out.println(reverseComplement(complement));
				
	
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
