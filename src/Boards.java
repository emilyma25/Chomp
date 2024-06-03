public class Boards {

    public int aa;
    public int bb;
    public int cc;
    public int dd;
    public int ee;
    public int ff;
    public int gg;
    public int hh;
    public int ii;
    public int jj;
    public int bestMoveColumn;
    public int bestMoveRow;



    public Boards(int pAa, int pBb, int pCc, int pDd, int pEe, int pFf, int pBestMoveColumn, int pBestMoveRow){
        aa = pAa;
        bb = pBb;
        cc = pCc;
        dd = pDd;
        ee = pEe;
        ff = pFf;
        bestMoveColumn = pBestMoveColumn;
        bestMoveRow = pBestMoveRow;
    }

    public void printBoard(){
        System.out.println(aa + ": " + bb + ": " + cc + ": " + dd + ":" + ee + ": " + ff + ", best move: (" + bestMoveColumn + ", " + bestMoveRow + ")");
    }


}
