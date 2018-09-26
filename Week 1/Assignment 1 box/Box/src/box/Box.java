package box;
import java.util.Scanner;
/**
 *
 * @author Thomas
 */
public class Box {
    public static void main(String[] args) {
//Scanner
            Scanner SC = new Scanner(System.in);
            System.out.println("Give me a number, and ill give you a box of that width and height");
            int BoxS = SC.nextInt();
//Box stuff
            String Box = new String();
            boolean BoxTop = false;
//loop
            for(int i=0;i<BoxS;++i){
                //lid or not
                if(i==0 || i==BoxS-1){
                    BoxTop = true;
                }
                else{
                    BoxTop = false;
                }
                //lid
                if(BoxTop==true){
                    for(int n=0;n<BoxS;++n){
                        Box+="#";
                    }
                }
                //sides
                else{
                    for(int n=0;n<BoxS;++n){
                        if(n==0 || n==BoxS-1){
                            Box+=("#");
                        }
                        else{
                            Box+=(" ");
                        }
                    }
                }
                Box+=("\n");
            }
            System.out.println(Box);
            System.out.println("Heres your box!");
    }
}