import codedraw.CodeDraw;

import java.awt.*;

public class Board {

    private final int row = 6;
    private final int col = 7;
    int[][] gameBoard = new int[row][col];

    private final Disc disc;
    private final CodeDraw myDrawObj;

    public Board(Disc disc, CodeDraw myDrawObj) {
        this.disc = disc;
        this.myDrawObj = myDrawObj;
    }

    public int[][] initialize() {
        // initializing board by creating a 2D Array
        for (int y = 0; y < row; y++) // creating rows
            for (int x = 0; x < col; x++) { // iterating through indexes (cols)
                gameBoard[y][x] = 0;
            }
        return gameBoard;
    }

    public void draw() {
        if (gameBoard != null && gameBoard.length > 0) {
            // Designing the board graphically
            for (int i = 0; i < gameBoard.length; i++) {
                if (gameBoard[i].length > 0) {
                    for (int j = 0; j < gameBoard[i].length; j++) {
                        // background
                        myDrawObj.setColor(Color.black);
                        myDrawObj.fillSquare(((j) * disc.size), (i * disc.size), disc.size);
                        // circles
                        disc.draw(gameBoard, i, j);
                    }
                }
            }
            myDrawObj.show();
        }
    }

    public void empty() {
        //Clearing out first line
        for (int j = 0; j < gameBoard[0].length; j++) {
            gameBoard[0][j] = 0;
            disc.draw(gameBoard, 0, j);
        }
        //flush
        for (int i = 1; i < gameBoard.length; i++) {
            // assign values of the previous row to current row
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = gameBoard[i - 1][j];
                disc.draw(gameBoard, i, j);
            }
            myDrawObj.show(500);
        }
        //Re-initialize
        initialize();
    }

}
