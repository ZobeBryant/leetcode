package 美图.第一;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        Arrays.sort(nums);
        List<List<Long>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        backtrack(n, visited, nums, res, new LinkedList<>());
        System.out.println(res.size());
        for (List<Long> list : res) {
            for (long num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void backtrack(int n, boolean[] visited, long[] nums, List<List<Long>> res, LinkedList<Long> path) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                path.addLast(nums[i]);
                visited[i] = true;
                backtrack(n, visited, nums, res, path);
                visited[i] = false;
                path.removeLast();
            }
        }
    }

}
