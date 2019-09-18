
public class Main {

	static RBTree taco;
	public static void main(String[] args)
	{
		
		Intervals intervalHolder = new Intervals();
		
		intervalHolder.intervalInsert(0, 9);
		intervalHolder.intervalInsert(2, 11);
		intervalHolder.intervalInsert(3, 6);
		intervalHolder.intervalInsert(4, 7);
		intervalHolder.intervalInsert(6, 7);
		intervalHolder.intervalInsert(5, 10);
		intervalHolder.intervalInsert(5, 15);
		//intervalHolder.getRBTree().print(intervalHolder.getRBTree().getRoot());
		
		System.out.printf("%n");
		System.out.println("Size: " + intervalHolder.getRBTree().getSize() + " POM: " + intervalHolder.findPOM());
		//intervalHolder.intervalDelete(1);
		intervalHolder.intervalDelete(3);
		
		System.out.println("Size: " + intervalHolder.getRBTree().getSize() + " POM: " + intervalHolder.findPOM());
		
	//	System.out.println("NEW TREE AFTER DELETIONS");
		//System.out.println("");
		//intervalHolder.getRBTree().print(intervalHolder.getRBTree().getRoot());
		//intervalHolder.getRBTree().delete(Node(0));
		//System.out.println("Size: " + intervalHolder.getRBTree().getSize() + " POM: " + intervalHolder.findPOM());
		
		taco = new RBTree();
		/*
		Node node0 = new Node(new Endpoint(0, Endpoint.LEFT));
		Node node4 = new Node(new Endpoint(4, Endpoint.RIGHT));
		Node node1 = new Node(new Endpoint(1, Endpoint.LEFT));
		Node node6 = new Node(new Endpoint(6, Endpoint.RIGHT));
		Node node3 = new Node(new Endpoint(3, Endpoint.LEFT));
		Node node9 = new Node(new Endpoint(9, Endpoint.RIGHT));
		Node node01 = new Node(new Endpoint(0, Endpoint.RIGHT));
		Node node10 = new Node(new Endpoint(10, Endpoint.LEFT));
		
		Node node0 = new Node(new Endpoint(0, Endpoint.LEFT));
		Node node1 = new Node(new Endpoint(1, Endpoint.RIGHT));
		Node node2 = new Node(new Endpoint(2, Endpoint.LEFT));
		Node node3 = new Node(new Endpoint(3, Endpoint.RIGHT));
		Node node4 = new Node(new Endpoint(4, Endpoint.LEFT));
		Node node5 = new Node(new Endpoint(5, Endpoint.RIGHT));
		Node node6 = new Node(new Endpoint(6, Endpoint.LEFT));
		Node node7 = new Node(new Endpoint(7, Endpoint.RIGHT));
		Node node8 = new Node(new Endpoint(8, Endpoint.LEFT));
		Node node9 = new Node(new Endpoint(9, Endpoint.RIGHT));
		Node node10 = new Node(new Endpoint(10, Endpoint.LEFT));
		Node node11 = new Node(new Endpoint(11, Endpoint.RIGHT));
		Node node12 = new Node(new Endpoint(12, Endpoint.LEFT));
		Node node13 = new Node(new Endpoint(13, Endpoint.RIGHT));
		Node node14 = new Node(new Endpoint(14, Endpoint.LEFT));
		Node node15 = new Node(new Endpoint(15, Endpoint.RIGHT));
		Node node16 = new Node(new Endpoint(16, Endpoint.LEFT));
		Node node17 = new Node(new Endpoint(17, Endpoint.RIGHT));
		Node node18 = new Node(new Endpoint(18, Endpoint.LEFT));
		Node node19 = new Node(new Endpoint(19, Endpoint.RIGHT));
		Node node20 = new Node(new Endpoint(20, Endpoint.LEFT));
		Node node21 = new Node(new Endpoint(21, Endpoint.RIGHT));
		
		
		taco.insert(node0);
		taco.insert(node1);
		taco.insert(node18);
		taco.insert(node2);
		taco.insert(node3);
		
		taco.insert(node14);
		
		taco.insert(node19);
		taco.insert(node20);
		taco.insert(node21);
		taco.insert(node4);
		taco.insert(node5);
		
		taco.insert(node15);
		taco.insert(node6);
		taco.insert(node12);
		taco.insert(node13);
		taco.insert(node16);
		taco.insert(node11);
		taco.insert(node10);
		
		taco.insert(node9);
		taco.insert(node17);
		taco.insert(node8);
		taco.insert(node7);
	
		
		taco.print(taco.getRoot());
		System.out.println(taco.getSize());

		taco.delete(node3);
		taco.print(taco.getRoot());
		System.out.println(taco.getSize());
		*/
	}
}
