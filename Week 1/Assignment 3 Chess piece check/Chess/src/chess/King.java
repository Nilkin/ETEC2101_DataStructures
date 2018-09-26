package chess;
public class King {
    int Row, Col;
    King(int r, int c){
        //set self values
        this.Row=r; this.Col=c;
    }
    int getRow(){
        return this.Row;
    }
    int getCol(){
        return this.Col;
    }
    char getSymbol(){
        return 'K';
    }
    boolean canMoveTo(int r, int c){
        //is one square up or down
        if((r==(this.Row-=1) && c==this.Col) || (r==(this.Row+=1) && c==this.Col))
            return true;
        //is one square to the left or right
        else if((c==(this.Col-=1) && r==this.Row) || (c==(this.Col+=1) && r==this.Row))
            return true;
        //is diagonally one square up
        else if((r==(this.Row+=1) && c==(this.Col+=1)) || (r==(this.Row-=1) && c==(this.Col+=1)))
            return true;
        //is diagonally one square down
        else if((r==(this.Row+=1) && c==(this.Col-=1)) || (r==(this.Row-=1) && c==(this.Col-=1)))
            return true;
        //is not one square next to piece
        else
            return false;
    }
}
