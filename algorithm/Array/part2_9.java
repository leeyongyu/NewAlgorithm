package algorithm;

import java.util.*;
public class part2_9 {

	public static void main(String[] args) {
		// 격자판 최대합
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int [][] array = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				array[i][j]=input.nextInt();
			}
		}
		int answer = solution(array);
		
		System.out.print(answer);
	}
	private static int solution(int [][] array) {
		List<Integer> sumList = new ArrayList<>();
		int wsum=0;
		int hsum=0;
		int dagak=0;
		int maxlen=array.length-1;
		int reverseDagak=0;
		int result=0;
		for(int i=0; i<array.length; i++) {
			wsum=0;
			hsum=0;
			reverseDagak+=array[i][maxlen-i];
			for(int j=0; j<array.length; j++) {
				wsum+=array[i][j];
				hsum+=array[j][i];
				if(i==j) {
					dagak+=array[i][j];
				}
			}
			sumList.add(wsum);
			sumList.add(hsum);
		}
		sumList.add(dagak);
		sumList.add(reverseDagak);
		
		Collections.sort(sumList,Comparator.reverseOrder());
		result = sumList.get(0);
		
		return result;
	}
}
