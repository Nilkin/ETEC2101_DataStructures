package piececheck;
    import java.util.Scanner;
public class PieceCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What kind of piece (K,Q,B,N,R,P)? ");
        String ptype = in.nextLine();
        System.out.println("What row?");
        int row = in.nextInt();
        System.out.println("What column?");
        int col = in.nextInt();
        Piece p;
        if( ptype.equals("K"))
            p = new King(row,col,'K');
        else if( ptype.equals("N") )
            p = new Knight(row,col,'N');
        else if( ptype.equals("R") )
            p = new Rook(row,col,'R');
        else if( ptype.equals("P") )
            p = new Pawn(row,col,'P');
        else if(ptype.equals("B"))
            p = new Bishop(row,col,'B');
        else if(ptype.equals("Q"))
            p = new Queen(row,col,'Q');
        else{
            System.out.println("Bad type");
            return;
        }
        
        System.out.println("Can move to: ");
        for(int r=0;r<=8;++r){
            for(int c=0;c<=8;++c){
                if( p.canMoveTo(r,c) )
                    System.out.print("("+r+","+c+") ");
            }
        }
        System.out.println();
    }
    
}
