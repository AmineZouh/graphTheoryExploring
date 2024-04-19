package graphTheory;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinimumLibraryCost {

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        if(c_lib<=c_road){
            long result = Math.abs(n)* Math.abs(c_lib);
            return result;
        }
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet();
        int numberOfComponent = 0;
        List<Integer> componentSizeList = new ArrayList<>();
        int r;
        int m = cities.size();
        Map<Integer, List<Integer>> graph = buildGraph(cities);
        for(int i=1; i<=n; i++){
            if(!graph.keySet().contains(i))
                graph.put(i, new ArrayList<>());
        }
        for(int node:graph.keySet()){
            if(explore(graph, node, visited1))
                numberOfComponent+=1;
            int componentSize = exploreSize(graph, node, visited2);
            if(componentSize!=0)
                componentSizeList.add(componentSize);
        }
        System.out.println(componentSizeList.toString());
        int total_road_cost = 0;
        for(int componentSizeElement: componentSizeList){
            total_road_cost += componentSizeElement-1;
        }
        r = total_road_cost*c_road+numberOfComponent*c_lib;
        return r;
    }

    public static boolean explore(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){
        if(visited.contains(node))
            return false;
        visited.add(node);
        for(int neighbor:graph.get(node))
            explore(graph, neighbor, visited);
        return true;
    }

    static int exploreSize(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){
        if(visited.contains(node))
            return 0;
        int size = 1;
        visited.add(node);
        for(int neighbor:graph.get(node))
            size += exploreSize(graph, neighbor, visited);
        return size;
    }

    public static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> cities){
        Map<Integer, List<Integer>> graph = new HashMap();
        List<Integer> isolated = new ArrayList<>();
        for(List<Integer> city:cities){
            int c1 = city.get(0);
            int c2 = city.get(1);
            if(!graph.containsKey(c1))
                graph.put(c1, new ArrayList<>());
            if(!graph.containsKey(c2))
                graph.put(c2, new ArrayList<>());
            List<Integer> c1neighbors = graph.get(c1);
            c1neighbors.add(c2);
            graph.put(c1, c1neighbors);
            List<Integer> c2neighbors = graph.get(c2);
            c2neighbors.add(c1);
            graph.put(c2, c2neighbors);
        }
        return graph;
    }

    public static void main(String[] args) throws IOException {
        String path1 = "D:\\Projets\\java\\MinimumLibraryCostTestCases1.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path1));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

//                System.out.print("for a number od cities : "+n+", for a lib cost : "+c_lib+" and road cost : "+c_road);


                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = MinimumLibraryCost.roadsAndLibraries(n, c_lib, c_road, cities);
//                System.out.print(", the minimum cost is "+result);
//                System.out.println();
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
//        System.out.println("the value of the multiplication of 96295*81523="+(96295L*81523L));
        bufferedReader.close();
//        bufferedWriter.close();
    }
}
