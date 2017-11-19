package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	
	private int [][] maze;
	
	public Maze() {
		maze = new int[12][16];
	}
	
	public int[][] getLevel(int level) {
		String mazeNum = "maze" + level;
		Scanner in = null;
		try {
			String str;
			int j = 0;
			in = new Scanner(new File("src/map/"+mazeNum));
			while(in.hasNext()) {
				String s = in.next();
				for(int i=0; i<12; i++) {
					if(i == 12)
						str = s.substring(i);
					else
						str = s.substring(i, i+1);
					maze[i][j] = Integer.parseInt(str);
				}
				j++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("failed to open map");
			e.printStackTrace();
		}
		in.close();
		// todo
		return maze;
	}
}
