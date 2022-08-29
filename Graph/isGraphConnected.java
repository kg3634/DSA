//Extention of getConnectedCompOfGraph 
package DSA.Graph;

import java.io.*;
import java.util.*;

public class isGraphConnected {
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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      /*images/getConnectedCompOfGraph.png */
      boolean [] visited = new boolean[vtces];
      for(int v=0; v<vtces; v++){//cheking tree for each verteces
        if(visited[v] == false){//only non visited will be made as src for tree
            ArrayList<Integer> comp = new ArrayList<>();//innner list for each connected graph
            drawTreeAndGererateComp(graph,v,visited,comp);//source each verteces for tree
            comps.add(comp);//outer list
        }
      }
      //difference of code: graph connected tabi hoga jab uska 1 hi componenet ho
      System.out.println(comps.size() == 1);//give false /true


   }
   public static void drawTreeAndGererateComp(ArrayList<Edge>[] graph,int src, boolean [] visited,ArrayList<Integer> comp){
        visited[src] = true;
        comp.add(src);
        for(Edge e: graph[src]){
            if(visited[e.nbr] == false){
                drawTreeAndGererateComp(graph, e.nbr, visited, comp);
            }
        }
   }
}

/*Sample Input

7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

Sample Output
false */