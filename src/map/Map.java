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
	
	public boolean move(int r0, int c0, int r1, int c1)
	{
		if(r0 == r1 && c0 == c1)
			return false;
		map[r1][c1] = map[r0][c0];
		map[r0][c0] = null;
		return true;
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
					map[i][j] = new UKnight();
				else
					map[i][j] = null;
			}
		}
	}
}
