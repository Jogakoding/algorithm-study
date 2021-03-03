BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			int date = Integer.parseInt(br.readLine());
			String answer= "";
			
			int front = date/100;
			int back = date%100;
			
			if(front > 12 || front <=0)
				answer = "YY";
			else
				answer = "ANY";
			
			if(answer.equals("ANY")) {
				if(back>12 || back <= 0)
					answer = "MMYY";
				else
					answer = "AMBIGUOUS";
			}else {
				if(back>12 || back <= 0)
					answer = "NA";
				else
					answer = "YYMM";
			}
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}