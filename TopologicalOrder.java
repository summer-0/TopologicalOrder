package day08;

import java.util.Stack;

import day08.DnGraphTopologic.EdgeNode;
import day08.TopologicalOrder.VertexNode;

public class TopologicalOrder {
/**
 * ��������
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
	 * ����һ��ͼ�����������ͼ��
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
	 * ��ʼ��������
	 * @throws Exception 
	 */
	public void topologicalOrder(VertexNode[] vertexArray) throws Exception{
		Stack<Integer> stack = new Stack<>();
		int count = 0; //��¼��ջ������
		int index;
		//�ȱ���һ�飬�����Ϊ0�ĵ�ѹջ
		for(int i=0; i<vertexArray.length; i++){
			if(vertexArray[i].in == 0){
				stack.push(i);  //���������е��±���룬ÿ���㶼�й̶����±�
			}
		}
		//ջ�в�Ϊ�գ�������
		while(!stack.isEmpty()){
		    index = stack.pop();//��ջ�Ǹ�Ԫ�ص��±�
			count++;
			System.out.println("����"+vertexArray[index].data);
			//��ջһ������Ҫ����ָ�����һ���� ��� ��һ
			for(EdgeNode edgeNode = vertexArray[index].firstNode; edgeNode!=null; edgeNode = edgeNode.next){
				//��ȡ�±�
				int adjVert = edgeNode.adjVert;//�±�
				//�����±꣬������ȼ�һ
				int newIn = --vertexArray[adjVert].in;//�ý���µ������(����Ҫע��)
				if(newIn == 0){
					stack.push(adjVert);  //������Ϊ0��ѹջ
				}
			}
			
		}
		if(count<vertexArray.length){
			throw new Exception("��������ʧ��");
		}
		
	}
	
	
	class EdgeNode{
		private int weight; //Ȩֵ
		private int adjVert; //�������е��±�
		private EdgeNode next;  //ָ��
		
		
		//���������е��±�
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
		private int in; //���
		private String data; //����
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
