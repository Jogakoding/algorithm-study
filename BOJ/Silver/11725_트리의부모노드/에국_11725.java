package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_11725 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> graph[] = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[start].add(end);
			graph[end].add(start);
		}
		
		int[] printList = new int[N+1];
		Queue<Integer> test = new LinkedList<>();
		test.add(1);
		visited[1] = true;
		while(!test.isEmpty()) {
			int pick = test.poll();
			
			for (Integer temp : graph[pick]) {
				if(!visited[temp]) {
					visited[temp] = true;
					printList[temp] = pick;
					test.add(temp);
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			System.out.println(printList[i]);
		}
	}

}
