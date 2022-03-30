package HOT100.除法求值;

import java.util.*;

public class Solution {
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<List<String>, Double> map = new HashMap<>();
        for(int i = 0; i < equations.size(); ++i){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            List<String> tmp = new ArrayList<>();
            tmp.add(b);
            tmp.add(a);
            map.put(equations.get(i), values[i]);
            map.put(tmp, 1.0 / values[i]);
            if(map.get(new ArrayList<>(Arrays.asList(a, a))) == null){
                map.put(new ArrayList<>(Arrays.asList(a, a)), 1.0);
            }
            if(map.get(new ArrayList<>(Arrays.asList(b, b))) == null){
                map.put(new ArrayList<>(Arrays.asList(b, b)), 1.0);
            }
        }
        for(int i = 0; i < equations.size(); ++i){
            String a1 = equations.get(i).get(0);
            String b1 = equations.get(i).get(1);
            for(int j = i+1; j < equations.size();++j){
                String a2 = equations.get(j).get(0);
                String b2 = equations.get(j).get(1);
                if(a1.equals(b2)){
                    map.put(new ArrayList<String>(Arrays.asList(a2, b1)),values[i] * values[j]);
                    map.put(new ArrayList<String>(Arrays.asList(b1, a2)),1.0 / (values[i] * values[j]));
                }else if(b1.equals(a2)){
                    map.put(new ArrayList<String>(Arrays.asList(a1, b2)),values[i] * values[j]);
                    map.put(new ArrayList<String>(Arrays.asList(b2, a1)) ,1.0 / (values[i] * values[j]));
                }else if(b1.equals(b2)){
                    map.put(new ArrayList<String>(Arrays.asList(a1, a2)),1.0 * values[i] / values[j]);
                    map.put(new ArrayList<String>(Arrays.asList(a2, a1)),1.0 * values[j] / values[i]);
                }else if(a1.equals(a2)){
                    map.put(new ArrayList<String>(Arrays.asList(b2, b1)),1.0 * values[i] / values[j]);
                    map.put(new ArrayList<String>(Arrays.asList(b1, b2)),1.0 * values[j] / values[i]);
                }
            }
        }
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); ++i){
            if(map.get(queries.get(i)) != null){
                res[i] = map.get(queries.get(i));
            }else{
                res[i] = -1.0;
            }
        }
        return res;
    }

    // 并查集 路径压缩
    // 并查集特点：一边查询一边修改节点指向
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsize);
        Map<String, Integer> map = new HashMap<>(2 * equationsize);
        int id = 0;
        for(int i = 0; i < equationsize; ++i){
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if(!map.containsKey(a)){
                map.put(a, id);
                ++id;
            }
            if(!map.containsKey(b)){
                map.put(b, id);
                ++id;
            }
            unionFind.union(map.get(a), map.get(b), values[i]);
        }
        int querySize = queries.size();
        double[] res = new double[querySize];
        for(int i = 0; i < querySize; ++i){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            Integer id1 = map.get(a);
            Integer id2 = map.get(b);
            if(id1 == null || id2 == null)
                res[i] = -1.0d;
            else
                res[i] = unionFind.isConnected(id1, id2);
        }
        return res;
    }

    public class UnionFind{
        private int[] parent;
        // 指向父节点的权值
        private double[] weight;
        public UnionFind(int n){
            this.parent = new int[n];
            this.weight = new double[n];
            for(int i = 0; i < n; ++i){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }
        public void union(int x, int y, double value){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)
                return;
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }
        public int find(int x){
            if(x != parent[x]){
                int orign = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[orign];
            }
            return parent[x];
        }
        public double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return weight[x] / weight[y];
            }else{
                return -1.0d;
            }
        }
    }
}
