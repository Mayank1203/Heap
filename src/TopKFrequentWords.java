import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    String ch;
    int freq;
    public Pair(String ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }
}

public class TopKFrequentWords {
    public static void main(String[] args){
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4 ;
        System.out.println(topKFrequent(words,k));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> li=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->{
            if(a.freq!=b.freq){
                return Integer.compare(b.freq,a.freq);
            }
            return a.ch.compareTo(b.ch);
        });
        for(String str:map.keySet()){
            pq.add(new Pair(str,map.get(str)));
        }
        for(int i=0;i<k;i++){
            Pair curr=pq.poll();
            li.add(curr.ch);
        }
        return li;
    }
}
// Question Link => https://leetcode.com/problems/top-k-frequent-words/