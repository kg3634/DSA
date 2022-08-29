/*1. You are given a number n (representing the number of students). Each student will have an id 
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are 
     from different clubs.

Constraints
None */
package DSA.Graph;

import java.io.*;
import java.util.*;

public class perfectFriends {
   
   public static class Edge{
    int v;
    int n;
    Edge(int v,int n){
        this.v = v;
        this.n = n;
    }
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      /*Logic:images/perfectFriends.png:create and get components of clubs first and then calculate ways by permutations 
      for c1,c2,c3 ==> c1.size()*c2.size()+c2c3+c3c1*/
      
      //create Graph
      ArrayList<Edge> [] graph = new ArrayList[n];/*array of arrayList of edges: by default all values will be null*/
      //intializing empty arraylist on each vertices in graph
      for(int v=0;v<n;v++){
        graph[v] = new ArrayList<>();
      }
      
      //initialize edges
      for(int e=0;e<k;e++){
        String line = br.readLine();
        String [] parts = line.split(" ");
        int v1 = Integer.parseInt(parts[0]);
        int v2 = Integer.parseInt(parts[1]);
        //each edge will be added 2 time: like for 01: v1-v2(neighbour) and v2-v1(neighbour)
        graph[v1].add(new Edge(v1,v2));
        graph[v2].add(new Edge(v2,v1));
      }

      boolean [] visited = new boolean[n];
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();//outer AL
      for(int v=0;v<n;v++){
        ArrayList<Integer> comp = new ArrayList<>();//inner AL
        if(visited[v] == false){
            drawTreeAndGenerateComp(graph,v,comp,visited);
            comps.add(comp);
        }
      }

      //cal no of ways
      int pairs =0;
      for(int i =0;i<comps.size();i++){
        for(int j=i+1;j<comps.size();j++){//starting from i+1 to avoid permutations(12 and 21 ) but we need combinations(12 only) 
            pairs+=comps.get(i).size()*comps.get(j).size();
        }
      }
      System.out.println(pairs);
   }

   public static void drawTreeAndGenerateComp(ArrayList<Edge>[] graph,int v,ArrayList<Integer> comp,boolean[] visited){
        visited[v] = true;
        comp.add(v);
        for(Edge e:graph[v]){
            if(visited[e.n] == false){
                drawTreeAndGenerateComp(graph, e.n, comp, visited);
            }
        }
   }

}
/*Sample Input

7
5
0 1
2 3
4 5
5 6
4 6

Sample Output
16 */