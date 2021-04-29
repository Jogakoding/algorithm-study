package programmers;

import java.util.Arrays;

public class kakao2018_비밀지도 {
	public static void main(String[] args) {

		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		String[] str = solution(n, arr1, arr2);
		System.out.println(Arrays.toString(str));
	}

	static public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		
		for(int i=0;i<n;i++) {
			String str="";
			
			// 두 정수의 or 연산 = 둘다 공백(0)이어야만 공백으로 처리
			String k=Integer.toBinaryString(arr1[i]|arr2[i]);
			String temp="";
			// 만약 n이 5인데 or연산의 결과가 3인경우, 00011이 아닌 11이나온다.
			// 그러므로 앞의 자릿수에 0을 채워넣어야한다.
			for(int j=k.length();j<n;j++) {
				temp+=" ";
			}
			k=temp+k;
			for(int j=0;j<n;j++) {
				if(k.charAt(j)=='1') {
					str+="#";
				}else {
					str+=" ";	
				}
			}
			answer[i]=str;
		}
		
		
		
		
		return answer;
	}
}
