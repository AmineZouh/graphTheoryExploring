package graphTheory;

import java.util.*;

public class ShortestPath {

    public static int shortestPath(Map<Character, char[]> graph, char src, char dst){
        Queue<List<Object>> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>(Set.of(src));
        List<Object> mixedList = new ArrayList<>(Arrays.asList(src, 0));
        queue.add(mixedList);
        while(!queue.isEmpty()){
            List<Object> nodeAndCount = queue.poll();
            char current = (char) nodeAndCount.get(0);
            if(current==dst)
                return (int) nodeAndCount.get(1);
            for (char neighbor:graph.get(current)) {
                if(!visited.contains(neighbor)){
                    List<Object> neighborAndCount = new ArrayList<>(Arrays.asList(neighbor, ((int)nodeAndCount.get(1))+1));
                    queue.add(neighborAndCount);
                }
            }
        }
        return -1;
    }

    public static int shortestPath(char[][] graphArray, char src, char dst){
        Map<Character, List<Character>> graph = buildGraph(graphArray);
        Queue<List<Object>> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>(Set.of(src));
        List<Object> mixedList = new ArrayList<>(Arrays.asList(src, 0));
        queue.add(mixedList);
        while(!queue.isEmpty()){
            List<Object> nodeAndCount = queue.poll();
            char current = (char) nodeAndCount.get(0);
            if(current==dst)
                return (int) nodeAndCount.get(1);
            for (char neighbor:graph.get(current)) {
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    List<Object> neighborAndCount = new ArrayList<>(Arrays.asList(neighbor, ((int)nodeAndCount.get(1))+1));
                    queue.add(neighborAndCount);
                }
            }
        }
        return -1;
    }

    public static Map<Character, List<Character>> buildGraph(char[][] graphArray){
        Map<Character, List<Character>> graph = new HashMap<>();
        for (char[] paire:graphArray) {
            char a = paire[0];
            char b = paire[1];
            if(!graph.containsKey(a))
                graph.put(a, new ArrayList<>());
            if(!graph.containsKey(b))
                graph.put(b, new ArrayList<>());
            List<Character> paireA = graph.get(a);
            paireA.add(b);
            graph.put(a, paireA);
            List<Character> paireB = graph.get(b);
            paireB.add(a);
            graph.put(b, paireB);
        }
        return graph;
    }

    public static void main(String args[]){
        char[][] graphArray1 = {
                {'i', 'j'},
                {'i', 'k'},
                {'m', 'k'},
                {'l', 'k'},
                {'o', 'n'}
        };
        char[][] graphArray2 = {
                {'a', 'c'},
                {'a', 'b'},
                {'c', 'b'},
                {'c', 'd'},
                {'b', 'd'},
                {'e', 'd'},
                {'g', 'f'}
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
//        System.out.println("the solution is "+largestComponent(graph2));
        System.out.println("the shortest path is "+shortestPath(graphArray2, 'b', 'g'));
    }
}
