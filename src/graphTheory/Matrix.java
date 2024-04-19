package graphTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
//Non Résolu.
public class Matrix {

    public static int minTime(List<List<Integer>> roads, List<Integer> machines) {
        // Write your code here
        List<Integer> times = new ArrayList<>();
        List<Integer> specialCaseTimes = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        boolean[] ind = {true};
        for(int machine:machines){
            List<List<Integer>> machineRoads = roads.stream()
                    .filter(list -> (list.get(0)==machine || list.get(1)==machine)&& !visited.contains(list.get(0)+" "+list.get(1)+" "+list.get(2))).collect(Collectors.toList());
            //
            for(List<Integer> machineRoad:machineRoads){
                System.out.println("machineRoad:"+machineRoad.toString()+", machine:"+machine);
                if(machineRoad.get(0)==machine && machines.contains(machineRoad.get(1))){
                    System.out.println("two machines :"+machineRoad);
                    specialCaseTimes.add(machineRoad.get(2));
                    visited.add(machineRoad.get(0)+" "+machineRoad.get(1)+" "+machineRoad.get(2));
                }
                else if(machineRoad.get(1)==machine && machines.contains(machineRoad.get(0))){
                    System.out.println("two machines :"+machineRoad);
                    specialCaseTimes.add(machineRoad.get(2));
                    visited.add(machineRoad.get(0)+" "+machineRoad.get(1)+" "+machineRoad.get(2));
                }else{
                    times.add(machineRoad.get(2));
                }
            }
        }
        int r1 = specialCaseTimes.stream().mapToInt(Integer::intValue).sum();
        final int[] r2 = {0};
        times.stream()
                .forEach(number -> {
                    if(number==Collections.max(times) && ind[0]){
                        ind[0]=false;
                    }
                    else
                        r2[0]+=number;
                });
        return r1+r2[0];
    }

    public static void main(String[] args) throws IOException {
        String path1 = "C:\\Users\\pc\\OneDrive\\Bureau\\hackerRankTestCasesFiles\\MatrixTestCase1.txt";
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path1));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> roads = new ArrayList<>();

        IntStream.range(0, n - 1).forEach(i -> {
            try {
                roads.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> machines = IntStream.range(0, k).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = minTime(roads, machines);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
        System.out.println("the result is minTime : "+result);
        bufferedReader.close();
//        bufferedWriter.close();

    }

}
