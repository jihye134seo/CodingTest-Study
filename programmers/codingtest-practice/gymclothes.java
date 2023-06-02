//2023.06.02
//프로그래머스 코딩테스트 연습 - 코딩테스트 고득점 Kit
//탐욕법(Greedy) - 체육복

import java.util.ArrayList;
import java.util.Collections;


class Solution {
    
    public ArrayList<Integer> getIntersection(ArrayList<Integer> lost, ArrayList<Integer> reserve){
        
        ArrayList<Integer> intersection = new ArrayList<>();
        
        for(int i=0; i<lost.size(); i++){
            if(reserve.contains(lost.get(i))){
                intersection.add(lost.get(i));
            }
        }
        
        return intersection;
    }
    
    public void removeIntersection(ArrayList<Integer> list, ArrayList<Integer> intersection){
        
        for(int i=0; i<intersection.size(); i++){
            list.remove(list.indexOf(intersection.get(i)));
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        ArrayList<Integer> remainStu = new ArrayList<>();
        ArrayList<Integer> lostStu = new ArrayList<>();
        
        for(int i=0; i<lost.length; i++){
            lostStu.add(lost[i]);
        }
        
        for(int i=0; i<reserve.length; i++){
            remainStu.add(reserve[i]);   
        }
        
        ArrayList<Integer> intersectionStu = getIntersection(lostStu, remainStu);
        removeIntersection(lostStu, intersectionStu);
        removeIntersection(remainStu, intersectionStu);
        
        answer = n - lostStu.size();
        
        Collections.sort(lostStu);
        Collections.sort(remainStu);
        
        for(int i=0; i<lostStu.size(); i++){
            if(remainStu.indexOf(lostStu.get(i)-1) != -1){
                remainStu.remove(remainStu.indexOf(lostStu.get(i)-1));
                answer++;
            }
            else if(remainStu.indexOf(lostStu.get(i)+1) != -1){
                remainStu.remove(remainStu.indexOf(lostStu.get(i)+1));
                answer++;
            }
        }
        
        return answer;    
        
    }
}
