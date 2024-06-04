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
        for (int a=1;a<11;a++){
            for (int b=0;b<11;b++) {
                for (int c=0; c<11; c++) {
                    for(int d=0;d<11;d++) {
                        for (int e=0;e<11;e++) {
                            for(int f=0;f<11;f++) {
                                for(int g=0;g<11;g++) {
                                    for (int h=0;h<11;h++){
                                        for (int i=0; i<11; i++){
                                            for (int j=0; j<11; j++){
                                                if (j<=i && i<=h && h<=g && g<=f && f<=e && e<=d && d <= c && c <= b && b <= a) {
                                                    System.out.println(" ");
                                                    System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                    System.out.println("resulting boards:");
                                                    ArrayList<Boards> ResultingBoards = new ArrayList<>();

                                                    //make an array list for each board of its resulting boards
                                                    //run through to check for life or death
                                                    //clear at end and restart??

                                                    //start resulting boards
                                                    //column 10
                                                    for (int newj = j; newj>=0; newj--){
                                                        if (newj != j){
                                                            //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + newj);
                                                            ResultingBoards.add(new Boards(a, b, c, d, e, f,g,h,i,newj, 0, 0));
                                                        }
                                                    }
                                                    //column 9
                                                    for (int newi = i; newi>=0; newi--){
                                                        if (j > newi) {
                                                            //int newj = newi;
                                                            if (newi != i) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + newi + ": " + newi);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, f,g,h,newi,newi, 0, 0));
                                                            }
                                                        } else {
                                                            if (newi != i) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + newi + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, f,g,h,newi,j, 0, 0));
                                                            }
                                                        }
                                                    }
                                                    //column 8
                                                    for (int newh = i; newh>=0; newh--){
                                                        if (j > newh) {
//                                                            int newj = newh;
//                                                            int newi = newh;
                                                            if (newh != h) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + newh + ": " + newh + ": " + newh);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, f,g,newh,newh,newh, 0, 0));
                                                            }
                                                        } else if (j <= newh && i > newh) {
                                                            //int newi = newh;
                                                            if (newh != h && i > newh) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + newh + ": " + newh + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, f,g,newh,newh,j, 0, 0));
                                                            }
                                                        } else {
                                                            if (newh != h) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + newh + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, f,g,newh,i,j, 0, 0));
                                                            }
                                                        }
                                                    }
                                                    //column 7
                                                    for (int newg = i; newg>=0; newg--){
                                                        if (j > newg) {
//                                                            int newh = newg;
//                                                            int newi = newg;
//                                                            int newj = newg;
                                                            if (newg != g) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + newg + ": " + newg + ": " + newg + ": " + newg);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, f,newg,newg,newg,newg, 0, 0));
                                                            }
                                                        } else if (j <= newg && i > newg) {
//                                                            int newh = newg;
//                                                            int newi = newg;
                                                            if (newg != g) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + newg + ": " + newg + ": " + newg + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, f,newg,newg,newg,j, 0, 0));
                                                            }
                                                        } else if (i <= newg && h > newg) {
//                                                            int newh = newg;
                                                            if (newg != g) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + newg + ": " + newg + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, f,newg,newg,i,j, 0, 0));
                                                            }
                                                        } else {
                                                            if (newg != g) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + newg + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, f,newg,h,i,j, 0, 0));
                                                            }
                                                        }
                                                    }
                                                    //column 6
                                                    for (int newf = f; newf >= 0; newf--) {
                                                        if (j > newf) {
//                                                            int newg = newf;
//                                                            int newh = newf;
//                                                            int newi = newf;
//                                                            int newj = newf;
                                                            if (newf != f) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + newf + ": " + newf + ": " + newf + ": " + newf + ": " + newf);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, newf,newf,newf,newf,newf, 0, 0));
                                                            }
                                                        } else if (j <= newf && i > newf) {
//                                                            int newg = newf;
//                                                            int newh = newf;
//                                                            int newi = newf;
                                                            if (newf != f) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + newf + ": " + newf + ": " + newf + ": " + newf + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, newf,newf,newf,newf,j, 0, 0));
                                                            }
                                                        } else if (i > newf && h <= newf) {
//                                                            int newg = newf;
//                                                            int newh = newf;
                                                            if (newf != f) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + newf + ": " + newf + ": " + newf + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, newf,newf,newf,i,j, 0, 0));
                                                            }
                                                        } else if (h <= newf && g > newf) {
//                                                            int newg = newf;
                                                            if (newf != f) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + newf + ": " + newf + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, newf,newf,h,i,j, 0, 0));
                                                            }
                                                        } else {
                                                            if (newf != f) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + e + ": " + newf + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, e, newf,g,h,i,j, 0, 0));
                                                            }
                                                        }
                                                    }
                                                    //column 5
                                                    for (int newe = e; newe >= 0; newe--) {
                                                        if (j > newe) {
//                                                            int newf = newe;
//                                                            int newg = newe;
//                                                            int newh = newe;
//                                                            int newi = newe;
//                                                            int newj = newe;
                                                            if (newe != e) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + newe + ": " + newe + ": " + newe + ": " + newe + ": " + newe + ": " + newe);
                                                                ResultingBoards.add(new Boards(a, b, c, d, newe, newe,newe,newe,newe,newe, 0, 0));
                                                            }
                                                        } else if (i > newe && j <= newe) {
//                                                            int newf = newe;
//                                                            int newg = newe;
//                                                            int newh = newe;
//                                                            int newi = newe;
                                                            if (newe != e) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + newe + ": " + newe + ": " + newe + ": " + newe + ": " + newe + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, newe, newe,newe,newe,newe,j, 0, 0));
                                                            }
                                                        } else if (h > newe && i <= newe) {
//                                                            int newf = newe;
//                                                            int newg = newe;
//                                                            int newh = newe;
                                                            if (newe != e) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + newe + ": " + newe + ": " + newe + ": " + newe + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, newe, newe,newe,newe,i,j, 0, 0));
                                                            }
                                                        } else if (g > newe && h <= newe) {
//                                                            int newf = newe;
//                                                            int newg = newe;
                                                            if (newe != e) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + newe + ": " + newe + ": " + newe + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, newe, newe,newe,h,i,j, 0, 0));
                                                            }
                                                        } else if (f > newe && g <= newe) {
//                                                            int newf = newe;
                                                            if (newe != e) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + newe + ": " + newe + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, newe, newe,g,h,i,j, 0, 0));
                                                            }
                                                        } else {
                                                            if (newe != e) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + d + ": " + newe + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, d, newe, f,g,h,i,j, 0, 0));
                                                            }
                                                        }
                                                    }
                                                    //column 4
                                                    for (int newd = d; newd >= 0; newd--) {
                                                        if (j > newd) {
//                                                            int newe = newd;
//                                                            int newf = newd;
//                                                            int newg = newd;
//                                                            int newh = newd;
//                                                            int newi = newd;
//                                                            int newj = newd;
                                                            if (newd != d) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + newd + ": " + newd + ": " + newd + ": " + newd + ": " + newd + ": " + newd);
                                                                ResultingBoards.add(new Boards(a, b, c, newd, newd, newd,newd,newd,newd,newd, 0, 0));
                                                            }
                                                        } else if (i > newd && j <= newd) {
//                                                            int newe = newd;
//                                                            int newf = newd;
//                                                            int newg = newd;
//                                                            int newh = newd;
//                                                            int newi = newd;
                                                            if (newd != d) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + newd + ": " + newd + ": " + newd + ": " + newd + ": " + newd + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, newd, newd, newd,newd,newd,newd,j, 0, 0));
                                                            }
                                                        } else if (h > newd && i <= newd) {
//                                                            int newe = newd;
//                                                            int newf = newd;
//                                                            int newg = newd;
//                                                            int newh = newd;
                                                            if (newd != d) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + newd + ": " + newd + ": " + newd + ": " + newd + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, newd, newd, newd,newd,newd,i,j, 0, 0));
                                                            }
                                                        } else if (g > newd && h <= newd) {
//                                                            int newe = newd;
//                                                            int newf = newd;
//                                                            int newg = newd;
                                                            if (newd != d) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + newd + ": " + newd + ": " + newd + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, newd, newd, newd,newd,h,i,j, 0, 0));
                                                            }
                                                        } else if (f > newd && g <= newd) {
//                                                            int newe = newd;
//                                                            int newf = newd;
                                                            if (newd != d) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + newd + ": " + newd + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, newd, newd, newd,g,h,i,j, 0, 0));
                                                            }
                                                        } else if (e > newd && f <= newd) {
//                                                            int newe = newd;
                                                            if (newd != d) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + newd + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, newd, newd, f,g,h,i,j, 0, 0));
                                                            }
                                                        } else {
                                                            if (newd != d) {
                                                                //System.out.println(a + ": " + b + ": " + c + ": " + newd + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, c, newd, e, f,g,h,i,j, 0, 0));
                                                            }
                                                        }
                                                    }
                                                    //column 3
                                                    for (int newc = c; newc >= 0; newc--) {
                                                        if (j > newc) {
//                                                            int newd = newc;
//                                                            int newe = newc;
//                                                            int newf = newc;
//                                                            int newg = newc;
//                                                            int newh = newc;
//                                                            int newi = newc;
//                                                            int newj = newc;
                                                            if (newc != c) {
                                                                //System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + newh + ": " + newi + ": " + newj);
                                                                ResultingBoards.add(new Boards(a, b, newc, newc, newc, newc,newc,newc,newc,newc, 0, 0));
                                                            }
                                                        } else if (i > newc && j <= newc) {
//                                                            int newd = newc;
//                                                            int newe = newc;
//                                                            int newf = newc;
//                                                            int newg = newc;
//                                                            int newh = newc;
//                                                            int newi = newc;
                                                            if (newc != c) {
                                                                //System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + newh + ": " + newi + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, newc, newc, newc, newc,newc,newc,newc,j, 0, 0));
                                                            }
                                                        } else if (h > newc && i <= newc) {
//                                                            int newd = newc;
//                                                            int newe = newc;
//                                                            int newf = newc;
//                                                            int newg = newc;
//                                                            int newh = newc;
                                                            if (newc != c) {
                                                                //System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + newh + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, newc, newc, newc, newc,newc,newc,i,j, 0, 0));
                                                            }
                                                        } else if (g > newc && h <= newc) {
//                                                            int newd = newc;
//                                                            int newe = newc;
//                                                            int newf = newc;
//                                                            int newg = newc;
                                                            if (newc != c) {
                                                                //System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, newc, newc, newc, newc,newc,h,i,j, 0, 0));
                                                            }
                                                        } else if (f > newc && g <= newc) {
//                                                            int newd = newc;
//                                                            int newe = newc;
//                                                            int newf = newc;
                                                            if (newc != c) {
                                                                //System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, newc, newc, newc, newc,g,h,i,j, 0, 0));
                                                            }
                                                        } else if (e > newc && f <= newc) {
//                                                            int newd = newc;
//                                                            int newe = newc;
                                                            if (newc != c) {
                                                                //System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + newe + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, newc, newc, newc, f,g,h,i,j, 0, 0));
                                                            }
                                                        }else if (d > newc && e <= newc) {
//                                                            int newd = newc;
                                                            if (newc != c) {
                                                                //System.out.println(a + ": " + b + ": " + newc + ": " + newd + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, newc, newc, e, f,g,h,i,j, 0, 0));
                                                            }
                                                        }else {
                                                            if (newc != c) {
                                                                //System.out.println(a + ": " + b + ": " + newc + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, b, newc, d, e, f,g,h,i,j, 0, 0));
                                                            }
                                                        }
                                                    }
                                                    //column 2
                                                    for (int newb = b; newb >= 0; newb--) {
                                                        if (j > newb) {
//                                                            int newc = newb;
//                                                            int newd = newb;
//                                                            int newe = newb;
//                                                            int newf = newb;
//                                                            int newg = newb;
//                                                            int newh = newb;
//                                                            int newi = newb;
//                                                            int newj = newb;
                                                            if (newb != b) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + newh + ": " + newi + ": " + newj);
                                                                ResultingBoards.add(new Boards(a, newb, newb, newb, newb, newb,newb,newb,newb,newb, 0, 0));
                                                            }
                                                        } else if (i > newb && j <= newb) {
//                                                            int newc = newb;
//                                                            int newd = newb;
//                                                            int newe = newb;
//                                                            int newf = newb;
//                                                            int newg = newb;
//                                                            int newh = newb;
//                                                            int newi = newb;
                                                            if (newb != b) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + newh + ": " + newi + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newb, newb, newb, newb, newb,newb,newb,newb,j, 0, 0));
                                                            }
                                                        } else if (h > newb && i <= newb) {
//                                                            int newc = newb;
//                                                            int newd = newb;
//                                                            int newe = newb;
//                                                            int newf = newb;
//                                                            int newg = newb;
//                                                            int newh = newb;
                                                            if (newb != b) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + newh + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newb, newb, newb, newb, newb,newb,newb,i,j, 0, 0));
                                                            }
                                                        } else if (g > newb && h <= newb) {
//                                                            int newc = newb;
//                                                            int newd = newb;
//                                                            int newe = newb;
//                                                            int newf = newb;
//                                                            int newg = newb;
                                                            if (newb != b) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newb, newb, newb, newb, newb,newb,h,i,j, 0, 0));
                                                            }
                                                        } else if (f > newb && g <= newb) {
//                                                            int newc = newb;
//                                                            int newd = newb;
//                                                            int newe = newb;
//                                                            int newf = newb;
                                                            if (newb != b) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newb, newb, newb, newb, newb,g,h,i,j, 0, 0));
                                                            }
                                                        } else if (e > newb && f <= newb) {
//                                                            int newc = newb;
//                                                            int newd = newb;
//                                                            int newe = newb;
                                                            if (newb != b) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newb, newb, newb, newb, f,g,h,i,j, 0, 0));
                                                            }
                                                        }else if (d > newb && e <= newb) {
//                                                            int newc = newb;
//                                                            int newd = newb;
                                                            if (newb != b) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newb, newb, newb, e, f,g,h,i,j, 0, 0));
                                                            }
                                                        }else if (c > newb && d <= newb) {
//                                                            int newc = newb;
                                                            if (newb != b) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newb, newb, d, e, f,g,h,i,j, 0, 0));
                                                            }
                                                        } else {
                                                            if (newb != b) {
                                                                //System.out.println(a + ": " + newb + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newb, c, d, e, f,g,h,i,j, 0, 0));
                                                            }
                                                        }
                                                    }
                                                    //column 1
                                                    for (int newa = a; newa > 0; newa--) {
                                                        if (j > newa) {
//                                                            int newb = newa;
//                                                            int newc = newa;
//                                                            int newd = newa;
//                                                            int newe = newa;
//                                                            int newf = newa;
//                                                            int newg = newa;
//                                                            int newh = newa;
//                                                            int newi = newa;
//                                                            int newj = newa;
                                                            if (newa != a) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + newh + ": " + newi + ": " + newj);
                                                                ResultingBoards.add(new Boards(a, newa, newa, newa, newa, newa,newa,newa,newa,newa, 0, 0));
                                                            }
                                                        } else if (i > newa && j <= newa) {
//                                                            int newb = newa;
//                                                            int newc = newa;
//                                                            int newd = newa;
//                                                            int newe = newa;
//                                                            int newf = newa;
//                                                            int newg = newa;
//                                                            int newh = newa;
//                                                            int newi = newa;
                                                            if (newa != a) {
                                                                //System.out.println(a + ": " + newa + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + newh + ": " + newi + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newa, newa, newa, newa, newa,newa,newa,newa,j, 0, 0));
                                                            }
                                                        } else if (h > newa && i <= newa) {
//                                                            int newb = newa;
//                                                            int newc = newa;
//                                                            int newd = newa;
//                                                            int newe = newa;
//                                                            int newf = newa;
//                                                            int newg = newa;
//                                                            int newh = newa;
                                                            if (newa != a) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + newh + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newa, newa, newa, newa, newa,newa,newa,i,j, 0, 0));
                                                            }
                                                        } else if (g > newa && h <= newa) {
//                                                            int newb = newa;
//                                                            int newc = newa;
//                                                            int newd = newa;
//                                                            int newe = newa;
//                                                            int newf = newa;
//                                                            int newg = newa;
                                                            if (newa != a) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + newg + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newa, newa, newa, newa, newa,newa,h,i,j, 0, 0));
                                                            }
                                                        } else if (f > newa && g <= newa) {
//                                                            int newb = newa;
//                                                            int newc = newa;
//                                                            int newd = newa;
//                                                            int newe = newa;
//                                                            int newf = newa;
                                                            if (newa != a) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + newf + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newa, newa, newa, newa, newa,g,h,i,j, 0, 0));
                                                            }
                                                        } else if (e > newa && f <= newa) {
//                                                            int newb = newa;
//                                                            int newc = newa;
//                                                            int newd = newa;
//                                                            int newe = newa;
                                                            if (newa != a) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + newe + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newa, newa, newa, newa, f,g,h,i,j, 0, 0));
                                                            }
                                                        }else if (d > newa && e <= newa) {
//                                                            int newb = newa;
//                                                            int newc = newa;
//                                                            int newd = newa;
                                                            if (newa != a) {
                                                                //System.out.println(a + ": " + newb + ": " + newc + ": " + newd + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(a, newa, newa, newa, e, f,g,h,i,j, 0, 0));
                                                            }
                                                        }else if (c > newa && d <= newa) {
//                                                            int newb = newa;
//                                                            int newc = newa;
                                                            if (newa != a) {
                                                                //System.out.println(newa + ": " + newb + ": " + newc + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(newa, newa, newa, d, e, f,g,h,i,j, 0, 0));
                                                            }
                                                        }
                                                        else if (c > newa && d <= newa) {
//                                                            int newb = newa;
                                                            if (newa != a) {
                                                                //System.out.println(newa + ": " + newb + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(newa, newa, c, d, e, f,g,h,i,j, 0, 0));
                                                            }
                                                        } else {
                                                            if (newa != a) {
                                                                //System.out.println(newa + ": " + b + ": " + c + ": " + d + ": " + e + ": " + f + ": " + g + ": " + h + ": " + i + ": " + j);
                                                                ResultingBoards.add(new Boards(newa, b, c, d, e, f,g,h,i,j, 0, 0));
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
                                                            if (board.aa == deathBoard.aa && board.bb == deathBoard.bb && board.cc == deathBoard.cc && board.dd == deathBoard.dd && board.ee == deathBoard.ee && board.ff == deathBoard.ff && board.gg == deathBoard.gg && board.hh == deathBoard.hh && board.ii == deathBoard.ii && board.jj == deathBoard.jj) {
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
                                                                } else if (g != board.gg) {
                                                                    bestMoveColumn = 6;
                                                                    bestMoveRow = board.gg;
                                                                } else if (h != board.hh) {
                                                                    bestMoveColumn = 7;
                                                                    bestMoveRow = board.hh;
                                                                } else if (i != board.ii) {
                                                                    bestMoveColumn = 8;
                                                                    bestMoveRow = board.ii;
                                                                } else if (j != board.jj) {
                                                                    bestMoveColumn = 9;
                                                                    bestMoveRow = board.jj;
                                                                }
                                                                LifeBoards.add(new Boards(a, b, c, d, e, f, g, h, i, j, bestMoveColumn, bestMoveRow));
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
                                                        DeathBoards.add(new Boards(a, b, c, d, e, f, g, h, i, j, 0, bestMoveRow));
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

        int[] thisBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for(int i=0; i< gameBoard.length;i++){
            for(int j=0;j<gameBoard[i].length; j++){
                System.out.println(gameBoard[i][j].isAlive);
                if(gameBoard[i][j].isAlive){
                    thisBoard[i]++;
                }
            }
        }
//        for (int i=0; i<4; i++){
//            System.out.println(Arrays.toString(thisBoard));
//        }

        for (Boards board : DeathBoards) {
            if (board.aa == thisBoard[0] && board.bb == thisBoard[1] && board.cc == thisBoard[2] && board.dd == thisBoard[3] && board.ee == thisBoard[4] && board.ff == thisBoard[5] && board.gg == thisBoard[6] && board.hh == thisBoard[7] && board.ii == thisBoard[8] && board.jj == thisBoard[9]) {
                //add move here and then add to life boards list
                column = board.bestMoveRow;
                row = board.bestMoveColumn;
            }
        }
        for (Boards board: LifeBoards){
            if (board.aa == thisBoard[0] && board.bb == thisBoard[1] && board.cc == thisBoard[2] && board.dd == thisBoard[3] && board.ee == thisBoard[4] && board.ff == thisBoard[5] && board.gg == thisBoard[6] && board.hh == thisBoard[7] && board.ii == thisBoard[8] && board.jj == thisBoard[9]) {
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
