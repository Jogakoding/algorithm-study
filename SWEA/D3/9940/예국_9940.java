package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9940 {

	private static int N;
	private static boolean[] array;
	private static String answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			array = new boolean[N+1];
			answer = "Yes";
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int idx = Integer.parseInt(st.nextToken());
				if(array[idx]) {
					answer = "No";
					break;
				}
				array[idx] = true;
			}
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
