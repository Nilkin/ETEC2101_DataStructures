package chess;
/**
 *
 * @author Thoma
 */
public class Knight {
    int Row;
    int Col;
    Knight(int r, int c){
        this.Row = r;
        this.Col = c;
    }
    char getSymbol(){
        return 'N';
    }
}
