import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<Boards> LifeBoards;
    public ArrayList<Boards> DeathBoards;

    public MyPlayer() {
        columns = new int[10];
        DeathBoards = new ArrayList<>();
        LifeBoards = new ArrayList<>();
       // DeathBoards.add(new Boards(1,0,0));

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        for (int a=1;a<4;a++){
            for (int b=0;b<4;b++) {
                for (int c = 0; c < 4; c++) {
                    if (c <= b && b <= a) {
                        System.out.println(" ");
                        System.out.println(a + ": " + b + ": " + c);
                        System.out.println("resulting boards:");
                        ArrayList<Boards> ResultingBoards = new ArrayList<>();

                        //make an array list for each board of its resulting boards
                        //run through to check for life or death
                        //clear at end and restart??

                        //start resulting boards
                        for (int newc = c; newc >= 0; newc--) {
                            if (newc != c) {
                                System.out.println(a + ": " + b + ": " + newc);
                                ResultingBoards.add(new Boards(a,b,newc));
                            }
                        }
                        for (int newb = b; newb >= 0; newb--) {
                            if (c > newb) {
                                int newc = newb;
                                if (newb != b && newc != c) {
                                    System.out.println(a + ": " + newb + ": " + newc);
                                    ResultingBoards.add(new Boards(a,newb,newc));
                                }
                            } else {
                                if (newb != b && c == c) {
                                    System.out.println(a + ": " + newb + ": " + c);
                                    ResultingBoards.add(new Boards(a,newb,c));
//                                }
                                }
                            }
                        }
                        for (int newa = a; newa > 0; newa--) {
                            if (b > newa) {
                                int newb = newa;
                                int newc = newa;
                                if (newa != a) {
                                    System.out.println(newa + ": " + newb + ": " + newc);
                                    ResultingBoards.add(new Boards(newa,newb,newc));
                                }
                            } else {
                                if (newa != a) {
                                    System.out.println(newa + ": " + b + ": " + c);
                                    ResultingBoards.add(new Boards(newa,b,c));
                                }
                            }
                        }
                        //end resulting boards

                        //start sorting
                        boolean isLifeBoard = true;
                        for (Boards board : ResultingBoards) {
                            for (Boards deathBoard: DeathBoards) {
                                if(isLifeBoard ==false){
                                    break;
                                }
                                if (board.x == deathBoard.x && board.y == deathBoard.y && board.z == deathBoard.z) {
                                    LifeBoards.add(new Boards(a, b, c));
                                    //System.out.println("found death board");
                                    isLifeBoard=false;

                                }else{
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
                        if(isLifeBoard==true){
                            //System.out.println("Adding death board");
                            DeathBoards.add(new Boards(a,b,c));
                        }
                        //end sorting

                        //start best move
                        for (Boards resultingBoard: ResultingBoards){
                            for (Boards deathBoard: DeathBoards){
                                if (resultingBoard.x==deathBoard.x && resultingBoard.y==deathBoard.y && resultingBoard.z==deathBoard.z){
                                    System.out.println(a+": "+b+": "+c);
                                    System.out.println("best move: "+ deathBoard.x +": "+deathBoard.y+": "+deathBoard.z);
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        //end best move
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

        row = 1;
        column = 1;



        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;


    }

}
