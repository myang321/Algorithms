package leetcode;

import java.util.HashMap;

import leetcode.model.UndirectedGraphNode;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private HashMap<Integer, UndirectedGraphNode> hm;

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		hm = new HashMap<Integer, UndirectedGraphNode>();
		return dfs(node);
	}

	public UndirectedGraphNode dfs(UndirectedGraphNode node) {
		if (node == null)
			return null;
		if (hm.containsKey(node.label))
			return hm.get(node.label);
		UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
		hm.put(node.label, copyNode);
		for (UndirectedGraphNode tmpNode : node.neighbors) {
			copyNode.neighbors.add(dfs(tmpNode));
		}
		return copyNode;
	}
}
