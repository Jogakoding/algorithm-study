package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_10965 {
	private static int MAX = 3163;
	private static boolean[] prime = new boolean[MAX+1];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 3; i <=MAX; i+=2) {
			int temp = i;
			if(!prime[i]) { //소수라면
				while(i*temp <=MAX) { // 그 이후 배수들은 합성수 처리
					prime[i*temp] = true;
					temp+=2;
				}
			}
		}
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int num = Integer.parseInt(br.readLine());
			sb.append("#").append(testCase).append(" ").append(go(num)).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int go(int num) {
		for (int i = 2; i <= MAX;) {
			if(!prime[i] & num%(i*i)== 0) { //소수이면
                num/=(i*i);
			}else if(i==2){
				i++;
			}else {
				i+=2;
			}
		}
		return num;
	}

}



/**
 * import java.io.*;
import java.util.*;
  
public class Solution{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tt=Integer.parseInt(br.readLine().trim());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        boolean[] notprime = new boolean[3163];
        for(int i=2; i<3163; i++){
            if(!notprime[i]){
                arr.add(i*i);
                for(int j=2*i; j<3163; j+=i){
                    notprime[j] = true;
                }
            }
        }
        for(int t=0; t<tt; t++){
            int n = Integer.parseInt(br.readLine().trim());
            for(int i=0; i<arr.size(); i++){
                if(arr.get(i)>n){
                    break;
                }
                while(n%arr.get(i)==0){
                    n/=arr.get(i);
                }   
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(Integer.toString(t+1)).append(" ").append(Integer.toString(n)).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
 */ 
