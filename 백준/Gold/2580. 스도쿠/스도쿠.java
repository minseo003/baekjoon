import java.util.*;
import java.io.*;


class Main {

   static int[][] board = new int[9][9];
   static StringBuffer sb  = new StringBuffer();


   static void dfs(int row, int col) {

       if (col == 9) {
           dfs(row + 1,0);
           return;
       }

       if (row == 9) {
           for (int i = 0; i < 9; i++) {
               for (int j = 0; j < 9; j++) {
                   System.out.print(board[i][j] + " ");
               }
               System.out.println();
           }
           System.exit(0);
       }

       if (board[row][col] == 0) {
           for (int i = 1; i <= 9; i++) {
               if (possibility(row, col, i)) {
                   board[row][col] = i;
                   dfs(row,col+1);
               }
           }
           board[row][col] = 0;
           return;
       }
       dfs(row,col+1);
   }

    public static boolean possibility(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 9 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < 9 ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        dfs(0,0);
    }
}