package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import application.controller.CharacterSelectController;
import application.controller.MainMenuController;
import units.*;

public class Map 
{
	private Unit[][] map;
	private int maxEnemies = 10;
	public Location firstTrue;
	public Location lastTrue;
	
	public Map()
	{
		map = new Unit[12][16];
		loadMap(1);
	}
	
	public Unit[][] getMatrix()
	{
		return map;
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
	
	public void remove(int r, int c)
	{
		map[r][c] = null;
	}
	
	/**
	 * 
	 * @param r0 current row
	 * @param c0 current column
	 * @param r1 target row
	 * @param c1 target column
	 * @return 0 if current is same with target, 2 if target is an Unit, 1 if move was successful, 3 is too far
	 */
	public int move(int r0, int c0, int r1, int c1)
	{
		if(r0 == r1 && c0 == c1)
			return 0;
		if(map[r1][c1] instanceof Unit)
			return 2;
		//if((Math.abs(r0-r1) + Math.abs(c0-c1)) > map[r0][c0].getiMobility())
		if(map[r0][c0] != null && map[r0][c0].getUnitName().equals("Ghost"))
		{
			if((Math.abs(r0-r1) + Math.abs(c0-c1)) <= map[r0][c0].getiMobility())
			{
				map[r1][c1] = map[r0][c0];
				map[r0][c0] = null;
				return 1;
			}
		}
		if(map[r0][c0] != null && moveable(map,r0,c0,map[r0][c0].getiMobility())[r1][c1] == false)
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
	
	public void loadMap(int level)
	{
		if(level == 1)
			loadLevel1();
		if(level == 2)
			loadLevel2();
		if(level == 3)
			loadLevel3();
		if(level == 4)
			loadLevel4();
		if(level == 5)
			loadLevel5();
	}
	
	public void loadLevel1()
	{
		int r=0;
		int enemyCount = 0;
		String line;
		Scanner s;
		try {
			s = new Scanner(new File("maze1.txt"));
			while(s.hasNextLine())
			{
				line = s.nextLine();
				for(int i = 0; i < 16; i++)
				{
					if(line.charAt(i) == '1')
						map[r][i] = new Wall();
				}
				r++;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				//if(i == 6 || i == 4)
					//map[i][j] = new UZEnemy0();
				if(j == 0 && i == 0)
					map[i][j] = CharacterSelectController.charList.get(0);
				else if(j == 1 && i == 0)
					map[i][j] = CharacterSelectController.charList.get(1);
				else if(j == 2 && i == 0)
					map[i][j] = CharacterSelectController.charList.get(2);
				else if(enemyCount <= maxEnemies && map[i][j] == null)
				{
					if(Math.random() <= 0.1)
					{
						map[i][j] = new UZEnemy0();
						enemyCount++;
						if (MainMenuController.mediumDiff == true) {
							map[i][j].iHitPointsUp(15);
							map[i][j].iAttackUp(15);
							map[i][j].iDefenseUp(15);
						}
						if (MainMenuController.hardDiff == true) {
							map[i][j].iHitPointsUp(30);
							map[i][j].iAttackUp(30);
							map[i][j].iDefenseUp(30);
						}
					}
				}
			}
		}

	}
	
	public void loadLevel2()
	{
		int r=0;
		int enemyCount = 0;
		String line;
		Scanner s;
		try {
			s = new Scanner(new File("maze2.txt"));
			while(s.hasNextLine())
			{
				line = s.nextLine();
				for(int i = 0; i < 16; i++)
				{
					if(line.charAt(i) == '1')
						map[r][i] = new Wall();
				}
				r++;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				//if(i == 6 || i == 4)
					//map[i][j] = new UZEnemy0();
				if(j == 0 && i == 10)
					map[i][j] = CharacterSelectController.charList.get(0);
				else if(j == 0 && i == 11)
					map[i][j] = CharacterSelectController.charList.get(1);
				else if(j == 1 && i == 11)
					map[i][j] = CharacterSelectController.charList.get(2);
				else if(enemyCount <= maxEnemies && map[i][j] == null)
				{
					if(Math.random() <= 0.1)
					{
						map[i][j] = new UZEnemy0();
						enemyCount++;
						if (MainMenuController.mediumDiff == true) {
							map[i][j].iHitPointsUp(15);
							map[i][j].iAttackUp(15);
							map[i][j].iDefenseUp(15);
						}
						if (MainMenuController.hardDiff == true) {
							map[i][j].iHitPointsUp(30);
							map[i][j].iAttackUp(30);
							map[i][j].iDefenseUp(30);
						}
					}
					
				}
			}
		}

	}
	
	public void loadLevel3()
	{
		int r=0;
		int enemyCount = 0;
		String line;
		Scanner s;
		try {
			s = new Scanner(new File("maze3.txt"));
			while(s.hasNextLine())
			{
				line = s.nextLine();
				for(int i = 0; i < 16; i++)
				{
					if(line.charAt(i) == '1')
						map[r][i] = new Wall();
				}
				r++;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				//if(i == 6 || i == 4)
					//map[i][j] = new UZEnemy0();
				if(j == 0 && i == 0)
					map[i][j] = CharacterSelectController.charList.get(0);
				else if(j == 1 && i == 0)
					map[i][j] = CharacterSelectController.charList.get(1);
				else if(j == 0 && i == 1)
					map[i][j] = CharacterSelectController.charList.get(2);
				else if(enemyCount <= maxEnemies && map[i][j] == null)
				{
					if(Math.random() <= 0.1)
					{
						map[i][j] = new UZEnemy0();
						enemyCount++;
						if (MainMenuController.mediumDiff == true) {
							map[i][j].iHitPointsUp(15);
							map[i][j].iAttackUp(15);
							map[i][j].iDefenseUp(15);
						}
						if (MainMenuController.hardDiff == true) {
							map[i][j].iHitPointsUp(30);
							map[i][j].iAttackUp(30);
							map[i][j].iDefenseUp(30);
						}
					}
					
				}
			}
		}

	}
	public void loadLevel4()
	{
		int r=0;
		int enemyCount = 0;
		String line;
		Scanner s;
		try {
			s = new Scanner(new File("maze4.txt"));
			while(s.hasNextLine())
			{
				line = s.nextLine();
				for(int i = 0; i < 16; i++)
				{
					if(line.charAt(i) == '1')
						map[r][i] = new Wall();
				}
				r++;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				//if(i == 6 || i == 4)
					//map[i][j] = new UZEnemy0();
				if(j == 0 && i == 10)
					map[i][j] = CharacterSelectController.charList.get(0);
				else if(j == 0 && i == 11)
					map[i][j] = CharacterSelectController.charList.get(1);
				else if(j == 1 && i == 11)
					map[i][j] = CharacterSelectController.charList.get(2);
				else if(enemyCount <= maxEnemies && map[i][j] == null)
				{
					if(Math.random() <= 0.1)
					{
						map[i][j] = new UZEnemy0();
						enemyCount++;
						if (MainMenuController.mediumDiff == true) {
							map[i][j].iHitPointsUp(15);
							map[i][j].iAttackUp(15);
							map[i][j].iDefenseUp(15);
						}
						if (MainMenuController.hardDiff == true) {
							map[i][j].iHitPointsUp(30);
							map[i][j].iAttackUp(30);
							map[i][j].iDefenseUp(30);
						}
					}
					
				}
			}
		}

	}
	public void loadLevel5()
	{
		int r=0;
		int enemyCount = 0;
		String line;
		Scanner s;
		try {
			s = new Scanner(new File("maze5.txt"));
			while(s.hasNextLine())
			{
				line = s.nextLine();
				for(int i = 0; i < 16; i++)
				{
					if(line.charAt(i) == '1')
						map[r][i] = new Wall();
				}
				r++;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				//if(i == 6 || i == 4)
					//map[i][j] = new UZEnemy0();
				if(j == 0 && i == 10)
					map[i][j] = CharacterSelectController.charList.get(0);
				else if(j == 0 && i == 11)
					map[i][j] = CharacterSelectController.charList.get(1);
				else if(j == 1 && i == 11)
					map[i][j] = CharacterSelectController.charList.get(2);
				else if(enemyCount <= maxEnemies && map[i][j] == null)
				{
					if(Math.random() <= 0.1)
					{
						map[i][j] = new UZEnemy0();
						enemyCount++;
						if (MainMenuController.mediumDiff == true) {
							map[i][j].iHitPointsUp(15);
							map[i][j].iAttackUp(15);
							map[i][j].iDefenseUp(15);
						}
						if (MainMenuController.hardDiff == true) {
							map[i][j].iHitPointsUp(30);
							map[i][j].iAttackUp(30);
							map[i][j].iDefenseUp(30);
						}
					}
					
				}
			}
		}

	}
	
	public boolean[][] moveable(Unit[][] map, int r, int c, int range)
	{
		boolean[][] mat = new boolean[map.length][map[0].length];
		firstTrue = null;
		lastTrue = null;
		for(int i = 0; i < mat.length; i++)
		{
			for(int j = 0; j < mat[0].length; j++)
			{
				mat[i][j] = false;
			}
		}
		moveableRec(map, mat, r, c, range);
		mat[r][c]=false;
		return mat;
	}
	
	public boolean[][] moveableRec(Unit[][] map, boolean[][] mat, int r, int c, int range)
	{
		if(range >= 0)
		{
			if(firstTrue == null)
				firstTrue = new Location(this,r,c);
			else if(firstTrue.getRow() >= r || firstTrue.getCol() >= c)
				firstTrue = new Location(this,Math.min(firstTrue.getRow(), r),Math.min(firstTrue.getCol(), c));
			if(lastTrue == null)
				lastTrue = new Location(this,r,c);
			else if(lastTrue.getRow() <= r || lastTrue.getCol() <= c)
				lastTrue = new Location(this,Math.max(lastTrue.getRow(), r),Math.max(lastTrue.getCol(), c));
			mat[r][c] = true;
			if((r+1)<mat.length && (map[r+1][c] == null || map[r+1][c].isbAlly()))
				moveableRec(map,mat,r+1,c,range-1);
			if((r-1)>=0 && (map[r-1][c] == null || map[r-1][c].isbAlly()))
				moveableRec(map,mat,r-1,c,range-1);
			if((c+1)<mat[0].length && (map[r][c+1] == null || map[r][c+1].isbAlly()))
				moveableRec(map,mat,r,c+1,range-1);
			if((c-1)>=0 && (map[r][c-1] == null || map[r][c-1].isbAlly()))
				moveableRec(map,mat,r,c-1,range-1);
		}
		return mat;
	}
	
	public void reset() {
		map = new Unit[12][16];
	}
}
