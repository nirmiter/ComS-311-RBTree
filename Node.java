
public class Node
{
	public static final int RED = 0;
	public static final int BLACK = 1;

	private Node parent, right, left;
	private Endpoint endpoint, emax;

	protected int size, maxVal, height;
	private int color, key, p, val, id;

	public Node(Endpoint endpoint)
	{
		this.endpoint = endpoint;
		this.p = endpoint.getSide();
		this.key = endpoint.getValue();
		this.left = null;
		this.right = null;
	}

	public Node getParent()
	{
		return parent;
	}

	public void setParent(Node parent)
	{
		this.parent = parent;
	}

	public Node getLeft()
	{
		return left;
	}

	public void setLeft(Node left)
	{
		this.left = left;
	}

	public Node getRight()
	{
		return right;
	}

	public void setRight(Node right)
	{
		this.right = right;
	}

	public int getKey()
	{
		return key;
	}

	public int getP()
	{
		return p;
	}

	public int getVal()
	{
		return val;
	}

	public int getMaxVal()
	{
		return maxVal;
	}

	public void setMaxVal()
	{
		maxVal = Math.max(Math.max(left.maxVal, left.val + p), left.val + p + right.maxVal);
	}

	public void setMaxVal(int maxVal)
	{
		this.maxVal = maxVal;
	}

	public Endpoint getEndpoint()
	{
		return endpoint;
	}

	public Endpoint getEmax()
	{
		return emax;
	}

	public void setEmax()
	{
		int case1 = left.maxVal;
		int case2 = left.val + p;
		int case3 = case2 + right.maxVal;

		if (case1 > Math.max(case2, case3)) emax = left.emax;
		else if (case2 >= Math.max(case1, case3)) emax = this.endpoint;
		else emax = right.emax;
	}

	public void setEmax(Endpoint emax)
	{
		this.emax = emax;
	}

	public int getColor()
	{
		return color;
	}

	public void setColor(int color)
	{
		this.color = color;
	}

	public void setVal()
	{
		this.val = p + left.val + right.val;
	}

	public void setVal(int val)
	{
		this.val = val;
	}

	public int getHeight()
	{
		return this.height;
	}

	public void setHeight()
	{
		this.height = Math.max(this.left.height, this.right.height) + 1;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize()
	{
		this.size = this.left.size + this.right.size + 1;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public int getID()
	{
		return id;
	}

	public void setID(int id)
	{
		this.id = id;
	}

	public void printNode()
	{
		System.out.println("Key: " + key + "\n");
	}
}