import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> parkingLog = new HashMap<>();
        Map<Integer,Integer> parkingTime = new HashMap<>();
        
        StringTokenizer st;
        for(int i=0;i<records.length;i++){
            st = new StringTokenizer(records[i]," ");
            String time = st.nextToken();
            int carNum = Integer.parseInt(st.nextToken());
            String status = st.nextToken();
            
            int minute = Integer.parseInt(time.substring(0,2))*60+Integer.parseInt(time.substring(3,5));
            
            if(status.equals("IN")){
                parkingLog.put(carNum,minute);
                set.add(carNum);
            }
            else{
                int inTime = parkingLog.get(carNum);
                parkingTime.put(carNum,minute - inTime +parkingTime.getOrDefault(carNum,0));
                parkingLog.remove(carNum);
            }
        }
        for(int num :parkingLog.keySet()){
            int inTime = parkingLog.get(num);
            parkingTime.put(num,1439-inTime+parkingTime.getOrDefault(num,0));
        }
        
        int[] answer = new int[set.size()];
        
        for(int num : set){
            pq.add(num);
        }
        int idx = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            int totalTime = parkingTime.get(cur);
            if(totalTime<=fees[0]){
                answer[idx]=fees[1];
            }
            else{
                answer[idx] = fees[1]+(totalTime-fees[0])/fees[2]*fees[3];
                if((totalTime-fees[0])%fees[2]!=0){
                    answer[idx]+=fees[3];
                }
            }
            idx++;
        }
        
        return answer;
    }
}