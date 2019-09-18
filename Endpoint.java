
public class Endpoint
{
	public static final int LEFT = 1;
    public static final int RIGHT = -1;
    public static final int NIL = 0; // Only used for NIL node
    
	private int value, side;
	
	public Endpoint(int value, int side)
	{
		this.value = value;
		this.side = side;
	}

	public int getValue()
	{
		return value;
	}
	
	public int getSide()
	{
		return side;
	}
}