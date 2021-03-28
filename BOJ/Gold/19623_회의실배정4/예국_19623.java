package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_19623 {

	static class lecture implements Comparable<lecture>{
		int start;
		int end;
		int person;
		
		public lecture(int start, int end, int person) {
			super();
			this.start = start;
			this.end = end;
			this.person = person;
		}

		@Override
		public int compareTo(lecture o) {
			return this.end - o.end;
					
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		lecture[] lectureList = new lecture[N];
		int[] startEnd = new int[2*N];
		HashMap<Integer,Integer> startEndList = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lectureList[i] = new lecture(start,end, Integer.parseInt(st.nextToken()));
			startEnd[2*i] = start;
			startEnd[2*i+1] = end;
		}
		//좌표 압축
		Arrays.sort(startEnd);
		int idx = 0;
		for (int i : startEnd) {
			if(!startEndList.containsKey(i)) {
				startEndList.put(i, idx++);
			}
		}
		
		int[] dp = new int[idx];
		int lectureIdx = 0;
		Arrays.sort(lectureList);
		
		for (int i = 1; i < idx; i++) {
			int end = lectureList[lectureIdx].end;
			//System.out.println(i+" "+end +" "+startEndList.get(lectureList[lectureIdx].start)+"~"+startEndList.get(end));
			if(i== startEndList.get(end)) {
				int current = dp[startEndList.get(lectureList[lectureIdx].start)] + lectureList[lectureIdx].person;
				if(dp[i-1]<current)
					dp[i] = current;
				else
					dp[i] = dp[i-1];
				lectureIdx++;
			}else {
				dp[i] = dp[i-1];
			}
			
			//System.out.println(Arrays.toString(dp));
		}
		
		System.out.println(dp[idx-1]);
	}

}
