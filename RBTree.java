/*
 * CODE HERE CONFUSE ME A LOT
 */
public class RBTree
{
	private Node root, nil;


	public RBTree()
	{

		nil = new NILNode(new Endpoint(0, Endpoint.NIL));
		root = nil;
	}

	public Node getRoot()
	{
		return root;
	}

	public Node getNILNode()
	{
		return nil;
	}

	public int getSize()
	{
		return root.getSize();
	}

	public int getHeight()
	{
		return root.getHeight();
	}

	/**
	 * START OF DELETION CODE
	 *
	 * @param u
	 * @param v
	 */
	public void transplant(Node u, Node v)
	{

		if (u.getParent().equals(nil))
		{
			root = v; //If u is the root, set root=v
		}
		else if (u.equals(u.getParent().getLeft()))
		{
			u.getParent().setLeft(v); //if u is on the left of u's parent
		}
		else
		{
			u.getParent().setRight(v); //U is on the right of u's parent
		}
		v.setParent(u.getParent());
	}

	public Node minimum(Node toFind)
	{
		while (!toFind.getLeft().equals(nil))
		{
			toFind = toFind.getLeft();
		}
		return toFind;
	}

	public void delete(Node toDelete)
	{
		//Node toDelete=search(intervalID);
		Node x;

		//Node toDelete=search(intervalID);
		Node y=toDelete;

		int yOriginalColor = y.getColor();
		if (toDelete.getLeft().equals(nil))
		{
			x = toDelete.getRight();
			transplant(toDelete, toDelete.getRight());
		}
		else if (toDelete.getRight().equals(nil))
		{
			x = toDelete.getLeft();
			transplant(toDelete, toDelete.getLeft());
		}
		else
		{
			//In this area we're setting y to minimum of right, whereas RBT Visualizer grabs the left one
			y = minimum(toDelete.getRight());
			yOriginalColor = y.getColor();
			x = y.getRight();
			if (y.getParent().equals(toDelete))
			{
				x.setParent(y);
			}
			else
			{
				transplant(y, y.getRight());
				y.setRight(toDelete.getRight());
				y.getRight().setParent(y);
			}
			transplant(toDelete, y);
			y.setLeft(toDelete.getLeft());
			y.getLeft().setParent(y);
			y.setColor(toDelete.getColor());

		}
		if (yOriginalColor == Node.BLACK)
		{
			deleteFixup(x);
			//updateNode(x);
		}
	}

	public void deleteFixup(Node toFix)
	{
		Node w, temp;
		//Indentation here confuse me a lot :c
		while (!toFix.equals(root) && toFix.getColor() == Node.BLACK)
		{
			if (toFix.equals(toFix.getParent().getLeft()))
			{
				w = toFix.getParent().getRight();
				if (w.getColor() == Node.RED)
				{
					w.setColor(Node.BLACK);
					toFix.getParent().setColor(Node.RED);
					leftRotate(toFix.getParent());
					w = toFix.getParent().getRight();
					//adding
					updateNode(w);

				}
				if (w.getLeft().getColor() == Node.BLACK && w.getRight().getColor() == Node.BLACK)
				{
					w.setColor(Node.RED);
					toFix = toFix.getParent();

				}
				else
				{

					if (w.getRight().getColor() == Node.BLACK)
					{
						//adding
						temp = w.getRight();
						w.getLeft().setColor(Node.BLACK);
						w.setColor(Node.RED);
						rightRotate(w);
						w = toFix.getParent().getRight();
						//adding
						updateNode(temp);
					}
					//adding
					temp = w.getLeft();
					w.setColor(toFix.getParent().getColor());
					toFix.getParent().setColor(Node.BLACK);
					w.getRight().setColor(Node.BLACK);
					leftRotate(toFix.getParent());
					toFix = root;
					updateNode(temp);
				}
			}
			else
			{
				w = toFix.getParent().getLeft();
				if (w.getColor() == Node.RED)
				{
					w.setColor(Node.BLACK);
					toFix.getParent().setColor(Node.RED);
					rightRotate(toFix.getParent());
					w = toFix.getParent().getLeft();
					//adding
					updateNode(w);

				}
				if (w.getRight().getColor() == Node.BLACK && w.getLeft().getColor() == Node.BLACK)
				{
					w.setColor(Node.RED);
					toFix = toFix.getParent();
				}
				else
				{

					if (w.getLeft().getColor() == Node.BLACK)
					{
						temp = w.getLeft();
						w.getRight().setColor(Node.BLACK);
						w.setColor(Node.RED);
						leftRotate(w);
						w = toFix.getParent().getLeft();
						updateNode(temp);

					}
					temp = w.getRight();
					w.setColor(toFix.getParent().getColor());
					toFix.getParent().setColor(Node.BLACK);
					w.getLeft().setColor(Node.BLACK);
					rightRotate(toFix.getParent());
					toFix = root;
					updateNode(temp);
				}
			}
		}
		toFix.setColor(Node.BLACK);

	}

	public void insert(Node toInsert)
	{
		Node y = nil;
		Node x = root;

		while (!x.equals(nil))
		{
			y = x;


			if (toInsert.getKey() < x.getKey())
			{ x = x.getLeft(); }
			else
			{ x = x.getRight(); }
		}

		toInsert.setParent(y);

		if (y.equals(nil))
		{
			root = toInsert;

		}
		else if (toInsert.getKey() < y.getKey())
		{ y.setLeft(toInsert); }
		else
		{ y.setRight(toInsert); }

		toInsert.setLeft(nil);
		toInsert.setRight(nil);
		toInsert.setColor(Node.RED);
		insertFixup(toInsert);

		updateNode(toInsert);
	}

	private void insertFixup(Node toInsert)
	{
		Node y;

		while (toInsert.getParent().getColor() == Node.RED)
		{
			if (toInsert.getParent().equals(toInsert.getParent().getParent().getLeft()))
			{
				y = toInsert.getParent().getParent().getRight();

				if (y.getColor() == Node.RED)
				{
					toInsert.getParent().setColor(Node.BLACK);
					y.setColor(Node.BLACK);
					toInsert.getParent().getParent().setColor(Node.RED);
					toInsert = toInsert.getParent().getParent();
				}
				else
				{
					if (toInsert.equals(toInsert.getParent().getRight()))
					{
						toInsert = toInsert.getParent();
						leftRotate(toInsert);
					}

					toInsert.getParent().setColor(Node.BLACK);
					toInsert.getParent().getParent().setColor(Node.RED);
					rightRotate(toInsert.getParent().getParent());
				}
			}
			else
			{
				y = toInsert.getParent().getParent().getLeft();

				if (y.getColor() == Node.RED)
				{
					toInsert.getParent().setColor(Node.BLACK);
					y.setColor(Node.BLACK);
					toInsert.getParent().getParent().setColor(Node.RED);
					toInsert = toInsert.getParent().getParent();
				}
				else
				{
					if (toInsert.equals(toInsert.getParent().getLeft()))
					{
						toInsert = toInsert.getParent();
						rightRotate(toInsert);
						updateNode(toInsert);
					}

					toInsert.getParent().setColor(Node.BLACK);
					toInsert.getParent().getParent().setColor(Node.RED);
					leftRotate(toInsert.getParent().getParent());
				}
			}
		}

		root.setColor(Node.BLACK);
	}

	private void leftRotate(Node toInsert)
	{
		Node y = toInsert.getRight();
		toInsert.setRight(y.getLeft());

		if (!y.getLeft().equals(nil))
		{ y.getLeft().setParent(toInsert); }

		y.setParent(toInsert.getParent());

		if (toInsert.getParent().equals(nil))
		{ root = y; }
		else if (toInsert == toInsert.getParent().getLeft())
		{ toInsert.getParent().setLeft(y); }
		else
		{ toInsert.getParent().setRight(y); }

		y.setLeft(toInsert);
		toInsert.setParent(y);

		updateNodeLeftRotate(toInsert, y);
	}

	private void rightRotate(Node toInsert)
	{
		Node y = toInsert.getLeft();
		toInsert.setLeft(y.getRight());

		if (!y.getRight().equals(nil))
		{ y.getRight().setParent(toInsert); }

		y.setParent(toInsert.getParent());

		if (toInsert.getParent().equals(nil))
		{ root = y; }
		else if (toInsert == toInsert.getParent().getRight())
		{ toInsert.getParent().setRight(y); }
		else
		{ toInsert.getParent().setLeft(y); }

		y.setRight(toInsert);
		toInsert.setParent(y);

		updateNodeRightRotate(toInsert, y);
	}

	private void updateNode(Node toInsert)
	{
		while (!toInsert.equals(nil))
		{
			toInsert.setHeight();
			toInsert.setSize();
			toInsert.setVal();
			toInsert.setMaxVal();
			toInsert.setEmax();

			toInsert = toInsert.getParent();
		}
	}

	private void updateNodeLeftRotate(Node toInsert, Node y)
	{
		y.setSize(toInsert.getSize());
		toInsert.setSize();
		y.setHeight(toInsert.getHeight());
		toInsert.setHeight();
		y.setVal(toInsert.getVal());
		toInsert.setVal();
		y.setMaxVal(toInsert.getMaxVal());
		toInsert.setMaxVal();
		y.setEmax(toInsert.getEmax());
		toInsert.setEmax();
	}

	private void updateNodeRightRotate(Node toInsert, Node y)
	{
		toInsert.setSize(y.getSize());
		y.setSize();
		toInsert.setHeight(y.getHeight());
		y.setHeight();
		toInsert.setVal(y.getVal());
		y.setVal();
		toInsert.setMaxVal(y.getMaxVal());
		y.setMaxVal();
		toInsert.setEmax(y.getEmax());
		y.setEmax();
	}

	public void print(Node node)
	{
		if (node.equals(nil))
		{
			return;
		}

		print(node.getLeft());

		String nodeKey = node.getKey() + "";
		String parentKey = node.getParent().equals(nil) ? "NIL" : node.getParent().getKey() + "";
		String leftKey = node.getLeft().equals(nil) ? "NIL" : node.getLeft().getKey() + "";
		String rightKey = node.getRight().equals(nil) ? "NIL" : node.getRight().getKey() + "";

		String nodeColor = node.getColor() == 0 ? "RED" : "BLACK";

		System.out.println("You are at this node: " + nodeKey + ", " + nodeColor + ". Node info of (Parent, Left, Right)");
		System.out.println("(" + parentKey + ", " + leftKey + ", " + rightKey + ")");
		System.out.println("The size of this subtree: " + node.getSize());
		System.out.println("The height of this subtree is: " + node.getHeight());
		System.out.println("The p value of this node is: " + node.getP());
		System.out.println("The val (sum of p) of this subtree is: " + node.getVal());
		System.out.println("The MAX value of this subtree is: " + node.getMaxVal());
		System.out.println("The EMAX endpoint is represented by the value: " + node.getEmax().getValue());
		System.out.println(" ");
		print(node.getRight());
	}

	public void printPostorder(Node node)
	{
		if (node.equals(nil))
		{
			return;
		}
		printPostorder(node.getLeft());
		printPostorder(node.getRight());
		System.out.print(node.getKey() + ", ");
	}
}