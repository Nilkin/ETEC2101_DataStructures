package stacks.ques;
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Thoma
 */
public class StacksQues {
    public static void main(String[] args){
        //Set the file Chooser
       JFileChooser Chooser =  new JFileChooser();
       FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Filter", ".txt",".java");
       Chooser.setFileFilter(txtFilter);
       int returnVal = Chooser.showOpenDialog(Chooser);
       
       //fileStuff
       ArrayList LinePeek;
       String FileName;
       FileReader Reader;
       String line;
       Stack LineChecker = new Stack<>();
       int backSlashCount = 0;
       int lineNum = 0;
       
        //Did you open a file or not
        switch (returnVal) {
        //you chose to cancel opening a file
            case JFileChooser.APPROVE_OPTION:
                System.out.println("reading in file: "+Chooser.getSelectedFile().getName());//tells you what file your reading in
                FileName = Chooser.getSelectedFile().getPath();
                try{
                    Reader = new FileReader(FileName);
                    BufferedReader BuffyReader = new BufferedReader(Reader);
                    
                    //read through the text
                    while((line=BuffyReader.readLine())!=null){
                        lineNum++;
                        backSlashCount=0;//counts to see if a comment was made or formed on the line
                        for(int i=0;i<line.length();i++){
                            char item = line.charAt(i);
                            if(item=='{'){
                                LinePeek = new ArrayList();
                                LinePeek.add(item);
                                LinePeek.add(lineNum);
                                LineChecker.push(LinePeek);
                            }
                            if(item=='}'){
                                if(LineChecker.empty()==false)
                                    LineChecker.pop();
                                else{
                                    LinePeek = new ArrayList();
                                    LinePeek.add(item);
                                    LinePeek.add(lineNum);
                                    LineChecker.push(LinePeek);
                                }
                            }
                            if(item=='/')
                                backSlashCount++;
                            if(backSlashCount==2)//should exit the for loop parsing through the line, the line is a comment now
                                i=line.length();
                        }
                    }
                }
                catch(FileNotFoundException ex){
                    System.out.println("Could not open or find "+FileName+
                            "\nCheck your file extension name your trying to open");
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }   break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("You chose not to open a file. Goodbye");
                System.exit(0);//quite program
            default:
                //an error happened with opening your file
                System.out.println("A error with opening the file has occured.");
                System.exit(0);//quite program
        }      
       
       //Check to see if you popped everything
       if(LineChecker.empty()==false){
           System.out.println("Line Errors at: "+LineChecker);
       }
       else{
           System.out.println("No errors");
       }
       System.exit(0);
    }
    
}
