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
            for (int b=0;b<4;b++) {
                for (int c = 0; c < 4; c++) {
                    if (c <= b && b <= a) {
                        System.out.println(" ");
                        System.out.println(a + ": " + b + ": " + c);
                        System.out.println("resulting boards:");
//
//                        for (int newa = a; newa > 0; newa--){
//                            for (int newb = b; newb >=0; newb--){
//                                for (int newc = c; newc >=0; newc--){
//                                    if(newc <= newb && newb <= newa){
//                                        System.out.println(newa + ": " + newb + ": " + newc);
//                                    }
//                                }
//                            }
//                        }


                        for (int newc = c; newc >= 0; newc--) {
                            //System.out.println(a + ": " + b + ": " + newc + ": " + c);
                            if (newc != c) {
                                System.out.println(a + ": " + b + ": " + newc);
                            }
                        }
                        for (int newb = b; newb >= 0; newb--) {
                            if (c > newb) {
                                int newc = newb;
                                if (newb != b && newc != c) {
                                    System.out.println(a + ": " + newb + ": " + newc);
                                }
                            } else {
                                if (newb != b && c == c) {
                                    System.out.println(a + ": " + newb + ": " + c);
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
                                }
                            } else {
                                if (newa != a) {
                                    System.out.println(newa + ": " + b + ": " + c);
//                                }
                                }
//                            int newb = newa;
//                            int newc = newa;
//                            System.out.println(newa + ": " + newb + ": " + newc);
                            }
                        }
//                        while (newc>=0){
//                            newc =- newc;
//                            System.out.println(a + ": " + b + ": " + newc);
//                        }


//                        int newa = a;
//                        while(newa>0) {
//                            int newb = b;
//                            int newc = c;
//                            if (newa > newb) {
//                                newa = newa - 1;
//                            } else if (newa == newb && newb > newc) {
//                                newa = newa - 1;
//                                newb = newb - 1;
//                            } else {
//                                newa = newa - 1;
//                                newb = newb - 1;
//                                newc = newc - 1;
//                            }
//                            System.out.println(newa + ": " + newb + ": " + newc);
//                        }
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
