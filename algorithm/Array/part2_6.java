package algorithm;

import java.util.*;
public class part2_6 {

	public static void main(String[] args) {
		// 뒤집은 소수
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int [] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i]=input.nextInt();
		}
		List<Integer> result = solution(nums);
		for(Integer num : result) {
			System.out.print(num +" ");
		}

	}
	private static List<Integer> solution(int [] array) {
		String tmp="";
		String [] strArr = new String[array.length];
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<array.length; i++) {
			tmp = Integer.toString(array[i]);
			strArr[i] = new StringBuffer(tmp).reverse().toString();
			array[i] = Integer.parseInt(strArr[i]);
		}

		for(int i=0; i<array.length; i++) {
			if(isPrime(array[i])== true) {
				list.add(array[i]);
			}
		}
		return list;
	}
	private static boolean isPrime(int n) {
		if(n==1) return false;
		for(int i=2; i<n; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
