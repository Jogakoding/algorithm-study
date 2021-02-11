package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1959 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t = 1; t <= N; t++) {
			String[] str = br.readLine().split(" ");
			int n1 = Integer.parseInt(str[0]);
			int n2 = Integer.parseInt(str[1]);
			int[] arr1 = new int[n1];
			int[] arr2 = new int[n2];

			String[] s1 = br.readLine().split(" ");
			String[] s2 = br.readLine().split(" ");
			for (int i = 0; i < n1; i++) {
				arr1[i] = Integer.parseInt(s1[i]);
			}
			for (int i = 0; i < n2; i++) {
				arr2[i] = Integer.parseInt(s2[i]);
			}

			int max=-1;
			
			if (n1 < n2) {
				for (int i = 0; i <= n2 - n1; i++) {
					int sum=0;
					for (int j = 0; j < n1; j++) {
						sum+=arr1[j]*arr2[j+i];
					}
					if(sum>max)max=sum;

				}
			} else {
				for (int i = 0; i <= n1 - n2; i++) {
					int sum=0;
					for (int j = 0; j < n2; j++) {
						sum+=arr1[j+i]*arr2[j];
					}
					if(sum>max)max=sum;

				}
				
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
			//System.out.println("#"+t+" "+max);
		}
		System.out.println(sb);

	}
}
