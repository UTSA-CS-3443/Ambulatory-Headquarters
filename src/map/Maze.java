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
		String mazeNum = "maze" + level + ".txt";
		Scanner in = null;
		try {
			String str;
			int j = 0;
			in = new Scanner(new File("src/"+mazeNum));
			while(in.hasNext()) {
				String s = in.next();
				for(int i=0; i<16; i++) {
					if(i == 15)
						str = s.substring(i);
					else
						str = s.substring(i, i+1);
					maze[j][i] = Integer.parseInt(str);
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
