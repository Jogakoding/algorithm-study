import java.util.*;

class Solution {
    private static HashMap<String,Integer> map = new HashMap<String,Integer>();
    private static int[] courses = {1,0};
    
    private static void findCombi(char[] order, String answer, int idx){
        if(idx == order.length || answer.length() > courses[1]) return;
        
        findCombi(order, answer, idx+1);
        
        answer += order[idx];
        
        if(answer.length() > 1 && courses[0]%answer.length() == 0){
            int cc = 1;
            if(map.containsKey(answer)){
                cc = map.get(answer) + 1;
            }
            map.put(answer,cc);
        }
        
        findCombi(order, answer, idx+1);
        
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        for(int i = 0; i< course.length; i++){
            courses[0] *= course[i];
            courses[1] = courses[1] < course[i] ? course[i] : courses[1];
        }
        
        for(int i = 0; i< orders.length; i++){
            String tt = orders[i];
            char[] temp = tt.toCharArray();
            Arrays.sort(temp);
            findCombi(temp, "", 0);
        }
        
        int[] count = new int[course.length];
        ArrayList[] countList = new ArrayList[course.length];
        
        for(int i = 0; i<countList.length; i++){
            countList[i] = new ArrayList<String>();
        }
        
        for(String key : map.keySet()){
            int val = map.get(key);
            // System.out.println(key+" "+val);
            for(int i = 0;i<course.length;i++){
                if(course[i]==key.length()){
                    if(count[i] < val){
                        count[i] = val;
                        countList[i].clear();
                        countList[i].add(key);
                    }else if(count[i] == val){
                        countList[i].add(key);
                    }
                }
            }
        }
        
        int idx = 0, arrIdx = 0;
        for(int i = 0; i<countList.length; i++){
            if(count[i]>=2)
                idx += countList[i].size();
        }
        
        String[] answer = new String[idx];
        idx = 0;
        for(ArrayList<String> arr : countList){
            if(count[arrIdx++]<2) continue;
            for(String str : arr){
                answer[idx++] = str;
            }
        }
        
        // System.out.println(Arrays.toString(answer));
        Arrays.sort(answer);
        
        return answer;
    }
}
