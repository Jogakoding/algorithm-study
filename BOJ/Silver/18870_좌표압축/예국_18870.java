package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_18870 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] clone = numbers.clone();
		Arrays.sort(numbers);
		
		HashMap<String,Integer> order = new HashMap<>();
		int orderIdx = 0;
		String key;
		for (int i : numbers) {
			key = String.valueOf(i);
			if(!order.containsKey(key)) {
				order.put(key, orderIdx++);
			}
		}
		
		for (int i : clone) {
			sb.append(order.get(String.valueOf(i))).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	
	/*
	 * public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>(list);
        List<Integer> newList = new ArrayList<>();
        newList.addAll(set);
        Collections.sort(newList);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < newList.size(); i++) {
            map.put(newList.get(i), i);
        }
        for (Integer num : list) {
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb);
    }*/

}
