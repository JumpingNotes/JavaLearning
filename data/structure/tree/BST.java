package data.structure.tree;

import data.structure.queue.Queue;

/**
 * TODO 基于二叉查找树的符号表
 * @author 鱼唇的人类
 * @date 2017/5/21
 * @time 14:21
 */
public class BST<K extends Comparable<K>,V> {
    private Node root;
    private class Node{
        private K key;//键
        private V val;//值
        private Node left,right;//指向子节点
        private int N;//以该节点为根的子树中的结点总数
        public Node(K k,V v,int n){
            this.key=k;this.val=v;this.N=n;
        }
    }

    //TODO 查找
    public V get(K key){return get(root,key);}
    private V get(Node node, K key) {
        if (node==null) return null;
        int cmp=key.compareTo(node.key);
        if (cmp<0)return get(node.left,key);
        else if (cmp>0) return get(node.right,key);
        else return node.val;
    }

    //TODO 查询大小
    public int size(){
        return size(root);
    }
    private int size(Node node){
        return node==null?0:node.N;
    }

    //TODO 插入
    private void put(K key,V val){root=put(root,key,val);}
    private Node put(Node node, K key, V val) {
        if (node==null) return new Node(key,val,1);
        int cmp=key.compareTo(node.key);
        if (cmp<0)node.left=put(node.left,key,val);
        else if (cmp>0) node.right=put(node.right,key,val);
        else node.val=val;
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }
    //TODO 查找最小值
    public K min(){return min(root).key;}
    private Node min(Node node) {return node.left==null?node:min(node.left);}

    //TODO 查找最大值
    public K max(){return max(root).key;}
    private Node max(Node node) {return node.right==null?node:max(node.right);}

    //TODO 根据键返回排名
    public int rank(K key){return rank(root,key);}
    private int rank(Node node, K key) {
        if (node==null)return 0;
        int cmp=key.compareTo(node.key);
        if (cmp<0)return rank(node.left,key);
        else if (cmp>0)return 1+size(node.left)+rank(node.right,key);
        else return size(node.left);
    }

    //TODO 根据排名查找节点
    public K select(int o){return select(root,o).key;}
    private Node select(Node node, int o) {
        if (node==null)return null;
        int t=size(node.left);
        if (t>o)return select(node.left,o);
        else if (t<o)return select(node.right,o-t-1);
        else return node;
    }

    //TODO 删除最小结点
    public void deleteMin(){root=deleteMin(root);}
    private Node deleteMin(Node node) {
        if (node.left==null)return node.right;
        node.left=deleteMin(node.left);
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }

    //TODO 删除
    public void delete(K key){root=delete(root,key);}
    private Node delete(Node node,K key) {
        if (node==null)return null;
        int cmp=key.compareTo(node.key);
        if (cmp<0)node.left=delete(node.left,key);
        else if (cmp>0)node.right=delete(node.right,key);
        else {
            if (node.right==null)return node.left;
            if (node.left==null)return node.right;
            Node n=node;
            node=min(n.right);
            node.right=deleteMin(n.right);
            node.left=n.left;
        }
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }

    //TODO 打印输出
    public void print(){print(root);}
    private void print(Node node) {
        if (node==null)return;
        print(node.left);
        System.out.println(node.key+":"+node.val);
        print(node.right);
    }

    //TODO 范围查找
    public Iterable<K> keys(){return keys(min(),max());}
    public Iterable<K> keys(K min, K max) {
        Queue<K> queue=new Queue<>();
        keys(root,queue,min,max);
        return queue;
    }
    private void keys(Node node, Queue<K> queue, K min, K max) {
        if (node==null)return;
        int cmpMin=min.compareTo(node.key);
        int cmpMax=max.compareTo(node.key);
        if (cmpMin<0)keys(node.left,queue,min,max);
        if (cmpMin<=0&&cmpMax>=0)queue.enQueue(node.key);
        if (cmpMax>0)keys(node.right,queue,min,max);
    }
}
