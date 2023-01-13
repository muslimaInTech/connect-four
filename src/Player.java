
public class Player {
    private int id = 1;
    public int getId() {
        return id;
    }

    public boolean isWinner(int[][] currentGameBoard) {
        //check for 4 across
        if (currentGameBoard != null && currentGameBoard.length > 0 && id > 0 && id < 3) {
            for (int[] ints : currentGameBoard) {
                for (int col = 0; col < currentGameBoard[0].length - 3; col++) {
                    if (ints[col] == id &&
                            ints[col + 1] == id &&
                            ints[col + 2] == id &&
                            ints[col + 3] == id) {
                        System.out.println("Across");
                        return true;
                    }
                }
            }
            //check for 4 up and down
            for (int row = 0; row < currentGameBoard.length - 3; row++) {
                for (int col = 0; col < currentGameBoard[0].length; col++) {
                    if (currentGameBoard[row][col] == id &&
                            currentGameBoard[row + 1][col] == id &&
                            currentGameBoard[row + 2][col] == id &&
                            currentGameBoard[row + 3][col] == id) {
                        return true;
                    }
                }
            }
            //check upward diagonal
            for (int row = 3; row < currentGameBoard.length; row++) {
                for (int col = 0; col < currentGameBoard[0].length - 3; col++) {
                    if (currentGameBoard[row][col] == id &&
                            currentGameBoard[row - 1][col + 1] == id &&
                            currentGameBoard[row - 2][col + 2] == id &&
                            currentGameBoard[row - 3][col + 3] == id) {
                        System.out.println("Upward diagonal");
                        return true;
                    }
                }
            }
            //check downward diagonal
            for (int row = 0; row < currentGameBoard.length - 3; row++) {
                for (int col = 0; col < currentGameBoard[0].length - 3; col++) {
                    if (currentGameBoard[row][col] == id &&
                            currentGameBoard[row + 1][col + 1] == id &&
                            currentGameBoard[row + 2][col + 2] == id &&
                            currentGameBoard[row + 3][col + 3] == id) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void switchPlayers() {
        // switch turns between players
        if (id == 1) {
            this.id = 2;
        } else {
            this.id = 1;
        }
    }

}
