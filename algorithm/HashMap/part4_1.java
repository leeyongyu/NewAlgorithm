package algorithm;

import java.io.*;
import java.util.*;
public class part4_1 {

	public static void main(String[] args) throws IOException {
		// 학급 회장(해쉬)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		char [] ch = new char[N];
		String str = br.readLine();
		ch = str.toCharArray();
		char answer = solution(ch);
		
		bw.write(answer);
		bw.flush();
		bw.close();
	}
	private static char solution(char [] charr) {
		char result =' ';
		int max=0;
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0; i< charr.length; i++) {
			// or if문 (map.containsKey(charr[i]))
			map.put(charr[i], map.getOrDefault(charr[i],0)+1);
		}
		for(Character key : map.keySet()) {
			if(max < map.get(key)) {
				max = map.get(key);
				result = key;
			}
		}
		return result;
	}
}
