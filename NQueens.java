
public class NQueens {
    private int size;
    private int[][] board;

    public NQueens(int n) {
        this.size = n;
        this.board = new int[n][n];
    }

    public boolean placeNQueens() throws Exception {
        if (size <= 0) {
            throw new Exception();
        }

        return placeQueen(0);
    }

    public boolean placeQueen(int row) {
        if (row == size ) {
            printToConsole();
            return true;
        }
        for (int col = 0; col < size; col++) {
            if (canPlaceQueen(row, col)) {
                board[row][col] = 1;
                if (placeQueen(row + 1)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public boolean canPlaceQueen(int row, int col) {
        for (int x = 0; x < size; x++) {
            if (board[row][x] == 1 || board[x][col] == 1) {
                return false;
            }
        }
        for(int i = 1, x = 1; i <= row && col - x >=0; i++, x++){
            if(board[row - i][col - x] == 1){
                return false;
            }
        }
        for(int i = 1, x = 1; i <= row && x + col < size; i++, x++){
            if(board[row - i][col + x] == 1){
                return false;
            }
        }
        /*for (int y = 1; y < col + 1; y++) {
            if(row - y < 0){
                break;
            }
            if (board[row - y][col - y] == 1) {
                return false;
            }
        }
        for (int y = 1; y < col + 1; y++) {
            if(row - y > size - 1){
                break;
            }
            if (board[row + y][col - y] == 1) {
                return false;
            }
        }

        for (int z = 1; z < size - col; z++){
            if(row - z < 0){
                break;
            }
            if(board[row - z][col + z] == 1){
                return false;
            }
        }
        for(int z = 1; z < size - col; z++){
            if(row + z > size - 1){
                break;
            }
            if(board[row + z][col + z] == 1){
                return false;
            }
        }*/
        return true;
    }

    public void printToConsole() {
        for (int i = 0; i < size; i++) {
            for (int y = 0; y < size; y++) {
                if (board[i][y] == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print("Q ");
                }
            }
            System.out.println("\n");
        }
    }
}
