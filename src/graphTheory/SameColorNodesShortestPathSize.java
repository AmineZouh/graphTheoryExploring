package graphTheory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SameColorNodesShortestPathSize {

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        List<Integer> listValIndex = new ArrayList<>();
        for(int i=0; i<ids.length; i++){
            if(ids[i]==val)
                listValIndex.add(i+1);
        }
        int listValIndexSize = listValIndex.size();
        if(listValIndexSize<2){
            return -1;
        }
        System.out.println("listValIndex : "+listValIndex.toString());
        Set<Integer> visited = new HashSet<>();
        int shortestPathSize = graphFrom.length;
        Map<Integer, List<Integer>> graph = buildGraph(graphFrom, graphTo);
        for(int j=0; j<listValIndexSize-1; j++){
            for(int l=j+1; l<listValIndexSize; l++){
                int size = exploreSize(graph, listValIndex.get(j), listValIndex.get(l), visited);
//                System.out.println("the size of the path at iteration : j = "+j+", l = "+l+", is : "+size);
                if(size!=0 && shortestPathSize>size)
                    shortestPathSize = size;
            }
        }
        return shortestPathSize;
    }

    private static int exploreSize(Map<Integer, List<Integer>> graph, int src, int dst, Set<Integer> visited){
        Set<Integer> visited1 = new HashSet<>();
        if(src==dst || visited.contains(src) || !isAPathToDst(graph, src, dst, visited, visited1))
            return 0;
        visited.add(src);
        List<Integer> neighbors = graph.get(src);
        int size = 1;
        for(int neighbor:neighbors){
                size += exploreSize(graph, neighbor, dst, visited);
        }
        System.out.println("the size while going to dst : "+dst+", from src : "+src+", is size : "+size);
        return size;
    }

    private static boolean isAPathToDst(Map<Integer, List<Integer>> graph, int src, int dst, Set<Integer> visited1, Set<Integer> visited){
        if(src==dst)
            return true;
        if(visited1.contains(src) || visited.contains(src))
            return false;
        visited.add(src);
        List<Integer> neighbors = graph.get(src);
        for (int neighbor:neighbors){
            if(isAPathToDst(graph, neighbor, dst, visited1, visited))
                return true;
        }
        return false;
    }

    public static Map<Integer, List<Integer>> buildGraph(int[] graphFrom, int[] graphTo){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<graphFrom.length; i++){
            if(!graph.containsKey(graphFrom[i]))
                graph.put(graphFrom[i], new ArrayList<>());
            if(!graph.containsKey(graphTo[i]))
                graph.put(graphTo[i], new ArrayList<>());
            List<Integer> neighbors1 = graph.get(graphFrom[i]);
            neighbors1.add(graphTo[i]);
            graph.put(graphFrom[i], neighbors1);
            List<Integer> neighbors2 = graph.get(graphTo[i]);
            neighbors2.add(graphFrom[i]);
            graph.put(graphTo[i], neighbors2);
        }
        return graph;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graph_nodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graph_nodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graph_nodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graph_nodes, graphFrom, graphTo, ids, val);

        System.out.println("the shortest path size between two node of the same colors is : "+ans);

//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
