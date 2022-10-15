package aq.koptev.compressorHuffman;

public class Main {

	public static void main(String[] args) {
		Compressor compressor = new Compressor();
		compressor.compress("susie says it is easy task");
		compressor.printOrigText();
		compressor.printEncode();
		compressor.printDecode();
	}
}
