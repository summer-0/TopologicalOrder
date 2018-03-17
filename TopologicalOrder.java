package day08;

import java.util.Stack;

import day08.DnGraphTopologic.EdgeNode;
import day08.TopologicalOrder.VertexNode;

public class TopologicalOrder {
/**
 * 拓扑排序
 * @param args
 */
	public static void main(String[] args) {
        TopologicalOrder topologicalOrder = new TopologicalOrder();
        topologicalOrder.createTopological();
        try {
			topologicalOrder.topologicalOrder(vertexNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static VertexNode[] vertexNode;
	
	/**
	 * 创建一个图（拓扑排序的图）
	 */
	public void createTopological(){
		VertexNode node0 = new VertexNode(0, "V0");
		VertexNode node1 = new VertexNode(0, "V1");
		VertexNode node2 = new VertexNode(2, "V2");
		VertexNode node3 = new VertexNode(0, "V3");
		VertexNode node4 = new VertexNode(2, "V4");
		VertexNode node5 = new VertexNode(3, "V5");
		VertexNode node6 = new VertexNode(1, "V6");
		VertexNode node7 = new VertexNode(2, "V7");
		VertexNode node8 = new VertexNode(2, "V8");
		VertexNode node9 = new VertexNode(1, "V9");
		VertexNode node10 = new VertexNode(1, "V10");
		VertexNode node11 = new VertexNode(2, "V11");
		VertexNode node12 = new VertexNode(1, "V12");
		VertexNode node13 = new VertexNode(2, "V13");
	    vertexNode = new VertexNode[]{node0,node1,node2,node3,node4,node5,node6,node7,node8,node9,node10,node11,node12,node13};
		node0.firstNode = new EdgeNode(11); node0.firstNode.next = new EdgeNode(5); node0.firstNode.next.next = new EdgeNode(4);
		node1.firstNode = new EdgeNode(8);node1.firstNode.next = new EdgeNode(4);node1.firstNode.next.next = new EdgeNode(2);
		node2.firstNode = new EdgeNode(9);node2.firstNode.next = new EdgeNode(6);node2.firstNode.next.next = new EdgeNode(5);
		node3.firstNode = new EdgeNode(13);node3.firstNode.next = new EdgeNode(2);
		node4.firstNode = new EdgeNode(7);
		node5.firstNode = new EdgeNode(12);node5.firstNode.next = new EdgeNode(8);
		node6.firstNode = new EdgeNode(5);
		node8.firstNode = new EdgeNode(7);
		node9.firstNode = new EdgeNode(11);node9.firstNode.next = new EdgeNode(10);
		node10.firstNode = new EdgeNode(13);
		node12.firstNode = new EdgeNode(9);
		
	}
	/**
	 * 开始拓扑排序
	 * @throws Exception 
	 */
	public void topologicalOrder(VertexNode[] vertexArray) throws Exception{
		Stack<Integer> stack = new Stack<>();
		int count = 0; //记录出栈的总数
		int index;
		//先遍历一遍，把入度为0的点压栈
		for(int i=0; i<vertexArray.length; i++){
			if(vertexArray[i].in == 0){
				stack.push(i);  //把在数组中的下标放入，每个点都有固定的下标
			}
		}
		//栈中不为空（遍历）
		while(!stack.isEmpty()){
		    index = stack.pop();//出栈那个元素的下标
			count++;
			System.out.println("顶点"+vertexArray[index].data);
			//出栈一个，就要把它指向的下一个的 入度 减一
			for(EdgeNode edgeNode = vertexArray[index].firstNode; edgeNode!=null; edgeNode = edgeNode.next){
				//获取下标
				int adjVert = edgeNode.adjVert;//下标
				//根据下标，将其入度减一
				int newIn = --vertexArray[adjVert].in;//该结点新的入度数(这里要注意)
				if(newIn == 0){
					stack.push(adjVert);  //如果入度为0，压栈
				}
			}
			
		}
		if(count<vertexArray.length){
			throw new Exception("拓扑排序失败");
		}
		
	}
	
	
	class EdgeNode{
		private int weight; //权值
		private int adjVert; //在数组中的下标
		private EdgeNode next;  //指针
		
		
		//传在数组中的下标
		public EdgeNode(int adjVert) {
			super();
			this.adjVert = adjVert;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public int getAdjVert() {
			return adjVert;
		}
		public void setAdjVert(int adjVert) {
			this.adjVert = adjVert;
		}
		public EdgeNode getNext() {
			return next;
		}
		public void setNext(EdgeNode next) {
			this.next = next;
		}
	}
	class VertexNode{
		private int in; //入度
		private String data; //数据
		EdgeNode firstNode;
		
		public EdgeNode getFirstNode() {
			return firstNode;
		}
		public void setFirstNode(EdgeNode firstNode) {
			this.firstNode = firstNode;
		}
		public VertexNode(int in, String data) {
			super();
			this.in = in;
			this.data = data;
		}
		public int getIn() {
			return in;
		}
		public void setIn(int in) {
			this.in = in;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
	}

}
