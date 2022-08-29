/*1. You are given a graph, a src vertex and a destination vertex.
2. You are required to find if a path exists between src and dest. If it does, print true 
     otherwise print false.

Constraints
None */
package DSA.Graph;

import java.io.*;
import java.util.*;

public class hasPath {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt){
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      /*Logic: images/hasPath.png: floodfill in recursion concept: */
      boolean [] visited = new boolean[vtces];//created to avoid back and forth call of vertices size
      boolean path = hasPath(graph,src,dest,visited);
      System.out.println(path);

    }

    public static boolean hasPath(ArrayList<Edge> [] graph, int src,int dest,boolean[] visited){/*graph is arraylist of edges(each 
      element in graph is also arraylist which contains mutiple edges) also called adjacency list: in edges there are 3 values: src,neighbour,weight*/
      if(src == dest){
         return true;
      }

      visited[src] = true;//marking true to avoid back and forth call as child(edge.nbr) is also neighbour of parent 
      for(Edge edge: graph[src]){/*graph[i] is arraylist of edges , so this loops elems are edges*/
         if(visited[edge.nbr] == false){
            boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
            if(hasNbrPath){
               return true;
            } 
         }
      }

      return false;
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
0
6

Sample Output
true */