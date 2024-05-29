public class Boards {

    public int x;
    public int y;
    public int z;

    public Boards(int pX, int pY, int pZ){
        x = pX;
        y = pY;
        z = pZ;
    }

    public void printBoard(){
        System.out.println(x + ": " + y + ": " + z);
    }

}
