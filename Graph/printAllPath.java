/*1. You are given a graph, a source vertex and a destination vertex. 2. You are required to find and print all paths between source 
and destination. Print them in lexicographical order. E.g. Check the following paths 012546 01256 032546 03256 The lexicographically 
smaller path is printed first.


Constraints
None */
package DSA.Graph;

import java.io.*;
import java.util.*;

public class printAllPath {
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

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());
      /*images/printAllPaths1.png: (basic travel), images/printAllPaths.png(shortcut: jo left side per se chala gya wo visit ho gya
      and right side se bhi chala gya to for unvisit ho gya, mainly hume same line mn hi dekhna h uper tak, left ka dehne ki jaruru ni
      same line se hi path print ka dnge)
      NOTE: 3 parts tree travel: 1st mn 0-1-2 ko explore, 2nd mn 0-3-2 ko explore, 3rd mn 0-3-4 ko*/
      boolean [] visited = new boolean[vtces];
      printAllPath(graph,src,dest,visited,src+"");
   }

   public static void printAllPath(ArrayList<Edge> [] graph,int src,int dest,boolean[] visited,String psf){
    if(src == dest){
        System.out.println(psf);
        return;
    }

    visited[src] = true;
    for( Edge edge:graph[src]){
        if(visited[edge.nbr] == false){
            printAllPath(graph, edge.nbr, dest, visited, psf+edge.nbr);
        }
    }
    visited[src] = false;
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
0123456
012346
03456
0346 */