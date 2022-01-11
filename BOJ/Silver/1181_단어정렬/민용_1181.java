package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1181_20220111 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		String temp = "";
		for(int i = 0; i<arr.length; i++) {
			arr[i] =br.readLine();
		}
		Arrays.sort(arr);
		Arrays.sort(arr, Comparator.comparing(String::length));
		for(int i = 0; i<arr.length; i++) {
			if(temp.equals(arr[i])) {
				continue;
			}
			else {
				System.out.println(arr[i]);
				temp = arr[i];
			}
		}
	}
}
