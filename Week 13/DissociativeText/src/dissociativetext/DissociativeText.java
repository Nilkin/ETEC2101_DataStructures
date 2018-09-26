package dissociativetext;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JFileChooser;

public class DissociativeText {
    public static void main(String[] args) {
        JFileChooser Chooser = new JFileChooser();
        int ChooserValue = Chooser.showOpenDialog(Chooser);
        Chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        //FileStuff
        TreeMap<String,ArrayList> wordList = new TreeMap();
        char word=' ';
        String WordKey;
        File DirectoryPath;
        String FilePath;
        String line; //line in file
        File[] FilesInDirectory;
        FileReader Reader;
        BufferedReader BuffyReader;
        ArrayList WordSet;

        switch(ChooserValue){
            case(JFileChooser.APPROVE_OPTION):
                System.out.println("You chose to open the file: "+Chooser.getSelectedFile().getName());
                DirectoryPath = new File(Chooser.getCurrentDirectory().getPath()); //The Directory path
                FilesInDirectory = DirectoryPath.listFiles(); //add all the files in the selected Directory to a list
                try{
                    for(int i=0;i<FilesInDirectory.length;i++){
                        FilePath = FilesInDirectory[i].getPath();
                        Reader = new FileReader(FilePath);
                        BuffyReader = new BufferedReader(Reader);
                        while((line=BuffyReader.readLine())!=null){
                            for(int c=0;c<line.length();c++){
                                WordSet = new ArrayList();
                                System.out.println(line);
                                if(line.charAt(c)==' '){
                                    if(wordList.containsKey(String.valueOf(word))){
                                        WordKey = String.valueOf(word);
                                        wordList.lastEntry().getValue().add(WordKey);
                                    }
                                    else{
                                        WordKey = String.valueOf(word);
                                        wordList.put(WordKey, WordSet);
                                    }
                                    word=line.charAt(c);
                                }
                                if(word==' ')
                                    word=line.charAt(c);
                                else
                                    word+=line.charAt(c);
                            }
                            //System.out.println(wordList);
                        }
                    }
                }
                catch(FileNotFoundException ex){
                    System.out.println("Could not open or find "+DirectoryPath+
                            "\nCheck your file extension name your trying to open");
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }   break;
                
            case(JFileChooser.CANCEL_OPTION):
                System.out.println("You chose not to open a file, goodbye!");
                System.exit(0); //exit the program
            default:
                System.out.println("An exceptional error has occured with opening your file /n"
                        + "Check the file you are opening.");
                System.exit(0); //exit the program
        }
        //System.out.println(wordList);
    }
    
}
