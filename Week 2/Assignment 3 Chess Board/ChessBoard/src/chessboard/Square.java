package chessboard;

import javax.swing.JButton;

public class Square extends JButton {
    int x,y;
    Square(int x, int y){
        this.x=x; this.y=y;
    }
    public int positionX(){
        return this.x;
    }
    public int positionY(){
        return this.y;
    }
}