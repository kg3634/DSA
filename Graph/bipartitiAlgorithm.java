/*1. You are given a graph.
2. You are required to find and print if the graph is bipartite

Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually 
               exclusive and exhaustive vertices such that all edges are across sets.

Constraints
None */
package DSA.Graph;
import java.io.*;
import java.util.*;

public class bipartitiAlgorithm {
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

      /*Bipartite condition: If it is possible to divide vertices into 2 mutually exclusive(koi vtces common na ho) and exhaustive
      (sare vtces khatam ho jaye) sets such that all edges are accross sets
      Logic: a)Acyclic: if no cycle is present than it is bipertitite:images/bipartite1.png : all edges are sccross set
      b)odd cyclic: if vtces can be visit twice with different level: wont be bipartitite as all edges wont be accross:images/bipartitite2.png
      c)even cyclic: if vtces can be visit twice with same level: it is bipartite as all edges are accross: images/bipartite3.png
      */

      int[] visited = new int[vtces];//as we have to add levels so not using boolean
      Arrays.fill(visited,-1);//fill -1 value by default
      for(int v=0;v<vtces;v++){
        if(visited[v] == -1){
            boolean isBipartite = checkBipartite(graph,v,visited);
            if(isBipartite == false){//here it is false not true
                System.out.println(false);
                return;                    
            }
        }
      }
      System.out.println(true);

   }

   public static boolean checkBipartite(ArrayList<Edge>[] graph, int src, int [] visited){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,src+"",0));

        while(q.size() >0){
            Pair rem = q.removeFirst();

            /*agar dursi baar visite kiya h then if mn jyega */
            if(visited[rem.v] == -1){
                /*agar current level last time ke visited level ke != then false  */
                if(rem.level != visited[rem.v]){
                    return false;
                }
            }else{
                visited[rem.v] = rem.level;
            }

            for(Edge e: graph[rem.v]){
                if(visited[e.nbr] == -1){
                    q.add(new Pair(e.nbr,rem.psf+e.nbr,rem.level+1));
                }
            }
           
        }
        return true;
   }

   public static class Pair{
        int v;
        String psf;
        int level;
        Pair(int v, String psf,int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
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

Sample Output
false */