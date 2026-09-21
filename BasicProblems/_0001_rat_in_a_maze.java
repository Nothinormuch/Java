import java.util.Arrays;
import java.util.ArrayList;
class _0001_rat_in_a_maze {
    ArrayList<String> result = new ArrayList<>();
    String path = "";
    public ArrayList<String> ratInMaze(int[][] maze) {
        if(maze[0][0]==0){
            return result;
        }
        else{
            maze[0][0]=0;
        }
        // code here
        int [][] maze_copy = new int [maze.length][];
        int []row = new int[maze[0].length];
        for(int i =0; i < maze.length;i++){
            for(int j=0; j<maze[0].length; j++){
                row[j]=maze[i][j];
            }
            maze_copy[i] = Arrays.copyOf(row,row.length);
        }
        func(maze,maze_copy,0,0);
        return result;
    }
    public void func(int[][] maze,int[][] maze_copy,int row,int col){
        int n = maze.length;
        if(row==n-1 && col==n-1){
            result.add(path);
            return;
        }
        
        if(row+1<n && maze_copy[row+1][col]==1){
            maze_copy[row+1][col]=0;
            path=path+"D";
            func(maze,maze_copy,row+1,col);
            path=path.substring(0,path.length()-1);
            maze_copy[row+1][col]=1;
        }
        if(col-1>-1 && maze_copy[row][col-1]==1){
            maze_copy[row][col-1]=0;
            path=path+"L";
            func(maze,maze_copy,row,col-1);
            path=path.substring(0,path.length()-1);
            maze_copy[row][col-1]=1;
        }
        if(col+1<n && maze_copy[row][col+1]==1){
            maze_copy[row][col+1]=0;
            path=path+"R";
            func(maze,maze_copy,row,col+1);
            path=path.substring(0,path.length()-1);
            maze_copy[row][col+1]=1;
        }
        if(row-1>-1 && maze_copy[row-1][col]==1){
            maze_copy[row-1][col]=0;
            path=path+"U";
            func(maze,maze_copy,row-1,col);
            path=path.substring(0,path.length()-1);
            maze_copy[row-1][col]=1;
        }
    }
    public static void main(String[] args){
        int [][] maze_a = {
            {1,1,1,1,1},
            {0,0,0,0,1},
            {1,1,1,1,1},
            {1,0,0,0,0},
            {1,1,1,1,1}
        };
        IO.print(new _0001_rat_in_a_maze().ratInMaze(maze_a));

        int [][] maze_b = {
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,0,1},
            {1,0,1,0,1},
            {1,1,1,0,1},
        };
        IO.print(new _0001_rat_in_a_maze().ratInMaze(maze_b));
    }
}
