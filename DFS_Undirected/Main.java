import java.io.*;
import java.util.*;
class Main
{
     
    static int N = 1000;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    static void dfsUtil(int u, int node, boolean visited[],
                        ArrayList<ArrayList<Integer>> road_used,
                        int parent, int it)
    {
        int c = 0;
        for (int i = 0; i < node; i++)
            if (visited[i])
                c++;
        if (c == node)
            return;
        visited[u] = true;
        road_used.add(new ArrayList<Integer>(Arrays.asList( parent, u )));
        System.out.print((char)(u+65) + " -> ");
        for (int x : adj.get(u))
        {
            if (!visited[x])
            {   
                dfsUtil(x, node, visited, road_used, u, it + 1);              
            }
        }
        System.out.print("Backtracking\n");
        for(int y = 0; y < road_used.size(); y++)
        {
            if(road_used.get(y).get(1) == u)
            {
                dfsUtil(road_used.get(y).get(0), node,
                        visited,road_used, u, it + 1);
            }
        }
         
    }
    static void dfs(int node)
    {
        boolean[] visited = new boolean[node];
        ArrayList<ArrayList<Integer>> road_used = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < node; i++)
        {
            visited[i] = false;
        }
        dfsUtil(0, node, visited, road_used, -1, 0);
    }
    static void insertEdge(int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner readMyFile = new Scanner(new File("graphin.txt"));
        int node = readMyFile.nextInt(); 
        int edge = readMyFile.nextInt();
        for(int i = 0; i < N; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        while(readMyFile.hasNext()){
            insertEdge((int)readMyFile.next().charAt(0) - 65, (int)readMyFile.next().charAt(0) - 65);
        }
        System.out.println("Nodes reachable from A(Steps with backtracing): ");
        dfs(node);
    }
}
