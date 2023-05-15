package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon18352 {
	static List<ArrayList<Integer>> graphList;
	static int[] dis; // 번호마다 최단거리 변수
	static int K; // 최단거리
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt(); // 도시의 개수(노드)
		int M = in.nextInt(); // 도로의 개수(간선)
		K = in.nextInt(); // 거리 정보
		int X = in.nextInt(); // 출발 도시 번호(출발노드)

		in.nextLine();
		String[] str = new String[M];
		for (int i = 0; i < str.length; i++) {
			str[i] = in.nextLine();
		}
		graphList = new ArrayList<ArrayList<Integer>>();
		dis = new int[N + 1];
		visited = new boolean[N + 1];
		List<Integer> resultList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graphList.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < str.length; i++) {
			String[] token = str[i].split(" ");
			int a = Integer.parseInt(token[0]); // 출발지 노드
			int b = Integer.parseInt(token[1]); // 목적지 노드

			graphList.get(a).add(b);
		}

		bfs(X);

		for (int i = 0; i < dis.length; i++) {
			if (dis[i] == K) {
				resultList.add(i);
			}
		}
		if (resultList.size() == 0) {
			System.out.print("-1");
		} else if (resultList.size() > 0) {
			Collections.sort(resultList);
			for (Integer n : resultList) {
				System.out.println(n);
			}
		}
	}

	private static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		visited[x] = true;
		dis[x] = 0;
		queue.offer(x);
		while (queue.isEmpty() != true) {
			int cv = queue.poll();
			for (int nv : graphList.get(cv)) {
				if (visited[nv] == false) {
					visited[nv] = true;
					queue.offer(nv);
					dis[nv] = dis[cv] + 1;
				}
			}
		}
	}

}
