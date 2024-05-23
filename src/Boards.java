public class Boards {

    public int a;
    public int b;
    public int c;

    public Boards(int pA, int pB, int pC){
        a = pA;
        b = pB;
        c = pC;
    }

    public void printBoard(){
        System.out.println(a + ": " + b + ": " + c);
    }

}
