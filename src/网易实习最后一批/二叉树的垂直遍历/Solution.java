package 网易实习最后一批.二叉树的垂直遍历;

import java.util.*;
public class Solution {
    public static class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

/*    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // 存放当前位置(key)的结果集(value)
        Map<Integer, List<Integer>> res = new TreeMap<>();

        // 存放当前节点（TreeNode）的位置
        Map<TreeNode, Integer> nodeMap = new HashMap<>();
        nodeMap.put(root, 0);

        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int i = nodeMap.get(node);
            // 如果当前位置还没有存储元素的结果集，则初始化 value，并添加元素
            res.computeIfAbsent(i, k -> new ArrayList<>()).add(node.val);
            // 左边向下逐层减 1
            if (node.left != null) {
                queue.add(node.left);
                nodeMap.put(node.left, i - 1);
            }
            // 右边向下逐层加 1
            if (node.right != null) {
                queue.add(node.right);
                nodeMap.put(node.right, i + 1);
            }
        }
        return new ArrayList<>(res.values());
    }*/
    public int[] verticalOrder(TreeNode root) {
        if(root == null)
            return new int[0];
        // 存储每个坐标对应的最大值
        Map<Integer,Integer> res = new TreeMap<>();
        // 存储每个节点的x坐标
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root,0);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            int i = map.get(node);
            int temp = res.getOrDefault(i, 0);
            if(temp == 0 ){
                res.put(i, node.val);
            }else{
                res.put(i, Math.max(temp,node.val));
            }
            if(node.left != null){
                q.offer(node.left);
                map.put(node.left, i - 1);
            }
            if(node.right != null){
                q.offer(node.right);
                map.put(node.right, i + 1);
            }
        }
        int size = res.size();
        int[] r = new int[size];
        List<Integer> list = new ArrayList<>(res.values());
        for(int i = 0; i < size; ++i){
            r[i] = list.get(i);
        }
        return r;


    }


    public static void main(String[] args) {
        Solution sl = new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        sl.verticalOrder(root);
    }
}
