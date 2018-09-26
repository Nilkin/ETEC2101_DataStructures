package chessgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;


public class ChessGame {
    public static void main(String[] args) {
        //set Window
        JFrame win = new JFrame("ChessBoard");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(800,600);
        win.getContentPane().setLayout(new BorderLayout());
        //set TopPanel
        JPanel topPanel = new JPanel();
        win.getContentPane().add(topPanel,BorderLayout.NORTH);
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
        //set CenterPanel
        JPanel centerPanel = new JPanel();
        win.getContentPane().add(centerPanel,BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(8,8));
        //set rightPanel
        JPanel rightPanel = new JPanel();
        win.getContentPane().add(rightPanel,BorderLayout.EAST);
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
        
        //Side Labels, and Time placement Labels
        JLabel Black = new JLabel("Black"); JLabel White = new JLabel("White");
        JLabel BlTime = new JLabel("00:05:00"); JLabel WhTime = new JLabel("00:05:00");
        //black label and time label
        rightPanel.add(Black); rightPanel.add(BlTime);
        //white label and time label
        rightPanel.add(White); rightPanel.add(WhTime);
        
        //make board and place it on JPanel
        ChessBoard GameBoard = new ChessBoard();
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++)
                centerPanel.add(GameBoard.Board[row][col]);
        }

        JMenuBar mbar = new JMenuBar();
        win.setJMenuBar(mbar);
        JMenu file = new JMenu("File");
        mbar.add(file);
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener((ActionEvent ev) -> {
            System.exit(0);
        });
        file.add(quit);
        win.setVisible(true);
    }
    
}
