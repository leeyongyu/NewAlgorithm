package algorithm;

import java.io.*;
import java.util.*;
public class part4_2 {

	public static void main(String[] args) throws IOException {
		// 아나그램(해쉬)
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine();
		String b = br.readLine();
		String answer =solution(a,b);
		
		bw.write(answer);
		bw.flush();
		bw.close();
	}
	private static String solution(String a , String b) {
		String result="YES"; // 기본 리턴 변수 Yes 
		HashMap<Character,Integer> map = new HashMap<>();
		HashMap<Character,Integer> map2 = new HashMap<>();
		for(int i=0; i<a.length(); i++) { // a 문자열  카운트
			map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0)+1);
		}
		for(int i=0; i<b.length(); i++) { // b 문자열 카운트
			map2.put(b.charAt(i), map2.getOrDefault(b.charAt(i), 0)+1);
		}
		for(Character key1 : map.keySet()) { //key값 for문 
			for(Character key2 : map2.keySet()) {
				// 단어 key가 같으나 숫자가 다르면 No 리턴
				if(key1 == key2 && map.get(key1) != map2.get(key2)) {
					result="NO";
				}
			}
		}	
		return result;
	}
}
