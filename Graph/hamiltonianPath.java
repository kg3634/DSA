/*1. You are given a graph and a src vertex.
2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with 
a "."

Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there 
is an edge between first and last vertex.
Note -> Print in lexicographically increasing order.

Constraints
None */
package DSA.Graph;

import java.io.*;
import java.util.*;

public class hamiltonianPath {
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
      /*Logic:Its similer to print all path: base case is imp: in base case as we have to print only paths which contains all
       vertices so visited.size == graph.length -1 ,why -1 ,visited is one step before psf,so for n visited contains n-1 values but
       psf contains n elem values, so when visited will be on n-1 that means all paths have been added.s
       */
      HashSet<Integer> visited = new HashSet<>();/*as we have to all elem is visited or not, so boolean wont work */
      hamiltonian(graph,src,visited,src+"",src);

   }

   public static void hamiltonian(ArrayList<Edge>[] graph, int src,HashSet<Integer> visited,String psf,int osrc){
    /*IMP BASE CASE */
    if(visited.size() == graph.length -1 ){
        System.out.print(psf);//there will be all vertices as psf is ne step ahead to visited

        boolean closingEdgeFound = false;
        /*if last elem nbr container original source that will be cycle */
        for(Edge e: graph[src]){
            if(e.nbr == osrc){
                closingEdgeFound = true;
            }
        }

        /*if closing Edge found then put "*" else "." */
        if(closingEdgeFound){
            System.out.println("*");
        }else{
            System.out.println(".");
        }

        return;
    }
    visited.add(src);
    for(Edge e: graph[src]){
        if(visited.contains(e.nbr)== false){
            hamiltonian(graph, e.nbr, visited, psf+e.nbr, osrc);//original src is passed to cal cycle
        }
    }
    visited.remove(src);

   }


}
/*Sample Input

7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0

Sample Output
0123456.
0123465.
0125643*
0346521* */