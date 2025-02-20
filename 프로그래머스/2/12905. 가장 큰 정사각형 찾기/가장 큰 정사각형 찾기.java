class Solution {
    public int solution(int [][]board) {
        int n = board.length;  //행의 길이
        int m = board[0].length;  //열의 길이
        int maxSide = 0;  //한 변의 최대 길이

        // DP 배열을 board 자체에서 활용 (공간 절약)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {  // 값이 1이면
                    if (i > 0 && j > 0) {
                        board[i][j] = Math.min(board[i - 1][j],
                                Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, board[i][j]); // 최대 변 길이 갱신
                }
            }
        }

        return maxSide * maxSide; // 넓이 반환
    }
}