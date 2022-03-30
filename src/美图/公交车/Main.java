package 美图.公交车;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Set<Integer>> map = new HashMap<>(m);
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int bus = sc.nextInt();
                map.computeIfAbsent(bus, o -> new HashSet<>()).add(i);
            }
        }
        int INF = 0x3f3f3f;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        for (Set<Integer> stops : map.values()) {
            for (int i : stops) {
                for (int j : stops) {
                    if (i == j) {
                        continue;
                    }
                    graph[i][j] = 1;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int t = graph[i][k] + graph[k][j];
                    graph[i][j] = Math.min(graph[i][j], t);
                }
            }
        }
        for (int[] row : graph) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.print(row[j] + "\n");
                } else {
                    if(row[j] == INF){
                        System.out.print(-1 + " ");
                    }else{
                        System.out.print(row[j] + " ");
                    }
                }
            }
        }

    }
}