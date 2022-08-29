/*1. You are given a graph, representing people and their connectivity.
2. You are also given a src person (who got infected) and time t.
3. You are required to find how many people will get infected in time t, if the infection spreads to neighbors of infected person in 1 
unit of time.

Constraints
None */
package DSA.Graph;

import java.io.*;
import java.util.*;

public class spreadOfInfection {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      /*Logic:images/spreadOfInfection.png: apply BFS(r-m*-a*),agar > t time hone per break kr dnge */
      ArrayDeque<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src,1));//source infected h at t =1, hume pata karna h kitne infected hojyeng in t time
      int[] visited = new int[vtces];//default value 0
      int count =0;
      while(q.size()>0){
        Pair rem = q.removeFirst();

        if(visited[rem.v] > 0){
            continue;
        }

        visited[rem.v] = rem.time;
        if(rem.time > t){//break condition
            break;
        }
        count++;

        for(Edge e : graph[rem.v]){
            if(visited[e.nbr] == 0){
                q.add(new Pair(e.nbr,rem.time+1));//neighbour will be infected in next 1 unit time
            }
        }

        System.out.println(count);

      }
   }
   public static class Pair{
        int v;
        int time;
        Pair(int v,int time){
            this.v = v;
            this.time = time;
        }
   }

}
/*Sample Input

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
6
3

Sample Output
4 */