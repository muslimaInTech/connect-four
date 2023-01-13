import codedraw.*;

import java.awt.*;

public class Messages {
    // set font for text
    private final TextFormat font = new TextFormat();
    private final Board board;
    private final CodeDraw myDrawObj;

    public Messages(Board board, CodeDraw myDrawObj) {
        this.board = board;
        this.myDrawObj = myDrawObj;
    }

    private TextFormat setFont() {
        font.setFontSize(30);
        font.setFontName("Arial");
        font.setTextOrigin(TextOrigin.CENTER);
        font.setBold(true);

        return font;
    }

    public void anounceWinner(int playerID) {
        show(false, "Player " + playerID + (playerID == 1 ? " (RED)" : " (YELLOW)") + " won!");
    }

    public void show(boolean isWarning, String message) {
        myDrawObj.setTextFormat(setFont());
        if (isWarning) {
            myDrawObj.setColor(Color.RED);
        } else {
            myDrawObj.setColor(Color.WHITE);
        }
        myDrawObj.drawText(350, 300, message);
        myDrawObj.show(1000);
        board.draw();
    }

}
