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



    public Boards(int pAa, int pBb, int pCc, int pDd, int pEe, int pFf, int pGg, int pHh, int pIi, int pJj, int pBestMoveColumn, int pBestMoveRow){
        aa = pAa;
        bb = pBb;
        cc = pCc;
        dd = pDd;
        ee = pEe;
        ff = pFf;
        gg = pGg;
        hh = pHh;
        ii = pIi;
        jj = pJj;
        bestMoveColumn = pBestMoveColumn;
        bestMoveRow = pBestMoveRow;
    }

    public void printBoard(){
        System.out.println(aa + ": " + bb + ": " + cc + ": " + dd + ":" + ee + ": " + ff + ": " + gg + ": " + hh + ": " + ii + ": " + jj+ ", best move: (" + bestMoveColumn + ", " + bestMoveRow + ")");
    }


}
