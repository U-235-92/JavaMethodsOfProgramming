package aq.koptev.compressorHuffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compressor {
	
	private Map<String, Integer> frequensySymbolMap;
	private List<Node> nodeList;
	private Map<String, String> codeMap = new HashMap<>();
	private Tree huffmanTree;
	private String encodeText = "";
	private String decodeTet = "";
	private String origText = "";
	
	public final void compress(String text) {
		origText = text;
		frequensySymbolMap = frequensySymbolMap(text);
		nodeList = getNodeList(frequensySymbolMap);
		huffmanTree = getHuffmanTree(nodeList);
		fillCodeMap();
		encodeText = getEncodeText(text);
		decodeTet = getDecodeString(encodeText);
	}
	
	private Map<String, Integer> frequensySymbolMap(String text) {
		Map<String, Integer> frequensySymbolMap = new HashMap<>();
		char[] chars = text.toCharArray();
		for(char ch : chars) {
			if(frequensySymbolMap.containsKey(String.valueOf(ch))) {
				int count = frequensySymbolMap.get(String.valueOf(ch));
				frequensySymbolMap.put(String.valueOf(ch), ++count);
			} else {
				frequensySymbolMap.put(String.valueOf(ch), 1);
			}
		}
		return frequensySymbolMap;
	}
	
	private List<Node> getNodeList(Map<String, Integer> frequensySymbolMap) {
		List<Node> nodeList = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : frequensySymbolMap.entrySet()) {
			Node node = new Node(entry.getValue(), entry.getKey());
			nodeList.add(node);
		}
		Collections.sort(nodeList);
		return nodeList;
	}
	
	private Tree getHuffmanTree(List<Node> nodeList) {
		Tree huffmanTree = new Tree();
		while(nodeList.size() != 1) {
			Node first = nodeList.remove(0);
			Node second = nodeList.remove(0);
			Tree merge = new Tree(new Node(first.getFrequensy() + second.getFrequensy(), "##"));
			merge.add(first, second);
			nodeList.add(merge.getRoot());
			Collections.sort(nodeList);
		}
		huffmanTree.add(nodeList.remove(0));
		return huffmanTree;
	}
	
	private void fillCodeMap() {
		fillCodeMap0(huffmanTree.getRoot(), "");
	}
	
	private void fillCodeMap0(Node node, String path) {
		if(node != null) {
			if(isLeaf(node)) {
				codeMap.put(node.getValue(), path);
			}
			fillCodeMap0(node.getLeftChild(), path + 0);
			fillCodeMap0(node.getRightChild(), path + 1);
		}
	}
	
	private String getEncodeText(String text) {
		char[] chars = text.toCharArray();
		String encodeText = "";
		for(char ch : chars) {
			for(Map.Entry<String, String> entry : codeMap.entrySet()) {
				if(String.valueOf(ch).equals(entry.getKey())) {
					encodeText += entry.getValue();
					break;
				}
			}
		}
		return encodeText;
	}
	
	private String getDecodeString(String text) {
		String decodeText = "";
		char[] path = text.toCharArray();
		decodeText = decode(path);
		return decodeText;
	}
	
	private String decode(char[] path) {
		return decode0(huffmanTree.getRoot(), 0, path);
	}
	
	
	private String decode0(Node node, int index, char[] path) {
		String result = "";
		if(node != null) {
			if(isLeaf(node)) {
				result += node.getValue();
				if(index > path.length - 1) {
					return result;
				} else {
					node = huffmanTree.getRoot();
				}
			}
			if(path[index] == '0') {
				result += decode0(node.getLeftChild(), ++index, path);
			} else {
				result += decode0(node.getRightChild(), ++index, path);
			}
		}
		return result;
	}
	
	private boolean isLeaf(Node node) {
		return node.getLeftChild() == null && node.getRightChild() == null;
	}
	
	public void printEncode() {
		println(encodeText);
	}
	
	public void printDecode() {
		println(decodeTet);
	}
	
	public void printOrigText() {
		println(origText);
	}
	
	private void println(String text) {
		System.out.println(text);
	}
}
