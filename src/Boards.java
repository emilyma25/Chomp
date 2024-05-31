public class Boards {

    public int x;
    public int y;
    public int z;
    public int bestMoveColumn;
    public int bestMoveRow;



    public Boards(int pX, int pY, int pZ, int pBestMoveColumn, int pBestMoveRow){
        x = pX;
        y = pY;
        z = pZ;
        bestMoveColumn = pBestMoveColumn;
        bestMoveRow = pBestMoveRow;
    }

    public void printBoard(){
        System.out.println(x + ": " + y + ": " + z + ", best move: (" + bestMoveColumn + ", " + bestMoveRow + ")");
    }


}
