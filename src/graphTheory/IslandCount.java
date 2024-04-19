package graphTheory;

import java.util.*;

public class IslandCount {
    // 0 for island and 1 for water
    public static int islandCount(int[][] graphArray){
        Set<List<Integer>> visited = new HashSet<>();
        int count = 0;
        for(int r=0; r< graphArray.length; r++){
            for(int c=0; c<graphArray[0].length; c++){
                if(explore(graphArray, r, c, visited))
                    count++;
            }
        }
        return count;
    }

    private static boolean explore(int[][] graphArray, int r, int c, Set<List<Integer>> visited) {
        List<Integer> position = List.of(r, c);
        boolean rowInbound = 0<= r && r< graphArray.length;
        boolean columnInbound = 0<= c && c< graphArray[0].length;
        if(!rowInbound || !columnInbound) return false;
        if(graphArray[r][c]=='W') return false;
        if(visited.contains(position))
            return false;
        visited.add(position);
        explore(graphArray, r-1, c, visited);
        explore(graphArray, r+1, c, visited);
        explore(graphArray, r, c-1, visited);
        explore(graphArray, r, c+1, visited);
         return true;
    }

    public static void main(String args[]){
        int[][] grid = {
                {'W', 'L', 'W', 'W', 'L'},
                {'W', 'L', 'W', 'W', 'L'},
                {'W', 'W', 'W', 'L', 'W'},
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'}
        };
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
//        System.out.println("the solution is "+largestComponent(graph2));
        System.out.println("The number of lands is "+islandCount(grid));
    }
}
