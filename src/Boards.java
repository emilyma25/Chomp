public class Boards {

    public int aa;
    public int bb;
    public int cc;
    public int dd;
    public int bestMoveColumn;
    public int bestMoveRow;



    public Boards(int pAa, int pBb, int pCc, int pDd,  int pBestMoveColumn, int pBestMoveRow){
        aa = pAa;
        bb = pBb;
        cc = pCc;
        dd = pDd;
        bestMoveColumn = pBestMoveColumn;
        bestMoveRow = pBestMoveRow;
    }

    public void printBoard(){
        System.out.println(aa + ": " + bb + ": " + cc + ": " + dd + ", best move: (" + bestMoveColumn + ", " + bestMoveRow + ")");
    }


}
