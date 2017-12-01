package map;

import map.Map;

/**
 * 
 * @author Classic Cannon
 *
 */
public class Location 
{
	private int row, col;
	private Map map;
	
	/**
	 * constructor
	 * @param m map
	 * @param r row
	 * @param c column
	 */
	public Location(Map m, int r, int c)
	{
		map = m;
		row = r;
		col = c;
	}
	
	/**
	 * 
	 * @return row of the location
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * 
	 * @return column of the location
	 */
	public int getCol()
	{
		return col;
	}
}
