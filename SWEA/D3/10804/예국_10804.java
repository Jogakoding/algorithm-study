package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_10804 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String input = br.readLine();
			sb.append("#").append(testCase).append(" ");
			for (int i = input.length()-1; i >=0; i--) {
				switch (input.charAt(i)) {
				case 'b':
					sb.append("d");
					break;
				case 'd':
					sb.append("b");				
					break;
				case 'p':
					sb.append("q");										
					break;
				default:
					sb.append("p");										
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
