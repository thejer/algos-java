package javaSolutions.src.old.Trees;

import java.util.*;

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
}