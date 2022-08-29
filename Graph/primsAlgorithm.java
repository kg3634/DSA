/*1. You are given a graph and a source vertex. The vertices represent computers and the edges 
     represent length of LAN wire required to connect them.
2. You are required to find the minimum length of wire required to connect all PCs over a network. 
     Print the output in terms of which all PCs need to be connected, and the length of wire between 
     them.

Note -> For output, check the sample output and question video.

Constraints
None */
package DSA.Graph;

import java.io.*;
import java.util.*;

public class primsAlgorithm {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      /*Prims Algorithm(images/primAlgorithm.png): MST(minimum spanning tree),what is a) subgraph b) tree(connected Acyclic) 
      c) spanning (all vertices) why: here we have to connect all PCS; means all vertices should be used(spanning) and  with minimum 
      length means: minimum spanning tree: It is more similar to dijskatra but main difference is a) in place of psf we will use source 
      vertice b) we wont add weight will use as it is, so in some cases answer for both dijkstara and prim can be same or be diffrent*/
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(0,-1,0));//src=0,aquired via = -1(imagine),wt =0
      boolean [] visited = new boolean[vtces];

      while(pq.size() >0){
        Pair rem = pq.remove();
        if(visited[rem.v] == true){
            continue;
        }
        visited[rem.v] = true;
        if(rem.av != -1){
            System.out.println("["+rem.v+"-"+rem.av+"@"+rem.wt+"]");
        }
        for(Edge e: graph[rem.v]){
            if(visited[e.nbr] == false){
                pq.add(new Pair(e.nbr,rem.v,e.wt));
            }
        }
      }

   }

   public static class Pair implements Comparable<Pair>{
        int v;
        int av;
        int wt;
        Pair(int v,int av,int wt){
            this.v = v;
            this.av = av;
            this.wt = wt;
        }
        public int compareTo(Pair o){
            return this.wt - o.wt;
        }        
   }

}
/*Sample Input

7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8

Sample Output
[1-0@10]
[2-1@10]
[3-2@10]
[4-3@2]
[5-4@3]
[6-5@3] */