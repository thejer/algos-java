package javaSolutions.Trees;

import java.util.*;
import org.junit.*;

import static org.junit.Assert.*;

public class TenWizards {

    public class Solution {
        public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
            int n = wizards.size();
            int[] parents = new int[wizards.size()];
            Map<Integer, Wizard> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                map.put(i, new Wizard(i));
            }

            map.get(source).dist = 0;
            Queue<Wizard> queue = new LinkedList<>();
            queue.offer(map.get(source));
            while (!queue.isEmpty()) {
                Wizard curr = queue.poll();
                List<Integer> neighbors = wizards.get(curr.id);
                for (int neighbor : neighbors) {
                    Wizard next = map.get(neighbor);
                    int weight = (int) Math.pow(next.id - curr.id, 2);
                    if (curr.dist + weight < next.dist) {
                        parents[next.id] = curr.id;
                        next.dist = curr.dist + weight;
                        // queue.offer(next);
                    }
                    queue.offer(next);
                }
            }

            List<Integer> res = new ArrayList<>();
            int t = target;
            while (t != source) {
                res.add(t);
                t = parents[t];
            }
            res.add(source);

            Collections.reverse(res);
            return res;
        }
    }

    class Wizard implements Comparable<Wizard> {
        int id;
        int dist;
        // Map<Integer, Integer> costs;

        Wizard(int id) {
            this.id = id;
            this.dist = Integer.MAX_VALUE;
            // this.costs = new HashMap<>();
        }

        @Override
        public int compareTo(Wizard that) {
            return this.dist - that.dist;
        }
    }

    /*
        Ten Wizards - Dijkstra
        AirBnB Interview Question
     */
    public class Solution_2 {
        public int[][] getShortestPath(int[][] wizards, int source, int target) {
            if (wizards == null || wizards.length == 0) return null;
            int n = wizards.length;
            int[] parent = new int[n];
            Map<Integer, Wizard> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                map.put(i, new Wizard(i));
            }

            map.get(source).dist = 0;
            Queue<Wizard> pq = new PriorityQueue<>(n);
            pq.offer(map.get(source));
            while (!pq.isEmpty()) {
                Wizard curr = pq.poll();
                int [] neighbors = wizards[curr.id];
                for (int neighbor : neighbors) {
                    Wizard next = map.get(neighbor);
                    int weight = (int) Math.pow(next.id - curr.id, 2);
                    if (curr.dist + weight < next.dist) {
                        parent[next.id] = curr.id;
                        pq.remove(next);
                        next.dist = curr.dist + weight;
                        pq.offer(next);
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            int t = target;
            while (t != source) {
                res.add(t);
                t = parent[t];
            }
            res.add(source);
            Collections.reverse(res);
            double total = 0;
            int[] itemsArray = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                itemsArray[i] = res.get(i);
                total = total + Math.pow((res.get(i+1) - res.get(i)), 2);
                if (i == res.size() - 2){
                    break;
                }
            }
            int[] totalArr = {(int)total};
            int[][] out = new int[2][];
            out[0]= totalArr;
            out[1]=itemsArray;
            return out;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new TenWizards().new Solution();
            int[][] ids = {{1, 5, 9}, {2, 3, 9}, {4}, {}, {}, {9}, {}, {}, {}, {}};
            List<List<Integer>> wizards = new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                List<Integer> wizard = new ArrayList<>();
                for (int j = 0; j < ids[i].length; j++) {
                    wizard.add(ids[i][j]);
                }
                wizards.add(wizard);
            }
            List<Integer> res = sol.getShortestPath(wizards, 0, 9);
            assertEquals(3, res.size());
            assertEquals(0, (int) res.get(0));
            assertEquals(5, (int) res.get(1));
            assertEquals(9, (int) res.get(2));
        }

        @Test
        public void test2() {
            Solution_2 sol = new TenWizards().new Solution_2();
            int[][] wizards = {{1,2,3}, {8,6,4}, {7,8,3}, {8,1}, {6}, {8,7}, {9,4}, {4,6}, {1}, {1,4}};
            int [][] res = sol.getShortestPath(wizards, 0, 9);
            assertEquals(23, res[0][0]);
        }
    }

    public static void main(String[] args) {
        Solution_2 sol = new TenWizards().new Solution_2();
        int[][] wizards = {{1,2,3}, {8,6,4}, {7,8,3}, {8,1}, {6}, {8,7}, {9,4}, {4,6}, {1}, {1,4}};
        int[][] res = sol.getShortestPath(wizards, 0, 9);
        System.out.println(res);
    }
}