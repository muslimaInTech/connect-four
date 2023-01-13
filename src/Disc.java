import codedraw.CodeDraw;
import codedraw.Palette;

public class Disc {

    final int size = 100;
    private final CodeDraw myDrawObj;

    public Disc(CodeDraw myDrawObj) {
        this.myDrawObj = myDrawObj;
    }

    public void draw(int[][] currentGameBoard, int i, int j) {
        switch (currentGameBoard[i][j]) {
            case 1 -> myDrawObj.setColor(Palette.RED);
            case 2 -> myDrawObj.setColor(Palette.YELLOW);
            default -> myDrawObj.setColor(Palette.GRAY);
        }
        myDrawObj.fillCircle((j * size) + (size / 2.0), (i * size)
                + (size / 2.0), size / 3.0);
    }

}
