package graphTheory;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class BFSShortestReachGraph {

    public static List<Integer> getShortest(int n, int[][] edges, int s){
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        System.out.println("the graph is : "+graph.toString());
        List<Integer> result = new ArrayList<>();
        if(graph.get(s)==null){
            for(int i=0; i<n-1; i++)
                result.add(-1);
            return result;
        }
        for(int i=1; i<=n; i++){
            if(i==s)
                continue;
            else{
                Set<Integer> visited = new HashSet<>();
                result.add(calcDst(graph, s, i, visited));
            }
        }
        return result;
    }

    public static int calcDst(Map<Integer, List<Integer>> graph, int s, int d, Set<Integer> visited){
        int r = 0;
        if(visited.contains(d))
            return r;
        visited.add(d);
        if(s==d)
            return r;
        List<Integer> neighbors = graph.get(d);
        if(neighbors==null)
            return -1;
        for(int n:neighbors){
            Set<Integer> visited1 = new HashSet<>();
            if(isAPathToDst(graph, s, n, visited1)){
                r+=6+calcDst(graph, s, n, visited);
                break;
            }
        }
        return r;
    }


    public static boolean isAPathToDst(Map<Integer, List<Integer>> graph, int s, int d, Set<Integer> v){
        if(v.contains(d))
            return false;
        v.add(d);
        if(s==d)
            return true;
        List<Integer> neighbors = graph.get(d);
        for(int n:neighbors){
            if(isAPathToDst(graph, s, n, v))
                return true;
        }
        return false;
    }


    public static Map<Integer, List<Integer>> buildGraph(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] paire:edges){
            int node1 = paire[0];
            int node2 = paire[1];
            if(!graph.containsKey(node1))
                graph.put(node1, new ArrayList<>());
            if(!graph.containsKey(node2))
                graph.put(node2, new ArrayList<>());
            List<Integer> node1Neighbors = graph.get(node1);
            node1Neighbors.add(node2);
            graph.put(node1, node1Neighbors);
            List<Integer> node2Neighbors = graph.get(node2);
            node2Neighbors.add(node1);
            graph.put(node2, node2Neighbors);
        }
        return graph;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader reader = null;
        String line;
        String path1 = "C:\\Users\\pc\\OneDrive\\Bureau\\hackerRankTestCasesFiles\\BFSShortestReachGraphTestCase1.txt";
        String path2 = "C:\\Users\\pc\\OneDrive\\Bureau\\hackerRankTestCasesFiles\\BFSShortestReachGraphTestCase2.txt";
        try {
            reader = new BufferedReader(new FileReader(path1));
            int q = Integer.parseInt(reader.readLine());
            for (int i=0; i<q; i++){
                String[] parameters = reader.readLine().split(" ");
                int n = Integer.parseInt(parameters[0]);
                int m = Integer.parseInt(parameters[1]);
                int[][] edges = new int[m][2];
                for(int j=0; j<m; j++){
                    String[] parameters1 = reader.readLine().split(" ");
                    edges[j][0] = Integer.parseInt(parameters1[0]);
                    edges[j][1] = Integer.parseInt(parameters1[1]);
                }
                int s = Integer.parseInt(reader.readLine());
                List<Integer> result = getShortest(n, edges, s);
                String result2 = result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "));
                System.out.println(result2);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }catch (Exception e){
            System.out.println("there was an error while trying reading the file");
        }
/*
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<q; i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();
            int[][] edges = new int[m][2];
            for(int j=0; j<m; j++){
                edges[j][0] = scanner.nextInt();
                edges[j][1] = scanner.nextInt();
            }
            scanner.nextLine();
            int s = scanner.nextInt();
            List<Integer> result = getShortest(n, edges, s);
            String result2 = result.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
            System.out.println(result2);
        }
*/

    }

}
