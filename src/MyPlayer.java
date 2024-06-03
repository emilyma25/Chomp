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
        for (int a=1;a<5;a++){
            for (int b=0;b<5;b++) {
                for (int c = 0; c < 5; c++) {
                    for(int d=0;d<5;d++) {
                        if (d<=c && c <= b && b <= a) {
                            System.out.println(" ");
                            System.out.println(a + ": " + b + ": " + c + ": " + d);
                            System.out.println("resulting boards:");
                            ArrayList<Boards> ResultingBoards = new ArrayList<>();

                            //make an array list for each board of its resulting boards
                            //run through to check for life or death
                            //clear at end and restart??

                            //start resulting boards
                            for(int newd=d;newd>=0;newd--){
                                if (newd != d) {
                                    System.out.println(a + ": " + b + ": " + c + ": " + newd);
                                    ResultingBoards.add(new Boards(a, b, c,newd, 0, 0));
                                }
                            }
                            for (int newc = c; newc >= 0; newc--) {
//                                if (newc != c) {
//                                    System.out.println(a + ": " + b + ": " + newc);
//                                    ResultingBoards.add(new Boards(a, b, newc, 0, 0));
//                                }
                                if (d > newc) {
                                    int newd = newc;
                                    if (newc != c && newd != d) {
                                        System.out.println(a + ": " + b + ": " + newc + ": " + newd);
                                        ResultingBoards.add(new Boards(a, b, newc, newd,0, 0));
                                    }
                                } else {
                                    if (newc != c) {
                                        System.out.println(a + ": " + b + ": " + newc + ": " + d);
                                        ResultingBoards.add(new Boards(a, b, newc, d,0, 0));
                                    }
                                }
                            }
                            for (int newb = b; newb >= 0; newb--) {
                                if (d > newb) {
                                    int newc = newb;
                                    int newd = newb;
                                    if (newb != b && newc != c && newd != d) {
                                        System.out.println(a + ": " + newb + ": " + newc + ": " + newd);
                                        ResultingBoards.add(new Boards(a, newb, newc, newd,0, 0));
                                    }
                                } else if (d <= newb && c > newb){
                                    int newc = newb;
                                    if (newb != b && newc != c) {
                                        System.out.println(a + ": " + newb + ": " + newc + ": " + d);
                                        ResultingBoards.add(new Boards(a, newb, newc, d,0, 0));
                                    }
                                }else{
                                    if(newb != b){
                                        System.out.println(a + ": " + newb + ": " + c + ": " + d);
                                        ResultingBoards.add(new Boards(a, newb, c, d,0, 0));
                                    }
                                }
                            }
                            for (int newa = a; newa > 0; newa--) {
                                if (d > newa) {
                                    int newb = newa;
                                    int newc = newa;
                                    int newd = newa;
                                    if (newa != a) {
                                        System.out.println(newa + ": " + newb + ": " + newc + ": " + newd);
                                        ResultingBoards.add(new Boards(newa, newb, newc, newd,0, 0));
                                    }
                                } else if(c>newa && d<=newa){
                                    int newb = newa;
                                    int newc = newa;
                                    if (newa != a) {
                                        System.out.println(newa + ": " + newb + ": " + newc + ": " + d);
                                        ResultingBoards.add(new Boards(newa, newb, newc, d,0, 0));
                                    }
                                }else if(b>newa && c<=newa && d<=newa){
                                    int newb=newa;
                                    if (newa != a) {
                                        System.out.println(newa + ": " + newb + ": " + c + ": " + d);
                                        ResultingBoards.add(new Boards(newa, newb, c, d,0, 0));
                                    }
                                }else {
                                    if (newa != a) {
                                        System.out.println(newa + ": " + b + ": " + c + ": " + d);
                                        ResultingBoards.add(new Boards(newa, b, c, d,0, 0));
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
                                    if (board.aa == deathBoard.aa && board.bb == deathBoard.bb && board.cc == deathBoard.cc && board.dd == deathBoard.dd) {
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
                                        }else if (d != board.dd){
                                            bestMoveColumn = 3;
                                            bestMoveRow = board.dd;
                                        }
                                        LifeBoards.add(new Boards(a, b, c, d, bestMoveColumn, bestMoveRow));
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
                                DeathBoards.add(new Boards(a, b, c, d,0, bestMoveRow));
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

        int[] thisBoard = {0, 0, 0, 0};

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
            if (board.aa == thisBoard[0] && board.bb == thisBoard[1] && board.cc == thisBoard[2] && board.dd == thisBoard[3]) {
                //add move here and then add to life boards list
                column = board.bestMoveRow;
                row = board.bestMoveColumn;
            }
        }
        for (Boards board: LifeBoards){
            if (board.aa == thisBoard[0] && board.bb == thisBoard[1] && board.cc == thisBoard[2] && board.dd == thisBoard[3]) {
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
