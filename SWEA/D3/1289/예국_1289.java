package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1289 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String input = br.readLine();
			String temp = "0";
			int cnt = 0;
			for (int i = 0; i < input.length(); i++) {
				if(!String.valueOf(input.charAt(i)).equals(temp)) {
					cnt++;
					temp = temp.equals("0")? "1":"0";
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
