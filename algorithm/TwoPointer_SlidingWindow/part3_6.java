package algorithm;

import java.io.*;
import java.util.*;
public class part3_6 {

	public static void main(String[] args) throws IOException {
		// 최대 길이 연속부분수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [] a = new int[N];
		
		StringTokenizer st2 =new StringTokenizer(br.readLine());
		int i=0;
		while(st2.hasMoreTokens()) {
			a[i++]=Integer.parseInt(st2.nextToken());
		}
		int answer = solution(a,N,K);
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
	private static int solution(int [] a, int N, int K) {
		int result=0;
		int lt=0, rt=0;
		int zerocnt=0; // 0의 개수 카운트 
		while(lt < N && rt < N) {
			if(a[rt]==0) { // 오른쪽 포인터 값이 0이고 
				if(zerocnt==K) { // 기존 0의 개수가 K개라면 0을 K+1번째 만남 
					// 두 포인터 사이의 거리가 기존값보다 크다면
					if(result < Math.abs(rt-lt)) { 
						result = Math.abs(rt-lt);
					}
					// 오른쪽 포인터를 멈추고 다음 0을 만날때까지 왼쪽 포인터 증가
					if(a[lt]==1) {
						lt++;
					}else {
						zerocnt-=1; 
						// 왼쪽 포인터가 0이라면 0의 개수카운트 감소후 다음 포인터로 증가
						lt++;
					}
				}else if(zerocnt < K) { // 다음 0을 만났을때
					zerocnt++; // 0 개수와 오른쪽 포인터 증가
					rt++;
				}
			}else if(a[rt]==1) { // 1이라면 오른쪽포인터 증가
				rt++;
			}
		}
		return result;
	}
}
