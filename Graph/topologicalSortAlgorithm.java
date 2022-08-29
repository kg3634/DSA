/*1. You are given a directed acyclic graph. The vertices represent tasks and edges represent 
    dependencies between tasks.
2. You are required to find and print the order in which tasks could be done. The task that should be 
    done at last should be printed first and the task which should be done first should be printed last. 
    This is called topological sort. Check out the question video for details.

Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if 
                                    for all directed edges uv, u appears before v in the graph

Note -> For output, check the sample output and question video.

Constraints
None */
package DSA.Graph;

import java.io.*;
import java.util.*;

public class topologicalSortAlgorithm {
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
      }

      /*Topological sort definition: A permutation of vertices of directed acyclic graph is called topological sort if for all 
       directed edges uv, u appears before v in the graph
       Logic:images/topologicalSortAlgo.png: use ge all connected component like code, we will use stack in post order to print 
       in topological sort order.
       IMP POINTS: a) we cant print it in post order as it will print in reverse of topological sort which is order of doing work.
       b) we can not even print it in pre order as well becaus for preorder it wil print it 0123 456(4 is dependent on 3,so shoudl be 
       printed before 3),as print is top to bootom so if there is any dependency of second connected graph vertices to first, it can 
       not detect it and will print dependent vertices afterwards as well but in case of stack, as it is storing it in bootom to top
       so all dependency would be resolved in all cases.
       in print is like it will print first ,but after this if any dependent v comes it can not print it before already printed elem.
       in stack (fist in -last out): first in - independent vtces, last in - dependent, first out -dependent, last out - independent  
       */
       Stack<Integer> st = new Stack<>();
       boolean [] visited = new boolean[vtces];
       for(int v =0;v<vtces;v++){
        if(visited[v] == false){
            topologicalSort(graph, v, visited, st);
        }
       }

       while(st.size() >0){
        System.out.println(st.pop());
       }

   }

   public static void topologicalSort(ArrayList<Edge> [] graph,int src,boolean[] visited, Stack<Integer> st){
        visited[src] = true;
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                topologicalSort(graph, e.nbr, visited, st);
            }
        }
        st.push(src);//post order mn push
   }

}
/*Sample Input

7
7
0 1
1 2
2 3
0 3
4 5
5 6
4 6

Sample Output
4
5
6
0
1
2
3 */