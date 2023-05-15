package algorithm;

import java.util.*;

public class part1_12 {

	public static void main(String[] args) {
		// 암호
		Scanner input = new Scanner(System.in);
		
		int cnt = input.nextInt();
		String str = input.next();
		System.out.print(solution(str,cnt));

	}
	private static String solution(String str, int n) {
		String result="";
		int len = str.length() / n;
		String [] strArr = new String[n];
		int [] numArr = new int[n];
		str = str.replaceAll("\\*","0");
		str = str.replaceAll("\\#","1");
		int idx=0;
		for(int i=0; i<str.length(); i++) {
			if(i==0) {
				strArr[idx++]=str.substring(i,i+len);
			}
			else if(i%len==0) {
				strArr[idx++]=str.substring(i,i+len);
			}
		}
		for(int i=0; i<strArr.length; i++) {
			int k=0;
			for(int j=strArr[i].length()-1; j>=0; j--) {
				if(strArr[i].charAt(k++)=='1') {
					numArr[i] += Math.pow(2,j);
				}
			}
			result +=(char)numArr[i];
		}
		
		return result;
	}
}
