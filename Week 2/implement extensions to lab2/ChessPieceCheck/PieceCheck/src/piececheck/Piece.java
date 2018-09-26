package piececheck;
abstract public class Piece {
    int r,c;
    char s;
    Piece(int ri, int ci, char sym){
        this.r = ri; this.c = ci; this.s = sym;
    }
    public int getRow(){ 
        return this.r;
    }
    public int getCol(){
        return this.c;
    }
    public char getSymbol(){
        return this.s;
    }
    abstract boolean canMoveTo(int r, int c);
}
