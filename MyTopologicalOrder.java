package day08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import day08.MyTopologicalOrder.VertexNode;

public class MyTopologicalOrder {
/**
 * ��������
 * @param args
 */
	
	class VertexNode{
		private int inDegree; //���
		private String data; //����
		List<VertexNode> children = new ArrayList<>();
		
		public VertexNode(int inDegree, String data) {
			super();
			this.inDegree = inDegree;
			this.data = data;
		}
		public int getInDegree() {
			return inDegree;
		}
		public void setInDegree(int inDegree) {
			this.inDegree = inDegree;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
	}
	public List<VertexNode> createGraph(){
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
		
		node0.children.add(node11); node0.children.add(node5); node0.children.add(node4);
		node1.children.add(node8); node1.children.add(node4); node1.children.add(node2);
		node2.children.add(node9); node2.children.add(node6); node2.children.add(node5);
		node3.children.add(node13); node3.children.add(node2); 
		node4.children.add(node7);
		node5.children.add(node12); node5.children.add(node8);
		node6.children.add(node5);
		node8.children.add(node7);
		node9.children.add(node11); node9.children.add(node10);
		node10.children.add(node13);
		node12.children.add(node9);
		
		List<VertexNode> list = new ArrayList<>();
		list.add(node0); list.add(node1); list.add(node2); list.add(node3); list.add(node4); list.add(node5);
		list.add(node6); list.add(node7); list.add(node8); list.add(node9); list.add(node10); list.add(node11);
		list.add(node12); list.add(node13); 
		return list;
	}
	public void myTopologicalOrder(List<VertexNode> list){
		Queue<VertexNode> queue = new LinkedList<>();
		Queue<VertexNode> outQueue = new LinkedList<>(); //�˶��������Ŵ���һ���г��ӵģ��������
		int count = 0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).inDegree == 0){  //������Ϊ0
				queue.add(list.get(i));   //��ӵ�������
			}
		}
		while(!queue.isEmpty()){
			VertexNode poll = queue.poll();
			outQueue.add(poll);
			count++;
			//���Ⱥ����
			for(int j=0; j<poll.children.size(); j++){  //�������ӵ��б����Ƿ������Ϊ0��
				//����
				--poll.children.get(j).inDegree;
				if(poll.children.get(j).inDegree == 0){
					//�������
					queue.add(poll.children.get(j));
				}
			}
		}
		//���
		while(!outQueue.isEmpty()){
			VertexNode out = outQueue.poll();
			System.out.println("���㣺"+out.data+"����");
			
		}
	}
	
	
	
	public static void main(String[] args) {
        MyTopologicalOrder myTopologicalOrder = new MyTopologicalOrder();
        List<VertexNode> createGraph = myTopologicalOrder.createGraph();
        myTopologicalOrder.myTopologicalOrder(createGraph);
	}

}
