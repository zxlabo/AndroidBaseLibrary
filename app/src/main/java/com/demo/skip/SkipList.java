package com.demo.skip;

import com.demo.mainDemo.SkipList2;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class SkipList<K, V> {
    private static final int MAX_LEVEL = 8;
    private static final double P = 0.25;
    private int size;
    private Comparator<K> comparator;
    /**
     * 有效层数
     */
    private int level;
    /**
     * 不存放任何K-V
     */
    private Node<K, V> first;

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        first = new Node<>(null, null, MAX_LEVEL);
    }

    public SkipList() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        keyCheck(key);

        // first.nexts[3] == 21节点
        // first.nexts[2] == 9节点
        // first.nexts[1] == 6节点
        // first.nexts[0] == 3节点

        // key = 30
        // level = 4

        Node<K, V> node = first;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            // node.nexts[i].key >= key
            if (cmp == 0) return node.nexts[i].value;
        }
        return null;
    }

    public V put(K key, V value) {
        keyCheck(key);

        Node<K, V> node = first;
        Node<K, V>[] prevs = new Node[level];
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            if (cmp == 0) { // 节点是存在的
                V oldV = node.nexts[i].value;
                node.nexts[i].value = value;
                return oldV;
            }
            prevs[i] = node;
        }

        // 新节点的层数
        int newLevel = randomLevel();
        // 添加新节点
        Node<K, V> newNode = new Node<>(key, value, newLevel);
        // 设置前驱和后继
        for (int i = 0; i < newLevel; i++) {
            if (i >= level) {
                first.nexts[i] = newNode;
            } else {
                newNode.nexts[i] = prevs[i].nexts[i];
                prevs[i].nexts[i] = newNode;
            }
        }

        // 节点数量增加
        size++;

        // 计算跳表的最终层数
        level = Math.max(level, newLevel);

        return null;
    }

    public V remove(K key) {
        keyCheck(key);

        Node<K, V> node = first;
        Node<K, V>[] prevs = new Node[level];
        boolean exist = false;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            prevs[i] = node;
            if (cmp == 0) exist = true;
        }
        if (!exist) return null;

        // 需要被删除的节点
        Node<K, V> removedNode = node.nexts[0];

        // 数量减少
        size--;

        // 设置后继
        for (int i = 0; i < removedNode.nexts.length; i++) {
            prevs[i].nexts[i] = removedNode.nexts[i];
        }

        // 更新跳表的层数
        int newLevel = level;
        while (--newLevel >= 0 && first.nexts[newLevel] == null) {
            level = newLevel;
        }

        return removedNode.value;
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    private void keyCheck(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null.");
        }
    }

    private int compare(K k1, K k2) {
        return comparator != null
                ? comparator.compare(k1, k2)
                : ((Comparable<K>) k1).compareTo(k2);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V>[] nexts;

        //		Node<K, V> right;
//		Node<K, V> down;
//		Node<K, V> top;
//		Node<K, V> left;
        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            nexts = new Node[level];
        }

        @Override
//        public String toString() {
//            return key + ":" + value + "_" + nexts.length;
//        }
        public String toString() {
            return key+"";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("一共" + level + "层").append("\n");
        for (int i = level - 1; i >= 0; i--) {
            Node<K, V> node = first;
            while (node.nexts[i] != null) {
                sb.append(node.nexts[i]);
                sb.append(" ");
                node = node.nexts[i];
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * 打印所有数据
     */
    public void printAll_beautiful() {
        Node<Integer, Integer> p = (Node<Integer, Integer>) first;
        Node<Integer, Integer>[] nexts = p.nexts;//
        for (Node<Integer, Integer> node : nexts) {
            System.out.println(node);
        }
    }

    public static void main(String[] args) {
        SkipList<Integer, Integer> skipList = new SkipList<>();
        skipList.put(3, 3);
        skipList.put(6, 6);
        skipList.put(7, 7);
        skipList.put(9, 9);
        skipList.put(12, 12);
        skipList.put(17, 17);
        skipList.put(19, 19);
        skipList.put(21, 21);
        skipList.put(25, 25);
        skipList.put(26, 26);
        System.out.println(skipList);
//        skipList.printAll_beautiful();

    }
}
