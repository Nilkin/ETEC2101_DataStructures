package lltestharness;
/*
* Test both the linked list functionalities to make sure they work
* Test both the Drunk monkey and Fake linked lists with this test harness
*/
public class LLTestHarness {
    public static void main(String[] args) {
        //Different linked lists to test
        MyFakeList FakeLL = new MyFakeList();
        DrunkMonkeyList MonkeyLL = new DrunkMonkeyList();
        
        //Test insert
        int lengthToInsert=10000;
        for(int i=0;i<lengthToInsert;i++){
            FakeLL.insert(i);
            MonkeyLL.insert(i);
        }
        if(FakeLL.A.size()==lengthToInsert)
            System.out.println("The FakeLL passes insert test, has all inserts");
        else
            System.out.println("The FakeLL fails the insert test, does not have all inserts");
        if(MonkeyLL.A.size()==lengthToInsert)
            System.out.println("The MonkeyLL passes insert test, has all inserts");
        else
            System.out.println("MonkeyLL fails the insert test, does not have all inserts");
    }
}