package lltestharness;
import java.util.ArrayList;
/** Jim's FakeLinkedList
 *
 * @author jhudson
 */
class MyFakeList<T> {
    ArrayList<T> A = new ArrayList<>();
    int cursor=0;
    void insert(T data){
        A.add(cursor,data);
        cursor++;
    }
    void truncate(){
        while(A.size() > cursor  )
            A.remove(A.size()-1);
    }
    void advance(){
        cursor++;
    }
    void retreat(){
        cursor--;
    }
    boolean canAdvance(){
        return cursor < A.size();
    }
    boolean canRetreat(){
        return cursor != 0;
    }
    T get(){
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
        int i=0;
        for(T item : L2 ){
            if( i == A.size() ){
                return false;
            }
            if( !item.equals(A.get(i))){
                return false;
            }
            i++;
        }
        if( i != A.size() ){
            return false;
        }
        return true;
    }
}