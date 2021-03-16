package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Solution_3752 {
	private static HashSet<Integer> answer;
    private static int[] score;
    private static int maxSum;
    private static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringJoiner sj = new StringJoiner("\n");
         
        int TC = Integer.parseInt(br.readLine());
         
        for (int testCase = 1; testCase <= TC; testCase++) {
            N = Integer.parseInt(br.readLine());
            score = new int[N];
            maxSum = 0;
            answer = new HashSet<>();
            answer.add(0);
            st = new StringTokenizer(br.readLine(), " ");
             
            for (int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(st.nextToken());
                maxSum += score[i];
            }
             
            for (int i = 0; i < score.length; i++) {
            	HashSet<Integer> temp = new HashSet<>();
            	for (Integer num : answer) {
            		if(!answer.contains(num+score[i])){
            			temp.add(num+score[i]);
            		}
				}
            	answer.addAll(temp);
            	
			}
            
            String line = "#"+testCase+" "+answer.size();
            sj.add(line);
        }
        System.out.println(sj.toString());
    }
     
    
 
}
