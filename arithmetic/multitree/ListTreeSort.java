package arithmetic.multitree;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归方式对list树遍历
 * T 节点类型
 * K 节点id和pId的类型
 * @author: Jumpingnotes
 * @date: 2017/7/21 9:18
 */
public class ListTreeSort<T extends TreeNode,K> {
    List<T> nodes;
    List<T> resultList;
    long times=0L;

    public List<T> getSortTreeList(List<T> nodeList){
        nodes=nodeList;
        resultList=new ArrayList<>();
        for (T node:nodes){
            times++;
            if (node.isRootNode()){
                resultList.add(node);
                if (hasChild((K) node.getId())){
                    traverseChildren((K) node.getId());
                }
            }
        }
        return resultList;
    }

    public void traverseChildren(K id){
        for (T node:nodes){
            times++;
            if (node.getPId()!=null&&node.getPId().equals(id)){
                resultList.add(node);
                if (hasChild((K) node.getId())){
                    traverseChildren((K) node.getId());
                }
            }
        }
    }

    public boolean hasChild(K id){
        for (T node:nodes){
            times++;
            if (node.getPId()!=null&&node.getPId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public long getTimes() {
        return times;
    }
}
