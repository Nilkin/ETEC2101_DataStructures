package checkerboard.box;

import java.util.Scanner;

/**
 *
 * @author Thoma
 */
public class CheckerboardBox {
    public static void main(String[] args) {
        //Scanner
            Scanner SC = new Scanner(System.in);
            System.out.println("Give me a number, and ill give you a checkered box of that width and height");
            int BoxS = SC.nextInt();
//Box stuff
            String Box = new String();
            boolean BoxTop = false;
            boolean Psign = true;
            int signChng = 1;
            int swap = 2;
//loop
            for(int i=0;i<(BoxS*2)+2;++i){
                //lid or not
                if(i==0 || i==(BoxS*2)+1){
                    BoxTop=true;
                }
                else{
                    BoxTop=false;
                }
                if(swap==0){
                    signChng=0;
                }
                else if(swap==2){
                    signChng=1;
                }
                if (BoxTop==true){
                    Box+=" ";
                    for(int n=0;n<BoxS*2;n++){
                        Box+="-";
                    }
                    Box+=" ";
                }
                else if(signChng==1 && BoxTop==false){
                    Box+="|";
                    for(int n=0;n<BoxS;n++){
                        if(Psign==true){
                            Box+="##";
                            Psign=false;
                        }
                        else if(Psign==false){
                            Box+="..";
                            Psign=true;
                        }
                    }
                    swap-=1;
                    Box+="|";
                }
                else if(signChng==0 & BoxTop==false){
                    Box+="|";
                    for(int n=0;n<BoxS;n++){
                        if(Psign==true){
                            Box+="..";
                            Psign=false;
                        }
                        else if(Psign==false){
                            Box+="##";
                            Psign=true;
                        }
                    }
                    swap+=1;
                    Box+="|";
                }
                Box+="\n";
            }
            System.out.println(Box);
            System.out.println("Heres your box!");
    }
    
}
