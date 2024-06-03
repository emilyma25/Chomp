import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<Boards> LifeBoards;
    public ArrayList<Boards> DeathBoards;
//    public ArrayList<Boards> allBoards;
    public int bestMoveColumn;
    public int bestMoveRow;

    public MyPlayer() {
        columns = new int[10];
        DeathBoards = new ArrayList<>();
        LifeBoards = new ArrayList<>();
//        allBoards = new ArrayList<>();
       // DeathBoards.add(new Boards(1,0,0));

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        for (int a=1;a<7;a++){
            for (int b=0;b<7;b++) {
                for (int c=0; c<7; c++) {
                    for(int d=0;d<7;d++) {
                        for (int e=0;e<7;e++) {
                            for(int f=0;f<7;f++) {
                                if (d <= c && c <= b && b <= a) {
                                    System.out.println(" ");
                                    System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e);
                                    System.out.println("resulting boards:");
                                    ArrayList<Boards> ResultingBoards = new ArrayList<>();

                                    //make an array list for each board of its resulting boards
                                    //run through to check for life or death
                                    //clear at end and restart??

                                    //start resulting boards
                                    //column 6
                                    for (int newf = f; newf >= 0; newf--){
                                        if (newf != f){
                                            System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + newf);
                                            ResultingBoards.add(new Boards(a, b, c, d, e, newf, 0, 0));
                                        }
                                    }
                                    //column 5
                                    for (int newe = e; newe >= 0; newe--) {
//                                        if (newe != e) {
//                                            System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + newe);
//                                            ResultingBoards.add(new Boards(a, b, c, d, newe, 0, 0));
//                                        }
                                        if (f > newe) {
                                            int newf = newe;
                                            if (newe != e && newf != f) {
                                                System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + newe + ": " + newf);
                                                ResultingBoards.add(new Boards(a, b, c, d, newe, newf,0, 0));
                                            }
                                        } else {
                                            if (newe != e) {
                                                System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + newe + ": " + f);
                                                ResultingBoards.add(new Boards(a, b, c, d, newe, f,0, 0));
                                            }
                                        }
                                    }
                                    //column 4
                                    for (int newd = d; newd >= 0; newd--) {
                                        if (f > newd) {
                                            int newf = newd;
                                            int newe = newd;
                                            if (newd != d && newe != e && newf != f) {
                                                System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + newe + ": " + newf);
                                                ResultingBoards.add(new Boards(a, b, c, newd, newe, newf, 0, 0));
                                            }
                                        } else if(f<=newd && e>newd){
                                            int newe = newd;
                                            if (newd != d && e > newd){
                                                System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + newe + ": " + f);
                                                ResultingBoards.add(new Boards(a, b, c, newd, newe, f,0, 0));
                                            }
                                        } else {
                                            if (newd != d) {
                                                System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + e + ": " + f);
                                                ResultingBoards.add(new Boards(a, b, c, newd, e, f,0, 0));
                                            }
                                        }
                                    }
                                    //column 3
                                    for (int newc = c; newc >= 0; newc--) {
                                        if (f > newc) {
                                            int newd = newc;
                                            int newe = newc;
                                            int newf = newc;
                                            if (newc != c && newd != d && newe != e) {
                                                System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + newe + ": " + newf);
                                                ResultingBoards.add(new Boards(a, b, newc, newd, newe, newf,0, 0));
                                            }
                                        } else if (f <= newc && e > newc) {
                                            int newd = newc;
                                            int newe = newc;
                                            if (newc != c && newd != d) {
                                                System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + newe + ": " + f);
                                                ResultingBoards.add(new Boards(a, b, newc, newd, newe, f,0, 0));
                                            }
                                        } else if (e <= newc && d > newc){
                                            int newd = newc;
                                            if (newc != c && newd != d) {
                                                System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + e + ": " + f);
                                                ResultingBoards.add(new Boards(a, b, newc, newd, e, f,0, 0));
                                            }
                                        }
                                        else {
                                            if (newc != c) {
                                                System.out.println(a + ": " + b + ": " + newc + ": " + d + ": " + e + ": " + f);
                                                ResultingBoards.add(new Boards(a, b, newc, d, e, f,0, 0));
                                            }
                                        }
                                    }
                                    //column 2
                                    for (int newb = b; newb >= 0; newb--) {
                                        if (f > newb) {
                                            int newc = newb;
                                            int newd = newb;
                                            int newe = newb;
                                            int newf = newb;
                                            if (newb != b && newc != c && newd != d) {
                                                System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf);
                                                ResultingBoards.add(new Boards(a, newb, newc, newd, newe, newf, 0,0));
                                            }
                                        } else if (f <= newb && e > newb) {
                                            int newc = newb;
                                            int newd = newb;
                                            int newe = newb;
                                            if (newb != b && newc != c) {
                                                System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + f);
                                                ResultingBoards.add(new Boards(a, newb, newc, newd, newe, f,0, 0));
                                            }
                                        } else if (d > newb && e <= newb) {
                                            int newc = newb;
                                            int newd = newb;
                                            if (newb != b) {
                                                System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + e + ": " + f);
                                                ResultingBoards.add(new Boards(a, newb, newc, newd, e, f,0, 0));
                                            }
                                        } else if (d <= newb && c > newb){
                                            int newc = newb;
                                            if (newb != b){
                                                System.out.println(a + ": " + newb + ": " + newc + ": " + d + ": " + e + ": " + f);
                                                ResultingBoards.add(new Boards(a, newb, newc, d, e, f,0, 0));
                                            }
                                        }
                                        else {
                                            if (newb != b) {
                                                System.out.println(a + ": " + newb + ": " + c + ": " + d + ": " + e);
                                                ResultingBoards.add(new Boards(a, newb, c, d, e, f,0, 0));
                                            }
                                        }
                                    }
                                    //column 1
                                    for (int newa = a; newa > 0; newa--) {
                                        if (f > newa) {
                                            int newb = newa;
                                            int newc = newa;
                                            int newd = newa;
                                            int newe = newa;
                                            int newf = newa;
                                            if (newa != a) {
                                                System.out.println(newa + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf);
                                                ResultingBoards.add(new Boards(newa, newb, newc, newd, newe, newf,0, 0));
                                            }
                                        } else if (e > newa && f <= newa) {
                                            int newb = newa;
                                            int newc = newa;
                                            int newd = newa;
                                            int newe = newa;
                                            if (newa != a) {
                                                System.out.println(newa + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + f);
                                                ResultingBoards.add(new Boards(newa, newb, newc, newd, newe, f,0, 0));
                                            }
                                        } else if (d > newa && e <= newa) {
                                            int newb = newa;
                                            int newc = newa;
                                            int newd = newa;
                                            if (newa != a) {
                                                System.out.println(newa + ": " + newb + ": " + newc + ": " + newd + ": " + e + ": " + f);
                                                ResultingBoards.add(new Boards(newa, newb, newc, newd, e, f,0, 0));
                                            }
                                        } else if (c > newa && d <= newa) {
                                            int newb = newa;
                                            int newc = newa;
                                            if (newa != a) {
                                                System.out.println(newa + ": " + newb + ": " + newc + ": " + d + ": " + e + ": " + f);
                                                ResultingBoards.add(new Boards(newa, newb, newc, d, e, f,0, 0));
                                            }
                                        } else if (b > newa && c <= newa){
                                            int newb = newa;
                                            if (newa != a) {
                                                System.out.println(newa + ": " + newb + ": " + c + ": " + d + ": " + e + ": " + f);
                                                ResultingBoards.add(new Boards(newa, newb, c, d, e, f,0, 0));
                                            }
                                        }
                                        else {
                                            if (newa != a) {
                                                System.out.println(newa + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f);
                                                ResultingBoards.add(new Boards(newa, b, c, d, e, f,0, 0));
                                            }
                                        }
                                    }
                                    //end resulting boards

                                    //start sorting
                                    System.out.println(" ");
                                    boolean isLifeBoard = true;
                                    for (Boards board : ResultingBoards) {
                                        for (Boards deathBoard : DeathBoards) {
                                            if (isLifeBoard == false) {
                                                break;
                                            }
                                            if (board.aa == deathBoard.aa && board.bb == deathBoard.bb && board.cc == deathBoard.cc && board.dd == deathBoard.dd && board.ee == deathBoard.ee && board.ff == deathBoard.ff) {
                                                //add move here and then add to life boards list

                                                if (a != board.aa) {
                                                    bestMoveColumn = 0;
                                                    bestMoveRow = board.aa;
                                                } else if (b != board.bb) {
                                                    bestMoveColumn = 1;
                                                    bestMoveRow = board.bb;
                                                } else if (c != board.cc) {
                                                    bestMoveColumn = 2;
                                                    bestMoveRow = board.cc;
                                                } else if (d != board.dd) {
                                                    bestMoveColumn = 3;
                                                    bestMoveRow = board.dd;
                                                } else if (e != board.ee) {
                                                    bestMoveColumn = 4;
                                                    bestMoveRow = board.ee;
                                                } else if (f != board.ff) {
                                                    bestMoveColumn = 5;
                                                    bestMoveRow = board.ff;
                                                }
                                                LifeBoards.add(new Boards(a, b, c, d, e, f, bestMoveColumn, bestMoveRow));
                                                //System.out.println("found death board");
                                                isLifeBoard = false;

                                            } else {
                                                //  isLifeBoard=true;
                                            }
                                            //System.out.println(isLifeBoard);
                                        }
//                            for(Boards lifeBoard: LifeBoards){
//                                if(board.x!=lifeBoard.x || board.y!=lifeBoard.y || board.z!=lifeBoard.z){
//                                    LifeBoards.add(new Boards(a,b,c));
//                                }else
//                            }
                                    }
                                    if (isLifeBoard == true) {
                                        //System.out.println("Adding death board");
                                        if (a == 1) {
                                            bestMoveRow = 0;
                                        } else {
                                            bestMoveRow = 1;
                                        }
                                        DeathBoards.add(new Boards(a, b, c, d, e, f, 0, bestMoveRow));
                                    }
                                    //end sorting

                                    //start best move
//                        System.out.println("best move 1");
//                        for (Boards resultingBoard: ResultingBoards){
//                            for (Boards deathBoard: DeathBoards){
//                                if (resultingBoard.x==deathBoard.x && resultingBoard.y==deathBoard.y && resultingBoard.z==deathBoard.z){
//                                    System.out.println(a+": "+b+": "+c);
//                                    System.out.println("best board: "+ deathBoard.x +": "+deathBoard.y+": "+deathBoard.z);
//                                    break;
//                                }
//                                break;
//                            }
//                            break;
//                        }
                                    //end best move
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("death boards:");
        for (Boards board:DeathBoards){
            board.printBoard();
        }
        System.out.println("life boards:");
        for (Boards board:LifeBoards){
            board.printBoard();
        }

    }


//    public void categorizeBoards(){
//        DeathBoards.add(new Boards(1,0,0));
//
//    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        //set best row and best column


        row = 1;
        column = 1;

        int[] thisBoard = {0, 0, 0, 0, 0, 0};

        for(int i=0; i< gameBoard.length;i++){
            for(int j=0;j<gameBoard[i].length; j++){
                System.out.println(gameBoard[i][j].isAlive);
                if(gameBoard[i][j].isAlive){
                    thisBoard[i]++;
                }
            }
        }
        for (int i=0; i<4; i++){
            System.out.println(Arrays.toString(thisBoard));
        }

        for (Boards board : DeathBoards) {
            if (board.aa == thisBoard[0] && board.bb == thisBoard[1] && board.cc == thisBoard[2] && board.dd == thisBoard[3] && board.ee == thisBoard[4] && board.ff == thisBoard[5]) {
                //add move here and then add to life boards list
                column = board.bestMoveRow;
                row = board.bestMoveColumn;
            }
        }
        for (Boards board: LifeBoards){
            if (board.aa == thisBoard[0] && board.bb == thisBoard[1] && board.cc == thisBoard[2] && board.dd == thisBoard[3] && board.ee == thisBoard[4] && board.ff == thisBoard[5]) {
                //add move here and then add to life boards list
                column = board.bestMoveRow;
                row = board.bestMoveColumn;
            }
        }

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;

    }

}
