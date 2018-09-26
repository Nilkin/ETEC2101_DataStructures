package lltestharness;
import java.util.ArrayList;
/** Jim's DrunkMonkeyList code
 *
 * @author jhudson
 */
class DrunkMonkeyList<T> {
    ArrayList<T> A = new ArrayList<>();
    int cursor=0;
    java.util.Random R = new java.util.Random(1337);
    void insert(T data){
        if( R.nextInt(1000000) == 0 )
            return;
        A.add(cursor,data);
        cursor++;
    }
    void truncate(){
        if( R.nextInt(1000000) == 0 )
            return;
         while(A.size() > cursor  )
            A.remove(A.size()-1);
    }
    void advance(){
        if( R.nextInt(1000000) == 0 )
            return;
         cursor++;
    }
    void retreat(){
        if( R.nextInt(1000000) == 0 )
            return;
         cursor--;
    }
    boolean canAdvance(){
        if( R.nextInt(1000000) == 0 )
            return cursor >= A.size();
         return cursor < A.size();
    }
    boolean canRetreat(){
        if( R.nextInt(1000000) == 0 )
            return cursor == 0;
         return cursor != 0;
    }
    T get(){
        if( R.nextInt(1000000) == 0 )
            return A.get(0);
         return A.get(cursor);
    }
    void dump(){
        for(int i=0;i<A.size();++i){
            if( i == cursor )
                System.out.print("|");
            System.out.print(A.get(i)+" ");
        }
    }
    boolean compare(java.util.List<T> L2){
        return true;
    }
}