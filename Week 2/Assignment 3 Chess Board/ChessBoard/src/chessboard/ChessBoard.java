package chessboard;
    import java.awt.BorderLayout;
    import java.awt.Color;
    import java.awt.GridLayout;
    import java.awt.event.ActionEvent;
    import javax.swing.BoxLayout;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JMenu;
    import javax.swing.JMenuBar;
    import javax.swing.JMenuItem;
    import javax.swing.JPanel;
public class ChessBoard {
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
        
        JLabel Black = new JLabel("Black");
        JLabel BlTime = new JLabel("00:05:00");
        JLabel WhTime = new JLabel("00:05:00");
        JLabel White = new JLabel("White");
        
        
        //black label and time label
        rightPanel.add(Black);
        rightPanel.add(BlTime);
        
        //white label and time label
        rightPanel.add(White);
        rightPanel.add(WhTime);
        
/*alternates the pattern between white and black per row for GridLayout
depending on which box goes first based off of the swap number
it creates a box and adds it to the centerPanel setting its background color and position
then it alternates to the next box color and so on per loop cylce
cycle time O(n^2)*/
        int swap = 0;
        for(int i=0;i<8;i++){
            if(swap==0){
                swap=1;
            }
            else if(swap==1){
                swap=0;
            }
            for(int n=0;n<8;n++){
                if(swap==0){
                    Square sq = new Square(i,n);
                    centerPanel.add(sq).setBackground(Color.BLACK);    
                    sq.addActionListener((ev)->{
                        Square c = (Square) ev.getSource();
                        System.out.println("Color: "+c.getText());
                        System.out.println("position: " + c.positionX() + "," + c.positionY());
                    });
                    swap+=1;
                }
                else if(swap==1){
                    Square sq = new Square(i,n);
                    centerPanel.add(sq).setBackground(Color.WHITE);
                    sq.addActionListener((ev)->{
                        Square c = (Square) ev.getSource();
                        System.out.println("Color: "+c.getText());
                        System.out.println("position: " + c.positionX() + "," + c.positionY());
                    });
                    swap-=1;
                }
            }  
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
