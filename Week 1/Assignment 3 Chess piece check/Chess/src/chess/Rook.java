package chess;

/**
 *
 * @author Thoma
 */
public class Rook {
    int Row, Col;
    Rook(int r, int c){
        //set self values
        this.Row = r; this.Col = c;
    }
    int getRow(){
        return this.Row;
    }
    int getCol(){
        return this.Col;
    }
    char getSymbol(){
        return 'R';
    }
    boolean canMoveTo(int r, int c){
        //Can move up or down as long as in Col
        if((r>this.Row || r<this.Row) && c==this.Col)
            return true;
        //Can move left or right as long as in Row
        else if(r==this.Row && (c>this.Col || c<this.Col))
            return true;
        //cant move diagonally
        else
            return false;
    }
}
