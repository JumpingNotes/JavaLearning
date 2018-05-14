package arithmetic.multitree;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树
 * @author: Jumpingnotes
 * @date: 2017/7/20 17:38
 */
public class MultiTree<N extends TreeNode>{
    private N node;
    private List<MultiTree> children;
    private long times=0L;

    public List<N> getSortTreeList(List<N> nodeList){
        return traverseTree(createTree(nodeList));
    }

    /**
     * 创建多叉树
     * @param nList
     * @return
     */
    public List<MultiTree> createTree(List<N> nList){
        List<MultiTree> operateTree=new ArrayList<>();
        List<MultiTree> rootTree=new ArrayList<>();
        for (N n:nList){
            times++;
            operateTree.add(new MultiTree(n));
        }
        for (MultiTree tree1:operateTree){
           if (tree1.node.isRootNode()){
               rootTree.add(tree1);
           }
           for (MultiTree tree2:operateTree){
               times++;
               if (tree2.node.getPId()!=null&&tree2.node.getPId().equals(tree1.node.getId())){
                   tree1.children.add(tree2);
               }
           }
        }
        return rootTree;
    }

    /**
     * 遍历多叉树
     * @param trees
     * @return
     */
    public List<N> traverseTree(List<MultiTree> trees){
        List<N> resultTree=new ArrayList<>();
        for (MultiTree tree:trees){
            times++;
            resultTree.add((N) tree.node);
            if (tree.children!=null&&tree.children.size()>0){
                resultTree.addAll(traverseTree(tree.children));
            }
        }
        return resultTree;
    }

    public long getTimes() {
        return times;
    }

    public MultiTree() {
    }

    public MultiTree(N node) {
        this.node = node;
        children=new ArrayList<>();
    }
}
