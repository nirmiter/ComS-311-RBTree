public class NILNode extends Node
{
	public NILNode(Endpoint endpoint)
	{
		super(endpoint);
		this.setColor(Node.BLACK);
		this.size = 0;
		this.maxVal = 0;
		this.height = 0;
		this.setEmax(endpoint);
	}
}