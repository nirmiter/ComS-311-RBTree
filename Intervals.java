import java.util.HashMap;
import java.util.Map;

public class Intervals
{
	private static int idNumber;
	private Endpoint left, right;
	private RBTree tree;
	private Map<Integer, Object> hashedIDA;
	private Map<Integer,Object> hashedIDB;

	public Intervals()
	{
		idNumber = 1;
		left = null;
		right = null;
		tree = new RBTree();
		hashedIDA = new HashMap<>();
		hashedIDB = new HashMap<>();
	}

	public void intervalInsert(int a, int b)
	{
		Node tempA = new Node(new Endpoint(a, Endpoint.LEFT));
		Node tempB = new Node(new Endpoint(b, Endpoint.RIGHT));

		tempA.setID(idNumber);
		tempB.setID(idNumber);

		hashedIDA.put(idNumber, tempA);
		hashedIDB.put(idNumber, tempB);

		idNumber++;

		tree.insert(tempA);
		tree.insert(tempB);
	}

	public boolean intervalDelete(int intervalID)
	{
		Node targetA = (Node) hashedIDA.get(intervalID);
		Node targetB = (Node) hashedIDB.get(intervalID);

		if (targetA == null || targetB == null) return false;

		tree.delete(targetA);
		tree.delete(targetB);

		hashedIDA.remove(intervalID);
		hashedIDB.remove(intervalID);

		return true;
	}

	public int findPOM()
	{
		return tree.getRoot().getEmax().getValue();
	}

	public RBTree getRBTree()
	{
		return tree;
	}
}