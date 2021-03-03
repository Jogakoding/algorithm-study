package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9839 {
	private static int[] array;
	private static int answer;
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			answer = -1;
			st = new StringTokenizer(br.readLine(), " ");
			array = new int[N];
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			findPair(0);
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	private static void findPair(int k) {
		if(k==2) {
			check();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(k==0 || array[0] < array[i]) {
				int temp = array[k];
				array[k] = array[i];
				array[i] = temp;
				
				findPair(k+1);
				
				temp = array[k];
				array[k] = array[i];
				array[i] = temp;
			}
		}
		
	}

	private static void check() {
		//System.out.println(array[0]+" "+array[1]);
		int t = array[0] * array[1];
		String test = String.valueOf(t);
		int start = test.charAt(0);
		
		for (int i = 1; i < test.length(); i++) {
			int next = test.charAt(i);
			//System.out.println(">> "+next+" "+test+" "+start);
			if(start+i != next)
				return;
		}
		
		answer = answer < t? t: answer;
		return;
		
	}

}
