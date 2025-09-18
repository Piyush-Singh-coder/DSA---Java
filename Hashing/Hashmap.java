package Hashing;

import java.util.*;

public class Hashmap {
    static class HMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            return null;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : buckets) {
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            N *= 2;
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            n = 0; // reset count
            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value); // reinserting
                }
            }
        }
    }

    public static void main(String[] args) {
        HMap<String, Integer> hm = new HMap<>();
        hm.put("India", 223);
        hm.put("US", 300);
        hm.put("UK", 180);
        hm.put("Australia", 120);
        hm.put("China", 999);

        System.out.println("Keys:");
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key + " -> " + hm.get(key));
        }

        System.out.println("Contains US? " + hm.containsKey("US"));
        System.out.println("Removing UK: " + hm.remove("UK"));
        System.out.println("After Removal:");
        for (String key : hm.keySet()) {
            System.out.println(key + " -> " + hm.get(key));
        }
    }
}
