package 华为秋招.链路;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.substring(1);
        str = str.substring(0, str.length() -1);
        String[] strs = str.split("],\\[");
        int len = strs.length;
        strs[0] = strs[0].substring(1);
        strs[len - 1] = strs[len - 1].substring(0, strs[len - 1].length() -1);
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(String s : strs){
            String[] edge = s.split(",");
            int from = Integer.parseInt(edge[0]);
            int to = Integer.parseInt(edge[1]);
            int weight = Integer.parseInt(edge[2]);
            List<int[]> neighbors = map.getOrDefault(from, new ArrayList<>());
            neighbors.add(new int[]{to, weight});
            map.put(from, neighbors);
        }
        Set<Integer> visited = new HashSet<>();
        for(int from : map.keySet()){
            dfs(0, from, map, visited);
        }
        System.out.println(res);
    }
    static int res = 0;
    private static void dfs(int sum, int from, Map<Integer, List<int[]>> map, Set<Integer> visited){
        List<int[]> neighbors = map.getOrDefault(from, new ArrayList<>());
        visited.add(from);
        res = Math.max(res, sum);
        for(int [] nb : neighbors){
            int to = nb[0], weight = nb[1];
            if(visited.contains(to)){
                continue;
            }
            dfs(sum + weight, to, map, visited);
        }
        visited.remove(from);
    }
}
