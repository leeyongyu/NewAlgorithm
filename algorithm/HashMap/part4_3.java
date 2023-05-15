package algorithm;

import java.io.*;
import java.util.*;
public class part4_3 {

	public static void main(String[] args) throws IOException{
		// 매출액의 종류
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		String [] a = str.split(" ");
		List<Integer> answer = solution(a,N,K);
		for(Integer s : answer) {
			bw.write(s+" ");
		}
		bw.flush();
		bw.close();
	}
	private static List<Integer> solution(String [] a, int N, int K) {

		HashMap<String,Integer> map = new HashMap<>();
		List<Integer> list =new ArrayList<>();
		int lt=0, rt=0;
		int cnt=0;
		while(lt < N  && rt < N) {			
			// 오른쪽 포인터 rt와 왼쪽 포인터 lt 가 K의 차가 K보다 작다면 윈도우가 다 안찼으므로
			if((rt-lt) < K) {
				// map에 추가한다.(key가 존재할시 기존 값에 +1을 한다.
			   map.put(a[rt], map.getOrDefault(a[rt], 0)+1);
			   rt++; // 오른쪽 슬라이드 포인터 증가
			// K의 길이와 포인터의 차가 같다면 윈도우의 사이즈가 K인것이므로
			}else if((rt-lt) == K){
				list.add(map.size()); // 해당 윈도우의 맵 사이즈가 숫자의 종류이므로 리스트 추가
				map.put(a[lt], map.getOrDefault(a[lt], 0)-1); // 맨 왼쪽 슬라이드 값 -1
				if(map.get(a[lt]) == 0) { // 해당 값이 0이 된다면 중복되는 맵이 없으므로
					map.remove(a[lt]); // 해당 숫자 맵에서 제거
				}
				// 오른쪽 포인터가 마지막을 왔을때 증가된 포인터 처리
				if(rt==N-1) {
					// 해당 값을 맵에 추가하여 리스트에 더하고 종료한다.
					map.put(a[rt], map.getOrDefault(a[rt],0)+1);
					list.add(map.size());
					break;
				}
				lt++; // 왼쪽 슬라이드 포인터 증가 
			}

		}		
		return list;
	}
}
