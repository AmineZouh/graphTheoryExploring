package graphTheory;

import java.util.*;

public class LargestComponent {

    public static int largestComponent(Map<Integer, List<Integer>> graph){
        Set<Integer> visited = new HashSet<>();
        int largest = 0;
        for (int n:graph.keySet()) {
            int size = exploreSize(graph, n, visited);
            if(size>largest)
                largest=size;
        }
        return largest;
    }

    public static int exploreSize(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){
        if(visited.contains(node))
            return 0;
        visited.add(node);
        int size = 1;
        for (int neighbor:graph.get(node)) {
            size+=exploreSize(graph, neighbor, visited);
        }
        return size;
    }

    public static void main(String args[]){
        char[][] graphArray = {
                {'i', 'j'},
                {'i', 'k'},
                {'m', 'k'},
                {'l', 'k'},
                {'o', 'n'}
        };
        Map<Character, char[]> graph = new HashMap<>();
        graph.put('i', new char[]{'j', 'k'});
        graph.put('j', new char[]{'i'});
        graph.put('k', new char[]{'i', 'm', 'l'});
        graph.put('m', new char[]{'k'});
        graph.put('l', new char[]{'k'});
        graph.put('o', new char[]{'n'});
        graph.put('n', new char[]{'o'});
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, new ArrayList<>(Arrays.asList(8, 1, 5)));
        graph2.put(1, new ArrayList<>(Arrays.asList(0)));
        graph2.put(5, new ArrayList<>(Arrays.asList(8, 0)));
        graph2.put(8, new ArrayList<>(Arrays.asList(0, 5)));
        graph2.put(2, new ArrayList<>(Arrays.asList(3, 4)));
        graph2.put(3, new ArrayList<>(Arrays.asList(2, 4)));
        graph2.put(4, new ArrayList<>(Arrays.asList(3, 2)));


//        depthFirstPrintIteration(graph, 'a');
//        depthFirstPrintRecursion(graph, 'a');
//        breadthFirstPrint(graph, 'a');
//        System.out.println("the solution is "+hasPath(graph, 'f', 'j'));
//        System.out.println("the solution is "+hasPathBreadthFirst(graph, 'f', 'h'));
//        System.out.println("the solution is "+undirectedPath(graphArray, 'i', 'l'));
        System.out.println("the solution is "+largestComponent(graph2));
    }
}
