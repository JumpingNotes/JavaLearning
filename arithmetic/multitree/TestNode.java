package arithmetic.multitree;

/**
 * @author: Jumpingnotes
 * @date: 2017/7/20 17:33
 */
public class TestNode implements TreeNode<Integer> {
    private int nodeId;
    private String nodeName;
    private int nodePId;

    @Override
    public Integer getId() {
        return nodeId;
    }

    @Override
    public Integer getPId() {
        return nodePId;
    }

    @Override
    public boolean isRootNode() {
        return nodePId==0;
    }

    public TestNode() {
    }

    public TestNode(int nodeId, String nodeName, int nodePId) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.nodePId = nodePId;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getNodePId() {
        return nodePId;
    }

    public void setNodePId(int nodePId) {
        this.nodePId = nodePId;
    }

    @Override
    public String toString() {
        return "TestNode{" +
                "nodeId=" + nodeId +
                ", nodeName='" + nodeName + '\'' +
                ", nodePId=" + nodePId +
                '}';
    }
}
