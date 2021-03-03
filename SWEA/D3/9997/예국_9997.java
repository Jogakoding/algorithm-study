package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9997 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			int degree = Integer.parseInt(br.readLine());
			
			int h = degree / (360/12);
			degree %= 360/12;
			int m = degree * 2;
			
			sb.append("#").append(testCase).append(" ").append(h).append(" ").append(m).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
