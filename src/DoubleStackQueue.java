import java.util.Stack;

public class DoubleStackQueue {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> help = new Stack<>();

    public void add(Integer num) {
        data.push(num);
    }

    public Integer peek() {
        if (data.empty()) {
            throw new RuntimeException("queue is empty");
        }
        while (data.size() != 1) {
            help.push(data.pop());
        }
        int res = data.pop();
        help.push(res);
        swap();
        return res;
    }

    public Integer poll() {
        if (data.empty()) {
            throw new RuntimeException("queue is empty");
        }
        while (data.size() != 1) {
            help.push(data.pop());
        }
        int res = data.pop();
        swap();
        return res;
    }

    public void swap() {
        while (!help.empty()){
            data.push(help.pop());
        }
    }

    public static void main(String[] args) {
        DoubleStackQueue doubleStackQueue=new DoubleStackQueue();
        doubleStackQueue.add(1);
        doubleStackQueue.add(9);
        doubleStackQueue.add(5);
        doubleStackQueue.add(44);


        CommonUtils.print(doubleStackQueue.poll()+"");
        CommonUtils.print(doubleStackQueue.poll()+"");
        CommonUtils.print(doubleStackQueue.poll()+"");
        CommonUtils.print(doubleStackQueue.poll()+"");
    }
}
