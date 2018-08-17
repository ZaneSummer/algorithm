import java.util.LinkedList;
import java.util.Queue;

public class DoubleQueueStack {
    private Queue<Integer> data = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(Integer num) {
        data.add(num);
    }

    public Integer pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    public Integer peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap();
        return res;
    }

    public void swap() {
      Queue<Integer> temp=help;
      help=data;
      data=temp;
    }

    public static void main(String[] args) {
        DoubleQueueStack doubleQueueStack=new DoubleQueueStack();
        doubleQueueStack.push(1);
        doubleQueueStack.push(9);
        doubleQueueStack.push(5);


        Utils.print(doubleQueueStack.peek()+"");
        Utils.print(doubleQueueStack.pop()+"");
        doubleQueueStack.push(50);

        Utils.print(doubleQueueStack.pop()+"");
    }
}
