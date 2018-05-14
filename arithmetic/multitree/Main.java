package arithmetic.multitree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Jumpingnotes
 * @date: 2017/7/20 17:54
 */
public class Main {
    public static void main(String []args){
        List<TestNode> testNodes=new ArrayList<>();
        testNodes.add(new TestNode(1,"1",0));
        testNodes.add(new TestNode(2,"2",0));
        testNodes.add(new TestNode(3,"3",0));
        testNodes.add(new TestNode(4,"1-4",1));
        testNodes.add(new TestNode(5,"2-5",2));
        testNodes.add(new TestNode(6,"3-6",3));
        testNodes.add(new TestNode(7,"1-4-7",4));
        testNodes.add(new TestNode(8,"1-4-8",4));
        testNodes.add(new TestNode(9,"2-5-9",5));
        testNodes.add(new TestNode(10,"2-5-9-10",9));
        testNodes.add(new TestNode(11,"2-5-9-10-11",10));
        testNodes.add(new TestNode(12,"2-5-9-10-11-12",11));
        testNodes.add(new TestNode(13,"2-5-9-10-11-12-13",12));
        testNodes.add(new TestNode(14,"2-5-9-10-11-12-13-14",13));
        testNodes.add(new TestNode(15,"2-5-9-10-11-12-13-14-15",14));
        //1.建立多叉树进行遍历
        long start1=System.currentTimeMillis();
        MultiTree<TestNode> tree=new MultiTree<>();
        List<TestNode> result=tree.getSortTreeList(testNodes);
        long end1=System.currentTimeMillis();
        for (TestNode node:result){
            System.out.println(node);
        }
        System.out.println(tree.getTimes());
        System.out.println("Time:"+(end1-start1));
        //2.使用递归进行遍历
        long start2=System.currentTimeMillis();
        ListTreeSort<TestNode,Integer> treeSort=new ListTreeSort<>();
        List<TestNode> list=treeSort.getSortTreeList(testNodes);
        long end2=System.currentTimeMillis();
        for (TestNode node:list){
            System.out.println(node.toString());
        }
        System.out.println(treeSort.getTimes());
        System.out.println("Time:"+(end2-start2));
    }
}
