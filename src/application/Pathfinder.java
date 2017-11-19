package application;
public class Pathfinder
{
    public static String findPath(char[][] mat, int rx, int cx, int rt, int ct)
	{
		int[][] intMat = convert(mat);
		fill(intMat,rx,cx,rt,ct,1);
		/*for(int[] c : intMat)
		{
			for(int i : c)
			{
				if(i>9||i<0)
					System.out.print(i+" ");
				else
					System.out.print(i+"  ");
			}
			System.out.println();
		}*/

		return makeString(intMat,rx,cx,rt,ct);
	}

	public static void fill(int[][] mat, int rx, int cx, int rt, int ct, int n)
	{
		if(rx<0||rx>mat.length-1||cx<0||cx>mat[rx].length-1||rt<0||rt>mat.length-1||ct<0||ct>mat[rt].length-1)
			return;
		mat[rx][cx] = n++;
		if(rx-1>=0&&mat[rx-1][cx]==0||mat[rx-1][cx]>n)
			fill(mat,rx-1,cx,rt,ct,n);
		if(cx+1<=mat[rx].length-1&&mat[rx][cx+1]==0||mat[rx][cx+1]>n)
			fill(mat,rx,cx+1,rt,ct,n);
		if(rx+1<=mat.length-1&&mat[rx+1][cx]==0||mat[rx+1][cx]>n)
			fill(mat,rx+1,cx,rt,ct,n);
		if(cx-1>=0&&mat[rx][cx-1]==0||mat[rx][cx-1]>n)
			fill(mat,rx,cx-1,rt,ct,n);
	}

	public static String makeString(int[][] mat, int rx, int cx, int rt, int ct)
	{
		if(rx<0||rx>mat.length-1||cx<0||cx>mat[rx].length-1||rt<0||rt>mat.length-1||ct<0||ct>mat[rt].length-1)
			return "!SOMETHING OUT OF BOUNDS";
		if(mat[rt][ct]==0)
			return "!";
		if(rt==rx&&ct==cx)
			return "";
		String dir = "";
		if(ct-1>=0&&mat[rt][ct-1]==(mat[rt][ct]-1))
			dir = makeString(mat,rx,cx,rt,ct-1) + "E";
		else if(ct+1<=mat[rt].length-1&&mat[rt][ct+1]==(mat[rt][ct]-1))
			dir = makeString(mat,rx,cx,rt,ct+1) + "W";
		else if(rt-1>=0&&mat[rt-1][ct]==(mat[rt][ct]-1))
			dir = makeString(mat,rx,cx,rt-1,ct) + "S";
		else if(rt+1<=mat.length-1&&mat[rt+1][ct]==(mat[rt][ct]-1))
			dir = makeString(mat,rx,cx,rt+1,ct) + "N";
		return dir;
	}

	public static int[][] convert(char[][] mat)
	{
		int[][] intMat = new int[mat.length][mat[0].length];
		for(int r = 0; r < mat.length; r++)
		{
			for(int c = 0; c < mat[0].length; c++)
			{
				if(mat[r][c]== 'W')
					intMat[r][c] =-1;
				else
					intMat[r][c] = 0;
			}
		}
		return intMat;
	}
}