import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        for (int a=1;a<4;a++){
            for (int b=0;b<4;b++){
                for (int c=0;c<4;c++){
                    if (c <= b && b <= a) {
                        System.out.println(" ");
                        System.out.println(a + ": " + b + ": " + c);
                        System.out.println("resulting boards:");

                        while(a>0) {
                            if (a > b) {
                                a = a - 1;
                            } else if (a == b && b > c) {
                                a = a - 1;
                                b = b - 1;
                            } else {
                                a = a - 1;
                                b = b - 1;
                                c = c - 1;
                            }
                            System.out.println(a + ": " + b + ": " + c);
                        }
//                            for (int x = 1; x<a+1;x++){
//                                for (int y = 0; y<b+1; y++){
//                                    for (int z = 0; z < c+1; z++){
//                                        if (z <= y && y <= x){
//                                            System.out.println(x + ": " + y + ": " + z);
//                                        }
//                                    }
//                                }
//                            }


                        }
                    }
                }
            }
        }


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
