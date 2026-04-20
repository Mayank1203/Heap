import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRows {
    static class Pair{
        int soldiers;
        int idx;

        public Pair(int soldiers , int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }

        public static void main(String[] args){
            int[][] mat = {{1,1,0,0,0},
                    {1,1,1,1,0},
                    {1,0,0,0,0},
                    {1,1,0,0,0},
                    {1,1,1,1,1}};

           int k = 3 ;

           System.out.print(Arrays.toString(kWeakestRows(mat,k)));
        }
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b) -> {
                    if(a.soldiers == b.soldiers){
                        return a.idx - b.idx;
                    }
                    else{
                        return a.soldiers - b.soldiers;
                    }
                }
        );

        int idx  = 0;
        for(int[] i : mat){
            int count = 0;

            for(int j : i){
                if(j==1){
                    count++;
                }
            }

            pq.add(new Pair(count,idx));
            idx++;
        }

        int[] ans = new int[k];
        for(int i = 0 ; i < k ;i++){
            ans[i] = pq.poll().idx;
        }

        return ans;
    }
}

// Question Link => https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

// Note : I directly made static class so that we need not to make object to call class and function