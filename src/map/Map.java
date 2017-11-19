package map;

import units.*;

public class Map 
{
	private Unit[][] map;
	
	public Map()
	{
		map = new Unit[12][16];
		loadMap();
	}
	
	public Unit get(int r, int c)
	{
		if(r < 0 || c < 0)
			return null;
		else if(r > map.length || c > map[0].length)
			return null;
		else
			return map[r][c];
	}
	
	/**
	 * 
	 * @param r0 current row
	 * @param c0 current column
	 * @param r1 target row
	 * @param c1 target column
	 * @return 0 if current is same with target, 2 if target is an Unit, 1 if move was successful
	 */
	public int move(int r0, int c0, int r1, int c1)
	{
		if(r0 == r1 && c0 == c1)
			return 0;
		if(map[r1][c1] instanceof Unit)
			return 2;
		if((Math.abs(r0-r1) + Math.abs(c0-c1)) > map[r0][c0].getiMobility())
			return 3;
		map[r1][c1] = map[r0][c0];
		map[r0][c0] = null;
		return 1;
	}
	
	public int getRow()
	{
		return map.length;
	}
	
	public int getCol()
	{
		return map[0].length;
	}
	
	public void loadMap()
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				if(j == 8 && i == 11)
					map[i][j] = new UElf();
				else if(j == 5 && i == 5)
					map[i][j] = new UKnight();
				else
					map[i][j] = null;
			}
		}
	}
}
