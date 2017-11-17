package map;

import map.Map;

public class Location 
{
	private int row, col;
	private Map map;
	
	public Location(Map m, int r, int c)
	{
		map = m;
		row = r;
		col = c;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
}
