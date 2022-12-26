import java.util.LinkedList;

public class j20221216_MyQueueClass {

    public LinkedList<String> myQueueFromClass = new LinkedList<>();

    public void enqueue(String element) {
        myQueueFromClass.add(element);
    }

    public String dequeue() {
        return myQueueFromClass.poll();
    }

    public String first() {
        return myQueueFromClass.peek();
    }

}