/*1. You are given a graph.
2. You are required to find and print if the graph is cyclic.

Constraints
None */
package DSA.Graph;

import java.io.*;
import java.util.*;

public class isGraphCyclic {
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

      /*Logic:images/isGraphCyclic.png: we will traverse all vtces based on visited and in each BFS travel if we found visited true
       we will return true : means we are visiting 2 nd time means there are two path for the same vteces : means it is cyclic
       */
       boolean [] visited = new boolean[vtces];       
       for(int v=0;v<vtces;v++){
            if(visited[v] == false){
                boolean cyclic = isCyclic(graph, v, visited);
                if(cyclic){
                    System.out.println(true);
                    return;
                }
            }
       }
       System.out.println(false);
   }

   public static boolean isCyclic(ArrayList<Edge>[] graph,int src,boolean[] visited){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src,src+""));

        while(queue.size()>0){
            Pair rem = queue.removeFirst();
            if(visited[rem.v] == true){
                return true;
            }
            visited[rem.v] = true;

            for(Edge e: graph[rem.v]){
                if(visited[e.nbr] == false){
                    queue.add(new Pair(e.nbr,rem.psf+e.nbr));
                }
            }
        }

        return false;

   }

   public static class Pair{
        int v;
        String psf;
        Pair(int v,String psf){
            this.v = v;
            this.psf= psf;
        }
   }
}
/*Sample Input

7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10

Sample Output
false */