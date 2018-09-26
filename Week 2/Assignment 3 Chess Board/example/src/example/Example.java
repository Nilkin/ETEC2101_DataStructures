package example;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class Example {
    public static void main(String[] args) {
        JFrame win = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b = new JButton("Greet me!");
        //win.setLayout(new GridLayout(numrows, numcols);
        //win.setLayout(new BoxLayout(win.getContentPane(), BoxLayout.X_AXIS));
        win.setLayout(new BorderLayout());
        
        JLabel statusbar = new JLabel("Whatever");
        win.add(statusbar,BorderLayout.SOUTH);
        
        JPanel panny = new JPanel();
        win.add(panny,BorderLayout.NORTH);
        panny.setLayout(new BoxLayout(panny,BoxLayout.X_AXIS));

        JTextArea text = new JTextArea();
        JScrollPane jsp = new JScrollPane(text);
        win.add(jsp,BorderLayout.CENTER);
        
        
        
        
        JButton new_ = new JButton("New");
        panny.add(new_);
        new_.addActionListener( (ev) -> {
            JButton src = (JButton) ev.getSource();
            System.out.println("Event happened on: "+src.getText());
        });
        JButton open = new JButton("Open");
        panny.add(open);
        JButton save = new JButton("Save");
        panny.add(save);
        save.addActionListener((ev)->{
            try{
                JFileChooser jf = new JFileChooser();
                if( jf.showSaveDialog(win) != JFileChooser.APPROVE_OPTION )
                    return;
                PrintWriter pw = new PrintWriter(jf.getSelectedFile());
                pw.print(text.getText());
                pw.close();
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(win,"Get a bigger disk!", 
                        "Save failed!", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        for(int i=0;i<5;++i){
            MyButton magic = new MyButton("MAGIC"+i, 42+i);
            panny.add(magic);        
            magic.addActionListener((ev)->{
                MyButton c = (MyButton) ev.getSource();
                System.out.println("Source: "+c.getText());
                System.out.println("Quux was: " + c.c);
            });
        }
        
        JMenuBar mbar = new JMenuBar();
        win.setJMenuBar(mbar);
        JMenu filemenu = new JMenu("File");
        mbar.add(filemenu);
        JMenuItem itemnew = new JMenuItem("New");
        filemenu.add(itemnew);
        itemnew.addActionListener( (ev) -> {
            text.setText("");
        });
        JMenuItem itemopen = new JMenuItem("Open");
        filemenu.add(itemopen);
        JMenuItem itemsave = new JMenuItem("Save");
        filemenu.add(itemsave);
        
        
        win.setSize(500,200);
        win.setVisible(true);
    }
}