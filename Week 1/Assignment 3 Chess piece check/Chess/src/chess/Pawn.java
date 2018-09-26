package chess;
/**
 *
 * @author Thoma
 */
public class Pawn {
    int Row;
    int Col;
    Pawn(int r, int c){
        this.Row = r;
        this.Col = c;
    }
    int getRow(){
        return this.Row;
    }
    int getCol(){
        return this.Col;
    }
    char getSymbol(){
        return 'P';
    }
    public boolean canMoveTo(int r, int c){
        if(r>this.Row && c==this.Col)
            return true ;
        else
            return false;
    }
}
