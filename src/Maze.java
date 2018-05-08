
import java.util.Scanner;

public class Maze {
    
    public int counter = 0;
    private static int rows = 3; 
    private static int cols = 3;
    public static char[][] maze = new char[3][3];
    
    // Get the start location (x,y) and try to solve the maze
    public void solve(int x, int y) {
        if (step(x,y)) {
            maze[x][y] = 'S';
        }
    }
    
    // Backtracking method
  public boolean step (int x, int y) {
		
		counter++;
		
		//System.out.println(this.toString());
		
		/** Accept case - we found the exit **/
		if (maze[x][y] == 'X') {
			return true;
		}
		
		/** Reject case - we hit a wall or our path **/
		if (maze[x][y] == '#' || maze[x][y] == '*') {
			return false;
		}
		
		/** Backtracking Step **/
		
		// Mark this location as part of our path
		maze[x][y] = '*';
		boolean result;	
		
		// Try to go Right
		result = step(x, y+1);
		if (result) { return true;}
		
		// Try to go Up
		result = step(x-1, y);
		if (result) { return true;}
		
		// Try to go Left
		result = step(x, y-1);
		if (result) { return true;}		
		
		// Try to go Down
		result = step(x+1, y);
		if (result) { return true;}		
		
		
		/** Deadend - this location can't be part of the solution **/
		
		// Unmark this location
		maze[x][y] = ' ';
		
		// Go back
		return false;
	}
    public String toString() {
        String output = "";
        for (int x=0; x<rows; x++) {
            for (int y=0; y<cols; y++) {
                output += maze[x][y] + " ";
            }
            output += "\n";
        }
        return output;
    }
    
    public static void main(String[] args) {
        Maze m = new Maze();
        int a = 0;
        // Start solving the maze from (8, 1)
        Scanner scan = new Scanner(System.in);
        m.rows = scan.nextInt();
        m.cols = scan.nextInt();
        String[] s = new String[m.rows];
        // Locate the exit
        
        for (int i = 0; i < s.length; i++){
            s[i] = scan.next();
        }
        for (int i = 0; i < m.rows ; i++) {
            while( a < m.cols ){
                m.maze[i][a] =  s[i].charAt(a);
                a++;
            }
            a = 0;
        }
        scan.close();
        m.maze[rows - 1][cols - 1] = 'X';
        m.solve(0, 0);
        System.out.println(m);
        System.out.println("Total calls: " + m.counter);
    }
    
}