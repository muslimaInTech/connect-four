import codedraw.CodeDraw;
import codedraw.EventScanner;
import codedraw.MouseClickEvent;

public class Game {

    // Constructing game
    CodeDraw myDrawObj = new CodeDraw(700, 600);
    EventScanner myEventSC = myDrawObj.getEventScanner();

    Player player = new Player();
    Disc disc = new Disc(myDrawObj);
    Board board = new Board(disc, myDrawObj);
    Messages messages = new Messages(board, myDrawObj);

    private int fields = 0;
    int[][] myGameBoard = board.initialize();

    public boolean isPossible(int[][] currentGameBoard, int col) {
        if (currentGameBoard != null && currentGameBoard.length > 0) {
            for (int i = currentGameBoard.length - 1; i >= 0; i--) {
                if (currentGameBoard[i].length > 0 && col >= 0 && col < currentGameBoard[i].length) {
                    if (currentGameBoard[i][col] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void makeMove(int col) {
        // Dropping disc in chosen column
        if (myGameBoard != null && myGameBoard.length > 0) {
            for (int y = myGameBoard.length - 1; y >= 0; y--) {
                if (myGameBoard[y].length > 0 && col >= 0 && col < myGameBoard[y].length) {
                    if (myGameBoard[y][col] == 0) {
                        // Setting value dependant of player
                        myGameBoard[y][col] = player.getId();
                        board.draw();
                        break;
                    }
                }
            }
        }
    }

    public void checkWinner() {
        if (player.isWinner(myGameBoard)) {
            myGameBoard = board.initialize();
            fields = 0;
            messages.anounceWinner(player.getId());
        }
    }

    public void checkFields(int fields) {
        if (fields == 42) {
            messages.show(true, "Board full!");
            board.empty();
            messages.show(true, "Try again!");
        }
    }

    public void play(int col) {
        if (isPossible(myGameBoard, col)) {
            makeMove(col);
            fields ++;
            checkWinner();
            checkFields(fields);
            player.switchPlayers();
        } else {
            messages.show(true, "Column already full!");
        }

    }

    public void execute() {
        board.draw();
        boolean gameActive = true;
        while (!myDrawObj.isClosed() && gameActive) {
            //Handling Keyboard entries
            if (myEventSC.hasKeyPressEvent()) {
                if (myEventSC.nextKeyPressEvent().getChar() == 'q') {
                    gameActive = false;
                }
            }
            //Handling mouse clicks
            else if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                // Getting chosen column
                int myMouseX = currentClick.getX();
                int col = myMouseX / disc.size;
                // Playing...
                play(col);
            } else {
                myEventSC.nextEvent();
            }
        }
        myDrawObj.close();
    }

}

